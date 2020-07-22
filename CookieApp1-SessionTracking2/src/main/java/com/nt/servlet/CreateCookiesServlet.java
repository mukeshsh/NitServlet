package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createCookies")
public class CreateCookiesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		Cookie cookie1=null,cookie2=null,cookie3=null,cookie4=null;
		//create cookies
		cookie1=new Cookie("ap", "Amaravati");
		cookie2=new Cookie("TS", "Hyderabad");
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		cookie3=new Cookie("mh", "Mumbai");
		cookie4=new Cookie("up", "Lucknow");
		cookie3.setMaxAge(20);
		cookie4.setMaxAge(40);
		res.addCookie(cookie3);
		res.addCookie(cookie4);
		pw.println("<h1 style='color:red;text-align:center'>Cookies are added</h1>");
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
