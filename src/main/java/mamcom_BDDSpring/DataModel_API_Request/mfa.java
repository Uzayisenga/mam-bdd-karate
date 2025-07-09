package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class mfa {

    public String mfa_intial(){

        return "{\n" +
                "\"authAppDisplayName\": \"Google Authenticator\"\n" +
                "    }" ;
    }
}
