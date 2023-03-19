package com.RestAssured;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DataFromJsonFile {
	
	@Test
	private void externalFile() {
		File jsonFile= new File("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\data.json");
		RestAssured
		.given()
			.baseUri("http://localhost:3000/")
			.header("Content-Type","application/json")
			.body(jsonFile)
		.when()
			.post("posts")
		.prettyPrint();
	}

}
