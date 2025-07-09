package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class EnrolmentContext {

    private String language="D";
    private String country="DE";
    private String tenantId;


    public EnrolmentContext(){}

    public EnrolmentContext(String language, String country, String tenantId) {
        this.language = language;
        this.country = country;
        this.tenantId = tenantId;
    }
    public EnrolmentContext(String tenantId) {
        this.tenantId = tenantId;
    }


}
