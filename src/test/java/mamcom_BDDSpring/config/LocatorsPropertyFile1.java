package mamcom_BDDSpring.config;


import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PageObjects
@PropertySource("classpath:locators.properties")
public class LocatorsPropertyFile1 {

    @Value("${mam_profile_account_email_detail}")
    private String mam_profile_account_email_detail;

    @Value("${mam_profile_account_scn_detail}")
    private String mam_profile_account_scn_detail;

    @Value("${mam_profile_account_userId_detail}")
    private String mam_profile_account_userId_detail;

    @Value("${mam_profile_account_email_changePwd}")
    private String mam_profile_account_email_changePwd;

    @Value("${mam_profile_account_scn_changePin}")
    private String mam_profile_account_scn_changePin;

    @Value("${mam_profile_account_userId_changePin}")
    private String mam_profile_account_userId_changePin;

    @Value("${mam_profile_account_requestPIN}")
    private String mam_profile_account_requestPIN;

    @Value("${mam_profile_address}")
    private String mam_profile_address;

    @Value("${mam_profile_email_address}")
    private String mam_profile_email_address;

    @Value("${mam_profile_preffer}")
    private String mam_profile_preffer;

    @Value("${mam_profile_userName}")
    private String mam_profile_userName;

    @Value("${mam_profile_DOB}")
    private String mam_profile_DOB;

    @Value("${mam_profile_emailaddress}")
    private String mam_profile_emailaddress;

    @Value("${mam_profile_telephone_no}")
    private String mam_profile_telephone_no;

    @Value("${mam_profile_prefer_lanuage}")
    private String mam_profile_prefer_lanuage;

    @Value("${mam_profile_2fa_trigger}")
    private String mam_profile_2fa_trigger;

    @Value("${mam_profile_form_uname}")
    private String mam_profile_form_uname;

    @Value("${mam_profile_form_2fa_trigger}")
    private String mam_profile_form_2fa_trigger;


    @Value("${lhCardSelection}")
    private String lhCardSelection;

    @Value("${osCardSelection}")
    private String osCardSelection;

    @Value("${lxCardSelection}")
    private String lxCardSelection;

    @Value("${snCardSelection}")
    private String snCardSelection;

    @Value("${ewCardSelection}")
    private String ewCardSelection;

    @Value("${emailSentConfirmation}")
    private String emailSentConfirmation;

    @Value("${airline_email_forgot_pwd_link}")
    private String airline_email_forgot_pwd_link;

    @Value("${airline_email_forgot_input}")
    private String airline_email_forgot_input;

    @Value("${airline_email_pwd_request_link}")
    private String airline_email_pwd_request_link;

    @Value("${airline_uname_forgot_pwd_link}")
    private String airline_uname_forgot_pwd_link;

    @Value("${airline_uname_forgot_input}")
    private String airline_uname_forgot_input;

    @Value("${airline_uname_pwd_request_link}")
    private String airline_uname_pwd_request_link;

    @Value("${airline_scn_forgot_pwd_link}")
    private String airline_scn_forgot_pwd_link;

    @Value("${airline_scn_forgot_input}")
    private String airline_scn_forgot_input;

    @Value("${airline_scn_pwd_request_link}")
    private String airline_scn_pwd_request_link;

    @Value("${airline_request_link_success_msg}")
    private String airline_request_link_success_msg;

    @Value("${airline_sn_forgot_pwd_link}")
    private String airline_sn_forgot_pwd_link;

    @Value("${partner_email_forgot_pwd_link}")
    private String partner_email_forgot_pwd_link;

    @Value("${partner_uname_scn_forgot_pwd_link}")
    private String partner_uname_scn_forgot_pwd_link;

    @Value("${partner_uname_scn_email_input}")
    private String partner_uname_scn_email_input;

    @Value("${partner_uname_scn_email_request_link}")
    private String partner_uname_scn_email_request_link;

    @Value("${airline_scn_pin_request_link}")
    private String airline_scn_pin_request_link;

    @Value("${partner_change_email_pwd_input}")
    private String partner_change_email_pwd_input;

    @Value("${partner_change_scn_pin_input}")
    private String partner_change_scn_pin_input;

    @Value("${partner_change_uname_pwd_input}")
    private String partner_change_uname_pwd_input;

    @Value("${partner_change_email_pwd_page_login}")
    private String partner_change_email_pwd_page_login;

    @Value("${partner_change_uname_pwd_page_login}")
    private String partner_change_uname_pwd_page_login;

    @Value("${partner_change_scn_pin_page_login}")
    private String partner_change_scn_pin_page_login;

    @Value("${clickCookie}")
    private String clickCookie;

    @Value("${yopMailEmail}")
    private String yopMailEmail;

    @Value("${SubmitMail}")
    private String SubmitMail;

    @Value("${FrameMail}")
    private String FrameMail;

