package API_CRUD;


import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class multipleFileUpload{
	
	
	
	@Test
	void fileUpload()
	{
		
		
		File myfile=new File ("D:\\Basic_Postman\\studentData.txt");
		File myfile2=new File ("D:\\Basic_Postman\\BookData.txt");

		
		given()
		
		.multiPart("files",myfile)
		.multiPart("files",myfile2)

		.contentType("multipart/form-data")
		
		.when().post("http://localhost:8080/uploadMultipleFiles")
		
		.then().statusCode(200)
		.body("[0].fileName",equalTo("studentData.txt"))

		.body("[1].fileName",equalTo("BookData.txt")).log().all();
		

}
	
    @Test
	void fileUpload1()           //Won't work for all kind of api
	{
		
		
		File myfile=new File ("D:\\Basic_Postman\\BookData.txt");
		File myfile2=new File ("D:\\Basic_Postman\\studentData.txt");

		File filearr[]= {myfile,myfile2};
		given()
		
		.multiPart("files",filearr)

		.contentType("multipart/form-data")
		
		.when().post("http://localhost:8080/uploadMultipleFiles")
		
		.then().statusCode(200)
		.body("myfile",equalTo("BookData.txt"))

		.body("myfile2",equalTo("studentData.txt"))
		
		.log().all();
		

}

	
	
	@Test
	void fileDownload()
	{
		
		given()
	
		.when().get("http://localhost:8080/downloadFile/BookData.txt")
		
		.then()
		
		.statusCode(200)
		.log().body();
		

}
	
}
