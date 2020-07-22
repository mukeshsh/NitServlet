package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookDetailsBO;

public class BookSearchDAO  {
	
	private static final String GET_BOOKS_BY_QUERY=
			"SELECT BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLISHER,STATUS,CATEGORY FROM BOOK_DETAILS WHERE CATEGORY=?";
	
	private Connection getPooledConnection()throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		//get PooledConnection object
		ic=new InitialContext();
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
		con=ds.getConnection();
		return con;
	}

	public List<BookDetailsBO> findBooks(String category) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BookDetailsBO> listBO=null;
		BookDetailsBO bo=null;
		//get PooledConnection 
		con=getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(GET_BOOKS_BY_QUERY);
		//set param values
		ps.setString(1, category);
		//execute the query
		rs=ps.executeQuery();
		//copy ResultSet object records ListBO
		listBO=new ArrayList<BookDetailsBO>();
		while(rs.next()) {
			//copy record for ResultSet to BO class object
			bo=new BookDetailsBO();
			bo.setBookid(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setPrice(rs.getFloat(4));
			bo.setPublisher(rs.getString(5));
			bo.setStatus(rs.getString(6));
			bo.setCategory(rs.getString(7));
			//add bookBO objects to ListBO
			listBO.add(bo);
			
			}
		return listBO;
	}

}
