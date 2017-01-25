package org.salesforce.util;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.sforce.soap.metadata.AsyncResult;
import com.sforce.soap.metadata.CodeCoverageWarning;
import com.sforce.soap.metadata.DeployDetails;
import com.sforce.soap.metadata.DeployMessage;
import com.sforce.soap.metadata.DeployOptions;
import com.sforce.soap.metadata.DeployResult;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.soap.metadata.RunTestFailure;
import com.sforce.soap.metadata.RunTestsResult;

/**
 * Sample that logs in and shows a menu of retrieve and deploy metadata options.
 */
public class FileBasedDeploy {

	private MetadataConnection metadataConnection;

	private static final String ZIP_FILE = "components.zip";

	// manifest file that controls which components get retrieved 
	private static final String MANIFEST_FILE = "package.xml";

	private static final double API_VERSION = 33.0;

	// one second in milliseconds 
	private static final long ONE_SECOND = 1000;

	// maximum number of attempts to deploy the zip file 
	private static final int MAX_NUM_POLL_REQUESTS = 50;

	private BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) throws Exception {
		FileBasedDeploy fbDeploy = new FileBasedDeploy();
		//fbDeploy.deploy();
	}

	public FileBasedDeploy() {
	}

	public void deploy(SFTargetoAuthHandle sfHandle) throws Exception {
		this.metadataConnection = sfHandle.getMetadaConnection();
		deployZip();
	}

	public void deploy(MetadataConnection metadataConnection) throws Exception {
		this.metadataConnection = metadataConnection;
		deployZip();
	}

	private void deployZip() throws Exception {
		byte zipBytes[] = readZipFile();
		DeployOptions deployOptions = new DeployOptions();
		deployOptions.setPerformRetrieve(false);
		deployOptions.setRollbackOnError(true);
		AsyncResult asyncResult = metadataConnection.deploy(zipBytes,
				deployOptions);
		DeployResult result = waitForDeployCompletion(asyncResult.getId());
		if (!result.isSuccess()) {
			printErrors(result, "Final list of failures:\n");
			throw new Exception("The files were not successfully deployed");
		}
		System.out.println("The file " + ZIP_FILE
				+ " was successfully deployed\n");
	}

	/*
	 * Read the zip file contents into a byte array.
	 */private byte[] readZipFile() throws Exception {
		byte[] result = null;
		// We assume here that you have a deploy.zip file. // See the retrieve
		// sample for how to retrieve a zip file.
		File zipFile = new File(ZIP_FILE);
		if (!zipFile.exists() || !zipFile.isFile()) {
			throw new Exception(
					"Cannot find the zip file for deploy() on path:"
							+ zipFile.getAbsolutePath());
		}

		FileInputStream fileInputStream = new FileInputStream(zipFile);
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = 0;
			while (-1 != (bytesRead = fileInputStream.read(buffer))) {
				bos.write(buffer, 0, bytesRead);
			}

			result = bos.toByteArray();
		} finally {
			fileInputStream.close();
		}
		return result;
	}

	/*
	 * Print out any errors, if any, related to the deploy.
	 * 
	 * @param result - DeployResult
	 */private void printErrors(DeployResult result, String messageHeader) {
		DeployDetails details = result.getDetails();
		StringBuilder stringBuilder = new StringBuilder();
		if (details != null) {
			DeployMessage[] componentFailures = details.getComponentFailures();
			for (DeployMessage failure : componentFailures) {
				String loc = "(" + failure.getLineNumber() + ", "
						+ failure.getColumnNumber();
				if (loc.length() == 0
						&& !failure.getFileName().equals(failure.getFullName())) {
					loc = "(" + failure.getFullName() + ")";
				}
				stringBuilder.append(
						failure.getFileName() + loc + ":"
								+ failure.getProblem()).append('\n');
			}
			RunTestsResult rtr = details.getRunTestResult();
			if (rtr.getFailures() != null) {
				for (RunTestFailure failure : rtr.getFailures()) {
					String n = (failure.getNamespace() == null ? "" : (failure
							.getNamespace() + ".")) + failure.getName();
					stringBuilder.append("Test failure, method: " + n + "."
							+ failure.getMethodName() + " -- "
							+ failure.getMessage() + " stack "
							+ failure.getStackTrace() + "\n\n");
				}
			}
			if (rtr.getCodeCoverageWarnings() != null) {
				for (CodeCoverageWarning ccw : rtr.getCodeCoverageWarnings()) {
					stringBuilder.append("Code coverage issue");
					if (ccw.getName() != null) {
						String n = (ccw.getNamespace() == null ? "" : (ccw
								.getNamespace() + ".")) + ccw.getName();
						stringBuilder.append(", class: " + n);
					}
					stringBuilder.append(" -- " + ccw.getMessage() + "\n");
				}
			}
		}
		if (stringBuilder.length() > 0) {
			stringBuilder.insert(0, messageHeader);
			System.out.println(stringBuilder.toString());
		}
	}


	private DeployResult waitForDeployCompletion(String asyncResultId)
			throws Exception {
		int poll = 0;
		long waitTimeMilliSecs = ONE_SECOND;
		DeployResult deployResult;
		boolean fetchDetails;
		do {
			Thread.sleep(waitTimeMilliSecs);
			// double the wait time for the next iteration

			waitTimeMilliSecs *= 2;
			if (poll++ > MAX_NUM_POLL_REQUESTS) {
				throw new Exception(
						"Request timed out. If this is a large set of metadata components, "
								+ "ensure that MAX_NUM_POLL_REQUESTS is sufficient.");
			}
			// Fetch in-progress details once for every 3 polls
			fetchDetails = (poll % 3 == 0);

			deployResult = metadataConnection.checkDeployStatus(asyncResultId,
					fetchDetails);
			System.out.println("Status is: " + deployResult.getStatus());
			if (!deployResult.isDone() && fetchDetails) {
				printErrors(deployResult,
						"Failures for deployment in progress:\n");
			}
		} while (!deployResult.isDone());

		if (!deployResult.isSuccess()
				&& deployResult.getErrorStatusCode() != null) {
			throw new Exception(deployResult.getErrorStatusCode() + " msg: "
					+ deployResult.getErrorMessage());
		}

		if (!fetchDetails) {
			// Get the final result with details if we didn't do it in the last
			// attempt.
			deployResult = metadataConnection.checkDeployStatus(asyncResultId,
					true);
		}

		return deployResult;
	}
}