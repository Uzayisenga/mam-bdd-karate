package mamcom_BDDSpring.config;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PageObjects
@PropertySource("classpath:locators.properties")
public class LocatorsPropertyFile {

    @Value("${secret_id}")
    private String secret_id;

    @Value("${submit_css}")
    private String submit_css;

    @Value("${body_tn}")
    private String body_tn;

    @Value("${loginwithsvc_css}")
    private String loginwithsvc_css;

    @Value("${loginuserid_css}")
    private String loginuserid_css;

    @Value("${servicecard_css}")
    private String servicecard_css;

    @Value("${pin_css}")
    private String pin_css;

    @Value("${loginpassword_css}")
    private String loginpassword_css;

    @Value("${loginwithuserid_css}")
    private String loginwithuserid_css;

    @Value("${userClicksBack_button}")
    private String userClicksBack_button;

    @Value("${login_css}")
    private String login_css;

    @Value("${login_xpath}")
    private String login_xpath;

    @Value("${selectcountry_css}")
    private String selectcountry_css;

    @Value("${confirmCookie_css}")
    private String confirmCookie_css;

    @Value("${scn_login_xpath}")
    private String scn_login_xpath;

    @Value("${travelId_permission_edit}")
    private String travelId_permission_edit;

    @Value("${loginHome_css}")
    private String loginHome_css;

    @Value("${closeButton_xpath}")
    private String closeButton_xpath;

    @Value("${tenant_login_trave_id}")
    private String tenant_login_trave_id;

    @Value("${profile_title_info}")
    private String profile_title_info;

    @Value("${tenant_login_page_heading}")
    private String tenant_login_page_heading;

    @Value("${cdn_mam_login_xpath}")
    private String cdn_mam_login_xpath;

    @Value("${scn_resetPin_xpath}")
    private String scn_resetPin_xpath;

    @Value("${loginWithEmmail_ffb_xpath}")
    private String loginWithEmmail_ffb_xpath;

    @Value("${Profile_scn_no_detail}")
    private String Profile_scn_no_detail;

    @Value("${myProfile_dropDown}")
    private String myProfile_dropDown;

    @Value("${tenant_login_page}")
    private String tenant_login_page;

    @Value("${tenant_id_xpath}")
    private String tenant_id_xpath;

    @Value("${ffb_username_xpath}")
    private String ffb_username_xpath;

    @Value("${myProfile_account_setting}")
    private String myProfile_account_setting;

    @Value("${email_sub_heading}")
    private String email_sub_heading;

    @Value("${travelId_email}")
    private String travelId_email;

    @Value("${ffb_login_button_xpath}")
    private String ffb_login_button_xpath;

    @Value("${profile_unameHeader}")
    private String profile_unameHeader;

    @Value("${profile_birthDay}")
    private String profile_birthDay;

    @Value("${profile_birthMonth}")
    private String profile_birthMonth;

    @Value("${profile_bday_saveChanges}")
    private String profile_bday_saveChanges;

    @Value("${profile_birthYear}")
    private String profile_birthYear;

    @Value("${profile_dob_xpath}")
    private String profile_dob_xpath;

    @Value("${email_error_box}")
    private String email_error_box;

    @Value("${scn_error_box}")
    private String scn_error_box;

    @Value("${link_to_be_added_xpath}")
    private String link_to_be_added_xpath;

    @Value("${acadamic_drTitle_radio}")
    private String acadamic_drTitle_radio;

    @Value("${profile_save_changes}")
    private String profile_save_changes;

    @Value("${close_2fa_auth}")
    private String close_2fa_auth;

    @Value("${pre_prod_cookies}")
    private String pre_prod_cookies;

    @Value("${change_pwd_old_pwd_errorMsg}")
    private String change_pwd_old_pwd_errorMsg;

    @Value("${username_change_old_pwd_errorMsg}")
    private String username_change_old_pwd_errorMsg;

    @Value("${personal_info_setting}")
    private String personal_info_setting;

    @Value("${forgot_pin_submit_2fa}")
    private String forgot_pin_submit_2fa;

    @Value("${personal_info_edit}")
    private String personal_info_edit;

    @Value("${acadamic_noTitle_radio}")
    private String acadamic_noTitle_radio;

    @Value("${back_link}")
    private String back_link;

    @Value("${loginErrorMessage_xpath}")
    private String loginErrorMessage_xpath;

    @Value("${step2_pwd_xpath}")
    private String step2_pwd_xpath;

    @Value("${scn_userContinueMM_xpath_text}")
    private String scn_userContinueMM_xpath_text;

    @Value("${preferredLanguage_xpath}")
    private String preferredLanguage_xpath;

    @Value("${earnMiles_css}")
    private String earnMiles_css;

    @Value("${navigationAirline_css}")
    private String navigationAirline_css;

    @Value("${profile_title_value}")
    private String profile_title_value;

    @Value("${profile_title_info_msg}")
    private String profile_title_info_msg;

    @Value("${navigationMileageCalculator_css}")
    private String navigationMileageCalculator_css;

    @Value("${header_MileageCalculator_css}")
    private String header_MileageCalculator_css;

    @Value("${startMileageCalculation_css}")
    private String startMileageCalculation_css;

    @Value("${profile_preffer_language}")
    private String profile_preffer_language;

    @Value("${lhAirline_css}")
    private String lhAirline_css;

    @Value("${anotherAirline_css}")
    private String anotherAirline_css;

    @Value("${continueButton_css}")
    private String continueButton_css;

    @Value("${ticketPrice_css}")
    private String ticketPrice_css;

    @Value("${surcharge_css}")
    private String surcharge_css;

    @Value("${currency_css}")
    private String currency_css;

    @Value("${oneWayTab_id}")
    private String oneWayTab_id;


    @Value("${returnTab_id}")
    private String returnTab_id;

    @Value("${multiCityTab_id}")
    private String multiCityTab_id;

    @Value("${oneWayOrigin_id}")
    private String oneWayOrigin_id;

    @Value("${onWayDestination_id}")
    private String onWayDestination_id;

    @Value("${outboundOrigin_id}")
    private String outboundOrigin_id;

    @Value("${outboundDestination_id}")
    private String outboundDestination_id;

    @Value("${inboundOrigin_id}")
    private String inboundOrigin_id;

    @Value("${inboundDestination_id}")
    private String inboundDestination_id;

    @Value("${route1Origin_id}")
    private String route1Origin_id;

    @Value("${route1Destination_id}")
    private String route1Destination_id;

    @Value("${route2Origin_id}")
    private String route2Origin_id;

    @Value("${route2Destination_id}")
    private String route2Destination_id;

    @Value("${airlineCode_css}")
    private String airlineCode_css;

    @Value("${airlineCode_xpath}")
    private String airlineCode_xpath;

    @Value("${airlineCode4_xpath}")
    private String airlineCode4_xpath;

    @Value("${airlineCode5_xpath}")
    private String airlineCode5_xpath;

    @Value("${airlineCode6_xpath}")
    private String airlineCode6_xpath;

    @Value("${airlineCode8_xpath}")
    private String airlineCode8_xpath;

    @Value("${operatedBy_css}")
    private String operatedBy_css;

    @Value("${inboundOperatedBy_css}")
    private String inboundOperatedBy_css;

    @Value("${route2OperatedBy_css}")
    private String route2OperatedBy_css;

    @Value("${bookingClass_css}")
    private String bookingClass_css;

    @Value("${inboundBookingClass_css}")
    private String inboundBookingClass_css;

    @Value("${route2BookingClass_css}")
    private String route2BookingClass_css;

    @Value("${awardMiles_xpath}")
    private String awardMiles_xpath;

    @Value("${statusMiles_xpath}")
    private String statusMiles_xpath;

    @Value("${navigationMileageCalculatorEasyMode_css}")
    private String navigationMileageCalculatorEasyMode_css;

    @Value("${startMileageCalculationEasyMode_css}")
    private String startMileageCalculationEasyMode_css;

    @Value("${easyModeOrigin_id}")
    private String easyModeOrigin_id;

    @Value("${easyModeDestination_id}")
    private String easyModeDestination_id;

    @Value("${easyModeOperatedBy_css}")
    private String easyModeOperatedBy_css;

    @Value("${easyModeAwardMiles_xpath}")
    private String easyModeAwardMiles_xpath;

    @Value("${easyModeStatusMiles_xpath}")
    private String easyModeStatusMiles_xpath;

    @Value("${invalidRoutePopUp_xpath}")
    private String invalidRoutePopUp_xpath;

    @Value("${invalidRoutePopUpCancel_css}")
    private String invalidRoutePopUpCancel_css;

