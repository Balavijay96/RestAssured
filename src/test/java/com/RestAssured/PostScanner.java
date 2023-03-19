package com.RestAssured;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.testng.annotations.Test;

import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostScanner {
	
	
	static ResponseBody body;
	static Response response;
	
	@Test	
	public void postRequest() {
		Map<String,Object> m= new HashMap<String,Object>();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the name");
		String name = s.nextLine();
		
		m.put("name", name );
		m.put("age", 27);
		m.put("Role", "SDET");
		
		RestAssured.baseURI="http://localhost:3000/";
		RequestSpecification specification = RestAssured.given().
		header("Content-Type","application/json").
		body(m);
		response = specification.request(Method.POST,"posts");
		body = response.getBody();
		System.out.println(response.asPrettyString());
		System.out.println("String : "+ response.asString());
		System.out.println(response.getStatusLine());
	}
	@Test
	public void getName() {
			System.out.println(response.getStatusLine());
//			Object name = body.jsonPath().get("name");
//			Object role = body.jsonPath().get("Role");
//			System.out.println(name);
//			System.out.println(role);
			
	}
	
	

}
