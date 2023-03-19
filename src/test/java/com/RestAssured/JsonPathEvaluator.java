package com.RestAssured;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class JsonPathEvaluator {
//its reads only on time	
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\JsonPath.json");
		List <Object> read = JsonPath.read(f, "$.members[?(@.secretIdentity=='Wonderwoman')].powers");
		for (Object object : read) {
			System.out.println(object);
		}
		
		
	}
	
	
	
	

}
