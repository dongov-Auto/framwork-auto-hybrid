package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pageUIs.HowItWorkUI;

public class HowItWorkObjectPage extends BasePageMobile {
    public HowItWorkObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
    @Step("Verify 'How it work' screen is displayed")
    public boolean then_Verify_How_It_Work_Screen_Displayed() {
        waitForElementVisible(HowItWorkUI.HOW_IT_WORKS_TITLE);
        return isElementDisplayed(HowItWorkUI.HOW_IT_WORKS_TITLE);
    }
    @Step("Verify 'Close' button is displayed")
    public boolean then_Verify_Close_Button_Displayed() {
        waitForElementVisible(HowItWorkUI.CLOSE_BUTTON);
        return isElementDisplayed(HowItWorkUI.CLOSE_BUTTON);
    }
    @Step("Verify 'Need help?' link is displayed")
    public boolean then_Verify_Need_Help_Link_Displayed() {
        waitForElementVisible(HowItWorkUI.NEED_HELP_CHAT_WITH_US_NOW_LINK);
        return isElementDisplayed(HowItWorkUI.NEED_HELP_CHAT_WITH_US_NOW_LINK);
    }
    @Step("Verify 'Renewal criteria' link is displayed")
    public boolean then_Verify_Renewal_Criteria_Link_Displayed() {
        waitForElementVisible(HowItWorkUI.RENEWAL_CRITERIA_LINK);
        return isElementDisplayed(HowItWorkUI.RENEWAL_CRITERIA_LINK);
    }
    @Step("Open Road Tax Screen")
    public RoadTaxObjectPage and_Open_Road_Tax_Screen() {
        waitForElementClickable(HowItWorkUI.CLOSE_BUTTON);
        clickToElement(HowItWorkUI.CLOSE_BUTTON);
        return PageGeneratorManager.given_Get_Road_Tax_Page(appiumDriver);
    }
    @Step("Click Close button")
    public void when_Click_Close_Button() {
        waitForElementClickable(HowItWorkUI.CLOSE_BUTTON);
        clickToElement(HowItWorkUI.CLOSE_BUTTON);
    }
    @Step("Click on Need help link")
    public void when_Click_To_Need_Help_Link() {
        waitForElementVisible(HowItWorkUI.NEED_HELP_CHAT_WITH_US_NOW_LINK);
        clickToElement(HowItWorkUI.NEED_HELP_CHAT_WITH_US_NOW_LINK);
    }
    @Step("Click on Renewal criteria link")
    public void when_Click_To_Renewal_Criteria_Link() {
        waitForElementVisible(HowItWorkUI.RENEWAL_CRITERIA_LINK);
        clickToElement(HowItWorkUI.RENEWAL_CRITERIA_LINK);
    }
    @Step("Verify Renewal criteria screen is displayed")
    public boolean then_Verify_Renewal_Criteria_Screen_Displayed() {
        waitForElementVisible(HowItWorkUI.RENEWAL_CRITERIA_TITLE);
        return isElementDisplayed(HowItWorkUI.RENEWAL_CRITERIA_TITLE);
    }
    @Step("Verify Renewal criteria screen is undisplayed")
    public boolean then_Verify_Renewal_Criteria_Screen_Un_Displayed() {
        return isElementUndisplayed(HowItWorkUI.RENEWAL_CRITERIA_TITLE);
    }
}
