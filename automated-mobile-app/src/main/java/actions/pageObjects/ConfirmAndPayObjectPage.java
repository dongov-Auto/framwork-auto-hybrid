package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pageUIs.ConfirmAndPayPageUI;
import pageUIs.GlobalUI;
import pageUIs.HomePageUI;

public class ConfirmAndPayObjectPage extends BasePageMobile {
    public ConfirmAndPayObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
    @Step("Scroll to privacy policy checkbox")
    public void scrollToFindElement() {
        sleepInSecond(1);
        scrollDown();
        sleepInSecond(1);
        scrollDown();
    }
    @Step("Click to renewal criteria checkbox")
    public void clickToRenewalCriteriaCheckbox() {
        waitForElementVisible(ConfirmAndPayPageUI.RENEWAL_CRITERIA_CHECKBOX);
        clickToElement(ConfirmAndPayPageUI.RENEWAL_CRITERIA_CHECKBOX);
    }
    @Step("Don't click to checkout button")
    public boolean then_Verify_CheckOut_Not_Click() {
        return isElementUndisplayed(ConfirmAndPayPageUI.CHECK_OUT_BUTTON);
    }
    @Step("Click to privacy policy checkbox")
    public void clickToPrivacyPolicyCheckbox() {
        waitForElementVisible(ConfirmAndPayPageUI.PRIVACY_POLICY_CHECKBOX);
        clickToElement(ConfirmAndPayPageUI.PRIVACY_POLICY_CHECKBOX);

    }
    @Step("Click to CheckOut Button")
    public MyRoadTaxStoreObjectPage clickToCheckoutButton() {
        sleepInSecond(1);
        clickToElement(GlobalUI.RELOAD_BUTTON);
        waitForElementClickable(ConfirmAndPayPageUI.CHECK_OUT_BUTTON);
        clickToElement(ConfirmAndPayPageUI.CHECK_OUT_BUTTON);
        return PageGeneratorManager.given_my_road_tax_store_Page(appiumDriver);
    }
}
