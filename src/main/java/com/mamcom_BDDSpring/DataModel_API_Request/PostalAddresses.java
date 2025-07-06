package com.mamcom_BDDSpring.DataModel_API_Request;
import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@PageObjects
public class PostalAddresses {

    private String action="INSERT";
    private AddressType addressType;
    private Country country;


     PostalAddresses() {
         AddressType at =new AddressType();
         at.getValue();
         setAddressType(at);
         Country c = new Country();
         c.getValue();
         setCountry(c);

    }





}