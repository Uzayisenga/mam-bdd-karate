package mamcom_BDDSpring.config;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PageObjects
@PropertySource("classpath:locators.properties")
public class LocatorsPropertyFile4 {
    @Value("${loginuat3_next}")
    private String loginuat3_next;

    @Value("${finaluat3_login}")
    private String finaluat3_login;

    @Value("${cdn_mam_loginuat3_xpath}")
    private String cdn_mam_loginuat3_xpath;

//    @Value("${request_code}")
//    private String request_code;

    @Value("${confirm_button_2fa}")
    private String confirm_button_2fa;

    @Value("${login_continue}")
    private String login_continue;

    @Value("${form_lateloginnext}")
    private String form_lateloginnext;

    @Value("${inbox_skip}")
    private String inbox_skip;

    @Value("${message_deletearchieve}")
    private String message_deletearchieve;

    @Value("${accountstatement_popup}")
    private String accountstatement_popup;

    @Value("${keep_germany}")
    private String keep_germany;

    @Value("${airlinesave_germany}")
    private String airlinesave_germany;

    @Value("${homepage_logoutfrench}")
    private String homepage_logoutfrench;

    @Value("${Cdm_mam_login_xpath}")
    private String Cdm_mam_login_xpath;

    @Value("${centraloffer_image}")
    private String centraloffer_image;

    @Value("${stepitem_heading}")
    private String stepitem_heading;

    @Value("${stepitem1}")
    private String stepitem1;

    @Value("${stepitem2}")
    private String stepitem2;

    @Value("${stepitem3}")
    private String stepitem3;

    @Value("${stepitem4}")
    private String stepitem4;

    @Value("${stepitem_sub1}")
    private String stepitem_sub1;

    @Value("${stepitem_sub2}")
    private String stepitem_sub2;

    @Value("${stepitem_sub3}")
    private String stepitem_sub3;

    @Value("${stepitem_sub4}")
    private String stepitem_sub4;

    @Value("${Accordian_xpath}")
    private String Accordian_xpath;

    @Value("${Accordian_content}")
    private String Accordian_content;

    @Value("${mp_okbutton}")
    private String mp_okbutton;

    @Value("${mam_forgot_travelId_link}")
    private String mam_forgot_travelId_link;

    @Value("${backtorpofile}")
    private String backtorpofile;

    @Value("${glance_image}")
    private String glance_image;

    @Value("${goodreason_text}")
    private String goodreason_text;

    @Value("${glance_earnmilestext}")
    private String glance_earnmilestext;

    @Value("${glance_lifeline}")
    private String glance_lifeline;

    @Value("${glance_register}")
    private String glance_register;

    @Value("${airasia_partner}")
    private String airasia_partner;

    @Value("${airasia_partnerdescription}")
    private String airasia_partnerdescription;

    @Value("${tag_airasia}")
    private String tag_airasia;

    @Value("${tag_partner}")
    private String tag_partner;

    @Value("${tag_airlines}")
    private String tag_airlines;

    @Value("${backtopartner}")
    private String backtopartner;

    @Value("${header_helpcontact}")
    private String header_helpcontact;

    @Value("${passwordchange_hp}")
    private String passwordchange_hp;

    @Value("${hp_changepin}")
    private String hp_changepin;

    @Value("${changepin_headinghp}")
    private String changepin_headinghp;

    @Value("${expand_customerservice}")
    private String expand_customerservice;

    @Value("${customerservice_tags}")
    private String customerservice_tags;

    @Value("${faq_customerservicehp}")
    private String faq_customerservicehp;

    @Value("${mfa_close}")
    private String mfa_close;

    @Value("${email_helpandcontact}")
    private String email_helpandcontact;

    @Value("${area_code}")
    private String area_code;

    @Value("${number_promotion}")
    private String number_promotion;

    @Value("${userFirstName_up}")
    private String userFirstName_up;

    @Value("${userLastName_up}")
    private String userLastName_up;

    @Value("${userBirthDay_up}")
    private String userBirthDay_up;

    @Value("${userBirthMonth_up}")
    private String userBirthMonth_up;

    @Value("${userBirthYear_up}")
    private String userBirthYear_up;

