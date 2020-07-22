package com.nt.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	private String cnmae;
	private String cadd;
	private float t1,t2,t3;
	private int orderid;
	public String getCnmae() {
		return cnmae;
	}
	public void setCnmae(String cnmae) {
		this.cnmae = cnmae;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public float getT1() {
		return t1;
	}
	public void setT1(float t1) {
		this.t1 = t1;
	}
	public float getT2() {
		return t2;
	}
	public void setT2(float t2) {
		this.t2 = t2;
	}
	public float getT3() {
		return t3;
	}
	public void setT3(float t3) {
		this.t3 = t3;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

}
