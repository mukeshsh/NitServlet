package com.nt.bo;

public class CustomerBO {
	private String cname;
	private String cadd;
	private float billAmt;
	private float discount;
	private float netAmt;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public float getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getNetAmt() {
		return netAmt;
	}
	public void setNetAmt(float netAmt) {
		this.netAmt = netAmt;
	}

}
