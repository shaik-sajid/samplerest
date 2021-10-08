
package RestAssured.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void get() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Get status code: " + res.getStatusCode());
	}
}
