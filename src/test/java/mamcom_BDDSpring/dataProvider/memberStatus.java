package mamcom_BDDSpring.dataProvider;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class memberStatus {


    private String clientProcessingNumber = "APP20180810-153917-7856";
    private String flightNr = "400";
    private String flightDate;
    private String origin = "FRA";
    private String destination = "JFK";
    private String partnerCode = "LH";
    private String serialNumber;
    private String airlineCode = "16";
    private String bookingClass = "F";

//    =========================================================
//    private String flightNr = "400";
//    private String flightDate;
//    private String origin = "FRA";


}
