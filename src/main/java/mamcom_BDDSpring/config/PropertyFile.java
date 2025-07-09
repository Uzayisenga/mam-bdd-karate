package mamcom_BDDSpring.config;

import lombok.Data;
import mamcom_BDDSpring.annotations.LazyAutowired;
import mamcom_BDDSpring.annotations.PageObjects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PageObjects
@PropertySource("classpath:application.properties")
@PropertySource("classpath:extent.properties")
@PropertySource("classpath:application-uat3.properties")
public class PropertyFile {

    public PropertyFile(){

    }

    @LazyAutowired
    mamcom_BDDSpring.dataProvider.dataProvider dataProvider;


    @Value("${chromedriverpath}")
    private String chromedriverpath;

    @Value("${firefoxdriverpath}")
    private String firefoxdriverpath;

    @Value("${macchromedriverpath}")
    private String macchromedriverpath;

    @Value("${edgedriverpath}")
    private String edgedriverpath;

    @Value("${macfirefoxdriverpath}")
    private String macfirefoxdriverpath;

    @Value("${Timeout}")
    private int Timeout;

    @Value("${PageCDNUrl}")
    private String PageCDNUrl;

    @Value("${worldShop_auth_url}")
    private String worldShop_auth_url;

    @Value("${PageCDNUrl_Pre}")
    private String PageCDNUrl_Pre;

    @Value("${PageCDNSecret_Pre}")
    private String PageCDNSecret_Pre;

    @Value("${Mam_URL_Pre}")
    private String Mam_URL_Pre;

    @Value("${Mam_Pre_acc}")
    private String Mam_Pre_acc;

    @Value("${Mam_acc_url}")
    private String Mam_acc_url;

    @Value("${PageCDNSecret}")
    private String PageCDNSecret;

    @Value("${Mamcom_URL}")
    private String Mamcom_URL;

    @Value("${invalidRouteMsg}")
    private String invalidRouteMsg;

    @Value("${invalidCompartmentMsg}")
    private String invalidCompartmentMsg;

    @Value("${invalidOperatedByMsg}")
    private String invalidOperatedByMsg;

    @Value("${enrollmentMessage}")
    private String enrollmentMessage;

    @Value("${mailActivationLink}")
    private String mailActivationLink;

    @Value("${welcomePageMessage}")
    private String welcomePageMessage;

    /*OneID*/

    @Value("${clientid_LH}")
    private String clientid_LH;

    @Value("${clientid_OS}")
    private String clientid_OS;

    @Value("${redirecturi_LH}")
    private String redirecturi_LH;

    @Value("${redirecturi_OS}")
    private String redirecturi_OS;

    @Value("${clientid_LX}")
    private String clientid_LX;

    @Value("${redirecturi_LX}")
    private String redirecturi_LX;

    @Value("${PageCDNUrl_LH}")
    private String PageCDNUrl_LH;

    @Value("${PageCDNUrl_OS}")
    private String PageCDNUrl_OS;

    @Value("${PageCDNUrl_LX}")
    private String PageCDNUrl_LX;

    @Value("${clientid_MMG}")
    private String clientid_MMG;

    @Value("${redirecturi_MMG}")
    private String redirecturi_MMG;

    @Value("${reportConfigPath}")
    private String reportConfigPath;

    @Value("${worldshop_uName}")
    private String worldshop_uName;

    @Value("${worldShop_Password}")
    private String worldShop_Password;

    @Value("${worldshop_popup_uname_path}")
    private String worldshop_popup_uname_path;

    @Value("${worldshop_popup_pwd_path}")
    private String worldshop_popup_pwd_path;

    @Value("${worldshop_popup_login_path}")
    private String worldshop_popup_login_path;

    @Value("${language_path}")
    private String language_path;

    @Value("${dropDown_path}")
    private String dropDown_path;

    @Value("${worldShop_url}")
    private String worldShop_url;

    @Value("${SCN_DefaultPIN}")
    private String SCN_DefaultPIN;

    @Value("${scn_save_pin}")
    private String scn_save_pin;

    @Value("${proxy_uid_path}")
    private String proxy_uid_path;

    @Value("${proxy_pwd_path}")
    private String proxy_pwd_path;

    @Value("${proxy_login_path}")
    private String proxy_login_path;

    @Value("${proxy_uid}")
    private String proxy_uid;

    @Value("${proxy}")
    private String proxy;

    @Value("${proxy_pwd}")
    private String proxy_pwd;

    @Value("${proxy_host_ip}")
    private String proxy_host_ip;

    @Value("${proxy_host_port}")
    private String proxy_host_port;

    @Value("${mam_update_pwd_url}")
    private String mam_update_pwd_url;

    @Value("${change_password_url}")
    private String change_password_url;

    @Value("${BaseHost}")
    public String BaseHost;

    @Value("${BaseOrigin}")
    public String BaseOrigin;

    @Value("${MamURl}")
    public String MamURl;

    @Value("${mam_preprod_url}")
    public String mam_preprod_url;

    @Value("${PageCDNUrl_SN}")
    public String PageCDNUrl_SN;

    public String getReportConfigPath() {
        return null;
    }
}
