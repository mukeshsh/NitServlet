package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 pw.println("<html>");
		 pw.println("<body>");
		 pw.println("<font color='red' size='7'>");
		 pw.println("<b>");
		 pw.println("Welcome to WildFly Server through Eclipse IDE");
		 pw.println("</b>");
		 pw.println("</font>");
		 pw.println("</body>");
		 pw.println("</html>");
	}

	}


