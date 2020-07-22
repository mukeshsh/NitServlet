package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     PrintWriter pw=res.getWriter();
	     res.setContentType("text/html");
	     //read form data
	     String uname=req.getParameter("uname");
	     String pwd=req.getParameter("pwd");
	     System.out.println(uname+""+pwd);
	     if(uname.equalsIgnoreCase("raja@gmail.com")&&pwd.equals("rani")) {
	    	 pw.println("<h1 style='color:red'>Valid Credentials</h1>");
	     }
	     else{
	    	 pw.println("<h1 style='color:red'>InValid Credentials</h1>");
	     }
	     //add hyperLinks
	     pw.println("<a href='login.html'>Home</a>");
	     System.out.println("req obj class name"+req.getClass());
	     System.out.println("res object class name"+res.getClass());
	     //close stream
	     pw.close();
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
