package API_CRUD;

import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;



public class HttpReq {
	
	@Test(priority = 1)
	void getUser()
	{
		
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).body("page",equalTo(2)).log().all();
		
	}
	@Test(priority=2)
	void getSingleUser()
	{
		given()
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
		
		
	}
	
	@Test(priority=0)
	void createUser()
	{
		HashMap<String, String> data=new HashMap<String, String>();
		
		data.put("name","sumeet");
		data.put("learn","RestAPI");
		given().contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201).log().all();
		
		
	}

}
