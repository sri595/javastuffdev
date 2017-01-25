package com.util;

import javax.servlet.annotation.WebInitParam;

public class Constants {

	public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	public static final String REFRESH_TOKEN = "REFRESH_TOKEN";
	public static final String INSTANCE_URL = "INSTANCE_URL";
	public static final String ID_URL = "ID_URL";
	public static final String TOKEN_FILE_PATH = "TOKEN_FILE_PATH";
	public static final String SFHomeUrl="/home/home.jsp"; 
	
	public static final String LoginEnv="https://login.salesforce.com"; 
	public static final String TestEnv="https://test.salesforce.com"; 
	
	public static String DeployedAppName =  "SFSOAPWS";
	
	public static String consumerSecret = "3817318800271280941";
	public static String queryString = "/services/data/v20.0/query";
	public static String BaseOrgName = "BaseOrg";

	
	public static String BaseOrgTokenCode = "TokenCode";
	public static String BaseOrgServerURL = "ServerURL";
	public static String BaseOrgRefreshTokenCode = "RefreshTokenCode";
	public static String BaseOrgBaseOrganizationId = "BaseOrganizationId";
	
	public static String BaseOrgToken = "BaseOrgToken";
/*	public static String BaseOrg = "00Dj0000001tsUfEAI";
	public static String TargetOrg = "00Dj00000029B59EAE";
*/	public static String AuthorizationCode = "";
	public static String token_type = "Bearer";
	public static final String API_VERSION = "33.0";
	
	public static final String[] SFTypes={"ApexClass","ApexComponent","ApexPage","ApexTrigger","AppMenu","AssignmentRule","AssignmentRules","AutoResponseRules","Community","CustomApplication","CustomField","CustomLabel","CustomLabels","CustomObject","CustomObjectTranslation","CustomTab","Dashboard","Document","EmailTemplate", "EscalationRule","EscalationRules","HomePageLayout","Layout","ListView","MatchingRules","MatchingRules","Profile","PermissionSet","QuickAction","RemoteSiteSetting","Report","ReportType","Role","Settings","SharingRules","StaticResource","WebLink","SharingSet","CustomPageWebLink","Workflow"};
	
	//public static final String[] SFTypes={"HomePageLayout","Layout"};
	// public static final String[] SFTypes={"CustomObject"};
    //public static final String[] SFTypes={"InstalledPackage","CustomLabels","StaticResource","Scontrol","AuraDefinitionBundle","ApexComponent","ApexPage","Queue","ExternalDataSource","NamedCredential","Role","Group","CustomObject","ReportType","Report","Dashboard","AnalyticSnapshot","Layout","Document","CustomPageWebLink","QuickAction","FlexiPage","CustomTab","CustomApplicationComponent","CustomApplication","Letterhead","EmailTemplate","Flow","Workflow","AssignmentRules","AutoResponseRules","EscalationRules","PostTemplate","ApprovalProcess","HomePageComponent","HomePageLayout","CustomObjectTranslation","ApexClass","ApexTrigger","Profile","PermissionSet","CustomMetadata","DataCategoryGroup","RemoteSiteSetting","MatchingRules","AuthProvider","CustomSite","ChannelLayout","SharingRules","SharingSet","Community","CallCenter","ConnectedApp","AppMenu","CustomPermission","SiteDotCom","SamlSsoConfig","CorsWhitelistOrigin","ActionLinkGroupTemplate","SynonymDictionary","Settings"};

	public static String base_username = "ikhan@infrascape.com";
	public static String base_password = "infrascape3"+ "cMN0SHllSbM6ireqkDbL7W3Qx";
	
	public static String target_username = "skrishna@infrascape.com.copdesti";
	public static String target_password = "infrascape3"+"1Ms5Ri5SwMLulCF60uFJMO0Z";
	
	
	public static String target3_username = "skrishna@desticorp2.com.com";
	public static String target3_password = "infrascape4"+"G8ksxsN26GySSdYYMH0a05cF";
	public static String target2_username = "skrishna@desticorp2.com.com";
	public static String target2_password = "infrascape4"+"BNsc0IwBaduT5Qryw5G4SIulL";
	
