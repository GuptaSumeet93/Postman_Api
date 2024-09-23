package API_CRUD;


import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import joptsimple.util.KeyValuePair;



public class Cookies {
	
	
	
	@Test
	void getCookies()
	{
		
		
		


	
		 Response res=given()
		
		.when().get("https://www.google.com/");
		 
		 //Get Single Cookie
		 
		 String singleCookie=res.getCookie("AEC");
		 
		 System.out.println(" Value of cookie is  "+singleCookie);
		 System.out.println("\n===========================================================");
		 
		 //Get all cookie info
		
		 Map<String,String> cookies_Value=res.getCookies();
		
		 
		 System.out.println(cookies_Value.keySet());
		 
		 System.out.println("\n===========================================================");

		 
		 for(String k: cookies_Value.keySet())
		 {
			 
			 
			 String allCookies=res.getCookie(k);
			 
			 System.out.println(k+"      "+allCookies);
		 }
		 
		 
	}





		
	}


