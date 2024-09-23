package API_CRUD;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {
	
	
	
	
	
	@Test
	void JsonSchemaValidation()
	{
		
		given()
	
		.when().get("http://localhost:3000/sport")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("sport_Scehma.json"));
	

}
}
