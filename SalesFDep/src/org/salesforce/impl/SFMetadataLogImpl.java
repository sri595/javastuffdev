package org.salesforce.impl;

import org.salesforce.util.SFoAuthHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.MetadataLog__c;

public class SFMetadataLogImpl {

	public SFMetadataLogImpl() {
		super();
	}

	public static void main(String[] args) {
		System.out.println("Hello");
		SFMetadataLogImpl sf = new SFMetadataLogImpl();
	}

	private static final Logger LOG = LoggerFactory
			.getLogger(SFMetadataLogImpl.class);

	public MetadataLog__c query(String metadataLogNameId, SFoAuthHandle sfHandle) {
		com.sforce.soap.enterprise.sobject.MetadataLog__c retObj = null;
		String sql = "SELECT Id, Name, Action__c, OrganizationId__c, Status__c"
				+ " FROM MetadataLog__c" + " where Id= '" + metadataLogNameId
				+ "'";
		try {
			QueryResult queryResults = sfHandle.getEnterpriseConnection()
					.query(sql);
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					retObj = (com.sforce.soap.enterprise.sobject.MetadataLog__c) queryResults
							.getRecords()[i];
					System.out.println(" - Action: " + retObj.getAction__c());
					System.out.println(" - Org Id: "
							+ retObj.getOrganizationId__c());
					System.out.println(" - Status: " + retObj.getStatus__c());
					System.out.println(" - Id: " + retObj.getId());
					System.out.println(" - Name: " + retObj.getName());
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

	public int update(String MetadataLogId, SFoAuthHandle sfHandle) {
		int retVal = 1;
		try {
			com.sforce.soap.enterprise.sobject.MetadataLog__c retObj = null;
			retObj = query(MetadataLogId, sfHandle);
			if (retObj != null) {
				retVal = update(retObj, sfHandle);
			}
		} catch (Exception e) {
			e.printStackTrace();
			retVal = -1;
		}
		return retVal;
	}

	public int update(MetadataLog__c obj, SFoAuthHandle sfHandle) {
		int retVal = 1;
		try {
			com.sforce.soap.enterprise.sobject.MetadataLog__c c = new com.sforce.soap.enterprise.sobject.MetadataLog__c();
			c.setId(obj.getId());
			c.setStatus__c("Completed");
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

	public String getActionToken(String metadataLogNameId,
			SFoAuthHandle sfHandle) {
		MetadataLog__c c = query(metadataLogNameId, sfHandle);
		if (c != null) {
			return c.getAction__c();
		}
		return null;
	}

	public void describeObjects(SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub

	}

	public MetadataLog__c[] query(SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(String metadataLogNameId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
