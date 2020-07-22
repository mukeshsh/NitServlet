package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/s3url")
public class ThirdServlet extends HttpServlet {
	

	private static final String INSERT_QUERY="INSERT INTO JOBSEEKER_INFO VALUES(JSID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	/*@Resource(name="Dsjndi")
	private DataSource ds;*/
	
	Connection  con=null;PreparedStatement ps=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String expCity=null;
		int expSalary=0;
		HttpSession ses=null;
		String name=null,addr=null,skills=null;
		int age,experience=0;
		int count=0;
		//general setting
		res.getWriter();
		res.setContentType("text/html ");
		//read form3 data
		expCity=req.getParameter("city");
		expSalary=Integer.parseInt(req.getParameter("salary"));
		//access to session object from session object
		ses=req.getSession(false);
		//read form1 and form2 data
	    name=(String) ses.getAttribute("name");
		addr=(String) ses.getAttribute("addr");
		experience=(int)ses.getAttribute("experience");
		skills=(String)ses.getAttribute("skills");
		age=(int)ses.getAttribute("age");
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "class");
		ps=con.prepareStatement(INSERT_QUERY);
		//SEt values to query
		ps.setString(1, name);
		ps.setString(2, addr);
		ps.setInt(3, age);
		ps.setLong(4, experience);
		ps.setString(5, skills);
		ps.setString(6,expCity );
		ps.setLong(7, expSalary);
		
		count=ps.executeUpdate();
		System.out.println("hello");
		//invalidate the session
		ses.invalidate();
		if(count>0) {
			pw.println("<body bgcolor=cyan>");
			//pw.println("<h1 style='color:red;text-align:center'>Record Inserted Successfully</h1>");
			pw.println("<a href='input.html'>Home</a>");
			
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Record Not Inserted </h1>");
			pw.println("<a href='input.html'>Home</a>");
		
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		pw.println("<h1 style='color:red;text-align:center'>Internal Problem::</h1>");
		pw.println("<a href='input.html'>Home</a>");
	}
	}
     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	
}