    @Value("${userCountry_up}")
    private String userCountry_up;

    @Value("${userSelectCountry_up}")
    private String userSelectCountry_up;

    @Value("${userAddress_up}")
    private String userAddress_up;

    @Value("${userZip_up}")
    private String userZip_up;

    @Value("${userCity_up}")
    private String userCity_up;

    @Value("${userCountryCode_up}")
    private String userCountryCode_up;

    @Value("${userPhoneNumber_up}")
    private String userPhoneNumber_up;
    @Value("${confirm_and_connect}")
    private String confirm_and_connect;

    @Value("${Mam_profile_account_summary_mfa_status}")
    private String Mam_profile_account_summary_mfa_status;

    @Value("${Mam_mfa_trigger}")
    private String Mam_mfa_trigger;

    @Value("${profile_mfa_register}")
    private String profile_mfa_register;

    @Value("${mfa_successmsg}")
    private String mfa_successmsg;

    @Value("${nav_logout}")
    private String nav_logout;

    @Value("${Profile_areacode}")
    private String Profile_areacode;

    @Value("${profile_areaCode_xpath}")
    private String profile_areaCode_xpath;

    @Value("${updated_mobileNo}")
    private String updated_mobileNo;

    @Value("${MFA_activate}")
    private String MFA_activate;

    @Value("${profile_additionalAddress}")
    private String profile_additionalAddress;

    @Value("${Glossary_heading}")
    private String Glossary_heading;


    @Value("${Glossary_firstavailable}")
    private String Glossary_firstavailable;

    @Value("${e_alphabet}")
    private String e_alphabet;

    @Value("${e_expand}")
    private String e_expand;

    @Value("${e_description}")
    private String e_description;

    @Value("${e_link}")
    private String e_link;

    @Value("${t_alphabet}")
    private String t_alphabet;

    @Value("${programhub_container_widget}")
    private String programhub_container_widget;

    @Value("${alertbar_container}")
    private String alertbar_container;

    @Value("${alertbar_text}")
    private String alertbar_text;

    @Value("${nolongerask_mfapage}")
    private String nolongerask_mfapage;

    @Value("${securitywidget_pencilicon}")
    private String securitywidget_pencilicon;

    @Value("${mfa_securitywidget}")
    private String mfa_securitywidget;

    @Value("${mfa_activationstatus}")
    private String mfa_activationstatus;

    @Value("${mfa_trusteddevice}")
    private String mfa_trusteddevice;

    @Value("${mfa_no_of_trusteddevice}")
    private String mfa_no_of_trusteddevice;

    @Value("${app_qrcode}")
    private String app_qrcode;

    @Value("${download_on_appstore}")
    private String download_on_appstore;

    @Value("${getit_on_googleplay}")
    private String getit_on_googleplay;

    @Value("${alertbar_close}")
    private String alertbar_close;

    @Value("${backtoprofile_afterCP}")
    private String backtoprofile_afterCP;

    @Value("${a_alphabet}")
    private String a_alphabet;

    @Value("${a_content}")
    private String a_content;

    @Value("${a_expand}")
    private String a_expand;

    @Value("${a_description}")
    private String a_description;

    @Value("${flight_awardlink}")
    private String flight_awardlink;


    @Value("${number_alphabet}")
    private String number_alphabet;


    @Value("${Profile_emailsave}")
    private String Profile_emailsave;

    @Value("${Profile_additionaladdresssave}")
    private String Profile_additionaladdresssave;



    @Value("${profile_birthDay}")
    private String profile_birthDay;

    @Value("${profile_birthMonth}")
    private String profile_birthMonth;

    @Value("${profile_birthYear}")
    private String profile_birthYear;

    @Value("${localNo_xpath}")
    private String localNo_xpath;

    @Value("${offerhub_heading}")
    private String offerhub_heading;

    @Value("${offerhubreference_backgroundimg}")
    private String offerhubreference_backgroundimg;

    @Value("${offerhubreference_carousel}")
    private String offerhubreference_carousel;

    @Value("${hubcarousel_scrollingindicator}")
    private String hubcarousel_scrollingindicator;

    @Value("${offerhubreference_navigationalarrow}")
    private String offerhubreference_navigationalarrow;

