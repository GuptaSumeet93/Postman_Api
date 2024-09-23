package API_CRUD;


import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.AND;
import io.restassured.http.Header;
import io.restassured.response.Response;

import io.restassured.response.ResponseOptions;

public class Headers {
	
	
	
	@Test(priority=0)
	void getHeaders()
	{
		 given()
					
		.when().get("https://www.google.com/")
					 
		.then().header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding","gzip")
		.and()
		.header("Server","gws")
		.log().headers();
		
		
	}
	
	@Test(priority=1)
	void getHeaders1()
	{
		Response  res=given()
					
		.when().get("https://www.google.com/");
					 
		
		//Get single header info
		
		String  headerValue=res.getHeader("Content-Type");
		
		System.out.println("value of single Header is  "+headerValue);
	
		
		System.out.println("===============================");
		
//		//Get All Headers
//		
//		
      //  Headers allheaders= res.getHeaders();
//		
//		
//		for(Header hd=allheaders)
//		{
//			
//			System.out.println(hd.getName()+"   "+hd.getValue());
//		}
	}

}
