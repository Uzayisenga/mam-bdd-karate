package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

import java.util.ArrayList;

@Data
@PageObjects
public class Profile {

    private GeneralDetails generalDetails;
    private ArrayList<PostalAddresses> postalAddresses;


    Profile(){
        GeneralDetails gd = new GeneralDetails();
        gd.getAction();
        gd.getFirstName();
        gd.getLastName();
        gd.getDateOfBirth();
        setGeneralDetails(gd);
        ArrayList<PostalAddresses> pa =new ArrayList<PostalAddresses>();
        PostalAddresses p1 =new PostalAddresses();
        p1.getAction();
        p1.getAddressType();
        p1.getCountry();
        pa.add(p1);
        setPostalAddresses(pa);
    }



}