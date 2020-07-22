package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.MyRequest;
import com.nt.wrapper.MyResponse;

public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
     MyRequest mrequest=null;
     MyResponse mresponse=null;
     String output=null;
     PrintWriter pw=null;
     //create custom request
     mrequest=new MyRequest((HttpServletRequest)req);
     mresponse=new MyResponse((HttpServletResponse)res);
     chain.doFilter(req, res);
     output=mresponse.toString().toUpperCase();
     //add signature
     output=output+"HCL,Ameerpet";
     pw=res.getWriter();
     pw.println(output);
     
	}
	@Override
	public void destroy() {
		
	}

}
