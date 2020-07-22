//EmpSearchServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;  //jdbc api
import java.io.*; 

public  class empSearchServlet extends  HttpServlet
{  private static final String  GET_STD_DETAILS="SELECT SNO,SNAME,SADD,SAVG FROM STUDENT WHERE SNO=?";

	public void doGet(HttpServletRequest req,
		                                  HttpServletResponse res)throws ServletException,IOException{
		 PrintWriter pw=null;
		 int sno=0;
		 Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 try{
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		sno=Integer.parseInt(req.getParameter("sno"));
		
		//Load jdbc driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","class");
		//create Jdbc PreparedStatement object
		ps=con.prepareStatement(GET_STD_DETAILS);
		//set query param value
		ps.setInt(1,sno);
		//send and execute Query
          rs=ps.executeQuery();
		  //process the ResultSet
		  if(rs.next()){
			    pw.println("<h3 style='color:red;text-align:center'>Emp Details are   :: </h3>");
				pw.println("<br><b> Sno number ::"+rs.getInt(1)+"</b>");
				pw.println("<br><b> Student name ::"+rs.getString(2)+"</b>");
				pw.println("<br><b> Student Address ::"+rs.getString(3)+"</b>");
				pw.println("<br><b> Student Average ::"+rs.getFloat(4)+"</b>");
		  }
		 }//try
		
		 catch(Exception e){
            RequestDispatcher rd=req.getRequestDispatcher("/errorurl");
            rd.forward(req, res);
		 }//catch
		 finally{
			 //close jdbc objs
			 try{
				 if(rs!=null)
					   rs.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }

			 try{
				 if(ps!=null)
					   ps.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }

			 try{
				 if(con!=null)
					   con.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }
		 }//finally
      }//doGet(-,-)

	  public void doPost(HttpServletRequest req,
		                                     HttpServletResponse res)throws ServletException,IOException{
		  doGet(req,res);
	  }//doPost(-,-)

}//class