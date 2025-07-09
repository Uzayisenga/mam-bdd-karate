package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class mfa {

    public String mfa_intial(){

        return "{\n" +
                "\"authAppDisplayName\": \"Google Authenticator\"\n" +
                "    }" ;
    }
}
