package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private final String userID="admin";
	private final String password="password";
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String user=null,pwd=null;
		HttpSession session=null;
		Cookie userName=null;
		RequestDispatcher rd=null;
		//general Settings
		pw=res.getWriter();
		res.setContentType("text/html");
		user=req.getParameter("user");
		pwd=req.getParameter("pwd");
		//conditional Statement
		if(userID.equals(user)&&password.equals(pwd)) {
			session=req.getSession();
			session.setAttribute("user","Mukesh1");
			//session setting
			session.setMaxInactiveInterval(30*60);
			userName=new Cookie("user", user);
			userName.setMaxAge(30*60);
			res.addCookie(userName);
			res.sendRedirect("LoginSuccess.jsp");
		}
		else {
			rd = getServletContext().getRequestDispatcher("/input.html");
			PrintWriter out= res.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(req, res);
		}
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
