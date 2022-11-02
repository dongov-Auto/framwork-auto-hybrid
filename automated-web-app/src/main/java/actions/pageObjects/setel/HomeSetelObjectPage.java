package actions.pageObjects.setel;

import actions.commons.BasePage;
import actions.commons.PageGeneratorSetelManager;
import org.openqa.selenium.WebDriver;

import static pageUIs.setel.HomeSetelPageUI.FAQ_BUTTON;

public class HomeSetelObjectPage extends BasePage {
    private WebDriver driver;

    public HomeSetelObjectPage(WebDriver driver) {
        super(driver);
    }

    public AskedQuestionsObjectPage clickToFAQ() {
        waitForElementClickable(FAQ_BUTTON);
        clickToElement(FAQ_BUTTON);
        return PageGeneratorSetelManager.getAskQuestionPage(driver);
    }
}
