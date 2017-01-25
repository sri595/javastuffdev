package org.salesforce.util;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SFoAuthHandle {
	ConnectorConfig enterpriseConfig = null;
	ConnectorConfig metadataConfig = null;
	String accessToken;

	String orgId;

	public SFoAuthHandle(String orgId, String accessToken) {
		this.orgId = orgId;
		this.accessToken = accessToken;
	}

	public MetadataConnection getMetadaConnection() {
		MetadataConnection metadataConnection = null;
		try {
			metadataConfig = new ConnectorConfig();
			String urlEndpoint = "https://na16.salesforce.com/services/Soap/m/33.0";
			metadataConfig.setSessionId(getAccessToken());
			metadataConfig.setManualLogin(true);
			metadataConfig.setCompression(false);
			metadataConfig.setServiceEndpoint(urlEndpoint);
			metadataConnection = new MetadataConnection(metadataConfig);
			// metadata conenction
			return metadataConnection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return metadataConnection;
	}

	public EnterpriseConnection getEnterpriseConnection() {
		EnterpriseConnection enterpriseConnection = null;
		try {
			enterpriseConfig = new ConnectorConfig();
			String eUrlEndpoint = "https://na16.salesforce.com/services/Soap/c/33.0";
			enterpriseConfig.setSessionId(getAccessToken());
			enterpriseConfig.setManualLogin(true);
			enterpriseConfig.setCompression(false);
			enterpriseConfig.setServiceEndpoint(eUrlEndpoint);
			enterpriseConnection = Connector.newConnection(enterpriseConfig);
			return enterpriseConnection;
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return enterpriseConnection;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
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


}
