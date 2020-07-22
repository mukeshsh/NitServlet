package com.nt.dto;

import java.io.Serializable;

public class JobSeekerDTO implements Serializable {

	private String JsName;
	private int age;
	private String addrs;
	private String skills;
	private String location;
	private int experience;
	private int expSalary;
	public String getJsName() {
		return JsName;
	}
	public void setJsName(String jsName) {
		JsName = jsName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getExpSalary() {
		return expSalary;
	}
	public void setExpSalary(int expSalary) {
		this.expSalary = expSalary;
	}
}
