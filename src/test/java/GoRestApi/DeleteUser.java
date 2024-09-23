package GoRestApi;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	
	@Test
	void deleteUser(ITestContext context)
	{

		
		int id=(Integer)
				
				
				context.getAttribute("UserId"); //this should come from create user		
		//context.getSuite().setAttribute("UserId",id);


	
	
		 String bearerToken="2a4dae09b7ef6563af6d6de2b27b020bf56da54e78ee4f30a2dba0e0df4e0eb1";
		
		 given()
				.headers("Authorization","Bearer"+bearerToken)
				.pathParam("id",id)
				
				
				.when().delete("https://gorest.co.in/public/v2/users/{id}")
				.then().statusCode(204).log().all();
	
	
	}

}
