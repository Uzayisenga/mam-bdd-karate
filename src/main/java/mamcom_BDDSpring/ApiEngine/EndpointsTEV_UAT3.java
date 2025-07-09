package mamcom_BDDSpring.ApiEngine;


import io.restassured.response.Response;
import mamcom_BDDSpring.DataModel_API_Request.BasicUserEnrolment;
import mamcom_BDDSpring.DataModel_API_Request.EnrollmentPayLoad;
import mamcom_BDDSpring.DataModel_API_Request.Enrolment; // Assuming this is needed, based on original imports
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentFFP;
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentTEV; // Added specific import for EnrolmentTEV
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentTravelIdTEV; // Added specific import for EnrolmentTravelIdTEV
import mamcom_BDDSpring.DataModel_API_Request.forgetPinPasswordPayload; // Added specific import for forgetPinPasswordPayload
import mamcom_BDDSpring.DataModel_API_Request.mfa; // Added specific import for mfa
import mamcom_BDDSpring.DataModel_API_Request.udhPayload; // Added specific import for udhPayload
import mamcom_BDDSpring.DataModel_API_Request.legacyFFPPayload; // Added specific import for legacyFFPPayload
import mamcom_BDDSpring.DataModel_API_Request.TravelIDBasic; // Added specific import for TravelIDBasic

import mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import mamcom_BDDSpring.annotations.LazyAutowired;
import mamcom_BDDSpring.annotations.PageObjects;
import mamcom_BDDSpring.config.PropertyFile;
import mamcom_BDDSpring.config.ProxyConfig;
import mamcom_BDDSpring.dataProvider.Member; // Explicitly import Member
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
// REMOVED: JUnit 4 assertion import. Assertions should be handled in test classes.
// import static org.junit.Assert.assertEquals;


@PageObjects
public class EndpointsTEV_UAT3 {


    @Autowired
    private JsonObjectGenerator jsonObjectGenerator;

    private Response response;

    @Autowired
    private PropertyFile propertyFile;

    @LazyAutowired
    Endpoints endpoints; // Assuming 'Endpoints' is another class in ApiEngine

    @Autowired
    private BasicUserEnrolment basicUserEnrolment;

    @Autowired
    private EnrolmentFFP enrolmentFFP;

    @Autowired
    private mamcom_BDDSpring.dataProvider.updateUser updateUser;


    @Autowired
    private mamcom_BDDSpring.dataProvider.dataProvider dataProvider;

    @LazyAutowired // Autowire Member directly as it's used directly
    private Member member;

    public static String payload;
    public static String serviceCardNumber;

    public Response EnrolmentUser(EnrolmentTEV enrolmentTEV) {
        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTEV) );
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType( "application/json" )
                .body( jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTEV) )
                .when()
