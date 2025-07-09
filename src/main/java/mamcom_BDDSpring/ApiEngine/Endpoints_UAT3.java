package mamcom_BDDSpring.ApiEngine;


import io.restassured.response.Response;
import mamcom_BDDSpring.DataModel_API_Request.BasicUserEnrolment;
import mamcom_BDDSpring.DataModel_API_Request.EnrollmentPayLoad;
import mamcom_BDDSpring.DataModel_API_Request.Enrolment;
import mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import mamcom_BDDSpring.annotations.LazyAutowired;
import mamcom_BDDSpring.annotations.PageObjects;
import mamcom_BDDSpring.config.PropertyFile;
import mamcom_BDDSpring.config.ProxyConfig;
import mamcom_BDDSpring.dataProvider.Member;
import mamcom_BDDSpring.dataProvider.dataProvider;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
// REMOVED: JUnit 4 assertion import. Assertions should be handled in test classes.
// import static org.junit.Assert.assertEquals;


@PageObjects
public class Endpoints_UAT3 {

    @Autowired
    private JsonObjectGenerator jsonObjectGenerator;

    private Response response;

    @Autowired
    private dataProvider dataProvider;
    @Autowired
    private PropertyFile propertyFile;


    @LazyAutowired
    private Member member;

    public Endpoints_UAT3() {
    }

