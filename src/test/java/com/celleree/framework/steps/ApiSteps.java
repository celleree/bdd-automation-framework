package com.celleree.framework.steps;

import com.celleree.framework.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

/**
 * Step definitions for JSONPlaceholder API scenarios.
 */
public class ApiSteps {

    private Response response;

    @When("I request user {int} from JSONPlaceholder")
    public void iRequestUserFromJSONPlaceholder(int userId) {
        String baseUrl = ConfigReader.get("api.base.url");

        response = given()
                .baseUri(baseUrl)
                .when()
                .get("/users/{id}", userId);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();

        Assert.assertEquals(
                actualStatusCode,
                expectedStatusCode,
                "Expected API status code " + expectedStatusCode + " but found " + actualStatusCode + ".");
    }

    @Then("the response username should be {string}")
    public void theResponseUsernameShouldBe(String expectedUsername) {
        String actualUsername = response.jsonPath().getString("username");

        Assert.assertEquals(
                actualUsername,
                expectedUsername,
                "Expected API username to be '" + expectedUsername + "' but found '" + actualUsername + "'.");
    }
}
