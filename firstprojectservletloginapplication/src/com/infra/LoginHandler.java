package com.infra;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandler extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("uname");
		String pwd = request.getParameter("upass");
		String email = request.getParameter("uemail");

		String str;
		if (name.equals("taruni") && pwd.equals("123")) {
			str = "Login Successful";
		} else {
			str = "Login not happend";
		}

		response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println(str);
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
