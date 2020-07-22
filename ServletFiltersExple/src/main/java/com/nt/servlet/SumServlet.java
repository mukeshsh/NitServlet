package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/*")
public class SumServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SumServlet.doGet()");
		PrintWriter pw=null;
		int val1=0,val2=0,val3=0,val4=0,sum=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		val1=Integer.parseInt(req.getParameter("first"));
		val2=Integer.parseInt(req.getParameter("second"));
		val3=Integer.parseInt(req.getParameter("third"));
		val4=Integer.parseInt(req.getParameter("fourth"));
		//perform results
		sum=val1+val2+val3+val4;
		//display results
		pw.println("<h1 style='color:red;text-align:center'> Result::"+sum+"<h1>");
		pw.println("<a href='input.html'>Home</h1>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
