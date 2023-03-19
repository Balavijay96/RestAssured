package com.RestAssured;

import java.io.FileOutputStream;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonCreation {
	
	public static void main(String[] args) throws IOException {
		JSONObject json=new JSONObject();
		json.put("Name", "Bala");
		json.put("age", 27);
		json.put("email", "balavijay65@gmail.com");
		JSONArray array = new JSONArray();
		array.add("Bala");
		array.add("Vijay");
		json.put("First_Last_Name", array);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\data1.json");
		String jsonString = json.toJSONString();
		fos.write(jsonString.getBytes());
		fos.close();
		
		
	}

}
