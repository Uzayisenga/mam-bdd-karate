package com.milesandmore.testautomation.stepdefinitions.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks {

    public static WebDriver driver;

    private ByteArrayOutputStream scenarioLogStream;
    private PrintStream originalSystemOut;
    private PrintStream originalSystemErr;

    private final boolean debugFilePrint = false; // Toggle for reading Hooks.java content

    @Before
    public void setup() {
        // Debug info
        System.out.println("\n===== Hooks.java Setup Debugging Start =====");
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("===== Hooks.java Setup Debugging End =====\n");

        // Optional file read
        if (debugFilePrint) {
            try {
                Path hooksPath = Paths.get(System.getProperty("user.dir"),
                        "src", "test", "java", "com", "milesandmore",
                        "testautomation", "stepdefinitions", "hooks", "Hooks.java");

                if (Files.exists(hooksPath)) {
                    System.out.println("--- Content of Hooks.java ---");
                    try (BufferedReader reader = new BufferedReader(new FileReader(hooksPath.toFile()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                } else {
                    System.err.println("Hooks.java not found at: " + hooksPath.toAbsolutePath());
                }
            } catch (IOException e) {
                System.err.println("Error reading Hooks.java: " + e.getMessage());
            }
        }

        // Capture logs
        originalSystemOut = System.out;
        originalSystemErr = System.err;
        scenarioLogStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(scenarioLogStream, true, StandardCharsets.UTF_8);
        System.setOut(ps);
        System.setErr(ps);
        System.out.println("--- System.out/err redirected for scenario log capture ---");

        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();

        boolean isCI = System.getenv("CI") != null ||
                System.getenv("JENKINS_HOME") != null ||
                System.getenv("KUBERNETES_SERVICE_HOST") != null;

        options.addArguments("--headless=chrome");
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

        String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome_user_data_" + System.currentTimeMillis();
        options.addArguments("--user-data-dir=" + userDataDir);

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

        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        try {
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));
            System.out.println("✅ ChromeDriver initialized successfully.");

            if (driver instanceof HasCapabilities) {
                Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
                Object chromeOptionsCap = capabilities.getCapability(ChromeOptions.CAPABILITY);
                if (chromeOptionsCap instanceof Map<?, ?> optionsMap && optionsMap.containsKey("args")) {
                    @SuppressWarnings("unchecked")
                    List<String> args = (List<String>) optionsMap.get("args");
                    System.out.println("✅ ChromeOptions arguments (ACTUALLY APPLIED by driver):");
                    args.forEach(arg -> System.out.println("  - " + arg));
                } else {
                    System.err.println("⚠️ Could not extract ChromeOptions arguments.");
                }
            }
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize ChromeDriver: " + e.getMessage());
            printSystemInfo();
            checkChromeBinary();
            throw new RuntimeException("Chrome driver initialization failed", e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // Restore System.out/err
        System.setOut(originalSystemOut);
        System.setErr(originalSystemErr);
        System.out.println("--- System.out/err restored ---");

        if (scenario.isFailed()) {
            try {
                String logContent = scenarioLogStream.toString(StandardCharsets.UTF_8.name());
                if (!logContent.isEmpty()) {
                    scenario.attach(logContent.getBytes(StandardCharsets.UTF_8), "text/plain", "Scenario Log");
                    System.out.println("📄 Scenario log attached successfully for failed scenario: " + scenario.getName());
                }
            } catch (IOException e) {
                System.err.println("ERROR: Could not get scenario log content: " + e.getMessage());
            }
        }

        if (driver != null) {
            if (scenario.isFailed() && driver instanceof TakesScreenshot) {
                try {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    if (screenshot != null && screenshot.length > 0) {
                        scenario.attach(screenshot, "image/png", "Screenshot");
                        System.out.println("📸 Screenshot attached successfully for failed scenario: " + scenario.getName());
                    }
                } catch (Exception e) {
                    System.err.println("⚠️ Error capturing screenshot: " + e.getMessage());
                }
            }

            try {
                driver.quit();
                System.out.println("🧹 WebDriver closed successfully.");
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
        String command = System.getProperty("os.name").toLowerCase().contains("win") ? "where chrome" : "which google-chrome || which chromium-browser || which chrome";
        try {
            ProcessBuilder pb = System.getProperty("os.name").toLowerCase().contains("win")
                    ? new ProcessBuilder("cmd", "/c", command)
                    : new ProcessBuilder("bash", "-c", command);

            Process process = pb.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.err.println("✅ Chrome binary found in PATH.");
            } else {
                System.err.println("❌ Chrome binary NOT found in PATH.");
            }

            try (BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(process.getInputStream()))) {
                String line;
                System.err.println("--- Chrome Binary Check Output ---");
                while ((line = reader.readLine()) != null) {
                    System.err.println(line);
                }
                System.err.println("---------------------------------");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("⚠️ Could not verify Chrome binary: " + e.getMessage());
        }
    }
}
