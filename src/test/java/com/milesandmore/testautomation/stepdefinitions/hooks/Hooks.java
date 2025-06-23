package com.milesandmore.testautomation.stepdefinitions.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.List;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // CI/Container environment detection
        boolean isCI = System.getenv("CI") != null ||
                System.getenv("JENKINS_HOME") != null ||
                System.getenv("KUBERNETES_SERVICE_HOST") != null;

        // Essential headless/browser stability flags
        options.addArguments("--headless=new"); // modern headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-background-timer-throttling");
        options.addArguments("--disable-backgrounding-occluded-windows");
        options.addArguments("--disable-renderer-backgrounding");
        options.addArguments("--disable-features=TranslateUI");
        options.addArguments("--disable-ipc-flooding-protection");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--remote-debugging-port=9222");

        // Optional user-data-dir (avoids permission issues in some CI setups)
        String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome_user_data_" + System.currentTimeMillis();
        options.addArguments("--user-data-dir=" + userDataDir);

        // Only add these in CI/container environments
        if (isCI) {
            options.addArguments("--single-process");
            options.addArguments("--disable-background-networking");
            options.addArguments("--disable-sync");
            options.addArguments("--metrics-recording-only");
            options.addArguments("--mute-audio");
            options.addArguments("--no-first-run");
            options.addArguments("--safebrowsing-disable-auto-update");
            options.addArguments("--ignore-certificate-errors");
        }

        // Disable automation indicators
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Debug: Print ChromeOptions arguments
        try {
            var argsField = ChromeOptions.class.getDeclaredField("args");
            argsField.setAccessible(true);
            @SuppressWarnings("unchecked")
            List<String> args = (List<String>) argsField.get(options);
            System.out.println("🚀 ChromeOptions arguments:");
            args.forEach(arg -> System.out.println("  - " + arg));
        } catch (Exception e) {
            System.err.println("⚠️ Could not reflectively access ChromeOptions arguments: " + e.getMessage());
        }

        // Initialize the driver
        try {
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));
            System.out.println("✅ ChromeDriver initialized.");
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize ChromeDriver: " + e.getMessage());
            printSystemInfo();
            checkChromeBinary();
            throw new RuntimeException("Chrome driver initialization failed", e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                try {
                    if (driver instanceof TakesScreenshot) {
                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.attach(screenshot, "image/png", "Screenshot");
                        System.out.println("📸 Screenshot attached for failed scenario: " + scenario.getName());
                    }
                } catch (Exception e) {
                    System.err.println("⚠️ Could not capture screenshot: " + e.getMessage());
                }
            }

            try {
                driver.quit();
                System.out.println("🧹 WebDriver closed.");
            } catch (Exception e) {
                System.err.println("⚠️ Error closing WebDriver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }

    private void printSystemInfo() {
        System.err.println("📋 System Info:");
        System.err.println("  - OS: " + System.getProperty("os.name"));
        System.err.println("  - Java Version: " + System.getProperty("java.version"));
        System.err.println("  - User: " + System.getProperty("user.name"));
        System.err.println("  - Working Directory: " + System.getProperty("user.dir"));
        System.err.println("  - Temp Directory: " + System.getProperty("java.io.tmpdir"));
    }

    private void checkChromeBinary() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "where chrome");
            Process process = pb.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.err.println("✅ Chrome binary found.");
            } else {
                System.err.println("❌ Chrome binary NOT found. Please ensure Chrome is installed and added to PATH.");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("⚠️ Could not verify Chrome binary: " + e.getMessage());
        }
    }
}
