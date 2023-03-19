package com.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BDDStyle {
	
	
	@Test(enabled=true)
	private void getRequest() {
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000/")
		.when()
			.get("posts/47")
		.prettyPrint();
		
	}
	@Test(enabled=true)
	private void postRequest() {
		Response post = RestAssured
		.given()
			.baseUri("http://localhost:3000/")
		
		.header("Content-Type", "application/json")
		.body("{\"name\":\"BalaVps\",\"age\":\"27\"}")
		.when()
		.post("posts");
		int statusCode = post.getStatusCode();
		
		Assert.assertEquals(statusCode, 201);
	}

}
