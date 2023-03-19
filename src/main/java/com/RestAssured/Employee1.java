package com.RestAssured;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee1 {
	
	public static void main(String[] args) throws JsonProcessingException {
		Employee e= new Employee();
			e.setFirstname("Bala");
			e.setLastname("Vijay");
			e.setEmail("bala@gmail.com");
			e.setSkills(Arrays.asList("java","selenium"));
			//System.out.println(e.getFirstname());
			ObjectMapper mapper= new ObjectMapper();
			//jackson databind
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(e);
			System.out.println(json);
	
	}

}
