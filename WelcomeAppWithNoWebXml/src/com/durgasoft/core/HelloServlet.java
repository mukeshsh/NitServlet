package com.durgasoft.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
	 PrintWriter pw=response.getWriter();
	 pw.println("<html>");
	 pw.println("<body>");
	 pw.println("<font color='red' size='7'>");
	 pw.println("<b>");
	 pw.println("Welcome to Weblogic Server through Eclipse IDE");
	 pw.println("</b>");
	 pw.println("</font>");
	 pw.println("</body>");
	 pw.println("</html>");
	 
	 
	 
	}

}
