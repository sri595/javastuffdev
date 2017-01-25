package org.salesforce.oauth.integration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.salesforce.util.Cache;
import org.salesforce.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet parameters
 */
@WebServlet(name = "OAuthServlet", urlPatterns = { "/OAuthServlet/*",
		"/OAuthServlet" }, initParams = {
		// clientId is 'Consumer Key' in the Remote Access UI
		@WebInitParam(name = "clientId", value = "3MVG9fMtCkV6eLhckipcGtsdEsY7pgHtP9KSIIuYk3vX6SRlxIOXv4cCVg8pVr_uFe.4Rr4yBUAW0zw_cbRLL"),
		// clientSecret is 'Consumer Secret' in the Remote Access UI
		@WebInitParam(name = "clientSecret", value = "9216385818935662243"),
		// This must be identical to 'Callback URL' in the Remote Access UI
		@WebInitParam(name = "redirectUri", value = "https://localhost:8443/SalesFDep/OAuthServlet"),
		@WebInitParam(name = "environment", value = "https://login.salesforce.com"), })
public class OAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String orgName = null;

	private static final Logger LOG = LoggerFactory
			.getLogger(OAuthServlet.class);

	private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	private static final String INSTANCE_URL = "INSTANCE_URL";

	private String clientId = null;
	private String clientSecret = null;
	private String redirectUri = null;
	private String environment = null;
	private String authUrl = null;
	private String tokenUrl = null;
	private String authorizationCode = null;
	private String id = null;

	public void init() throws ServletException {
		clientId = this.getInitParameter("clientId");
		clientSecret = this.getInitParameter("clientSecret");
		redirectUri = this.getInitParameter("redirectUri");
		environment = this.getInitParameter("environment");

		try {
			authUrl = environment + "/services/oauth2/authorize?"
					+ "prompt=login" + "&response_type=code" + "&client_id="
					+ clientId + "&redirect_uri="
					+ URLEncoder.encode(redirectUri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOG.error("Error while creating AuthURL: {} ", e.getMessage());
			throw new ServletException("Error while creating AuthURL:", e);
		}
		tokenUrl = environment + "/services/oauth2/token";
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute(
				ACCESS_TOKEN);
		if (orgName == null) {
			if (request.getParameter("OrgName") != null) {
				System.out.println("%%%%%%% " + orgName);
				orgName = request.getParameter("OrgName");
			}
			if (request.getParameter("OrgName") == null) {
				System.out.println("&&&&&& " + orgName);
			}
		} else {
			if (request.getParameter("OrgName") != null) {
				System.out.println("%%%%%%% " + orgName);
				orgName = request.getParameter("OrgName");
			}
			System.out.println("-------" + orgName);
		}

		System.out.println("*********** Org Name - "
				+ request.getParameter("OrgName"));

		// if (null == accessToken) {
		String instanceUrl = null;
		LOG.info("test: ", request.getRequestURI());
		System.out.println("Request URL : " + request.getRequestURI());
		if (request.getRequestURI().endsWith("OAuthServlet")) {
			// Send the user to authorize
			response.sendRedirect(authUrl);
			return;
		} else {
			String code = request.getParameter("code");
			authorizationCode = code;
			LOG.info("Auth successful, got Authorization code: {} ", code);

			HttpClient httpclient = new HttpClient();
			PostMethod post = new PostMethod(tokenUrl);
			post.addParameter("code", code);
			post.addParameter("grant_type", "authorization_code");
			post.addParameter("client_id", clientId);
			post.addParameter("client_secret", clientSecret);
			post.addParameter("redirect_uri", redirectUri);

			try {
				httpclient.executeMethod(post);
				try {
					JSONObject authResponse = new JSONObject(new JSONTokener(
							new InputStreamReader(
									post.getResponseBodyAsStream())));
					accessToken = authResponse.getString("access_token");
					instanceUrl = authResponse.getString("instance_url");
					id = authResponse.getString("id");
					LOG.info("Auth Response: {} ", authResponse.toString(2));
				} catch (JSONException e) {
					LOG.error(
							"Error while getting JSONObject from AuthResponse: {} ",
							e.getMessage());
					throw new ServletException(
							"Error while getting JSONObject from AuthResponse: {} ",
							e);
				}
			} catch (Exception e) {
				LOG.error("Error while Oauth with Salesforce: {} ",
						e.getMessage());
				throw new ServletException(
						"Error while Oauth with Salesforce:  ", e);
			} finally {
				post.releaseConnection();
			}
		}

		// Set a session attribute so that other servlets can get the access
		// token
		request.getSession().setAttribute(ACCESS_TOKEN, accessToken);

		// We also get the instance URL from the OAuth response, so set it
		// in the session too
		request.getSession().setAttribute(INSTANCE_URL, instanceUrl);
		request.getSession().setAttribute("AuthorizationCode",
				authorizationCode);
		request.getSession().setAttribute(Constants.ID, id);

		// }
		getuserDetails(request, orgName);
		response.sendRedirect(request.getContextPath() + "/home");
	}

	public void getuserDetails(HttpServletRequest request, String orgName)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String accessToken = (String) session.getAttribute("ACCESS_TOKEN");

		HttpClient httpclient = new HttpClient();
		GetMethod get = new GetMethod(id);
		// set the token in the header
		get.setRequestHeader("Authorization", "OAuth " + accessToken);

		// set the SOQL as a query param
		NameValuePair[] params = new NameValuePair[1];

		params[0] = new NameValuePair("oauth_token", accessToken);
		get.setQueryString(params);
		System.out.println("URL---" + get.getURI().toString());
		try {
			httpclient.executeMethod(get);
			System.out.println(" status - " + get.getStatusCode());
			if (get.getStatusCode() == HttpStatus.SC_OK) {
				// Now lets use the standard java json classes to work with the
				// results
				try {
					JSONObject jsonResponse = new JSONObject(
							new JSONTokener(new InputStreamReader(
									get.getResponseBodyAsStream())));

					LOG.debug("Query response: {}, \n Total records: {} ",
							jsonResponse.toString(2));

					LOG.debug("URls : ", jsonResponse.get("organization_id")
							.toString());
					System.out.println("Org: "
							+ jsonResponse.get("organization_id"));
					String s = new String(
							(String) jsonResponse.get("organization_id"));
					Cache.getMap().put(s.substring(0, s.length() - 3),
							accessToken);
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
			e.printStackTrace();
		}
	}
}