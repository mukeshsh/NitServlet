package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public class CustomerDAOImpl implements CustomerDAO {
	private static final String INSERT_CUST_QUERY="INSERT INTO LAYERED_CUSTOMER1 VALUES(CNO_SEQ.NEXTVAL,?,?,?,?,?)";
	
	
	
	private Connection getPooledConnection()throws Exception{
	Connection con=null;
	InitialContext ic=null;
	DataSource ds=null;
	
	ic=new InitialContext();
	ds=(DataSource) ic.lookup("DsJndi");
	con=ds.getConnection();
	return con;
	}
	@Override
	public int insert(CustomerBO bo) throws Exception {
		
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//GET POOLED JDBC CONN
		con=getPooledConnection();
		//create prepare statement
		ps=con.prepareStatement(INSERT_CUST_QUERY);
		//set values
		ps.setString(1, bo.getCname());
		ps.setString(2, bo.getCadd());
		ps.setFloat(3, bo.getBillAmt());
		ps.setFloat(4, bo.getDiscount());
		ps.setFloat(5, bo.getNetAmt());
		//execute the query
		count=ps.executeUpdate();
		//close obj
		ps.close();
       con.close();
       return count;
	}

}
