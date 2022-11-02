package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageUIs.YourOrderFailedPageUI;

public class YourOrderFailedObjectPage extends BasePageMobile {
    public YourOrderFailedObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
    public ConfirmAndPayObjectPage when_click_to_try_again() {
        waitForElementClickable(YourOrderFailedPageUI.TRY_AGAIN_BUTTON);
        clickToElement(YourOrderFailedPageUI.TRY_AGAIN_BUTTON);
        return PageGeneratorManager.given_Confirm_Pay_Page(appiumDriver);
    }
    public RoadTaxObjectPage when_click_to_return_to_home_page() {
        waitForElementClickable(YourOrderFailedPageUI.RETURN_TO_HOME_PAGE_BUTTON);
        clickToElement(YourOrderFailedPageUI.RETURN_TO_HOME_PAGE_BUTTON);
        return PageGeneratorManager.given_Get_Road_Tax_Page(appiumDriver);
    }

    public boolean then_verify_your_order_failed_screen_displayed() {
        waitForElementVisible(YourOrderFailedPageUI.RETURN_TO_HOME_PAGE_BUTTON);
        return isElementDisplayed(YourOrderFailedPageUI.YOUR_ORDER_FAILED_TITLE);
    }
}
