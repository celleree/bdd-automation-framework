package com.celleree.framework.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Creates and manages the browser used by UI tests.
 */
public final class BrowserManager {

    private static WebDriver driver;

    private BrowserManager() {
        // Utility class; prevent instantiation.
    }

    public static void startBrowser() {
        if (driver != null) {
            return;
        }

        String browser = ConfigReader.get("browser");

        if (!"chrome".equalsIgnoreCase(browser)) {
            throw new IllegalArgumentException("Unsupported browser configured: " + browser);
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Browser has not been started.");
        }

        return driver;
    }

    public static WebDriverWait getWait() {
        int timeoutSeconds = ConfigReader.getInt("timeout.seconds");
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
