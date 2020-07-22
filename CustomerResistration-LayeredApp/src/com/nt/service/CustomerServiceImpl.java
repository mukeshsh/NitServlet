package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dao.CustomerDAOImpl;
import com.nt.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO dao;
	public CustomerServiceImpl() {
		dao=new CustomerDAOImpl();
	}
	@Override
		public String registerCustomer(CustomerDTO dto) throws Exception {
		int cnt=0;
		float bAmt=0.0f;
		float discount=0.0f;
		float netAmt=0.0f;
		CustomerBO bo=null;
       
		//write b.logic
		bAmt=dto.getT1()+dto.getT2()+dto.getT3();
		if(bAmt>=50000) 
			discount=(bAmt*0.1f);
		    netAmt=bAmt-discount;
		    if (bAmt<50000)
			discount=(bAmt*0.05f);
		     netAmt=bAmt-discount;
		     //prepare BO class object having persistable data
		     bo=new  CustomerBO();
		     bo.setCname(dto.getCnmae());
		     bo.setCadd(dto.getCadd());
		     bo.setBillAmt(bAmt);
		     bo.setDiscount(discount);
		     bo.setNetAmt(netAmt);
		     //use dao
		     cnt=dao.insert(bo);
		     //result
		     if(cnt==0)
		    	 return "Customer registration Failed";
		     else
		    	 return "Customer registration Succede";
		}	
}
