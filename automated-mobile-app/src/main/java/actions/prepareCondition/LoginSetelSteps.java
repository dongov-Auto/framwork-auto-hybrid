package actions.prepareCondition;

import actions.commons.BaseTestMobile;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.ChooseLanguageObjectPage;
import actions.pageObjects.HomePageObjectPage;
import actions.pageObjects.LoginObjectPage;
import org.testng.Assert;

import static actions.commons.GlobalData.APPIUM_DRIVER;
import static actions.commons.GlobalData.Login.MOBILENUMBER;
import static actions.commons.GlobalData.Login.PIN;

public class LoginSetelSteps extends BaseTestMobile {
    private ChooseLanguageObjectPage chooseLanguagePage;
    private LoginObjectPage loginPage;
    private HomePageObjectPage homePagePage;

    public void prepareLogin(){
        chooseLanguagePage = PageGeneratorManager.given_Get_Choose_Language_Page(APPIUM_DRIVER);
        loginPage = chooseLanguagePage.when_Choose_English_Language();
        Assert.assertTrue(loginPage.then_Verify_Mobile_Number_Displayed());
        loginPage.when_Click_To_Your_Mobile_Number_TextBox();
        loginPage.when_Input_To_Your_Mobile_Number(MOBILENUMBER);
        loginPage.when_Click_To_Continue();
        homePagePage = loginPage.when_Input_To_OPT(PIN);
        Assert.assertTrue(homePagePage.then_Verify_Enable_Location());
        homePagePage.when_Click_To_Enable_Location();
        homePagePage.when_Click_To_Allow_Button();
        Assert.assertTrue(homePagePage.then_Verify_Content_Box_Displayed());
    }
}
