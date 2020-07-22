package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
@WebServlet("/poourl")
public class ConnPoolServlet extends HttpServlet {
	@Resource(name="DsJndi")
	private DataSource ds;
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		String tabName=null;
		ResultSetMetaData rsmd=null;
		int count=0;
		//general setting
		pw=resp.getWriter();
		resp.setContentType("text/html");
		//read data
		tabName=req.getParameter("table");
		//write business logic
		try {
			//get connection object from jdbc conn pool
			con=makeConnection();
			//create statement object
			st=con.createStatement();
			rs=st.executeQuery("select * from" +tabName);
			rsmd=rs.getMetaData();
			//print col names
			count=rsmd.getColumnCount();
			pw.println("<table border='1' bgcolor='red'>");
			pw.println("<tr bgcolor='cyan'>");
			for(int i=1;i<=count;i++) {
				pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
			}
			pw.println("</tr>");
			//process the  resultset
			while(rs.next()) {
				pw.println("<tr>");
				for(int i=1;i<=count;i++) {
					pw.println("<td>"+rs.getString(i)+"</td>");
				}
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("<br><a href='index.html'>Try Again</a>");
			//close jdbc obj
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e) {
			pw.println("<b><center>Internal Problem</center></b>");
			pw.println("<br><a href='index.html'>Try Again</a>");
		}
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	private Connection makeConnection() {
		Connection con=null;
		try {
			con=ds.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
