package mamcom_BDDSpring.dataProvider;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class cucumberdataTable {
    private String ticketPrice;
    private String surcharge;
    private String currency;
    private String origin;
    private String destination;
    private String outboundOrigin;
    private String outboundDestination;
    private String inboundOrigin;
    private String inboundDestination;
    private String route1_Origin;
    private String route1_Destination;
    private String route2_Origin;
    private String route2_Destination;
    private String operatedBy;
    private String bookingClass;
    private String flightSegment;
    private String title;
    private String academicTitle;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String country;
    private String street;
    private String zipCode;
    private String city;
    private String email;
    private String phoneNumber;
    private String serviceCard;
    private String userName;
    private String password = "Test@1234";
    private String preferredPartner;
    private String generalConsent;
    private int stepperSize;
    private String day;
    private String month;
    private String year;
    private String additionalInformation;
    private String countryCode;
    private String areaCode;
    private String number;
    private String state ;


 }