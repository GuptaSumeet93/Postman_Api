package API_CRUD;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;



public class PathAndQueryParameter {
	
	//https://reqres.in/api/users?page=2&id=5
	
	
	@Test
	void testQueryAndPathParameter()
	{
		given().pathParam("mypath","users") //Path Parameter
		                            
		.queryParam("page", 2)        //Query parameter
		.queryParam("id",5)           //Query parameter
		
		.when().get("https://reqres.in/api/{mypath}")
		
		.then().statusCode(200).log().all();
		
		
	}

}
