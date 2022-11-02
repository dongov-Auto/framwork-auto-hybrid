package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pageUIs.HomePageUI;

public class HomePageObjectPage extends BasePageMobile {
    public HomePageObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
    @Step("Verify 'Enable Location' is displayed")
    public boolean then_Verify_Enable_Location() {
        waitForElementVisible(HomePageUI.ENABLE_LOCATION_BUTTON);
        return isElementDisplayed(HomePageUI.ENABLE_LOCATION_BUTTON);
    }
    @Step("Click to Enable Location")
    public void when_Click_To_Enable_Location() {
        waitForElementClickable(HomePageUI.ENABLE_LOCATION_BUTTON);
        clickToElement(HomePageUI.ENABLE_LOCATION_BUTTON);
    }
    @Step("Click to Allow button")
    public void when_Click_To_Allow_Button() {
        waitForElementClickable(HomePageUI.ALLOW_BUTTON);
        clickToElement(HomePageUI.ALLOW_BUTTON);
    }
    @Step("Verify 'Content first box' is displayed")
    public boolean then_Verify_Content_Box_Displayed() {
        waitForElementClickable(HomePageUI.CONTENT_DRAG_HANDLE_BUTTON);
        return isElementDisplayed(HomePageUI.CONTENT_DRAG_HANDLE_BUTTON);
    }
    @Step("Scroll to fuel subsidy button")
    public void when_Scroll_To_Fuel_Subsidy_Button() {
        sleepInSecond(1);
        scrollToElement(HomePageUI.FUEL_SUBSIDY_BUTTON);
    }
    @Step("Click to content drag")
    public void when_Click_To_Content_Card() {
        sleepInSecond(3);
        waitForElementClickable(HomePageUI.CONTENT_DRAG_HANDLE_BUTTON);
        clickToElement(HomePageUI.CONTENT_DRAG_HANDLE_BUTTON);
        sleepInSecond(1);
        clickToElement(HomePageUI.CONTENT_DRAG_HANDLE_BUTTON);
    }
    @Step("Verify title 'Welcome to Setel' is displayed")
    public boolean then_Verify_Welcome_To_Setel_Displayed() {
        waitForElementVisible(HomePageUI.WELCOM_TO_SETEL_LABEL);
        return isElementDisplayed(HomePageUI.WELCOM_TO_SETEL_LABEL);
    }
    @Step("Verify title 'Mini card' is displayed")
    public boolean then_Verify_Mini_Card_Displayed() {
        waitForElementVisible(HomePageUI.MINI_APP_SCREEN);
        return isElementDisplayed(HomePageUI.MINI_APP_SCREEN);
    }

    @Step("Click to Road Tax button")
    public RoadTaxObjectPage when_Click_To_Road_Tax_Button() {
        waitForElementClickable(HomePageUI.MINI_APP_SCREEN);
        swipeFindElementFromRightToLeft(HomePageUI.MINI_APP_SCREEN,HomePageUI.ROAD_TAX_BUTTON);
        return PageGeneratorManager.given_Get_Road_Tax_Page(appiumDriver);
    }
}
