package mamcom_BDDSpring.DataModel_API_Request;
import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

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