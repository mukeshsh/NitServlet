package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2url")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	String f2val1=null,f2val2=null;
	String pname=null,fname=null,ms=null;
	String age=null;
		//general setting
	pw=res.getWriter();
	res.setContentType("text/html");
	//read form2 data
	f2val1=req.getParameter("f2t1");
	f2val2=req.getParameter("f2t2");
	//read form1 data
	pname=req.getParameter("pname");
	fname=req.getParameter("fname");
	ms=req.getParameter("ms");
	age=req.getParameter("page");
	//display form1 and form2 data
	pw.println("<br><b><i> form1/req1 data ::"+pname+".. "+fname+".. "+ms+".. "+age+"</b></i>");
	pw.println("<br><b><i> form2/req2 data ::"+f2val1+".. "+f2val2+"</b></i>");
	pw.println("<br> <a href='input.html'>home</a>");
	pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
