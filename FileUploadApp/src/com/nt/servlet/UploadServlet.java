package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;
@WebServlet("/upurl")
public class UploadServlet extends HttpServlet {
	@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			PrintWriter pw =null;
			MultipartFormDataRequest nreq=null;
			UploadBean upd=null;
			Hashtable ht=null;
			Enumeration <UploadFile>e=null;
			//general setting
			pw=res.getWriter();
			res.setContentType("text/html");
			try {
				//prepare special request object
				nreq=new MultipartFormDataRequest(req);
				//specify file uploading setting
				upd=new UploadBean();
				upd.setFolderstore("F:/store ");
				upd.setOverwrite(false);
				//complete file uploading
				upd.store(nreq);
				//display the names of uploaded files
				pw.println("<h1>The Upload Files are::</h1>");
				ht=nreq.getFiles();
				e=ht.elements();
				while(e.hasMoreElements()) {
					UploadFile file=(UploadFile) e.nextElement();
					pw.println("<br>"+file.getFileName()+" "+file.getFileSize()+file.getContentType());
				}
				}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doPost(req, res);
	}

}
