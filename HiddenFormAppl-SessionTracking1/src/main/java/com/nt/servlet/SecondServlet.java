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

@WebServlet("/s2url")
public class SecondServlet extends HttpServlet {
	@Resource(name="DsJndi")
	private DataSource ds;
	private static final String Insert_Query="INSERT INTO HIDDEN_PERSON VALUES(PID_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			PrintWriter pw=null;
			String whentomarry=null,whytomarry=null,spouse=null;
			int kidds,age=0;
			String name=null,fname=null,ms=null;
			Connection con=null;
			PreparedStatement ps=null;
			int result=0;
			//general settings
			pw=res.getWriter();
			res.setContentType("text/html");
			//read form1 data
			name=req.getParameter("hname");
			fname=req.getParameter("hfname");
			ms=req.getParameter("hms");
			age=Integer.parseInt(req.getParameter("hage"));
			//read form2 data
		      whentomarry=req.getParameter("whentomarry");
			whytomarry=req.getParameter("whytomarry");
			spouse=req.getParameter("spouse");
			kidds=Integer.parseInt(req.getParameter("kidds"));
						try {
				//pooled connection
				con=ds.getConnection();
				ps=con.prepareStatement(Insert_Query);
				//set param values
				ps.setString(1, name);
				ps.setString(2, fname);
				ps.setInt(3, age);
				ps.setString(4, ms);
				ps.setString(5, whentomarry);
				ps.setString(6, whytomarry);
				ps.setString(7, spouse);
				ps.setInt(8, kidds);
				//execute the query
				result=ps.executeUpdate();
				if(result==1)
					pw.println("<b>Registration is succeded</b>");
				else
					pw.println("<b>Registration is Failed</b>");
			}
			catch(SQLException se) {
				se.printStackTrace();
				pw.println("<b>Registration is failed</b>");
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
			pw.println("<br> <br>form2/req2 data :::"+whentomarry+"...."+whytomarry+"......"+spouse+"......"+kidds);
			//add hyperlink
			pw.println("<br><br> <a href='input.html'>home</a> ");
			//close stream
			pw.close();
}
		


	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
