package mamcom_BDDSpring.config;


import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PageObjects
@PropertySource("classpath:locators.properties")
public class LocatorsPropertyFile5 {



    @Value("${offermansory}")
    private String offermansory;

    @Value("${offermansory_list}")
    private String offermansory_list;

    @Value("${single_offer}")
    private String single_offer;

    @Value("${single_container}")
    private String single_container;


    @Value("${promo_offer}")
    private String promo_offer;


    @Value("${promo_banner}")
    private String promo_banner;


    @Value("${offer_hub}")
    private String offer_hub;

    @Value("${large_image}")
    private String large_image;


    @Value("${rightside_hub}")
    private String rightside_hub;

    @Value("${topside_hub}")
    private String topside_hub;

    @Value("${second_slide}")
    private String second_slide;

    @Value("${annual_review}")
    private String annual_review;

    @Value("${annual_display}")
    private String annual_display;

    @Value("${my_airlines}")
    private String my_airlines;

    @Value("${airline_top}")
    private String airline_top;

    @Value("${upgrade_welcome}")
    private String upgrade_welcome;

    @Value("${oneway}")
    private String oneway;

    @Value("${footer_newsletter}")
    private String footer_newsletter;







}
