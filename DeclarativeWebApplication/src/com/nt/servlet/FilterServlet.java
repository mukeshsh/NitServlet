package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("page successfully displayed::");
		pw.println("<h1 style='color:red,text-align:center'>"+req.getRemoteUser()+"<h1>");
		pw.println("<h1 style='color:red,text-align:center'>"+req.getAuthType()+"<h1>");
		//close stream
		pw.close();
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
