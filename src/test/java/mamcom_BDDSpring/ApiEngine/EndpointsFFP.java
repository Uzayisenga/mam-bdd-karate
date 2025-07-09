package mamcom_BDDSpring.ApiEngine;

//import com.mamcom_BDDSpring.DataModel_API_Request.*;
import mamcom_BDDSpring.DataModel_API_Request.*;
import mamcom_BDDSpring.JsonObjectGenerator.JsonObjectGenerator;
import mamcom_BDDSpring.annotations.PageObjects;
import mamcom_BDDSpring.config.PropertyFile;
import mamcom_BDDSpring.config.ProxyConfig;
import mamcom_BDDSpring.dataProvider.Member;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.assertEquals;

@PageObjects
@Data
public class EndpointsFFP {


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
        System.out.println("getBaseOrigin: "+ dataProvider.getBaseOrigin());
        System.out.println("getBaseHost : "+ dataProvider.getBaseHost());

         ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .header("Authorization", dataProvider.getAuthKey())
                .contentType( "application/json" )
                .body( jsonObjectGenerator.getEnrolmentJsonBody(enrolmentFFP) )
                .when()
                .post( dataProvider.getBaseHost() + "/v1/user" );
//         .post( dataProvider.getBaseHost() + "/v1/oneid" );
        assertEquals( 201, response.statusCode() );
        return response;
    }

    public Response EnrolmentBasicUser(BasicUserEnrolment basicUserEnrolment) {
        System.out.println("EnrolmentUser: "+jsonObjectGenerator.getEnrolmentJsonBody(basicUserEnrolment) );

        ProxyConfig.setupProxy(propertyFile);

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

         ProxyConfig.setupProxy(propertyFile);

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
        System.out.println("user logins via API");
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

    public Response updateUser_2FA(){
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType("application/json")
                .cookies(dataProvider.getCookies())
                .body( jsonObjectGenerator.getJsonBody(jsonObjectGenerator.create_2FABody()) )
                .when()
                .put(dataProvider.getBaseHost() + "/v1/user/"+member.getCustNo());
        assertEquals( 204, response.statusCode() );
        return response;
    }

    public Response getMobileContactPoints(){
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .cookies(dataProvider.getCookies())
                .when()
                .get(dataProvider.getBaseHost() + "/v1/user/"+member.getCustNo()+"/contactpoint");
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
        System.out.println("getBaseOrigin: "+ dataProvider.getBaseOrigin());
        System.out.println("getBaseHost : "+ dataProvider.getBaseHost());
        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .header("udh-common-tenant",tenant)
                .header("Cookie", "3db13f3f93aa995dadde4ecdd58ff879=bc813f8f9b4675708e7e77d99ecd20f6")
                .header("x-api-key", "XETbeBbtrBAYSnGUlh1PUlCD03Ag2AGq")
                .contentType( "application/json" )
                .body(connectPayload )
                .when()
                .post( dataProvider.getBaseHost() + "/testing/v3/udh/user/create" );
        assertEquals( 201, response.statusCode() );

        return response;

    }


    public Response mfaActivation(mfa mfa){


        String mfaPayload = mfa.mfa_intial();
        System.out.println(mfaPayload);
        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType("application/json")
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
               .cookie("STAT Cookie")
                .cookies(dataProvider.getCookies())
                .body(mfaPayload )
                .when()
                .post(dataProvider.getBaseHost() +"/oauth2/mfa/totp");
        assertEquals( 201, response.statusCode() );
        return response;
    }

    public Response mfaconfirmation(String code){



        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType("application/x-www-form-urlencoded")
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .header("x-scope", "urn:milesandmore:oauth:multifactorauthentication:totp")
                .cookie("STAT Cookie")
                .cookies(dataProvider.getCookies())
                .formParam("code",code) //customer.getAliasName())
                .when()
                .post(dataProvider.getBaseHost() +"/oauth2/mfa/totp/confirmation");
        assertEquals( 201, response.statusCode() );
        return response;
    }
    public Response LegacyEnrolment(legacyFFPPayload legacyFFPpayload) {

//        System.out.println("EnrolmentUser Req Body: "+jsonObjectGenerator.getEnrolmentJsonBody(udhEnrolment));
        String legacyPayload = legacyFFPpayload.LegacyFFPEnrolement();
        System.out.println("Legacy EnrolmentUser Req Body: "+legacyPayload);
        JSONObject jsonObject = new JSONObject(legacyPayload);
        FirstName = jsonObject.get("userName").toString();
        System.out.println(FirstName);
        System.out.println("getBaseOrigin: "+ dataProvider.getBaseOrigin());
        System.out.println("getBaseHost : "+ dataProvider.getBaseHost());
        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType( "application/json" )
                .body( legacyPayload )
                .when()
                .post( dataProvider.getBaseHost() + "/v1/user" );
        assertEquals( 201, response.statusCode() );

        return response;

    }

    public Response Login1(String username, String password) {

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .contentType("application/x-www-form-urlencoded"  )
                .header( "Origin", dataProvider.getBaseOrigin() )
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
        assertEquals( 201, response.statusCode());
        System.out.println("user logins via API");
        dataProvider.setCookies(response.getDetailedCookies());
        return response;
    }

    public Response TravelIDBasic(TravelIDBasic travelIDBasic) {
        System.out.println("EnrolmentUser Data: "+travelIDBasic );

        ProxyConfig.setupProxy(propertyFile);

        response = given()
                .header("Origin", dataProvider.getBaseOrigin())
                .contentType( "application/json" )
                .header("X-AUTHORIZATION", dataProvider.getBaseBearer())
                .body( travelIDBasic )
                .when()
                .post( dataProvider.getBaseHost() + "/testing/v3/testdatamanagement" );
        assertEquals( 201, response.statusCode() );
        return response;
    }
}