    @Value("${offerbackgroundimg}")
    private String offerbackgroundimg;

    @Value("${offercarousel}")
    private String offercarousel;

    @Value("${offer_navigationalarrow}")
    private String offer_navigationalarrow;

    @Value("${offer_scrollingindicator}")
    private String offer_scrollingindicator;


    @Value("${offerhubreference_heading}")
    private String offerhubreference_heading;

    @Value("${revolving_component}")
    private String revolving_component;

    @Value("${revolving_navigationalarrow}")
    private String revolving_navigationalarrow;

    @Value("${revoving_scrollingindicator}")
    private String revoving_scrollingindicator;


    @Value("${forgetpassword_usernamelogin}")
    private String forgetpassword_usernamelogin;

    @Value("${forgetpassword_scnlogin}")
    private String forgetpassword_scnlogin;

    @Value("${forgetpassword_email}")
    private String forgetpassword_email;


    @Value("${resetlink_name}")
    private String resetlink_name;

    @Value("${backgroundmusic_Muted}")
    private String backgroundmusic_Muted;

    @Value("${backgroundmusic_unmuted}")
    private String backgroundmusic_unmuted;

    @Value("${intromodule_saluation}")
    private String intromodule_saluation;

    @Value("${intromodule_header}")
    private String intromodule_header;

    @Value("${intromodule_firsttext}")
    private String intromodule_firsttext;


    @Value("${intromodule_anniversarytext}")
    private String intromodule_anniversarytext;

    @Value("${intro_click}")
    private String intro_click;

    @Value("${pointmodule_click}")
    private String pointmodule_click;

    @Value("${pointsmodule_topline}")
    private String pointsmodule_topline;

    @Value("${pointsmodule_headline}")
    private String pointsmodule_headline;

    @Value("${pointsmodule_QP}")
    private String pointsmodule_QP;

    @Value("${pointsmodule_HCP}")
    private String pointsmodule_HCP;

    @Value("${statusmodule_click}")
    private String statusmodule_click;

    @Value("${statuslabel1}")
    private String statuslabel1;

    @Value("${statuslabel2}")
    private String statuslabel2;

    @Value("${statuslabel3}")
    private String statuslabel3;

    @Value("${statustext}")
    private String statustext;

    @Value("${buttonlabel_status}")
    private String buttonlabel_status;

    @Value("${milesmodule_click}")
    private String milesmodule_click;

    @Value("${awardmiles_earned}")
    private String awardmiles_earned;

    @Value("${miles_redeemed}")
    private String miles_redeemed;

    @Value("${current_mileage}")
    private String current_mileage;

    @Value("${awardmiles_number}")
    private String awardmiles_number;

    @Value("${milesredeem_number}")
    private String milesredeem_number;

    @Value("${currentmileage_number}")
    private String currentmileage_number;

    @Value("${flightmodule_click}")
    private String flightmodule_click;

    @Value("${flight_topline}")
    private String flight_topline;

    @Value("${flight_subline}")
    private String flight_subline;

    @Value("${flightmodule_label}")
    private String flightmodule_label;
    @Value("${annual_review_button}")
    private String annual_review_button;

    @Value("${raffle_module}")
    private String raffle_module;

    @Value("${raffle_module_text1}")
    private String raffle_module_text1;

    @Value("${raffle_module_text2}")
    private String raffle_module_text2;

    @Value("${raffle_module_joinnow}")
    private String raffle_module_joinnow;

    @Value("${raffle_joinnow_close}")
    private String raffle_joinnow_close;

    @Value("${raffle_joinnow_heading}")
    private String raffle_joinnow_heading;

    @Value("${raffle_joinnow_description}")
    private String raffle_joinnow_description;

    @Value("${raffle_joinnow_accordion_heading}")
    private String raffle_joinnow_accordion_heading;

    @Value("${raffle_joinnow_accordion_content}")
    private String raffle_joinnow_accordion_content;

    @Value("${raffle_joinnow_accordion_participate}")
    private String raffle_joinnow_accordion_participate;

    @Value("${login_after_cp}")
    private String login_after_cp;

    @Value("${reset_email_password_hide_button}")
    private String reset_email_password_hide_button;
}
