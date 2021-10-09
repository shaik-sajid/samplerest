package RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Basic {

	@Test
	public void verifyGet() {
		baseURI ="https://reqres.in/api";
		
		given()
			.get("/users?page=2")
		.then().statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Rachel"));
	}
	
	
	@Test
	public void verifyPost() {
		
		Map<String, Object> mp = new HashMap<String, Object>();
		
		JSONObject postResponse = new JSONObject();
		
		postResponse.put("name", "Khan");
		postResponse.put("Designation", "SDET");
		
		
		System.out.println(postResponse.toJSONString());
		
		baseURI = "https://reqres.in/api/";
		
		given()
		.header("Content-Type", "application/json")
		.accept(ContentType.JSON)
		.body(postResponse.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201)
		.log().all();
	}
}
