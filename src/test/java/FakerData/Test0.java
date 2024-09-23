package FakerData;



import org.testng.annotations.Test;

import com.github.javafaker.Faker;



public class Test0 {
	
	@Test
	
	void testGenerateDummyData() {
		
		Faker faker=new Faker();
		
		
		String fullName=faker.name().fullName();
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String email=faker.internet().safeEmailAddress();
		String username=faker.name().username();
		String password=faker.internet().password();
		String phoneno=faker.name().fullName();


		System.out.println("Full Name:  "+fullName  );
		System.out.println(" First Name:  "+firstName  );
		System.out.println(" Last name : "+lastName  );
		System.out.println(" Email :  "+ email );
		System.out.println(" Username  "+username );
		System.out.println(" Password :"+password  );
		System.out.println(" Phoneno:  "+ phoneno );

		
	}

}
