package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pageUIs.MyRoadTaxStorePageUI;

public class MyRoadTaxStoreObjectPage extends BasePageMobile {
    public MyRoadTaxStoreObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
@Step("Click to Setel wallet pay radio")
    public void clickToPayType() {
        waitForElementClickable(MyRoadTaxStorePageUI.PAY_SETEL_WALLET);
        clickToElement(MyRoadTaxStorePageUI.PAY_SETEL_WALLET);
    }

    public void clickToPayButton() {
        waitForElementClickable(MyRoadTaxStorePageUI.PAY_BUTTON);
        clickToElement(MyRoadTaxStorePageUI.PAY_BUTTON);
        sleepInSecond(5);

    }

    public boolean then_verify_my_road_tax_screen_dispalyed() {
        waitForElementVisible(MyRoadTaxStorePageUI.MY_ROAD_TAX_STORE_TITEL);
        waitForElementVisible(MyRoadTaxStorePageUI.PAYMENT_METHOD_TITLE,60);
        return isElementDisplayed(MyRoadTaxStorePageUI.PAYMENT_METHOD_TITLE);
    }

    public YourOrderFailedObjectPage clickToCancelPayment() {
        waitForElementClickable(MyRoadTaxStorePageUI.CANCEL_PAYMENT_BUTTON);
        clickToElement(MyRoadTaxStorePageUI.CANCEL_PAYMENT_BUTTON);
        return PageGeneratorManager.given_your_order_failed_Page(appiumDriver);
    }
}
