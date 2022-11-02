package actions.setupEnvironment.allureReport;

import actions.commons.BaseTestMobile;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureTestListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    // Screenshot attachments for Allure
    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public static byte[] saveScreenshotPNG(String testName, AppiumDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        AppiumDriver driver = ((BaseTestMobile) testClass).getDriver();
        saveScreenshotPNG(iTestResult.getName(), driver);
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

}
