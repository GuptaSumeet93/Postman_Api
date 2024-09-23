package API_CRUD;



import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;



public class Logall {
	
	//https://reqres.in/api/users?page=2&id=5
	
	
	@Test
	void testLog()
	{
		given()
		
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then().log().all();
		//.then().log().body();
		//.then().log().cookies();

		
		
		
	}

}
