package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/showCookies")
public class ShowCookiesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		Cookie cookies[]=null;
		//read and display cookies
		cookies=req.getCookies();
		if(cookies!=null) {
			pw.println("<table>");
			for(Cookie ck:cookies) {
				pw.println("<tr>");
				 pw.println("<td>"+ck.getName()+"</td>");
				 pw.println("<td>"+ck.getValue()+"</td>");
				 pw.println("</tr>");
			}
			pw.println("</table>");
		}
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
