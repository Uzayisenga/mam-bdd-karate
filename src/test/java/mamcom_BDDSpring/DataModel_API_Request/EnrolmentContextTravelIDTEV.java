package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class EnrolmentContextTravelIDTEV {

    private String channel="web";
    private String country;
    private String language;
    private String origin;
    private String tenantId;
    private String principal_type;

    private String client_id;
    private String redirect_uri;
    private String reduced_state="NONE";
    private String response_type="code";
    private String scope;
    private String state;

    // private String channel="worldshop";
   // private String redirecturi="https%3A%2F%2Fuat.worldshop.eu%2Floginreturn";
    public EnrolmentContextTravelIDTEV(){}
    public EnrolmentContextTravelIDTEV(String language,String tenantId,String country,String principal_type,String origin,String channel,String redirecturi) {
        this.language = language;
        this.country = country;
        this.tenantId = tenantId;
        this.origin = origin;
        this.channel = channel;
        this.principal_type =principal_type;
      //  this.redirecturi=redirecturi;
    }
    public EnrolmentContextTravelIDTEV(String language,String tenantId,String country,String origin,String principal_type) {

        this.language = language;
        this.tenantId = tenantId;
        this.country = country;
        this.origin = origin;
        this.principal_type =principal_type;
    }

//    Newly added

    public EnrolmentContextTravelIDTEV(String language,String tenantId,String country,String origin,String principal_type,String reduced_state,String response_type, String scope, String state) {

        this.language = language;
        this.tenantId = tenantId;
        this.country = country;
        this.origin = origin;
        this.principal_type =principal_type;
        this.reduced_state=reduced_state;
        this.response_type=response_type;
        this.scope=scope;
        this.state=state;
    }


}
