package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1url")
public class FirstServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null,ms=null;
		int age=0;
			//general setting
			pw=res.getWriter();
			res.setContentType("text/html");
			//read form data
			pname=req.getParameter("pname");
			fname=req.getParameter("fname");
			ms=req.getParameter("ms");
			age=Integer.parseInt(req.getParameter("page"));
			//set not selected state of checkbox
			if(ms==null)
				ms="single";
			//generate form2 dynamically
			if(ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color:red;text-align:center'>Form2 provide martial life details::</h1>");
			pw.println("<form action='s2url'  method='POST'>");
			pw.println("<table>");
      	    pw.println(" <tr><td>Spouse name ::</td><td><input type='text' name='f2t1'></td></tr><br>");
      	    pw.println(" <tr><td>no.of kids ::</td><td><input type='text' name='f2t2'></td></tr><br>");
      	    pw.println(" <tr><td><input type='submit' value='submit'></td></tr>");
      	    pw.println("</table>");
      	    pw.println("</form>");
			}
			else {
				  pw.println("<h1 style='color:red;text-align:center'>Form2-Provide Bachelor life details::</h1>");
	        	  pw.println("<form action='s2url'  method='POST'>");
	        	  pw.println("<table>");
	        	  pw.println("<tr><td> when do u want to marry ::</td><td> <input type='text' name='f2t1'></td></tr><br>");
	        	  pw.println("<tr><td> why do u want to marry ::</td> <td><input type='text' name='f2t2'></td></tr><br>");
	        	  pw.println(" <tr><td><input type='submit' value='submit'></td></tr>");
	        	  pw.println("</table>");
	        	  pw.println("</form>");

			}
			//close stream
			pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
