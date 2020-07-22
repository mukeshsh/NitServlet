package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("LcTestServlet.static block");
	}
	public LcTestServlet() {
		System.out.println("LcTestServlet: 0 parameter constructer");
	}
	public void init(ServletConfig cg) {
		System.out.println("LcTestServlet.init(ServletConfig cg)");
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("LcTestServlet.service(-,-)");
		//set response type
		response.setContentType("text/html");
		//get PrintWriter object
		PrintWriter pw=response.getWriter();
		//write response 
		Date d=new Date();
		pw.println("<b><i><center>Date and Time is"+d+" </center></i></b>");
		//close stream
		pw.close();
	}//service
	public void destroy() {
	 System.out.println("LcTestServlet.destroy()");
		
	}

}
