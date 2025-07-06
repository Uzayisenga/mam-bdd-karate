package com.mamcom_BDDSpring.config;


import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PageObjects
@PropertySource("classpath:locators.properties")
public class LocatorsPropertyFile2 {

    @Value("${newsletter_xpath}")
    private String newsletter_xpath;

    @Value("${inbox}")
    private String inbox;

    @Value("${oneway_brussels}")
    private String oneway_brussels;

    @Value("${loggedin1}")
    private String loggedin1;

    @Value("${loggedin_email}")
    private String loggedin_email;

    @Value("${area_code}")
    private String area_code;

    @Value("${number_promotion}")
    private String number_promotion;

    @Value("${date_promotion}")
    private String date_promotion;

    @Value("${inbox_current}")
    private String inbox_current;

    @Value("${inbox_message}")
    private String inbox_message;

    @Value("${preferred_airport}")
    private String preferred_airport;

    @Value("${overview_inbox_message}")
    private String overview_inbox_message;

    @Value("${mileage_calculator}")
    private String mileage_calculator;

    @Value("${detailed_calculation}")
    private String detailed_calculation;

    @Value("${lhgoup_airline}")
    private String lhgoup_airline;

    @Value("${continue_mlgcalculator}")
    private String continue_mlgcalculator;

    @Value("${ticket_price}")
    private String ticket_price;

    @Value("${surcharges}")
    private String surcharges;

    @Value("${ancillary_charge}")
    private String ancillary_charge;

    @Value("${depature_airport}")
    private String depature_airport;

    @Value("${arrival_airport}")
    private String arrival_airport;

    @Value("${select_depature}")
    private String select_depature;

    @Value("${one_way}")
    private String one_way;

    @Value("${multi_city}")
    private String multi_city;

    @Value("${oneway_depature}")
    private String oneway_depature;

    @Value("${oneway_arrival}")
    private String oneway_arrival;

    @Value("${all_messages}")
    private String all_messages;

    @Value("${multicity_depature1}")
    private String multicity_depature1;

    @Value("${multicity_depature2}")
    private String multicity_depature2;

    @Value("${multicity_arrival1}")
    private String multicity_arrival1;

    @Value("${multicity_arrival2}")
    private String multicity_arrival2;

    @Value("${return_outbound}")
    private String return_outbound;

    @Value("${return_inbound}")
    private String return_inbound;

    @Value("${return_outbound_swiss}")
    private String return_outbound_swiss;

    @Value("${return_inbound_swiss}")
    private String return_inbound_swiss;

    @Value("${return_outbound_bookclass}")
    private String return_outbound_bookclass;

    @Value("${return_inbound_bookclass}")
    private String return_inbound_bookclass;

    @Value("${outbound_a_class}")
    private String outbound_a_class;

    @Value("${inbound_a_class}")
    private String inbound_a_class;

    @Value("${oneway_operatedby}")
    private String oneway_operatedby;

    @Value("${oneway_eurowings}")
    private String oneway_eurowings;

    @Value("${oneway_class}")
    private String oneway_class;

    @Value("${oneway_a_class}")
    private String oneway_a_class;

    @Value("${multi_operated_1}")
    private String multi_operated_1;

    @Value("${multi_operated_2}")
    private String multi_operated_2;

    @Value("${multi_airline1}")
    private String multi_airline1;

    @Value("${multi_airline2}")
    private String multi_airline2;

    @Value("${multi_class1}")
    private String multi_class1;

    @Value("${multi_class2}")
    private String multi_class2;

    @Value("${multi_p_class1}")
    private String multi_p_class1;

    @Value("${multi_p_class2}")
    private String multi_p_class2;

    @Value("${mileagecalculator_result}")
    private String mileagecalculator_result;

    @Value("${award_miles}")
    private String award_miles;

    @Value("${status_miles}")
    private String status_miles;

    @Value("${ticketprice_mileage}")
    private String ticketprice_mileage;

    @Value("${quick_calculation}")
    private String quick_calculation;

    @Value("${easymode_oneway}")
    private String easymode_oneway;

    @Value("${easymode_depature}")
    private String easymode_depature;

