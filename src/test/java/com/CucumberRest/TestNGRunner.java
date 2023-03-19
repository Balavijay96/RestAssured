package com.CucumberRest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestNGRunner {
	
	
	RestAssuredBaseClass rest;
	@DataProvider(name = "data-provider")
	public Object[][] postMethod() {
		// TODO Auto-generated method stub
		rest=new RestAssuredBaseClass("https://restful-booker.herokuapp.com/");
		
		rest.setHeader("Content-Type", "application/json");
		rest.setBody("{\r\n"
				+ "    \"firstname\": \"Bala\",\r\n"
				+ "    \"lastname\": \"Vijay\",\r\n"
				+ "    \"totalprice\": 11122,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\",\r\n"
				+ "        \"code\":\"yfhsagfgyu8y8t8ytuhgjgtjh8u24\",\r\n"
				+ "        \"ids\":\"tr8y185iuuuouhuh8uh\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Extra pillows please\"\r\n"
				+ "}");
		Response r=rest.sendPostRequest("booking/");
		 int s= r.jsonPath().get("bookingid");
		 System.out.println(s);
		  return new Object[][] {{s}};
	
		
	}
	@Test(dataProvider="data-provider")
	private void nextMethod(int s) {
		rest.sendGetRequest("booking/"+s);
		System.out.println(rest.response.asPrettyString());
	}

}
