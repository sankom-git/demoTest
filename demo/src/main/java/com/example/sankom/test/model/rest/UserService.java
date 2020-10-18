package com.example.sankom.test.model.rest;

public interface UserService {
	public abstract void createUser(UserModel user) throws Exception;
	public abstract UserModel getUser(String userId)throws Exception;
}