    @Value("${invalidRouteMsg_css}")
    private String invalidRouteMsg_css;

    @Value("${invalidDeparture_xpath}")
    private String invalidDeparture_xpath;

    @Value("${invalidArrival_xpath}")
    private String invalidArrival_xpath;

    @Value("${invalidCompartmentMsg_css}")
    private String invalidCompartmentMsg_css;

    @Value("${invalidOperatedByMsg_xpath}")
    private String invalidOperatedByMsg_xpath;

    @Value("${invalidOperatedBy_xpath}")
    private String invalidOperatedBy_xpath;

    @Value("${validDeparture_xpath}")
    private String validDeparture_xpath;

    @Value("${validArrival_xpath}")
    private String validArrival_xpath;

    @Value("${validOperatedBy_xpath}")
    private String validOperatedBy_xpath;

    @Value("${validTicketPrice_xpath}")
    private String validTicketPrice_xpath;

    @Value("${validCurrency_xpath}")
    private String validCurrency_xpath;

    @Value("${myAccount_css}")
    private String myAccount_css;

    @Value("${myProfileButton_css}")
    private String myProfileButton_css;

    @Value("${editProfileSetting_css}")
    private String editProfileSetting_css;

    @Value("${changePasswordLink_css}")
    private String changePasswordLink_css;

    @Value("${currentPasswordTextField_id}")
    private String currentPasswordTextField_id;

    @Value("${newPasswordTextField_id}")
    private String newPasswordTextField_id;

    @Value("${confirmPasswordTextField_id}")
    private String confirmPasswordTextField_id;

    @Value("${changePasswordButton_css}")
    private String changePasswordButton_css;

    @Value("${technicalErrorHeader_xpath}")
    private String technicalErrorHeader_xpath;

    @Value("${technicalErrorClose_xpath}")
    private String technicalErrorClose_xpath;

    @Value("${registerMember_xpath}")
    private String registerMember_xpath;

    @Value("${userTitleMr_css}")
    private String userTitleMr_css;

    @Value("${userTitleMs_css}")
    private String userTitleMs_css;

    @Value("${userFirstName_css}")
    private String userFirstName_css;

    @Value("${userLastName_css}")
    private String userLastName_css;

    @Value("${userBirthDay_css}")
    private String userBirthDay_css;

    @Value("${userBirthMonth_css}")
    private String userBirthMonth_css;

    @Value("${userBirthYear_css}")
    private String userBirthYear_css;

    @Value("${continueRegistration_css}")
    private String continueRegistration_css;

    @Value("${userCountry_css}")
    private String userCountry_css;

    @Value("${keep_india_cookies}")
    private String keep_india_cookies;

    @Value("${scn_oldPIN_error_msg}")
    private String scn_oldPIN_error_msg;

    @Value("${userSelectCountry_css}")
    private String userSelectCountry_css;

    @Value("${userAddress_css}")
    private String userAddress_css;

    @Value("${userZip_css}")
    private String userZip_css;

    @Value("${userCity_css}")
    private String userCity_css;

    @Value("${userEmail_css}")
    private String userEmail_css;

    @Value("${userCountryCode_css}")
    private String userCountryCode_css;

    @Value("${userSelectCountryCode_css}")
    private String userSelectCountryCode_css;

    @Value("${userAreaCode_css}")
    private String userAreaCode_css;

    @Value("${userPhoneNumber_css}")
    private String userPhoneNumber_css;

    @Value("${userServiceCard_css}")
    private String userServiceCard_css;

    @Value("${userUserName_css}")
    private String userUserName_css;

    @Value("${userPassword_css}")
    private String userPassword_css;

    @Value("${userConfirmPassword_css}")
    private String userConfirmPassword_css;

    @Value("${userCreateContinueRegistration_xpath}")
    private String userCreateContinueRegistration_xpath;

    @Value("${userGeneralConsent_css}")
    private String userGeneralConsent_css;

    @Value("${userAcceptTerms_css}")
    private String userAcceptTerms_css;

    @Value("${userEnrollmentMessage_css}")
    private String userEnrollmentMessage_css;

    @Value("${welcomeHeader_css}")
    private String welcomeHeader_css;

    @Value("${serviceCardID_css}")
    private String serviceCardID_css;

    @Value("${downloadServiceCard_css}")
    private String downloadServiceCard_css;

    @Value("${printIcon_css}")
    private String printIcon_css;

    @Value("${loginLink_css}")
    private String loginLink_css;

    @Value("${mamHomePage_css}")
    private String mamHomePage_css;

    @Value("${stepperElement_css}")
    private String stepperElement_css;

    @Value("${stepperValidation_xpath}")
    private String stepperValidation_xpath;

    @Value("${userCreateAccountGeneralConsent_css}")
    private String userCreateAccountGeneralConsent_css;

    @Value("${userCreateAccountAcceptTerms_css}")
    private String userCreateAccountAcceptTerms_css;
/*OneID*/

    @Value("${seviceCardNumber_xpath}")
    private String seviceCardNumber_xpath;

    @Value("${forgetPinLink_xpath}")
    private String forgetPinLink_xpath;

   @Value("${loginWithMileAndMore_xpath}")
   private String loginWithMileAndMore_xpath;

    @Value("${userUsername_id}")
    private String userUsername_id;

    @Value("${userContinue_xpath}")
    private String userContinue_xpath;

    @Value("${userContinueMM_xpath}")
    private String userContinueMM_xpath;

    @Value("${infoIcomButton_xpath}")
    private String infoIcomButton_xpath;

    @Value("${confirm_cookies}")
    private String confirm_cookies;

    @Value("${neccessary_cookie_germany}")
    private String neccessary_cookie_germany;

    @Value("${myProfile_login_details_requestPIN}")
    private String myProfile_login_details_requestPIN;

    @Value("${myProfile_login_details}")
    private String myProfile_login_details;

    @Value("${neccessary_cookie_selectAll}")
    private String neccessary_cookie_selectAll;


    @Value("${airline_tenant_login}")
    private String airline_tenant_login;

    @Value("${cancel_2fa}")
    private String cancel_2fa;

    @Value("${myAccount_xpath}")
    private String myAccount_xpath;

    @Value("${cdn_preview_login}")
    private String cdn_preview_login;

    @Value("${step1_email_login_xpath}")
    private String step1_email_login_xpath;

    @Value("${infoMessage_xpath}")
    private String infoMessage_xpath;

    @Value("${forgetPasswordlink_xpath}")
    private String forgetPasswordlink_xpath;

    @Value("${forgot_scn_reset_input}")
    private String forgot_scn_reset_input;

    @Value("${userName_forgot_password}")
    private String userName_forgot_password;

    @Value("${forgot_scn_pin_link}")
    private String forgot_scn_pin_link;

    @Value("${forget_legacy_password_xpath}")
    private String forget_legacy_password_xpath;

    @Value("${forget_travelId_password}")
    private String forget_travelId_password;

    @Value("${forgotten_travelId_password}")
    private String forgotten_travelId_password;

    @Value("${travelid_forgot_username}")
    private String travelid_forgot_username;

    @Value("${airlineTenant_reset_password}")
    private String airlineTenant_reset_password;

    @Value("${usernameonForgetPasswordPage_xpath}")
    private String usernameonForgetPasswordPage_xpath;

    @Value("${error_link_xpath}")
    private String error_link_xpath;

    @Value("${reSetPassword_xpath}")
    private String reSetPassword_xpath;

    @Value("${successMessage_xpath}")
    private String successMessage_xpath;

    @Value("${userNameResetPasswordPage_xpath}")
    private String userNameResetPasswordPage_xpath;

    @Value("${userClearText_xpath}")
    private String userClearText_xpath;

    @Value("${serviceCardForgetPinPage_xapth}")
    private String serviceCardForgetPinPage_xapth;

    @Value("${successMessageForgetPinPage_xapth}")
    private String successMessageForgetPinPage_xapth;

    /*Enrolment*/
    @Value("${enrolmentLink_xpath}")
    private String enrolmentLink_xpath;

    @Value("${enrolmentEmail_xpath}")
    private String enrolmentEmail_xpath;

    @Value("${enrolmentPassword_xpath}")
    private String enrolmentPassword_xpath;

    @Value("${enrolmentExpandButton_xpath}")
    private String enrolmentExpandButton_xpath;

    @Value("${loginWithEmailInMilreAndMorePage_xpath}")
    private String loginWithEmailInMilreAndMorePage_xpath;

    @Value("${clickOnEnrolmentlink_xpath}")
    private String clickOnEnrolmentlink_xpath;

    @Value("${clickOnAccordion_css}")
    private String clickOnAccordion_css;

