
package RestAssured.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test (priority = 2)
	public void get() {
		Response res = RestAssured.get("http://reqres.in/api/users/2");
		System.out.println("Get status code: " + res.getStatusCode());
		System.out.println("Body: " + res.getBody().asPrettyString());
	}
	
	@Test (priority = 1)
	public void post() {
		Response pres = RestAssured.post("http://reqres.in/api/users/2");
		System.out.println("Post status code :" + pres.getStatusCode());
	}
	
	@Test (priority = 3)
	public void put() {
		Response pures = RestAssured.put("http://reqres.in/api/users/2?name=john");
		System.out.println("Put status code :" + pures.getStatusCode());
	}
	
	@Test (priority = 4)
	public void delete() {
		Response dres = RestAssured.delete("http://reqres.in/api/users/2");
		System.out.println("Delete status code :" +dres.getStatusCode());
				
	}
}
