package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.JobSeekerBO;

public class JobSeekerDAOImpl implements JobSeekerDAO {
	private static final String  INSERT_QUERY="INSERT INTO INFO_NAUKARI VALUES(JSID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	
	private Connection getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//get initialContext object
		ic= new InitialContext();
		//get dataSource object through lookup operation
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
		//get pooled connection
		con=ds.getConnection();
		return con;
		
	}
	@Override
	public int insert(JobSeekerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get pooled connection
		con=getPooledConnection();
		//create preparedStatement object
		ps=con.prepareStatement(INSERT_QUERY);
		//set values to query
		ps.setString(1,bo.getJsName());
		ps.setInt(2, bo.getAge());
		ps.setString(3,bo.getAddrs());
		ps.setString(4,bo.getSkills());
		ps.setString(5,bo.getLocation());
		ps.setInt(6, bo.getExperience());
		ps.setInt(7,bo.getExpSalary());
		//execute the Query
		count=ps.executeUpdate();
		return count;
	}

}