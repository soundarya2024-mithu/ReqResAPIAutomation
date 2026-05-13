package api.EndPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsersEndPoints2 {
	    
	public static Response createUser(User payload) {
		
		Response response=BaseClass.requestSpc()
								.body(payload)
							.when()
								.post(BaseClass.post_url);
		return response;
	}
	
	public static Response updateUser(int id,User payload) {
		
		Response response=BaseClass.requestSpc()
							.pathParam("user_id", id)
							.body(payload)
						.when()
							.put(BaseClass.put_url);
		return response;
	}
	public static Response getUser(int id) {
		Response response=BaseClass.requestSpc()
							.pathParam("user_id", id)
						.when()
							.get(BaseClass.get_url);
		
		return response;
	}
	
	public static	Response deleteUser(int id) {
		Response response=BaseClass.requestSpc()
							.pathParam("user_id", id)
						.when()
							.delete(BaseClass.delete_url);

		return response;
	}

}
