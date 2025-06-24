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
import java.lang.reflect.Field; // Import for reflective access
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
        // Ensure the directory is created if needed, or rely on Chrome to create it.
        String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome_user_data_" + System.currentTimeMillis();
        options.addArguments("--user-data-dir=" + userDataDir);

        // Only add these in CI/container environments
        if (isCI) {
            options.addArguments("--single-process"); // Can sometimes help in containers but might also hinder
            options.addArguments("--disable-background-networking");
            options.addArguments("--disable-sync");
            options.addArguments("--metrics-recording-only");
            options.addArguments("--mute-audio");
            options.addArguments("--no-first-run");
            options.addArguments("--safebrowsing-disable-auto-update");
            options.addArguments("--ignore-certificate-errors"); // Use with caution, can hide real issues
        }

        // Disable automation indicators
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Debug: Print ChromeOptions arguments
        try {
            Field argsField = ChromeOptions.class.getDeclaredField("args");
            argsField.setAccessible(true);
            @SuppressWarnings("unchecked")
            List<String> args = (List<String>) argsField.get(options);
            System.out.println("🚀 ChromeOptions arguments:");
            args.forEach(arg -> System.out.println("  - " + arg));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.err.println("⚠️ Could not reflectively access ChromeOptions arguments: " + e.getMessage());
        }

        // Initialize the driver
        try {
            driver = new ChromeDriver(options);
            // Set implicit waits and page load timeouts
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));
            System.out.println("✅ ChromeDriver initialized successfully.");
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize ChromeDriver: " + e.getMessage());
            printSystemInfo(); // Helper method to print system details
            checkChromeBinary(); // Helper method to check Chrome binary path
            throw new RuntimeException("Chrome driver initialization failed", e); // Re-throw to fail the test
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                try {
                    // Check if the driver supports taking screenshots
                    if (driver instanceof TakesScreenshot) {
                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                        // --- NEW CHECK HERE ---
                        if (screenshot != null && screenshot.length > 0) {
                            scenario.attach(screenshot, "image/png", "Screenshot");
                            System.out.println("📸 Screenshot attached successfully for failed scenario: " + scenario.getName());
                        } else {
                            System.err.println("⚠️ Captured screenshot was null or empty for failed scenario: " + scenario.getName());
                        }
                        // --- END NEW CHECK ---
                    } else {
                        System.err.println("❌ Driver instance does not support taking screenshots.");
                    }
                } catch (Exception e) {
                    System.err.println("⚠️ Error capturing or attaching screenshot: " + e.getMessage());
                    // Optionally, print stack trace for more details in case of exception during capture
                    e.printStackTrace();
                }
            }

            // Always attempt to quit the driver, even if screenshot failed,
            // to ensure browser processes are terminated.
            try {
                driver.quit();
                System.out.println("🧹 WebDriver closed successfully.");
            } catch (Exception e) {
                System.err.println("⚠️ Error closing WebDriver: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging
            } finally {
                driver = null; // Ensure the static driver reference is cleared
            }
        }
    }

    /**
     * Helper method to print system information for debugging purposes.
     */
    private void printSystemInfo() {
        System.err.println("📋 System Info:");
        System.err.println("  - OS: " + System.getProperty("os.name"));
        System.err.println("  - OS Architecture: " + System.getProperty("os.arch"));
        System.err.println("  - OS Version: " + System.getProperty("os.version"));
        System.err.println("  - Java Version: " + System.getProperty("java.version"));
        System.err.println("  - User: " + System.getProperty("user.name"));
        System.err.println("  - Working Directory: " + System.getProperty("user.dir"));
        System.err.println("  - Temp Directory: " + System.getProperty("java.io.tmpdir"));
    }

    /**
     * Helper method to check if Chrome binary is found in the system's PATH.
     * This is useful for diagnosing 'Chrome failed to start' errors.
     */
    private void checkChromeBinary() {
        String command = System.getProperty("os.name").toLowerCase().contains("win") ? "where chrome" : "which google-chrome || which chromium-browser || which chrome";
        try {
            ProcessBuilder pb;
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                pb = new ProcessBuilder("cmd", "/c", command);
            } else {
                pb = new ProcessBuilder("bash", "-c", command);
            }

            Process process = pb.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.err.println("✅ Chrome binary found in PATH.");
            } else {
                System.err.println("❌ Chrome binary NOT found in PATH. Please ensure Chrome is installed and its path is configured.");
            }

            // Optionally, print the output of the command
            try (var reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()))) {
                String line;
                System.err.println("--- Chrome Binary Check Output ---");
                while ((line = reader.readLine()) != null) {
                    System.err.println(line);
                }
                System.err.println("---------------------------------");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("⚠️ Could not verify Chrome binary via command: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