//                .post( dataProvider.getUAT3_BaseHost() + "/user/v3/enrolment" );
                .post( dataProvider.getUAT3_BaseHost() + "/v1/user/enrolment");

        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 202) {
            throw new RuntimeException("EnrolmentUser failed: Expected status code 202 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response EnrolmentUserTravelid(EnrolmentTravelIdTEV enrolmentTravelIdTEV) {
        System.out.println("EnrolmentUserTravelid: "+jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTravelIdTEV) );

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType( "application/json" )
                .cookie("") // Consider if this empty cookie is intentional or a placeholder
                .cookie(dataProvider.getCookie())
                .header("x-variation","travelid")
                .header("x-api-key","XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .body( jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTravelIdTEV) )
                .when()
                .post( dataProvider.getUAT3_BaseHost() + "/user/v3/enrolment" );
//                .post( dataProvider.getUAT3_BaseHost() + "/v1/user/enrolment");

        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("EnrolmentUserTravelid failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response ResetPinPasswrod(forgetPinPasswordPayload forgetPinPasswordPayload, String userType, String loginType, String tenantId) {
        switch (userType){
            case ("TravelID FFP"):
                if (loginType.equals("Email")) {
                    if (tenantId.equals("LH Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lh", "EMAIL", "U2KNSi09XfUmbIDHV4UUgYGjAs47IEwu", "https://qa-www.lufthansa.com", updateUser.getAliasName());
                    } else if (tenantId.equals("LX Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lx", "EMAIL", "nmQFO8BiRJeAlACYpy6uun8APdewyZxJ", "https://qa-www.swiss.com", updateUser.getAliasName());
                    } else if (tenantId.equals("OS Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("os", "EMAIL", "eqswPWLkydOffXb7B3ILZz9HWap5SADa", "https://qa-www.austrian.com", updateUser.getAliasName());
                    } else if (tenantId.equals("SN Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("sn", "EMAIL", "tNugDtB7CCT9G48zTGPWFXy37vaNAb6F", "https://qa-www.brusselsairlines.com", updateUser.getAliasName());
                    } else if (tenantId.equals("MMG")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("mam", "EMAIL", "vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98", dataProvider.getMamURl(), updateUser.getAliasName());

                    }

                }
                break;
            case ("Legacy FFP"):
                if (loginType.equals("SCN")) {
                    dataProvider.setResponse(endpoints.GetDetails());
                    String serviceCardNumberApi = dataProvider.getResponse().getBody().asString();
                    System.out.println(serviceCardNumberApi);
                    JSONObject jo = new JSONObject(serviceCardNumberApi);
                    System.out.println("SCN from JSON : " + jo.getString("primaryCardNumber"));
                    serviceCardNumber = jo.getString("primaryCardNumber");

                    if (tenantId.equals("LH Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lh", "SERVICE_CARD_NUMBER", "U2KNSi09XfUmbIDHV4UUgYGjAs47IEwu", "https://qa-www.lufthansa.com",serviceCardNumber);
                    } else if (tenantId.equals("LX Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lx", "SERVICE_CARD_NUMBER", "nmQFO8BiRJeAlACYpy6uun8APdewyZxJ", "https://qa-www.swiss.com", updateUser.getAliasName()); // This line was cut off, assuming similar pattern
                    }
                }
                break; // Added missing break for the outer switch case
        }
        // Assuming a response is generated here based on the payload
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .body(payload)
                .when()
                .post(dataProvider.getUAT3_BaseHost() + "/v1/password/reset"); // Example endpoint, adjust as needed

        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) { // Assuming 200 is expected for successful reset request
            throw new RuntimeException("ResetPinPassword failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response GetDetails(){
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

    public Response Login(String username, String password) {
        response = given()
                .contentType("application/x-www-form-urlencoded")
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .header("x-logintype", "USER_PWD")
                .header("x-scope", "AUTHENTICATED")
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .formParam("username", username)
                .formParam("password", password)
                .formParam("grant_type", "password")
                .when()
                .post(dataProvider.getUAT3_BaseHost() + "/oauth2/token");
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
                .put(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()); // CORRECTED: Use directly autowired 'member'
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("updateUser_2FA failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response getMobileContactPoints(){
        System.out.println(member.getCustNo()); // CORRECTED: Use directly autowired 'member'
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/contactpoint"); // CORRECTED: Use directly autowired 'member'
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
                .queryParam("intPrefix", member.getInternationalDialingPrefix()) // CORRECTED: Use directly autowired 'member'
                .queryParam("localNr", member.getLocalNumber()) // CORRECTED: Use directly autowired 'member'
                .queryParam("userId", member.getCustNo()) // CORRECTED: Use directly autowired 'member'
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
//              .queryParam("intPrefix", member.getInternationalDialingPrefix()) // Commented out
//              .queryParam("localNr", member.getLocalNumber()) // Commented out
//              .queryParam("userId", member.getCustNo()) // Commented out
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
        // No assertion in original, so no change needed here.
        return response;
    }

    public Response GetDetailsFromMemberV3(){ // Renamed to avoid conflict with existing GetDetails
        System.out.println(dataProvider.getUAT3_BaseOrigin());

        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .cookie("STAT Cookie")
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getUAT3_BaseHost() +"/member/v3/me");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("GetDetailsFromMemberV3 failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response userEnebledAllInOneUser() {
        System.out.println("UpdateStatus: "+jsonObjectGenerator.getJsonBody(jsonObjectGenerator.createAllInOneBody()));
        System.out.println(member.getCustNo()); // CORRECTED: Use directly autowired 'member'
        response = given()
                .header("Origin", dataProvider.getUAT3_BaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.createAllInOneBody()) )
                .when()
                .put(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/permission/all-in-one"); // CORRECTED: Use directly autowired 'member'
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
                .get(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/permission"); // CORRECTED: Use directly autowired 'member'
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
                .get(dataProvider.getUAT3_BaseHost() + "/v1/user/"+member.getCustNo()+"/subscription"); // CORRECTED: Use directly autowired 'member'
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
