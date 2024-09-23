package API_CRUD;


import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class ParsingJsonResData {
	
	
	//Apprach 1
	@Test(priority =0)
	void testJsonResponse()
	{
		given()
		.contentType(ContentType.JSON)
		
		.when().get("http://localhost:3000/sport")
		
		.then().statusCode(200)
		.header("Content-Type","application/json")

		.body("game[1].player",equalTo("Rohit Sharma"))
		.log().all();

		
		
		
	}
	
	
	
	//Apprach 2
	
			@Test(priority = 1)

		void testJsonResponse1()
		{
			Response res=given()
			.contentType(ContentType.JSON)
			
			.when().get("http://localhost:3000/sport");
			
			Assert.assertEquals(res.getStatusCode(),200);
			
			Assert.assertEquals(res.header("Content-Type"),"application/json");
			

			String playerName=res.jsonPath().get("game[0].player").toString();
			
			System.out.println(" "+playerName);
			
			
			//Assert.assertEquals(bookName,"Things Fall Apart");
		}
		
		
		//Approach 3 )using JSON OBJECT CLASS
		
			@Test(priority = 2)
		void testJsonResBody()
		
		{
			

			Response res=given()
			.contentType(ContentType.JSON)
			
			.when().get("http://localhost:3000/sport");
			
			
			JSONObject jo=new JSONObject(res.asString()); //Converting Response to json object
			
		//	Print all titles of book
			
			
			for(int i=0; i<jo.getJSONArray("game").length(); i++)
			{
					
				String jersyNumber=jo.getJSONArray("game").getJSONObject(i).get("Jersy").toString();

				System.out.println(jersyNumber);
		    }
		
		}
		
}


