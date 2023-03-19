package com.CucumberRest;
	
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class RestAssuredBaseClass {
	    public static RequestSpecification requestSpecification;
	    public static Response response;

	    public RestAssuredBaseClass(String uri) {
	        RestAssured.baseURI = uri; // set the base URI for all requests
	        requestSpecification = RestAssured.given(); // create a new request specification object
	    }

	    public void setHeader(String name, String value) {
	        requestSpecification.header(name, value); // set a header for the request
	    }

	    public static void setQueryParam(String name, String value) {
	        requestSpecification.queryParam(name, value); // set a query parameter for the request
	    }

	    public static void setBody(String body) {
	        requestSpecification.body(body); // set the request body
	    }

	    public static Response sendGetRequest(String path) {
	        return response = requestSpecification.get(path);
	    }

	    public static Response sendPostRequest(String path) {
	        return response = requestSpecification.post(path);
	    }

	    public static void sendPutRequest(String path) {
	        response = requestSpecification.put(path); // send a PUT request and save the response
	    }

	    public static void sendDeleteRequest(String path) {
	        response = requestSpecification.delete(path); // send a DELETE request and save the response
	    }

	    public static int getStatusCode() {
	        return response.getStatusCode(); // get the status code of the response
	    }

	    public static String getResponseBody() {
	        return response.getBody().asString(); // get the response body as a string
	    }
	}



