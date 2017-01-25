package org.salesforce.impl;

import org.salesforce.util.SFSourceoAuthHandle;
import org.salesforce.util.SFoAuthHandle;

import com.sforce.soap.enterprise.DescribeGlobalResult;
import com.sforce.soap.enterprise.DescribeGlobalSObjectResult;
import com.sforce.soap.enterprise.DescribeSObjectResult;
import com.sforce.soap.enterprise.Field;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.MetadataDescription__c;
import com.sforce.soap.metadata.CustomField;
import com.sforce.soap.metadata.CustomObject;
import com.sforce.soap.metadata.DeploymentStatus;
import com.sforce.soap.metadata.FieldType;
import com.sforce.soap.metadata.Metadata;
import com.sforce.soap.metadata.SharingModel;
import com.sforce.ws.ConnectionException;

public class SFObjectsImpl{
	SFoAuthHandle sfHandle = null;

	public SFObjectsImpl() {
		super();
	}

	public static void main(String[] args) throws Exception{
		SFObjectsImpl sfi = new SFObjectsImpl();
		
		//String userId = "skrishna@infrascape.com.copdesti";
		//String passwd = "infrascape1"+"ylnJ8eMUawBd47meJEXhzSygb";
		//passwd = "infrascape1ylnJ8eMUawBd47meJEXhzSygb";
		String orgId="";
		//orgId="00Dj00000029B59";
		orgId="00Dj0000001tsUf";
		//orgId="00Do0000000dw2D";
	}
	
