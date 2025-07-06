package com.mamcom_BDDSpring.mamcom_Pages;


import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.mamcom_BDDSpring.annotations.BeanScope;
import com.mamcom_BDDSpring.annotations.LazyAutowired;
import com.mamcom_BDDSpring.annotations.PageObjects;
import com.mamcom_BDDSpring.config.*;
import com.mamcom_BDDSpring.dataProvider.cucumberdataTable;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;
import org.springframework.context.ApplicationContext;

import jakarta.annotation.PostConstruct;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

//import org.sikuli.script.Screen;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


@PageObjects
//@SpringBootTest
public class Base_Page {

    private static JsonStringEncoder FileReaderManager;
    //private WebDriver driver;
    private WebDriverWait wait;

    @LazyAutowired
    private WebDriver driver;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @LazyAutowired
    private WebDriverWait webDriverWait;

    @LazyAutowired
    private driverConfig config;

    @LazyAutowired
    private JavascriptExecutor js;

    @LazyAutowired
    private PropertyFile propertyFile;

    @LazyAutowired
    private LocatorsPropertyFile locatorspropertyFile;

    @LazyAutowired
    private LocatorsPropertyFile2 locatorsPropertyFile2;

    @LazyAutowired
    private LocatorsPropertyFile3 locatorsPropertyFile3;

    @LazyAutowired
    private cucumberdataTable cucumberdataTable;

    @LazyAutowired
    private driverConfig driverconfig;
    private WebElement element;


    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void keepgermany_launch() {
        String url = driver.getCurrentUrl();
        if (url.contains("lufthansa") || url.contains("austrian") || url.contains("brussels") || url.contains("swiss") || url.contains("15below")) {
            System.out.println("Country popup not required");
        } else {
            try {
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsPropertyFile3.getKeep_germany_launch())));
                driver.findElement(By.xpath(locatorsPropertyFile3.getKeep_germany_launch())).click();
            } catch (Exception e) {
                System.out.println("Pop-up not found");
            }
        }
    }

    public void load_page(String url) {
        deleteAllCookiesbutCDN();
        driver.get(url);
        System.out.println("open url: " + url);
        keepgermany_launch();
    }

    public Base_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // or your desired timeout
    }
    public void load_pageTenent(String url) {

        if (!driver.getCurrentUrl().contains(url)) {
            deleteAllCookiesbutCDN();
            driver.get(url);
        }
    }

    public String get_URL(String url) {
        return driver.getCurrentUrl();
    }

    public void openNewTab() {
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void airlineCookieSelection() {
        try {
            driver.findElement(By.xpath("//button[@id='cm-acceptAll' and @tabindex='0']")).click();
            System.out.println("clicked on Agree button");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("clicked on Agree button");
        }


    }

    public void openNewTab2() {
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    public void openNewTab3() {
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(3));
    }

    public void openNewTab4() {
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(4));
    }

    public void openNewTab5() {
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(5));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void enter_text(WebElement element, String text) {
        scroll_to_element(element);
        element.clear();
        element.sendKeys(text);
    }
    public void enter_text_slowly(WebElement element, String text) {
        scroll_to_element(element);
        element.clear();
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            waitfor(300);
        }

    }

    public void enter_text_tab(WebElement element, String text) {
        scroll_to_element(element);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.TAB);
    }

    public void selectFromDropDownUsingText(String locator, String valueToSelect) throws InterruptedException {
        Select time = new Select(driver.findElement(By.xpath(locator)));
        time.selectByValue(valueToSelect);
    }

    public void selectFromDropDownUsingValue(String locator, int valueToSelect) {
        Select time = new Select(driver.findElement(By.xpath(locator)));
        time.selectByIndex(valueToSelect);
    }

    public void JsEnter_text(WebElement element, String text) {
        scroll_to_element(element);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(id').value=" + text + ";");
    }

    public void JavaScriptclick(WebElement element) throws InterruptedException, IOException {
        this.element = element;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }


    public void sessionClear() throws InterruptedException {
        try {
            System.out.println("COOKIES -" + driver.manage().getCookies());
            driver.manage().deleteCookieNamed("s_vi");
            Thread.sleep(500);
            deleteAllCookiesbutCDN();
            Thread.sleep(500);
            deleteAllCookiesbutCDN();
            System.out.println("Session Cleared");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void proxyHandle() throws AWTException {

        try {
            String UserID = propertyFile.getProxy_uid();
            System.setProperty("java.awt.headless", "false");
            Robot robot = new Robot();
            StringSelection stringSelection1 = new StringSelection(UserID);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection1, stringSelection1);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(500);
            System.out.println("user enters proxy user id");


            // changed to 2k for firefox

            String Pswd = propertyFile.getProxy_pwd();
            StringSelection stringSelection2 = new StringSelection(Pswd);
            Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard2.setContents(stringSelection2, stringSelection2);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            System.out.println("user enters proxy user pwd");
            robot.keyPress(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void worldShopProxyHandle() throws AWTException {

        try {
            String UserID = propertyFile.getWorldshop_uName();
            System.setProperty("java.awt.headless", "false");
            Robot robot = new Robot();
            StringSelection stringSelection1 = new StringSelection(UserID);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection1, stringSelection1);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(500);
            System.out.println("user enters proxy user id");


            // changed to 2k for firefox

            String Pswd = propertyFile.getWorldShop_Password();
            StringSelection stringSelection2 = new StringSelection(Pswd);
            Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard2.setContents(stringSelection2, stringSelection2);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            System.out.println("user enters proxy user pwd");
            robot.keyPress(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void click(WebElement element) {
        scroll(element);
        scroll_to_element(element);
        js.executeScript("arguments[0].click();", element);
    }

    public void click_button(WebElement element) {
//        scroll(element);
        scroll_to_element(element);
        element.click();
    }
    @BeanScope
    public WebDriverWait driverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(propertyFile.getTimeout()));
    }
    public void switchTab(int i) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(i));
    }

    public void waitfor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void closeTab(int i) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(i));
        Thread.sleep(1000);
    }

    public void browserTabClose() throws InterruptedException {
        int i;

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        for (i = 0; i < tabs.size(); i++) {
            System.out.println("Size" + tabs.size());

            driver.switchTo().window(tabs.get(i));
            Thread.sleep(1000);
        }
    }

    public boolean elementExists(String elementname) throws InterruptedException {
        if (driver.findElements(By.xpath(elementname)).size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible(String elementname) {


        if (driver.findElement(By.xpath(elementname)).isDisplayed()) {
            return true;
        }
        return false;
    }

    public String getAtrribValue(String locator, String attribName) throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).isDisplayed();
        String text = driver.findElement(By.xpath(locator)).getAttribute(attribName);
        return text;
    }


    public Map<String, String> parseCurrentURL() {
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String[] params = url.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            System.out.println(name + "=" + value);
            map.put(name, value);
        }
        return map;

    }

    public void radioButtonverify(String elementname) {
        driver.findElement(By.xpath(String.valueOf(elementname))).isSelected();
    }

    public boolean checkBoxvalidation(String elementname) {
        driver.findElement(By.xpath(String.valueOf(elementname))).isSelected();
        return true;
    }

    public boolean checkBoxverify(String elementname) {
        driver.findElement(By.xpath(String.valueOf(elementname))).isSelected();
        return true;
    }

    public WebElement returnElement_id(String elementname) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementname)));
    }

    public WebElement returnElement_name(String elementname) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name(elementname)));
    }

    public WebElement returnElement_css(String elementname) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementname)));
    }

    public WebElement returnElement_tag(String elementname) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(elementname)));
    }

    public WebElement returnElement(String elementname) {
        return driver.findElement(By.xpath(elementname));
    }

    public WebElement returnElement_class(String elementname) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className(elementname)));
    }

    public WebElement returnElement_xpath(String elementname) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementname)));
