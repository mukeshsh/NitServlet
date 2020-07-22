package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null;
		int age=0;
		HttpSession ses=null;
				
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1/req1 data...
		name=req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		addrs=req.getParameter("addrs");
		//create  HttpSession object
		ses=req.getSession(true);
		//place form1/req1 data as settion attribute values
		ses.setAttribute("name",name);
		ses.setAttribute("age",age);
		ses.setAttribute("addrs",addrs);
		//Generate form2 dynamically from here
		pw.println("<body bgcolor='lightyellow'>");
		pw.println("<h1 style='color:red;text-align:center'>Naukri.com Registration Page2 </h1>");
		pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
		pw.println("<table>");
		 pw.println("<tr><td>Skills :::</td><td><input type='text' name='skills'></td></tr>");
		 pw.println("<tr><td>Experience :::</td><td><input type='text' name='exp'></td></tr><br>");
		pw.println("<tr><td><input type='submit' value='continue'></td></td>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
