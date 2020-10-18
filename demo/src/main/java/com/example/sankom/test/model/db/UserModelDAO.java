package com.example.sankom.test.model.db;

public interface UserModelDAO {
   public UserModelDB  getUser(String userId) throws Exception;
   public boolean createUser(UserModelDB user) throws Exception;
}
