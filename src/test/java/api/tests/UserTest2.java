package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.EndPoints.UsersEndPoints;
import api.EndPoints.UsersEndPoints2;
import api.Payload.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserTest2 {
	
	Faker faker;
	User userPayload;
	int user_id;
	
	@BeforeClass
	public void dataSetup() {
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setName(faker.name().fullName());
		userPayload.setJob(faker.job().title());
	}
	
	@Test(priority = 1)
	public void testCreateUser() {
		Response response=UsersEndPoints2.createUser(userPayload);
		response.then().log().body();
		user_id=response.jsonPath().getInt("id");
		response.then()
		.statusCode(201)
		.header("Content-Type", containsString("application/json"))
		.header("Server", notNullValue())
		.time(lessThan(3000L))
		.body("name", equalTo(userPayload.getName()))
		.body("job", equalTo(userPayload.getJob()));	
		
	}	
	@Test(priority = 2)
	
	public void testUpdateUser() {
		userPayload.setJob(faker.job().title());
		Response response=UsersEndPoints2.updateUser(user_id, userPayload);
		response.then()
			.statusCode(200)
			.header("Content-Type", containsString("application/json"))
			.header("Server", notNullValue())
			.time(lessThan(3000L))
			.body("name", equalTo(userPayload.getName()))
			.body("job", equalTo(userPayload.getJob()));
		
	}
	
	@Test(priority = 3)
	public void testGetUser() {
	
		Response response=UsersEndPoints2.getUser(userPayload.getUser_id());
		response.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {

		Response response=UsersEndPoints2.deleteUser(userPayload.getUser_id());
		response.then()
		.statusCode(204);
		
	}
	

}
