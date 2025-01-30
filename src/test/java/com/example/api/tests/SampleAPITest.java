package com.example.api.tests;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

@Epic("API Testing")
@Feature("Sample REST Assured Tests")
public class SampleAPITest {

    @Test(description = "Validate GET /posts/1 endpoint")
    @Story("GET Request Validation")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Allure.step("Send GET request to /posts/1 and validate the response");
        Response response = RestAssured
                .given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .extract()
                .response();

        Allure.step("Print the response body");
        System.out.println("Response Body: " + response.asString());
    }
}
