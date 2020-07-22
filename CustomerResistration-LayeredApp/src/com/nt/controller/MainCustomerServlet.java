package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerService;
import com.nt.service.CustomerServiceImpl;
import com.nt.vo.CustomerVO;

@WebServlet("/services")
public class MainCustomerServlet extends HttpServlet {
	private CustomerService service;
	public void init() {
		service=new CustomerServiceImpl();
	}
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cname=null,cadd=null,t1=null,t2=null,t3=null,orderid=null;
		PrintWriter pw=null;
		CustomerVO vo=null;
		CustomerDTO dto=null;
		String result=null;
		
		//get printwriter
		pw=res.getWriter();
		res.setContentType("text/html");
		
		//access form data
		cname=req.getParameter("cname");
		cadd=req.getParameter("cadd");
		t1=req.getParameter("t1");
		t2=req.getParameter("t2");
		t3=req.getParameter("t3");
		orderid=req.getParameter("orderid");
		
		//Strore form data into vo class object
		vo=new CustomerVO();
		vo.setCname(cname);
		vo.setCadd(cadd);
		vo.setT1(t1);
		vo.setT2(t2);
		vo.setT3(t3);
		vo.setOrderid(orderid);
		//vo ->dto
		dto=new CustomerDTO();
		dto.setCnmae(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setT1(Float.parseFloat(vo.getT1()));
		dto.setT2(Float.parseFloat(vo.getT2()));
		dto.setT3(Float.parseFloat(vo.getT3()));
		dto.setOrderid(Integer.parseInt(vo.getOrderid()));
		
		//use service
		
		try {
			result=service.registerCustomer(dto);
			pw.println("<h1 style='color:red;text-align:center'>"+result+"</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal problem:try Again</h1>");
			
		}
		pw.println("<br> <a href='customer_registration.html'>home</a>");
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	public void destroy() {
		service=null;
	}

}
