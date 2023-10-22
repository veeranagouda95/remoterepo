package restassured;

//Refactor POST request in Rest Assured using meyhod channing

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class shortcutCreateBooking {
	public static void main(String[] args) {
		//build request
		//RequestSpecification requestSpecification = RestAssured.given();
		// requestSpecification =RestAssured.given().log().all();
		//   RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/");
		//method channing concept in it
		//set up request
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
		// hit the request and get responce
		.post()
		//validate  the responsce
		.then()
		.log()
		.all()
		.statusCode(200);

		//hit Request and get response
		//Response response = requestSpecification.post();

		//validate Response
		//ValidatableResponse validatetableResponse = response.then().log().all();
		//the above log(),all() output on consloe responce on the console
		//validatetableResponse.statusCode(200);
	}
}

