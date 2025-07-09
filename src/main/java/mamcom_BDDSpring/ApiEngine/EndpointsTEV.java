package mamcom_BDDSpring.ApiEngine;

import io.restassured.response.Response;
import mamcom_BDDSpring.DataModel_API_Request.BasicUserEnrolment;
import mamcom_BDDSpring.DataModel_API_Request.EnrollmentPayLoad;
import mamcom_BDDSpring.DataModel_API_Request.Enrolment;
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentFFP;
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentTEV;
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentTravelIdTEV;
import mamcom_BDDSpring.DataModel_API_Request.forgetPinPasswordPayload;
import mamcom_BDDSpring.DataModel_API_Request.mfa; // Added missing import
import mamcom_BDDSpring.DataModel_API_Request.udhPayload; // Added missing import
import mamcom_BDDSpring.DataModel_API_Request.legacyFFPPayload; // Added missing import
import mamcom_BDDSpring.DataModel_API_Request.TravelIDBasic; // Added missing import
import mamcom_BDDSpring.DataModel_API_Request.ResetPinPassword; // Added missing import

import mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import mamcom_BDDSpring.annotations.LazyAutowired;
import mamcom_BDDSpring.annotations.PageObjects;
import mamcom_BDDSpring.config.PropertyFile;
import mamcom_BDDSpring.config.ProxyConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
// REMOVED: JUnit assertion import. Assertions should be handled in test classes.
// import static org.junit.Assert.assertEquals;

@PageObjects
public class EndpointsTEV {


    @Autowired
    private JsonObjectGenerator jsonObjectGenerator;

    private Response response;

    @Autowired
    private PropertyFile propertyFile;

    @LazyAutowired
    Endpoints endpoints;

    @Autowired
    private BasicUserEnrolment basicUserEnrolment;

    @Autowired
    private EnrolmentFFP enrolmentFFP;

    @Autowired
    private mamcom_BDDSpring.dataProvider.updateUser updateUser;


    @Autowired
    private mamcom_BDDSpring.dataProvider.dataProvider dataProvider;

    public static String payload;
    public static String serviceCardNumber;

    public Response EnrolmentUser(EnrolmentTEV enrolmentTEV) {
        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTEV) );
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType( "application/json" )
                .body( jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTEV) )
                .when()
