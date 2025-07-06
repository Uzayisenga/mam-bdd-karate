package com.mamcom_BDDSpring.ApiEngine;

import com.mamcom_BDDSpring.DataModel_API_Request.Enrolment;
import com.mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import com.mamcom_BDDSpring.annotations.PageObjects;
import com.mamcom_BDDSpring.dataProvider.dataProvider;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@PageObjects
public class EndpointsCookiesClearing {


        @Autowired
        private JsonObjectGenerator jsonObjectGenerator;

        private Response response;

        @Autowired
        private com.mamcom_BDDSpring.dataProvider.dataProvider dataProvider;

    public Response SelniumCookies() {
//        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(enrolment) );
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .header("X-AUTHORIZATION", "Basic YOUR_CREDENTIALS==")
                .contentType( "application/json" )
                .when()
                .post( "https://api.dev.miles-and-more.com/testing/v3/revoketoken" );
        assertEquals( 200, response.statusCode() );
        return response;
    }



}
