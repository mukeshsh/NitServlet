package com.nt.servive;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
       private EmployeeDAO dao;
       public EmployeeServiceImpl() {
		dao=new EmployeeDAOImpl();
	}
	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		int cnt=0;
		float gSalary=0.0f;
		float netSalary=0.0f;
		EmployeeBO bo=null;
		//b.logic
		gSalary=dto.getSalary()+(dto.getSalary()*0.4f);
		netSalary=gSalary-(gSalary*0.2f);
		//prepare bo class object having persistable data
		bo=new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setEadd(dto.getEadd());
		bo.setSalary(dto.getSalary());
		bo.setGrossSalary(gSalary);
		bo.setNetSalary(netSalary);
		//use dao
		cnt=dao.insert(bo);
		//process the result
		if(cnt==0)
			return "Employee Registration Faliled";
		else
			return "Employee Registration Succeded";
		
	}
}
