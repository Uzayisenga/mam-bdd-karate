package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class EnrolmentAliasesTEV<v, k> {

    public String type = "LHCOM";
    public String aliasName;
    public String password = "Test@1234";

    public EnrolmentAliasesTEV() {}

    public EnrolmentAliasesTEV(String type, String aliasName, String password) {
        this.type = type;
        this.aliasName = aliasName;
        this.password = password;
    }
    public EnrolmentAliasesTEV(String aliasName) {
        this.aliasName = aliasName;
    }
}


