package actions.commons;

import actions.pageObjects.setel.AskedQuestionsObjectPage;
import actions.pageObjects.setel.HomeSetelObjectPage;
import actions.pageObjects.setel.LoginSetelObjectPage;
import org.openqa.selenium.WebDriver;

public class PageGeneratorSetelManager {
    public static AskedQuestionsObjectPage getAskQuestionPage(WebDriver driver){
        return new AskedQuestionsObjectPage(driver);
    }
    public static HomeSetelObjectPage getHomePage(WebDriver driver){
        return new HomeSetelObjectPage(driver);
    }
    public static LoginSetelObjectPage getLoginPage(WebDriver driver){
        return new LoginSetelObjectPage(driver);
    }

}
