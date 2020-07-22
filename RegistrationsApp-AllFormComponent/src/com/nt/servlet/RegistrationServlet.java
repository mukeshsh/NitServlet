package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null,dob=null,time=null,addrs=null,ms=null,gender=null,qlfy=null,crs[]=null,hb[]=null,mail=null,color=null,url=null;
		 int age=0;
		 String month=null,week=null;
		 long mobileNo=0;
		//get PrintWrtier
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
	      //read form data
		 name=req.getParameter("pname");
		 age=Integer.parseInt(req.getParameter("page"));
		 gender=req.getParameter("gender");
		 addrs=req.getParameter("addrs");
		 ms=req.getParameter("ms");
		 if(ms==null)
			 ms="single";
		 dob=req.getParameter("dob");
		 qlfy=req.getParameter("qlfy");
		 crs=req.getParameterValues("courses");
		 if(crs==null)
			 crs=new String[] {"not joined courses"};
		 hb=req.getParameterValues("hb");
		   if(hb==null)
			   hb=new String[] {"i am baba --pari tyagi"};
		 mail=req.getParameter("mail");
		 url=req.getParameter("url");
		 mobileNo=Long.parseLong(req.getParameter("mobileNo"));
		 color=req.getParameter("color");
		 month=req.getParameter("month");
		 week=req.getParameter("week");
		 time=req.getParameter("time");
		 //write b.logic
		 if(gender.equalsIgnoreCase("M")) {
			 if(age<5)
				 pw.println("<h2 style='color:pink'>Master ::"+name+" u  r  baby boy</h2>");
			 else if(age<13)
				 pw.println("<h2 style='color:blue'>Master ::"+name+" u  r  little boy</h2>");
			 else if(age<20)
				 pw.println("<h2 style='color:cyan'>Mr ::"+name+" u  r  teenage boy</h2>");
			 else if(age<35)
				 pw.println("<h2 style='color:cyan'>Mr ::"+name+" u  r young man</h2>");
			 else if(age<50)
				 pw.println("<h2 style='color:cyan'>Mr ::"+name+" u  r middle-aged man</h2>");
			 else 
				 pw.println("<h2 style='color:cyan'>Mr ::"+name+" u  r Budda</h2>");
		 }
		 else {
			 if(age<5)
				 pw.println("<h2 style='color:pink'>Master ::"+name+" u  r  baby girl</h2>");
			 else if(age<13)
				 pw.println("<h2 style='color:blue'>Master ::"+name+" u  r  little girl</h2>");
			 else if(age<20) {
				 if(ms.equalsIgnoreCase("married")) {
				     pw.println("<h2 style='color:cyan'>Mrs ::"+name+" u  r  married teenage girl</h2>");
				 }
				 else {
					 pw.println("<h2 style='color:cyan'>Miss ::"+name+" u  r  teenage girl</h2>");
				 }
			 }
			 else if(age<35) {
				 if(ms.equalsIgnoreCase("married")) {
				     pw.println("<h2 style='color:maroon'>Mrs ::"+name+" u  r  married young woman</h2>");
				 }
				 else {
					 pw.println("<h2 style='color:maroon'>Miss ::"+name+" u  r  young womain</h2>");
				 }
			 }
			 else if(age<50) {
				 if(ms.equalsIgnoreCase("married")) {
				     pw.println("<h2 style='color:green'>Mrs ::"+name+" u  r  married middle-aged woman</h2>");
				 }
				 else {
					 pw.println("<h2 style='color:green'>Miss ::"+name+" u  r  middle-aged woman</h2>");
				 }
			 }
			 else { 
				 if(ms.equalsIgnoreCase("married")) {
				     pw.println("<h2 style='color:black'>Mrs ::"+name+" u  r  married old woman</h2>");
				 }
				 else {
					 pw.println("<h2 style='color:black'>Miss ::"+name+" u  r  old woman</h2>");
				 }
			 }
		 }//if
		 
		 //display form data....
		 pw.println("<h2> u have submitted the following form data.. </h2>");
		 pw.println("<b> name::"+name+"</b><br>");
		 pw.println("<b> age::"+age+"</b><br>");
		 pw.println("<b> gender::"+gender+"</b><br>");
		 pw.println("<b> addrs::"+addrs+"</b><br>");
		 pw.println("<b> marital status::"+ms+"</b><br>");
		 pw.println("<b> Qualification::"+qlfy+"</b><br>");
		 pw.println("<b> DOB::"+dob+"</b><br>");
		 pw.println("<b> Courses::"+Arrays.toString(crs)+"</b><br>");
		 pw.println("<b> Hobies::"+Arrays.toString(hb)+"</b><br>");
		 pw.println("<b> color::"+color+"</b><br>");
		 pw.println("<b> url::"+url+"</b><br>");
		 pw.println("<b> email::"+mail+"</b><br>");
		 pw.println("<b> mobileNo::"+mobileNo+"</b><br>");
		 pw.println("<b> Month::"+month+"</b><br>");
		 pw.println("<b> time::"+time+"</b><br>");
		 pw.println("<b> week::"+week+"</b><br>");
		 
		 pw.println("<br><br> <a href='register_form.html'><img src='images/home.jpg'></a>");
		 
		//close steam
		 pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      doGet(req,res);
	}

}
