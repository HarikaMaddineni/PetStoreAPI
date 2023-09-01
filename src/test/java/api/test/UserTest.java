package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	User payload;
	
	@BeforeClass
	
				public void setUpData() {
					faker= new Faker();
					
					payload= new User();
					
					payload.setId(faker.idNumber().hashCode());
					payload.setUsername(faker.name().username());
					payload.setFirstName(faker.name().firstName());
					payload.setLastName(faker.name().lastName());
					payload.setEmail(faker.internet().emailAddress());
					payload.setPassword(faker.internet().password());
					payload.setPhone(faker.phoneNumber().cellPhone());
					//payload.setUserStatus(0);
				}
	@Test(priority=1)
	void testPostUser() {
		Response res=UserEndPoints.createUser(payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	 void testgetUser() {
	 Response res=UserEndPoints.readUser(this.payload.getUsername());
	 
	 res.then().log().body();
	}
	
	@Test(priority=3)
	void testUpdateUser() {
		//payload= new User();
		
		this.payload.setFirstName(faker.name().firstName());
		this.payload.setLastName(faker.name().lastName());
		this.payload.setEmail(faker.internet().emailAddress());
		Response res=UserEndPoints.updateUser(this.payload.getUsername(), payload);
		System.out.println("------------------------------------");
			
		res.then().log().body();
		Response resAfterUpdate=UserEndPoints.readUser(this.payload.getUsername());
		 
		resAfterUpdate.then().log().body();
		
	}
	@Test(priority=4)
	
	
	void testDeleteUser() {
		Response res=UserEndPoints.deleteUser(this.payload.getUsername());
		res.then().log().all();
	}
	 
	

}
