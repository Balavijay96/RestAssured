package com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostEmployee {
	@Test
	private void postEmployee() {
			RestAssured.baseURI="http://localhost:3000/";
			RequestSpecification specification = RestAssured.given().
			header("Content-Type","application/json").
			body("{\"name\":\"BalaVijay\",\"age\":\"27\"}");
			Response response = specification.request(Method.POST,"profile");
			System.out.println(response.asPrettyString());
			System.out.println("String : "+ response.asString());
			System.out.println(response.getStatusLine());
			
	}

}
