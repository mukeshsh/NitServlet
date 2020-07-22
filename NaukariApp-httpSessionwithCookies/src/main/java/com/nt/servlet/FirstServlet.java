package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s1url")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addr=null;
		HttpSession ses=null;
		int age=0;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		//form1 data
		name=req.getParameter("name");
		addr=req.getParameter("addr");
		age=Integer.parseInt(req.getParameter("age"));
		//create session for browser windows
		ses=req.getSession(true);
		//form1 data in session attribute
		ses.setAttribute("name", name);
		ses.setAttribute("addr", addr);
		ses.setAttribute("age", age);
		//generate form2 dynamically
		pw.println("<body bgcolor='lightyellow'>");
		pw.println("<h1 style='color:red;text-align:center'>Provide Your Experience and Skills</h1>");
		pw.println("<form action='s2url' method='post'>");
		pw.println("<table>");
		pw.println("<b><tr><td>Enter Number of Year exp::</td><td><input type='text' name='experience'></td></tr><br>");
		pw.println("<b><tr><td>Select Skills::</td><td><select name='skills'>");
		pw.print("<option value=java>JAVA/J2SE</option value>");
		pw.print("<option value=.NET>.Net</option value>");
		pw.print("<option value=ORACLE>oracle 11g</option value>");
		pw.print("<option value=ANGULAR>Angular</option value>");
		pw.println("</td></tr>");
	    pw.println("<b><tr><td><input type='submit' value='continue'></td></tr>");
	    pw.println("</table>");
	    pw.println("</form>");
	    pw.println("</body>");
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