    @Value("${clickOnContinue_xpath}")
    private String clickOnContinue_xpath;

    @Value("${registrationBack_xpath}")
    private String registrationBack_xpath;

    @Value("${accountPageTitile_xpath}")
    private String accountPageTitile_xpath;

    @Value("${serviceCardTitle_xpath}")
    private String serviceCardTitle_xpath;

    @Value("${milesAndMoePartners_xpath}")
    private String milesAndMoePartners_xpath;

    @Value("${userStreet_css}")
    private String userStreet_css;

    @Value("${userClickonCountinuInEnrolmentPage_css}")
    private String userClickonCountinuInEnrolmentPage_css;

    @Value("${userClickOnCountinuInServiceCardPage_css}")
    private String userClickOnCountinuInServiceCardPage_css;

    @Value("${userVerifyCommunicationPage_css}")
    private String userVerifyCommunicationPage_css;

    @Value("${userSelectCheckBox_css}")
    private String userSelectCheckBox_css;

    @Value("${userClickOnCountinuAndConfirmeButton_css}")
    private String userClickOnCountinuAndConfirmeButton_css;

    @Value("${userVerifyConfirmationMessage_xpath}")
    private String userVerifyConfirmationMessage_xpath;

    @Value("${lufthansaLogo_css}")
    private String lufthansaLogo_css;

    @Value("${austrainLog_css}")
    private String austrainLog_css;

    @Value("${swissLogo_css}")
    private String swissLogo_css;

    @Value("${erowingsLogo_css}")
    private String erowingsLogo_css;

    @Value("${userSelectErowings_xpath}")
    private String userSelectErowings_xpath;

    @Value("${userVerifyesTheServiceCardTitile_xpath}")
    private String userVerifyesTheServiceCardTitile_xpath;

    @Value("${userVerifyesTheAccountPage_xpath}")
    private String userVerifyesTheAccountPage_xpath;

    @Value("${userVerifyesTheConfirmation_xpath}")
    private String userVerifyesTheConfirmation_xpath;

    @Value("${userVerifiesLoginText_xpath}")
    private String userVerifiesLoginText_xpath;

    @Value("${userVerifiesUsernameText_xpath}")
    private String userVerifiesUsernameText_xpath;

    @Value("${userVerifyesUserNameFailed_xpath}")
    private String userVerifyesUserNameFailed_xpath;

    @Value("${userVerifiesContinu_xpath}")
    private String userVerifiesContinu_xpath;

    @Value("${userVerifiesLoginWithEmail_xpath}")
    private String userVerifiesLoginWithEmail_xpath;

    @Value("${UserVerifiesEnterEmailAddressText_xpath}")
    private String UserVerifiesEnterEmailAddressText_xpath;

    @Value("${userVerifiesEmailAddrestextInFailed_xpath}")
    private String userVerifiesEmailAddrestextInFailed_xpath;

    @Value("${userEnterEnterUserName_css}")
    private String userEnterEnterUserName_css;

    @Value("${userClicksOnContinue_xpath}")
    private String userClicksOnContinue_xpath;

    @Value("${userVerifiesWelcomeBackText_xpath}")
    private String userVerifiesWelcomeBackText_xpath;

    @Value("${userVerifiesEnterUserTravelIDPasswordText_xpath}")
    private String userVerifiesEnterUserTravelIDPasswordText_xpath;

    @Value("${userVerifiesDisabledEmail_css}")
    private String userVerifiesDisabledEmail_css;

    @Value("${userEnterPassword_css}")
    private String userEnterPassword_css;

    @Value("${userClickOnEyeButtonInWelcomeBack_xpath}")
    private String userClickOnEyeButtonInWelcomeBack_xpath;

    @Value("${userCanVerifiesUnmaskedPassword_xpath}")
    private String userCanVerifiesUnmaskedPassword_xpath;

    @Value("${userVerifiesCheckBox_xpath}")
    private String userVerifiesCheckBox_xpath;

    @Value("${userVerifiesInfoMessage_xpath}")
    private String userVerifiesInfoMessage_xpath;

    @Value("${userClicksOnInfoIcon_xpath}")
    private String userClicksOnInfoIcon_xpath;

    @Value("${userVerifiesLoginTextinTenet_xpath}")
    private String userVerifiesLoginTextinTenet_xpath;

    @Value("${userVerifiesEmailAdressTextInTenent_xpath}")
    private String userVerifiesEmailAdressTextInTenent_xpath;

    @Value("${userVerifiesEmailLebelInTenent_xpath}")
    private String userVerifiesEmailLebelInTenent_xpath;

    @Value("${userVerifiesLinkForEnrolmentLufthansa_xpath}")
    private String userVerifiesLinkForEnrolmentLufthansa_xpath;

    @Value("${userVerifiesLinkForEnrolmentAustrian_xpath}")
    private String userVerifiesLinkForEnrolmentAustrian_xpath;

    @Value("${userVerifiesLinkForEnrolmentSwiss_xpath}")
    private String userVerifiesLinkForEnrolmentSwiss_xpath;

    @Value("${userverifiesLoginWithMMTextInTenent_xpath}")
    private String userverifiesLoginWithMMTextInTenent_xpath;

    @Value("${userVerifiesWelcomeBackTextInTenent_xpath}")
    private String userVerifiesWelcomeBackTextInTenent_xpath;

    @Value("${userVerifiesPasswordTextInTenent_xpath}")
    private String userVerifiesPasswordTextInTenent_xpath;

    @Value("${userenterpasswordInTenent_xpath}")
    private String userenterpasswordInTenent_xpath;

    @Value("${userverifiesDisableEmailInTenent_xpath}")
    private String userverifiesDisableEmailInTenent_xpath;

    @Value("${userverifiesUnmaskedPasswordInTenent_xpath}")
    private String userverifiesUnmaskedPasswordInTenent_xpath;

    @Value("${userClickInfoIconInTenent_xpath}")
    private String userClickInfoIconInTenent_xpath;

    @Value("${userClickOnLoginInTenent_xpath}")
    private String userClickOnLoginInTenent_xpath;

    @Value("${userVerifiesInfoMessageInTenent_xpath}")
    private String userVerifiesInfoMessageInTenent_xpath;

    @Value("${userverifiesTraveIDTextInTenent_xpath}")
    private String userverifiesTraveIDTextInTenent_xpath;

    @Value("${userUncheckTheCheckBoxInTent_xpath}")
    private String userUncheckTheCheckBoxInTent_xpath;

    @Value("${userVerifiesTravelIDAccessInformation_xpath}")
    private String userVerifiesTravelIDAccessInformation_xpath;

    @Value("${userVerifiesEnrolmentLinkInTenent_xpath}")
    private String userVerifiesEnrolmentLinkInTenent_xpath;

    @Value("${userVefiesTheRegistroLinkInMM_xpath}")
    private String userVefiesTheRegistroLinkInMM_xpath;

    @Value("${userverifiesTravelIDAccount_xpath}")
    private String userverifiesTravelIDAccount_xpath;

    @Value("${userverifiesTravelAcessText_xpath}")
    private String userverifiesTravelAcessText_xpath;


    @Value("${userVerifiesPasswordTent_xpath}")
    private String userVerifiesPasswordTent_xpath;

    @Value("${userClicksOnCountiueButton_css}")
    private String userClicksOnCountiueButton_css;

    @Value("${userEnterEmailInTenent_css}")
    private String userEnterEmailInTenent_css;

    @Value("${userEnterPasswordInTenet_xpath}")
    private String userEnterPasswordInTenet_xpath;

    @Value("${userClickonCountineInTenent_css}")
    private String userClickonCountineInTenent_css;

    @Value("${userClickOnActivateMailesAndMore_css}")
    private String userClickOnActivateMailesAndMore_css;

    @Value("${userClickOnTitleRadioButtion_xpath}")
    private String userClickOnTitleRadioButtion_xpath;

    @Value("${userClickOnTitleRadioButtionForMs_xpath}")
    private String userClickOnTitleRadioButtionForMs_xpath;

    @Value("${userClicksOnCountinueButton_css}")
    private String userClicksOnCountinueButton_css;

    @Value("${userSelectCheckBoxInTenent_css}")
    private String userSelectCheckBoxInTenent_css;

    @Value("${userSelectCheckBoxInTenent_xpath}")
    private String userSelectCheckBoxInTenent_xpath;

    @Value("${enrolment_step4_communication_content1}")
    private String enrolment_step4_communication_content1;

    @Value("${enrolment_step4_communication_content2}")
    private String enrolment_step4_communication_content2;

    @Value("${enrolment_step4_communication_content3}")
    private String enrolment_step4_communication_content3;

