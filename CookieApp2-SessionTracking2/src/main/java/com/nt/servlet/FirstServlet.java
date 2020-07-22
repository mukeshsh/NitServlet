package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1url")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=null;
	 String name=null,fname=null;
	 int age=0;
	 Cookie ckName=null,ckFname=null,ckAge=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		//form data
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		age=Integer.parseInt(req.getParameter("age"));
		//add form1 data to Inmemory metadata
		ckName=new Cookie("cname", name);
		ckFname=new Cookie("cfname", fname);
		ckAge=new Cookie("cage", String.valueOf(age));
		res.addCookie(ckName);
		res.addCookie(ckFname);
		res.addCookie(ckAge);
		//generate form2 dynamically
		pw.println("<body bgcolor='cyan'>");
		pw.println("<br><h1 style='color:red;text-align:center'>Form2 --Income Tax Details </h1>");
		 pw.println("<form action='s2url'  method='POST'>");
		 pw.println("<table>");
		 pw.println("<b> <tr><td>Income ::: </td><td> <input type='text' name='income'></td></tr><br>");
		 pw.println("<b><tr><td> Tax ::: </td><td> <input type='text' name='tax'></td></tr><br>");
		 pw.println("<b><tr><td> <input type='submit'  value='submit'></td></tr>");
		 pw.println("</table>");
		 pw.println("</form>");
		 pw.println("</body>");
		 //clsoe stream
		 pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
