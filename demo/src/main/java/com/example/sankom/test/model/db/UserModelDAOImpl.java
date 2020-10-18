package com.example.sankom.test.model.db;

public class UserModelDAOImpl implements UserModelDAO {

	@Override
	public UserModelDB getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("get User from "+userId);
		return new UserModelDB();
	}

	@Override
	public boolean createUser(UserModelDB user) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Create User"+user);
		return true;
	}

}
