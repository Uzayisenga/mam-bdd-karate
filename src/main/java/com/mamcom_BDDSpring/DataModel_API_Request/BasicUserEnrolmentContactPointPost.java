package com.mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;

@Data
public class BasicUserEnrolmentContactPointPost extends BasicUserEnrolmentContactPoints{

    protected String channel;
    protected String city;
    protected String country;
    protected boolean postBoxAddress;
    protected boolean standard;
    protected String street;
    protected String usage;
    protected String zipCode;
    protected String additionalAddressInformation;
    protected String countryCode;


    public BasicUserEnrolmentContactPointPost() {}

    public BasicUserEnrolmentContactPointPost(String channel,String city,String country,
                                              boolean postBoxAddress,boolean standard,String street,String usage,
                                              String zipCode ) {
//        super(usage, channel, standard);

        this.channel = channel;
        this.city = city;
        this.country = country;
        this.postBoxAddress=postBoxAddress;
        this.standard = standard;
        this.street = street;
        this.usage = usage;
        this.zipCode = zipCode;

    }
}
