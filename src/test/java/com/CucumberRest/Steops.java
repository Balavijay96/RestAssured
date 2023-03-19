package com.CucumberRest;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steops {
	public static RestAssuredBaseClass r;
	@Given("entering The BaseURI")
	public void entering_the_base_uri() {
		 r=new RestAssuredBaseClass("http://localhost:3000/");
	}
	@Given("selects The Headers")
	public void selects_the_headers() {
		
		r.setHeader("Content-Type", "application/json");
	}
	@Given("enters The Json Body To be Create")
	public void enters_the_json_body_to_be_create() {
		
		r.setBody("{\"name\":\"BalaM2P\",\"age\":\"27\"}");
	}
	@When("selects The Post Methods and Resourse Path")
	public void selects_the_post_methods_and_resourse_path() {
		r.sendPostRequest("posts/");
	}
	@Then("it Validates")
	public void it_validates() {
		
		int statusCode = r.getStatusCode();
		Assert.assertEquals(statusCode,201);
	}



}
