package com.RestAssured;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class FluentAPI {
	 
	public static File jsonFile;
	
	public void oneMethod() throws IOException {
		jsonFile= new File("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\booksjsonpath.json");
		DocumentContext parse = JsonPath.parse(jsonFile);
		Object read = parse.read("$..book");
		System.out.println(read);
		//System.out.println(JsonPath.parse(jsonFile).read("$..title"));
	}
	
	private void anotherMethod() throws IOException {
			Configuration conf = Configuration.defaultConfiguration();
			List <Object> read = JsonPath.using(conf)
					.parse(jsonFile)
					.read("$..book");
			for (Object object : read) {
				System.out.println(object);
			}
			//System.out.println(read);
	}

	public static void main(String[] args) throws IOException {
		FluentAPI read= new FluentAPI();
		read.oneMethod();
		read.anotherMethod();
	}
}
