package com.RestAssured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Serialization {
	@Test
	private void json() {
	
		
		Map<String,Object> jsonBody = new HashMap<String,Object> ();
		
	//	List <String> skill = new ArrayList<String>();
		
		//skill.add("Java");
		//skill.add("Selenium");
		jsonBody.put("First_Name", "Ran");
		jsonBody.put("Last_Name", "Jith");
		jsonBody.put("Email", "ranjith@gmail.com");
		jsonBody.put("Skills", Arrays.asList("Java","Selenium"));
		
		RestAssured.
			given().
				baseUri("http://localhost:3000/").	
				header("Content-Type","application/json")
				.body(jsonBody)
					.log()
					.all()
			.when()
				.post("posts")
			.then()
				.log()
					.all();
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
		
		