    @Value("${MailUrl}")
    private String MailUrl;

    @Value("${prodmailurl}")
    private String prodmailurl;

    @Value("${authorizeButton}")
    private String authorizeButton;

    @Value("${partnerCancelButton}")
    private String partnerCancelButton;

    @Value("${stayloggedin1}")
    private String stayloggedin1;

    @Value("${stayloggedin2}")
    private String stayloggedin2;

    @Value("${backButton}")
    private String backButton;

    @Value("${userClickOnBack_xpath}")
    private String userClickOnBack_xpath;

    @Value("${userClicksBack_button}")
    private String userClicksBack_button;

    @Value("${AllUNameLabel}")
    private String AllUNameLabel;

    @Value("${federalState}")
    private String federalState;

    @Value("${btn_relogin}")
    private String btn_relogin;

    @Value("${oneIDLoginPage}")
    private String oneIDLoginPage;

    @Value("${editPernlzdOferComictns}")
    private String editPernlzdOferComictns;

    @Value("${pduCheckbox}")
    private String pduCheckbox;

    @Value("${pduMarketResearch}")
    private String pduMarketResearch;

    @Value("${pduMAMNL}")
    private String pduMAMNL;

    @Value("${pduMAMPOI}")
    private String pduMAMPOI;

    @Value("${mamSMS}")
    private String mamSMS;

    @Value("${mamEmail}")
    private String mamEmail;

    @Value("${mamPhone}")
    private String mamPhone;

    @Value("${behaviouralPermission}")
    private String behaviouralPermission;

    @Value("${lufthansaGroupMarketResearch}")
    private String lufthansaGroupMarketResearch;

    @Value("${lufthansaGroupSMS}")
    private String lufthansaGroupSMS;

    @Value("${lufthansaGroupEMAIL}")
    private String lufthansaGroupEMAIL;

    @Value("${lufthansaGroupPHONE}")
    private String lufthansaGroupPHONE;

    @Value("${austrianAir}")
    private String austrianAir;

    @Value("${austrianPOI}")
    private String austrianPOI;

    @Value("${austrianSMS}")
    private String austrianSMS;

    @Value("${austrianEMAIL}")
    private String austrianEMAIL;

    @Value("${austrianPHONE}")
    private String austrianPHONE;

    @Value("${austrianNL}")
    private String austrianNL;

    @Value("${brusselsAir}")
    private String brusselsAir;

    @Value("${brusselsPOI}")
    private String brusselsPOI;

    @Value("${brusselsSMS}")
    private String brusselsSMS;

    @Value("${brusselsEMAIL}")
    private String brusselsEMAIL;

    @Value("${brusselsPHONE}")
    private String brusselsPHONE;

    @Value("${brusselsNL}")
    private String brusselsNL;

    @Value("${eurowingsAir}")
    private String eurowingsAir;

    @Value("${eurowingsPOI}")
    private String eurowingsPOI;

    @Value("${eurowingsSMS}")
    private String eurowingsSMS;

    @Value("${eurowingsEMAIL}")
    private String eurowingsEMAIL;

    @Value("${eurowingsPHONE}")
    private String eurowingsPHONE;

    @Value("${eurowingsNL}")
    private String eurowingsNL;

    @Value("${discoverAir}")
    private String discoverAir;

    @Value("${discoverPOI}")
    private String discoverPOI;

    @Value("${discoverSMS}")
    private String discoverSMS;

    @Value("${discoverEMAIL}")
    private String discoverEMAIL;

    @Value("${discoverPHONE}")
    private String discoverPHONE;

    @Value("${discoverNL}")
    private String discoverNL;

    @Value("${lufthansaAir}")
    private String lufthansaAir;

    @Value("${lufthansaPOI}")
    private String lufthansaPOI;

    @Value("${lufthansaSMS}")
    private String lufthansaSMS;

    @Value("${lufthansaEMAIL}")
    private String lufthansaEMAIL;

    @Value("${lufthansaPHONE}")
    private String lufthansaPHONE;

    @Value("${lufthansaNL}")
    private String lufthansaNL;

    @Value("${swissAir}")
    private String swissAir;

    @Value("${swissPOI}")
    private String swissPOI;

    @Value("${swissSMS}")
    private String swissSMS;

    @Value("${swissEMAIL}")
    private String swissEMAIL;

    @Value("${swissPHONE}")
    private String swissPHONE;

    @Value("${swissNL}")
    private String swissNL;

    @Value("${backToProfile}")
    private String backToProfile;

    @Value("${airlineSaveButtonPerm}")
    private String airlineSaveButtonPerm;

    @Value("${pduSaveButton}")
    private String pduSaveButton;

    @Value("${pduMessage}")
    private String pduMessage;

    @Value("${pduTelephone}")
    private String pduTelephone;

    @Value("${mamMarketResearch}")
    private String mamMarketResearch;

