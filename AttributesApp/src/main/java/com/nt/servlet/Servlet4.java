package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		//read and display request attribute value
		pw.println("<br>Servlet4:attr1 attribute value "+req.getAttribute("attr1"));
		//read and display session request attribute value
		ses=req.getSession();
		pw.println("<br>Servlet4:attr2  Session attribute value"+ses.getAttribute("attr2"));
		//read and display servletContext  attribute
		sc=getServletContext();
		pw.println("<br>Servlet4:attr4 Context attribute value"+sc.getAttribute("attr3"));
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
