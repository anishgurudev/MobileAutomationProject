package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("anish", "password123");
    }
}