    @Value("${profileCompletionPercentage}")
    private String profileCompletionPercentage;

    @Value("${pdu}")
    private String pdu;

    @Value("${bp}")
    private String bp;

    @Value("${accountSummary}")
    private String accountSummary;

    @Value("${enrolmentClickOnCountinue}")
    private String enrolmentClickOnCountinue;

    @Value("${enrolment_emailError}")
    private String enrolment_emailError;

    @Value("${enrolment_pwdError}")
    private String enrolment_pwdError;

    @Value("${enrolment_error_link1}")
    private String enrolment_error_link1;

    @Value("${enrolment_error_link2}")
    private String enrolment_error_link2;

    @Value("${btn_MAM_2FA_Activate}")
    private String btn_MAM_2FA_Activate;

    @Value("${airline_tenant_oneId_login}")
    private String airline_tenant_oneId_login;

    @Value("${enrolment_Activate_Miles_and_More_button}")
    private String enrolment_Activate_Miles_and_More_button;

    @Value("${errorHeading}")
    private String errorHeading;

    @Value("${flyout_validation_displayed}")
    private String flyout_validation_displayed;

    @Value("${personal_details_error_link}")
    private String personal_details_error_link;

    @Value("${personal_details_error_link1}")
    private String personal_details_error_link1;

    @Value("${personal_details_error_link2}")
    private String personal_details_error_link2;

    @Value("${personal_details_error_link3}")
    private String personal_details_error_link3;

    @Value("${personal_details_error_link4}")
    private String personal_details_error_link4;

    @Value("${personal_details_error_link5}")
    private String personal_details_error_link5;

    @Value("${personal_details_error_link6}")
    private String personal_details_error_link6;

    @Value("${personal_details_error_link7}")
    private String personal_details_error_link7;

    @Value("${personal_details_error_link8}")
    private String personal_details_error_link8;

    @Value("${personal_details_error_link9}")
    private String personal_details_error_link9;

    @Value("${back_btn_click}")
    private String back_btn_click;

    @Value("${back_btn_click_bottom}")
    private String back_btn_click_bottom;

    @Value("${email15b}")
    private String email15b;

    @Value("${pwd15b}")
    private String pwd15b;

    @Value("${signInBtn15b}")
    private String signInBtn15b;

    @Value("${lxUat}")
    private String lxUat;

    @Value("${lxTst}")
    private String lxTst;

    @Value("${transactionalHistory15b}")
    private String transactionalHistory15b;

    @Value("${search15b}")
    private String search15b;

    @Value("${searchBtn15b}")
    private String searchBtn15b;

    @Value("${detailsBtn15b}")
    private String detailsBtn15b;

    @Value("${viewContentBtn15b}")
    private String viewContentBtn15b;

    @Value("${doNotAgree}")
    private String doNotAgree;

    @Value("${migrationButton}")
    private String migrationButton;

    @Value("${save_pin_button_label}")
    private String save_pin_button_label;

    @Value("${connectUnameSCN}")
    private String connectUnameSCN;

    @Value("${connectPinPassword}")
    private String connectPinPassword;

    @Value("${findAccountContinue}")
    private String findAccountContinue;

    @Value("${confirmAccount}")
    private String confirmAccount;

    @Value("${messageTitle}")
    private String messageTitle;

    @Value("${reviewYourTravelID}")
    private String reviewYourTravelID;

    @Value("${logInNow}")
    private String logInNow;

    @Value("${migrationPassword}")
    private String migrationPassword;

    @Value("${migrationEmail}")
    private String migrationEmail;

    @Value("${migrationContinue}")
    private String migrationContinue;

    @Value("${migrationPersonalInformationContinue}")
    private String migrationPersonalInformationContinue;

    @Value("${communicationsNextButton}")
    private String communicationsNextButton;

    @Value("${migrationHeading}")
    private String migrationHeading;

    @Value("${migrationLogin}")
    private String migrationLogin;


    @Value("${notRightNow}")
    private String notRightNow;

    @Value("${listIcon}")
    private String listIcon;


    @Value("${myAccount}")
    private String myAccount;

    @Value("${loginTriggerButton}")
    private String loginTriggerButton;


    @Value("${loginBackLink}")
    private String loginBackLink;

    @Value("${enrolmentLinkClick}")
    private String enrolmentLinkClick;

    @Value("${activatedMessage}")
    private String activatedMessage;

    @Value("${enrolmentLogin}")
    private String enrolmentLogin;


    @Value("${activatedEnrolmentLogin}")
    private String activatedEnrolmentLogin;

    @Value("${migrationEmailErrorText}")
    private String migrationEmailErrorText;

    @Value("${contactServiceLink}")
    private String contactServiceLink;

    @Value("${serviceCentrePopUp}")
    private String serviceCentrePopUp;

    @Value("${btn_login1}")
    private String btn_login1;

    @Value("${cancelButtonUpgrade}")
    private String cancelButtonUpgrade;

