package com.RestAssured;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Put {
	
	@Test
	private void update() throws ParseException {
		
		Response response = RestAssured.given().baseUri("http://localhost:3000/").get("posts/47");
		
		
		 String string = response.asString();

		 JSONParser parser = new JSONParser();
         Object obj = parser.parse(string);
         JSONObject jsonObject = (JSONObject) obj;
         jsonObject.put("id", 77);
         
         RestAssured.given().baseUri("http://localhost:3000/").contentType("application/json").body(jsonObject.toString()).log().all().put("posts/47").then().log().all();
         
         
		
		
		
	}

}
