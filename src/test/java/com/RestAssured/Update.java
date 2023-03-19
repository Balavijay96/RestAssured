package com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class Update {

	
	@Test
	private void updateEmployee() {
		// TODO Auto-generated method stub
			RestAssured.baseURI="http://localhost:3000/";
			RequestSpecification reqspec= RestAssured.given().
			header("Content-Type","application/json").
			body("{\"name\":\"Balasubramaniyan Pakkirisamy\",\"age\":\"27\"}");
			reqspec.request(Method.PUT,"posts/1");
			
			
	}
}