//                .post( dataProvider.getBaseHost() + "/user/v3/enrolment" );
                .post( dataProvider.getBaseHost() + "/v1/user/enrolment");

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
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType( "application/json" )
                .cookie("")
                .cookie(dataProvider.getCookie())
                .header("x-variation","travelid")
                .header("x-api-key","XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .body( jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTravelIdTEV) )
                .when()
                .post( dataProvider.getBaseHost() + "/user/v3/enrolment" );
//                .post( dataProvider.getBaseHost() + "/v1/user/enrolment");

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

                        payload = forgetPinPasswordPayload.forgetPinPassword("lx", "SERVICE_CARD_NUMBER", "nmQFO8BiRJeAlACYpy6uun8APdewyZxJ", "https://qa-www.swiss.com",serviceCardNumber);
                    } else if (tenantId.equals("OS Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("os", "SERVICE_CARD_NUMBER", "eqswPWLkydOffXb7B3ILZz9HWap5SADa", "https://qa-www.austrian.com",serviceCardNumber);
                    } else if (tenantId.equals("SN Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("sn", "SERVICE_CARD_NUMBER", "tNugDtB7CCT9G48zTGPWFXy37vaNAb6F", "https://qa-www.brusselsairlines.com",serviceCardNumber);
                    } else if (tenantId.equals("MMG")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("mam", "SERVICE_CARD_NUMBER", "vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98", "https://www-uat1.miles-and-more.com",serviceCardNumber);

                    }
                }
                else if (loginType.equals("Username")) {
                    if (tenantId.equals("LH Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lh", "USER_NAME", "U2KNSi09XfUmbIDHV4UUgYGjAs47IEwu", "https://qa-www.lufthansa.com", enrolmentFFP.getAliases().get(0).getAliasName());
                    } else if (tenantId.equals("LX Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lx", "USER_NAME", "nmQFO8BiRJeAlACYpy6uun8APdewyZxJ", "https://qa-www.swiss.com", enrolmentFFP.getAliases().get(0).getAliasName());
                    } else if (tenantId.equals("OS Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("os", "USER_NAME", "eqswPWLkydOffXb7B3ILZz9HWap5SADa", "https://qa-www.austrian.com", enrolmentFFP.getAliases().get(0).getAliasName());
                    } else if (tenantId.equals("SN Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("sn", "USER_NAME", "tNugDtB7CCT9G48zTGPWFXy37vaNAb6F", "https://qa-www.brusselsairlines.com", enrolmentFFP.getAliases().get(0).getAliasName());
                    } else if (tenantId.equals("MMG")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("mam", "USER_NAME", "vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98", "https://www-uat1.miles-and-more.com", enrolmentFFP.getAliases().get(0).getAliasName());

                    }
                }
                break;
            case ("TravelID Basic"):
                if (loginType.equals("Email")) {
                    if (tenantId.equals("LH Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lh", "EMAIL", "U2KNSi09XfUmbIDHV4UUgYGjAs47IEwu", "https://qa-www.lufthansa.com", basicUserEnrolment.getOneId());
                    } else if (tenantId.equals("LX Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lx", "EMAIL", "nmQFO8BiRJeAlACYpy6uun8APdewyZxJ", "https://qa-www.swiss.com", basicUserEnrolment.getOneId());
                    } else if (tenantId.equals("OS Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("os", "EMAIL", "eqswPWLkydOffXb7B3ILZz9HWap5SADa", "https://qa-www.austrian.com", basicUserEnrolment.getOneId());
                    } else if (tenantId.equals("SN Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("sn", "EMAIL", "tNugDtB7CCT9G48zTGPWFXy37vaNAb6F", "https://qa-www.brusselsairlines.com", basicUserEnrolment.getOneId());
                    }
                }
                break;
        }
//            String payload = forgetPinPasswordPayload.forgetPinPassword("mam","EMAIL","vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98","https://www-uat1.miles-and-more.com");
        System.out.println(payload);
        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
//                .header("Authorization", dataProvider.getAuthKey())
                .contentType( "application/json" )
//                .cookie("STAT Cookie")
//                .cookie(dataProvider.getCookie())
                .header("x-variation","travelid")
                .header("x-api-key","XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
//                .body( jsonObjectGenerator.getEnrolmentJsonBody(resetPinPassword) )
                .body(payload )
//                .log().all()
                .when()
                .delete( dataProvider.getBaseHost() + "/user/v3/password" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("ResetPinPassword failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }
    public Response ResetPinPasswrod(ResetPinPassword resetPinPassword) {
        System.out.println("resetPinPassword: "+jsonObjectGenerator.getEnrolmentJsonBody(resetPinPassword) );

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
//                .header("Authorization", dataProvider.getAuthKey())
                .contentType( "application/json" )
                .cookie("STAT Cookie")
                .cookie(dataProvider.getCookie())
                .header("x-variation","travelid")
                .header("x-api-key","XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .body( jsonObjectGenerator.getEnrolmentJsonBody(resetPinPassword) )
                .when()
                .delete( dataProvider.getBaseHost() + "/user/v3/password" );
        //               .post( dataProvider.getBaseHost() + "/user/v3/password");
//                .post( dataProvider.getBaseHost() + "/v1/user/enrolment");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("ResetPinPassword failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response ResetPinPasswroduat2(ResetPinPassword resetPinPassword) {
        System.out.println("resetPinPassword: "+jsonObjectGenerator.getEnrolmentJsonBody(resetPinPassword) );

        System.setProperty("http.proxyHost", propertyFile.getProxy_host_ip());
        System.setProperty("http.proxyPort", propertyFile.getProxy_host_port());
        System.setProperty("http.proxyUser", propertyFile.getProxy_uid());
        System.setProperty("http.proxyPassword", propertyFile.getProxy_pwd());
        System.setProperty("https.proxyHost", propertyFile.getProxy_host_ip());
        System.setProperty("https.proxyPort", propertyFile.getProxy_host_port());
        System.setProperty("https.proxyUser", propertyFile.getProxy_uid());
        System.setProperty("https.proxyPassword", propertyFile.getProxy_pwd());

        response = given()
                .header("Origin", dataProvider.getUAT2_BaseOrigin())
//                .header("Authorization", dataProvider.getAuthKey())
                .contentType( "application/json" )
                .cookie("STAT Cookie")
                .cookie(dataProvider.getCookie())
                .header("x-variation","travelid")
                .header("x-api-key","XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .body( jsonObjectGenerator.getEnrolmentJsonBody(resetPinPassword) )
                .when()
                .delete( dataProvider.getUAT2_BaseHost() + "/user/v3/password" );
        //               .post( dataProvider.getBaseHost() + "/user/v3/password");
//                .post( dataProvider.getBaseHost() + "/v1/user/enrolment");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("ResetPinPasswroduat2 failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }



    public Response EnrolmentTravelidUser(EnrolmentTravelIdTEV enrolmentTravelIdTEV) {
        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTravelIdTEV) );
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType( "application/json" )
                .body( jsonObjectGenerator.getEnrolmentJsonBody(enrolmentTravelIdTEV) )
                .when()
//                .post( dataProvider.getBaseHost() + "/user/v3/enrolment" );
                .post( dataProvider.getBaseHost() + "/user/v3/enrolment");

        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 202) {
            throw new RuntimeException("EnrolmentTravelidUser failed: Expected status code 202 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response EnrolmentBasicUser(BasicUserEnrolment basicUserEnrolment) {
        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(basicUserEnrolment) );
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType( "application/json" )
                .body( jsonObjectGenerator.getEnrolmentJsonBody(basicUserEnrolment) )
                .when()
                .post( dataProvider.getBaseHost() + "/oneid/v1" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 201) {
            throw new RuntimeException("EnrolmentBasicUser failed: Expected status code 201 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response Login(String username, String password) {
        response = given()
                .contentType("application/x-www-form-urlencoded"  )
                .header( "Origin", dataProvider.getBaseOrigin() )
                .header("x-logintype", "USER_PWD")
                .header("x-scope", "AUTHENTICATED")
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .formParam("username",username) //customer.getAliasName())
                .formParam("password",password) //customer.getPassword())
                .formParam("grant_type", "password")
                .when()
                .post(dataProvider.getBaseHost()+"/oauth2/token");
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
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType( "application/json" )
                .cookies(dataProvider.getCookies())

                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.updateStatus_Json()) )
                .when()
                .post( dataProvider.getBaseHost() + "/v1/account/me/retro" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("UpdateStatus failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response AccountStatement(){
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() + "/v1/account/me/statement?isHistory=false");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("AccountStatement failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response updateToTravelID() {
        System.out.println("UpdateStatus: "+jsonObjectGenerator.getJsonBody(jsonObjectGenerator.userupdate_Json()) );
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.userupdate_Json()) )
                .when()
                .put(dataProvider.getBaseHost()+"/v1/user/me");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("updateToTravelID failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        dataProvider.setCookies(response.getDetailedCookies());
        return response;
    }

    public Response GetDetails(){
//        System.out.println(dataProvider.getBaseOrigin());
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() +"/member/v3/me");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 200) {
            throw new RuntimeException("GetDetails failed: Expected status code 200 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }

    public Response ResetPinPasswrod_uat2(forgetPinPasswordPayload forgetPinPasswordPayload,String userType, String loginType, String tenantId) {
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
                    dataProvider.setResponse(endpoints.GetDetails_UAT2());
                    String serviceCardNumberApi = dataProvider.getResponse().getBody().asString();
                    System.out.println(serviceCardNumberApi);
                    JSONObject jo = new JSONObject(serviceCardNumberApi);
                    System.out.println("SCN from JSON : " + jo.getString("primaryCardNumber"));
                    serviceCardNumber = jo.getString("primaryCardNumber");

                    if (tenantId.equals("LH Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lh", "SERVICE_CARD_NUMBER", "U2KNSi09XfUmbIDHV4UUgYGjAs47IEwu", "https://qa-www.lufthansa.com",serviceCardNumber);
                    } else if (tenantId.equals("LX Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lx", "SERVICE_CARD_NUMBER", "nmQFO8BiRJeAlACYpy6uun8APdewyZxJ", "https://qa-www.swiss.com",serviceCardNumber);
                    } else if (tenantId.equals("OS Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("os", "SERVICE_CARD_NUMBER", "eqswPWLkydOffXb7B3ILZz9HWap5SADa", "https://qa-www.austrian.com",serviceCardNumber);
                    } else if (tenantId.equals("SN Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("sn", "SERVICE_CARD_NUMBER", "tNugDtB7CCT9G48zTGPWFXy37vaNAb6F", "https://qa-www.brusselsairlines.com",serviceCardNumber);
                    } else if (tenantId.equals("MMG")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("mam", "SERVICE_CARD_NUMBER", "vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98", "https://www-uat2.miles-and-more.com",serviceCardNumber);

                    }
                }
                else if (loginType.equals("Username")) {
                    if (tenantId.equals("LH Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lh", "USER_NAME", "U2KNSi09XfUmbIDHV4UUgYGjAs47IEwu", "https://qa-www.lufthansa.com", enrolmentFFP.getAliases().get(0).getAliasName());
                    } else if (tenantId.equals("LX Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lx", "USER_NAME", "nmQFO8BiRJeAlACYpy6uun8APdewyZxJ", "https://qa-www.swiss.com", enrolmentFFP.getAliases().get(0).getAliasName());
                    } else if (tenantId.equals("OS Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("os", "USER_NAME", "eqswPWLkydOffXb7B3ILZz9HWap5SADa", "https://qa-www.austrian.com", enrolmentFFP.getAliases().get(0).getAliasName());
                    } else if (tenantId.equals("SN Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("sn", "USER_NAME", "tNugDtB7CCT9G48zTGPWFXy37vaNAb6F", "https://qa-www.brusselsairlines.com", enrolmentFFP.getAliases().get(0).getAliasName());
                    } else if (tenantId.equals("MMG")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("mam", "USER_NAME", "vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98", "https://www-uat2.miles-and-more.com", enrolmentFFP.getAliases().get(0).getAliasName());

                    }
                }
                break;
            case ("TravelID Basic"):
                if (loginType.equals("Email")) {
                    if (tenantId.equals("LH Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lh", "EMAIL", "U2KNSi09XfUmbIDHV4UUgYGjAs47IEwu", "https://qa-www.lufthansa.com", basicUserEnrolment.getOneId());
                    } else if (tenantId.equals("LX Web")) {

                        payload = forgetPinPasswordPayload.forgetPinPassword("lx", "EMAIL", "nmQFO8BiRJeAlACYpy6uun8APdewyZxJ", "https://qa-www.swiss.com", basicUserEnrolment.getOneId());
                    } else if (tenantId.equals("OS Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("os", "EMAIL", "eqswPWLkydOffXb7B3ILZz9HWap5SADa", "https://qa-www.austrian.com", basicUserEnrolment.getOneId());
                    } else if (tenantId.equals("SN Web")) {
                        payload = forgetPinPasswordPayload.forgetPinPassword("sn", "EMAIL", "tNugDtB7CCT9G48zTGPWFXy37vaNAb6F", "https://qa-www.brusselsairlines.com", basicUserEnrolment.getOneId());
                    }
                }
                break;
        }
//            String payload = forgetPinPasswordPayload.forgetPinPassword("mam","EMAIL","vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98","https://www-uat1.miles-and-more.com");
        System.out.println(payload);
        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT2_BaseOrigin())
//                .header("Authorization", dataProvider.getAuthKey())
                .contentType( "application/json" )
//                .cookie("STAT Cookie")
//                .cookie(dataProvider.getCookie())
                .header("x-variation","travelid")
                .header("x-api-key","XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
//                .body( jsonObjectGenerator.getEnrolmentJsonBody(resetPinPassword) )
                .body(payload )
//                .log().all()
                .when()
                .delete( dataProvider.getUAT2_BaseHost() + "/user/v3/password" );
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("ResetPinPasswrod_uat2 failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }
    public Response ResetPinPasswrod_uat2f(ResetPinPassword resetPinPassword) {
        System.out.println("resetPinPassword: "+jsonObjectGenerator.getEnrolmentJsonBody(resetPinPassword) );

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getUAT2_BaseOrigin())
//                .header("Authorization", dataProvider.getAuthKey())
                .contentType( "application/json" )
                .cookie("STAT Cookie")
                .cookie(dataProvider.getCookie())
                .header("x-variation","travelid")
                .header("x-api-key","XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .body( jsonObjectGenerator.getEnrolmentJsonBody(resetPinPassword) )
                .when()
                .delete( dataProvider.getUAT2_BaseHost() + "/user/v3/password" );
        //               .post( dataProvider.getBaseHost() + "/user/v3/password");
//                .post( dataProvider.getBaseHost() + "/v1/user/enrolment");
        // REPLACED: JUnit assertion with a runtime check.
        if (response.statusCode() != 204) {
            throw new RuntimeException("ResetPinPasswrod_uat2f failed: Expected status code 204 but got " + response.statusCode() + ". Response body: " + response.getBody().asString());
        }
        return response;
    }
}