	public static final String SUCESS_MESSAGE = "MetadataLog record is sucessfully updated";
	public static final String Package_FileName = "package.xml";
	public static final String Component_Zip_FileName = "components.zip";
	public static final String ERROR_STATUS = "Error";
	public static final String PROCESSING_STATUS = "In-Progress";
	public static final String COMPLETED_STATUS = "Completed";
	public static final String RETRIEVE_SUCESS_MESSAGE = "Retrieve request sucessfully processed";
	public static final String DEPLOY_SUCESS_MESSAGE = "Deploy request sucessfully processed";
	
	public static final String Retrieve_CSV_File = "retreive.csv";
	public static final String MetadataDescription_Name = "MetadataDescription__c";
	public static int ChunkSize = 8000;
	public static int waitFor2Sec = 2000;
	public static int waitFor1Sec = 1000;
	public static String BaseClientID = "3MVG9fMtCkV6eLhckipcGtsdEsVknDH5QapqayieqVXn9.ZhCKj6DE8R_uLa7b8o2rjmJ5Du9JjzFq.jA8woO";
	public static String BaseClientSecret = "815658844577726804";
	public static String CustomClientID = "3MVG9fMtCkV6eLhckipcGtsdEsfpQCEkyYEebiLuCF4f6W3oYzlz5oBwSFWTKe7eZaIXoX2Zwg3Dbtaa0bUxF";
	public static String CustomClientSecret = "6261950468938934297";
	public static String Token_URL = "/services/oauth2/token";
	
	public static String Environment="Environment";
	public static String DeployDetails="DeployDetails";
	public static String DeploySettings="DeploySettings";
	public static String MetadataDescription="MetadataDescription";
	public static String Package="Package";
	public static String ReleasePackage="ReleasePackage";
	public static String MetadataLog="MetadataLog";

	
	
