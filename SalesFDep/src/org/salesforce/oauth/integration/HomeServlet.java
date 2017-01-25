package org.salesforce.oauth.integration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.salesforce.util.Cache;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		out.println("Welcome ");
		out.println("<h4>You are successfully Registered with SalesFDep using Salesforce oAuth<h4>");
		out.println("<html><body>");
		out.println("<form method=\"get\" action=\"deploy\">");
		
		out.println("Select source Org:");
		out.println("<select name=\"SourceOrgType\">");
		Map map1 = Cache.getMap();
		Iterator entries1 = map1.entrySet().iterator();
		while (entries1.hasNext()) {
			out.println("<option>");
			Map.Entry entry1 = (Map.Entry) entries1.next();
			String key = (String) entry1.getKey();
			out.println(key);
			out.println("</option>");
		}
		out.println("</select>");

		out.println("</p>");
		out.println("</p>");
		
		out.println("Select target Org:");
		out.println("<select name=\"TargetOrgType\">");
		Map map2 = Cache.getMap();
		Iterator entries2 = map2.entrySet().iterator();
		while (entries2.hasNext()) {
			out.println("<option>");
			Map.Entry entry1 = (Map.Entry) entries2.next();
			String key = (String) entry1.getKey();
			out.println(key);
			out.println("</option>");
		}
		out.println("</select>");
		out.println("</p>");
		out.println("</p>");
		
		out.println("<input type=\"submit\" name=\"deploy\"	value=\"deploy\" />");
		//out.println("<a href=\"display\">Click here to retrieve accounts from Salesforce via OAuth.</a>");
		out.println("</p>");
		out.println("</p>");
		out.println("List of orgs");
		
		out.println("<table border=\"1\">");
		
		out.println("<tr>");
		out.println("<th>Org Id (OrgName)</th>");
		out.println("<th>Access Token</th>");
		out.println("</tr>");
		
		Map map = Cache.getMap();

		Iterator entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			out.println("<tr>");
			out.println("<td>");
			out.println(key);
			out.println("</td>");
			out.println("<td>");
			out.println(value);
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</p>");
		out.println("</p>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
