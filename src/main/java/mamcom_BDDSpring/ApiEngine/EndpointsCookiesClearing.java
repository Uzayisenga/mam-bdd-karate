package mamcom_BDDSpring.ApiEngine;

import io.restassured.response.Response;
import mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import mamcom_BDDSpring.annotations.PageObjects;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
// REMOVED: JUnit assertion import. Assertions should be handled in test classes.
// import static org.junit.Assert.assertEquals;

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
                .header("X-AUTHORIZATION", "Basic YOUR_CREDENTIALS==") // Ensure this is a valid/safe credential or placeholder
                .contentType( "application/json" )
                .when()
                .post( "https://api.dev.miles-and-more.com/testing/v3/revoketoken" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("SelniumCookies failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }
}
