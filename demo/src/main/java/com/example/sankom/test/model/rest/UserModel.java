package com.example.sankom.test.model.rest;

import java.math.BigDecimal;

public class UserModel {
	private String userName;
	private String address;
	private String province;
	private String zipcode;
	 
	private String refercode;
	private String classify;
	private String phoneno;
	private BigDecimal salary;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRefercode() {
		return refercode;
	}

	public void setRefercode(String refercode) {
		this.refercode = refercode;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	 

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", address=" + address + ", province=" + province + ", zipcode="
				+ zipcode + ", refercode=" + refercode + ", classify=" + classify + ", phoneno=" + phoneno + ", salary="
				+ salary + "]";
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	 

}
