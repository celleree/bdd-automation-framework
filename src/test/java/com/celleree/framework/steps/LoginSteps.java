package com.celleree.framework.steps;

import com.celleree.framework.pages.LoginPage;
import com.celleree.framework.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Step definitions for SauceDemo login scenarios.
 */
public class LoginSteps {

    private LoginPage loginPage;

    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        loginPage = new LoginPage();
        loginPage.open();
    }

    @When("I log in with valid credentials")
    public void iLogInWithValidCredentials() {
        loginPage.login(
                ConfigReader.get("ui.valid.username"),
                ConfigReader.get("ui.valid.password"));
    }

    @When("I log in with invalid credentials")
    public void iLogInWithInvalidCredentials() {
        loginPage.login(
                ConfigReader.get("ui.invalid.username"),
                ConfigReader.get("ui.invalid.password"));
    }

    @Then("I should see the Products page")
    public void iShouldSeeTheProductsPage() {
        String actualTitle = loginPage.getProductsTitle();
        String expectedTitle = "Products";

        Assert.assertEquals(
                actualTitle,
                expectedTitle,
                "Expected Products page title to be '" + expectedTitle + "' but found '" + actualTitle + "'.");
    }

    @Then("I should see the expected login error")
    public void iShouldSeeTheExpectedLoginError() {
        String actualError = loginPage.getLoginErrorMessage();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(
                actualError,
                expectedError,
                "Expected login error to be '" + expectedError + "' but found '" + actualError + "'.");
    }
}
