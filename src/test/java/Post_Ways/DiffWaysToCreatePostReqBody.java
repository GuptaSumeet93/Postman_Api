package Post_Ways;


import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;



public class DiffWaysToCreatePostReqBody {
	
	//1)Post Test Using Hashmap
	
	//@Test(priority=0)

	void testPostUsingHashMap()
	{
		
	HashMap<String, Object> data=new HashMap<String, Object>();
		
		data.put("name","sumeet");
		data.put("location","Banglore");
		data.put("phone","8796656585");
		
		String courseArr[]= {"appium","Git"};
		data.put("courses",courseArr);


		
		
		given()
				.contentType("application/json")
				.body(data)
		.when()
		.post("http://localhost:3000/students")
		
		.then().statusCode(201)
		.body("name",equalTo("sumeet"))
		.body("location",equalTo("Banglore"))

		.body("phone",equalTo("8796656585"))

		.body("courses[0]",equalTo("appium"))
		.body("courses[1]",equalTo("Git"))
		.header("content-Type","application/json; charset=utf-8")
        .log().all();
		
		
		 
		
	}
	
	//2)Post Test Using  JsonLibrary

	//@Test(priority=0)
	void testPostUsingJsonLibrary()
	{
		
	JSONObject data=new JSONObject();
		
		data.put("name","sumeet");
		data.put("location","Banglore");
		data.put("phone","8796656585");
		
		String courseArr[]= {"appium","Git"};
		data.put("courses",courseArr);


		
		
		given()
				.contentType("application/json")
				.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		
		.then().statusCode(201)
		.body("name",equalTo("sumeet"))
		.body("location",equalTo("Banglore"))

		.body("phone",equalTo("8796656585"))

		.body("courses[0]",equalTo("appium"))
		.body("courses[1]",equalTo("Git"))
		.header("content-Type","application/json; charset=utf-8")
        .log().all();
		
		
		 
		
	}
	//3)Post Request body using Pojo Class
	
	// @Test(priority=0)
		void testPostUsingPojoClass()
		{
			
		Pojo_PostReq data=new Pojo_PostReq();
			
			data.setName("sumeet");
			data.setLocation("Banglore");
			data.setPhone("8796656585");
			
			String courseArr[]= {"appium","Git"};
			data.setCourses(courseArr);


			
			
			given()
					.contentType("application/json")
					.body(data)
			.when()
			.post("http://localhost:3000/students")
			
			.then().statusCode(201)
			.body("name",equalTo("sumeet"))
			.body("location",equalTo("Banglore"))

			.body("phone",equalTo("8796656585"))

			.body("courses[0]",equalTo("appium"))
			.body("courses[1]",equalTo("Git"))
			.header("content-Type","application/json; charset=utf-8")
	        .log().all();
			
			
			 
			
		}
		
	
		
		//)4)Post Request body using External Json File
		
		  @Test(priority=0)
			void testPostUsingExetJsonFile() throws  FileNotFoundException
			{
				File f=new File(".\\body.json");
				
			FileReader fr=new FileReader(f);
			
				JSONTokener jt=new JSONTokener(fr);
				JSONObject data=new JSONObject(jt);
				
				
				
				
				given()
						.contentType("application/json")
						.body(data.toString())
				.when()
				.post("http://localhost:3000/students")
				
				.then().statusCode(201)
				.body("name",equalTo("sumeet"))
				.body("location",equalTo("Banglore"))

				.body("phone",equalTo("8796656585"))

				.body("courses[0]",equalTo("appium"))
				.body("courses[1]",equalTo("Git"))
				.header("content-Type","application/json; charset=utf-8")
		        .log().all();
				
				
				 
				
			}
			
		
	
	
	@Test(priority=1)
	void deleteUser()
	{
		
		
		given()
				
		.when()
		.delete("http://localhost:3000/students/27")

		
		.then().statusCode(200)
		.log().all();
		
		
	}
	

}
