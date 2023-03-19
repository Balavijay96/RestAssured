package com.CucumberRest;

import org.testng.Assert;

import com.RestAssured.Employee;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Runner  {
	
	
	
	public static void main(String[] args) {
		
		RestAssuredBaseClass r= new RestAssuredBaseClass("http://localhost:3000/");
	
		Response rk= r.sendGetRequest("posts/71/");
		
		
		String responseBody = r.getResponseBody();
		
	String object = rk.jsonPath().get("name");
	
	Employee e= new Employee();
	e.setFirstname(object);
	String firstname = e.getLastname();
	System.out.println(firstname);
		
	
	}
}
