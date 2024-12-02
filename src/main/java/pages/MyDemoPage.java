package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MyDemoPage {
    private AppiumDriver driver;

    public MyDemoPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Sauce Lab Back Packs\")]")
    private AndroidElement productText;

    @AndroidFindBy(className = "android.widget.ScrollView")
    private AndroidElement scrollViewProduct;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Displays available colors of selected product\")]/android.view.ViewGroup[2]")
    private AndroidElement blueProductVariant;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Increase item quantity\")]")
    private AndroidElement clickAddItemQuantity;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"noTV\") and (@text=\"2\")]")
    private AndroidElement totalItemQuantity;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Add to cart\")]")
    private AndroidElement addToCartButton;

    @AndroidFindBy(id = "cartRL")
    private AndroidElement iconCart;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Sauce Lab Back Packs\")]")
    private AndroidElement cartProductItemText;

    @AndroidFindBy(id = "cartBt")
    private AndroidElement buttonCartCheckout;

    public MyDemoPage chooseProduct() {
        productText.click();
        return new MyDemoPage(driver);
    }

    public MyDemoPage addProductToCart() {
        blueProductVariant.click();
        clickAddItemQuantity.click();
        totalItemQuantity.isDisplayed();
        addToCartButton.click();
        return new MyDemoPage(driver);
    }

    public MyDemoPage validateProductCartPage() {
        iconCart.click();
        cartProductItemText.isDisplayed();
        return new MyDemoPage(driver);
    }

    public MyDemoPage cartCheckout() {
        buttonCartCheckout.click();
        return new MyDemoPage(driver);
    }
}
