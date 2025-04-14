package pages;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import locators.LoginLocators;

public class LoginPage {

    AppiumDriver driver;

    public LoginPage() {
        this.driver = BaseTest.getDriver();
    }

    public void login(String username, String password) {
        driver.findElement(LoginLocators.usernameField).sendKeys(username);
        driver.findElement(LoginLocators.passwordField).sendKeys(password);
        driver.findElement(LoginLocators.loginBtn).click();
    }
}
