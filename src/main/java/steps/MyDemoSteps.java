package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.MyDemoPage;

public class MyDemoSteps extends BaseSteps {
    private AppiumDriver driver;
    private MyDemoPage myDemoPage;

    @Before()
    public void setup() throws Exception {
        preparation();
    }

    @Given("^User choose product$")
    public void userChooseProduct() throws Throwable {
        androidDriver.findElementByXPath("//*[contains(@content-desc,\"Sauce Lab Back Packs\")]").click();
    }

    @And("^User change variant to Blue$")
    public void userChooseVariant() throws Throwable {
        androidDriver.findElementByXPath(
                "//*[contains(@content-desc,\"Displays available colors of selected product\")]/android.view.ViewGroup[2]"
        ).click();
        throw new PendingException();
    }

    @And("^User scroll the product detail page$")
    public void scrollProductDetailPage() throws Throwable {
        androidDriver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Add to cart\").instance(0))"
        );
    }

    @And("^User add product to cart$")
    public void addItemQuantity() throws Throwable {
        androidDriver.findElementById("plusIV").click();
        androidDriver.findElementByXPath("//*[contains(@resource-id,\"noTV\") and (@text=\"2\")]").isDisplayed();
        androidDriver.findElementByXPath("//*[contains(@text,\"Add to cart\")]").click();
    }

    @And("^User go to Cart page$")
    public void isOnCartPage() throws Throwable {
        androidDriver.findElementById("cartRL").click();
        androidDriver.findElementByXPath("//*[contains(@text,\"Sauce Lab Back Packs\")]");
    }

    @When("^User checkout from Cart page$")
    public void cartCheckout() throws Throwable {
        androidDriver.findElementById("cartBt").click();
    }

    @Then("^User will be redirected to Login page$")
    public void isOnLoginPage() throws Throwable {
        androidDriver.findElementById("loginBtn").isDisplayed();
    }
}