    @Value("${startButtonUpgrade}")
    private String startButtonUpgrade;

    @Value("${continueButtonUpgrade}")
    private String continueButtonUpgrade;

    @Value("${confirmAndActiveButton}")
    private String confirmAndActiveButton;

    @Value("${activatedUpgradeMessage}")
    private String activatedUpgradeMessage;

    @Value("${profileButtonUpgrade}")
    private String profileButtonUpgrade;

    @Value("${exploreMilesAndMoreButton}")
    private String exploreMilesAndMoreButton;

    @Value("${optionalLoginButton}")
    private String optionalLoginButton;

    @Value("${upgradeHeading}")
    private String upgradeHeading;

    @Value("${upgradeHeadingDescription}")
    private String upgradeHeadingDescription;

    @Value("${migrationHeadingLogin}")
    private String migrationHeadingLogin;

    @Value("${migrationHeadingDescription}")
    private String migrationHeadingDescription;

    @Value("${connectHeading}")
    private String connectHeading;

    @Value("${connectHeadingDescription}")
    private String connectHeadingDescription;

    @Value("${mamMigrationDescription1}")
    private String mamMigrationDescription1;

    @Value("${mamMigrationEmailDescription}")
    private String mamMigrationEmailDescription;

    @Value("${mamMigrationUsernameDescription}")
    private String mamMigrationUsernameDescription;

    @Value("${mamMigrationSCNDescription}")
    private String mamMigrationSCNDescription;

    @Value("${back_btn_click_scn_Uname}")
    private String back_btn_click_scn_Uname;

    @Value("${migrationWelcomeHeading}")
    private String migrationWelcomeHeading;

    @Value("${migrationBack}")
    private String migrationBack;

    @Value("${mam_2fa_request_code}")
    private String mam_2fa_request_code;

    @Value("${mam_2fa_submit}")
    private String mam_2fa_submit;

    @Value("${backToProfileUpgrade}")
    private String backToProfileUpgrade;


    @Value("${upgradeLoginHeading}")
    private String upgradeLoginHeading;

    @Value("${upgradeLoginDescription}")
    private String upgradeLoginDescription;

    @Value("${forgetPasswordLogin}")
    private String forgetPasswordLogin;

    @Value("${upgradeCancel}")
    private String upgradeCancel;

    @Value("${Reset_completion_login_button_scn}")
    private String Reset_completion_login_button_scn;

    @Value("${connectErrorMsg}")
    private String connectErrorMsg;

    @Value("${connectServiceCenter}")
    private String connectServiceCenter;

    @Value("${serviceCenterBackbutton}")
    private String serviceCenterBackbutton;

    @Value("${profileMigrationErrorMsg}")
    private String profileMigrationErrorMsg;

    @Value("${goToProfileLink}")
    private String goToProfileLink;

    @Value("${dobSaveChanges}")
    private String dobSaveChanges;

    @Value("${savedDobValue}")
    private String savedDobValue;

    @Value("${closeButtonClick}")
    private String closeButtonClick;

    @Value("${addressUpdate}")
    private String addressUpdate;

    @Value("${addressSavebutton}")
    private String addressSavebutton;

    @Value("${twoFAcountryCode}")
    private String twoFAcountryCode;

    @Value("${twoFAAreaCode}")
    private String twoFAAreaCode;

    @Value("${twoFALocalNumber}")
    private String twoFALocalNumber;

    @Value("${next_2fa_button}")
    private String next_2fa_button;

    @Value("${confirm_2fa_button}")
    private String confirm_2fa_button;

    @Value("${resetPinConnect}")
    private String resetPinConnect;

    @Value("${resetPasswordConnect}")
    private String resetPasswordConnect;

    @Value("${exchangeNow}")
    private String exchangeNow;

    @Value("${mileageExchangeCheckbox}")
    private String mileageExchangeCheckbox;

    @Value("${popupExchangeNow}")
    private String popupExchangeNow;

    @Value("${loginPageMessage}")
    private String loginPageMessage;

    @Value("${teaserAvailableMiles}")
    private String teaserAvailableMiles;

    @Value("${exchangeNowButton}")
    private String exchangeNowButton;

    @Value("${exchangeConfirmationMsg1}")
    private String exchangeConfirmationMsg1;

    @Value("${exchangeConfirmationMsg2}")
    private String exchangeConfirmationMsg2;

    @Value("${partner_scn_forgot_pwd_link}")
    private String partner_scn_forgot_pwd_link;

    @Value("${hc_footer_helpcontact_logged}")
    private String hc_footer_helpcontact_logged;

    @Value("${hc_Technicalerror}")
    private String hc_Technicalerror;

    @Value("${hc_website}")
    private String hc_website;

    @Value("${hc_date}")
    private String hc_date;

    @Value("${hc_SelectIcon}")
    private String hc_SelectIcon;

