package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			PrintWriter pw=null;
			String ss=null;
			String engine=null;
			String url=null;
			//general setting
			pw=res.getWriter();
			res.setContentType("text/html");
			//form data
			ss=req.getParameter("ss");
			engine=req.getParameter("engine");
			//prepare url with query String for send redirection
			
			if(engine.equalsIgnoreCase("google")) {
				url="https://www.google.com/search?q="+ss;
			}
			else if(engine.equalsIgnoreCase("yahoo")) {
				url="https://in.search.yahoo.com/search;_ylt="+ss;
			}
			else if(engine.equalsIgnoreCase("ask")) {
				url="https://www.search.ask.com/web?="+ss;
			}
			else if(engine.equalsIgnoreCase("bing")) {
				url="https://www.bing.com/search?q="+ss;
			}
			System.out.println("Before searchServlet:sendRedirect(-)");
			res.sendRedirect(url);
			RequestDispatcher rd=req.getRequestDispatcher("/search.html");
			rd.include(req, res);
			System.out.println("After SearchServlet:sendRedirect");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
