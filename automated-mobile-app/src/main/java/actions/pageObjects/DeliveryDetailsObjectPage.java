package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageUIs.DeliveryDetailsPageUI;

public class DeliveryDetailsObjectPage extends BasePageMobile {
    public DeliveryDetailsObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public ConfirmAndPayObjectPage clickToContinue() {
        waitForElementVisible(DeliveryDetailsPageUI.CONTINUE_BUTTON);
        waitForElementClickable(DeliveryDetailsPageUI.CONTINUE_BUTTON);
        clickToElement(DeliveryDetailsPageUI.CONTINUE_BUTTON);
        return PageGeneratorManager.given_Confirm_Pay_Page(appiumDriver);
    }
}
