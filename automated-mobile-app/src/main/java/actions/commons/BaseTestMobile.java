package actions.commons;

import actions.setupEnvironment.connectAppium.DriverFactory;
import actions.setupEnvironment.connectAppium.Platforms;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.internal.CapabilityHelpers;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class BaseTestMobile {
    private AppiumDriver driver;
    private static final List<DriverFactory> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;
    private String udid;
    private String platformName = System.getProperty("platformName");
    private String platformVersion;
    protected final Log log;
    protected BaseTestMobile(){
        log = LogFactory.getLog(getClass());
    }
    public AppiumDriver<MobileElement> getDriverInstance() {
        return this.driver;
    }
    @BeforeSuite
    public void  initBeforeSuite(){
        deleteAllureReport();
    }
    @BeforeClass(description = "Init appium session")
    @Parameters({"udid", "platformName", "platformVersion"})
    public AppiumDriver<MobileElement> initAppiumSession(String udid,String platformName, @Optional("platformVersion") String platformVersion) {
        this.udid = udid;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        driverThread = ThreadLocal.withInitial(()->{
            DriverFactory driverThread = new DriverFactory();
            driverThreadPool.add(driverThread);
            return driverThread;
        });
        return getDriver();
    }
    @AfterClass(alwaysRun = true, description = "Quit the appium session")
    public void quitAppiumSession() {
        driverThread.get().quitAppiumDriver();
    }
    public AppiumDriver<MobileElement> getDriver() {
        System.out.println("platformName: " + platformName.toUpperCase());
        return driverThread.get().getDriver(Platforms.valueOf(platformName.toUpperCase()), udid, platformVersion);
    }
    @AfterMethod(description = "Capture screenshot")
    public void captureScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String testMethodName = result.getName();
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String dateTaken = y + "-" + m + "-" + d + "-" + hr + "-" + min + "-" + sec;
            AppiumDriver<MobileElement> currentDriverThread = driverThread.get().getDriver(Platforms.valueOf(platformName.toUpperCase()), udid, platformVersion);
            Capabilities caps = currentDriverThread.getCapabilities();
            String currentUDID = CapabilityHelpers.getCapability(caps, "udid", String.class);
            String fileLocation =
                    GlobalConstants.PROJECT_PATH + "/screenshots/" + currentUDID + "-" + testMethodName + "-" + dateTaken + ".png";
            File screenshot = currentDriverThread.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(fileLocation));
                // Get file content then attach to Allure reporter
                Path screenshotContentPath = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(screenshotContentPath);
                Allure.addAttachment(testMethodName + "-" +dateTaken, inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteAllureReport(){
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-results";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i=0;i<listOfFiles.length;i++) {
                if (listOfFiles[i].isFile()) {
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
