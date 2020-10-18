# demoTest
TestMobile
     Software Requment   
      1. JDK 8.0 
      2. Maven
      
Howtorun 
   1. clone git  
   2. cd demo
   3. mvnw spirngb-boot:run
   
REST test path on localhost
      get token   POST http://localhost:8080/gettokens/:userName
      create user POST http://localhost:8080/user/:userName
      Get User    GET  http://localhost:8080/user/:userName/:userRequest
