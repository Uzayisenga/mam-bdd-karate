package mamcom_BDDSpring.ApiEngine;

// Removed duplicate import for DataModel_API_Request
import mamcom_BDDSpring.DataModel_API_Request.BasicUserEnrolment;
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentFFP;
import mamcom_BDDSpring.DataModel_API_Request.TravelIDBasic;
import mamcom_BDDSpring.DataModel_API_Request.legacyFFPPayload;
import mamcom_BDDSpring.DataModel_API_Request.mfa;
import mamcom_BDDSpring.DataModel_API_Request.udhPayload;

import io.restassured.response.Response;
import lombok.Data;
import mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import mamcom_BDDSpring.annotations.PageObjects;
import mamcom_BDDSpring.config.PropertyFile;
import mamcom_BDDSpring.config.ProxyConfig;
import mamcom_BDDSpring.dataProvider.Member;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
// REMOVED: JUnit assertion import. Assertions should be handled in test classes (e.g., step definitions).
// import static org.junit.jupiter.api.Assertions.assertEquals;

@PageObjects
@Data
public class EndpointsFFP_UAT3 {

    @Autowired
    private JsonObjectGenerator jsonObjectGenerator;

    private Response response;

    @Autowired
    private mamcom_BDDSpring.dataProvider.dataProvider dataProvider;

    @Autowired
    private PropertyFile propertyFile;

    @Autowired
    Member member;

    public static String emailID;
    public static String FirstName;

    public Response EnrolmentUser(EnrolmentFFP enrolmentFFP) {

        System.out.println("EnrolmentUser Req Body: "+jsonObjectGenerator.getEnrolmentJsonBody(enrolmentFFP) );
        System.out.println("getUAT3_BaseOrigin(): "+ dataProvider.getUAT3_BaseOrigin());
        System.out.println("getBaseHost : "+ dataProvider.getUAT3_BaseHost());

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .header("Authorization", dataProvider.getAuthKey())
                .contentType( "application/json" )
                .body( jsonObjectGenerator.getEnrolmentJsonBody(enrolmentFFP) )
                .when()
                .post( dataProvider.getUAT3_BaseHost() + "/v1/user" );
//         .post( dataProvider.getUAT3_BaseHost() + "/v1/oneid" );
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

        ProxyConfig.setupProxy(propertyFile);

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
        System.out.println("user logins via API");
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

    public Response updateToTravelID() {
        System.out.println("UpdateStatus: "+jsonObjectGenerator.getJsonBody(jsonObjectGenerator.userupdate_Json()) );
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
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

    public Response GetDetails(){
//        System.out.println(dataProvider.getUAT3_BaseOrigin());
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getUAT3_BaseHost() +"/member/v3/me");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("GetDetails failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response updateUser_2FA(){
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
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/contactpoint");
        System.out.println("Response Code "+ response.statusCode());
        System.out.println("Body "+ response.getBody().asString());
        return response;
    }

    public Response ConnectEnrolment(udhPayload udhpayload, String tenant ) {

//        System.out.println("EnrolmentUser Req Body: "+jsonObjectGenerator.getEnrolmentJsonBody(udhEnrolment));
        String connectPayload = udhpayload.udhEnrolement();
        System.out.println("EnrolmentUser Req Body: "+connectPayload);
        JSONObject jsonObject = new JSONObject(connectPayload);
        emailID = jsonObject.get("userName").toString();
        System.out.println(emailID);
        System.out.println("getUAT3_BaseOrigin(): "+ dataProvider.getUAT3_BaseOrigin());
        System.out.println("getBaseHost : "+ dataProvider.getUAT3_BaseHost());
        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .header("udh-common-tenant",tenant)
                .header("Cookie", "3db13f3f93aa995dadde4ecdd58ff879=bc813f8f9b4675708e7e77d99ecd20f6")
                .header("x-api-key", "XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .contentType( "application/json" )
                .body(connectPayload )
                .when()
                .post( dataProvider.getUAT3_BaseHost() + "/testing/v3/udh/user/create" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("ConnectEnrolment failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }


    public Response mfaActivation(mfa mfa){

        String mfaPayload = mfa.mfa_intial();
        System.out.println(mfaPayload);
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .cookie("STAT")
                .cookies(dataProvider.getCookies())
                .body(mfaPayload )
                .when()
                .post(dataProvider.getUAT3_BaseHost() +"/oauth2/mfa/totp");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("mfaActivation failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response mfaconfirmation(String code){

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/x-www-form-urlencoded")
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .header("x-scope", "urn:milesandmore:oauth:multifactorauthentication:totp")
                .cookie("STAT")
                .cookies(dataProvider.getCookies())
                .formParam("code",code) //customer.getAliasName())
                .when()
                .post(dataProvider.getUAT3_BaseHost() +"/oauth2/mfa/totp/confirmation");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("mfaconfirmation failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }
    public Response LegacyEnrolment(legacyFFPPayload legacyFFPpayload) {

//        System.out.println("EnrolmentUser Req Body: "+jsonObjectGenerator.getEnrolmentJsonBody(udhEnrolment));
        String legacyPayload = legacyFFPpayload.LegacyFFPEnrolement();
        System.out.println("Legacy EnrolmentUser Req Body: "+legacyPayload);
        JSONObject jsonObject = new JSONObject(legacyPayload);
        FirstName = jsonObject.get("userName").toString();
        System.out.println(FirstName);
        System.out.println("getUAT3_BaseOrigin(): "+ dataProvider.getUAT3_BaseOrigin());
        System.out.println("getBaseHost : "+ dataProvider.getBaseHost());
        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType( "application/json" )
                .body( legacyPayload )
                .when()
                .post( dataProvider.getBaseHost() + "/v1/user" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("LegacyEnrolment failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response Login1(String username, String password) {

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .contentType("application/x-www-form-urlencoded"  )
                .header( "Origin", dataProvider.getUAT3_BaseOrigin() )
                .header("x-api-key", "XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
//                .header("x-logintype", "USER_PWD")
                .header("x-scope", "AUTHENTICATED IDENTIFIED")
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .formParam("username",username) //customer.getAliasName())
                .formParam("password",password) //customer.getPassword())
                .formParam("customer_number",member.getCustNo()) //customer.getPassword())
                .formParam("grant_type", "client_credentials")
                .when()
                .post(dataProvider.getBaseHost()+"/oauth2/token");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("Login1 failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        System.out.println("user logins via API");
        dataProvider.setCookies(response.getDetailedCookies());
        return response;
    }

    public Response TravelIDBasic(TravelIDBasic travelIDBasic) {
        System.out.println("EnrolmentUser Data: "+travelIDBasic );

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType( "application/json" )
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .body( travelIDBasic )
                .when()
                .post( dataProvider.getBaseHost() + "/testing/v3/testdatamanagement" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("TravelIDBasic failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }
}
