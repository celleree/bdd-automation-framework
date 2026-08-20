package com.celleree.framework.pages;

import com.celleree.framework.utils.BrowserManager;
import com.celleree.framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page object for the SauceDemo login page.
 */
public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productsTitle = By.cssSelector("[data-test='title']");
    private final By loginErrorMessage = By.cssSelector("[data-test='error']");

    public LoginPage() {
        this.driver = BrowserManager.getDriver();
        this.wait = BrowserManager.getWait();
    }

    public void open() {
        driver.get(ConfigReader.get("ui.base.url"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getProductsTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).getText();
    }

    public String getLoginErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage)).getText();
    }
}