	public boolean isObjectAvailable(String orgId, String objName, SFSourceoAuthHandle sfHandle){
		String[] listStr = listAllSFGlobalObjects(sfHandle);
		for (int i = 0; i < listStr.length; i++) {
			String string = listStr[i];
			if(string.equals(objName)){
				System.out.println("Object "+objName +" is available in " +orgId);
				return true;
			}
		}
		return false;
	}

	
	public String[] listAllSFGlobalObjects(SFSourceoAuthHandle sfHandle) {
		String[] objlist = null;
		try {
			// Environment env = new Environment();
			// Enviroment__c envObj = env.queryObject(orgId);
			DescribeGlobalResult describeGlobalResult = sfHandle
					.getEnterpriseConnection().describeGlobal();
			// Get the sObjects from the describe global result
			DescribeGlobalSObjectResult[] sobjectResults = describeGlobalResult
					.getSobjects();
			objlist = new String[sobjectResults.length];
			// Write the name of each sObject to the console
			for (int i = 0; i < sobjectResults.length; i++) {
				objlist[i] = sobjectResults[i].getName();
				//System.out.println(sobjectResults[i].getName());
			}
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
		return objlist;
	}

	public void describeSFObjects(String orgId, String[] objList,
			SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		try {
			// Call describeSObjectResults and pass it an array with
			// the names of the objects to describe.

			DescribeSObjectResult[] describeSObjectResults = sfHandle
					.getEnterpriseConnection().describeSObjects(objList);
			for (int i = 0; i < describeSObjectResults.length; i++) {
				DescribeSObjectResult desObj = describeSObjectResults[i];
				// Get the name of the sObject
				String objectName = desObj.getName();
				System.out.println("sObject name: " + objectName);
				// For each described sObject, get the fields
				Field[] fields = desObj.getFields();

			}
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
	}

	public void insertSFObjects(String[] objList, String OrgId,
			String MetadataLogId, SFoAuthHandle sfHandle) {

		MetadataDescription__c[] records = new MetadataDescription__c[objList.length];
		try {
			DescribeSObjectResult[] describeSObjectResults = sfHandle
					.getEnterpriseConnection().describeSObjects(objList);
			for (int i = 0; i < describeSObjectResults.length; i++) {
				DescribeSObjectResult desObj = describeSObjectResults[i];
				// Get the name of the sObject
				String objectName = desObj.getName();
				System.out.println("sObject name: " + objectName);
				MetadataDescription__c a = new MetadataDescription__c();
				a.setName__c(objectName);
				a.setOrganizationId__c(OrgId);
				a.setMetadataLog__c(MetadataLogId);
				records[i] = a;
			}
		} catch (ConnectionException ce) {
			ce.printStackTrace();
			return;
		}

		try {
			// create the records in Salesforce.com
			com.sforce.soap.enterprise.SaveResult[] saveResults = sfHandle
					.getEnterpriseConnection().create(records);

			// check the returned results for any errors
			for (int i = 0; i < saveResults.length; i++) {
				if (saveResults[i].isSuccess()) {
					System.out.println(i
							+ ". Successfully created record - Id: "
							+ saveResults[i].getId());
				} else {
					com.sforce.soap.enterprise.Error[] errors = saveResults[i]
							.getErrors();
					for (int j = 0; j < errors.length; j++) {
						System.out.println("ERROR creating record: "
								+ errors[j].getMessage());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void updateMetadaLogStatus(String MetadataLogId, SFoAuthHandle sfHandle) {

		System.out.println("updating ../////.");
		try {
			com.sforce.soap.enterprise.sobject.MetadataLog__c c = new com.sforce.soap.enterprise.sobject.MetadataLog__c();
			SaveResult[] results1 = sfHandle
					.getEnterpriseConnection()
					.update(new com.sforce.soap.enterprise.sobject.MetadataLog__c[] { c });
			for (SaveResult r : results1) {
				if (r.isSuccess()) {
					System.out.println("Updated component: " + r.getId());
				} else {
					System.out
							.println("Errors were encountered while updating "
									+ r.getId());
					for (com.sforce.soap.enterprise.Error e : r.getErrors()) {
						System.out.println("Error message: " + e.getMessage());
						System.out.println("Status code: " + e.getStatusCode());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNewCustomObject(String objectName, SFoAuthHandle sfHandle)  throws Exception{
		final String label = objectName;
		CustomObject co = new CustomObject();
		co.setFullName(objectName+"__c");
		co.setDeploymentStatus(DeploymentStatus.Deployed);
		co.setDescription("Created by the Metadata API Sample");
		co.setEnableActivities(true);
		co.setLabel(label);
		co.setPluralLabel(label + "s");
		co.setSharingModel(SharingModel.ReadWrite);

		// The name field appears in page layouts, related lists, and elsewhere.
		final String fieldLabel = "MyCustomTestField";
		final String uniqueFieldName = "MyCustomTField__c";
		CustomField nf = new CustomField();
		nf.setType(com.sforce.soap.metadata.FieldType.Text);
		nf.setDescription("The custom object identifier on page layouts, related lists etc");
		nf.setLabel(fieldLabel);
		nf.setFullName(uniqueFieldName);
		co.setNameField(nf);
		com.sforce.soap.metadata.SaveResult[] results = sfHandle
				.getMetadaConnection()
				.createMetadata(new Metadata[] { co });

		for (com.sforce.soap.metadata.SaveResult r : results) {
			if (r.isSuccess()) {
				System.out.println("Created component: " + r.getFullName());
			} else {
				System.out.println("Errors were encountered while creating "
						+ r.getFullName());
				for (com.sforce.soap.metadata.Error e : r.getErrors()) {
					System.out.println("Error message: " + e.getMessage());
					System.out.println("Status code: " + e.getStatusCode());
				}
			}
		}
	}
	
	private void createNewCustomObject1(String objectName) {
		final String label = "My Custom Object";
		CustomObject co = new CustomObject();
		co.setFullName(objectName);
		co.setDeploymentStatus(DeploymentStatus.Deployed);
		co.setDescription("Created by the Metadata API Sample");
		co.setEnableActivities(true);
		co.setLabel(label);
		co.setPluralLabel(label + "s");
		co.setSharingModel(SharingModel.ReadWrite);

		// The name field appears in page layouts, related lists, and elsewhere.
		final String fieldLabel = "My Custom Field";
		final String uniqueFieldName = "MyCustomField__c";
		CustomField nf = new CustomField();
		nf.setType(FieldType.Text);
		nf.setDescription("The custom object identifier on page layouts, related lists etc");
		nf.setLabel(fieldLabel);
		nf.setFullName(uniqueFieldName);
		co.setNameField(nf);

		
	}
}
