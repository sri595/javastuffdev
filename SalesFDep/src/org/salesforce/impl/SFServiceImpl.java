package org.salesforce.impl;

import org.salesforce.util.Cache;
import org.salesforce.util.FileBasedDeploy;
import org.salesforce.util.FileBasedRetrieve;
import org.salesforce.util.SFSourceoAuthHandle;
import org.salesforce.util.SFTargetoAuthHandle;
import org.salesforce.util.SFoAuthHandle;
import org.salesforce.util.XMLUtil;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.DeployMetadata__c;
import com.sforce.soap.metadata.MetadataConnection;

public class SFServiceImpl {

	public SFServiceImpl() {
		super();
	}

	public static void main(String[] args) {
		SFServiceImpl sfi = new SFServiceImpl();
		// 00Dj0000001tsUf -
		// 00Dj0000001tsUf!AR8AQCo6TivJg3GBwlKYZa5v06ydzAb3wtgNhpQV3f.Xk6GhobaIv0Q41KRPMfag7TiCoVwvfNfL3SRkBR7vYOqMhpWCjQPf
		// 00Dj00000029B59 -
		// 00Dj00000029B59!AR8AQLUYUeNO7_jrGx2MdB._seVMl9JVWkhjv6g_K7h9Rh1lHQS_ClFF4k0INY1MGaXD2qxvfgrY_kiHP0AzcFFI2dBPt1yO
		Cache.add(
				"00Dj0000001tsUf",
				"00Dj0000001tsUf!AR8AQIOOrgygaM3hXT0_Mdz9SFOo.u9Mar6uJ7kMB0KWXvmcA_ZknevPfeyPK8H0gFIrafTdoma6o9dnOGsTkF7HDOmmnrkW");
		Cache.add(
				"00Dj00000029B59",
				"00Dj00000029B59!AR8AQN0wjhAf9pSBlQvOkJsAukoZfxTV1jF86OHybGysyRUFTzsj8_eFnhChlt_GHYUPPBZz3zFzLw9i2Ud5NAlI5sO5JtVy");
		sfi.deploy("00Dj00000029B59", "00Dj0000001tsUf", "a0Yj0000002Kz7A");
	}

