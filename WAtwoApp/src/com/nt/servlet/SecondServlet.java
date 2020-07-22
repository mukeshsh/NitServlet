package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		float val=0.0f;
		float cube=0.0f;
		pw=res.getWriter();
		res.setContentType("text/html");
		val=Float.parseFloat(req.getParameter("t1"));
		//Calculate cube
		cube=val*val*val;
		//display
		pw.println("<h1 style='color:red';text-align:center>SecondServlet:Cube::</center><h1>"+cube);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