    @Value("${easymode_arrival}")
    private String easymode_arrival;

    @Value("${easymode_premiumeconomy}")
    private String easymode_premiumeconomy;

    @Value("${easymode_firstclass}")
    private String easymode_firstclass;

    @Value("${operated_by}")
    private String operated_by;

    @Value("${swiss_airlines}")
    private String swiss_airlines;

    @Value("${award_miles_easy}")
    private String award_miles_easy;

    @Value("${status_miles_easy}")
    private String status_miles_easy;

    @Value("${easymode_businessclass}")
    private String easymode_businessclass;

    @Value("${brussels_airlines}")
    private String brussels_airlines;

    @Value("${donation_amount}")
    private String donation_amount;

    @Value("${donation_agree_checkbox}")
    private String donation_agree_checkbox;

    @Value("${donate_now}")
    private String donate_now;

    @Value("${your_donation_amount}")
    private String your_donation_amount;

    @Value("${donation_confirmation_message}")
    private String donation_confirmation_message;

    @Value("${cookie_setting}")
    private String cookie_setting;

    @Value("${accept_neccesary}")
    private String accept_neccesary;

    @Value("${cookie_personalize}")
    private String cookie_personalize;

    @Value("${personalization_toggle}")
    private String personalization_toggle;

    @Value("${marketing_toggle}")
    private String marketing_toggle;

    @Value("${allow_all_cookie}")
    private String allow_all_cookie;

    @Value("${confirm_selection_cookie}")
    private String confirm_selection_cookie;

    @Value("${digital_service_card}")
    private String digital_service_card;

    @Value("${download_service_card}")
    private String download_service_card;

    @Value("${copy_service_card}")
    private String copy_service_card;

    @Value("${copy_scn_tooltip}")
    private String copy_scn_tooltip;

    @Value("${message_delete}")
    private String message_delete;

    @Value("${delete_message_confirm}")
    private String delete_message_confirm;

    @Value("${read_message}")
    private String read_message;

    @Value("${archive_tab}")
    private String archive_tab;

    @Value("${read_message_archive}")
    private String read_message_archive;

    @Value("${bankdetail_edit}")
    private String bankdetail_edit;

    @Value("${bankdetails_add_button}")
    private String bankdetails_add_button;

    @Value("${iban_text_field}")
    private String iban_text_field;

    @Value("${bankupdate_savechanges}")
    private String bankupdate_savechanges;

    @Value("${iban_error_msg}")
    private String iban_error_msg;

    @Value("${iban_country_error_msg}")
    private String iban_country_error_msg;

    @Value("${bank_detail}")
    private String bank_detail;

    @Value("${bank_number1}")
    private String bank_number1;

    @Value("${bankdetail_bin}")
    private String bankdetail_bin;

    @Value("${add_bank_details_after_adding1}")
    private String add_bank_details_after_adding1;

    @Value("${bank_details_all}")
    private String bank_details_all;

    @Value("${bankdetails_close}")
    private String bankdetails_close;

    @Value("${thanksforregister_promotionform}")
    private String thanksforregister_promotionform;

    @Value("${mileage_account}")
    private String mileage_account;

    @Value("${accountbalence_awardmiles}")
    private String accountbalence_awardmiles;

    @Value("${accountbalence_points}")
    private String accountbalence_points;

    @Value("${accountbalence_qualifyingpoints}")
    private String accountbalence_qualifyingpoints;

    @Value("${accountbalence_honcirclepoints}")
    private String accountbalence_honcirclepoints;

    @Value("${mileagepooling_scroll_right}")
    private String mileagepooling_scroll_right;

    @Value("${accountbalence_milesinpool}")
    private String accountbalence_milesinpool;

    @Value("${profile_transactionwidget}")
    private String profile_transactionwidget;

    @Value("${profile_widget_currentactivities}")
    private String profile_widget_currentactivities;

    @Value("${mileageaccount_profile_widget}")
    private String mileageaccount_profile_widget;

    @Value("${mileagepooling_success_msg}")
    private String mileagepooling_success_msg;

    @Value("${flight_search_page}")
    private String flight_search_page;

    @Value("${twofa_submit_button}")
    private String twofa_submit_button;

