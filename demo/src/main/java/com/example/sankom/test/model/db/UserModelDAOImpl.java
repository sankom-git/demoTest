package com.example.sankom.test.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Properties;

public class UserModelDAOImpl implements UserModelDAO {

	@Override
	public UserModelDB getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("get User from "+userId);
		Connection conn=this.getConnection();
		System.out.println("conn"+conn);
		 Statement stmt = null;
		 UserModelDB result=null;
		   try{
			   String sql = "SELECT username, address, province, zipcode, \"password\", create_date, update_date, refercode, classify, phoneno, salary"
			   		+ " FROM public.register_users "
			   		+ " where username=? ";
			   PreparedStatement pstmt  = conn.prepareStatement(sql);
			   pstmt.setString(1,userId);
			   pstmt.executeQuery();
			   ResultSet rs = pstmt.executeQuery();
			      
			      if(rs.next()){
			    	  result=new UserModelDB();
			    	  result.setUserName(rs.getString(1));
			    	  result.setAddress(rs.getString(2));
			    	  result.setProvince(rs.getString(3));
			    	  result.setZipcode(rs.getString(4));
			    	  
			    	  result.setPassword(rs.getString(5));
			    	  result.setCreateDate(rs.getDate(6));
			    	  result.setUpdateDate(rs.getDate(7));
			    	  result.setRefercode(rs.getString(8));
			    	  result.setClassify(rs.getString(9));
			    	  result.setPhoneno(rs.getString(10));
			    	  result.setSalary(rs.getBigDecimal(11));
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
		return result;
	}

	@Override
	public boolean createUser(UserModelDB user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		System.out.println("conn"+conn);
		 Statement stmt = null;
		   try{
			   String sql = "INSERT INTO public.register_users (username,address,province,zipcode,password   ,create_date,update_date,refercode,classify,phoneno,salary) "+
			   " VALUES(?,?,?,?,?  ,?,?,?,?,?   ,?) ";
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, user.getUserName());
			   pstmt.setString(2, user.getAddress());
			   pstmt.setString(3, user.getProvince());
			   pstmt.setString(4, user.getZipcode());
			   pstmt.setString(5, user.getPassword());
			   Timestamp time=new Timestamp(new java.util.Date().getTime());
			   pstmt.setTimestamp(6,time);
			   pstmt.setTimestamp(7, time);
			   pstmt.setString(8, user.getRefercode());
			   pstmt.setString(9, user.getClassify());
			   pstmt.setString(10, user.getPhoneno());
			   pstmt.setBigDecimal(11, user.getSalary());
			   pstmt.executeUpdate();
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
