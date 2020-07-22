package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InputFilterValidation implements Filter {
	public InputFilterValidation() {
		System.out.println("InputFilterValidation::0-param constructor");
	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("InputFilterValidation.init()");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("InputFilterValidation.doFilter(-,-,-)");
		PrintWriter pw=null;
		int val1=0,val2=0,val3=0,val4=0;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		val1=Integer.parseInt(req.getParameter("first"));
		val2=Integer.parseInt(req.getParameter("second"));
		val3=Integer.parseInt(req.getParameter("third"));
		val4=Integer.parseInt(req.getParameter("fourth"));
		//check inputs
		if(val1<0||val2<0||val3<0||val4<0) {
			pw.println("<h4 style='color:red;text-align:center'>Input must be possitive</h4>");
		}
		else {
			System.out.println("InputFilterValidation:before:doFilter()");
			chain.doFilter(req, res);
			System.out.println("InputFilterValidation:after:doFilter()");
		}
		pw.println("<a href=input.html>Home</a>");
	}
	@Override
	public void destroy() {
	System.out.println("InputFilterValidation.destroy()");	
	}
}
