package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   String pval=null;
	   float val1=0.0f,val2=0.0f;
		// get PrintWriter 
	   pw=res.getWriter();
	   //set resposne content type
		res.setContentType("text/html");
		//read addtional req param value (s1)
		pval=req.getParameter("s1");
		//read form data
		if(!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")) {
  	         val1=Float.parseFloat(req.getParameter("t1"));
  	         val2=Float.parseFloat(req.getParameter("t2"));
		}
		//process the results
		if(pval.equalsIgnoreCase("add")) {
			pw.println("<h1 style='color:blue'> Sum ::: "+(val1+val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("sub")) {
			pw.println("<h1 style='color:blue'> Sub ::: "+(val1-val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("mul")) {
			pw.println("<h1 style='color:blue'> mul ::: "+(val1*val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("div")) {
			pw.println("<h1 style='color:blue'> div::: "+(val1/val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color:blue'> System properties::: "+System.getProperties()+"</h1>");
		}
		else {
			pw.println("<h1 style='color:blue'> System Date::: "+new Date()+"</h1>");
		}
		//add hyperlink
		pw.println("<br><a href='form.html'> home</a>");
		
		//close stream
		pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)

}
