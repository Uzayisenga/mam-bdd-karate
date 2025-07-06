package com.mamcom_BDDSpring.DataModel_API_Request;


import lombok.Data;

@Data
public class EnrolmentContactPointsPostTEV extends EnrolmentContactPointsTEV{

    protected boolean standard;
    protected String country;
    protected String city;
    protected String zipCode;
    protected String street;

    public EnrolmentContactPointsPostTEV() {}

    public EnrolmentContactPointsPostTEV(String usage, String channel, boolean standard, String country, String city,
                                      String zipCode, String street) {
        super(usage, channel);
        this.usage = usage;
        this.channel = channel;
        this.standard = standard;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
    }

}
