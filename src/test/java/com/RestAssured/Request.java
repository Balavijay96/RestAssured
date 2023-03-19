package com.RestAssured;


import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Request {

	@Test
	private void getMethod() {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().when().get("https://reqres.in/api/users/2")
		.then().log().all().statusCode(200).extract().response();
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		System.out.println(response.asString());
	}
}
