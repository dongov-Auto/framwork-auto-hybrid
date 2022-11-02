package actions.commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.GlobalUI;


import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BasePageMobile {
    protected final AppiumDriver<MobileElement> appiumDriver;
    public BasePageMobile(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public void openPageUrl( String pageUrl){
        appiumDriver.get(pageUrl);
    }
    public String getPageTitle(AppiumDriver driver){
        return appiumDriver.getTitle();
    }
    public String getPageUrl(AppiumDriver driver){
        return appiumDriver.getCurrentUrl();
    }
    public String getPageSourceCode(AppiumDriver driver){
        return appiumDriver.getPageSource();
    }
    public void backToPage(AppiumDriver driver){
        appiumDriver.navigate().back();
    }
    public void forwardToPage(AppiumDriver driver){
        appiumDriver.navigate().forward();
    }
    public void refreshCurrentPage(AppiumDriver driver){
        appiumDriver.navigate().refresh();
    }
    public Alert waitForAlertPresence(AppiumDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(AppiumDriver driver){
        waitForAlertPresence(driver).accept();
    }
    public void cancelAlert(AppiumDriver driver){
        waitForAlertPresence(driver).dismiss();
    }
    public String getAlertText(AppiumDriver driver){
        return waitForAlertPresence(driver).getText();
    }
    public void sendKeyToAlert( String textValue){
        waitForAlertPresence(appiumDriver).sendKeys(textValue);
    }
    public void switchToWindowByID( String windowID){
        Set<String> allWindowIDs = appiumDriver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(windowID)){
                appiumDriver.switchTo().window(id);
            }
        }
    }
    public void switchToWindowByTitle( String tabTitle){
        Set<String> allWindowIDs = appiumDriver.getWindowHandles();
        for (String id : allWindowIDs) {
            appiumDriver.switchTo().window(id);
            String actualTitle = appiumDriver.getTitle();
            if (actualTitle.equals(tabTitle)){
                break;
            }
        }
    }
    public void closeAllTabWithoutParent( String parentID){
        Set<String> allWindowIDs = appiumDriver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(parentID)){
                appiumDriver.switchTo().window(id);
                appiumDriver.close();
            }
        }
    }
    private By getByLocator(String locatorType){
        By by = null;
        if (locatorType.startsWith("id=")||locatorType.startsWith("ID=")||locatorType.startsWith("Id=")) {
            by = MobileBy.id(locatorType.substring(3));
        }else if (locatorType.startsWith("AccessibilityId=")||locatorType.startsWith("accessibilityId=")||locatorType.startsWith("AccessibilityID=")){
            by = MobileBy.AccessibilityId(locatorType.substring(16));
        } else if (locatorType.startsWith("xpath=")||locatorType.startsWith("XPATH=")||locatorType.startsWith("Xpath=")||locatorType.startsWith("XPath=")){
            by =MobileBy.xpath(locatorType.substring(6));
        } else {
            throw  new RuntimeException("Locator type is not support.");
        }
        return by;
    }
    private String getDynamicXpath(String locatorType, String... dynamicValues){
        if (locatorType.startsWith("xpath=")||locatorType.startsWith("XPATH=")||locatorType.startsWith("Xpath=")||locatorType.startsWith("XPath=")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        }
        for(String value: dynamicValues){
        }
        return locatorType;
    }
    public MobileElement getMobileElement(String xpathLocator){
        return appiumDriver.findElement(getByLocator(xpathLocator));
    }
    public List<MobileElement> getListWebElement(String xpathLocator){
        return this.appiumDriver.findElements(getByLocator(xpathLocator));
    }
    public void clickToElement( String xpathLocator){
        getMobileElement(xpathLocator).click();
    }
    public void clickToElement( String xpathLocator, String... dynamicValues){
        getMobileElement(getDynamicXpath(xpathLocator,dynamicValues)).click();
    }
    public void sendKeyToElement( String xpathLocator, String textValue){
        MobileElement element = getMobileElement(xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }
    public void enterToKeyBoardAndroid(){
        Actions action=new Actions(appiumDriver);
        action.sendKeys(Keys.ENTER).build().perform();

    }
    public void sleepInSecond(long time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public String getElementText( String xpathLocator){
        return getMobileElement(xpathLocator).getText();
    }
    public void scrollDown() {

        //The viewing size of the device
        Dimension size = appiumDriver.manage().window().getSize();

        //Starting y location set to 80% of the height (near bottom)
        int starty = (int) (size.height * 0.7);
        //Ending y location set to 20% of the height (near top)
        int endy = (int) (size.height * 0.4);
        //x position set to mid-screen horizontally
        int startx = (size.width / 2);

        scroll(startx, starty, startx, endy);

    }
    public void scrollUp() {

        //The viewing size of the device
        Dimension size = appiumDriver.manage().window().getSize();

        //Starting y location set to 80% of the height (near bottom)
        int starty = (int) (size.height * 0.4);
        //Ending y location set to 20% of the height (near top)
        int endy = (int) (size.height * 0.7);
        //x position set to mid-screen horizontally
        int startx = (size.width / 2);

        scroll(startx, starty, startx, endy);

    }
    public void scroll(int startx, int starty, int endx, int endy) {

        TouchAction touchAction = new TouchAction(appiumDriver);

        touchAction.longPress(PointOption.point(startx, starty))
                .moveTo(PointOption.point(endx, endy))
                .release()
                .perform();

    }
    public boolean isElementDisplayed( String xpathLocator){
        try {
            return getMobileElement(xpathLocator).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
    public boolean isElementDisplayed( String xpathLocator, String... dynamicValues){
        try {
            return getMobileElement(getDynamicXpath(xpathLocator,dynamicValues)).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
    public boolean isElementEnabled( String xpathLocator){
        try {
            return getMobileElement(xpathLocator).isEnabled();
        } catch (Exception e){
            return false;
        }
    }
    public boolean isElementEnabled( String xpathLocator, String... dynamicValues){
        try {
            return getMobileElement(getDynamicXpath(xpathLocator, dynamicValues)).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
    public void hoverMouseToElement(String xpathLocator){
        Actions action = new Actions(appiumDriver);
        action.moveToElement(getMobileElement(xpathLocator)).perform();
    }
    public void scrollFindElement(String xpathLocator){
        MobileElement element = getMobileElement(xpathLocator);
        int startPointX =element.getLocation().getY()/2;
        int endPointX = element.getLocation().getX() + element.getSize().getWidth()/2;
        int anchorY = element.getLocation().getY() + element.getSize().getHeight()/2;
        new TouchAction(appiumDriver)
                .press(PointOption.point(startPointX, anchorY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endPointX, anchorY))
                .release().perform();

    }
    public void scrollToElement(String xpathLocator){
        overrideImplicitTimeout(appiumDriver,shortTimeout);
        List<MobileElement> elements = getListWebElement(xpathLocator);
        Dimension size = appiumDriver.manage().window().getSize();
        int count = 0;
        while (elements.size() == 0 && count < 5) {
            elements =  getListWebElement(xpathLocator);
            if(elements.size() != 0){
                break;
            }
            count++;
           scrollDown();
        }
        overrideImplicitTimeout(appiumDriver,longTimeout);
    }
    public void swipeFindElementFromRightToLeft(String xpathLocator, String findElementLocator){
        overrideImplicitTimeout(appiumDriver,shortTimeout);
        List<MobileElement> elements = getListWebElement(findElementLocator);
        int count = 0;
        while (elements.size() == 0 && count < 5) {
            elements = getListWebElement(findElementLocator);
            if(elements.size() != 0){
                break;
            }
            count++;
            swipeFromRightToLeft(xpathLocator);
        }
        elements.get(0).click();
        overrideImplicitTimeout(appiumDriver,longTimeout);
    }
    public void scrollDownToELement(String xpathLocator){
        overrideImplicitTimeout(appiumDriver,shortTimeout);
        List<MobileElement> elements = getListWebElement(xpathLocator);
        int count = 0;
        while (elements.size() == 0 && count < 5) {
            elements = getListWebElement(xpathLocator);
            System.out.println("scroll: " + elements.size());
            if(elements.size() != 0){
                break;
            }
            count++;
            scrollDown();
        }
        elements.get(0).click();
        overrideImplicitTimeout(appiumDriver,longTimeout);
    }
    public void waitForElementVisible(String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathLocator)));
    }
    public void waitForElementVisible(String xpathLocator, long time){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,time);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathLocator)));
    }
    public void waitForElementVisible( String xpathLocator, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(xpathLocator,dynamicValues))));
    }
    public void waitForAllElementVisible( String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(xpathLocator)));
    }
    public void waitForAllElementVisible( String xpathLocator, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(xpathLocator,dynamicValues))));
    }
    public void waitForElementInvisible( String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathLocator)));
    }
    public void waitForElementUndisplayed( String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,shortTimeout);
        overrideImplicitTimeout(appiumDriver,shortTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathLocator)));
        overrideImplicitTimeout(appiumDriver,longTimeout);
    }
    public void waitForElementInvisible( String xpathLocator, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(xpathLocator,dynamicValues))));
    }
    public void waitForAllElementInvisible( String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements((WebElement) getListWebElement(xpathLocator)));
    }
    @Step("Verify '{0}' message is displayed")
    public boolean then_Verify_Message_Is_Required_Displayed(String messageError) {
        sleepInSecond(1);
        waitForElementVisible(GlobalUI.MESSAGE_REQUIRED,messageError);
        return isElementDisplayed(GlobalUI.MESSAGE_REQUIRED,messageError);
    }
    public void waitForAllElementInvisible( String xpathLocator, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements((WebElement) getListWebElement(getDynamicXpath(xpathLocator,dynamicValues))));
    }
    public void waitForElementClickable(String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(xpathLocator)));
    }
    public void waitForElementClickable( String xpathLocator, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver,longTimeout);
        System.out.println(getDynamicXpath(xpathLocator,dynamicValues));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(xpathLocator,dynamicValues))));
    }
    public boolean isElementUndisplayed(String locator){
        overrideImplicitTimeout(appiumDriver, shortTimeout);
        List<MobileElement> elements = getListWebElement(locator);
        overrideImplicitTimeout(appiumDriver,longTimeout);
        if (elements.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    public void overrideImplicitTimeout(AppiumDriver<MobileElement> appiumDriver, long timeout){
        appiumDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
    public void swipeFromRightToLeft(String elementLocator){
        WebElement element = getMobileElement(elementLocator);
        int startPointX =element.getLocation().getX() + 50;
        int endPointX = element.getLocation().getX() + element.getSize().getWidth() - 56;
        int anchorY = element.getLocation().getY() + element.getSize().getHeight() - 30;
        new TouchAction(appiumDriver)
                .press(PointOption.point(endPointX, anchorY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(startPointX, anchorY))
                .release().perform();
    }
    private static ThreadLocal<Map<Object, Object>> variables = new ThreadLocal<Map<Object, Object>>(){
        protected HashMap initialValue( ) {
            return new HashMap<Object, Object>();
        }
    };
    public void stepChooseRamdonElement(String xpathLocator, String nameElement) {
        List<MobileElement> elementList = getListWebElement(xpathLocator);
        for (int i =0; i<elementList.size(); i++){
            WebElement element = elementList.get(i);
            String filedName = element.getText();
            if(filedName.equals(nameElement)){
                element.click();
                break;
            }
        }
    }
    public void stepHidenKeyBoardAndroid(){
        appiumDriver.hideKeyboard();
    }
    public void stepBackKeyBoardAndroid(){
        ((AndroidDriver<MobileElement>) appiumDriver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
    private final long longTimeout = GlobalConstants.LONG_TIMEOUT;
    public final long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

}
