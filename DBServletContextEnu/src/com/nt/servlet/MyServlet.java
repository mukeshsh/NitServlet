package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletContext context=null;
		pw=response.getWriter();
		response.setContentType("text/html");
		context=getServletConfig().getServletContext();
		String LogicalName=context.getInitParameter("a");
		String a=context.getInitParameter("a");
		String b=context.getInitParameter("b");
		Enumeration e=context.getInitParameterNames();
		context.setAttribute("c", "cat");
		context.setAttribute("d", "dog");
		pw.println("<html><body><h1><br>");
		pw.println("Logical Names  ::"+LogicalName);
		pw.println("<br>");
		pw.println("a for.... "+a);
		pw.println("<br>");
		pw.println("b for ..."+b);
		pw.println("<br>");
		while(e.hasMoreElements()) {
			pw.println(e.nextElement()+"<br>");
		}
			pw.println("c for ...."+context.getAttribute("c"));
			pw.println("<br>");
			pw.println("d for ..."+context.getAttribute("d"));
			pw.println("<br>");
			e=context.getAttributeNames();
		while(e.hasMoreElements()) {
			pw.println(e.nextElement()+"<br>");
		}
		pw.println("</h1></body></html>");
		}
		
	}


