package com.milesandmore.testautomation.stepdefinitions.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Capabilities; // Import Capabilities
import org.openqa.selenium.HasCapabilities; // Import HasCapabilities

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream; // For capturing logs
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream; // For redirecting System.out/err
import java.nio.charset.StandardCharsets; // For log encoding
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map; // Import for Map type



public class Hooks {

    public static WebDriver driver;

    // --- New fields for capturing System.out and System.err ---
    private ByteArrayOutputStream scenarioLogStream;
    private PrintStream originalSystemOut;
    private PrintStream originalSystemErr;
    // --- End new fields ---

    @Before
    public void setup() {
        // --- START DEEP DEBUGGING OUTPUT ---
        System.out.println("\n===== Hooks.java Setup Debugging Start =====");
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("OS Name: " + System.getProperty("os.name"));

        // Attempt to read and print the content of this very Hooks.java file
        try {
            Path hooksPath = Paths.get(System.getProperty("user.dir"),
                    "src", "test", "java", "com", "milesandmore",
                    "testautomation", "stepdefinitions", "hooks", "Hooks.java");
            System.out.println("Attempting to read Hooks.java from: " + hooksPath.toAbsolutePath().toString());
            if (Files.exists(hooksPath)) {
                System.out.println("--- Content of Hooks.java (as seen by build agent) ---");
                try (BufferedReader reader = new BufferedReader(new FileReader(hooksPath.toFile()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
                System.out.println("--- End Content of Hooks.java ---");
            } else {
                System.err.println("CRITICAL: Hooks.java file NOT FOUND at expected path: " + hooksPath.toAbsolutePath().toString());
            }
        } catch (IOException e) {
            System.err.println("ERROR: Could not read Hooks.java file for debugging: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("===== Hooks.java Setup Debugging End =====\n");
        // --- END DEEP DEBUGGING OUTPUT ---

        // --- Start capturing System.out/err for scenario logs ---
        originalSystemOut = System.out;
        originalSystemErr = System.err;
        scenarioLogStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(scenarioLogStream, true, StandardCharsets.UTF_8);
        System.setOut(ps);
        System.setErr(ps);
        System.out.println("--- System.out/err redirected for scenario log capture ---");
        // --- End capturing ---

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
        //options.addArguments("--remote-debugging-port=9222");

        // Optional user-data-dir (avoids permission issues in some CI setups)
        String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome_user_data_" + System.currentTimeMillis();
        //options.addArguments("--user-data-dir=" + userDataDir);

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

        // Initialize the driver - ONLY ONCE!
        try {
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));
            System.out.println("✅ ChromeDriver initialized successfully.");

            // --- IMPROVED DEBUG: Print ACTUAL ChromeOptions arguments from the driver ---
            if (driver instanceof HasCapabilities) {
                Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
                if (capabilities.getCapability(ChromeOptions.CAPABILITY) instanceof Map) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> chromeOptionsMap = (Map<String, Object>) capabilities.getCapability(ChromeOptions.CAPABILITY);
                    if (chromeOptionsMap != null && chromeOptionsMap.containsKey("args")) {
                        @SuppressWarnings("unchecked")
                        List<String> actualArgs = (List<String>) chromeOptionsMap.get("args");
                        System.out.println("✅ ChromeOptions arguments (ACTUALLY APPLIED by driver):");
                        actualArgs.forEach(arg -> System.out.println("  - " + arg));
                    } else {
                        System.err.println("⚠️ 'args' not found in ChromeOptions capabilities map.");
                    }
                } else {
                    System.err.println("⚠️ ChromeOptions capability is not a Map in driver capabilities.");
                }
            } else {
                System.err.println("⚠️ Driver instance does not implement HasCapabilities.");
            }
            // --- END IMPROVED DEBUG ---

        } catch (Exception e) {
            System.err.println("❌ Failed to initialize ChromeDriver: " + e.getMessage());
            printSystemInfo();
            checkChromeBinary();
            throw new RuntimeException("Chrome driver initialization failed", e);
        }
    }

    private void checkChromeBinary() {
    }

    private void printSystemInfo() {
    }
}