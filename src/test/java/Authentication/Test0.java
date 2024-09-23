package Authentication;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

public class Test0 {

	
	
	
	@Test(priority=0)
	void testBasicAuthentication()
	{
		given()
		.auth().basic("postman","password")
		
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();	
	}
	
	
	
	
	
	@Test(priority=1)
	void testDigestAuthentication()
	{
		given()
		.auth().digest("postman","password")
		
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();	
	}


	
	
	
	@Test(priority=2)
	void testPreemtiveAuthentication()
	{
		given()
		.auth().preemptive().basic("postman","password")
		
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();	
	}
	

	@Test(priority=3)
	void testBeareTokenAuthentication()
	{
		String bearerToken="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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";
		
		given()
        .headers(
            "Authorization", "Bearer " + bearerToken)
		.when().get("https://api.github.com/user/repos")
		
		.then().statusCode(200)
		.log().all();	
	}
	
	
}
