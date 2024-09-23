package API_CRUD;


import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class ParsingJsonResDataBook {
	
	
	//Apprach 1
	@Test(priority =1)

	void testJsonResponse()
	{
		given()
		.contentType(ContentType.JSON)
		
		.when().get("http://localhost:3000/Store")
		
		.then().statusCode(200)
		.body("books[12].author",equalTo("Emily Brontë"));
	//	.header("Content-Type","application/json").log().all();

		
		
		
	}
	
	
	
	//Apprach 2
	
	@Test(priority =2)

		void testJsonResponse1()
		{
			Response res=given()
			.contentType(ContentType.JSON)
			
			.when().get("http://localhost:3000/Store");
			
			Assert.assertEquals(res.getStatusCode(),200);
			
			Assert.assertEquals(res.header("Content-Type"),"application/json");

			String bookTitle=res.jsonPath().get("books[15].title").toString();
			System.out.println(""+bookTitle);
			
			Assert.assertEquals(bookTitle,"Journey to the End of the Night");
		}
		
		
		//Approach 3 )using JSON OBJECT CLASS
		
		@Test(priority =3)
		void testJsonResBody()
		
		{
			

			Response res=given()
			.contentType(ContentType.JSON)
			
			.when().get("http://localhost:3000/Store");
			
			
			JSONObject jo=new JSONObject(res.asString()); //Converting Response to json object
			
		//	Print all titles of book
			boolean status=false;
			
			for(int i=0; i<jo.getJSONArray("books").length(); i++)
			{
					
				String bookTitle=jo.getJSONArray("books").getJSONObject(i).get("title").toString();

				System.out.println(bookTitle);
				
				if(bookTitle.equals("Journey to the End of the ight"))
				{
					status=true;
					break;
				}
				
		    }
			
			Assert.assertEquals(status,true);

		
		}
		
}