	/**
	 * query's custom object
	 * 
	 * @param customObjectName
	 */
	private DeployMetadata__c queryObject(String orgId, SFoAuthHandle sfHandle) {
		com.sforce.soap.enterprise.sobject.DeployMetadata__c retObj = null;
		System.out.println("Querying ../////.");

		try {
			QueryResult queryResults = sfHandle
					.getEnterpriseConnection()
					.query("SELECT Id, Name__c, OrganizationId__c, Type__c FROM DeployMetadata__c"
							+ " where OrganizationId__c='" + orgId + "'");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					retObj = (com.sforce.soap.enterprise.sobject.DeployMetadata__c) queryResults
							.getRecords()[i];
					System.out.println(" - Name: " + retObj.getName__c());
					System.out.println(" - Type: " + retObj.getType__c());
					System.out.println(" - Org Id: "
							+ retObj.getOrganizationId__c());
					System.out.println(" - metadata log: " + retObj.getName());
					System.out.println(" - Id: " + retObj.getId());
					System.out.println(" --------------: ");
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retObj;
	}

	private DeployMetadata__c query(SFoAuthHandle sfHandle) {
		com.sforce.soap.enterprise.sobject.DeployMetadata__c retObj = null;
		System.out.println("Querying ../////.");

		try {
			QueryResult queryResults = sfHandle
					.getEnterpriseConnection()
					.query("SELECT Id, Name__c, OrganizationId__c, Type__c FROM DeployMetadata__c"
							+ " where OrganizationId__c='" + sfHandle.getOrgId() + "'");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					retObj = (com.sforce.soap.enterprise.sobject.DeployMetadata__c) queryResults
							.getRecords()[i];
					System.out.println(" - Name: " + retObj.getName__c());
					System.out.println(" - Type: " + retObj.getType__c());
					System.out.println(" - Org Id: "
							+ retObj.getOrganizationId__c());
					System.out.println(" - metadata log: " + retObj.getName());
					System.out.println(" - Id: " + retObj.getId());
					System.out
							.println(" - Id_c: " + retObj.getMetadataLog__c());
					System.out
							.println(" - Id_r: " + retObj.getMetadataLog__r());
					System.out.println(" --------------: ");
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retObj;
	}

	public int deploy(String sOrgId, String tOrgId, String metadataLogId) {
		int retVal = 0;
		if (sOrgId != null && tOrgId != null && metadataLogId != null) {
			SFoAuthHandle basesfHandle = new SFoAuthHandle(tOrgId, (String) Cache
					.getMap().get(tOrgId));
			SFSourceoAuthHandle ssfHandle = new SFSourceoAuthHandle(sOrgId, (String) Cache
					.getMap().get(sOrgId));
			SFTargetoAuthHandle tsfHandle = new SFTargetoAuthHandle(tOrgId, (String) Cache
					.getMap().get(tOrgId));

			try {
				// get the Deployment list of objects from SalesForce.
				SFMetadataLogImpl isfMetadataLog = new SFMetadataLogImpl();
				String action = isfMetadataLog.getActionToken(metadataLogId,
						basesfHandle);
				if (action != null) {
					if (action.equals("Retrieve")) {
						System.out.println("Retrieve------");
						retVal = runRetrieve(ssfHandle, tsfHandle, basesfHandle);
					} else if (action.equals("Deploy")) {
						System.out.println("Deploy------");
						retVal = runDeploy(ssfHandle, tsfHandle, basesfHandle);
					}
					if (retVal == 1) {
						isfMetadataLog.update(metadataLogId, basesfHandle);
					}
				} else {
					retVal = -1;
				}
				// Update MetadataLog status to Completed
			} catch (Exception e) {
				System.out.println("EXP-------");
				e.printStackTrace();
			}
		}
		return retVal;
	}

	private int runRetrieve(SFSourceoAuthHandle ssfHandle, SFTargetoAuthHandle tsfHandle, SFoAuthHandle basesfHandle) {
		System.out.println("retirve------"+Thread.currentThread().getContextClassLoader().toString());

		String[] deployObjArr = getRetrievObjectArr(ssfHandle);
		// deploy object into target Env
		
		deployObjToTargetOrg(deployObjArr, ssfHandle, tsfHandle);

		// insert the objects into MetdataDesctiption__c
		SFMetadaDescriptionImpl isfMetadataDescription = new SFMetadaDescriptionImpl();
		int retval = 0;

		retval = isfMetadataDescription.insertSFObjects(deployObjArr, basesfHandle);

		return retval;
	}

	private String[] getRetrievObjectArr(SFSourceoAuthHandle sfHandle) {
		int arrSize = 1;
		String[] deployObjArr = new String[arrSize];
		for (int i = 0; i < arrSize; i++) {
			deployObjArr[i] = new String();
		}
		try {
			if (sfHandle.getEnterpriseConnection() != null) {
				// get the global list of objects from SalesForce.
				SFObjectsImpl isfObj = new SFObjectsImpl();
				String[] globalObjList = isfObj
						.listAllSFGlobalObjects(sfHandle);

				for (int i = 0; i < globalObjList.length; i++) {
					if (globalObjList[i].equals("MyTestObject2__c")) {
						deployObjArr[0] = "MyTestObject2__c";
						System.out.println("retrieving object Name - "
								+ deployObjArr[0]);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("EXP-------");
			e.printStackTrace();
		}
		return deployObjArr;
	}

	private int runDeploy(SFSourceoAuthHandle ssfHandle, SFTargetoAuthHandle tsfHandle, SFoAuthHandle basesfHandle) {
		// get the to be deployed object from DeployMetadata__c
		DeployMetadata__c deployMDObj = query(basesfHandle);
		String[] deployMDObjArr = new String[1];
		deployMDObjArr[0] = deployMDObj.getName__c();
		System.out.println("--------" + deployMDObj.getName__c());
		// deploy object into target Env
		int retVal = deployObjToTargetOrg(deployMDObjArr, ssfHandle, tsfHandle);

		return retVal;
	}
	
	private int deployObjToTargetOrg(String[] metadataObjectNames,
			MetadataConnection sMetadataConnection, MetadataConnection tMetadataConnection) {
		int retVal = 1;
		XMLUtil.createDeployXMLFile(metadataObjectNames);
		FileBasedRetrieve retrieveObjectsFromSource = new FileBasedRetrieve();
		System.out.println("Cu Thread : "+Thread.currentThread().getContextClassLoader().toString());
		try {
			retrieveObjectsFromSource.retrieveZip(sMetadataConnection);
		} catch (Exception e) {
			e.printStackTrace();
			retVal = -1;
		}
		FileBasedDeploy deployObjectsToTarget = new FileBasedDeploy();
		try {
			deployObjectsToTarget.deploy(tMetadataConnection);
		} catch (Exception e) {
			e.printStackTrace();
			retVal = -1;
		}
		return retVal;
	}

	private int deployObjToTargetOrg(String[] metadataObjectNames,
			SFSourceoAuthHandle sfHandle, SFTargetoAuthHandle tsfHandle) {
		int retVal = 1;
		XMLUtil.createDeployXMLFile(metadataObjectNames);
		FileBasedRetrieve retrieveObjectsFromSource = new FileBasedRetrieve();
		System.out.println("Cu Thread : "+Thread.currentThread().getContextClassLoader().toString());
		try {
			retrieveObjectsFromSource.retrieveZip(sfHandle);
		} catch (Exception e) {
			e.printStackTrace();
			retVal = -1;
		}
		FileBasedDeploy deployObjectsToTarget = new FileBasedDeploy();
		try {
			deployObjectsToTarget.deploy(tsfHandle);
		} catch (Exception e) {
			e.printStackTrace();
			retVal = -1;
		}
		return retVal;
	}

	public int retrieve(String orgId, String metadataLogId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
