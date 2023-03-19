package com.RestAssured;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetEmployees {
	@Test
	public void getEmployees() {
		RestAssured.baseURI="http://localhost:3000/";
		RequestSpecification spec= RestAssured.given();
		Response response = spec.request(Method.GET,"posts/2");
		String prettyString = response.asPrettyString();
		String statusLine = response.getStatusLine();
		System.out.println(prettyString);
		System.out.println(statusLine);
	}

}
