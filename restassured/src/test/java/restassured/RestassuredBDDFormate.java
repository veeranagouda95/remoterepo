package restassured;

//i am not using cucumber 

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestassuredBDDFormate {

	public static void main(String[] args) {
		//given-build request
		RestAssured
		.given()
		   .log()
		   .all()
		   .baseUri("https://restful-booker.herokuapp.com/")
		   .basePath("booking")
		   .body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}")

		    //	requestSpecification.contentType("application/json");//this one method content type overloaded method
		    .contentType(ContentType.JSON)
		 .when()
		   .post()
		 .then()
		   .statusCode(200);
		    
		
	}
}