    @Value("${enrolment_step4_communication_content_evenMoreMM}")
    private String enrolment_step4_communication_content_evenMoreMM;

    @Value("${enrolment_step4_communication_content_MMNewsLetter}")
    private String enrolment_step4_communication_content_MMNewsLetter;

    @Value("${enrolment_step4_communication_content_Offer}")
    private String enrolment_step4_communication_content_Offer;

    @Value("${enrolment_step4_communication_content_marketReserch}")
    private String enrolment_step4_communication_content_marketReserch;

    @Value("${enrolment_step4_communication_content_adjTime}")
    private String enrolment_step4_communication_content_adjTime;

    @Value("${enrolment_step4_communication_content_adjAnyTime}")
    private String enrolment_step4_communication_content_adjAnyTime;

    @Value("${enrolment_step4_communication_header}")
    private String enrolment_step4_communication_header;

    @Value("${enrolment_step4_communication_header_evenMoreMM}")
    private String enrolment_step4_communication_header_evenMoreMM;

    @Value("${enrolment_step4_communication_header_MMNewsLetter}")
    private String enrolment_step4_communication_header_MMNewsLetter;

    @Value("${enrolment_step4_communication_header_MMOffers}")
    private String enrolment_step4_communication_header_MMOffers;

    @Value("${enrolment_step4_communication_header_MarketResearch}")
    private String enrolment_step4_communication_header_MarketResearch;

    @Value("${enrolment_step4_communication_header_adjustmentTime}")
    private String enrolment_step4_communication_header_adjustmentTime;

    @Value("${areaCode_css}")
    private String areaCode_css;

    @Value("${number_css}")
    private String number_css;

    @Value("${countrycode_css}")
    private String countrycode_css;

    @Value("${userenterState_css}")
    private String userenterState_css;

    @Value("${worldshop_login_button}")
    private String worldshop_login_button;

    @Value("${worldshop_cookies}")
    private String worldshop_cookies;

    @Value("${confirmCookie_xpath}")
    private String confirmCookie_xpath;

    @Value("${MailesAndMoreCounteButton_Setp2_css}")
    private String  MailesAndMoreCounteButton_Setp2_css;

    @Value("${MailesAndMoreCounteButton_Setp2_xpath}")
    private String  MailesAndMoreCounteButton_Setp2_xpath;

    @Value("${userEmail_id}")
    private String  userEmail_id;

    @Value("${userVerifiesMemberPage_css}")
    private String  userVerifiesMemberPage_css;

    @Value("${worldshop_home_page_xpath}")
    private String  worldshop_home_page_xpath;

    @Value("${userCanEnterUsernameMMTenant_xpath}")
    private String  userCanEnterUsernameMMTenant_xpath;

    @Value("${userCanEnterPsswordMMTenant_css}")
    private String  userCanEnterPsswordMMTenant_css;


    @Value("${userClicksOnLoginMMTenant_xpath}")
    private String  userClicksOnLoginMMTenant_xpath;

    @Value("${keep_jerman_cookies}")
    private String keep_jerman_cookies;

    @Value("${CP_old_pwd_xpath}")
    private String CP_old_pwd_xpath;

    @Value("${Cpwd_field_error_msg}")
    private String Cpwd_field_error_msg;

    @Value("${enrolment_home_text}")
    private String enrolment_home_text;

    @Value("${email_error_valiation_msg}")
    private String email_error_valiation_msg;

    @Value("${password_error_validation_msg}")
    private String password_error_validation_msg;

    @Value("${firstName_xpath}")
    private String firstName_xpath;

    @Value("${fName_error_msg}")
    private String fName_error_msg;

    @Value("${surname_xpath}")
    private String surname_xpath;

    @Value("${surname_error_msg}")
    private String surname_error_msg;

    @Value("${bday_error_msg}")
    private String bday_error_msg;

    @Value("${enrolment_airlineTenant_error_box}")
    private String enrolment_airlineTenant_error_box;

    @Value("${country_error_msg}")
    private String  country_error_msg;

    @Value("${street_error_msg}")
    private String  street_error_msg;

    @Value("${userAdditional_address_xpath}")
    private String  userAdditional_address_xpath;

    @Value("${additional_address_error_msg}")
    private String  additional_address_error_msg;

    @Value("${postal_error_msg}")
    private String  postal_error_msg;

    @Value("${phoneNo_error_msg}")
    private String  phoneNo_error_msg;

    @Value("${city_error_msg}")
    private String  city_error_msg;

    @Value("${state_error_msg}")
    private String state_error_msg;

    @Value("${userState_css}")
    private String userState_css;

    @Value("${CP_new_pwd_xpath}")
    private String CP_new_pwd_xpath;

    @Value("${mam_enrolment_home_text}")
    private String mam_enrolment_home_text;

    @Value("${mam_enrolment_login_form}")
    private String mam_enrolment_login_form;

    @Value("${cdn_enrolment_xpath}")
    private String cdn_enrolment_xpath;

    @Value("${login_button_xpath}")
    private String login_button_xpath;

    @Value("${Logintext}")
    private String loginText;

    @Value("${select_all_cookies}")
    private String select_all_cookies;

    @Value("${userCanEnterPinMMTenant_css}")
    private String  userCanEnterPinMMTenant_css;

    @Value("${CP_stepper_invalidation_msg}")
    private String CP_stepper_invalidation_msg;

    @Value("${enrolment_step4_page}")
    private String enrolment_step4_page;

    @Value("${UserSelectKeepEnglishIsPreparedLanguage_xpath}")
    private String  UserSelectKeepEnglishIsPreparedLanguage_xpath;

    @Value("${userEnterPasswordInPWChangePage_css}")
    private String  userEnterPasswordInPWChangePage_css;

    @Value("${email_pin_password_old_password}")
    private String  email_pin_password_old_password;

    @Value("${email_pin_password_new_password}")
    private String  email_pin_password_new_password;

    @Value("${userclicksOnSavePasswordInPWChangePage_xpath}")
    private String  userclicksOnSavePasswordInPWChangePage_xpath;

    @Value("${userVerifiesErrorMessageForOldPasswordFealdInPWChange_xpath}")
    private String  userVerifiesErrorMessageForOldPasswordFealdInPWChange_xpath;

    @Value("${userEnterNewPasswordInNewPasswordFealdInPWChange_css}")
    private String  userEnterNewPasswordInNewPasswordFealdInPWChange_css;

    @Value("${userClicksOnActivateNow_xpath}")
    private String  userClicksOnActivateNow_xpath;

    @Value("${userClicksOn_ActivateNow}")
    private String  userClicksOn_ActivateNow;

    @Value("${userClickOnConfirmButton_xpath}")
    private String  userClickOnConfirmButton_xpath;

    @Value("${userEntersVerificationCode_css}")
    private String  userEntersVerificationCode_css;

    @Value("${forgot_pin_2fa_code}")
    private String  forgot_pin_2fa_code;

    @Value("${userClicksOnSubmitButton_xpath}")
    private String  userClicksOnSubmitButton_xpath;

    @Value("${userClicksOnMyProfileLink_xpath}")
    private String  userClicksOnMyProfileLink_xpath;

    @Value("${userClickOnEdit_css}")
    private String  userClickOnEdit_css;

    @Value("${userClicksOnPinChange_xpath}")
    private String  userClicksOnPinChange_xpath;

//Mani
    @Value("${scn_info_xpath}")
    private String scn_info_xpath;

    @Value("${BP_persional_communication_checkbox}")
    private String BP_persional_communication_checkbox;

    @Value("${Persional_communication_checkbox}")
    private String Persional_communication_checkbox;

    @Value("${profile_myAccount_summary}")
    private String profile_myAccount_summary;

    @Value("${MilesAndMore_personalOffer}")
    private String MilesAndMore_personalOffer;

    @Value("${MilesAndMore_personalOffer_message}")
    private String MilesAndMore_personalOffer_message;

    @Value("${profile_market_research}")
    private String profile_market_research;

    @Value("${MilesAndMore_personalOffer_Email}")
    private String MilesAndMore_personalOffer_Email;

    @Value("${MilesAndMore_personalOffer_Phone}")
    private String MilesAndMore_personalOffer_Phone;

    @Value("${MilesAndMore_Newsletter}")
    private String MilesAndMore_Newsletter;

    @Value("${MilesAndMore_product_info}")
    private String MilesAndMore_product_info;

    @Value("${MilesAndMore_product_info_sms}")
    private String MilesAndMore_product_info_sms;

    @Value("${MilesAndMore_product_info_email}")
    private String MilesAndMore_product_info_email;

    @Value("${profile_complete_percent}")
    private String  profile_complete_percent;


