package com.example.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class SampleAPITest {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send GET request and validate response
        Response response = RestAssured
            .given()
            .when()
            .get("/posts/1")
            .then()
            .statusCode(200)  // Validate status code
            .body("userId", equalTo(1)) // Validate JSON field
            .body("id", equalTo(1))
            .extract()
            .response();

        System.out.println("Response Body: " + response.asString());
    }
}
