package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   PrintWriter pw=null;
		   float val=0.0f;
			//general setting
		   pw=res.getWriter();
		   res.setContentType("text/html");
		   //read form data
		    val=Float.parseFloat(req.getParameter("t1"));
		    //Calculate Square
		  float  square=val*val;
		    pw.println("<h1 style='color:blue';text-align:center>FirstServlet:Square::</center><h1>"+square);
		    //include the response SecondServlet component
		    //GET SERVLETCONTEXT OBJECT FOR FIRST SERVLET
		    ServletContext sc1=getServletContext();
		    //getservlet context for secondsevlet
		    ServletContext sc2=sc1.getContext("/WAtwoApp");
		    //get requestDispather object ponting to Secondservlet
		    RequestDispatcher rd=sc2.getRequestDispatcher("/secondurl");
		    rd.include(req, res);
		    //close stream
		    pw.close();
		   
	}
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