    @Value("${scn_help_text_xpath}")
    private String scn_help_text_xpath;

    @Value("${ffb_Login_user_continue}")
    private String ffb_Login_user_continue;

    @Value("${scn_invalid_msg_xpath}")
    private String scn_invalid_msg_xpath;

    @Value("${profile_travelid_permissions}")
    private String profile_travelid_permissions;

    @Value("${PDU_profile_travelId_permission}")
    private String PDU_profile_travelId_permission;

    @Value("${profile_permission_saveChanges}")
    private String profile_permission_saveChanges;

    @Value("${profile_BP_permission_saveChanges}")
    private String profile_BP_permission_saveChanges;

    @Value("${profile_pdu_save_changes}")
    private String profile_pdu_save_changes;

//    @Value("${seviceCardNumber_xpath}")
//    private String seviceCardNumber_xpath;


//    @Value("${userEnterServiceCardNumber_css}")
//    private String userEnterServiceCardNumber_css;


//Mani2
@Value("${ffb_Login_username_xpath}")
private String ffb_Login_username_xpath;
//
//    @Value("${ffb_Login_user_continue}")
//    private String ffb_Login_user_continue;

    @Value("${enter_pin_info_text}")
    private String enter_pin_info_text;

    @Value("${tool_tip_msg}")
    private String tool_tip_msg;

    @Value("${scn_pin_xpath}")
    private String scn_pin_xpath;

    @Value("${mam_scn_old_pin}")
    private String mam_scn_old_pin;

    @Value("${mam_scn_new_pin}")
    private String mam_scn_new_pin;

    @Value("${mam_change_pin_xpath}")
    private String mam_change_pin_xpath;

    @Value("${ffb_login_xpath}")
    private String ffb_login_xpath;

    @Value("${step2_login_xpath}")
    private String step2_login_xpath;

    @Value("${scn_pin_validation_msg_xpath}")
    private String scn_pin_validation_msg_xpath;

    @Value("${step2_login_issue_xpath}")
    private String step2_login_issue_xpath;

//    @Value("${loginWithMileAndMore_xpath}")
//    private String loginWithMileAndMore_xpath;

    @Value("${ffb_login_userpassword_xpath}")
    private String ffb_login_userpassword_xpath;

    @Value("${CPwd_Current}")
    private String CPwd_Current;

    @Value("${step1_user_continue_xpath}")
    private String step1_user_continue_xpath;

    @Value("${login_step2_error_msg_xpath}")
    private String login_step2_error_msg_xpath;


//    @Value("${old_pin_input_xpath}")
//    private String old_pin_input_xpath;

    @Value("${new_pin_input_xpath}")
    private String new_pin_input_xpath;

    @Value("${stepper_pin_invalid_msg}")
    private String stepper_pin_invalid_msg;

//    @Value("${userEnterPinInMMTenent_css}")
//    private String userEnterPinInMMTenent_css;

    @Value("${userEnterOldPinInMMTenent_css}")
    private String userEnterOldPinMMTenet_css;

    @Value("${userEnterNewPinInMMTenent_css}")
    private String userEnterNewPinInMMTenent_css;

    @Value("${userclickOnSavaPinMMTenet_xpath}")
    private String userclickOnSavaPinMMTenet_xpath;

    @Value("${forgetPasswordlink_xpathInMMTenent}")
    private String forgetPasswordlink_xpathInMMTenent;

    @Value("${usernameonForgetPasswordPageInMMTenent_xpath}")
    private String usernameonForgetPasswordPageInMMTenent_xpath;

    @Value("${reSetPasswordInMMTenent_xpath}")
    private String reSetPasswordInMMTenent_xpath;

    @Value("${invalid_error_text}")
    private String invalid_error_text;

    @Value("${reset_email_link}")
    private String reset_email_link;

    @Value("${reset_scn_pin_link}")
    private String reset_scn_pin_link;

    @Value("${username_reset_pin_text}")
    private String username_reset_pin_text;

    @Value("${uname_password_reset_success}")
    private String uname_password_reset_success;

    @Value("${userEnterServiceCard_css}")
    private String userEnterServiceCard_css;

    @Value("${userClicksOnResetLink_xpath}")
    private String userClicksOnResetLink_xpath;

    @Value("${userVerifiesConfoirmationText_xpath}")
    private String userVerifiesConfoirmationText_xpath;

    @Value("${userClicksOnForgetUsername_xpath}")
    private String userClicksOnForgetUsername_xpath;

    @Value("${userEnterUserNameInForgetPasswordPage_xpath}")
    private String userEnterUserNameInForgetPasswordPage_xpath;

    @Value("${userName_forgotten_password}")
    private String userName_forgotten_password;

    @Value("${email_forgotten_password}")
    private String email_forgotten_password;

    @Value("${userClickOnResetLink_xpath}")
    private String userClickOnResetLink_xpath;

    @Value("${userclicksOnRestLinEmail_xpath}")
    private String userclicksOnRestLinEmail_xpath;

    @Value("${reset_email_password_request_link}")
    private String reset_email_password_request_link;

    @Value("${reset_success_scn_text}")
    private String reset_success_scn_text;

    @Value("${reset_request_pin_link}")
    private String reset_request_pin_link;

    @Value("${reset_completion_success_msg}")
    private String reset_completion_success_msg;

    @Value("${reset_email}")
    private String reset_email;

    @Value("${register_travelId}")
    private String register_travelId;

    @Value("${password_xpath}")
    private String password_xpath;

//    @Value("${enrolment_continue}")
//    private String enrolment_continue;

    @Value("${register_travel_id_xpath}")
    private String register_travel_id_xpath;

    @Value("${enrolment_connect_later_button}")
    private String enrolment_connect_later_button;

    @Value("${enrolmentForm_MMG_tenant_name}")
    private String enrolmentForm_MMG_tenant_name;

    @Value("${enrolmentForm_Lufthansa_tenant_name}")
    private String enrolmentForm_Lufthansa_tenant_name;

    @Value("${enrolmentForm_airlineTenant_email_pricipleType}")
    private String enrolmentForm_airlineTenant_email_pricipleType;

    @Value("${enrolmentForm_airlineTenant_username_pricipleType}")
    private String enrolmentForm_airlineTenant_username_pricipleType;

    @Value("${enrolmentForm_Swiss_tenant_name}")
    private String enrolmentForm_Swiss_tenant_name;

    @Value("${enrolmentForm_Austrian_tenant_name}")
    private String enrolmentForm_Austrian_tenant_name;

    @Value("${enrolmentForm_airlineTenant_login}")
    private String enrolmentForm_airlineTenant_login;

    @Value("${enrolmentForm_airlineTenant_login_text}")
    private String enrolmentForm_airlineTenant_login_text;

    @Value("${register_for_travel_Id_xpath}")
    private String register_for_travel_Id_xpath;

    @Value("${enrolment_mamTenent_expireLink}")
    private String enrolment_mamTenent_expireLink;

    @Value("${enrolment_airlinetenant_success}")
    private String enrolment_airlinetenant_success;

    @Value("${enrolment_airlinetenant_success_message}")
    private String enrolment_airlinetenant_success_message;


    @Value("${lufthnsa_SCN_active}")
    private String lufthnsa_SCN_active;

    @Value("${confirm_registration_text}")
    private String confirm_registration_text;

    @Value("${enrolment_confirm_text}")
    private String enrolment_confirm_text;

    @Value("${enrolment_registraion_text}")
    private String enrolment_registraion_text;


    @Value("${scn_registration_next}")
    private String scn_registration_next;

    @Value("${email_error_xpath}")
    private String email_error_xpath;

    @Value("${enrolment_error_link}")
    private String enrolment_error_link;

    @Value("${enrolment_email_errorCount_box}")
    private String enrolment_email_errorCount_box;

    @Value("${userLogoutMMInTenent_xpath}")
    private String userLogoutMMInTenent_xpath;

    @Value("${member_logout_xpath}")
    private String member_logout_xpath;

    @Value("${userVerifiesSuccessMessageInMMTenent_xpath}")
    private String userVerifiesSuccessMessageInMMTenent_xpath;

    @Value("${reset_password_success_msg}")
    private String reset_password_success_msg;

    @Value("${mam_preHome_Login_Page}")
    private String mam_preHome_Login_Page;

    @Value("${reset_email_password_successMsg}")
    private String reset_email_password_successMsg;

    @Value("${change_password_success_msg}")
    private String change_password_success_msg;

    @Value("${reset_completion_login_button}")
    private String reset_completion_login_button;

    @Value("${userCloseSuccessMessage_xpath}")
    private String userCloseSuccessMessage_xpath;

