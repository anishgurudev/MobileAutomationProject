package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestListener implements ITestListener {
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
        result.setAttribute("extentTest", test); // store it for use in test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed: " + result.getThrowable());
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

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}

