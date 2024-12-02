package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected AndroidDriver androidDriver;
    private AppiumDriverLocalService service;

    protected void preparation() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("deviceName", "RRCX104JN7M"); // Ganti sesuai adb devices
        capabilities.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
        capabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        capabilities.setCapability("app", "/Users/lugasaktafrimanda/Downloads/mda-2.2.0-25.apk");
        capabilities.setCapability("fullReset", "true");
        capabilities.setCapability("adbExecTimeout", "500000");
        capabilities.setCapability("newCommandTimeout", "6000");

        try {
            service = AppiumDriverLocalService.buildDefaultService();
            System.out.println("Starting Appium server...");
            service.start();
        } catch (Exception e) {
            System.out.println("Failed to start Appium Server: " + e.getMessage());
            throw e;
        }

        String service_url = service.getUrl().toString();
        System.out.println("Appium Service Address: " + service_url);

        androidDriver = new AndroidDriver(new URL(service_url), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void stopServer() {
        if (service != null && service.isRunning()) {
            System.out.println("Stopping Appium server...");
            service.stop();
        }
    }
}
