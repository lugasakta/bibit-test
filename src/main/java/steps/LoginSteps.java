package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {
    private AppiumDriver driver;
    private LoginPage loginPage;

    @Before()
    public void setup() throws Exception {
        preparation();
    }

    @Given("^User go to login page$")
    public void userLogin() throws Throwable {
        loginPage.goToLoginPage();
    }

    @And("^User input credentials$")
    public void userInputCredentials() throws Throwable {
        loginPage.inputCredentials();
    }

    @When("^User click login$")
    public void clickLoginButton() throws Throwable {
        loginPage.clickLoginButton();
    }

    @Then("^User will be redirect to homepage$")
    public void isOnHomepage() throws Throwable {
        loginPage.validateHomepage();
    }
}
