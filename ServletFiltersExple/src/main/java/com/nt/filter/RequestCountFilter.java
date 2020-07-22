package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/check")
public class RequestCountFilter implements Filter {
	int counter=0;
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("RequestCountFilter.doFilter()");
		//count request
		counter++;
		//place request counter
		ServletContext sc=req.getServletContext();
		sc.setAttribute("reqCount", counter);
		System.out.println("RequestCounterFilter::Before doFilter(-,-)");
		chain.doFilter(req, res);
		System.out.println("RequestCounterFilter::After doFilter(-,-)");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void destroy() {
		
	}

}
