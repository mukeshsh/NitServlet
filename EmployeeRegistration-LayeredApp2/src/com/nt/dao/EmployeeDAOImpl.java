package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_EMPLOYEE="INSERT INTO LAYERED_EMPLOYEE VALUES(ENO_SEQ.NEXTVAL,?,?,?,?,?)";
	private Connection getPooledConnection()throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		//create initial context
		ic=new InitialContext();
		//get datasource object thorugh lookup operation
		ds=(DataSource) ic.lookup("DsJndi");
		//get pooled jdbc connection object
		con=ds.getConnection();
		return con;
	}

	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get pooled jdbc conn object
		con=getPooledConnection();
		//create prepared statement object
		ps=con.prepareStatement(INSERT_EMPLOYEE);
		//set values to query param
		ps.setString(1, bo.getEname());
		ps.setString(2, bo.getEadd());
		ps.setFloat(3, bo.getSalary());
		ps.setFloat(4, bo.getGrossSalary());
		ps.setFloat(5, bo.getNetSalary());
		//execute the query
		count=ps.executeUpdate();
		//close object
		con.close();
		ps.close();
		return count;
		
	}
}
