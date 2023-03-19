package testng;
import java.util.Scanner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestNgAPI {
	Response response;
		@DataProvider(name = "data-provider")
	public Object[][] postMethod() {
	response = RestAssured
		.given()
			.baseUri("https://restful-booker.herokuapp.com/")
			.given()
			.contentType("application/json")
			.body("{\r\n"
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
					+ "}")
		.when()
			.post("booking");
		System.out.println(response.asString());

	  
		String checkout = response.jsonPath().getString("booking.bookingdates.checkout");
		String checkin=response.jsonPath().getString("booking.bookingdates.checkin");

	    System.out.println("Check-in Date: " + checkin);
	    System.out.println("Check-out Date: " + checkout);
	    checkin="2023-03-17";
	    return new Object[][] {{ checkin,checkout}};

	}
		@Test(dataProvider="data-provider")
	public void nextMethod(String checkin,String checkout) {
		
		System.out.println(checkin);
		
	response = RestAssured
	.given()
		.baseUri("https://restful-booker.herokuapp.com/")
		.given()
		.contentType("application/json")
		.body("{\r\n"
				+ "    \"firstname\": \"Bala\",\r\n"
				+ "    \"lastname\": \"Vijay\",\r\n"
				+ "    \"totalprice\": 11122,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ " \"checkin\": \"" + checkin + "\",\r\n"
		            + "        \"checkout\": \"" + checkout + "\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Extra pillows please\"\r\n"
				+ "}")
		.log()
		.all()
	.when()
		.post("booking");
	System.out.println("Second"+response.asPrettyString());
				
			}
	
	    @Test
	    public void thirdMethod() {
	    	
	    	Scanner s= new Scanner(System.in);
	    	System.out.println("Enter the booking id:");
	    	String id=s.nextLine();
	        JsonPath jsonPath = response.jsonPath();
	        String bookingId = jsonPath.getString("bookingid");
	        RestAssured.given()
	        .when().get("https://restful-booker.herokuapp.com/booking/"+id)
	        .then().log().all();
	    }


	
}