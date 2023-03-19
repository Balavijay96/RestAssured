package com.RestAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;

public class JsonPathMultipleRead {

	public static void main(String[] args) throws InvalidJsonException, IOException {
		FileInputStream f= new FileInputStream("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\JsonPath.json");
		Object parse = Configuration.defaultConfiguration().jsonProvider()
		.parse(f.readAllBytes());
		List<Object> names= JsonPath.read(parse,"$.members");
		for (Object name : names) {
			System.out.println(name);	
		}
		
		
	}
}
