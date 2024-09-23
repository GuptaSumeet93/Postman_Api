package API_CRUD;


import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FileUploadDownload {
	
	
	
	@Test
	void fileUpload()
	{
		
		
		File myfile=new File ("D:\\Basic_Postman\\studentData.txt");
		
		
		given().multiPart("file",myfile)
		.contentType("multipart/form-data")
		
		.when().post("http://localhost:8080/uploadFile")
		
		.then().statusCode(200)
		.body("fileName",equalTo("studentData.txt"))
				.log().all();
		

}

}
