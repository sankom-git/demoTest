package com.example.sankom.test.model.rest;

public class ResponseModel {
	UserModel usermodel;
	String token;

	public UserModel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(UserModel usermodel) {
		this.usermodel = usermodel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
