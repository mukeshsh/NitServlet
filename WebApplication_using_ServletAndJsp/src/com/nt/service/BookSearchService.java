package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookDetailsBO;
import com.nt.dao.BookSearchDAO;
import com.nt.dto.BookDetailsDTO;

public class BookSearchService  {
	public List<BookDetailsDTO> search(String category) throws Exception {
     BookSearchDAO dao=null;
     List<BookDetailsBO> listBO=null;
     List<BookDetailsDTO> listDTO=null;
     BookDetailsDTO dto=null;
     //use dao
       dao=new BookSearchDAO();
		listBO=dao.findBooks(category);
		//convert list bo to listDTO
		listDTO=new ArrayList<BookDetailsDTO>();
		for(BookDetailsBO bo:listBO) {
			//copy each BO object to each DTO Objects
			dto=new BookDetailsDTO();
			dto.setBookid(bo.getBookid());
			dto.setBookName(bo.getBookName());
			dto.setAuthor(bo.getAuthor());
			dto.setPrice(Math.round(bo.getPrice()));
			dto.setPublisher(bo.getPublisher());
			dto.setStatus(bo.getStatus());
			dto.setCategory(bo.getCategory());
			//add DTO class object to List Collection
			listDTO.add(dto);
		}
		return listDTO;
	}

}
