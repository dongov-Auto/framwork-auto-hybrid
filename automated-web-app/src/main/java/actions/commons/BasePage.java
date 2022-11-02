package actions.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected final WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void openPageUrl(String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode() {
        return driver.getPageSource();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    public void forwardToPage() {
        driver.navigate().forward();
    }

    public void refreshCurrentPage() {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence() {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitForAlertPresence().accept();
    }

    public void cancelAlert() {
        waitForAlertPresence().dismiss();
    }

    public String getAlertText() {
        return waitForAlertPresence().getText();
    }

    public void sendKeyToAlert(String textValue) {
        waitForAlertPresence().sendKeys(textValue);
    }

    public void switchToWindowByID(String windowID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);
            }
        }
    }

    public void switchToWindowByTitle(String tabTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(tabTitle)) {
                break;
            }
        }
    }

    public void closeAllTabWithoutParent(String parentID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support.");
        }
        return by;
    }

    private String getDynamicXpath(String locatorType, String... dynamicValues) {
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        }
        return locatorType;
    }

    private WebElement getWebElement(String xpathLocator) {
        return driver.findElement(getByLocator(xpathLocator));
    }

    public List<WebElement> getListWebElement(String xpathLocator) {
        return driver.findElements(getByLocator(xpathLocator));
    }
    public List<WebElement> getListWebElement(String xpathLocator, String... dynamicValues) {
        return driver.findElements(getByLocator(getDynamicXpath(xpathLocator, dynamicValues)));
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
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

    public void clickToElement(String xpathLocator) {
        getWebElement(xpathLocator).click();
    }

    public void clickToElement(String xpathLocator, String... dynamicValues) {
        getWebElement(getDynamicXpath(xpathLocator, dynamicValues)).click();
    }

    public void sendKeyToElement(String xpathLocator, String textValue) {
        WebElement element = getWebElement(xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public void sendKeyToElement(String xpathLocator, String textValue, String... dynamicValues) {
        WebElement element = getWebElement(getDynamicXpath(xpathLocator, dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }

    public void selectItemInDefaultDropDown(String xpathLocator, String textItem) {
        Select select = new Select(getWebElement(xpathLocator));
        select.selectByVisibleText(textItem);
    }

    public void selectItemInDefaultDropDown(String xpathLocator, String textItem, String... dynamicValues) {
        Select select = new Select(getWebElement(getDynamicXpath(xpathLocator, dynamicValues)));
        select.selectByVisibleText(textItem);
    }

    public String getSelectedItemDefaultDropdown(String xpathLocator) {
        Select select = new Select(getWebElement(xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedItemDefaultDropdown(String xpathLocator, String... dynamicValues) {
        Select select = new Select(getWebElement(getDynamicXpath(xpathLocator, dynamicValues)));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(String xpathLocator) {
        Select select = new Select(getWebElement(xpathLocator));
        return select.isMultiple();
    }

    public boolean isDropdownMultiple(String xpathLocator, String... dynamicValues) {
        Select select = new Select(getWebElement(getDynamicXpath(xpathLocator, dynamicValues)));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(String parentXpath, String childXpath, String expectedTextItem) {
        getWebElement(parentXpath).click();
        sleepInSecond(1);
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedTextItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementAttribute(String xpathLocator, String attributeName) {
        return getWebElement(xpathLocator).getAttribute(attributeName);
    }
    public String getElementAttribute(String xpathLocator, String attributeName, String... dynamicValues) {
        return getWebElement(getDynamicXpath(xpathLocator, dynamicValues)).getAttribute(attributeName);
    }

    public String getElementText(String xpathLocator) {
        return getWebElement(xpathLocator).getText();
    }

    public String getElementText(String xpathLocator, String... dynamicValues) {
        return getWebElement(getDynamicXpath(xpathLocator, dynamicValues)).getText();
    }

    public String getElementCssValue(String xpathLocator, String propertyName) {
        return getWebElement(xpathLocator).getCssValue(propertyName);
    }

    public String getHeXaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(String xpathLocator) {
        return getListWebElement(xpathLocator).size();
    }

    public int getElementSize(String xpathLocator, String... dynamicValues) {
        return getListWebElement(getDynamicXpath(xpathLocator, dynamicValues)).size();
    }

    public void checkToDefaultCheckboxRadio(String xpathLocator) {
        WebElement element = getWebElement(xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToDefaultCheckboxRadio(String xpathLocator, String... dynamicValues) {
        WebElement element = getWebElement(getDynamicXpath(xpathLocator, dynamicValues));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckbox(String xpathLocator) {
        WebElement element = getWebElement(xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckbox(String xpathLocator, String... dynamicValues) {
        WebElement element = getWebElement(getDynamicXpath(xpathLocator, dynamicValues));
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(String xpathLocator) {
        try {
            return getWebElement(xpathLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(String xpathLocator, String... dynamicValues) {
        try {
            return getWebElement(getDynamicXpath(xpathLocator, dynamicValues)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementEnabled(String xpathLocator) {
        try {
            return getWebElement(xpathLocator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementEnabled(String xpathLocator, String... dynamicValues) {
        try {
            return getWebElement(getDynamicXpath(xpathLocator, dynamicValues)).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementSelected(String xpathLocator) {
        try {
            return getWebElement(xpathLocator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementSelected(String xpathLocator, String... dynamicValues) {
        try {
            return getWebElement(getDynamicXpath(xpathLocator, dynamicValues)).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public void switchToFrameIframe(String xpathLocator) {
        driver.switchTo().frame(getWebElement(xpathLocator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(String xpathLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(xpathLocator)).perform();
    }

    public void scrollToBottomPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(xpathLocator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void highlightElement(String xpathLocator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(getDynamicXpath(xpathLocator, dynamicValues));
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(locator));
    }

    public void clickToElementByJS(String locator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(getDynamicXpath(locator, dynamicValues)));
    }

    public void scrollToElement(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(locator));
    }

    public void scrollToElement(String locator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(getDynamicXpath(locator, dynamicValues)));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(getDynamicXpath(locator, dynamicValues)));
    }

    public boolean areJQueryAndJSLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public boolean isImageLoaded(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(locator));
        if (status) {
            return true;
        }
        return false;
    }

    public boolean isImageLoaded(String locator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(getDynamicXpath(locator, dynamicValues)));
        if (status) {
            return true;
        }
        return false;
    }

    public void waitForElementVisible(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 15);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathLocator)));
    }

    public void waitForElementVisible(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 15);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(xpathLocator, dynamicValues))));
    }

    public void waitForAllElementVisible(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(xpathLocator)));
    }

    public void waitForAllElementVisible(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(xpathLocator, dynamicValues))));
    }

    public void waitForElementInvisible(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathLocator)));
    }

    public void waitForElementUndisplayed(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
        overrideImplicitTimeout(shortTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathLocator)));
        overrideImplicitTimeout(longTimeout);
    }

    public void waitForElementInvisible(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(xpathLocator, dynamicValues))));
    }

    public void waitForAllElementInvisible(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(xpathLocator)));
    }

    public void waitForAllElementInvisible(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(getDynamicXpath(xpathLocator, dynamicValues))));
    }

    public void waitForElementClickable(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(xpathLocator)));
    }

    public void waitForElementClickable(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        System.out.println(getDynamicXpath(xpathLocator, dynamicValues));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(xpathLocator, dynamicValues))));
    }


    public boolean isElementUndisplayed(String locator) {
        overrideImplicitTimeout(shortTimeout);
        List<WebElement> elements = getListWebElement(locator);
        overrideImplicitTimeout(longTimeout);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String getElementValueByJsXpath(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        locator = locator.replace("xpath=", "");
        return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + locator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
    }
    public String getElementValueByJsXpath(String xpathLocator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String  locator = getDynamicXpath(xpathLocator, dynamicValues).replace("xpath=", "").trim();
        System.out.println("tét: " + (getDynamicXpath(xpathLocator, dynamicValues)));
        System.out.println("loca: " + locator);

        return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + locator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
    }

    public Set<Cookie> getAllCookies() {
        return driver.manage().getCookies();
    }

    public void overrideImplicitTimeout(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    private final long longTimeout = GlobalConstants.LONG_TIMEOUT;
    public final long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

    public void setCookies(Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(2);
    }
}
