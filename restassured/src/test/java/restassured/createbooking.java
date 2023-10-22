package restassured;

//post request in rest assured

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class createbooking {
	public static void main(String[] args) {
		//build request
		          RequestSpecification requestSpecification = RestAssured.given().log().all();//in order to print the something
		          //requestSpecification=requestSpecification.log().all();another way writing code 
		          //it print console that request side of it
		          requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		          requestSpecification.basePath("booking");
		
		          requestSpecification.body("{\r\n"
				        + "    \"firstname\" : \"Jim\",\r\n"
				        + "    \"lastname\" : \"Brown\",\r\n"
				        + "    \"totalprice\" : 111,\r\n"
				        + "    \"depositpaid\" : true,\r\n"
				        + "    \"bookingdates\" : {\r\n"
				        + "        \"checkin\" : \"2018-01-01\",\r\n"
				        + "        \"checkout\" : \"2019-01-01\"\r\n"
				        + "    },\r\n"
				        + "    \"additionalneeds\" : \"Breakfast\"\r\n"
				        + "}");
		
	             //	requestSpecification.contentType("application/json");//this one method content type overloaded method
		         requestSpecification.contentType(ContentType.JSON);
		
		//hit Request and get response
		         Response response = requestSpecification.post();
		
		//validate Response
		        ValidatableResponse validatetableResponse = response.then().log().all();
		        //the above log(),all() output on consloe responce on the console
		        validatetableResponse.statusCode(200);
	}
}


//Refactor post request in rest assured using method channing
//or this will written in 
//RestAssured
//.given()
//.baseuri()
//.basepath(booking)
//.contentType(contentType.json)
//.post()
//.then()
//.statuscode(200)
