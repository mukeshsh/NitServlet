package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String  INSERT_QUERY="INSERT INTO HIDDEN_PER VALUES(PID_SEQ.NEXTVAL,?,?,?,?,?,?)";
	@Resource(name="DsJndi")
	private DataSource ds;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,ms=null;
		int age=0;
		String f2val1=null,f2val2=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1/req1 data... (session tracking)
		name=req.getParameter("hname");
		fname=req.getParameter("hfname");
		ms=req.getParameter("hms");
		age=Integer.parseInt(req.getParameter("hage"));
		//read  form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		try {
		//write jdbc code
			//get Pooled connection
		con=ds.getConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(INSERT_QUERY);
		//set quer param values
		ps.setString(1,name);
		ps.setString(2,fname);
		ps.setInt(3,age );
		ps.setString(4,ms);
		ps.setString(5,f2val1);
		ps.setString(6,f2val2);
		//execute the Query
		result=ps.executeUpdate();
		if(result==1)
			pw.println("<b> Registration Succeded</b>");
		}//try
		catch(SQLException se) {
		  se.printStackTrace();
		  pw.println("<b>Problem in Registration</b>");
		}
		finally {
			//close jdbc objs
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
		 //display dynamic web page having form1/req1 , form2/req2 data
		pw.println("<br> <br>form1/req1 data :::"+name+"...."+fname+" ..."+age+"..."+ms);
		pw.println("<br> <br>form2/req2 data :::"+f2val1+"...."+f2val2);
		//add hyperlink
		pw.println("<br><br> <a href='input.html'>home</a> ");
		//close stream
		pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)

}//class