	/*
	015-08-07T09:17:27.328908+00:00 app[web.1]: SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
2015-08-07T09:17:27.329284+00:00 app[web.1]: Auth URL---https://emc--oppvis.cs1.my.salesforce.com/services/oauth2/authorize?response_type=code&client_id=3MVG9fMtCkV6eLhckipcGtsdEsXpvuj0tgLP6bJJYaFcdwyUC5dmSJ.Oi2e6vkHAZMrNBY6k8y9Qf.QWFahCK&redirect_uri=https%3A%2F%2Fsfinfraws.herokuapp.com%2FOAuthServlet%2Fcallback
2015-08-07T09:17:27.375750+00:00 app[web.1]: main :10/OAuthServlet/callback
2015-08-07T09:17:27.375756+00:00 app[web.1]: tokenurl : https://emc--oppvis.cs1.my.salesforce.com/services/oauth2/token
2015-08-07T09:17:27.375812+00:00 app[web.1]: authUrl : https://emc--oppvis.cs1.my.salesforce.com/services/oauth2/authorize?response_type=code&client_id=3MVG9fMtCkV6eLhckipcGtsdEsXpvuj0tgLP6bJJYaFcdwyUC5dmSJ.Oi2e6vkHAZMrNBY6k8y9Qf.QWFahCK&redirect_uri=https%3A%2F%2Fsfinfraws.herokuapp.com%2FOAuthServlet%2Fcallback
2015-08-07T09:17:27.376775+00:00 app[web.1]: test: /OAuthServlet/callback
2015-08-07T09:17:28.469297+00:00 app[web.1]: WARNING: Cookie rejected: "$Version=0; BrowserId=sFZu9todR2icHWS3Pqfy3w; $Path=/; $Domain=.salesforce.com". Domain attribute ".salesforce.com" violates RFC 2109: host minus domain may not contain any dots
2015-08-07T09:17:28.478301+00:00 app[web.1]: RL --https://emc--OppVis.cs1.my.salesforce.com
2015-08-07T09:17:28.476673+00:00 app[web.1]: idURL---------https://test.salesforce.com/id/00DS0000003Km6LMAS/00570000001eJC9AAM
2015-08-07T09:17:28.468945+00:00 app[web.1]: Aug 07, 2015 9:17:28 AM org.apache.commons.httpclient.HttpMethodBase processCookieHeaders
2015-08-07T09:17:28.881662+00:00 app[web.1]: tt4rttrtertretret
2015-08-07T09:17:28.868072+00:00 app[web.1]:  status - 200
2015-08-07T09:17:28.869858+00:00 app[web.1]: Auth Response: {} {
2015-08-07T09:17:28.869860+00:00 app[web.1]:   "timezone": "America/Panama",
2015-08-07T09:17:28.869862+00:00 app[web.1]:   "last_modified_date": "2015-08-06T13:40:10.000+0000",
2015-08-07T09:17:28.869864+00:00 app[web.1]:   "addr_zip": null,
2015-08-07T09:17:28.869865+00:00 app[web.1]:   "language": "en_US",
2015-08-07T09:17:28.869866+00:00 app[web.1]:   "locale": "en_US",
2015-08-07T09:17:28.869870+00:00 app[web.1]:     "thumbnail": "https://emc--OppVis--c.cs1.content.force.com/profilephoto/005/T",
2015-08-07T09:17:28.869868+00:00 app[web.1]:   "photos": {
2015-08-07T09:17:28.869871+00:00 app[web.1]:     "picture": "https://emc--OppVis--c.cs1.content.force.com/profilephoto/005/F"
2015-08-07T09:17:28.869872+00:00 app[web.1]:   },
2015-08-07T09:17:28.869874+00:00 app[web.1]:   "addr_street": null,
2015-08-07T09:17:28.869875+00:00 app[web.1]:   "urls": {
2015-08-07T09:17:28.869878+00:00 app[web.1]:     "metadata": "https://emc--OppVis.cs1.my.salesforce.com/services/Soap/m/{version}/00DS0000003Km6L",
2015-08-07T09:17:28.869876+00:00 app[web.1]:     "rest": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/",
2015-08-07T09:17:28.869880+00:00 app[web.1]:     "enterprise": "https://emc--OppVis.cs1.my.salesforce.com/services/Soap/c/{version}/00DS0000003Km6L",
2015-08-07T09:17:28.869881+00:00 app[web.1]:     "query": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/query/",
2015-08-07T09:17:28.869883+00:00 app[web.1]:     "profile": "https://emc--OppVis.cs1.my.salesforce.com/00570000001eJC9AAM",
2015-08-07T09:17:28.869884+00:00 app[web.1]:     "groups": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/chatter/groups",
2015-08-07T09:17:28.869887+00:00 app[web.1]:     "search": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/search/",
2015-08-07T09:17:28.869889+00:00 app[web.1]:     "partner": "https://emc--OppVis.cs1.my.salesforce.com/services/Soap/u/{version}/00DS0000003Km6L",
2015-08-07T09:17:28.869886+00:00 app[web.1]:     "users": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/chatter/users",
2015-08-07T09:17:28.869890+00:00 app[web.1]:     "feeds": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/chatter/feeds",
2015-08-07T09:17:28.869891+00:00 app[web.1]:     "sobjects": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/sobjects/",
2015-08-07T09:17:28.869893+00:00 app[web.1]:     "feed_items": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/chatter/feed-items",
2015-08-07T09:17:28.869894+00:00 app[web.1]:     "recent": "https://emc--OppVis.cs1.my.salesforce.com/services/data/v{version}/recent/",
2015-08-07T09:17:28.869896+00:00 app[web.1]:     "custom_domain": "https://emc--OppVis.cs1.my.salesforce.com"
2015-08-07T09:17:28.869897+00:00 app[web.1]:   },
2015-08-07T09:17:28.869898+00:00 app[web.1]:   "user_type": "STANDARD",
2015-08-07T09:17:28.869900+00:00 app[web.1]:   "mobile_phone": null,
2015-08-07T09:17:28.869902+00:00 app[web.1]:   "first_name": "Anand",
2015-08-07T09:17:28.869905+00:00 app[web.1]:   "email_verified": true,
2015-08-07T09:17:28.869901+00:00 app[web.1]:   "id": "https://test.salesforce.com/id/00DS0000003Km6LMAS/00570000001eJC9AAM",
2015-08-07T09:17:28.869904+00:00 app[web.1]:   "email": "anand.sharma2@emc.com",
2015-08-07T09:17:28.869906+00:00 app[web.1]:   "utcOffset": -18000000,
2015-08-07T09:17:28.869909+00:00 app[web.1]:   "active": true,
2015-08-07T09:17:28.869910+00:00 app[web.1]:   "display_name": "Anand Sharma",
2015-08-07T09:17:28.869908+00:00 app[web.1]:   "last_name": "Sharma",
2015-08-07T09:17:28.869915+00:00 app[web.1]:   "organization_id": "00DS0000003Km6LMAS",
2015-08-07T09:17:28.869911+00:00 app[web.1]:   "addr_state": null,
2015-08-07T09:17:28.869914+00:00 app[web.1]:   "user_id": "00570000001eJC9AAM",
2015-08-07T09:17:28.869912+00:00 app[web.1]:   "asserted_user": true,
2015-08-07T09:17:28.869916+00:00 app[web.1]:   "nick_name": "anand.sharma2",
2015-08-07T09:17:28.869917+00:00 app[web.1]:   "addr_city": null,
2015-08-07T09:17:28.869918+00:00 app[web.1]:   "mobile_phone_verified": false,
2015-08-07T09:17:28.869920+00:00 app[web.1]:   "addr_country": null,
2015-08-07T09:17:28.869921+00:00 app[web.1]:   "username": "anand.sharma2@emc.com.oppvis",
2015-08-07T09:17:28.869922+00:00 app[web.1]:   "status": {
2015-08-07T09:17:28.869923+00:00 app[web.1]:     "created_date": null,
2015-08-07T09:17:28.869924+00:00 app[web.1]:     "body": null
2015-08-07T09:17:28.869925+00:00 app[web.1]:   }
2015-08-07T09:17:28.869930+00:00 app[web.1]: }
2015-08-07T09:17:28.870132+00:00 app[web.1]: ------https://emc--OppVis.cs1.my.salesforce.com
2015-08-07T09:17:28.887813+00:00 app[web.1]: [WSC][Thread.run:745]Log file already exists, appending to trace.log
2015-08-07T09:17:30.071731+00:00 app[web.1]:  - Id: a0Wj0000003j9ZvEAI
2015-08-07T09:17:30.071825+00:00 app[web.1]:  - Name: anand.sharma2@emc.com.OppVis
2015-08-07T09:17:30.071935+00:00 app[web.1]:  - Passwd: null
2015-08-07T09:17:30.072002+00:00 app[web.1]:  - Token encripted: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
2015-08-07T09:17:30.072094+00:00 app[web.1]:  - Token: 00DS0000003Km6L!AQsAQCgpuZIFrk3y_BKgIEeA6l64LDvfJTsnOAn9pGe._OUzjJCGzNd.zL1qLYHQeDgUCtrE65pYgl2nmJtgeZ5mpKoGPZBw
2015-08-07T09:17:30.072180+00:00 app[web.1]:  - Token: https://emc--OppVis.cs1.my.salesforce.com
2015-08-07T09:17:30.072356+00:00 app[web.1]: 00DS0000003Km6LMAS~00DS0000003Km6L!AQsAQH1MnzdSERwYTVXvHsHMljCfj2a._wHp8wXk2zCnoXvp7.705aoa_ZSff_Ikn0afU4MZ87N7ltSqj5PM6pDCsiGSBRML~https://emc--OppVis.cs1.my.salesforce.com~anand.sharma2@emc.com.oppvis
2015-08-07T09:17:30.072474+00:00 app[web.1]: update : https://emc--OppVis.cs1.my.salesforce.com
2015-08-07T09:17:30.251449+00:00 app[web.1]: Updated Environment component: a0Wj0000003j9ZvEAI
2015-08-07T09:17:30.256458+00:00 heroku[router]: at=info method=GET path="/OAuthServlet/callback?code=aPrxJZTK7Rs03PXLoSV_pU6QVJUdfubGR34GeHYOBbdFW74M9fgHGLgbzigF4Tx4xPyt.cKkgQ%3D%3D" host=sfinfraws.herokuapp.com request_id=32b48f11-2ffb-4fe8-9279-ed7d5e89ad71 fwd="183.82.108.79" dyno=web.1 connect=1ms service=8044ms status=302 bytes=248
2015-08-07T09:17:30.683962+00:00 heroku[router]: at=info method=GET path="/sfhome" host=sfinfraws.herokuapp.com request_id=bbaacbe9-cbf0-40ff-a448-17effb5809b8 fwd="183.82.108.79" dyno=web.1 connect=1ms service=7ms status=302 bytes=216
infra3@local:~/eclipse_workspace/c3/sfinfraws$ 

	 */
}
