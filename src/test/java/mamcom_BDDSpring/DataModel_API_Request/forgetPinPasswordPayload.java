package mamcom_BDDSpring.DataModel_API_Request;


import mamcom_BDDSpring.annotations.LazyAutowired;
import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;


@Data
@PageObjects
public class forgetPinPasswordPayload {

    @LazyAutowired
    private mamcom_BDDSpring.dataProvider.updateUser updateUser;

    private String tenantID;
    private String principal_type;
    private String ClientID;
    private String redirect_uri;
    private String principal;


    public String forgetPinPassword(String tenantID,String principal_type,String ClientID,String redirect_uri,String principal){

        return "{\n  " +
                " \"context\":" +
                "{\n   " +
                "   \"channel\":\"web\",\n  " +
                "    \"country\":\"de\",\n    " +
                "  \"language\":\"en\",\n   " +
                "   \"origin\":\"de\",\n  " +
                "    \"tenantId\":\""+tenantID+"\",\n   " +
                "   \"principal_type\":\""+principal_type+"\",\n   " +
                "   \"client_id\":\""+ClientID+"\",\n    " +
                "  \"redirect_uri\":\""+redirect_uri+"\",\n    " +
                "  \"reduced_state\":\"NONE\",\n  " +
                "    \"response_type\":\"code\",\n   " +
                "   \"scope\":\"AUTHENTICATED+IDENTIFIED+urn%3Amilesandmore%3Atech%3Abackground%3Av1%3Aactive\",\n  " +
                "    \"state\":\"OTE0NzEwNDc0MjI5MDE4OTE5NTYyMDgyNDIxMTgxNDMxNzEyMzgyMTM\"\n " +
                "  },\n  " +
                " \"principal\":\""+principal+"\",\n " +
                "  \"principalType\":\""+principal_type+"\",\n " +
                "  \"redirect_uri\":\""+redirect_uri+"\"\n" +
                "}";

    }
}