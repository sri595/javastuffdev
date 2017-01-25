package org.salesforce.oauth.integration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.salesforce.impl.SFServiceImpl;
import org.salesforce.util.Cache;
import org.salesforce.util.SFSourceoAuthHandle;

@WebServlet("/deploy")
public class DeployAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		HashMap<String, String> hashobj = Cache.getMap();
		session.setAttribute("object", hashobj);
		HashMap<String, String> lijstAttr = (HashMap<String, String>) session
				.getAttribute("object");
		Iterator it = lijstAttr.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			//System.out.println(pairs.getKey() + " " + pairs.getValue());
			System.out.println("Organization ids in HashMap----------" + pairs.getKey());
		}
		SFServiceImpl ser = new SFServiceImpl();
		
		String s=request.getParameter("SourceOrgType");
		StringTokenizer st = new StringTokenizer(s,"(");
		String sOrg = "";
		if(st.hasMoreTokens()){
			sOrg = st.nextToken();
		}
		
		SFSourceoAuthHandle soAuth = new SFSourceoAuthHandle(sOrg, (String)Cache.getMap().get(sOrg));
		System.out.println("********* "+soAuth.getMetadaConnection().getSessionHeader());
		
		
		String t=request.getParameter("TargetOrgType");
		StringTokenizer st1 = new StringTokenizer(t,"(");
		String tOrg = "";
		if(st1.hasMoreTokens()){
			tOrg = st1.nextToken();
		}
		
		ser.deploy(sOrg, tOrg, "a0Yj0000002Kz7A");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
