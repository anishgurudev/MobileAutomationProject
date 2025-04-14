package listeners;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Listeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) BaseTest.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = String.valueOf(new Date().getTime());
        String testName = result.getName();

        try {
            FileUtils.copyFile(src, new File("screenshots/" + testName + "_" + timestamp + ".png"));
            System.out.println("📸 Screenshot saved for failed test: " + testName);
        } catch (IOException e) {
            System.out.println("⚠️ Failed to save screenshot: " + e.getMessage());
        }
    }

    // Other overrides (optional)...
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
}
