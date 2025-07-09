package mamcom_BDDSpring.config;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PageObjects
@PropertySource("classpath:locators.properties")

public class LocatorsPropertyFile3 {

    @Value("${country_conflict}")
    private String country_conflict;

    @Value("${login_cookie}")
    private String login_cookie;

    @Value("${cookie_username}")
    private String cookie_username;

    @Value("${cookie_next}")
    private String cookie_next;

    @Value("${migration_second}")
    private String migration_second;

    @Value("${footer_flag}")
    private String footer_flag;

    @Value("${language_french}")
    private String language_french;

    @Value("${selectcountry_button}")
    private String selectcountry_button;

    @Value("${country_french}")
    private String country_french;

    @Value("${language_savebutton}")
    private String language_savebutton;

    @Value("${countryfrench_backbutton}")
    private String countryfrench_backbutton;

    @Value("${countrychange_french}")
    private String countrychange_french;

    @Value("${country_dropdown}")
    private String country_dropdown;

    @Value("${selectlanguage_french}")
    private String selectlanguage_french;

    @Value("${countrydropdown_scroll}")
    private String countrydropdown_scroll;

    @Value("${country_selection}")
    private String country_selection;

    @Value("${country_savebutton}")
    private String country_savebutton;

    @Value("${preferedlanguage_english}")
    private String preferedlanguage_english;

    @Value("${countryfrench_selection}")
    private String countryfrench_selection;

    @Value("${footer_helpandcontact}")
    private String footer_helpandcontact;

    @Value("${myaccount_icon}")
    private String myaccount_icon;

    @Value("${profile_completeness}")
    private String profile_completeness;

    @Value("${account_profile}")
    private String account_profile;

    @Value("${profile_offerandcommunication}")
    private String profile_offerandcommunication;

    @Value("${offercommunication_backbutton}")
    private String offercommunication_backbutton;

    @Value("${text_offerandcommunication}")
    private String text_offerandcommunication;
    //631
    @Value("${header_programe}")
    private String header_programe;

    @Value("${program_partner}")
    private String program_partner;

    @Value("${header_dropdown}")
    private String header_dropdown;

    @Value("${dropdown_earn}")
    private String dropdown_earn;


    @Value("${earn_hotels}")
    private String earn_hotels;

    @Value("${Lh_header}")
    private String Lh_header;

    @Value("${helpandcontact_pinpassword}")
    private String helpandcontact_pinpassword;

    @Value("${pinpassword_requestpin}")
    private String pinpassword_requestpin;

    @Value("${expand_requestpin}")
    private String expand_requestpin;

    @Value("${faq_helpandcontact}")
    private String faq_helpandcontact;

    @Value("${allarticles_helpandcontact}")
    private String allarticles_helpandcontact;

    @Value("${summary_firstlevel}")
    private String summary_firstlevel;

    @Value("${firstlevel_accountstatement}")
    private String firstlevel_accountstatement;

    @Value("${Summary_secondlevel}")
    private String Summary_secondlevel;

    @Value("${secondlevel_mileageexpiry}")
    private String secondlevel_mileageexpiry;

    @Value("${summary_thirdlevel}")
    private String summary_thirdlevel;

    @Value("${Thirdlevel_validityofmiles}")
    private String Thirdlevel_validityofmiles;

    @Value("${profile_menu}")
    private String profile_menu;

    @Value("${account_logout}")
    private String account_logout;

    @Value("${othercountries_radiobutton}")
    private String othercountries_radiobutton;

    @Value("${homepage_logout}")
    private String homepage_logout;

    @Value("${frenchcountry_french}")
    private String frenchcountry_french;

    @Value("${mapicon_departurefield}")
    private String mapicon_departurefield;

    @Value("${outboundcountry_title}")
    private String outboundcountry_title;

    @Value("${outboundcity_title}")
    private String outboundcity_title;

    @Value("${outboundairport_title}")
    private String outboundairport_title;

    @Value("${departure_selectbutton}")
    private String departure_selectbutton;

    @Value("${mapicon_arrivalfield}")
    private String mapicon_arrivalfield;

    @Value("${arrival_country}")
    private String arrival_country;

    @Value("${oneway_outwardflight}")
    private String oneway_outwardflight;

    @Value("${adult_increment}")
    private String adult_increment;

    @Value("${child_increment}")
    private String child_increment;

    @Value("${search_flight}")
    private String search_flight;

    @Value("${english_language}")
    private String english_language;

    @Value("${languagefield_savebutton}")
    private String languagefield_savebutton;