    @Value("${verifiesErrorMessage_xpath}")
    private String verifiesErrorMessage_xpath;

    @Value("${verifyErrorMessage_xpath}")
    private String verifyErrorMessage_xpath;

    @Value("${verifiesRegisterAgainNow_xpath}")
    private String verifiesRegisterAgainNow_xpath;

    @Value("${verifyRegisterAgainNow_xpath}")
    private String verifyRegisterAgainNow_xpath;

    @Value("${airlineTenant_pricipleType}")
    private String airlineTenant_pricipleType;

    @Value("${enrolment_AirlintTenant_registerForTravelId_button}")
    private String enrolment_AirlintTenant_registerForTravelId_button;

    @Value("${enrolment_AirlintTenant_registerForTravelId}")
    private String enrolment_AirlintTenant_registerForTravelId;

    @Value("${active2fa_successfull_pop_up}")
    private String active2fa_successfull_pop_up;

    @Value("${active2fa_sucess_pop_up_close}")
    private String active2fa_sucess_pop_up_close;

    @Value("${errorMessageHomepage_xpath}")
    private String errorMessageHomepage_xpath;

    @Value("${VerifiesErrorMessageExpairedLink}")
    private String VerifiesErrorMessageExpairedLink;

    @Value("${enrolment_Verify_expireMessage}")
    private String enrolment_Verify_expireMessage;

    @Value("${verifyResetPassword_Page_xpath}")
    private String verifyResetPassword_Page_xpath;

    @Value("${registrationHomePage_xpath}")
    private String registrationHomePage_xpath;

    @Value("${verifyResetPasswordPage_xpath}")
    private String verifyResetPasswordPage_xpath;

    @Value("${userEnterPasswordInResetPasswordPage}")
    private String userEnterPasswordInResetPasswordPage;

    @Value("${reset_email_password}")
    private String reset_email_password;

    @Value("${userClickOnSaveInResetPasswrodPage_xpath}")
    private String userClickOnSaveInResetPasswrodPage_xpath;

    @Value("${userClicks_on_email_update_password}")
    private String userClicks_on_email_update_password;

    @Value("${reset_email_password_submit}")
    private String reset_email_password_submit;

    @Value("${reset_email_save_password}")
    private String reset_email_save_password;

    @Value("${verifySuccessMessage_xpath}")
    private String verifySuccessMessage_xpath;

    @Value("${userClickOnGotoLogin_xpath}")
    private String userClickOnGotoLogin_xpath;

    @Value("${userClickOnRequestCode_xpath}")
    private String userClickOnRequestCode_xpath;

    @Value("${userEnterSMSCodeForAactiveUser_xpath}")
    private String userEnterSMSCodeForAactiveUser_xpath;

    @Value("${userClickOnSubmiteActiveuser_xpath}")
    private String userClickOnSubmiteActiveuser_xpath;

    @Value("${validateResetLink_xpath}")
    private String validateResetLink_xpath;

    @Value("${userClickOnGotoLoginAfterError_xpath}")
    private String userClickOnGotoLoginAfterError_xpath;

    @Value("${userClickOnRequestLink_xpath}")
    private String userClickOnRequestLink_xpath;

    @Value("${userClicks_on_request_link_username}")
    private String userClicks_on_request_link_username;

    @Value("${userVerifiesSuccessMessageInPWRestPage_xpath}")
    private String userVerifiesSuccessMessageInPWRestPage_xpath;

    @Value("${profile_email_heading}")
    private String profile_email_heading;

//    @Value("${profile_email_Id}")
//    private String profile_email_Id;

    @Value("${profile_changePwd_link}")
    private String profile_changePwd_link;

    @Value("${profile_changePassword_link}")
    private String profile_changePassword_link;

    @Value("${profile_scn_changePin_link}")
    private String profile_scn_changePin_link;

    @Value("${profile_scn_requestPin_link}")
    private String profile_scn_requestPin_link;

    @Value("${profile_streetName}")
    private String profile_streetName;

    @Value("${profile_cityName}")
    private String profile_cityName;

    @Value("${profile_additionalAddress}")
    private String profile_additionalAddress;

    @Value("${edit_2fa_phone_no}")
    private String edit_2fa_phone_no;

    @Value("${phone_save_changes}")
    private String phone_save_changes;

    @Value("${save_changes_disable}")
    private String save_changes_disable;

    @Value("${email_save_changes}")
    private String email_save_changes;

    @Value("${profile_email_xpath}")
    private String profile_email_xpath;

    @Value("${profile_2fa}")
    private String profile_2fa;
    @Value("${auth_2fa_close_in_profile}")
    private String auth_2fa_close_in_profile;

    @Value("${request_code_2fa_pop_up_close}")
    private String request_code_2fa_pop_up_close;

    @Value("${success_2fa_message_close}")
    private String success_2fa_message_close;

    @Value("${page_upArrow}")
    private String page_upArrow;

    @Value("${preferred_launguage}")
    private String preferred_launguage;

    @Value("${preferred_launguage_english}")
    private String preferred_launguage_english;

    @Value("${additional_addressLine}")
    private String additional_addressLine;

    @Value("${radioButton_german}")
    private String radioButton_german;

    @Value("${load_previous_page}")
    private String load_previous_page;

    @Value("${myAcc_summary}")
    private String myAcc_summary;

    @Value("${language_saveChanges}")
    private String language_saveChanges;

    @Value("${other_telephoneNo}")
    private String  other_telephoneNo;

    @Value("${other_telephoneNo_xpath}")
    private String  other_telephoneNo_xpath;

    @Value("${other_telephoneNo_saveChanges}")
    private String  other_telephoneNo_saveChanges;

    @Value("${other_telephoneNo_countryCode}")
    private String  other_telephoneNo_countryCode;

    @Value("${mobileNo_radioButton}")
    private String  mobileNo_radioButton;

    @Value("${country_code_xpath}")
    private String  country_code_xpath;

    @Value("${change_phone_no}")
    private String  change_phone_no;

    @Value("${primary_phone_no}")
    private String  primary_phone_no;

    @Value("${next_2fa_xpath}")
    private String  next_2fa_xpath;

    @Value("${popup_2fa_areaCode_xpath}")
    private String  popup_2fa_areaCode_xpath;

    @Value("${country_code_dropDown}")
    private String  country_code_dropDown;

    @Value("${change_2fa_phone_no}")
    private String  change_2fa_phone_no;

    @Value("${saveChanges_2fa_phoneNo}")
    private String  saveChanges_2fa_phoneNo;

    @Value("${change_2fa_phoneno_prefix}")
    private String  change_2fa_phoneno_prefix;

    @Value("${localNo_xpath}")
    private String  localNo_xpath;

    @Value("${local_no_xpath}")
    private String  local_no_xpath;

    @Value("${request_code_2fa}")
    private String  request_code_2fa;

    @Value("${profile_personalinfo_email}")
    private String  profile_personalinfo_email;

    @Value("${request_code_for_2fa_popup}")
    private String  request_code_for_2fa_popup;

    @Value("${request_code_2fa_text}")
    private String  request_code_2fa_text;

    @Value("${mam_prehome_page_with_loginButton}")
    private String  mam_prehome_page_with_loginButton;

    @Value("${mobileno_2fa_confirm}")
    private String  mobileno_2fa_confirm;

    @Value("${otp_confirm_submit}")
    private String  otp_confirm_submit;

    @Value("${update_email_otp_submit}")
    private String  update_email_otp_submit;

    @Value("${profile_areaCode_xpath}")
    private String  profile_areaCode_xpath;

    @Value("${success_2fa_close}")
    private String  success_2fa_close;

    @Value("${submit_2fa_xpath}")
    private String  submit_2fa_xpath;

    @Value("${success_2fa_message}")
    private String success_2fa_message;

    @Value("${updated_mobileNo}")
    private String updated_mobileNo;

    @Value("${profile_settings}")
    private String profile_settings;

    @Value("${profile_emailId}")
    private String profile_emailId;

    @Value("${profile_email_id}")
    private String profile_email_id;

    @Value("${profile_mobileNo_header}")
    private String profile_mobileNo_header;

    @Value("${profile_mobileNo}")
    private String profile_mobileNo;

    @Value("${profile_2fa_header}")
    private String profile_2fa_header;

    @Value("${profile_scn_header}")
    private String profile_scn_header;

    @Value("${profile_aliasName}")
    private String profile_aliasName;

    @Value("${profile_userId_heading}")
    private String profile_userId_heading;

    @Value("${profile_scn_number}")
    private String profile_scn_number;

    @Value("${profile_serviceCard_no}")
    private String profile_serviceCard_no;

