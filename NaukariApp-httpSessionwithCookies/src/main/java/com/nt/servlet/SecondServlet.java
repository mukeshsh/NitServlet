package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s2url")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 
		PrintWriter pw=null;
		String skills=null;
		int experience=0;
		HttpSession ses=null;
       
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		//get form2 data
		experience=Integer.parseInt(req.getParameter("experience"));
		skills=req.getParameter("skills");
		//create session for browser windows
		ses=req.getSession(false);
		//form2 data in session tracking
		ses.setAttribute("experience", experience);
		ses.setAttribute("skills", skills);
		//generate form3 dynamically
		pw.println("<body bgcolor='lightyellow'>");
		pw.println("<h1 style='color:red;text-align:center'>Provide expected city and salary</h1>");
		pw.println("<form action='s3url' method ='post'>");
		pw.println("<table>");
		pw.println("<b><tr><td>Enter Expected locations::</td><td><input type='text' name='city'></td></tr><br>");
		pw.println("<b><tr><td>Enter Expected Salary ::</td><td><input type='text' name='salary'></td></tr><br>");
		pw.println("<tr><td><input type='submit' name='continue'></td></tr><br>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
