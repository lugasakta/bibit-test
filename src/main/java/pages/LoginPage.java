package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "menuIV")
    private AndroidElement viewSideMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    private AndroidElement textLogin;

    @AndroidFindBy(id = "nameET")
    private AndroidElement usernameField;

    @AndroidFindBy(id = "passwordET")
    private AndroidElement passwordField;

    @AndroidFindBy(id = "loginBtn")
    private AndroidElement loginButton;

    @AndroidFindBy(id = "mTvTitle")
    private AndroidElement homepageTitle;

    public void goToLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(viewSideMenu));
        viewSideMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(textLogin));
        textLogin.click();
        new LoginPage(driver);
    }

    public void inputCredentials() {
        usernameField.click();
        usernameField.sendKeys("test");
        passwordField.click();
        passwordField.sendKeys("test");
        new LoginPage(driver);
    }

    public void clickLoginButton() {
        loginButton.click();
        new LoginPage(driver);
    }

    public void validateHomepage() {
        homepageTitle.isDisplayed();
        new LoginPage(driver);
    }
}
