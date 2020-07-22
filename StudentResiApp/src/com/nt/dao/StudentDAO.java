package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAO  {

	private static final String Student_Insert_Query="INSERT INTO STUDENT_TAB1 VALUES(?,?,?,?,?)";
	
	public int insert(StudentBO bo)  {
	     InitialContext ic=null;
	     DataSource ds=null;
	     Connection con=null;
	     PreparedStatement ps=null;
	     int result=0;
		try {
			//create initialcontext
			ic=new InitialContext();
			//get datasource object through lookup operation
			ds=(DataSource) ic.lookup("DsJndi");
			//get conn
			con=ds.getConnection();
			//CREATE preparedsta
			ps=con.prepareStatement(Student_Insert_Query);
			//set values
			ps.setInt(1, bo.getSno());
			ps.setString(2, bo.getSname());
			ps.setInt(3, bo.getTotal());
			ps.setFloat(4, bo.getAvg());
			ps.setString(5, bo.getResult());
			//execute query
			result=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
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
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
      return result;
	}
}
