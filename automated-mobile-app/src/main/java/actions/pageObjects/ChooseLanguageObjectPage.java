package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pageUIs.ChooseLanguageUI;

public class ChooseLanguageObjectPage extends BasePageMobile {

    public ChooseLanguageObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
    @Step("Choose English language")
    public LoginObjectPage when_Choose_English_Language(){
        waitForElementClickable(ChooseLanguageUI.ENGLISH_LANGUAGE);
        clickToElement(ChooseLanguageUI.ENGLISH_LANGUAGE);
        return PageGeneratorManager.given_get_Login_Page(appiumDriver);
    }
}