    @Value("${password_for_username}")
    private String password_for_username;

    @Value("${login_for_username}")
    private String login_for_username;

    @Value("${status_star_eventbox_desc}")
    private String status_star_eventbox_desc;

    @Value("${lifetime_info_comp}")
    private String lifetime_info_comp;

    @Value("${freq_traveller_lifetime}")
    private String freq_traveller_lifetime;

    @Value("${qualifying_points}")
    private String qualifying_points;

    @Value("${threshold_points}")
    private String threshold_points;

    @Value("${ftl_badge}")
    private String ftl_badge;

    @Value("${mileage_exchange_reedemnow}")
    private String mileage_exchange_reedemnow;

    @Value("${how_mileage_exchange_works}")
    private String how_mileage_exchange_works;

    @Value("${how_mileage_exchange_works_ok_button}")
    private String how_mileage_exchange_works_ok_button;

    @Value("${exchange_miles}")
    private String exchange_miles;

    @Value("${redeem_benefits_yes}")
    private String redeem_benefits_yes;

    @Value("${miles_exchanged}")
    private String miles_exchanged;

    @Value("${not_enough_miles_available}")
    private String not_enough_miles_available;

    @Value("${attain_next_benefit}")
    private String attain_next_benefit;

    @Value("${extra_benefits}")
    private String extra_benefits;

    @Value("${extra_benefit_voucher}")
    private String extra_benefit_voucher;

    @Value("${voucher_reedem_now}")
    private String voucher_reedem_now;

    @Value("${call_us_voucher}")
    private String call_us_voucher;

    @Value("${miles_expiry}")
    private String miles_expiry;

    @Value("${miles_protect}")
    private String miles_protect;

    @Value("${language_german}")
    private String language_german;

    @Value("${language_Chinese}")
    private String language_Chinese;

    @Value("${language_Dutch}")
    private String language_Dutch;

    @Value("${language_French}")
    private String language_French;

    @Value("${language_Italian}")
    private String language_Italian;

    @Value("${language_Japanese}")
    private String language_Japanese;

    @Value("${language_Polish}")
    private String language_Polish;

    @Value("${language_Russian}")
    private String language_Russian;

    @Value("${language_Spanish}")
    private String language_Spanish;

    @Value("${language_back_button}")
    private String language_back_button;

    @Value("${retro_notification}")
    private String retro_notification;

    @Value("${show_more_retro}")
    private String show_more_retro;

    @Value("${show_less_retro}")
    private String show_less_retro;

    @Value("${statusmanage_exchangemiles}")
    private String statusmanage_exchangemiles;

    @Value("${ready_to_exchange_miles_yes_button}")
    private String ready_to_exchange_miles_yes_button;

    @Value("${FTL_VIP}")
    private String FTL_VIP;

    @Value("${status_all_members}")
    private String status_all_members;

    @Value("${qualifying_points_earned}")
    private String qualifying_points_earned;

    @Value("${automatically_reedemed}")
    private String automatically_reedemed;

    @Value("${qualifying_points_balence}")
    private String qualifying_points_balence;


    @Value("${noAPIResults}")
    private String noAPIResults;

    @Value("${filterIcon}")
    private String filterIcon;

    @Value("${applyButton}")
    private String applyButton;

    @Value("${transactionsNoResults}")
    private String transactionsNoResults;

    @Value("${ancillaries}")
    private String ancillaries;

    @Value("${mileage_calculator_easy_mode}")
    private String mileage_calculator_easy_mode;

    @Value("${start_mileagecalculation_btn}")
    private String start_mileagecalculation_btn;

    @Value("${ml_points}")
    private String ml_points;

    @Value("${ml_qualifying_points}")
    private String ml_qualifying_points;

    @Value("${ml_miles_pool}")
    private String ml_miles_pool;

    @Value("${ml_scn}")
    private String ml_scn;

    @Value("${ml_scn_value}")
    private String ml_scn_value;

    @Value("${ml_miles}")
    private String ml_miles;

    @Value("${ml_hon_circle_points}")
    private String ml_hon_circle_points;

    @Value("${mc_miles}")
    private String mc_miles;