    public Response EnrolmentUser(Enrolment enrolment) {
        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(enrolment) );
        System.out.println(enrolment);
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType( "application/json" )
                .body( jsonObjectGenerator.getEnrolmentJsonBody(enrolment) )
                .when()
                .post( dataProvider.getUAT3_BaseHost() + "/v1/user" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("EnrolmentUser failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response EnrolmentBasicUser(BasicUserEnrolment basicUserEnrolment) {
        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(basicUserEnrolment) );
        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .header("x-api-key", "XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .contentType( "application/json" )
                .body( jsonObjectGenerator.getEnrolmentJsonBody(basicUserEnrolment) )
                .when()
                .post( dataProvider.getUAT3_BaseHost() + "/oneid/v1" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("EnrolmentBasicUser failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response Login(String username, String password) {

        response = given()
                .contentType("application/x-www-form-urlencoded"  )
                .header( "Origin", dataProvider.getUAT3_BaseOrigin() )
                .header("x-logintype", "USER_PWD")
                .header("x-scope", "AUTHENTICATED")
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .formParam("username",username) //customer.getAliasName())
                .formParam("password",password) //customer.getPassword())
                .formParam("grant_type", "password")
                .when()
                .post(dataProvider.getUAT3_BaseHost()+"/oauth2/token");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("Login failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        dataProvider.setCookies(response.getDetailedCookies());
        return response;
    }

    public Response UpdateStatus() {
        System.out.println("UpdateStatus: "+jsonObjectGenerator.getJsonBody(jsonObjectGenerator.updateStatus_Json()) );
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType( "application/json" )
                .cookies(dataProvider.getCookies())
                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.updateStatus_Json()) )
                .when()
                .post( dataProvider.getUAT3_BaseHost() + "/v1/account/me/retro" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("UpdateStatus failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response AccountStatement(){
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getUAT3_BaseHost() + "/v1/account/me/statement?isHistory=false");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("AccountStatement failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response updateUser_2FA(){
        System.out.println(jsonObjectGenerator.getJsonBody(jsonObjectGenerator.create_2FABody()));
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.create_2FABody()) )

                .when()
                .put(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo());
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("updateUser_2FA failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response getMobileContactPoints(){
        System.out.println(member.getCustNo());
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/contactpoint");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }
    public Response updateToTravelID() {
        System.out.println("UpdateStatus: "+jsonObjectGenerator.getJsonBody(jsonObjectGenerator.userupdate_Json()));
        System.out.println("Update User API");

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookie("STAT Cookie")
                .cookies(dataProvider.getCookies())
                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.userupdate_Json()) )
                .when()
                .put(dataProvider.getUAT3_BaseHost()+"/v1/user/me");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("updateToTravelID failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        dataProvider.setCookies(response.getDetailedCookies());
        return response;
    }

    public Response requestTAN_usingMobileNumber(){

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookie("STAT Cookie")
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .queryParam("intPrefix", member.getInternationalDialingPrefix())
                .queryParam("localNr", member.getLocalNumber())
                .queryParam("userId", member.getCustNo())
                .post(dataProvider.getUAT3_BaseHost() +"/validation/v1/testing/me/sms");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("requestTAN_usingMobileNumber failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }


    public Response requestTAN_usingMobileNumberE2E(String custNo){

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookie("STAT Cookie")
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .queryParam("intPrefix", "+49")
                .queryParam("localNr", "696123456")
                .queryParam("userId",custNo)
                .post(dataProvider.getUAT3_BaseHost() +"/validation/v1/testing/me/sms");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("requestTAN_usingMobileNumberE2E failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }

    public Response getCustNo(String email) {
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .header("x-api-key", "XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .header("Authorization","Basic WEVUYmVCYnRyQkFZU25HVWxoMVBVbENEMDNBZzJBR3E6QVVnalEwdk1ZT2lONVl0Vw==")
                .queryParam("aliasName",email)
                .queryParam("aliasType", "ONEID")
                .get(dataProvider.getUAT3_BaseHost() +"/v1/user/custno");


        System.out.println(dataProvider);
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("getCustNo failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response requestTAN_usingMobileNumberForActiveUser(){

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
//              .queryParam("intPrefix", member.getInternationalDialingPrefix())
//              .queryParam("localNr", member.getLocalNumber())
//              .queryParam("userId", member.getCustNo())
                .post(dataProvider.getUAT3_BaseHost() +"/validation/v1/testing/me/sms");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("requestTAN_usingMobileNumberForActiveUser failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }

    public Response Contactpoint()
    {
        response = given()
                .header("Origin",("https://www-uat1.miles-and-more.com"))
                .cookies(dataProvider.getCookies())
                .when()
                .get("https://api.test.miles-and-more.com/v1/user/me/contactpoint");
        System.out.println("Status " +response.statusCode()+" - OK");
        System.out.println(response.body());
        System.out.println("Contact Points " +response.getBody().asString());
        String contactPointResponse = response.getBody().asString();
        return response;
    }
    public Response GetDetails(){
        System.out.println(dataProvider.getUAT3_BaseOrigin());

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookie("STAT Cookie")
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getUAT3_BaseHost() +"/member/v3/me");
        //      .get(dataProvider.getUAT3_BaseHost() +"/v3/member/me/pin");
        //        .get(dataProvider.getUAT3_BaseHost() +"/v1/member/me");

        System.out.println(dataProvider);
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("GetDetails failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response userEnebledAllInOneUser() {
        System.out.println("UpdateStatus: "+jsonObjectGenerator.getJsonBody(jsonObjectGenerator.createAllInOneBody()));
        System.out.println(member.getCustNo());
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.createAllInOneBody()) )
                .when()
                .put(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/permission/all-in-one");
//                .put(dataProvider.getUAT3_BaseHost() + "/v1/user/me/permission/all-in-one");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }
    public Response validatePermissions() {
        System.out.println("VALIDATE PREMISSIONS");
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
//                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.createAllInOneBody()) )
                .when()
                .get(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/permission");
//                .put(dataProvider.getUAT3_BaseHost() + "/v1/user/me/permission/all-in-one");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        System.out.println("----------------");
        return response;

    }


    public Response subscription() {
        System.out.println("SUBSCRIPTIONS");
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
//                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.createAllInOneBody()) )
                .when()
                .get(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/subscription");
//                .put(dataProvider.getUAT3_BaseHost() + "/v1/user/me/permission/all-in-one");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }



    public Response personalDetails() {
        System.out.println("Personal details");
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() + "/user/v3/me");
        System.out.println("Response Code "+ response.statusCode());

        System.out.println("Body "+ response.getBody().asString());

//
        return response;
    }

    public Response contactDetails() {
        System.out.println("Contact details");
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() + "/user/v3/me/contactpoint");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }

    public Response memberDetails() {
        System.out.println("Member details");
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() + "/member/v3/me");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }

    public Response enrolePermission() {
        System.out.println("Permission Group - PDU & BP");
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() + "/user/v3/me/permission");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }

    public Response enroleSubscription() {
        System.out.println("Subscription - PDU & BP");
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() + "/user/v3/me/subscription");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }


    public Response enrollmentTDM(EnrollmentPayLoad enrollmentPayLoad, String userType1,String userType2, String tenant){
        String payload = enrollmentPayLoad.enrollmentPayload(userType1,userType2,tenant);

        System.out.println(payload);
        response=given()
                .header("Authorization","Basic WEVUYmVCYnRyQkFZU25HVWxoMVBVbENEMDNBZzJBR3E6QVVnalEwdk1ZT2lONVl0Vw==")
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .body(payload)
                .when()
                .post(dataProvider.getBaseHost() + "/testing/v3/testdatamanagement");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("enrollmentTDM failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }
}
