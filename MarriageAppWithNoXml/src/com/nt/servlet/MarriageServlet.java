package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, 
			                          HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,gender=null;
		int age=0;
		
		//get PrintWriter
		pw=res.getWriter();
		// set response content type
		res.setContentType("text/html");
		//read form data...
		name=req.getParameter("pname");
		gender=req.getParameter("gender");
		age=Integer.parseInt(req.getParameter("page"));
		//write b.logic or req processing logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<21)
				 pw.println("<h1 style='color:red'>Mr. "+name+" u  r not elgible for Marriage .. Be Happy </h1>");
			else
				 pw.println("<h1 style='color:green'>Mr. "+name+" u  r elgible for Marriage .. But think Thrice becoz it is 60 years project </h1>");
		}
		else {
			if(age<18)
				 pw.println("<h1 style='color:red'>Miss. "+name+" u  r not elgible for Marriage .. Be Happy </h1>");
			else
				 pw.println("<h1 style='color:green'>Miss. "+name+" u  r  elgible for Marriage .. But think twice .  </h1>");
		}
		
		//add hyperlink
		pw.println("<br><br> <a href='form.html'>home</a>");
		
		pw.println("<br> req obj class name::"+req.getClass());
		pw.println("<br> res obj class name::"+res.getClass());
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}//doPost(-,-)
}//class
