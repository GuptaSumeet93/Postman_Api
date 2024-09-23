package API_CRUD;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;


import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXmlResponse {
	
	
	//Approach-1
	
	//@Test(priority=0)
	void tesXmlResponse()
	{
		given()
		
		.when().get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then().statusCode(200)
		.body("TravelerinformationResponse .page",equalTo("1"))
		.body("TravelerinformationResponse .travelers.Travelerinformation[0].name",equalTo("Developer"))

		.header("Content-Type","application/xml; charset=utf-8");

}
	
	//Approach-2
	
	//@Test(priority=1)

		void tesXmlResponse1()
		{
			Response res=given()
			
			.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
			
			Assert.assertEquals(res.getStatusCode(),200);
			
			Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
			
		String	pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();

			Assert.assertEquals(pageNo,"1");
			
		String	name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
			Assert.assertEquals(name, "Developer");

		}


	@Test(priority=2)

		void tesXmlResponseBody()
		{
			Response res=given()
			
			.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
			
	
	
            XmlPath  xmlObj=new XmlPath(res.asString());	
            
            //Verify Total no of Travellers
            
    
            
            
             List <String> traveller=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
             Assert.assertEquals(traveller.size(), 10);
 
             //Verify  Travellers name is present in list
             
             List <String> travellerName=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
             
             boolean status=false;
             
             for(String tname:travellerName)
             {

            	 
            	 
            	 System.out.println(tname);
            	 
            	 if(tname.equals("asdasd"))
            	 {
            		 status=true;
            		 break;
            	 }
            	 
             }

 			Assert.assertEquals(status, true);


		
		}
	
	
}

