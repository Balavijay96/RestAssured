package com.RestAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;

public class Deserialisation {
			public static String json;
			public void usingObjectMapper() throws JsonMappingException, JsonProcessingException {
		json="{\r\n"
				+ "  \"firstname\" : \"Balasubu\",\r\n"
				+ "  \"lastname\" : \"Vijay\",\r\n"
				+ "  \"email\" : \"bala@gmail.com\",\r\n"
				+ "  \"skills\" : [ \"java\", \"selenium\" ]\r\n"
				+ "}\r\n"
				+ "";
	
		ObjectMapper mapper= new ObjectMapper();
		Employee r=mapper.readValue(json,Employee.class);
		System.out.println(r.getFirstname());
		System.out.println(r.getLastname());
		System.out.println(r.getSkills());
	
	}
			
			private void usingJsonPath() {
				//To deserialize using jsonPath Mapping provider used in congiguration
				JacksonMappingProvider mapping=new JacksonMappingProvider();
				Configuration config = Configuration.builder()
					.mappingProvider(mapping)
					.build();
				Employee e = JsonPath.using(config)
						.parse(json)
						.read("$",Employee.class);
				
				System.out.println(e.getFirstname());
				System.out.println(e.getLastname());
				System.out.println(e.getEmail());
				System.out.println(e.getSkills());
			}
			
			private void usingRestAssuredJsonPath() {
					
			}
			
			public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
				Deserialisation d=new Deserialisation();
				d.usingObjectMapper();
				d.usingJsonPath();
				d.usingRestAssuredJsonPath();
			}

}