    @Value("${arrival_selectbutton}")
    private String arrival_selectbutton;

    @Value("${helpandcontact_heading}")
    private String helpandcontact_heading;

    @Value("${mileagecredit_hp}")
    private String mileagecredit_hp;


    @Value("${flightaward_hp}")
    private String flightaward_hp;

    @Value("${furtherawards_hp}")
    private String furtherawards_hp;

    @Value("${status_hp}")
    private String status_hp;

    @Value("${customerprofile_hp}")
    private String customerprofile_hp;

    @Value("${pin_hp}")
    private String pin_hp;

    @Value("${dataprotection_hp}")
    private String dataprotection_hp;

    @Value("${object_hp}")
    private String object_hp;

    @Value("${account_hp}")
    private String account_hp;

    @Value("${miles_hp}")
    private String miles_hp;

    @Value("${technical_hp}")
    private String technical_hp;


    @Value("${contact_hp}")
    private String contact_hp;

    @Value("${tag_hp}")
    private String tag_hp;

    @Value("${requestpin_hp}")
    private String requestpin_hp;

    @Value("${requestpassword_hp}")
    private String requestpassword_hp;

    @Value("${changepin_hp}")
    private String changepin_hp;

    @Value("${changepassword_hp}")
    private String changepassword_hp;

    @Value("${pop_up}")
    private String pop_up;

    @Value("${profilecompleteness_text}")
    private String profilecompleteness_text;


    @Value("${login_hp}")
    private String login_hp;

    @Value("${requestservice_hp}")
    private String requestservice_hp;

    @Value("${heading_rp}")
    private String heading_rp;

    @Value("${helpresult_rp}")
    private String helpresult_rp;

    @Value("${applynow_rp}")
    private String applynow_rp;

    @Value("${description_rp}")
    private String description_rp;

    @Value("${servicecardnumber_pc}")
    private String servicecardnumber_pc;

    @Value("${email_pc}")
    private String email_pc;

    @Value("${mobile_pc}")
    private String mobile_pc;

    @Value("${hc_send}")
    private String hc_send;

    @Value("${datepicker_forwardflight}")
    private String datepicker_forwardflight;

    @Value("${datepicker_previousflight}")
    private String datepicker_previousflight;

    @Value("${closebutton_datepicker}")
    private String closebutton_datepicker;

    @Value("${outbound_field}")
    private String outbound_field;

    @Value("${outbound_calender}")
    private String outbound_calender;

    @Value("${outbound_date}")
    private String outbound_date;

    @Value("${agree_popup}")
    private String agree_popup;

    @Value("${departure_from}")
    private String departure_from;

    @Value("${arrival_at}")
    private String arrival_at;

    @Value("${dep_selection}")
    private String dep_selection;

    @Value("${arrival_selection}")
    private String arrival_selection;

    @Value("${oneway_verify}")
    private String oneway_verify;

    @Value("${oneway_outboundfield}")
    private String oneway_outboundfield;

    @Value("${instant_flightsearch}")
    private String instant_flightsearch;

    @Value("${checkbox_oneway}")
    private String checkbox_oneway;

    @Value("${oneway_datepicker}")
    private String oneway_datepicker;

    @Value("${datepicker_confirm}")
    private String datepicker_confirm;

    @Value("${travelclass_title}")
    private String travelclass_title;

    @Value("${passenger_heading}")
    private String passenger_heading;

    @Value("${adult_title}")
    private String adult_title;

    @Value("${adult_value}")
    private String adult_value;

    @Value("${increment_adult}")
    private String increment_adult;

    @Value("${decrement_adult}")
    private String decrement_adult;

    @Value("${child_title}")
    private String child_title;

    @Value("${increment_child}")
    private String increment_child;

    @Value("${decrement_child}")
    private String decrement_child;

    @Value("${travel_option}")
    private String travel_option;

    @Value("${searchflight_reset}")
    private String searchflight_reset;

    @Value("${searchflight_submit}")
    private String searchflight_submit;

//mileage calculator

    @Value("${earn_mileage}")
    private String earn_mileage;

    @Value("${airlines_mileage}")
    private String airlines_mileage;

    @Value("${mileagecalculator_mileage}")
    private String mileagecalculator_mileage;

    @Value("${quickcalculation_mileage}")
    private String quickcalculation_mileage;

    @Value("${arrivalfield_mileage}")
    private String arrivalfield_mileage;

    @Value("${operatedby_mileage}")
    private String operatedby_mileage;