    @Value("${hc_Time}")
    private String hc_Time;

    @Value("${hc_browser}")
    private String hc_browser;

    @Value("${hc_message}")
    private String hc_message;

    @Value("${hc_submit}")
    private String hc_submit;

    @Value("${hc_summaryTitle}")
    private String hc_summaryTitle;

    @Value("${hc_RequestReceived}")
    private String hc_RequestReceived;

    @Value("${languageSwitch}")
    private String languageSwitch;

    @Value("${ls_germany}")
    private String ls_germany;

    @Value("${ls_english}")
    private String ls_english;
    @Value("${ls_saveChanges}")
    private String ls_saveChanges;


    @Value("${spendMiles}")
    private String spendMiles;

    @Value("${fs_Flights}")
    private String fs_Flights;

    @Value("${enrolment_Activated_message}")
    private String enrolment_Activated_message;

    @Value("${enrolment_confirmation_email}")
    private String enrolment_confirmation_email;


    @Value("${enrolment_start_registration_again}")
    private String enrolment_start_registration_again;

    @Value("${enrolment_miles_and_more}")
    private String enrolment_miles_and_more;

    @Value("${enrolment_personal_details}")
    private String enrolment_personal_details;

    @Value("${request_pin}")
    private String request_pin;

    @Value("${hc_app}")
    private String hc_app;

    @Value("${hc_last_name}")
    private String hc_last_name;

    @Value("${hc_customer_number}")
    private String hc_customer_number;

    @Value("${nav_earn_miles}")
    private String nav_earn_miles;

    @Value("${nav_spend_miles}")
    private String nav_spend_miles;

    @Value("${nav_programme}")
    private String nav_programme;

    @Value("${nav_airlines}")
    private String nav_airlines;

    @Value("${nav_airports}")
    private String nav_airports;


    @Value("${nav_hotels}")
    private String nav_hotels;

    @Value("${nav_travels}")
    private String nav_travels;

    @Value("${nav_mobility}")
    private String nav_mobility;

    @Value("${nav_entertainment}")
    private String nav_entertainment;

    @Value("${nav_shopping}")
    private String nav_shopping;

    @Value("${nav_finances}")
    private String nav_finances;

    @Value("${nav_all_offers}")
    private String nav_all_offers;

    @Value("${scrollbar}")
    private String scrollbar;

    @Value("${nav_flights}")
    private String nav_flights;

    @Value("${nav_car_rentals}")
    private String nav_car_rentals;

    @Value("${nav_gift_cards}")
    private String nav_gift_cards;

    @Value("${nav_worldshop}")
    private String nav_worldshop;

    @Value("${nav_others_awards}")
    private String nav_others_awards;

    @Value("${nav_donate_miles}")
    private String nav_donate_miles;

    @Value("${nav_all_awards}")
    private String nav_all_awards;

    @Value("${nav_flight_benefits}")
    private String nav_flight_benefits;

    @Value("${nav_status_benefits}")
    private String nav_status_benefits;

    @Value("${nav_daily_benefits}")
    private String nav_daily_benefits;

    @Value("${nav_partners}")
    private String nav_partners;

    @Value("${nav_credit_cards}")
    private String nav_credit_cards;

    @Value("${nav_my_account}")
    private String nav_my_account;

    @Value("${nav_status_management}")
    private String nav_status_management;

    @Value("${nav_mileage_account}")
    private String nav_mileage_account;

    @Value("${nav_my_booking_summary}")
    private String nav_my_booking_summary;

    @Value("${nav_inbox}")
    private String nav_inbox;

    @Value("${nav_mileage_pooling}")
    private String nav_mileage_pooling;

    @Value("${nav_logout}")
    private String nav_logout;

    @Value("${button_invitemember_xpath}")
    private String invite_member;

    @Value("${text_scn_xpath}")
    private String text_scn_xpath;

    @Value("${button_invite_xpath}")
    private String invite_click;

    @Value("${button_mileagepooling_next}")
    private  String mileagepooling_next;

    @Value("${checkbox_mileagepooling_invite}")
    private String checkbox_invite;

    @Value("${button_sendinvitation_xpath}")
    private String button_sendinvitation;

    @Value("${text_abletostart}")
    private String text_abletostart;

    @Value("${button_understood_xpath}")
    private String button_understood_xpath;

    @Value("${myaccount_dropdown}")
    private String myaccount_dropdown;

    @Value("${button_logout}")
    private String button_logout;

    @Value("${button_scroller}")
    private String button_scroller;

    @Value("${button_accept_invitation}")
    private  String button_accept_invitation;

    @Value("${checkbox_accept_invitation}")
    private String checkbox_accept_invitation;

    @Value("${button_accept_invitation2}")
    private String button_accept_invitation2;

    @Value("${button_final_OK}")
    private String button_final_OK;

    @Value("${closebutton}")
    private String closebutton;

