package com.mamcom_BDDSpring.dataProvider;


import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects

public class CreditCard {

    private String Cardtype;
    private String Cardholder;
    private String CreditcardNumber;
    private String Cvc;
    private String Expiry;

    public CreditCard(String Cardtype, String Cardholder, String CreditcardNumber, String Cvc, String Expiry) {
        this.Cardtype = Cardtype;
        this.Cardholder = Cardholder;
        this.CreditcardNumber = CreditcardNumber;
        this.Cvc = Cvc;
        this.Expiry = Expiry;
    }

    public CreditCard() {}

}
