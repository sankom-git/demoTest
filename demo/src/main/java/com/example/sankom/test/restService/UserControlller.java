package com.example.sankom.test.restService;
 

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.sankom.test.model.rest.ResponseModel;
import com.example.sankom.test.model.rest.UserModel;
import com.example.sankom.test.model.rest.UserServiceImpl;

@RestController
public class UserControlller {
	@Autowired
	   UserServiceImpl userService;
	
	@GetMapping("/test")
	public String test(@RequestParam(value="name") String name) {
		return "Test "+name;
	}
	
	@PostMapping("/gettokens/{userName}")
	public ResponseEntity<Object> getToken(@PathVariable(value="userName") String userName,HttpServletResponse response) {
		 
		ResponseModel res=new ResponseModel();
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    String token = JWT.create()
		    	.withClaim("userName", userName)	
		        .withIssuer("auth0")
		        .sign(algorithm);
		    response.setHeader("custom-token", token);
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		
		res.setToken("OK");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping(value="/user/{userName}/{userRequest}", produces = "application/json")
	public ResponseEntity<Object>  getUser(@RequestHeader("custom-token") String token,@PathVariable String userName,@PathVariable String userRequest,HttpServletResponse response) throws Exception {
		
		try {
			System.out.println("Token="+token );
			System.out.println("UserName="+userName );
			System.out.println("userRequest="+userRequest );
			
			try {
			    Algorithm algorithm = Algorithm.HMAC256("secret");
			    JWTVerifier verifier = JWT.require(algorithm)
			        .withIssuer("auth0")
			        .build(); //Reusable verifier instance
			    DecodedJWT jwt = verifier.verify(token);
			   Claim userNameToken= jwt.getClaim("userName");
			   System.out.println("id token+ "+userNameToken.asString());
			   
			   if(token==null||!userName.equals(userNameToken.asString())) {
				   throw new ResponseStatusException(
				           HttpStatus.FORBIDDEN, "Request Cannot Access ");
			   }else{
				   //Get User
				   userService.getUser(userRequest);
			   }
			   
			} catch (JWTVerificationException exception){
			    //Invalid signature/claims
			}
			 ResponseModel res=new ResponseModel();
			 res.setUsermodel(new UserModel());
			 res.getUsermodel().setUserName(userName);
				return new ResponseEntity<>(res, HttpStatus.OK);
		       
		    } catch ( Exception ex) {
		    	ex.printStackTrace();
		        throw new Exception(
		          "Exception", ex);
		    }
		
	}
	
	
	@PostMapping("/user/{userName}")
	public ResponseEntity<Object> register(@RequestHeader("custom-token") String token,@PathVariable String userName,@RequestBody UserModel user,HttpServletResponse response) throws Exception {
		 
		try {
			System.out.println("Token="+token );
			
			try {
			    Algorithm algorithm = Algorithm.HMAC256("secret");
			    JWTVerifier verifier = JWT.require(algorithm)
			        .withIssuer("auth0")
			        .build(); //Reusable verifier instance
			    DecodedJWT jwt = verifier.verify(token);
			   Claim userNameToken= jwt.getClaim("userName");
			   System.out.println("id token+ "+userNameToken.asString());
			   
			   if(token==null ||!userName.equals(userNameToken.asString()) ) {
				   throw new ResponseStatusException(
				           HttpStatus.FORBIDDEN, "Request Cannot Access ");
			   }
			} catch (JWTVerificationException exception){
			    //Invalid signature/claims
			}
			
			   userService.createUser(user);
			   ResponseModel res=new ResponseModel();
				 res.setUsermodel(user);
				return new ResponseEntity<>(res, HttpStatus.OK);
		       
		    } catch ( Exception ex) {
		    	ex.printStackTrace();
		        throw new Exception(
		          "Exception", ex);
		    }
	}

}
