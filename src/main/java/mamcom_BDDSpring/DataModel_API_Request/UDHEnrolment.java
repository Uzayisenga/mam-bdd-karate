package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class UDHEnrolment {

    private String initialPassword;
    private String userName;
    private Profile profile;


    UDHEnrolment(){
       Profile p = new Profile();
       p.getGeneralDetails();
       p.getPostalAddresses();
       setProfile(p);

   }

}
