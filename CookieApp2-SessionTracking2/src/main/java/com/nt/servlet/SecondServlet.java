package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/s2url")
public class SecondServlet extends HttpServlet {
	private static final String INSERT_QUERY="INSERT INTO COOKIE_PERSON VALUES(PID_SEQ.NEXTVAL,?,?,?,?,?)";
	@Resource(name="DsJndi")
      private DataSource ds;	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
		PrintWriter pw=null;
		int income=0,tax=0;
		Cookie cks[]=null;
		String name=null,fname=null;
		int age=0;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2 data
		income=Integer.parseInt(req.getParameter("income"));
		tax=Integer.parseInt(req.getParameter("tax"));
		//read form1 data from cookies
		cks=req.getCookies();
		if(cks!=null) {
			name=cks[0].getValue();
			fname=cks[1].getValue();
			age=Integer.parseInt(cks[2].getValue());
		}
		try {
			//write form1 and form2 data to database table
			//connection pool
			con=ds.getConnection();
			//Create preparedStatement object
			ps=con.prepareStatement(INSERT_QUERY);
			//set values to query param
			ps.setString(1, name);
			ps.setString(2, fname);
			ps.setInt(3, age);
			ps.setInt(4, income);
			ps.setInt(5, tax);
			//execute the query
			result=ps.executeUpdate();
			if(result==0) {
				pw.println("<h1 style='color:red;text-align:center'>Registration Failed::</h1>");
			}
			else {
				pw.println("<h1 style='color:green;text-align:center'>Registration Succeded::</h1>");
			}

		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Registration Failed::</h1>");
		}
		finally {
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
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		//display form1/req1 and form2/req2 data as web page content
	    pw.println("<br> form1/req1 data ::"+name+" ...."+fname+"....."+age);
	    pw.println("<br> form2/req2 data ::"+income+" ...."+tax);
	    //add HyperLinks
	    pw.println("<a href='input.html'>home</a>");
	//close stream
	    pw.close();

	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
