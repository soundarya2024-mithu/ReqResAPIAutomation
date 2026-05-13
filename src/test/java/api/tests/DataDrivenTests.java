package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.EndPoints.UsersEndPoints;
import api.Payload.User;
import api.EndPoints.UsersEndPoints;

import io.restassured.response.Response;

public class DataDrivenTests {
	User userPayload;

	@Test(priority = 1, dataProvider = "dp", dataProviderClass =api.Utilities.DataProviders.class)
	public void testCreateUser(String name, String job) {
		userPayload=new User();
		userPayload.setName(name);
		userPayload.setJob(job);
		Response response=UsersEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}
}
