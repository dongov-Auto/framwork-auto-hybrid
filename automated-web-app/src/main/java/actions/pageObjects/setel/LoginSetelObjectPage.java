package actions.pageObjects.setel;

import actions.commons.BasePage;
import actions.commons.PageGeneratorSetelManager;
import org.openqa.selenium.WebDriver;

import static pageUIs.setel.LoginSetelPageUI.*;

public class LoginSetelObjectPage extends BasePage {

    public LoginSetelObjectPage(WebDriver driver) {
        super(driver);
    }

    public void enterPhoneNumber(String phone) {
        waitForElementClickable(PHONE_INPUT);
        sendKeyToElement(PHONE_INPUT,phone);
    }
    public void clickToContinue() {
        waitForElementClickable(CONTINUE_BUTTON);
        clickToElement(CONTINUE_BUTTON);
    }
    public HomeSetelObjectPage enterPin(String pin) {
        waitForElementClickable(PIN_INPUT);
        sendKeyToElement(PIN_INPUT,pin);
        return PageGeneratorSetelManager.getHomePage(driver);
    }
}
