package com.example.sankom.test.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UserModelDAOImpl implements UserModelDAO {

	@Override
	public UserModelDB getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("get User from "+userId);
		Connection conn=this.getConnection();
		System.out.println("conn"+conn);
		 Statement stmt = null;
		   try{
			   String sql = "SELECT  'TEST ' ";
			   stmt = conn.createStatement();
			   stmt.executeQuery(sql);
			   
			   ResultSet rs = stmt.executeQuery(sql);
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
//			         int id  = rs.getInt("id");
//			         int age = rs.getInt("age");
//			         String first = rs.getString("first");
//			         String last = rs.getString("last");
			    	  String data=rs.getString(1);
			    	  System.out.println("Data "+data);

			         //Display values
//			         System.out.print("ID: " + id);
//			         System.out.print(", Age: " + age);
//			         System.out.print(", First: " + first);
//			         System.out.println(", Last: " + last);
			      }
			      rs.close();
			   
		   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
		
		//System.out.println("Create User"+user);
		return new UserModelDB();
	}

	@Override
	public boolean createUser(UserModelDB user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		System.out.println("conn"+conn);
		 Statement stmt = null;
		   try{
			   String sql = "SELECT  'TEST ' ";
			   stmt = conn.createStatement();
			   stmt.executeQuery(sql);
			   
			   ResultSet rs = stmt.executeQuery(sql);
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
//			         int id  = rs.getInt("id");
//			         int age = rs.getInt("age");
//			         String first = rs.getString("first");
//			         String last = rs.getString("last");
			    	  String data=rs.getString(1);
			    	  System.out.println("Data "+data);

			         //Display values
//			         System.out.print("ID: " + id);
//			         System.out.print(", Age: " + age);
//			         System.out.print(", First: " + first);
//			         System.out.println(", Last: " + last);
			      }
			      rs.close();
			   
		   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
		
		System.out.println("Create User"+user);
		return true;
	}
	
	private Connection getConnection()  throws Exception{
		String url = "jdbc:postgresql://localhost/exam";
		Properties props = new Properties();
		props.setProperty("user","postgres_user1");
		props.setProperty("password","password");
		//props.setProperty("ssl","true");
		Connection conn = DriverManager.getConnection(url, props);
		return conn;
		
	}

}