    @Value("${profile_scn_heading}")
    private String profile_scn_heading;

    @Value("${profile_serviceCard_heading}")
    private String profile_serviceCard_heading;

    @Value("${profile_scn}")
    private String profile_scn;

    @Value("${profile_email_header}")
    private String profile_email_header;

    @Value("${myprofile_back}")
    private String myprofile_back;

    @Value("${user_enter_verification_code}")
    private String user_enter_verification_code;

    @Value("${verification_2fa_code_enter}")
    private String verification_2fa_code_enter;

    @Value("${postalCode_error_msg}")
    private String postalCode_error_msg;

    @Value("${profile_zipCode}")
    private String profile_zipCode;

    @Value("${auth_2fa_popup}")
    private String auth_2fa_popup;

    @Value("${request_code_2fa_pop_up}")
    private String request_code_2fa_pop_up;

    @Value("${confirm_2fa_submit}")
    private String confirm_2fa_submit;

    @Value("${country_dropdown}")
    private String country_dropdown;

    @Value("${UserContinueTT_xpath}")
    private String UserContinueTT_xpath;

    @Value("${userClicksOnRequestcode_xpath}")
    private String userClicksOnRequestcode_xpath;

    @Value("${ffpusernamesubmit}")
    private String ffpusernamesubmit;

    @Value("${ffp_email_current_password}")
    private String ffp_email_current_password;

    @Value("${ffp_email_new_password}")
    private String ffp_email_new_password;

    @Value("${ffp_email_savepassword}")
    private String ffp_email_savepassword;

    @Value("${userClicksonActivateNow}")
    private String userClicksonActivateNow;

    @Value("${ffp_username_change_password_visibleicon")
    private String ffp_username_change_password_visibleicon;

    @Value("${twofa_success_activated_msg")
    private String twofa_success_activated_msg;

    @Value("${userContinueEmail_xpath}")
    private String userContinueEmail_xpath;

    @Value("${profile_fullName}")
    private String profile_fullName;

    @Value("${profile_birthDate}")
    private String profile_birthDate;

    @Value("${profile_baseAddress}")
    private String profile_baseAddress;

    @Value("${profile_baseAddress1}")
    private String profile_baseAddress1;

    @Value("${profile_prefferLanuage}")
    private String profile_prefferLanuage;

    @Value("${activated_2fa}")
    private String activated_2fa;

    @Value("${cor_poland}")
    private String cor_poland;

    @Value("${request_code_2fa_myprofile}")
    private String  request_code_2fa_myprofile;


    @Value("${BP_LH_marketResearch_post}")
    private String BP_LH_marketResearch_post;
    @Value("${BP_LH_marketResearch_sms}")
    private String BP_LH_marketResearch_sms;
    @Value("${BP_LH_marketResearch_email}")
    private String BP_LH_marketResearch_email;
    @Value("${BP_LH_marketResearch_phone}")
    private String BP_LH_marketResearch_phone;

    @Value("${austrianAirlines_collapse}")
    private String austrianAirlines_collapse;
    @Value("${austrianAirlines_collapse_post}")
    private String austrianAirlines_collapse_post;
    @Value("${austrianAirlines_collapse_sms}")
    private String austrianAirlines_collapse_sms;
    @Value("${austrianAirlines_collapse_email}")
    private String austrianAirlines_collapse_email;
    @Value("${austrianAirlines_collapse_phone}")
    private String austrianAirlines_collapse_phone;
    @Value("${austrianAirlines_collapse_NSLetter}")
    private String austrianAirlines_collapse_NSLetter;

    @Value("${BrusselsAirlines_collapse}")
    private String BrusselsAirlines_collapse;
    @Value("${BrusselsAirlines_collapse_post}")
    private String BrusselsAirlines_collapse_post;
    @Value("${BrusselsAirlines_collapse_sms}")
    private String BrusselsAirlines_collapse_sms;
    @Value("${BrusselsAirlines_collapse_email}")
    private String BrusselsAirlines_collapse_email;
    @Value("${BrusselsAirlines_collapse_phone}")
    private String BrusselsAirlines_collapse_phone;
    @Value("${BrusselsAirlines_collapse_NSLetter}")
    private String BrusselsAirlines_collapse_NSLetter;

    @Value("${Eurowings_collapse}")
    private String Eurowings_collapse;
    @Value("${Eurowings_post}")
    private String Eurowings_post;
    @Value("${Eurowings_sms}")
    private String Eurowings_sms;
    @Value("${Eurowings_email}")
    private String Eurowings_email;
    @Value("${Eurowings_phone}")
    private String Eurowings_phone;
    @Value("${Eurowings_phone_NSLetter}")
    private String Eurowings_phone_NSLetter;


    @Value("${EurowingsDiscover_collapse}")
    private String EurowingsDiscover_collapse;
    @Value("${EurowingsDiscover_post}")
    private String EurowingsDiscover_post;
    @Value("${EurowingsDiscover_sms}")
    private String EurowingsDiscover_sms;
    @Value("${EurowingsDiscover_email}")
    private String EurowingsDiscover_email;
    @Value("${EurowingsDiscover_phone}")
    private String EurowingsDiscover_phone;
    @Value("${EurowingsDiscover_NSLetter}")
    private String EurowingsDiscover_NSLetter;

    @Value("${Lufthansa_collapse}")
    private String Lufthansa_collapse;
    @Value("${Lufthansa_post}")
    private String Lufthansa_post;
    @Value("${Lufthansa_sms}")
    private String Lufthansa_sms;
    @Value("${Lufthansa_email}")
    private String Lufthansa_email;
    @Value("${Lufthansa_phone}")
    private String Lufthansa_phone;
    @Value("${Lufthansa_NSLetter}")
    private String Lufthansa_NSLetter;

    @Value("${SWISSInternationalAirlines_collapse}")
    private String SWISSInternationalAirlines_collapse;
    @Value("${SWISSInternationalAirlines_post}")
    private String SWISSInternationalAirlines_post;
    @Value("${SWISSInternationalAirlines_sms}")
    private String SWISSInternationalAirlines_sms;
    @Value("${SWISSInternationalAirlines_email}")
    private String SWISSInternationalAirlines_email;
    @Value("${SWISSInternationalAirlines_phone}")
    private String SWISSInternationalAirlines_phone;
    @Value("${SWISSInternationalAirlines_NSLetter}")
    private String SWISSInternationalAirlines_NSLetter;

    @Value("${Login_Page_Screen_form}")
    private String Login_Page_Screen_form;

    @Value("${enrolment_communication_Page}")
    private String enrolment_communication_Page;

    @Value("${enrolment_permission_description}")
    private String enrolment_permission_description;

    @Value("${enrolment_welcome_page}")
    private String enrolment_welcome_page;

    @Value("${enrolment_partner_page}")
    private String enrolment_partner_page;

    @Value("${enrolment_welcomePage_loginButton}")
    private String enrolment_welcomePage_loginButton;

    @Value("${enrolment_airlinetenant_welcomepage_login}")
    private String enrolment_airlinetenant_welcomepage_login;

    @Value("${enrolment_airlineTenant_loginButton}")
    private String enrolment_airlineTenant_loginButton;

    @Value("${enrolment_airlineTenant_os_loginButton}")
    private String enrolment_airlineTenant_os_loginButton;

    @Value("${enrolment_airlineTenant_lx_loginButton}")
    private String enrolment_airlineTenant_lx_loginButton;

    @Value("${enrolment_arilineTenant_successWelcome_page}")
    private String enrolment_arilineTenant_successWelcome_page;

    @Value("${enrolment_success_message}")
    private String enrolment_success_message;

    @Value("${enrolment_travelId_desc}")
    private String enrolment_travelId_desc;

    @Value("${enrolment_step5_page}")
    private String enrolment_step5_page;

    @Value("${Lufthansa_partner}")
    private String Lufthansa_partner;

    @Value("${brussels_partner}")
    private String brussels_partner;

    @Value("${austrian_partner}")
    private String austrian_partner;

    @Value("${enrolment_step5_registration_page}")
    private String enrolment_step5_registration_page;

    @Value("${erowings_partner}")
    private String erowings_partner;

    @Value("${swiss_partner}")
    private String swiss_partner;

    @Value("${enrolmentForm_login}")
    private String enrolmentForm_login;

    @Value("${worldshop_userName_button_css}")
    private String worldshop_userName_button_css;

    @Value("${worldShop_animation_spinner}")
    private String worldShop_animation_spinner;

    @Value("${worldshop_logOff}")
    private String worldshop_logOff;

    @Value("${worldShop_loginLink}")
    private String worldShop_loginLink;

    @Value("${scn_save_pin}")
    private String scn_save_pin;

