package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;

@Data

public class EnrolmentContactPointsPost extends EnrolmentContactPoints{

    protected String country;
    protected String city;
    protected String zipCode;
    protected String street;
    protected String additionalAddressInformation;

    public EnrolmentContactPointsPost() {}

    public EnrolmentContactPointsPost(String usage, String channel, boolean standard, String country, String city,
                                      String zipCode, String street, String additionalAddressInformation) {
        super(usage, channel, standard);
        this.usage = usage;
        this.channel = channel;
        this.standard = standard;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.additionalAddressInformation = additionalAddressInformation;
    }

}
