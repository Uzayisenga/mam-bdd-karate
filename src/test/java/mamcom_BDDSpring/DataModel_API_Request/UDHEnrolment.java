package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

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
