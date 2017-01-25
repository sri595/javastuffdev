package org.salesforce.oauth.integration;

import java.io.InputStreamReader;

import javax.servlet.ServletException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.salesforce.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sforce.soap.enterprise.sobject.MetadataLog__c;

public class SFMetadataLogImpl{

	private String metadataLogNameId= "a0Yj0000002Kz7A";
	
	public SFMetadataLogImpl(){
		super();
		query(metadataLogNameId);
	}
	
	public static void main(String[] args){
		System.out.println("Hello");
		SFMetadataLogImpl sf = new SFMetadataLogImpl();
		
	}
	
	private static final Logger LOG = LoggerFactory
			.getLogger(SFMetadataLogImpl.class);

	public MetadataLog__c query(String metadataLogNameId) {
		com.sforce.soap.enterprise.sobject.MetadataLog__c retObj = null;
		String sql = "SELECT Id, Name, Action__c, OrganizationId__c, Status__c"
				+ " FROM MetadataLog__c" + " where Id= '" + metadataLogNameId
				+ "'";
		GetMethod get = null;
		try {
			System.out.println("Displaying List of Accounts:");
			HttpClient httpclient = new HttpClient();
			get = new GetMethod(Constants.instance_url
					+ Constants.queryString);
			
			// set the token in the header
			get.setRequestHeader("Authorization", "OAuth " + Constants.access_token);

			// set the SOQL as a query param
			NameValuePair[] params = new NameValuePair[1];

			/*params[0] = new NameValuePair("q",
					"SELECT Name,Id from Account LIMIT 10");*/
			params[0] = new NameValuePair("q",sql);
			get.setQueryString(params);
			try {
				httpclient.executeMethod(get);
				if (get.getStatusCode() == HttpStatus.SC_OK) {
					// Now lets use the standard java json classes to work with the
					// results
					try {
						JSONObject response = new JSONObject(
								new JSONTokener(new InputStreamReader(
										get.getResponseBodyAsStream())));
						LOG.debug("Query response: {}, \n Total records: {} ",
								response.toString(2));//,response.getString("totalSize"));
						JSONArray results = response.getJSONArray("records");
						for (int i = 0; i < results.length(); i++) {
							LOG.debug("Id: {}, Name: {}", results.getJSONObject(i)
									.getString("Id"), results.getJSONObject(i)
									.getString("Name"));
						}
					} catch (JSONException e) {
						LOG.error(
								"Error while getting JSONObject from the records {} ",
								e.getMessage());
						throw new ServletException(
								"Error while getting JSONObject from the records: ",
								e);
					}
				}
			} catch (Exception e) {
				LOG.error("Error while displaying list of accounts {} ",
						e.getMessage());
				throw new ServletException(
						"Error while displaying list of accounts: ", e);
			}
		} catch (Exception e) {
			LOG.error("Error while displaying list of accounts {} ",
					e.getMessage());
		} finally {
			get.releaseConnection();
		}
		return retObj;
	}
	
}
