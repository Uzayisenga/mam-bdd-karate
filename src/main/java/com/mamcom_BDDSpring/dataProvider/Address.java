package com.mamcom_BDDSpring.dataProvider;

import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class Address {

    private String Type;
    private boolean Primary;
    private String Salutation;
    private String AcademicTitle;
    private String Company;
    private String FirstName;
    private String LastName;
    private String Country;
    private String StreetWithNumber;
    private int zipCode;
    private String City;
    private String AdditionalInfo;
    private String DhlPackstation;
    private String DhlCustomerno;
    private String DhlPackstationNo;
    private String Street;
    private String Title;
    private String NobilityTitle;
    private String nameOnTicket;
    private String Day;
    private String Month;
    private String Year;
    private String AdditionalAddressInformation;
    private String CountryCode;
    private String Number;
    private String OtherTelephoneNumbers;
    private String PreferredLaunguage;


    public Address() {
    }

    public Address(String Type, boolean Primary, String Salutation, String AcademicTitle, String Company, String FirstName,
                   String LastName, String Country, String StreetWithNumber, int zipCode, String City, String AdditionalInfo,
                   String DhlCustomerno, String DhlPackstation, String DhlPackstationNo, String Day, String Month, String Year, String CountryCode, String Number, String OtherTelephoneNumbers,
                   String Street,String Title, String AdditionalAddressInformation, String PreferredLaunguage,String NobilityTitle,String nameOnTicket) {
        this.Type = Type;
        this.Primary = Primary;
        this.Salutation = Salutation;
        this.AcademicTitle = AcademicTitle;
        this.NobilityTitle = NobilityTitle;
        this.nameOnTicket = nameOnTicket;
        this.Company = Company;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Country = Country;
        this.StreetWithNumber = StreetWithNumber;
        this.zipCode = zipCode;
        this.City = City;
        this.AdditionalInfo = AdditionalInfo;
        this.DhlCustomerno = DhlCustomerno;
        this.DhlPackstation = DhlPackstation;
        this.DhlPackstationNo = DhlPackstationNo;
        this.Title= Title;
        this.Street = Street;
        this.AcademicTitle=AcademicTitle;
        this.Day= Day;
        this.Month= Month;
        this.Year= Year;
        this.AdditionalAddressInformation= AdditionalAddressInformation;
        this.CountryCode = CountryCode;
        this.Number = Number;
        this.OtherTelephoneNumbers = OtherTelephoneNumbers;
        this.PreferredLaunguage = PreferredLaunguage;
    }

    public String getAddress() {
        return Type + " " + Primary + " " + Salutation + " " + AcademicTitle + " " + Company + " " + FirstName + " " + LastName + " " + Country + " "
                + StreetWithNumber + " " + zipCode + " " + City + " " + AdditionalInfo + " " + DhlCustomerno + " " + DhlPackstation + " " +
                DhlPackstationNo +" "+ Country +" "+ Street +" "+ AcademicTitle +" "+ AdditionalAddressInformation +" "+ CountryCode +" "+ Number +" "+ OtherTelephoneNumbers +" "+ PreferredLaunguage;
    }
 }
