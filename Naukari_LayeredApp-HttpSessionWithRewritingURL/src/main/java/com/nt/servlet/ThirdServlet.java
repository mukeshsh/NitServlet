package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.JobSeekerDTO;
import com.nt.service.JobSeekerMgmtService;
import com.nt.service.JobSeekerMgmtServiceImpl;

@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
	
	private  JobSeekerMgmtService service=null;
	
	@Override
	public void init() throws ServletException {
	service=new JobSeekerMgmtServiceImpl();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String location=null,name=null,addrs=null,skills=null;
		int salary=0,age=0,exp=0;
		
		HttpSession ses=null;
		JobSeekerDTO dto=null;
		String result=null;
		
				
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form3/req3 data...
		location=req.getParameter("location");
		salary=Integer.parseInt(req.getParameter("salary"));
		//create  HttpSession object
		ses=req.getSession(false);
		//place form1/req1,form2/req2 data from Session attributes
		name=(String) ses.getAttribute("name");
		age=(int) ses.getAttribute("age");
		addrs=(String) ses.getAttribute("addrs");
		skills=(String) ses.getAttribute("skills");
		exp=(int)ses.getAttribute("exp");
		//prepare DTO class object
		dto=new JobSeekerDTO();
		dto.setJsName(name);
		dto.setAge(age);
		dto.setAddrs(addrs);
		dto.setSkills(skills);
		dto.setExperience(exp);
		dto.setLocation(location);
		dto.setExpSalary(salary);
		try {
		//use service
		result=service.registerJobSeeker(dto);
		pw.println("<h1 style='color:red;text-align:center'>"+result+"</h1>");
		
		}
		catch(Exception e) {
			pw.println("<h1 style='color:red;text-align:center'>Internal Problem</h1>");
			e.printStackTrace();
		}
		//invalidate the session
		ses.invalidate();
		//add hyperlink
		pw.println("<br> <a href='input.html'>home</a>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
