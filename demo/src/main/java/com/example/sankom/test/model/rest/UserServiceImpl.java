package com.example.sankom.test.model.rest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.sankom.test.model.db.UserModelDAO;
import com.example.sankom.test.model.db.UserModelDAOImpl;
import com.example.sankom.test.model.db.UserModelDB;

@Service
public class UserServiceImpl implements UserService {

	 
	
	@Override
	public void createUser(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		UserModelDAO  userdao=new UserModelDAOImpl();
		
		if(user!=null) {
			UserModelDB userDb=new UserModelDB();
			userDb.setUserName(user.getUserName());
			userDb.setAddress(user.getAddress());
			userDb.setProvince(user.getProvince());
			userDb.setZipcode(user.getZipcode());
			Date currentDate=Calendar.getInstance().getTime();
		    java.sql.Date sqlDate=new java.sql.Date(currentDate.getTime());
			userDb.setUpdateDate(sqlDate);
			userDb.setCreateDate(sqlDate);
			userDb.setPhoneno(user.getPhoneno());
			userDb.setRefercode(getRefer( user.getPhoneno(),currentDate));
			userDb.setClassify(getClassify(user.getSalary()));
			
			user.setClassify(userDb.getClassify());
			user.setRefercode(userDb.getRefercode());
			userdao.createUser(userDb);
		}
		
	}

	private String getClassify(BigDecimal salary) {
	 
		String classify="Reject";
		BigDecimal S50K=new BigDecimal(50000);
		BigDecimal S30K=new BigDecimal(30000);
		BigDecimal S15K=new BigDecimal(15000);
		if(  S50K.compareTo(salary)<0){
			classify="Platinum";
		}else if(  S30K.compareTo(salary)<0){
			classify="Gold";
		}else if(  S15K.compareTo(salary)<0){
			classify="Silver";
		} 
		return classify;
	}

	private String getRefer(String phoneno, Date currentDate) {
		SimpleDateFormat df=new SimpleDateFormat("YYYMMDD");
		
	    String result=df.format(currentDate);
	    if(phoneno!=null&&phoneno!=""&&phoneno.length()>4) {
	    	
	    	result=result+phoneno.substring( phoneno.length()-4);
	    }
		return result;
	}

	@Override
	public UserModel getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		UserModelDAO  userdao=new UserModelDAOImpl();
		UserModelDB userDB=userdao.getUser(userId);
	    UserModel res=null;
		if(userDB!=null) {
			res=new UserModel();
			res.setUserName(userDB.getUserName());
			res.setAddress(userDB.getAddress());
			res.setProvince(userDB.getProvince());
			res.setZipcode(userDB.getZipcode());
		}
		return  res;
	}

}
