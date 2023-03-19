package com.RestAssured;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

	public class JsonSchema {
	@Test
	private void jsonSchemaValidating() {
		
		File input= new File("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\input.json");
		
		RestAssured
			.given()
				.baseUri("http://localhost:3000/")
				.contentType("application/json")
					.body(input)
					
			.when()
				.post("posts")
			.then()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
				.log()
				.all();
				
			
	}
	
	

}
