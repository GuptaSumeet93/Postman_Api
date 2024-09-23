package GoRestApi;


import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	
	@Test
	void createUser(ITestContext context)
	{
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		


		 data.put("name",faker.name().fullName());
		 data.put("gender","male");
		 data.put("email",faker.internet().safeEmailAddress());
		 data.put("status","inactive");

		 String bearerToken="2a4dae09b7ef6563af6d6de2b27b020bf56da54e78ee4f30a2dba0e0df4e0eb1";
		
	int id=given()
				.headers("Authorization","Bearer"+bearerToken)
				.contentType("application/json")
				.body(data.toString())
				
				
				.when().post("https://gorest.co.in/public/v2/users")
				.jsonPath().getInt("id");
	
		System.out.println("Generated Id=  "+id);
		
		context.setAttribute("UserId",id); 
	//context.getSuite().setAttribute("UserId",id);

	}
}