    @Value("${mc_points}")
    private String mc_points;

    @Value("${mc_qualifying_points}")
    private String mc_qualifying_points;

    @Value("${mc_miles_value}")
    private String mc_miles_value;

    @Value("${mc_points_value}")
    private String mc_points_value;

    @Value("${mc_qualifying_points_value}")
    private String mc_qualifying_points_value;

    @Value("${mc_disclaimerText}")
    private String mc_disclaimerText;
    @Value("${myoverview_points_value}")
    private String myoverview_points_value;

    @Value("${myoverview_qualpoints_value}")
    private String myoverview_qualpoints_value;

    @Value("${accountbalence_honcirclepoints_value}")
    private String accountbalence_honcirclepoints_value;

    @Value("${tenant_popup_close}")
    private String tenant_popup_close;

    @Value("${flight_award_form_new}")
    private String flight_award_form_new;

    @Value("${fs_waymode_new}")
    private String fs_waymode_new;

    @Value("${fs_class_new}")
    private String fs_class_new;

    @Value("${fs_oneway_new}")
    private String fs_oneway_new;

    @Value("${fs_openjaw_new}")
    private String fs_openjaw_new;

    @Value("${fs_premium_economy_new}")
    private String fs_premium_economy_new;

    @Value("${fs_business_new}")
    private String fs_business_new;

    @Value("${fs_passenger_new}")
    private String fs_passenger_new;

    @Value("${fs_adults_increment_new}")
    private String fs_adults_increment_new;

    @Value("${fs_children_increment_new}")
    private String fs_children_increment_new;

    @Value("${fs_infant_increment_new}")
    private String fs_infant_increment_new;

    @Value("${fs_bookingforothers_new}")
    private String fs_bookingforothers_new;

    @Value("${fs_passenger_select}")
    private String fs_passenger_select;

    @Value("${fs_depature_new}")
    private String fs_depature_new;

    @Value("${fs_arrival_new}")
    private String fs_arrival_new;

    @Value("${travel_dates_new}")
    private String travel_dates_new;

    @Value("${fs_searchflights_new}")
    private String fs_searchflights_new;

    @Value("${depature_errormsg_new}")
    private String depature_errormsg_new;

    @Value("${arrival_errormsg_new}")
    private String arrival_errormsg_new;

    @Value("${adjustment_correction}")
    private String adjustment_correction;

    @Value("${mfa_setup}")
    private String mfa_setup;

    @Value("${mfa_secret_key}")
    private String mfa_secret_key;

    @Value("${mfa_gotostep3}")
    private String mfa_gotostep3;

    @Value("${mfa_verification_code}")
    private String mfa_verification_code;

    @Value("${mfa_submit}")
    private String mfa_submit;

    @Value("${mfa_verification_code_field}")
    private String mfa_verification_code_field;

    @Value("${mfa_login_submit}")
    private String mfa_login_submit;

    @Value("${fs_openjaw_depature_new}")
    private String fs_openjaw_depature_new;

    @Value("${fs_openjaw_arrival_new}")
    private String fs_openjaw_arrival_new;

    @Value("${fs_datepicker1_new}")
    private String fs_datepicker1_new;

    @Value("${fs_datepicker2_new}")
    private String fs_datepicker2_new;


    @Value("${mc_show_details}")
    private String mc_show_details;

    @Value("${mc_status_dialogue_box1}")
    private String mc_status_dialogue_box1;

    @Value("${mc_status_dialogue_box2}")
    private String mc_status_dialogue_box2;

    @Value("${mc_status_dialogue_box3}")
    private String mc_status_dialogue_box3;

    @Value("${mc_status_dialogue_box4}")
    private String mc_status_dialogue_box4;

    @Value("${mc_currency_dropdown}")
    private String mc_currency_dropdown;

    @Value("${mc_currency_dropdown_value}")
    private String mc_currency_dropdown_value;

    @Value("${mc_currency_value}")
    private String mc_currency_value;

    @Value("${mam_change_pin}")
    private String mam_change_pin;

    @Value("${mam_change_pin_save}")
    private String mam_change_pin_save;

    @Value("${tenant_login_after_pin}")
    private String tenant_login_after_pin;

