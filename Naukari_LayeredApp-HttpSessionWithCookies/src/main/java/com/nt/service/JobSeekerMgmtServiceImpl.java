package com.nt.service;

import com.nt.bo.JobSeekerBO;
import com.nt.dao.JobSeekerDAO;
import com.nt.dao.JobSeekerDAOImpl;
import com.nt.dto.JobSeekerDTO;

public class JobSeekerMgmtServiceImpl implements JobSeekerMgmtService {
  
	private JobSeekerDAO dao=null;
	public JobSeekerMgmtServiceImpl() {
		dao=new  JobSeekerDAOImpl();
	}
	@Override
	public String registerJobSeeker(JobSeekerDTO dto) throws Exception {
		JobSeekerBO bo=null;
		int count=0;
	    //convert DTO to BO
		bo=new JobSeekerBO();
		bo.setJsName(dto.getJsName());
		bo.setAge(dto.getAge());
		bo.setAddrs(dto.getAddrs());
		bo.setSkills(dto.getSkills());
		bo.setLocation(dto.getLocation());
		bo.setExperience(dto.getExperience());
		bo.setExpSalary(dto.getExpSalary());
		//use DAO
		count=dao.insert(bo);
		if(count==0)
		     return "Registration Failed";
		else
			 return "Registration Succeded";
	}
}
