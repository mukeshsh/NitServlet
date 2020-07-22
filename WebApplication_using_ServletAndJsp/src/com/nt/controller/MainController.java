package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDetailsDTO;
import com.nt.service.BookSearchService;


@WebServlet("/controller")
public class MainController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String category=null;
		String source=null;
		BookSearchService service=null;
		List<BookDetailsDTO>listDTO=null;
		RequestDispatcher rd=null;
		//read form data
		category=req.getParameter("category");
		source=req.getParameter("source");
		//use service class
		service=new BookSearchService();
		try {
			listDTO=service.search(category);
		}
			catch(Exception e) {
				rd=req.getRequestDispatcher("/err.jsp");
				rd.forward(req, res);
				return;
			}
			//keep listDTO in request attribute
			req.setAttribute("booksList", listDTO);
			//forword request
			//based on button
			if(source.equalsIgnoreCase("html")) {
				rd=req.getRequestDispatcher("/html_screen.jsp");
			}
			else {
				rd=req.getRequestDispatcher("/excel_screen.jsp");
			}
			rd.forward(req, res);
		}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
  
}
