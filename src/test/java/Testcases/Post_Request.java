package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class Post_Request {
	

	@Test
	void postrequest()
	{
	
	//RestAssured.baseURI="http://restapi.demoqa.com/customer";
	RequestSpecification httprequest=RestAssured.given();
	
	JSONObject requestparam=new JSONObject();
	//requestparam.put("Firstname", "Himani");
	//requestparam.put("Lastname", "Gupta");
	//requestparam.put("Username", "Abc");
	
	//requestparam.put("Email", "eve.holt@reqres.in");
	//requestparam.put("Password", "pistol");
	requestparam.put("id", "78912");
	
	httprequest.header("Content-Type","application/json");
	httprequest.body(requestparam.toString());
	
	
	Response response=post("https://reqbin.com/echo/post/json");
	
	
	System.out.println(response.asString());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	//int statuscode=response.getStatusCode();
	//Assert.assertEquals(statuscode, 200);
	}
}
