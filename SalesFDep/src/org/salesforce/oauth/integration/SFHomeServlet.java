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
import org.salesforce.util.TokenRepoUtil;

@WebServlet("/sfhome")
public class SFHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SFHomeUrl="https://na16.salesforce.com/home/home.jsp"; 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Heloooooooo");
		TokenRepoUtil.getInstance().listTokens();
		response.sendRedirect(SFHomeUrl);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
