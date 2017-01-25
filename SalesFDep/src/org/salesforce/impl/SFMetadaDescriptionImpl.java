package org.salesforce.impl;

import org.salesforce.util.SFoAuthHandle;

import com.sforce.soap.enterprise.DescribeSObjectResult;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.MetadataDescription__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class SFMetadaDescriptionImpl{

	public SFMetadaDescriptionImpl() {
		super();
		int arrSize = 1;
		String[] tempArr = new String[arrSize];
		for(int i=0; i<arrSize; i++){
			tempArr[i] = new String();
		}
	}

	public static void main(String[] args){
		SFMetadaDescriptionImpl sf = new SFMetadaDescriptionImpl();
		
	}
	
	public int insertSFObjects(String[] objList, SFoAuthHandle sfHandle){
		int retVal = 1;
		
		// create the records
		MetadataDescription__c[] records = new MetadataDescription__c[objList.length];
		try {
			System.out.println(sfHandle.getEnterpriseConnection().getUserInfo().getUserId());
			DescribeSObjectResult[] describeSObjectResults = sfHandle
					.getEnterpriseConnection().describeSObjects(objList);
			for (int i = 0; i < describeSObjectResults.length; i++) {
				DescribeSObjectResult desObj = describeSObjectResults[i];
				// Get the name of the sObject
				String objectName = desObj.getName();
				System.out.println("sObject name: " + objectName);
				MetadataDescription__c a = new MetadataDescription__c();
				a.setName__c(objectName);
				a.setType__c("CustomObject");
				a.setOrganizationId__c(sfHandle.getOrgId());
				records[i] = a;
			}
		} catch (ConnectionException ce) {
			ce.printStackTrace();
			retVal = -1;
			return retVal;
		}
		//retVal = save(records,sfHandle);
		return retVal;
	}

	public void describeObjects(SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub

	}

	public MetadataDescription__c[] query(SFoAuthHandle sfHandle) {
		com.sforce.soap.enterprise.sobject.MetadataDescription__c[] retObj = null;
		try {
			String sql = "SELECT Id, Name, Name__c, OrganizationId__c, Type__c, MetadataLog__c"
					+ " FROM MetadataDescription__c";
			// + " where Name__c= '"+metadataLogName+"'";
			System.out.println("sql - " + sql);
			QueryResult queryResults = sfHandle
					.getEnterpriseConnection().query(sql);
			retObj = new com.sforce.soap.enterprise.sobject.MetadataDescription__c[queryResults
					.getSize()];
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					retObj[i] = (com.sforce.soap.enterprise.sobject.MetadataDescription__c) queryResults
							.getRecords()[i];
					System.out.println(" - Id: " + retObj[i].getId());
					System.out.println(" - Name: " + retObj[i].getName());
					System.out.println(" - Name__c: " + retObj[i].getName__c());
					System.out.println(" - Org Id: "
							+ retObj[i].getOrganizationId__c());
					System.out.println(" - Type_c: " + retObj[i].getType__c());
					System.out.println(" - Metadata: "
							+ retObj[i].getMetadataLog__c());
					// System.out.println(" - MetadataLog: " +
					// retObj.toString());
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

	public int update(MetadataDescription__c obj, String metadataLogNameId, SFoAuthHandle sfHandle) {
		int retVal = 1;
		try {
			com.sforce.soap.enterprise.sobject.MetadataDescription__c c = new com.sforce.soap.enterprise.sobject.MetadataDescription__c();
			c.setId(obj.getId());
			c.setMetadataLog__c(metadataLogNameId);
			SaveResult[] results1 = sfHandle
					.getEnterpriseConnection()
					.update(new com.sforce.soap.enterprise.sobject.MetadataDescription__c[] { c });
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
					retVal = -1;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			retVal = -1;
			return retVal;
		}
		return retVal;
	}

	public void queryAndUpdate(String metadataLogNameId, SFoAuthHandle sfHandle) {
		com.sforce.soap.enterprise.sobject.MetadataDescription__c[] retObj = null;
		try {
			String sql = "SELECT Id, Name, Name__c, OrganizationId__c, Type__c, MetadataLog__c"
					+ " FROM MetadataDescription__c";
			QueryResult queryResults = sfHandle
					.getEnterpriseConnection().query(sql);
			retObj = new com.sforce.soap.enterprise.sobject.MetadataDescription__c[queryResults
					.getSize()];
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					// cast the SObject to a strongly-typed Contact
					retObj[i] = (com.sforce.soap.enterprise.sobject.MetadataDescription__c) queryResults
							.getRecords()[i];
					save(retObj[i], sfHandle);
				}
			} else {
				System.out.println(" There are no records size is - : "
						+ queryResults.getSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int save(SObject sobject, SFoAuthHandle sfHandle) {
		int retVal = 0;
		return retVal;
	}
	
	public int save(SObject[] sobjects, SFoAuthHandle sfHandle) {
		int retVal = 1;
		
		try {
			System.out.println("SAVE--"+sfHandle.getEnterpriseConnection());
			com.sforce.soap.enterprise.SaveResult[] saveResults = sfHandle
					.getEnterpriseConnection().create(sobjects);

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
			retVal = -1;
			return retVal;
		}
		return retVal;
	}
}
