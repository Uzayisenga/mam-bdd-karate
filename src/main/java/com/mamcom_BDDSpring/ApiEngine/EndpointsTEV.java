package com.mamcom_BDDSpring.ApiEngine;

import com.mamcom_BDDSpring.DataModel_API_Request.*;
import com.mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import com.mamcom_BDDSpring.annotations.LazyAutowired;
import com.mamcom_BDDSpring.annotations.PageObjects;
import com.mamcom_BDDSpring.config.PropertyFile;
import com.mamcom_BDDSpring.config.ProxyConfig;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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
    private com.mamcom_BDDSpring.dataProvider.updateUser updateUser;


    @Autowired
    private com.mamcom_BDDSpring.dataProvider.dataProvider dataProvider;

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

        assertEquals( 202, response.statusCode() );
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

        assertEquals( 201, response.statusCode() );
        return response;
    }

    public Response ResetPinPasswrod(forgetPinPasswordPayload forgetPinPasswordPayload,String userType, String loginType, String tenantId) {
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
        assertEquals( 204, response.statusCode() );

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
        assertEquals( 204, response.statusCode() );
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
        assertEquals( 204, response.statusCode() );
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

        assertEquals( 202, response.statusCode() );
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
        assertEquals( 201, response.statusCode() );
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
        assertEquals( 201, response.statusCode());
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
        assertEquals( 200, response.statusCode() );
        return response;
    }

    public Response AccountStatement(){
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() + "/v1/account/me/statement?isHistory=false");
        assertEquals( 200, response.statusCode() );
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
        assertEquals( 204, response.statusCode());
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
        assertEquals( 200, response.statusCode() );
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
        assertEquals( 204, response.statusCode() );

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
        assertEquals( 204, response.statusCode() );
        return response;
    }
}
