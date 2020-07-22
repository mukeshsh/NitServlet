package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpSearchServlet extends HttpServlet {
	   Connection con=null;
	   PreparedStatement ps=null;
	   private static final String Get_EMP_Details="SELECT EMPNO,ENAME,EADDR,ESAL FROM EMP WHERE EMPNO=?";
	  
	   public void init() {
			String driver=null,url=null,dbuser=null,password=null;
			try {
				//Access servletContext Object
				ServletContext sc=getServletContext();
				driver=sc.getInitParameter("driver");
				url=sc.getInitParameter("url");
				dbuser=sc.getInitParameter("dbuser");
				password=sc.getInitParameter("password");
				//register jdbc driver
				Class.forName(driver);
				//establish Connection
				con=DriverManager.getConnection(url, dbuser, password);
				//create preparedstatment
				ps=con.prepareStatement(Get_EMP_Details);
			}
			catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int no=0;
		ResultSet rs=null;
		RequestDispatcher rd=null,rd1=null,rd2=null;
		try {
			//include header content
			rd1=req.getRequestDispatcher("/headurl");
			rd1.include(req, res);
		
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<b><h3 style='color:cyan';text-align:center>Before Rising Exception</h3></b>");
		//read form data
		no=Integer.parseInt(req.getParameter("teno"));
		//set value
		ps.setInt(1, no);
		//execute the query
		rs=ps.executeQuery();
		//process the resultset
		if(rs.next()) {
			pw.println("<br>Emp no ::="+rs.getInt(1));
			pw.println("<br>Emp Name::="+rs.getString(2));
			pw.println("<br>Emp Address::="+rs.getString(3));
			pw.println("<br>Emp Salary::="+rs.getFloat(4));
		}
		else {
			pw.println("<b> Record not found</b>");
		}
		//add hyperlinks
		pw.println("<br> <br><a href='input.html'>Home</a>");
		//get Access to servletContext object
		//include footer content
		rd2=req.getRequestDispatcher("/footer.html");
		rd2.include(req, res);
		rs.close();
		pw.close();
	}
		catch(Exception e) {
		rd=req.getRequestDispatcher("/eurl");
		rd.forward(req, res);
		}
}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	public void destroy() {
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}

		
	}

}
