package com.nt.initializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarriageServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {
	public void onStartup(java.util.Set<java.lang.Class<?>> set, ServletContext sc) throws ServletException{
	//create user-defined servlet class object
		MarriageServlet servlet=new MarriageServlet();
		//register witth container
		ServletRegistration.Dynamic dynamic=sc.addServlet("marriage", servlet);
		//enable loadon startup
		dynamic.setLoadOnStartup(0);
		//add url pattern
		dynamic.addMapping("/marriageurl");
	}

}
