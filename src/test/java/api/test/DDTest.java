package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	@Test( priority = 1,dataProvider =   "data",dataProviderClass = DataProviders.class)
	public void DDT_createUser(String id,String username,String fname,String lname,String email,String password,String phone,String usrStatus) {
	
		 User payload= new User();
		
		payload.setId(Integer.parseInt(id));
		payload.setUsername(username);
		payload.setFirstName(fname);
		payload.setLastName(lname);
		payload.setEmail(email);
		payload.setPassword(password);
		payload.setPhone(phone);
		payload.setUserStatus(Integer.parseInt(usrStatus));
		Response res=UserEndPoints.createUser(payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority=2,dataProvider  = "username",dataProviderClass = DataProviders.class)
	 void testgetUser(String username) {
	 Response res=UserEndPoints.readUser(username);
	 
	 res.then().log().body();
	}
	
	@Test(priority = 3,dataProvider  = "username",dataProviderClass = DataProviders.class)
	
	public void DDT_deleteUser(String username) {
		Response res=UserEndPoints.deleteUser(username);
		res.then().log().all();
		
	}

}