    @Value("${ocp_activeoneclick}")
    private String ocp_activeoneclick;

    @Value("${ocp_thanku}")
    private String ocp_thanku;

    @Value("${ocp_inactiveOnceClick}")
    private String ocp_inactiveOnceClick;

    @Value("${promotionform_multiple_reg}")
    private String promotionform_multiple_reg;

    @Value("${airline_forgot_travelId_link_uat3}")
    private String airline_forgot_travelId_link_uat3;

    @Value("${interestsurvey_login}")
    private String interestsurvey_login;

    @Value("${loginNext_xpath}")
    private String loginNext_xpath;

    @Value("${loginNext_xpath_uat3}")
    private String loginNext_xpath_uat3;

    @Value("${cookie_path}")
    private String cookie_path;

    @Value("${select_interest}")
    private String select_interest;

    @Value("${firstareaof_interest}")
    private String firstareaof_interest;

    @Value("${secondareaof_interest}")
    private String secondareaof_interest;

    @Value("${thirdareaof_interest}")
    private String thirdareaof_interest;

    @Value("${fourthareaof_interest}")
    private String fourthareaof_interest;

    @Value("${fifthareaof_interest}")
    private String fifthareaof_interest;

    @Value("${sixthareaof_interest}")
    private String sixthareaof_interest;

    @Value("${seventhareaof_interest}")
    private String seventhareaof_interest;

    @Value("${eighthareaof_interest}")
    private String eighthareaof_interest;

    @Value("${interestsurvey_submitbutton}")
    private String interestsurvey_submitbutton;

    @Value("${interestsurvey_earnmiles}")
    private String interestsurvey_earnmiles;

    @Value("${mileage_exchange_close}")
    private String mileage_exchange_close;

    @Value("${miles_value}")
    private String miles_value;

    @Value("${promotionform_usagetime_option1}")
    private String promotionform_usagetime_option1;

    @Value("${mm_logo}")
    private String mm_logo;

    @Value("${country_footer}")
    private String country_footer;

    @Value("${country_save_changes}")
    private String country_save_changes;

    @Value("${airline_link}")
    private String airline_link;

    @Value("${donatemiles_myclimate}")
    private String donatemiles_myclimate;

    @Value("${donationamount_dropdown}")
    private String donationamount_dropdown;

    @Value("${donationamount_3000}")
    private String donationamount_3000;

    @Value("${cadoozpage_acceptcookie}")
    private String cadoozpage_acceptcookie;

    @Value("${promotionform_audiondemand}")
    private String promotionform_audiondemand;

    @Value("${promotionform_description}")
    private String promotionform_description;

    @Value("${promotionform_personal_info}")
    private String promotionform_personal_info;

    @Value("${promoform_tooltip_text}")
    private String promoform_tooltip_text;

    @Value("${promoform_dob_tooltip}")
    private String promoform_dob_tooltip;

    @Value("${cookie_header}")
    private String cookie_header;

    @Value("${cookie_para}")
    private String cookie_para;

    @Value("${cookie_popup}")
    private String cookie_popup;

    @Value("${hcp_search_carSearch_Heading}")
    private String hcp_search_carSearch_Heading;

    @Value("${hcp_search_carSearch_subHeading}")
    private String hcp_search_carSearch_subHeading;

    @Value("${hcp_search_carSearch_allCarsLink_icon}")
    private String hcp_search_carSearch_allCarsLink_icon;

    @Value("${hcp_search_carSearch_pickup_label}")
    private String hcp_search_carSearch_pickup_label;

    @Value("${hcp_search_carSearch_dropoff_label}")
    private String hcp_search_carSearch_dropoff_label;

    @Value("${hcp_search_carSearch_rent_pickup_heading}")
    private String hcp_search_carSearch_rent_pickup_heading;

    @Value("${hcp_search_carSearch_rent_pickup_dateLabel}")
    private String hcp_search_carSearch_rent_pickup_dateLabel;

    @Value("${hcp_search_carSearch_rent_pickup_calender_icon}")
    private String hcp_search_carSearch_rent_pickup_calender_icon;

    @Value("${hcp_past_rental_date}")
    private String hcp_past_rental_date;

