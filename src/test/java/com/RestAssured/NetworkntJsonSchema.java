package com.RestAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class NetworkntJsonSchema {
@Test
	private void validateJsonSchema() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V4);
		File input= new File("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\input.json");
		FileInputStream schema = new FileInputStream("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\schema.json");
		JsonSchema schema2 = factory.getSchema(schema);
		JsonNode readTree = mapper.readTree(input);
		Set<ValidationMessage> validate = schema2.validate(readTree);
		
		
		if(validate.isEmpty()) {
			System.out.println("No Errors");
		}
		else {
			for(ValidationMessage message:validate) {
				
				System.out.println(message);
				
			}
		}
		
	}
}
