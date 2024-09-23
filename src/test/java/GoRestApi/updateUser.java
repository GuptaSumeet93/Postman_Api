package GoRestApi;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updateUser {
	
	
	@Test
	void updateUser(ITestContext context)
	{
		
		int id=(Integer) context.getAttribute("UserId"); //this should come from create user		 
	//context.getSuite().setAttribute("UserId",id);

		
          Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		


		 data.put("name",faker.name().fullName());
		 data.put("gender","female");
		 data.put("email",faker.internet().safeEmailAddress());
		 data.put("status","active");
	
		


		 
		 String bearerToken="2a4dae09b7ef6563af6d6de2b27b020bf56da54e78ee4f30a2dba0e0df4e0eb1";
		
	        //this should come from create user		 
		 given()
				.headers("Authorization","Bearer"+bearerToken)
				.pathParam("id",id)
				.contentType("application/json")
				.body(data.toString())
				
				
				
				.when().get("https://gorest.co.in/public/v2/users/{id}")
				.then().statusCode(200).log().all();
	
	
	}

}