    @Value("${lufthansa_mileage}")
    private String lufthansa_mileage;

    @Value("${ticketprice_milegae}")
    private String ticketprice_milegae;

    @Value("${arrivalmileage_selection}")
    private String arrivalmileage_selection;

    @Value("${calculation_mileage}")
    private String calculation_mileage;

    @Value("${showdetails_mileage}")
    private String showdetails_mileage;

    @Value("${miles_result}")
    private String miles_result;

    @Value("${points_result}")
    private String points_result;

    @Value("${qualifyingpoints_result}")
    private String qualifyingpoints_result;

    @Value("${honcircle_result}")
    private String honcircle_result;

    @Value("${bookflight_mileage}")
    private String bookflight_mileage;

    @Value("${easymode_tc}")
    private String easymode_tc;

    @Value("${pararesult_expand}")
    private String pararesult_expand;

    @Value("${result_close}")
    private String result_close;

    @Value("${tax_close}")
    private String tax_close;

    @Value("${popup_cancel}")
    private String popup_cancel;

    @Value("${easymode_errormessage}")
    private String easymode_errormessage;

    @Value("${loginNext_after_enroll}")
    private String loginNext_after_enroll;

    @Value("${keep_germany_launch}")
    private String keep_germany_launch;

    @Value("${lufthansa_airline_mc}")
    private String lufthansa_airline_mc;

    @Value("${profile_security_widget}")
    private String profile_security_widget;

    @Value("${pool_give_cancel_event}")
    private String pool_give_cancel_event;

    @Value("${pool_give_event}")
    private String pool_give_event;

    @Value("${pool_give_cancel_event_overview}")
    private String pool_give_cancel_event_overview;

    @Value("${pool_give_event_overview}")
    private String pool_give_event_overview;

    @Value("${status_manage_member_colour}")
    private String status_manage_member_colour;

    @Value("${SCN_xpath_requestpin}")
    private String SCN_xpath_requestpin;

    @Value("${news_carousel}")
    private String news_carousel;

    @Value("${news_carousel_previous}")
    private String news_carousel_previous;

    @Value("${news_carousel_next}")
    private String news_carousel_next;

    @Value("${news_carousel_first}")
    private String news_carousel_first;

    @Value("${HRS_hotel_text}")
    private String HRS_hotel_text;

    @Value("${HRS_hotel_creditcard_img}")
    private String HRS_hotel_creditcard_img;

    @Value("${mfa_close_btn}")
    private String mfa_close_btn;

    @Value("${country_language_backbutton}")
    private String country_language_backbutton;

    @Value("${memberdock_statusimg}")
    private String memberdock_statusimg;

    @Value("${memberdock_partnerimg}")
    private String memberdock_partnerimg;

    @Value("${memberdock_points}")
    private String memberdock_points;

    @Value("${memberdock_miles}")
    private String memberdock_miles;

    @Value("${memberdock_scn}")
    private String memberdock_scn;

    @Value("${memberdock_qualpoints}")
    private String memberdock_qualpoints;

    @Value("${memberdock_honpoints}")
    private String memberdock_honpoints;

    @Value("${memberdock_component}")
    private String memberdock_component;

    @Value("${help_contact_tenant}")
    private String help_contact_tenant;

    @Value("${savepin_submit}")
    private String savepin_submit;

    @Value("${requestpin_profiletab}")
    private String requestpin_profiletab;

    @Value("${enrolment_email_field}")
    private String enrolment_email_field;

    @Value("${enrolment_password_field}")
    private String enrolment_password_field;

    @Value("${enrolment_emailcontinue_tenant}")
    private String enrolment_emailcontinue_tenant;

    @Value("${enrolment_emailcontinue_mam}")
    private String enrolment_emailcontinue_mam;

    @Value("${userClicksOnCountinueButton_mam}")
    private String userClicksOnCountinueButton_mam;

    @Value("${creditmilesandpoints_preprod_hc}")
    private String creditmilesandpoints_preprod_hc;

    @Value("${guardian_approve_button}")
    private String guardian_approve_button;

    @Value("${guardian_approved_success}")
    private String guardian_approved_success;

    @Value("${guardian_decline_button}")
    private String guardian_decline_button;

    @Value("${consent_not_received}")
    private String consent_not_received;

    @Value("${tenant_decline_message}")
    private String tenant_decline_message;

    @Value("${agree_popup_brussels}")
    private String agree_popup_brussels;

    @Value("${mam_login_lang}")
    private String mam_login_lang;
}
