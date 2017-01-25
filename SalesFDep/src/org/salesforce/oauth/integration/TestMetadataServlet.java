package org.salesforce.oauth.integration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.openbrace.obmimic.mimic.servlet.http.HttpServletRequestMimic;
import com.openbrace.obmimic.mimic.servlet.http.HttpServletResponseMimic;

@WebServlet(urlPatterns = { "/logs" })
public class TestMetadataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	private static final String INSTANCE_URL = "INSTANCE_URL";
	private static final String AUTH_CODE = "AuthorizationCode";

	private static final Logger LOG = LoggerFactory
			.getLogger(TestMetadataServlet.class);

	TestMetadataServlet() {
		super();

	}

	public static void main(String[] args) {
		try {
			System.out.println("Hello");
			HttpServletRequestMimic request = new HttpServletRequestMimic();
			HttpServletResponseMimic response = new HttpServletResponseMimic();
			
			request.getSession().setAttribute(ACCESS_TOKEN,
					Constants.access_token);
			request.getSession().setAttribute(INSTANCE_URL,
					Constants.instance_url);
			request.getSession().setAttribute(INSTANCE_URL,
					Constants.instance_url);

			String accessToken = (String) request.getSession().getAttribute(
					ACCESS_TOKEN);
			String instanceUrl = (String) request.getSession().getAttribute(
					INSTANCE_URL);
			String authorizationCode = (String) request.getSession()
					.getAttribute("AuthorizationCode");
			doGet1(request, response);
			//doGet2(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void showAccounts(String instanceUrl, String accessToken,
			PrintWriter writer) throws ServletException, IOException {
		LOG.info("Displaying List of Accounts:");
		HttpClient httpclient = new HttpClient();
		GetMethod get = new GetMethod(instanceUrl
				+ "/services/data/v20.0/query");

		// set the token in the header
		get.setRequestHeader("Authorization", "OAuth " + accessToken);

		// set the SOQL as a query param
		NameValuePair[] params = new NameValuePair[1];

		params[0] = new NameValuePair("q",
				"SELECT Name,Id from Account LIMIT 10");
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
						writer.println("<br>");
						writer.println(i + 1 + ". "
								+ results.getJSONObject(i).getString("Name"));
					}
					writer.println("<br>");
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
		} finally {
			get.releaseConnection();
		}
	}


	private static void query(String metadataLogNameId, String accessToken,
			PrintWriter writer) throws ServletException, IOException {
		com.sforce.soap.enterprise.sobject.MetadataLog__c retObj = null;
		String sql1 = "SELECT Id, Name, Action__c, OrganizationId__c, Status__c"
				+ " FROM MetadataLog__c" + " where Id= 'a0Yj0000002Kz7A'";
		String sql = "SELECT Name,Id, Action__c,OrganizationId__c, Status__c from MetadataLog__c LIMIT 10";
		GetMethod get = null;
		try {
			System.out.println("Displaying Logs:");
			HttpClient httpclient = new HttpClient();
			get = new GetMethod(Constants.instance_url + Constants.queryString);

			// set the token in the header
			get.setRequestHeader("Authorization", "OAuth "
					+ Constants.access_token);

			// set the SOQL as a query param
			NameValuePair[] params = new NameValuePair[1];

			/*
			 * params[0] = new NameValuePair("q",
			 * "SELECT Name,Id from Account LIMIT 10");
			 */
			params[0] = new NameValuePair("q", sql);
			get.setQueryString(params);
			System.out.println("URL : "+get.getURI().toString());
			try {
				httpclient.executeMethod(get);
				if (get.getStatusCode() == HttpStatus.SC_OK) {
					// Now lets use the standard java json classes to work with
					// the
					// results
					try {
						JSONObject response = new JSONObject(new JSONTokener(
								new InputStreamReader(
										get.getResponseBodyAsStream())));
						LOG.debug("Query response: {}, \n Total records: {} ",
								response.toString(2));// ,response.getString("totalSize"));
						JSONArray results = response.getJSONArray("records");
						for (int i = 0; i < results.length(); i++) {
							LOG.debug(results.getJSONObject(i).getString("Id"));
							LOG.debug(results.getJSONObject(i).getString("Name"));
							LOG.debug(results.getJSONObject(i).getString("Action__c"));
							LOG.debug(results.getJSONObject(i).getString("Id"));
							LOG.debug(results.getJSONObject(i).getString("Id"));
							
							
							/*LOG.debug("Id: {}, Name: {}", results
									.getJSONObject(i).getString("Id"), results
									.getJSONObject(i).getString("Name") + "-Action__c-"+results.getJSONObject(i).getString("Action__c")
									+ "-OrganizationId__c-"+results.getJSONObject(i).getString("OrganizationId__c") 
									+ "-Status__c-"+results.getJSONObject(i).getString("Status__c")
									);*/
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
	}

	/**
	 * String accessToken = (String) request.getSession().getAttribute(
	 * ACCESS_TOKEN); String instanceUrl = (String)
	 * request.getSession().getAttribute( INSTANCE_URL); String
	 * authorizationCode = (String) request.getSession().getAttribute(
	 * "AuthorizationCode");
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>OAuth Response</title>");
		writer.println("</head>");

		String accessToken = (String) request.getSession().getAttribute(
				ACCESS_TOKEN);
		String instanceUrl = (String) request.getSession().getAttribute(
				INSTANCE_URL);
		String authorizationCode = (String) request.getSession().getAttribute(
				"AuthorizationCode");

		LOG.debug("instance URL: {} ", instanceUrl);
		LOG.debug("Access Token: {} ", accessToken);
		LOG.debug("Authorization code: {} ", authorizationCode);

		if (accessToken == null) {
			writer.write("Error - no access token");
			return;
		}

		writer.println("<h2><b><center>Log Details</center></b><h2><br>");

		writer.println("<h4>List of Logs: <h4>");
		query(instanceUrl, accessToken, writer);

		writer.println("</body>");
		writer.println("</html>");
	}

	private static void doGet1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>OAuth Response</title>");
		writer.println("</head>");

		String accessToken = (String) request.getSession().getAttribute(
				ACCESS_TOKEN);
		String instanceUrl = (String) request.getSession().getAttribute(
				INSTANCE_URL);
		String authorizationCode = (String) request.getSession().getAttribute(
				"AuthorizationCode");

		LOG.debug("instance URL: {} ", instanceUrl);
		LOG.debug("Access Token: {} ", accessToken);
		LOG.debug("Authorization code: {} ", authorizationCode);

		if (accessToken == null) {
			writer.write("Error - no access token");
			return;
		}

		writer.println("<h2><b><center>Log Details</center></b><h2><br>");

		writer.println("<h4>List of Logs: <h4>");
		query(instanceUrl, accessToken, writer);

		writer.println("</body>");
		writer.println("</html>");
	}
	
	private static void doGet2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>OAuth Response</title>");
		writer.println("</head>");

		String accessToken = (String) request.getSession().getAttribute(
				ACCESS_TOKEN);
		String instanceUrl = (String) request.getSession().getAttribute(
				INSTANCE_URL);
		String authorizationCode = (String) request.getSession().getAttribute(
				"AuthorizationCode");

		LOG.debug("instance URL: {} ", instanceUrl);
		LOG.debug("Access Token: {} ", accessToken);
		LOG.debug("Authorization code: {} ", authorizationCode);

		if (accessToken == null) {
			writer.write("Error - no access token");
			return;
		}

		writer.println("<h2><b><center>Congratulation..!!!! OAuth process completed Successfully</center></b><h2><br>");

		writer.println("<h4>List of existing Accounts: <h4>");
		showAccounts(instanceUrl, accessToken, writer);
		writer.println("</body>");
		writer.println("</html>");
	}
}