    @Value("${reset_pin_request_success_msg}")
    private String reset_pin_request_success_msg;

    @Value("${reset_scn_pin_save}")
    private String reset_scn_pin_save;

    @Value("${reset_scn_pin_success}")
    private String reset_scn_pin_success;

    @Value("${reset_scn_pin_login_button}")
    private String reset_scn_pin_login_button;

    @Value("${userName_principle_type_form}")
    private String userName_principle_type_form;

    @Value("${reset_scn_pin_expired}")
    private String reset_scn_pin_expired;

    @Value("${reset_scn_pin_expired_login}")
    private String reset_scn_pin_expired_login;

    @Value("${reset_email_expired_login}")
    private String reset_email_expired_login;

    @Value("${partner_forgotPIN_xpath}")
    private String partner_forgotPIN_xpath;

    @Value("${lh_os_login_or_register}")
    private String lh_os_login_or_register;

    @Value("${lx_login_or_register}")
    private String lx_login_or_register;

    @Value("${userName_forgotten_password_xpath}")
    private String userName_forgotten_password_xpath;

    @Value("${retroactive_credit}")
    private String retroactive_credit;

    @Value("${login_back_button}")
    private String login_back_button;

    @Value("${update_email_pwd_confirm_no}")
    private String update_email_pwd_confirm_no;

    @Value("${airline_email_login}")
    private String airline_email_login;

    @Value("${update_email_password_non_2fa_user}")
    private String update_email_password_non_2fa_user;

    @Value("${user_2fa_form}")
    private String user_2fa_form;

    @Value("${airline_login_with_scn}")
    private String airline_login_with_scn;

    @Value("${airline_tenant_continue_button}")
    private String airline_tenant_continue_button;

    @Value("${airline_tenant_email_error_box_link}")
    private String airline_tenant_email_error_box_link;

    @Value("${airline_tenant_credentials_error_msg}")
    private String airline_tenant_credentials_error_msg;

    @Value("${airline_tenant_oneId_login}")
    private String airline_tenant_oneId_login;

    @Value("${airline_tenant_oneId_login_1}")
    private String airline_tenant_oneId_login_1;

    @Value("${proxy_accept_cookies}")
    private String proxy_accept_cookies;

    @Value("${airline_oneId_login}")
    private String airline_oneId_login;

    @Value("${airline_tenant_validation_error_msg}")
    private String airline_tenant_validation_error_msg;

    @Value("${retroactive_mileage_page}")
    private String retroactive_mileage_page;

    @Value("${proxy_cookies_accept}")
    private String proxy_cookies_accept;

    @Value("${airline_tenant_oneId_login_2}")
    private String airline_tenant_oneId_login_2;

    @Value("${airline_scn_continue}")
    private String airline_scn_continue;

    @Value("${airline_tenant_logout}")
    private String airline_tenant_logout;

    @Value("${airline_tenant_scn_no}")
    private String airline_tenant_scn_no;

    @Value("${airline_tenant_scn_no_pop_up}")
    private String airline_tenant_scn_no_pop_up;

    @Value("${airline_scn_pin}")
    private String airline_scn_pin;

    @Value("${airline_scn_pin_save}")
    private String airline_scn_pin_save;

    @Value("${airline_tenant_uName}")
    private String airline_tenant_uName;

    @Value("${airline_tenant_Swiss_uName}")
    private String airline_tenant_Swiss_uName;

    @Value("${airline_lh_logo}")
    private String airline_lh_logo;

    @Value("${airline_lx_logo}")
    private String airline_lx_logo;

    @Value("${airline_os_logo}")
    private String airline_os_logo;

    @Value("${airline_sn_logo}")
    private String airline_sn_logo;

    @Value("${airline_footer_links}")
    private String airline_footer_links;

    @Value("${airline_lh_fav_icon}")
    private String airline_lh_fav_icon;

    @Value("${airline_lx_fav_icon}")
    private String airline_lx_fav_icon;

    @Value("${airline_os_fav_icon}")
    private String airline_os_fav_icon;

    @Value("${airline_sn_fav_icon}")
    private String airline_sn_fav_icon;

    @Value("${mam_uname_pwd_change}")
    private String mam_uname_pwd_change;

    @Value("${mam_email_pwd_change}")
    private String mam_email_pwd_change;

    @Value("${mam_pwd_change_save}")
    private String mam_pwd_change_save;

    @Value("${mam_email_pwd_change_save}")
    private String mam_email_pwd_change_save;

    @Value("${active_2fa_popup_close}")
    private String active_2fa_popup_close;

    @Value("${airline_forgot_travelId_link}")
    private String airline_forgot_travelId_link;

    @Value("${airline_reset_email_input}")
    private String airline_reset_email_input;

    @Value("${airline_reset_email_request_button}")
    private String airline_reset_email_request_button;

    @Value("${airline_reset_email_eror_link}")
    private String airline_reset_email_eror_link;

    @Value("${airline_forgot_pwd_expireLink_text}")
    private String airline_forgot_pwd_expireLink_text;

    @Value("${airline_forgot_pwd_expireUrl_resetPin_button}")
    private String airline_forgot_pwd_expireUrl_resetPin_button;

    @Value("${airline_forgot_pwd_expireUrl_login_button}")
    private String airline_forgot_pwd_expireUrl_login_button;

    @Value("${airline_reset_pwd_component}")
    private String airline_reset_pwd_component;

    @Value("${airline_tenants_Uname_expire_link_Pin_reset_button}")
    private String airline_tenants_Uname_expire_link_Pin_reset_button;

    @Value("${airline_tenants_Uname_expire_link_goto_login_button}")
    private String airline_tenants_Uname_expire_link_goto_login_button;

    @Value("${airline_tenants_scn_expire_link_Pin_reset_button}")
    private String airline_tenants_scn_expire_link_Pin_reset_button;

    @Value("${airline_tenants_scn_expire_link_goto_login_button}")
    private String airline_tenants_scn_expire_link_goto_login_button;

    @Value("${airline_tenants_email_expire_link_Pin_reset_button}")
    private String airline_tenants_email_expire_link_Pin_reset_button;

    @Value("${airline_tenants_email_expire_link_goto_login_button}")
    private String airline_tenants_email_expire_link_goto_login_button;

    @Value("${airline_tenants_reset_pwd_email_input}")
    private String airline_tenants_reset_pwd_email_input;

    @Value("${airline_tenants_reset_pwd_uname_input}")
    private String airline_tenants_reset_pwd_uname_input;

    @Value("${airline_tenants_reset_pwd_scn_input}")
    private String airline_tenants_reset_pwd_scn_input;

    @Value("${btn_login}")
    private String btn_login;

    @Value("${mam_header_logo}")
    private String mam_header_logo;

    @Value("${password_flyout_validation}")
    private String password_flyout_validation;

    @Value("${pin_error_message}")
    private String pin_error_message;

    @Value("${uname_error_message2}")
    private String uname_error_message2;

    @Value("${uname_error_message}")
    private String uname_error_message;

    @Value("${password_clear_icon}")
    private String password_clear_icon;


    @Value("${pattern_error}")
    private String pattern_error;

    @Value("${pattern_pin_error1}")
    private String pattern_pin_error1;
    @Value("${mam_enrolment_form}")
    private String mam_enrolment_form;

    @Value("${mam_enrolment_back}")
    private String mam_enrolment_back;

    @Value("${mam_profile_title_xpath}")
    private String mam_profile_title_xpath;

    @Value("${mam_partner_page}")
    private String mam_partner_page;

    @Value("${mam_profile_preffer_language}")
    private String mam_profile_preffer_language;


    @Value("${mam_profile_account_summary_scn}")
    private String mam_profile_account_summary_scn;

    @Value("${mam_profile_account_summary_preffer_no}")
    private String mam_profile_account_summary_preffer_no;

    @Value("${mam_profile_account_summary_email}")
    private String mam_profile_account_summary_email;

    @Value("${mam_profile_account_summary_profile_complete}")
    private String mam_profile_account_summary_profile_complete;

    @Value("${mam_profile_account_summary_2fa_status}")
    private String mam_profile_account_summary_2fa_status;

    @Value("${mam_non_2fa_user_active_pop_up}")
    private String mam_non_2fa_user_active_pop_up;

    @Value("${mam_non_2fa_trigger}")
    private String mam_non_2fa_trigger;

    @Value("${login_password_error_message}")
    private String login_password_error_message;

    @Value("${pattern_uname_error1}")
    private String pattern_uname_error1;

    @Value("${loginNext_xpath}")
    private String loginNext_xpath;

    @Value("${finalLogin_xpath}")
    private String final_login;


}
