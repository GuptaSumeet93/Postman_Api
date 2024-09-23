package API_CRUD;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class SerializationDeserialisation {
	
	
	
	@Test(priority=0)
	void cnvertPojoToJson() throws JsonProcessingException
	{
		
		
	//CREATING JAVA OBJECT USING JAVA POJO CLASS
		
		
		StudentPojo stu=new StudentPojo();
		
		stu.setName("sumeet");
		stu.setLocation("Banglore");
		stu.setPhone("8796656585");
		
		String courseArr[]= {"appium","Git"};
		stu.setCourses(courseArr);
		
		
		//Converting java object to json object(serialization)
		
		ObjectMapper objMapper=new ObjectMapper();
		
		String jsonData=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
		
		System.out.println(jsonData);
		
	}
	
	@Test(priority=1)
	void cnverJsonToPojo() throws JsonProcessingException
	{
		
		
		
		//Converting  json object to java object (Deserialization)
		
		String jsonData="{\r\n"
				+ "  \"name\" : \"sumeet\",\r\n"
				+ "  \"phone\" : \"8796656585\",\r\n"
				+ "  \"location\" : \"Banglore\",\r\n"
				+ "  \"courses\" : [ \"appium\", \"Git\" ]\r\n"
				+ "}";
		
		ObjectMapper objMapper=new ObjectMapper();
		
		StudentPojo stu=objMapper.readValue(jsonData,StudentPojo.class);//Convert json to pojo
		
		
		System.out.println(	"Name :"+stu.getName());

		System.out.println("Location: "+stu.getLocation());

		

		System.out.println(" Phone :"+stu.getPhone());

		System.out.println("Courses 1"+ stu.getCourses()[0]);
		System.out.println("Courses 1"+ stu.getCourses()[1]);


		
		
	}

}
