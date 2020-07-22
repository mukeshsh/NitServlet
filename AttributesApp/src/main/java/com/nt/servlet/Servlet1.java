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
import javax.servlet.http.HttpSession;

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		//create request attribute
		req.setAttribute("attr1", "val1");
		//create session attributes
		ses=req.getSession();
		ses.setAttribute("attr2", "val2");
		//create ServletContext attribute
		sc=getServletContext();
		sc.setAttribute("attr3", "value3");
		//forword the request to Servlet2 Component
		rd=req.getRequestDispatcher("/s2url");
		rd.forward(req, res);
		//close stream
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