    @Value("${pickup_time_select}")
    private String pickup_time_select;
    @Value("${hcp_search_carSearch_rent_pickupTime_dropdown}")
    private String hcp_search_carSearch_rent_pickupTime_dropdown;

    @Value("${hcp_search_carSearch_return_heading}")
    private String hcp_search_carSearch_return_heading;

    @Value("${hcp_search_carSearch_rent_dropTime_dropdown}")
    private String hcp_search_carSearch_rent_dropTime_dropdown;

    @Value("${hcp_driverAge_heading}")
    private String hcp_driverAge_heading;

    @Value("${hcp_driverAge_label}")
    private String hcp_driverAge_label;

    @Value("${hcp_driverAge_infoIcon}")
    private String hcp_driverAge_infoIcon;

    @Value("${hcp_driverAge_infoText}")
    private String hcp_driverAge_infoText;

    @Value("${hcp_driverAge_input}")
    private String hcp_driverAge_input;

    @Value("${hcp_search_carSearch_submitButton}")
    private String hcp_search_carSearch_submitButton;

    @Value("${hcp_search_hotelSearch_heading}")
    private String hcp_search_hotelSearch_heading;

    @Value("${hcp_serach_hotelSearch_subHeading}")
    private String hcp_serach_hotelSearch_subHeading;

    @Value("${hcp_search_hotelSearch_toWebsite_link}")
    private String hcp_search_hotelSearch_toWebsite_link;

    @Value("${hcp_search_hotelSearch_location_label}")
    private String hcp_search_hotelSearch_location_label;

    @Value("${hcp_search_hotelSearch_stay_heading}")
    private String hcp_search_hotelSearch_stay_heading;

    @Value("${hcp_search_hotelSearch_stay_checkinLabel}")
    private String hcp_search_hotelSearch_stay_checkinLabel;

    @Value("${hcp_search_hotelSearch_stay_checkinDate}")
    private String hcp_search_hotelSearch_stay_checkinDate;

    @Value("${hcp_search_hotelSearch_past_date_validation}")
    private String hcp_search_hotelSearch_past_date_validation;

    @Value("${hcp_search_hotelSearch_stay_checkoutLabel}")
    private String hcp_search_hotelSearch_stay_checkoutLabel;

    @Value("${hcp_search_hotelSearch_stay_checkoutDate}")
    private String hcp_search_hotelSearch_stay_checkoutDate;

    @Value("${hcp_search_hotelSearch_stay_adultSection_heading}")
    private String hcp_search_hotelSearch_stay_adultSection_heading;

    @Value("${hcp_search_hotelSearch_stay_adultLabel}")
    private String hcp_search_hotelSearch_stay_adultLabel;

    @Value("${hcp_search_hotelSearch_stay_adultSection_value}")
    private String hcp_search_hotelSearch_stay_adultSection_value;

    @Value("${hcp_search_hotelSearch_stay_adultSection_decrementor}")
    private String hcp_search_hotelSearch_stay_adultSection_decrementor;

    @Value("${hcp_search_hotelSearch_stay_adultSection_incrementor}")
    private String hcp_search_hotelSearch_stay_adultSection_incrementor;

    @Value("${hcp_search_hotelSearch_stay_childSection_heading}")
    private String hcp_search_hotelSearch_stay_childSection_heading;

    @Value("${hcp_search_hotelSearch_stay_childSection_decrementor}")
    private String hcp_search_hotelSearch_stay_childSection_decrementor;

    @Value("${hcp_search_hotelSearch_stay_childSection_incrementor}")
    private String hcp_search_hotelSearch_stay_childSection_incrementor;

    @Value("${hcp_search_hotelSearch_stay_ageChild1}")
    private String hcp_search_hotelSearch_stay_ageChild1;

    @Value("${hcp_search_hotelSearch_stay_ageChild2}")
    private String hcp_search_hotelSearch_stay_ageChild2;

    @Value("${hcp_search_hotelSearch_stay_ageChild3}")
    private String hcp_search_hotelSearch_stay_ageChild3;

    @Value("${hcp_search_hotelSearch_stay_ageChild1_dropdown}")
    private String hcp_search_hotelSearch_stay_ageChild1_dropdown;

