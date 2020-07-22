package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    String name=null,fname=null,ms=null;
	    int age=0;
		//general settings
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read form1/req1  data
	    name=req.getParameter("pname");
	    fname=req.getParameter("pfname");
	    ms=req.getParameter("ms");
	    age=Integer.parseInt(req.getParameter("page"));
	    //generate  form2 dynamically from here based on marital status
	    if(ms.equalsIgnoreCase("married")) {
	    	pw.println("<h1 style='color:red;text-align:center'>Provide marital life details </h1>");
	    	pw.println("<form action='secondurl' method='POST'> ");
	    	pw.println(" Spouse name :: <input type='text' name='f2t1'><br>");
	    	pw.println("No.of kids :: <input type='text' name='f2t2'><br>");
	    	pw.println("<input type='hidden' name='hname' value="+name+">");
	    	pw.println("<input type='hidden' name='hfname' value="+fname+">");
	    	pw.println("<input type='hidden' name='hage' value="+age+">");
	    	pw.println("<input type='hidden' name='hms' value="+ms+">");
	    	pw.println("<input type='submit' value='submit'>");
	    	pw.println("</form>");
	    }
	    else {
	    	pw.println("<h1 style='color:red;text-align:center'>Provide Bachelor life details </h1>");
	    	pw.println("<form action='secondurl' method='POST'> ");
	    	pw.println("When do u want to marry :: <input type='text' name='f2t1'><br>");
	    	pw.println("why do u want to marry :: <input type='text' name='f2t2'><br>");
	    	pw.println("<input type='hidden' name='hname' value="+name+">");
	    	pw.println("<input type='hidden' name='hfname' value="+fname+">");
	    	pw.println("<input type='hidden' name='hage' value="+age+">");
	    	pw.println("<input type='hidden' name='hms' value="+ms+">");
	    	pw.println("<input type='submit' value='submit'>");
	    	pw.println("</form>");
	    }
	    //close
	    pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}//doPost(-,-)
}//class
