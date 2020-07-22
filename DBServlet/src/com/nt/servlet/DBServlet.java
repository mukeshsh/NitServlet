package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public void init() {
		    
		try {
			//register jdbc connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "class");
			//create jdbc preparedStatement
			ps=con.prepareStatement("SELECT EMPNO,ENAME,EADDR,ESAL FROM EMP WHERE EMPNO=?");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=null;
		try {
			//general setting
			pw=resp.getWriter();
			resp.setContentType("text/html");
			//read form data
			int id=Integer.parseInt(req.getParameter("eid"));
			//set param values to sql queris
			ps.setInt(1, id);
			//exceute the sql queries
			rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("<br> Employee Number"+rs.getInt(1));
				pw.println("<br>Employee name "+rs.getString(2));
				pw.println("<br> Employee Address"+rs.getString(3));
				pw.println("<br>Employee salary"+rs.getFloat(4));
			}
				else {
					pw.println("<br> No employee found");
				}
			}
			
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	public void destroy() {
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se1) {
			se1.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se2) {
			se2.printStackTrace();
		}
	}
}