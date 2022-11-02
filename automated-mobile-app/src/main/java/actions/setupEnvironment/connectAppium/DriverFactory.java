package actions.setupEnvironment.connectAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {
    private AppiumDriver<MobileElement> appiumDriver;
    public AppiumDriver<MobileElement> getDriver(Platforms platformName, String udid, String platformVersion) {
        if (appiumDriver == null) {
            if (platformName == null) {
                throw new IllegalArgumentException("Platform can't be null, you can provide one of these: "
                        + Arrays.toString(Platforms.values()));
            }
            Exception exception = null;
            try {
                DesiredCapabilities desiredCaps = new DesiredCapabilities();
                URL targetServer = new URL("http://localhost:4723/wd/hub");
                String hubEnvVar = System.getProperty("hub");
                String hubUrl = hubEnvVar != null ? hubEnvVar : System.getenv("hub");
                if(hubUrl != null) {
                    System.out.println("[INFO] Running test in remote mode!");
                    targetServer = new URL(hubUrl + ":4444/wd/hub");
                }
                switch (platformName) {
                    case ANDROID:
                        desiredCaps.setCapability(PLATFORM_NAME, platformName);
                        desiredCaps.setCapability(AUTOMATION_NAME, "uiautomator2");
                        desiredCaps.setCapability(UDID, udid);
                        desiredCaps.setCapability(APP_PACKAGE, "com.setel.mobile.dev");
                        desiredCaps.setCapability(APP_ACTIVITY, "com.zapmobile.zap.splash.SplashActivity");
//                        desiredCaps.setCapability(NO_RESET,true);
                        appiumDriver = new AndroidDriver<>(targetServer, desiredCaps);
                        break;
                    case IOS:
                        desiredCaps.setCapability(PLATFORM_NAME, platformName);
                        desiredCaps.setCapability(AUTOMATION_NAME, "XCUITest");
                        desiredCaps.setCapability(DEVICE_NAME, udid);
                        desiredCaps.setCapability(PLATFORM_VERSION, platformVersion); // 15.1 NOT 15.1.2
                        desiredCaps.setCapability(BUNDLE_ID, "com.setel.mobile.dev");
                        appiumDriver = new IOSDriver<>(targetServer, desiredCaps);
                }
            } catch (Exception e) {
                exception = e;
            }
            if (appiumDriver == null) {
                throw new RuntimeException(exception.getMessage());
            }
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return appiumDriver;
    }
    public void quitAppiumDriver(){
        if (appiumDriver != null){
            appiumDriver.quit();
            appiumDriver = null;
        }
    }

}
