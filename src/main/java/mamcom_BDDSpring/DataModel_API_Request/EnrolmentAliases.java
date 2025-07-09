package mamcom_BDDSpring.DataModel_API_Request;


import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class EnrolmentAliases {
    private int id = 0;
    private String type = "LHCOM";
    private String aliasName;
    private String password = "Test@1234";

    public EnrolmentAliases() {}

    public EnrolmentAliases(int id, String type, String aliasName, String password) {
        this.id = id;
        this.type = type;
        this.aliasName = aliasName;
        this.password = password;
    }

    public EnrolmentAliases(String aliasName) {
        this.aliasName = aliasName;


    }
}