    @Value("${hcp_search_hotelSearch_stay_ageChild2_dropdown}")
    private String hcp_search_hotelSearch_stay_ageChild2_dropdown;

    @Value("${hcp_search_hotelSearch_stay_ageChild3_dropdown}")
    private String hcp_search_hotelSearch_stay_ageChild3_dropdown;

    @Value("${promoform_street_tooltip}")
    private String promoform_street_tooltip;

    @Value("${promoform_postcode_tooltip}")
    private String promoform_postcode_tooltip;

    @Value("${promoform_city_tooltip}")
    private String promoform_city_tooltip;

    @Value("${promoform_country_tooltip}")
    private String promoform_country_tooltip;

    @Value("${promoform_email_tooltip}")
    private String promoform_email_tooltip;

    @Value("${promoform_mobile_tooltip}")
    private String promoform_mobile_tooltip;

    @Value("${promoform_upload_error}")
    private String promoform_upload_error;

    @Value("${promoform_remove_attachment}")
    private String promoform_remove_attachment;

    @Value("${partner_carousel}")
    private String partner_carousel;

    @Value("${partnerpage_allcards}")
    private String partnerpage_allcards;

    @Value("${partner_hotelde}")
    private String partner_hotelde;

    @Value("${partner_hotelde_desc}")
    private String partner_hotelde_desc;

    @Value("${partner_hotelde_benefits}")
    private String partner_hotelde_benefits;

    @Value("${countrylang_switch_selectn}")
    private String countrylang_switch_selectn;

    @Value("${country_usa_radiobutton}")
    private String country_usa_radiobutton;


    @Value("${pf_lufthansa}")
    private String pf_lufthansa;

    @Value("${pf_eurowings}")
    private String pf_eurowings;

    @Value("${pf_carousel_slide}")
    private String pf_carousel_slide;

    @Value("${pf_brussels}")
    private String pf_brussels;

    @Value("${pf_discover}")
    private String pf_discover;

    @Value("${pf_LH_desc}")
    private String pf_LH_desc;

    @Value("${pf_carousel_reverse_slide}")
    private String pf_carousel_reverse_slide;


    @Value("${search_button_homepage}")
    private String search_button_homepage;

    @Value("${searchbox_heading}")
    private String searchbox_heading;

    @Value("${searchbox_close}")
    private String searchbox_close;

    @Value("${searchbox_input}")
    private String searchbox_input;

    @Value("${search_button}")
    private String search_button;

    @Value("${searchresults}")
    private String searchresults;

    @Value("${searchresult_showmore}")
    private String searchresult_showmore;

    @Value("${searchresult_showless}")
    private String searchresult_showless;

    @Value("${searchresult_password_change}")
    private String searchresult_password_change;

    @Value("${united_offer}")
    private String united_offer;

    @Value("${searchresult_noresult}")
    private String searchresult_noresult;

    @Value("${printpage_icon}")
    private String printpage_icon;

    @Value("${youtube_icon}")
    private String youtube_icon;

    @Value("${linkedin_icon}")
    private String linkedin_icon;

    @Value("${searchresult_list}")
    private String searchresult_list;

    @Value("${searchresult_list_heading}")
    private String searchresult_list_heading;

    @Value("${eurowings_offer}")
    private String eurowings_offer;

    @Value("${brussels_logo}")
    private String brussels_logo;

    @Value("${contact_selectreason}")
    private String contact_selectreason;

    @Value("${faq_result_help}")
    private String faq_result_help;

    @Value("${faq_expand_content}")
    private String faq_expand_content;

    @Value("${contact_by_telephone}")
    private String contact_by_telephone;

    @Value("${passenger_receipt}")
    private String passenger_receipt;

    @Value("${personal_info_content}")
    private String personal_info_content;

    @Value("${personal_info_heading}")
    private String personal_info_heading;

    @Value("${personal_info_sections}")
    private String personal_info_sections;

    @Value("${personal_info_telephone}")
    private String personal_info_telephone;

    @Value("${access_data}")
    private String access_data;

    @Value("${access_data_section}")
    private String access_data_section;

