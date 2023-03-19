package com.RestAssured;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;


public class HamcrestMatcher {
	@Test
	public void hamcrestschema() throws IOException{
		File input = new File("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\input.json");
		
		//String inputs = input.toString();
		String inputs = FileUtils.readFileToString(input);
		
		File schema = new File("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\schema.json");
		
		JsonSchemaValidator schema2 = JsonSchemaValidator.matchesJsonSchema(schema);
		
	//	JsonSchemaValidator schema12 = JsonSchemaValidator.matchesJsonSchema(input);
		
		MatcherAssert.assertThat(inputs,schema2);
		
		
	}

}
