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
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.salesforce.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openbrace.obmimic.mimic.servlet.http.HttpServletRequestMimic;
import com.openbrace.obmimic.mimic.servlet.http.HttpServletResponseMimic;

@WebServlet(urlPatterns = { "/logs1" })
public class TestAddMetadataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	private static final String INSTANCE_URL = "INSTANCE_URL";
	private static final String AUTH_CODE = "AuthorizationCode";

	private static final Logger LOG = LoggerFactory
			.getLogger(TestAddMetadataServlet.class);

	TestAddMetadataServlet() {
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
			// doGet2(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String createCustomObject(String name, String instanceUrl,
			String accessToken, PrintWriter writer) throws ServletException,
			IOException {
		String accountId = null;

		HttpClient httpclient = new HttpClient();

		JSONObject account = new JSONObject();

		try {
			account.put("Name", name);
		} catch (JSONException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		PostMethod post = new PostMethod(instanceUrl
				+ "/services/data/v20.0/sobjects/MyTestObject3__c");

		post.setRequestHeader("Authorization", "OAuth " + accessToken);
		post.setRequestEntity(new StringRequestEntity(account.toString(),
				"application/json", null));

		try {
			httpclient.executeMethod(post);

			LOG.debug("HTTP status " + post.getStatusCode()
					+ " creating account\n\n");

			if (post.getStatusCode() == HttpStatus.SC_CREATED) {
				try {
					JSONObject response = new JSONObject(new JSONTokener(
							new InputStreamReader(
									post.getResponseBodyAsStream())));
					System.out.println("Create response: "
							+ response.toString(2));

					if (response.getBoolean("success")) {
						accountId = response.getString("id");
						LOG.debug("New record id " + accountId + "\n\n");
					}
				} catch (JSONException e) {
					e.printStackTrace();
					// throw new ServletException(e);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			post.releaseConnection();
		} 

		return accountId;
	}

	private static void query(String instanceUrl, String accessToken,
			PrintWriter writer) throws ServletException, IOException {
		GetMethod get = null;
		try {
			System.out.println("Displaying Logs:");
			HttpClient httpclient = new HttpClient();

			String queryString = "/services/data/v20.0/sobjects";
			get = new GetMethod(Constants.instance_url + queryString);

			// set the token in the header
			get.setRequestHeader("Authorization", "OAuth "
					+ Constants.access_token);
			System.out.println("URL : " + get.getURI().toString());
			try {
				httpclient.executeMethod(get);
				if (get.getStatusCode() == HttpStatus.SC_OK) {
					try {
						JSONObject response = new JSONObject(new JSONTokener(
								new InputStreamReader(
										get.getResponseBodyAsStream())));
						LOG.debug("Query response: {}, \n Total records: {} ",
								response.toString(2));// ,response.getString("totalSize"));
						/*
						 * JSONArray results = response.getJSONArray("records");
						 * for (int i = 0; i < results.length(); i++) {
						 * LOG.debug(results.getJSONObject(i).getString("Id")
						 * +" : " +results.getJSONObject(i).getString("Name") );
						 * }
						 */
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

	protected static void doGet1(HttpServletRequest request,
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
		createCustomObject("MyTestObject3__c", instanceUrl, accessToken, writer);
		//query(instanceUrl, accessToken, writer);
		writer.println("</body>");
		writer.println("</html>");
	}

}