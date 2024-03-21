package Testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// How to test getapi , There are 2 ways, i.e create a method or Create BDD style

public class FirstTestcase_get {

	@Test
	void tc01_get()
	{
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
	@Test
	void tc02_get()
	{
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7));
	}
	
}
