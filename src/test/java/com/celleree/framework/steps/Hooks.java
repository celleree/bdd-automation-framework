package com.celleree.framework.steps;

import com.celleree.framework.utils.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Cucumber hooks for UI scenarios.
 */
public class Hooks {

    @Before("@ui")
    public void startBrowser() {
        BrowserManager.startBrowser();
    }

    @After("@ui")
    public void closeBrowser() {
        BrowserManager.quitBrowser();
    }
}
