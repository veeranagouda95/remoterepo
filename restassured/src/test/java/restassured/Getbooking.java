package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Getbooking {

	public static void main(String[] args) {
		//build request

		RequestSpecification requestspecification = RestAssured.given().log().all();
		requestspecification.baseUri("https://restful-booker.herokuapp.com/");
		requestspecification.basePath("booking/{id}");

		//thier no body is present in get methods

		requestspecification.pathParam("id", 10);

		//hit the request and get response
		Response response = requestspecification.get();


		//validate the response
		ValidatableResponse validatetableresponse = response.then().log().all();
		validatetableresponse.statusCode(200); 
	}
}


//or
//Restassured
//.given()
//.log()
//.all()
//.baseuri("https://restful-booker.herokuapp.com/");
//.basePath("booking/{id}");
//.pathParam("id", 10);
//when()
//.get()
//.then()
//.log()
//.all()
//.statuscode()