    @Value("${enrolment_register_travelID}")
    private String enrolment_register_travelID;

    @Value("${personal_info_edit_save}")
    private String personal_info_edit_save;

    @Value("${2fa_request_code_xpath}")
    private String fa_request_code_xpath;

    @Value("${promotions_button_xpath}")
    private String promotions_button_xpath;

    @Value("${postal_code_xpath}")
    private String postal_code_xpath;

    @Value("${city_xpath}")
    private String city_xpath;

    @Value("${emailaddress_xpath}")
    private String emailaddress_xpath;

    @Value("${usagetime_dropdown_xpath}")
    private String usagetime_dropdown_xpath;

    @Value("${booking_number_xpath}")
    private String booking_number_xpath;

    @Value("${usagetime_click_xpath}")
    private String usagetime_click_xpath;

    @Value("${button_start_mileagepooling}")
    private String button_start_mileagepooling;

    @Value("${upload_image_xpath}")
    private String upload_image_xpath;

    @Value("${usagetime_1studen_xpath}")
    private String usagetime_1studen_xpath;

    @Value("${submitnow_promotion_xpath}")
    private String submitnow_promotion_xpath;

    @Value("${helpandcontact}")
    private String helpandcontact;

    @Value("${pinpassword_help}")
    private String pinpassword_help;

    @Value("${loginnotpossible}")
    private String loginnotpossible;

    @Value("${message_help}")
    private String message_help;

    @Value("${send_help}")
    private String send_help;

    @Value("${helpandcontact_link}")
    private String helpandcontact_link;

    @Value("${thanksforenquiry}")
    private String thanksforenquiry;

    @Value("${spendmiles_xpath}")
    private String spendmiles_xpath;

    @Value("${hotels_destination}")
    private String hotels_destination;

    @Value("${frankfurt_hotels}")
    private String frankfurt_hotels;

    @Value("${hotel_adult_add}")
    private String hotel_adult_add;

    @Value("${searchforhotel_xpath}")
    private String searchforhotel_xpath;

    @Value("${pickupstation_carrental}")
    private String pickupstation_carrental;

    @Value("${frankfurt_pickup}")
    private String frankfurt_pickup;

    @Value("${dropoff_carrental}")
    private String dropoff_carrental;

    @Value("${munich_dropoff}")
    private String munich_dropoff;

    @Value("${rentalstart_date}")
    private String rentalstart_date;

    @Value("${rentalend_date}")
    private String rentalend_date;

    @Value("${rentalstart_time}")
    private String rentalstart_time;

    @Value("${rentalend_time}")
    private String rentalend_time;

    @Value("${search_rentalcars}")
    private String search_rentalcars;

    @Value("${servicecard_textbox}")
    private String servicecard_textbox;

    @Value("${login_nextButton}")
    private String login_nextButton;

    @Value("${login_pin}")
    private String login_pin;

    @Value("${loginButton_scn}")
    private String loginButton_scn;

    @Value("${passwordforUser}")
    private String passwordforUser;

    @Value("${mnm_header_logo}")
    private String mnm_header_logo;

    @Value("${header_logos}")
    private String header_logos;


    @Value("${footer_information}")
    private String footer_information;

    @Value("${footer_service}")
    private String footer_service;

    @Value("${footer_more}")
    private String footer_more;

    @Value("${footer_extras}")
    private String footer_extras;

    @Value("${mnm_app_footer}")
    private String mnm_app_footer;

    @Value("${submityopmail}")
    private String submityopmail;

    @Value("${loginafterenroll}")
    private String loginafterenroll;

    @Value("${myprofile}")
    private String myprofile;

    @Value("${flight_depature}")
    private String flight_depature;

    @Value("${flight_arrival}")
    private String flight_arrival;

    @Value("${oneway_checkbox}")
    private String oneway_checkbox;

    @Value("${search_flights}")
    private String search_flights;

    @Value("${frankfurt_depature}")
    private String frankfurt_depature;

    @Value("${munich_arrival}")
    private String munich_arrival;

    @Value("${driver_age}")
    private String driver_age;

    @Value("{lufthansa_login}")
    private String lufthansa_login;

    @Value("{tenant_logout}")
    private String tenant_logout;

    @Value("{SCN_tenant_forgot_PIN}")
    private String SCN_tenant_forgot_PIN;

    //country language switch

    @Value("${country_language_switch_link}")
    private String country_language_switch_link;

    @Value("${save_country_as_germany}")
    private String save_country_as_germany;

    @Value("${save_country_as_india}")
    private String save_country_as_india;

    @Value("${save_country_as_poland}")
    private String save_country_as_poland;

    @Value("${save_language_as_german}")
    private String save_language_as_german;

    @Value("${save_language_as_english}")
    private String save_language_as_english;

    @Value("${save_language_as_polish}")
    private String save_language_as_polish;

