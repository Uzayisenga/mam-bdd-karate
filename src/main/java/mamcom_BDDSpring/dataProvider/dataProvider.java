package mamcom_BDDSpring.dataProvider;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class dataProvider {
    private Response response;
    private String status;
    private String language_parameter = "lang=";
    private String url = "";
    private int id = 0;
    private boolean bool;
    private String path = "/api/v0.1/clients/";
    private String submitconsentpath = "/v1/consents/members/{custNo}/{client_api_key}";
    private String custNo = "";
    private final String hostConsent = "https://consent-store-mconnect-acc.test-msp.miles-and-more.com";
    private final String Origin = "https://net-uat2.miles-and-more.com";
    private final String host = "https://api.test.miles-and-more.com";
    private Cookies cookies;
    private String cookie ="https://{{Host}}/member/v3/me";
    private String requestBody = "";
    private String clientName;
    private String clientUUID;
    //    UAT3
    private String UAT3_BaseHost = "https://api.bloom.miles-and-more.com";
    private String UAT3_BaseOrigin = "https://account-uat3.miles-and-more.com";
    private String UAT3_MamURl="https://www-uat3.miles-and-more.com";
//    UAT1
    private String BaseHost = "https://api.test.miles-and-more.com";
    private String BaseOrigin = "https://account-uat1.miles-and-more.com";
    private String MamURl="https://www-uat1.miles-and-more.com";
//     private String BaseOrigin = "https://net-uat2.miles-and-more.com";

    //    UAT2
    private String UAT2_BaseHost = "https://api.test.miles-and-more.com";
    private String UAT2_BaseOrigin = "https://account-uat2.miles-and-more.com";
    private String UAT2_MamURl="https://www-uat2.miles-and-more.com";


    private String BaseOriginAndCookies= "https://{{Host}}/user/v3/me?dataSet=COMPLETE";
    private String OriginAndCookies="https://{{Host}}/member";
    //  private String BaseBearer="Bearer U2FsdGVkX19vugcsbgjb31bpjNigKysF01dB/nIttvj04bF3eOKEARecpHrnwxf+W1FRZYApKkJ9PTNwMGYcQJ+cp8UKThcypV0Kku0f8lkFMJheFYx3KGgvsmcHIOzJ";
    private String BaseBearer="Bearer U2FsdGVkX19OqWO1/Yr6B1otxCKaTc67UXUN6J56KYeO/0oz9uHZmEC6jcOy77P5RYXIU5pMaRGYMlDGgTsZArxw6auY7XaR0FvDkUktvhdXg84HSUFdcwldBUJDZb+j";
    private String AuthKey= "Basic WEVUYmVCYnRyQkFZU25HVWxoMVBVbENEMDNBZzJBR3E6QVVnalEwdk1ZT2lONVl0Vw==";
    private String mileageCalculatorMode;
    private String primaryCardNumber;
    private String xuserActionLink;

    public String getBaseHost() {
        return "";
    }

    public Object getBaseBearer() {
        return null;
    }
    // private String tenantId;


}
