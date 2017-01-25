package org.salesforce.util;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SFSourceoAuthHandle{
	ConnectorConfig enterpriseConfig = null;
	ConnectorConfig metadataConfig = null;
	EnterpriseConnection enterpriseConnection = null;
	MetadataConnection metadataConnection =null;
	String accessToken;

	String orgId;
	
	public SFSourceoAuthHandle(String orgId, String accessToken) {
		this.orgId = orgId;
		this.accessToken = accessToken;  
		try {
			System.out.println("getEnterpriseConnection - Class Loader: "+Thread.currentThread().getContextClassLoader().toString());
			enterpriseConfig = new ConnectorConfig();
			String eUrlEndpoint = "https://na16.salesforce.com/services/Soap/c/33.0/"+orgId;
			enterpriseConfig.setSessionId(getAccessToken());
			enterpriseConfig.setManualLogin(true);
			enterpriseConfig.setCompression(false);
			enterpriseConfig.setServiceEndpoint(eUrlEndpoint);
			enterpriseConnection = Connector.newConnection(enterpriseConfig);
			System.out.println("getEnterpriseConnection - Class Loader: "+Thread.currentThread().getContextClassLoader().toString());
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("getMetadaConnection - Class Loader: "+Thread.currentThread().getContextClassLoader().toString());
			
			com.sforce.ws.ConnectorConfig metadataConfig1 = new ConnectorConfig();
			String urlEndpoint = "https://na16.salesforce.com/services/Soap/m/33.0/"+orgId;
			metadataConfig1.setSessionId(getAccessToken());
			metadataConfig1.setManualLogin(true);
			metadataConfig1.setCompression(false);
			metadataConfig1.setServiceEndpoint(urlEndpoint);
			//metadataConfig.setAuthEndpoint(urlEndpoint);
			metadataConnection = new MetadataConnection(metadataConfig1);
			
			//metadataConnection = com.sforce.soap.metadata.Connector.newConnection(metadataConfig1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		setEnterpriseConnection(enterpriseConnection);

		

		setMetadataConnection(metadataConnection);	
	}

	public MetadataConnection getMetadaConnection() {
		return metadataConnection;
	}

	public EnterpriseConnection getEnterpriseConnection() {
		return enterpriseConnection;
	}

	public ConnectorConfig getEnterpriseConfig() {
		return enterpriseConfig;
	}

	public void setEnterpriseConfig(ConnectorConfig enterpriseConfig) {
		this.enterpriseConfig = enterpriseConfig;
	}

	public ConnectorConfig getMetadataConfig() {
		return metadataConfig;
	}

	public void setMetadataConfig(ConnectorConfig metadataConfig) {
		this.metadataConfig = metadataConfig;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public MetadataConnection getMetadataConnection() {
		return metadataConnection;
	}

	public void setMetadataConnection(MetadataConnection metadataConnection) {
		this.metadataConnection = metadataConnection;
	}

	public void setEnterpriseConnection(EnterpriseConnection enterpriseConnection) {
		this.enterpriseConnection = enterpriseConnection;
	}

	

}