    @Value("${save_changed_country}")
    private String save_changed_country;

    @Value("${save_changed_country_as_india}")
    private String save_changed_country_as_india;

    @Value("${save_changed_language}")
    private String save_changed_language;

    @Value("${secret_id}")
    private String secret_id;

    @Value("${language_saveChanges}")
    private String language_saveChanges;

    @Value("${neccessary_cookie_selectAll}")
    private String neccessary_cookie_selectAll;

    @Value("${cancel_2fa}")
    private String cancel_2fa;

    @Value("${keep_pref_country}")
    private String keep_pref_country;

//logged in user

    @Value("${ffb_login_xpath}")
    private String ffb_login_xpath;

    @Value("${login_with_email_address}")
    private String login_with_email_address;

    @Value("${enter_email_address}")
    private String enter_email_address;

    @Value("${email_address_next}")
    private String email_address_next;

    @Value("${enter_password}")
    private String enter_password;

    @Value("${login_button}")
    private String login_button;

    @Value("${enter_scn}")
    private String enter_scn;

    @Value("${scn_next}")
    private String scn_next;

    @Value("${enter_pin}")
    private String enter_pin;

    @Value("${scn_login_button}")
    private String scn_login_button;

    @Value("${close_twofa}")
    private String close_twofa;

    @Value("${my_account_click}")
    private String my_account_click;

    @Value("${my_profile_link}")
    private String my_profile_link;

    @Value("${personal_information_edit}")
    private String personal_information_edit;

    @Value("${personal_details_street}")
    private String personal_details_street;

    @Value("${personal_details_save}")
    private String personal_details_save;

    @Value("${personal_details_twofa}")
    private String personal_details_twofa;

    @Value("${travel_pref_edit}")
    private String travel_pref_edit;

    @Value("${travel_pref_location}")
    private String travel_pref_location;

    @Value("${travel_pref_location_select}")
    private String travel_pref_location_select;

    @Value("${travel_pref_autocheckin}")
    private String travel_pref_autocheckin;

    @Value("${travel_pref_save_changes}")
    private String travel_pref_save_changes;

    @Value("${comm_edit}")
    private String comm_edit;

    @Value("${comm_checkbox}")
    private String comm_checkbox;

    @Value("${comm_save_changes}")
    private String comm_save_changes;

    @Value("${log_login}")
    private String log_login;

    @Value("${personal_details_postalcode}")
    private String personal_details_postalcode;

    @Value("${personal_details_city}")
    private String personal_details_city;

    @Value("${travel_pref_location_text}")
    private String travel_pref_location_text;

    @Value("${travel_pref_autocheckin_notselect}")
    private String travel_pref_autocheckin_notselect;

    @Value("${comm_validation}")
    private String comm_validation;

    @Value("{submit_twofa}")
    private String submit_twofa;

    @Value("${offer_carousle_label}")
    private String offer_carousle_label;

    @Value("${offer_carousle_click}")
    private String offer_carousle_click;

    @Value("${retro_page_click}")
    private String retro_page_click;

    @Value("${retro_miles_and_more_label}")
    private String retro_miles_and_more_label;

    @Value("${retro_miles_and_more_partner}")
    private String retro_miles_and_more_partner;

    @Value("${retro_apply_mileage_credit1}")
    private String retro_apply_mileage_credit1;

    @Value("${retro_apply_mileage_credit2}")
    private String retro_apply_mileage_credit2;

    @Value("${retro_apply_mileage_credit3}")
    private String retro_apply_mileage_credit3;

    @Value("${retro_user_name_label}")
    private String retro_user_name_label;

    @Value("${retro_back_anchor}")
    private String retro_back_anchor;

    @Value("${retro_flight_number_code}")
    private String retro_flight_number_code;

    @Value("${retro_flight_number_tooltip}")
    private String retro_flight_number_tooltip;


    @Value("${retro_flight_date_tooltip}")
    private String retro_flight_date_tooltip;

    @Value("${retro_depature_airport_tooltip}")
    private String retro_depature_airport_tooltip;

    @Value("${retro_arrival_airport_tooltip}")
    private String retro_arrival_airport_tooltip;

    @Value("${retro_travel_class_tooltip}")
    private String retro_travel_class_tooltip;

    @Value("${retro_ticket_number_tooltip}")
    private String retro_ticket_number_tooltip;


    @Value("${retro_flight_date}")
    private String retro_flight_date;

    @Value("${retro_depature_airport}")
    private String retro_depature_airport;


    @Value("${retro_arrival_airport}")
    private String retro_arrival_airport;

    @Value("${retro_travel_class_economy}")
    private String retro_travel_class_economy;

    @Value("${retro_travel_class_business}")
    private String retro_travel_class_business;

    @Value("${retro_travel_class_first}")
    private String retro_travel_class_first;

    @Value("${retro_ticket_number}")
    private String retro_ticket_number;

