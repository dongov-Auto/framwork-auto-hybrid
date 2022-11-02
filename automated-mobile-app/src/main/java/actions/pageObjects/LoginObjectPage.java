package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pageUIs.LoginPageUI;

public class LoginObjectPage extends BasePageMobile {
    private final AppiumDriver driver;

    public LoginObjectPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify 'Enter your mobile number' is displayed")
    public boolean then_Verify_Mobile_Number_Displayed(){
        waitForElementVisible(LoginPageUI.PHONE_NUMBER_TEXTBOX);
        return isElementDisplayed(LoginPageUI.PHONE_NUMBER_TEXTBOX);
    }
    @Step("Input {0} to your mobile number")
    public void when_Input_To_Your_Mobile_Number(String mobileNumber) {
        waitForElementVisible(LoginPageUI.INPUT_PHONE_NUMBER);
        sendKeyToElement(LoginPageUI.INPUT_PHONE_NUMBER,mobileNumber);
        stepHidenKeyBoardAndroid();
    }
    @Step("Click to continue button")
    public void when_Click_To_Continue() {
        waitForElementClickable(LoginPageUI.CONTINUE_BUTTON);
        clickToElement(LoginPageUI.CONTINUE_BUTTON);
    }
    @Step("Click to your mobile number textbox")
    public void when_Click_To_Your_Mobile_Number_TextBox() {
        waitForElementClickable(LoginPageUI.PHONE_NUMBER_TEXTBOX);
        clickToElement(LoginPageUI.PHONE_NUMBER_TEXTBOX);
    }
    @Step("Input {0} code")
    public HomePageObjectPage when_Input_To_OPT(String opt) {
        waitForElementVisible(LoginPageUI.PIN_TEXTBOX);
        sendKeyToElement(LoginPageUI.PIN_TEXTBOX,opt);
        return PageGeneratorManager.given_Get_Home_Page(driver);
    }
}
