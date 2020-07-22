package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dburl")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public static final String prepare_Queries=("SELECT EMPNO ,ENAME,EADDR,ESAL FROM EMP WHERE EMPNO=?");
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public void init() {
		    
		try {
			//get access to servletconfig object
			ServletConfig cg=getServletConfig();
			//read init param values
			String s1=cg.getInitParameter("driver");
			String s2=cg.getInitParameter("dburl");
			String s3=cg.getInitParameter("dbuser");
			String s4=cg.getInitParameter("dbpwd");
			
			//create jdbc conn
			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);
			//create preparedStatement
			ps=con.prepareStatement(prepare_Queries);
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