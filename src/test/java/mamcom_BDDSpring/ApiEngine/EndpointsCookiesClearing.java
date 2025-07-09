package mamcom_BDDSpring.ApiEngine;

import mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import mamcom_BDDSpring.annotations.PageObjects;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
// REMOVED: JUnit 4 assertion import
// import static org.junit.Assert.assertEquals;
// ADDED: JUnit 5 Assertions import for test classes
import org.junit.jupiter.api.Assertions;


@PageObjects
public class EndpointsCookiesClearing {


    @Autowired
    private JsonObjectGenerator jsonObjectGenerator;

    private Response response;

    @Autowired
    private mamcom_BDDSpring.dataProvider.dataProvider dataProvider;

    public Response SelniumCookies() {
//        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(enrolment) );
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .header("X-AUTHORIZATION", "Basic YOUR_CREDENTIALS==")
                .contentType( "application/json" )
                .when()
                .post( "https://api.dev.miles-and-more.com/testing/v3/revoketoken" );
        // CHANGED: Use JUnit 5 Assertions.assertEquals
        Assertions.assertEquals( 200, response.statusCode(), "SelniumCookies failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        return response;
    }
}
