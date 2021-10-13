package RestAssured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class DemoRail {

@Test
	public void testGet() {
		baseURI = "https://qaautomationappz.testrail.io/";
		
		
		
		
		given()
			.auth().preemptive().basic("shadabanwar.appz@gmail.com", "Test@123")
			.get("index.php?/api/v2/get_case/6")
			.then().statusCode(200);
}
	
	@Test
	public void get() {
		baseURI = "https://qaautomationappz.testrail.io/";
		
		Response res = RestAssured.given().auth().preemptive().basic("shadabanwar.appz@gmail.com", "Test@123")
				.get("index.php?/api/v2/get_case/6");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asPrettyString());
	}
	
	@Test
	public void post() {
    Map<String, Object> mp = new HashMap<String, Object>();
		
		JSONObject postResponse = new JSONObject();
		
		postResponse.put("title", "Updated test case 3:51pm");
		
		
		
		System.out.println(postResponse.toJSONString());
		
		baseURI = "https://qaautomationappz.testrail.io/";
		
		
		given().auth().preemptive().basic("shadabanwar.appz@gmail.com", "Test@123")
		.header("Content-Type", "application/json")
		.accept(ContentType.JSON)
		.body(postResponse.toJSONString())
		.when()
		.post("index.php?/api/v2/add_case/1")
		.then()
		.statusCode(200)
		.log().all();
		
		System.out.println(postResponse);
		
	}
	
	@Test
	public void put() {
		 Map<String, Object> mp = new HashMap<String, Object>();
			
			JSONObject putResponse = new JSONObject();
			
			putResponse.put("title", "Updated test case 5:09 pm");
			
			
			
			System.out.println(putResponse.toJSONString());
			
			baseURI = "https://qaautomationappz.testrail.io/";
			
			
			given().auth().preemptive().basic("shadabanwar.appz@gmail.com", "Test@123")
			.header("Content-Type", "application/json")
			.accept(ContentType.JSON)
			.body(putResponse.toJSONString())
			.when()
			.post("index.php?/api/v2/update_case/28")
			.then()
			.statusCode(200)
			.log().all();
			
			//System.out.println(putResponse);
	}
	
	@Test
	public void delete() {
		baseURI = "https://qaautomationappz.testrail.io/";
		
		
		given().auth().preemptive().basic("shadabanwar.appz@gmail.com", "Test@123")
		.header("Content-Type", "application/json")
		.accept(ContentType.JSON)
		.when()
		.post("index.php?/api/v2/delete_case/28")
		.then()
		.statusCode(200)
		.log().all();
	}
	
}