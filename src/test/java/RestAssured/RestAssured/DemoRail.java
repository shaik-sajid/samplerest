package RestAssured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class DemoRail {

@Test
	public void testGet() {
		baseURI = "https://qaautomationappz.testrail.io/";
		
		
		
		given()
			.get("/index.php?/api/v2/get_case/6")
			.then().statusCode(200);
}
	
	@Test
	public void get() {
		Response res = RestAssured.get("https://qaautomationappz.testrail.io/index.php?/api/v2/get_case/4");
		System.out.println(res.getStatusCode());
	}
	
	@Test
	public void post() {
    Map<String, Object> mp = new HashMap<String, Object>();
		
		JSONObject postResponse = new JSONObject();
		
		postResponse.put("title", "Updated test case 11");
		
		
		
		System.out.println(postResponse.toJSONString());
		
		baseURI = "https://qaautomationappz.testrail.io/";
		
		given()
		.header("Content-Type", "application/json")
		.accept(ContentType.JSON)
		.body(postResponse.toJSONString())
		.when()
		.post("/index.php?/api/v2/update_case/6")
		.then()
		.statusCode(200)
		.log().all();
		
		System.out.println(postResponse);
	}
}