    @Value("${offers_communication_section}")
    private String offers_communication_section;

    @Value("${offers_communication}")
    private String offers_communication;

    @Value("${offers_communication_edit}")
    private String offers_communication_edit;

    @Value("${access_data_edit}")
    private String access_data_edit;

    @Value("${travel_preference_section}")
    private String travel_preference_section;

    @Value("${travel_pref_depature}")
    private String travel_pref_depature;

    @Value("${travel_pref_automated_checkin}")
    private String travel_pref_automated_checkin;


    @Value("${hcp_closeIcon}")
    private String hcp_closeIcon;

    @Value("${pf_air_astana}")
    private String pf_air_astana;

    @Value("${pf_back_to_partner_overview}")
    private String pf_back_to_partner_overview;

    @Value("${pf_althoff}")
    private String pf_althoff;


    @Value("${hc_country_code}")
    private String hc_country_code;

    @Value("${hc_area_code}")
    private String hc_area_code;

    @Value("${hc_telephone_number}")
    private String hc_telephone_number;

    @Value("${hc_form_txtbx_firstname}")
    private String hc_form_txtbx_firstname;

    @Value("${hc_surname}")
    private String hc_surname;

    @Value("${hc_servicecardnumber}")
    private String hc_servicecardnumber;

    @Value("${hc_emailaddress_form}")
    private String hc_emailaddress_form;

    @Value("${hc_areacode_errormsg}")
    private String hc_areacode_errormsg;

    @Value("${hc_thankyou}")
    private String hc_thankyou;

    @Value("${hc_request_id}")
    private String hc_request_id;

    @Value("${profile_email_errormsg}")
    private String profile_email_errormsg;

    @Value("${language_mix}")
    private String language_mix;

    @Value("${partner_carousle}")
    private String partner_carousle;

    @Value("${magazine_homepage}")
    private String magazine_homepage;

    @Value("${news_magazinepage}")
    private String news_magazinepage;

    @Value("${news_filter}")
    private String news_filter;

    @Value("${newsfilter_press_option}")
    private String newsfilter_press_option;

    @Value("${newfilter_apply_button}")
    private String newfilter_apply_button;

    @Value("${newsfilter_resetfilter}")
    private String newsfilter_resetfilter;

    @Value("${news_wrapper}")
    private String news_wrapper;

    @Value("${news_filter_oneselected}")
    private String news_filter_oneselected;

    @Value("${news_showmore}")
    private String news_showmore;

    @Value("${userselectconsent}")
    private String userselectconsent;

    @Value("${ancillary_recalculation}")
    private String ancillary_recalculation;

    @Value("${ancillary_recalculation_miles}")
    private String ancillary_recalculation_miles;

    @Value("${ancillary_cancellation}")
    private String ancillary_cancellation;

    @Value("${ancillary_calcellation_miles}")
    private String ancillary_calcellation_miles;

    @Value("${hc_newlastname}")
    private String hc_newlastname;

    @Value("${hc_custno}")
    private String hc_custno;

    @Value("${hc_birthday}")
    private String hc_birthday;

    @Value("${hc_birthmonth}")
    private String hc_birthmonth;

    @Value("${hc_birthyear}")
    private String hc_birthyear;

    @Value("${hc_postofficebox}")
    private String hc_postofficebox;

    @Value("${hc_zipcode}")
    private String hc_zipcode;

    @Value("${hc_city}")
    private String hc_city;

    @Value("${hc_time_icon}")
    private String hc_time_icon;

    @Value("${worldshop_trigger}")
    private String worldshop_trigger;

    @Value("${worldshop_trigger_searchbutton}")
    private String worldshop_trigger_searchbutton;

    @Value("${mc_easy_fields}")
    private String mc_easy_fields;

    @Value("${mc_expert_fields}")
    private String mc_expert_fields;

    @Value("${miles_exchanged_close}")
    private String miles_exchanged_close;

    @Value("${ftlben_reedemnow}")
    private String ftlben_reedemnow;

    @Value("${fs_arrival_new_uat1}")
    private String fs_arrival_new_uat1;

    @Value("${fs_depature_new_uat1}")
    private String fs_depature_new_uat1;
}
