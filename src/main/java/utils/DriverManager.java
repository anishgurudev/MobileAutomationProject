package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AppiumDriver driver;

    private DriverManager() {}  // Private constructor to prevent object creation

    public static AppiumDriver getDriver(String platform) throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();

            if (platform.equalsIgnoreCase("Android")) {
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");  // Change as per your device
                caps.setCapability("app", System.getProperty("user.dir") + "/apps/AndroidApp.apk");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            } else if (platform.equalsIgnoreCase("iOS")) {
                caps.setCapability("platformName", "iOS");
                caps.setCapability("deviceName", "iPhone Simulator");
                caps.setCapability("app", System.getProperty("user.dir") + "/apps/iOSApp.app");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
