package api.EndPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsersEndPoints {
 
	
	public static Response createUser(User payload) {
		Response response=given()
				.header(Routes.API_Key,Routes.API_Value)
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		return response;
	}
	
	public static Response updateUser(int id,User payload) {
		Response response=given()
				.header(Routes.API_Key,Routes.API_Value)
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("user_id", id)
			.body(payload)
		.when()
			.put(Routes.put_url);
		return response;
	}
	public static Response getUser(int id) {
		Response response=given()
							.header(Routes.API_Key,Routes.API_Value)
							.pathParam("user_id", id)
						.when()
							.get(Routes.get_url);
		
		return response;
	}
	
	public static	Response deleteUser(int id) {
		Response response=given()
				.header(Routes.API_Key,Routes.API_Value)
				.pathParam("user_id", id)
			.when()
				.delete(Routes.delete_url);

		return response;
	}

}