    @Value("${retro_flight_number}")
    private String retro_flight_number;

    @Value("${retro_depature_dropdown_list}")
    private String retro_depature_dropdown_list;

    @Value("${retro_success_message}")
    private String retro_success_message;

    @Value("${retro_to_mileage_account}")
    private String retro_to_mileage_account;

    @Value("${retro_current_date}")
    private String retro_current_date;

    @Value("${retro_reject_message}")
    private String retro_reject_message;

    @Value("${retro_to_mileage_account_rejected}")
    private String retro_to_mileage_account_rejected;

    @Value("${retro_miles_and_more_partner_label}")
    private String retro_miles_and_more_partner_label;

    @Value("${retro_miles_and_more_non_air}")
    private String retro_miles_and_more_non_air;

    @Value("${retro_hotel_name_tooltip}")
    private String retro_hotel_name_tooltip;

    @Value("${retro_Attachment_tooltip}")
    private String retro_Attachment_tooltip;

    @Value("${retro_hotel_name}")
    private String retro_hotel_name;

    @Value("${retro_arrival_date}")
    private String retro_arrival_date;

    @Value("${retro_depature_date}")
    private String retro_depature_date;

    @Value("${retro_club_number}")
    private String retro_club_number;

    @Value("${retro_booking_number}")
    private String retro_booking_number;

    @Value("${retro_invoice_number}")
    private String retro_invoice_number;

    @Value("${retro_file_upload}")
    private String retro_file_upload;

    @Value("${retro_hotel_success_message}")
    private String retro_hotel_success_message;


    @Value("${retro_to_mileage_account_hotel}")
    private String retro_to_mileage_account_hotel;

    @Value("${retro_car_pickup}")
    private String retro_car_pickup;

    @Value("${retro_car_drop}")
    private String retro_car_drop;

    @Value("${retro_rental_agreement_number}")
    private String retro_rental_agreement_number;

    @Value("${retro_order_date}")
    private String retro_order_date;

    @Value("${retro_order_number}")
    private String retro_order_number;

    @Value("${newsLetter}")
    private String newsLetter;

    @Value("${nl_regsiter_now}")
    private String nl_regsiter_now;

    @Value("${nl_checkbox}")
    private String nl_checkbox;

    @Value("${nl_register_now_second}")
    private String nl_register_now_second;

    @Value("${nl_message}")
    private String nl_message;

    @Value("${migration_heading}")
    private String migration_heading;

    @Value("${migration_description}")
    private String migration_description;

    @Value("${migration_view_profile_button}")
    private String migration_view_profile_button;

    @Value("${migration_email_error}")
    private String migration_email_error;

    @Value("${nl_send}")
    private String nl_send;

    @Value("${upgrade_description}")
    private String upgrade_description;

    @Value("${profile_email_validation}")
    private String profile_email_validation;

    @Value("${promo_offer_click}")
    private String promo_offer_click;

    @Value("${promo_offer_heading}")
    private String promo_offer_heading;

    @Value("${promo_list_item1}")
    private String promo_list_item1;

    @Value("${promo_list_item2}")
    private String promo_list_item2;

    @Value("${promo_list_item3}")
    private String promo_list_item3;

    @Value("${promo_heading_text}")
    private String promo_heading_text;

    @Value("${promo_table_heading}")
    private String promo_table_heading;

    @Value("${promo_iframe_heading}")
    private String promo_iframe_heading;

    @Value("${promo_app_store_teaser}")
    private String promo_app_store_teaser;

    @Value("${promo_app_store_description}")
    private String promo_app_store_description;

    @Value("${promo_tool_teaser_heading}")
    private String promo_tool_teaser_heading;

    @Value("${promo_tool_teaser_ist}")
    private String promo_tool_teaser_ist;

    @Value("${promo_form_list}")
    private String promo_form_list;

    @Value("${promo_value_comparison}")
    private String promo_value_comparison;

    @Value("${promo_value_comparison2}")
    private String promo_value_comparison2;

    @Value("${promo_cross_link_teaser}")
    private String promo_cross_link_teaser;

    @Value("${promo_book_button}")
    private String promo_book_button;


    @Value("${yopmail_accept_cookies}")
    private String yopmail_accept_cookies;

    @Value("${driverage_message}")
    private String driverage_message;

    @Value("${loginnotpossible_uat3}")
    private String loginnotpossible_uat3;

    @Value("${send_help_uat3}")
    private String send_help_uat3;

    @Value("${account_fromlist}")
    private String account_fromlist;

    @Value("${tenant_homepage_closeIcon}")
    private String tenant_homepage_closeIcon;

    @Value("${profile_date}")
    private String profile_date;

    @Value("${Profile_language}")
    private String Profile_language;

    @Value("${guardian_email_textbox}")
    private String guardian_email_textbox;


    @Value("${reset_unmae_save_password}")
    private String reset_unmae_save_password;


}