//        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementname)));
    }

    public WebElement return_xpath(String elementname) {
        return driver.findElement(By.xpath(elementname));
    }

    public WebElement returnVisible_xpath(String elementname) {
//        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementname)));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementname)));
    }

    public boolean verifyText(String elementname) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementname)));
        return true;
    }

    public boolean verifyElement(String elementname) {
        driver.findElement(By.xpath(elementname));
        return true;
    }

    public void noOfElements(String elementname) {
        List<WebElement> elements = driver.findElements(By.xpath(elementname));
        for (WebElement e : elements) {
            System.out.println(e.getText() + " Button is available");
        }
    }

    public String get_text(WebElement element) {
//        wait_until_element_clickable(element);
        scroll_to_element(element);
        return element.getText();
    }

    public String get_Title(WebElement element) {
        wait_until_element_clickable(element);
        scroll_to_element(element);
        return element.getAttribute("title");
    }

    public void switchTab0() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(0));
    }

    public void switchToAuthPopUP() throws InterruptedException, FindFailed {
        try {
            ImagePath.add(System.getProperty("user.dir"));
            System.setProperty("java.awt.headless", "false");
            Thread.sleep(2000);
            Screen screen = new Screen();
            Thread.sleep(2000);
            screen.type(propertyFile.getProxy_login_path(), propertyFile.getWorldshop_uName());
            Thread.sleep(1000);
            screen.type(propertyFile.getWorldshop_popup_pwd_path(), propertyFile.getWorldShop_Password());
            screen.click(propertyFile.getWorldshop_popup_login_path());
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void mouseActionClick(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void mouseClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void mouseActionMove(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
//        actions.moveToElement(element);
        actions.moveToElement(element,0,0).perform();
    }

    public void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void clicksTab() {
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
    }

    public void clear() {
        driver.switchTo().activeElement().clear();
    }

    public boolean getElementsvalue(String element) {
        List<WebElement> ele = driver.findElements(By.xpath(element));
        for (int i = 0; i < ele.size(); i++) {
            System.out.println(ele.get(i).getText());
        }
        return true;
    }

    public void launchEnrolmenturl() {
        driver.get("https://account-uat1.miles-and-more.com/web/de/en/enrolment.html");
    }

    public boolean wait_until_element_clickable(WebElement element) {
        boolean value = false;
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
            System.out.println("caught NoSuchElementException - " + element + " not found");
            value = true;
        } catch (TimeoutException e) {
            System.out.println("caught TimeoutException - " + element + " not found");
        }
        return value;
    }

    public void scroll_to_element(WebElement element) {
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
        waitfor(500);
    }

    public void scroll(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView()", element);
    }


    public void click_login(String login) throws InterruptedException {
        Thread.sleep(7000);
        switch (login) {
            case ("service card number"):
                click_button(returnElement_css(locatorspropertyFile.getLoginwithsvc_css()));
                break;
            case ("user id"):
                click_button(returnElement_css(locatorspropertyFile.getLoginwithuserid_css()));
                break;
        }
    }

    public String return_airlineSelection(String airline) {
        String returnAirline;
        switch (airline) {
            case ("lufthansa group airline"):
                returnAirline = locatorspropertyFile.getLhAirline_css();
                break;
            case ("another airline"):
                returnAirline = locatorspropertyFile.getAnotherAirline_css();
                break;
            default:
                throw new RuntimeException("Specified airline is not available in the system " + airline);
        }
        return returnAirline;
    }

    public String return_PrincipleTypeValues(String principleValues) {
        String returnValues;
        switch (principleValues) {
            case ("emailaddress"):
                returnValues = locatorspropertyFile.getUserEmail_id();
                break;
            case ("Username"):
                returnValues = locatorspropertyFile.getUserUsername_id();
                break;
            default:
                throw new RuntimeException("Specified airline is not available in the system " + principleValues);
        }
        return returnValues;
    }

    public void click_radioButton(String elementName) {
        WebElement element = driver.findElement(By.cssSelector(elementName));
        scroll_to_element(element);
        element.click();

    }

    public void closeTab() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1000);
    }

    public void switchTab1() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(1));
    }


    public void closeBrowserTab() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1000);
    }

    public void closeBrowserTab3() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(2));
        Thread.sleep(1000);
    }


    public void openNewTab1() {
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    public String select_operatedBy(String operatedBy) {
        String value;

        switch (operatedBy.toLowerCase(Locale.ROOT)) {
            case ("lufthansa"):
                value = "//*[@data-airline='LH']";
                break;
            case ("lufthansa group"):
                value = "//*[@data-airline='LUFTHANSA-GROUP']";
                break;
            case ("united"):
                value = "//*[@data-airline='UA']";
                break;
            case ("aegan airlines"):
                value = "//*[@data-airline='A3']";
                break;
            case ("eurowings"):
                value = "//*[@data-airline='EW']";
                break;
            case ("tap air portugal"):
                value = "//*[@data-airline='TP']";
                break;
            case ("air malta"):
                value = "//*[@data-airline='KM']";
                break;
            case ("lufthansa private jet"):
                value = "//*[@data-airline='LUFTHANSA-PRIVAT-JET']";
                break;
            case ("lot polish airline"):
                value = "//*[@data-airline='LO']";
                break;
            case ("swiss airline"):
                value = "//*[@data-airline='LX']";
                break;
            case ("austrian airline"):
                value = "//*[@data-airline='OS']";
                break;
            case ("singapore airline"):
                value = "//*[@data-airline='SQ']";
                break;
            case ("brussels airline"):
                value = "//*[@data-airline='SN']";
                break;
            case ("thai"):
                value = "//*[@data-airline='TG']";
                break;
            case ("luxair"):
                value = "//*[@data-airline='LG']";
                break;
            case ("air canada"):
                value = "//*[@data-airline='AC']";
                break;
            case ("air china"):
                value = "//*[@data-airline='CA']";
                break;
            case ("croatia airline"):
                value = "//*[@data-airline='OU']";
                break;
            case ("ana"):
                value = "//*[@data-airline='NH']";
                break;
            default:
                throw new RuntimeException("Specified Operated By Airline is not available " + operatedBy);
        }
        return value;
    }

    public String select_bookingClass(String bookingClass) {
        String xpath = "//*[@data-booking-class='" + bookingClass + "']";
        return xpath;
    }

    public String select_inboundOperatedBy(String operatedBy) {
        String value;

        switch (operatedBy.toLowerCase(Locale.ROOT)) {
            case ("lufthansa"):
                value = "(//*[@data-airline='LH'])[2]";
                break;
            case ("united"):
                value = "(//*[@data-airline='UA'])[2]";
                break;
            case ("aegan airlines"):
                value = "(//*[@data-airline='A3'])[2]";
                break;
            case ("eurowings"):
                value = "(//*[@data-airline='EW'])[2]";
                break;
            case ("tap air portugal"):
                value = "(//*[@data-airline='TP'])[2]";
                break;
            case ("air malta"):
                value = "(//*[@data-airline='KM'])[2]";
                break;
            default:
                throw new RuntimeException("Specified Operated By Airline is not available " + operatedBy);
        }
        return value;
    }

    public String select_inboundBookingClass(String bookingClass) {
        String xpath = "(//*[@data-booking-class='" + bookingClass + "'])[2]";
        return xpath;
    }

    public WebElement return_tab(String tabSelection) {
        WebElement returnElement;
        switch (tabSelection.toLowerCase(Locale.ROOT)) {
            case ("one way"):
                returnElement = returnElement_id(locatorspropertyFile.getOneWayTab_id());
                break;
            case ("return"):
                returnElement = returnElement_id(locatorspropertyFile.getReturnTab_id());
                break;
            case ("multi city"):
                returnElement = returnElement_id(locatorspropertyFile.getMultiCityTab_id());
                break;
            default:
                throw new RuntimeException("Specified tab selection is not available in the system " + tabSelection);
        }
        return returnElement;
    }

    @SneakyThrows
    public void select_flightSegment(String tabSelection) throws IOException {
        switch (tabSelection) {
            case ("one way"):
                enter_text(returnElement_id(locatorspropertyFile.getOneWayOrigin_id()), cucumberdataTable.getOrigin());
                click_button(returnElement_css(locatorspropertyFile.getAirlineCode_css()));
                System.out.println("Departure " + cucumberdataTable.getOrigin() + " selected");

                enter_text(returnElement_id(locatorspropertyFile.getOnWayDestination_id()), cucumberdataTable.getDestination());
                click_button(returnElement_xpath(locatorspropertyFile.getAirlineCode_xpath()));
                System.out.println("Arrival " + cucumberdataTable.getDestination() + " selected");
                break;
            case ("return"):
                enter_text(returnElement_id(locatorspropertyFile.getOutboundOrigin_id()), cucumberdataTable.getOutboundOrigin());
                click_button(returnElement_css(locatorspropertyFile.getAirlineCode_css()));
                System.out.println("Outbound Departure " + cucumberdataTable.getOutboundOrigin() + " selected");

                enter_text(returnElement_id(locatorspropertyFile.getOutboundDestination_id()), cucumberdataTable.getOutboundDestination());
                click_button(returnElement_xpath(locatorspropertyFile.getAirlineCode_xpath()));
                System.out.println("Outbound Arrival " + cucumberdataTable.getOutboundDestination() + " selected");

                /*enter_text(returnElement_id(locatorspropertyFile.getInboundOrigin_id()), cucumberdataTable.getInboundOrigin());
                click_button(returnElement_xpath(locatorspropertyFile.getAirlineCode4_xpath()));
                System.out.println("Inbound Origin "+cucumberdataTable.getInboundOrigin()+" selected");

                enter_text(returnElement_id(locatorspropertyFile.getInboundDestination_id()), cucumberdataTable.getInboundDestination());
                click_button(returnElement_xpath(locatorspropertyFile.getAirlineCode5_xpath()));
                System.out.println("Inbound Destination "+cucumberdataTable.getInboundDestination()+" selected");*/
                break;
            case ("multi city"):
                enter_text(returnElement_id(locatorspropertyFile.getRoute1Origin_id()), cucumberdataTable.getRoute1_Origin());

                click_button(returnElement_css(locatorspropertyFile.getAirlineCode_css()));
                System.out.println("Route1 Departure " + cucumberdataTable.getRoute1_Origin() + " selected");

                enter_text(returnElement_id(locatorspropertyFile.getRoute1Destination_id()), cucumberdataTable.getRoute1_Destination());
                click_button(returnElement_xpath(locatorspropertyFile.getAirlineCode_xpath()));
                System.out.println("Route1 Arrival " + cucumberdataTable.getRoute1_Destination() + " selected");

                enter_text(returnElement_id(locatorspropertyFile.getRoute2Origin_id()), cucumberdataTable.getRoute2_Origin());
                click_button(returnElement_xpath(locatorspropertyFile.getAirlineCode6_xpath()));
                System.out.println("Route2 Departure " + cucumberdataTable.getRoute2_Origin() + " selected");

                enter_text(returnElement_id(locatorspropertyFile.getRoute2Destination_id()), cucumberdataTable.getRoute2_Destination());
                click_button(returnElement_xpath(locatorspropertyFile.getAirlineCode8_xpath()));
                System.out.println("Route2 Arrival " + cucumberdataTable.getRoute2_Destination() + " selected");
                break;
            default:
                throw new RuntimeException("Specified tab selection is not available in the system " + tabSelection);
        }
    }

    public void click_airportCode(String airportCode) {
        List<WebElement> element = driver.findElements(By.cssSelector("span[class='awesomplete__itemExtraSpacing awesomplete__itemExtraSpacing--flex']"));
        System.out.println("Size " + element);
        for (int i = 0; i < element.size(); i++) {
            String actualCode = element.get(i).getText();
            System.out.println("Actual code " + actualCode);
            try {
                element.get(i).click();
                System.out.println("Clicked I val " + i);
            } catch (ElementNotInteractableException e) {

            }
        }
    }

    public int get_elementSize(String elementName) {
        List<WebElement> element = driver.findElements(By.cssSelector(elementName));
        int Size = element.size();
        return Size;
    }

    public int getStepperSize(String elementName) {
        List<WebElement> element = driver.findElements(By.xpath(elementName));
        int Size = element.size();
        System.out.println("Stepper Size before looping " + Size);
        for (int i = 0; i < Size; i++) {
            if (element.get(i).getAttribute("hidden") != null) {
                Size = Size - 1;
            }
        }
        System.out.println("Stepper Size after looping " + Size);
        return Size;
    }

    public void getstepperText(int Size, String elementName, String[] arrayLabel) {
        List<WebElement> element = driver.findElements(By.xpath(elementName));
        for (int i = 0; i < Size; i++) {
            assertEquals(arrayLabel[i], element.get(i).getText());
            System.out.println("Steppers Label " + element.get(i).getText() + " is displayed");
        }
    }

    public WebElement select_MileageCalculatorMode(String mileageCalculator) {
        WebElement returnElement;
        switch (mileageCalculator.toLowerCase(Locale.ROOT)) {
            case ("expert mode"):
                returnElement = returnElement_css(locatorspropertyFile.getNavigationMileageCalculator_css());
                break;
            case ("easy mode"):
                returnElement = returnElement_css(locatorspropertyFile.getNavigationMileageCalculatorEasyMode_css());
                break;
            default:
                throw new RuntimeException("Specified mode is not available in the system " + mileageCalculator);
        }
        return returnElement;
    }

    public WebElement click_MileageCalculator(String startmileageCalculator) {
        WebElement returnElement;
        switch (startmileageCalculator.toLowerCase(Locale.ROOT)) {
            case ("expert mode"):
                returnElement = returnElement_css(locatorspropertyFile.getStartMileageCalculation_css());
                break;
            case ("easy mode"):
                returnElement = returnElement_css(locatorspropertyFile.getStartMileageCalculationEasyMode_css());
                break;
            default:
                throw new RuntimeException("Specified mode is not available in the system " + startmileageCalculator);
        }
        return returnElement;
    }

    public String select_easyModeBookingClass(String bookingClass) {
        String value;

        switch (bookingClass.toLowerCase(Locale.ROOT)) {
            case ("economy class"):
                value = "(//*[@class='mcalceasy__compartmentItem'])[1]";
                //value = "//*[@id='serviceClass--Y']";
                break;
            case ("premium economy class"):
                value = "(//*[@class='mcalceasy__compartmentItem'])[2]";
                break;
            case ("business class"):
                value = "(//*[@class='mcalceasy__compartmentItem'])[3]";
                break;
            case ("first class"):
                value = "(//*[@class='mcalceasy__compartmentItem'])[4]";
                break;
            default:
                throw new RuntimeException("Specified Booking Class is not available " + bookingClass);
        }
        return value;
    }

    public boolean get_element_displayed_status(WebElement element) {
        boolean isDisplayed = true;
        try {
            scroll_to_element(element);
            isDisplayed = element.isDisplayed();
            System.out.println("Element Displayed");
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
        return isDisplayed;
    }


    public String returnTitle(String title) {
        String value;
        switch (title.toLowerCase(Locale.ROOT)) {
            case ("mr"):
                value = locatorspropertyFile.getUserTitleMr_css();
                break;
            case ("ms"):
                value = locatorspropertyFile.getUserTitleMs_css();
                break;
            default:
                throw new RuntimeException("Specified Title is not available " + title);
        }
        return value;
    }

    public String select_academicTitle(String academicTitle) {
        String value;
        switch (academicTitle.toLowerCase(Locale.ROOT)) {
            case ("no title"):
                value = "INPUT[value='notitle']";
                break;
            case ("dr"):
                value = "input[value='dr']";
                break;
            case ("prof."):
                value = "input[value='prof']";
                break;
            case ("prof. dr"):
                value = "input[value='profdr']";
                break;
            default:
                throw new RuntimeException("Specified Academic Title is not available " + academicTitle);
        }
        return value;
    }

    public void enter_dateOdBirth(String dateOfBirth) throws IOException {
        String[] arrdob = dateOfBirth.split("-");
        enter_text(returnElement_css(locatorspropertyFile.getUserBirthDay_css()), arrdob[0]);
        enter_text(returnElement_css(locatorspropertyFile.getUserBirthMonth_css()), arrdob[1]);
        enter_text(returnElement_css(locatorspropertyFile.getUserBirthYear_css()), arrdob[2]);
    }

    public void enter_phoneNumber(String phoneNumber, String country) throws IOException {
        String[] arrPH = phoneNumber.split("-");
        enter_text(returnElement_css(locatorspropertyFile.getUserCountryCode_css()), arrPH[0]);
        click_button(returnElement_css(locatorspropertyFile.getUserSelectCountryCode_css()));
        if (country.contains("India") || country.contains("Poland")) {
            enter_text(returnElement_css(locatorspropertyFile.getUserPhoneNumber_css()), arrPH[1]);
        } else {
            enter_text(returnElement_css(locatorspropertyFile.getUserAreaCode_css()), arrPH[1]);
            enter_text(returnElement_css(locatorspropertyFile.getUserPhoneNumber_css()), arrPH[2]);
        }

    }

    public void select_serviceCard(String serviceCard) {
        switch (serviceCard.toLowerCase(Locale.ROOT)) {
            case ("y"):
                click_button(returnElement_css(locatorspropertyFile.getUserServiceCard_css()));
                break;
            case ("n"):
                click_button(returnElement_css(locatorspropertyFile.getUserServiceCard_css()));
                click_button(returnElement_css(locatorspropertyFile.getUserServiceCard_css()));
                break;
            default:
                throw new RuntimeException("Specified Service Card detail is not available " + serviceCard);
        }
    }

    public String selectPartner(String partner) {
        String value;
        switch (partner.toLowerCase(Locale.ROOT)) {
            case ("lufthansa"):
                value = "li[data-escid='0DE21']";
                break;
            case ("austrian"):
                value = "li[data-escid='0AT02']";
                break;
            case ("swiss"):
                value = "li[data-escid='0CH19']";
                break;
            case ("eurowings"):
                value = "li[data-escid='0EW10']";
                break;
            default:
                throw new RuntimeException("Specified Preferred Partner is not available " + partner);
        }
        return value;
    }

    public void select_temporaryServiceCard(String value) {
        switch (value.toLowerCase(Locale.ROOT)) {
            case ("y"):
                click_radioButton(locatorspropertyFile.getUserServiceCard_css());
                break;
            case ("n"):
                System.out.println("User don't have a provisional service card number");
                break;
            default:
                throw new RuntimeException("Specified temporary service card number is not available " + value);

        }
    }

    public void select_generalConsent(String value) {
        switch (value.toLowerCase(Locale.ROOT)) {
            case ("y"):
                click_radioButton(locatorspropertyFile.getUserGeneralConsent_css());
                break;
            case ("n"):
                System.out.println("User don't want to select General Consent");
                break;
            default:
                throw new RuntimeException("Specified temporary service card number is not available " + value);
        }
    }

    public void select_createAccountGeneralConsent(String value) {
        switch (value.toLowerCase(Locale.ROOT)) {
            case ("y"):
                click_radioButton(locatorspropertyFile.getUserCreateAccountGeneralConsent_css());
                break;
            case ("n"):
                System.out.println("User don't want to select General Consent");
                break;
            default:
                throw new RuntimeException("Specified temporary service card number is not available " + value);

        }
    }


    public String getDateOfBirth(String age) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        System.out.println("Current Date: " + sdf.format(cal.getTime()));
        switch (age.toLowerCase(Locale.ROOT)) {
            case ("adult"):
                cal.add(Calendar.DAY_OF_MONTH, -13000);
                break;
            case ("teenager"):
                cal.add(Calendar.DAY_OF_MONTH, -6000);
                break;
            case ("child"):
                cal.add(Calendar.DAY_OF_MONTH, -1000);
                break;
            default:
                throw new RuntimeException("Specified age is not available " + age);
        }
        //cal.add(Calendar.DAY_OF_MONTH, -6000);
        //Date after adding the days to the current date
        String newDate = sdf.format(cal.getTime());
        //Displaying the new Date after addition of Days to current date
        System.out.println("Date after Addition: " + newDate);
        return newDate;
    }


    public void selectTitle(String title) {
        String value;
        switch (title) {
            case ("Mr"):
                click_button(returnElement_xpath(locatorspropertyFile.getUserClickOnTitleRadioButtion_xpath()));
                break;
            case ("Ms"):
                click_button(returnElement_css(locatorspropertyFile.getUserClickOnTitleRadioButtionForMs_xpath()));
                break;
            default:
                throw new RuntimeException("Specified Academic Title is not available " + title);
        }
    }

    public void closeBrowser() {
        System.out.println("before close");
        driver.close();
        //driver.quit();
        System.out.println("After close");
    }

    @After
    public void quitDriver() {
        System.out.println("Before quitting in quit class");
        driver.close();
        System.out.println("After quitting driver");
    }


    public void closeTab1() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(0));
    }

    public void closeTab0switchTab0() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    public void closeTab2() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(1));
    }

    public void userNavigateToBack() {
        driver.navigate().back();
    }

    public void switchAndCloseTab0() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(0));
    }

    public void closeBrowserTabs() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Thread.sleep(500);
        driver.close();
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(500);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void switchAndCloseBrowserTabs() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(2));
        Thread.sleep(500);
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    public void closeOpenedBrowserTabs() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(2));
        Thread.sleep(500);
        driver.close();
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(500);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void get_pageSource() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    public void deleteCookies() {
        deleteAllCookiesbutCDN();
    }

    public String currentURL() {
        String currentUrl = driver.getCurrentUrl();
        String url = currentUrl.toString().replace("row", "de");
        return url;
    }

    public String getCurrentURL() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void getScreenshot(String screenshotName) throws Exception {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String dateStr = dateFormat.format(new Date());
//        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//        ImageIO.write(screenshot.getImage(),"JPG",new File("C:\\Users\\2012704\\Desktop\\errorSnap\\"+screenshotName+".jpeg"));

//        Augmenter augmenter = new Augmenter();
//        TakesScreenshot ts = (TakesScreenshot) augmenter.augment(driver);
//        File file = ts.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file,new File("C:\\Users\\2012704\\Desktop\\errorSnap"+ screenshotName + ".jpeg"));

//        WebDriver augmentedDriver = new Augmenter().augment(driver);
//        byte[] bytes = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
//        ((TakesScreenshot)driver.getDelegates()).getScreenshotAs(OutputType.BYTES);

//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_PRINTSCREEN);
//        robot.keyPress(KeyEvent.VK_PRINTSCREEN);

//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String dest = System.getProperty("user.dir") + "\\ErrorScreenshots\\" + screenshotName + ".png";
//        System.out.println("destination" +dest);
//        File destination = new File(dest);
//        FileUtils.copyFile(source, destination);

//        WebDriver agumentDriver=new Augmenter().augment(driver);
//        byte[] bytes=((TakesScreenshot) agumentDriver).getScreenshotAs(OutputType.BYTES);
//        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        File srcFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destFile=new File("C:\\Users\\2012704\\Desktop\\errorSnap\\"+ screenshotName +".jpeg");


        System.setProperty("java.awt.headless", "false");
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", new File("C:\\Users\\2012704\\Downloads\\Git_code_MAM\\Git_code_MAM\\mam3.0-bdd-main\\mam3.0-bdd-main\\test-output\\Extent_Report" + screenshotName + ".jpeg"));

    }

    public String getReportConfigPath() {
        String reportConfigPath = System.getProperty("reportConfigPath");
        System.out.println(reportConfigPath);
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public void elementStatus(WebElement element) {
        assertFalse(driver.findElement(By.xpath(String.valueOf(element))).isEnabled());
    }

    public void addScreenshot() throws AWTException, IOException {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//          scenario.attach(screenshot, "image/png", "image");
        System.setProperty("java.awt.headless", "false");
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        // ImageIO.write(image, "png", new File("C:\\Users\\2012704\\Desktop\\errorSnap\\test.jpeg"));
        ImageIO.write(image, "png", new File("C:\\Users\\2574350\\Desktop\\errorSnap\\test.jpeg"));

    }

    public void openNewTab(int i) {
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i));
    }

    public void openTab() {
        int i;
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        for (i = 0; i < tabs.size(); i++)
            driver.switchTo().window(tabs.get(i));
    }

    public void focusTab() {
        int i;
//        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        for (i = 0; i < tabs.size(); i++)
            driver.switchTo().window(tabs.get(i));

    }

    public void load_Mampage_uat3() {
        try {
            String titile = driver.getTitle();
            deleteAllCookiesbutCDN();

            Set<String> tabs = driver.getWindowHandles();
            for (String tab : tabs) {
                System.out.println(tabs.size());

                if (!tab.equals(tabs)) {
                    driver.get("https://www-uat3.miles-and-more.com/de/en.html");
                    Thread.sleep(2000);
                    System.out.println(" Third Url loaded successfully.");
                    keepgermany_launch();
                }

            }
        } catch (Exception e) {
            System.out.println("Focus is catch");

        }
    }

    public void load_Mampage_uat2() {
        try {
            String titile = driver.getTitle();
            deleteAllCookiesbutCDN();

            Set<String> tabs = driver.getWindowHandles();
            for (String tab : tabs) {
                System.out.println(tabs.size());

                if (!tab.equals(tabs)) {
                    driver.get("https://www-uat2.miles-and-more.com/de/en.html");
                    Thread.sleep(2000);
                    System.out.println(" Third Url loaded successfully.");
                    keepgermany_launch();
                }

            }
        } catch (Exception e) {
            System.out.println("Focus is catch");

        }
    }


    public void load_prod_Mampage() {
        try {
            String titile = driver.getTitle();
            deleteAllCookiesbutCDN();

            Set<String> tabs = driver.getWindowHandles();
            for (String tab : tabs) {
                System.out.println(tabs.size());

//                if (!tab.equals(tabs)) {
//                    driver.get("https://account-uat1.miles-and-more.com/lh_shared/log-me-in");
//                    Thread.sleep(2000);
//                    driver.findElement(By.id("secret")).sendKeys("Mn6h5&ZG");
//                    System.out.println(" FIRST Url loaded successfully.");
//                }
//                if (!tab.equals(tabs)) {
//                    driver.get("https://www-uat1.miles-and-more.com/lh_shared/log-me-in");
//                    Thread.sleep(2000);
//                    driver.findElement(By.id("secret")).sendKeys("Mn6h5&ZG");
//                    System.out.println(" Second Url loaded successfully.");
//                }
                if (!tab.equals(tabs)) {
                    driver.get("https://www-uat1.miles-and-more.com/de/en.html");
//                    driver.get("https://www-bloom.miles-and-more.com/de/en.html");
                    Thread.sleep(2000);
                    System.out.println(" Third Url loaded successfully.");
                }

            }
        } catch (Exception e) {
            System.out.println("Focus is catch");

        }

    }

    public void moveToTab(int i) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i));
    }

    public void textValidation(WebElement element, String expectedText) {
        System.out.println("Expected-->" + expectedText);
        String actualText = element.getText();
        System.out.println("Actual-->" + actualText);
        Assert.assertEquals(expectedText, actualText);
    }

    public void presenceOfElement(WebElement element) {
        boolean presence = element.isDisplayed();
        if (presence == true) {
            scroll_to_element(element);
            System.out.println("Element Present");
        } else {
            Assert.fail("Element not present");
        }
    }

    public void urlVerify(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }

    public void textVerify(WebElement element, String expectedText) {
        String actualText = element.getText();
        System.out.println("Expected-->" + expectedText);
        System.out.println("Actual-->" + actualText);
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Text Matching");
    }

    public void load_Mampage() {
        System.getProperty("env");
        System.out.println("ENvvvv->" + System.getProperty("env"));
        try {
            System.out.println(" Opening URL:" + propertyFile.getMamcom_URL());
            deleteAllCookiesbutCDN();
            driver.get(propertyFile.getMamcom_URL());


            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("header__logo")));
            System.out.println(" Page loaded successfully.");

            keepgermany_launch();

        } catch (Exception e) {
            System.out.println("Focus is catch");
            e.printStackTrace();
        }

    }

    /**
     * Delete all cookies but matain the CDN Login Cookie
     */
    public void deleteAllCookiesbutCDN() {
//        driver.manage().deleteAllCookies();
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            if (!cookie.getName().equals("__cdnpt__")) {
                driver.manage().deleteCookie(cookie);
            }
        }
    }

    public void load_Mampage2(String tenantSite) {
        System.getProperty("env");
        System.out.println("ENvvvv->" + System.getProperty("env"));
        try {
            String titile = driver.getTitle();
            deleteAllCookiesbutCDN();

            Set<String> tabs = driver.getWindowHandles();
            for (String tab : tabs) {
                System.out.println(tabs.size());

                if (!tab.equals(tabs)) {
                    driver.get("https://account-uat2.miles-and-more.com/lh_shared/log-me-in");
                    Thread.sleep(2000);
                    driver.findElement(By.id("secret")).sendKeys("Mn6h5&ZG");
                    System.out.println(" FIRST Url loaded successfully.");
                }
//                if (!tab.equals(tabs)) {
//                    driver.get("https://www-uat1.miles-and-more.com/lh_shared/log-me-in");
//                    Thread.sleep(2000);
//                    driver.findElement(By.id("secret")).sendKeys("Mn6h5&ZG");
//                    System.out.println(" Second Url loaded successfully.");
//                }
//                if (!tab.equals(tabs)) {
//                    driver.get(propertyFile.getMamcom_URL());
////                    driver.get("https://www-bloom.miles-and-more.com/de/en.html");
//                    Thread.sleep(2000);
//                    System.out.println(" Third Url loaded successfully.");
//                }

            }
        } catch (Exception e) {
            System.out.println("Focus is catch");

        }

    }

    public void tenantUat1toUat2(){
        String url=driver.getCurrentUrl();
        String uat2_url=url.replaceFirst("1","2");
        System.out.println(uat2_url);
        driver.get(uat2_url);
//        load_page(uat2_url);
    }

    public void clickLoginAfterLaunchTenant() {
        waitfor(3000);
        refreshPage();

        try{
            click_button(returnElement_xpath(locatorsPropertyFile3.getAgree_popup()));
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            click(return_xpath(locatorsPropertyFile3.getAgree_popup_brussels()));
        }
        catch (Exception e){
            System.out.println(e);
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));


        try {
            WebElement close_proxy_popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsPropertyFile3.getAgree_popup())));
            close_proxy_popup.click();
        } catch (Exception e) {
            System.out.println("Privacy setting Popup not found");
        }
        try {
            WebElement close_popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsPropertyFile2.getTenant_popup_close())));
            close_popup.click();
        } catch (Exception e) {
            System.out.println("Popup not found");
        }

        try {
            get_element_displayed_status(return_xpath(locatorspropertyFile.getBtn_login()));
            click_button(return_xpath(locatorspropertyFile.getBtn_login()));
        } catch (Exception e) {
            get_element_displayed_status(return_xpath(locatorspropertyFile.getBtn_login()));
            click(return_xpath(locatorspropertyFile.getBtn_login()));
            System.out.println("Login clicked using JS");
        }


    }

}

