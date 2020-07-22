package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
	
	  public String generateResult(StudentDTO dto)  {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentDAO dao=null;
		StudentBO bo=null;
		int count=0;
		//b.logic
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35) 
			result="fail";
			else
				result="pass";
		//prepare bo class object
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use dao
		dao=new StudentDAO();
		count=dao.insert(bo);
		if(count==0)
			return "Registration Failed";
		else
			return " Registration Succeded and Result"+result;
		}
	}

