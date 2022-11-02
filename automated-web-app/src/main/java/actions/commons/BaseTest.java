package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected final Log log;

    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    public WebDriver getDriverInstance() {
        return this.driver;
    }

    protected WebDriver getBrowserDriver(String browserDriver) {
        if (browserDriver.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
//            disable-logging
            System.getProperty("webdriver.chrome.args", "--disable-logging");
            System.getProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions options = new ChromeOptions();
            // Setup lang for browser
            options.addArguments("--lang=vi");
            // Disable developer popup
            options.addArguments("--disable-infobars");
            // Disable notifications popup
            options.addArguments("--disable-notifications");
            // Disable location popup
            options.addArguments("--disable-geolocation");
            // Disable Automation info Bar popup
            options.setExperimentalOption("useAutomationExtension",false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            // Save password in chrome
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service",false);
            prefs.put("profile.password_manager_enabled",false);
            options.setExperimentalOption("prefs",prefs);
            // Auto save file download
            prefs.put("profile.default_content_settings.popups",0);
            prefs.put("download.default_directory",GlobalConstants.PROJECT_PATH + "\\downloadFile");
            options.setExperimentalOption("prefs",prefs);
            driver = new ChromeDriver(options);
        } else if (browserDriver.equals("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserDriver.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
//            print-logging-to-file
            System.getProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.getProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");
//            Setup lang for browser
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
            driver = new FirefoxDriver(options);
        } else if (browserDriver.equals("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if (browserDriver.equals("coccoc")) {
            WebDriverManager.chromedriver().driverVersion("102.0.5005.61").setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser name invalid.");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(GlobalConstants.USER_PAGE_URL);
        driver.manage().window().maximize();
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserDriver, String appURL) {
        if (browserDriver.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserDriver.equals("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if (browserDriver.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserDriver.equals("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserDriver.equals("coccoc")) {
            WebDriverManager.chromedriver().driverVersion("102.0.5005.61").setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser name invalid.");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(appURL);
        driver.manage().window().maximize();
        return driver;

    }

    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                System.out.println(" -------------------------- PASSED -------------------------- ");
            } else {
                System.out.println(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                System.out.println(" -------------------------- PASSED -------------------------- ");
            } else {
                System.out.println(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            System.out.println(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            System.out.println(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected void closeBrowserAndDriver() {
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }

            if (driver != null) {
                // IE
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

    public int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }
}