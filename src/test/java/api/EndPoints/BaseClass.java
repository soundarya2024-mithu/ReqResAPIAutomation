package api.EndPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static ResourceBundle getUrl(){
		ResourceBundle routes=ResourceBundle.getBundle("routes"); //Load properties file
		return routes;
	}
	
	static String API_KEY = getUrl().getString("API_Key");
	static String API_VALUE = getUrl().getString("API_Value");
	    
	static String post_url=getUrl().getString("post_url");
	static String put_url=getUrl().getString("put_url");
	static String get_url=getUrl().getString("get_url");
	static String delete_url=getUrl().getString("delete_url");
	
	public static RequestSpecification requestSpc() {
		
		return given()
					.header(API_KEY,API_VALUE)
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON);
				
	}

}
