package com.example.sankom.test.model.db;

import java.math.BigDecimal;
import java.sql.Date;

public class UserModelDB {
	private String userName;
	private String address;
	private String province;
	private String zipcode;
	private String password;
	private Date createDate;
	private Date updateDate;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "UserModelDB [userName=" + userName + ", address=" + address + ", province=" + province + ", zipcode="
				+ zipcode + ", password=" + password + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", refercode=" + refercode + ", classify=" + classify + ", phoneno=" + phoneno + ", salary=" + salary
				+ "]";
	}

	 

}
