package setel.driver.roadTax.homePage;

import actions.commons.BaseTestMobile;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.*;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import actions.prepareCondition.GoToRoadTaxPageSteps;
import actions.prepareCondition.LoginSetelSteps;

import static actions.commons.GlobalData.APPIUM_DRIVER;

public class HowItWorkField extends BaseTestMobile {
    private RoadTaxObjectPage roadTaxPage;
    private HowItWorkObjectPage howItWorkPage;
    @BeforeClass()
    public void beforeClass(){
        APPIUM_DRIVER = getDriver();
        LoginSetelSteps loginSetelSteps = new LoginSetelSteps();
        GoToRoadTaxPageSteps stepGoTo =new GoToRoadTaxPageSteps();
        loginSetelSteps.prepareLogin();
        stepGoTo.prepareGoToRoadTaxPage();
    }
    @Test(description = "APP | Home page | How it works |",groups = "regression")
    @Description("Verify user can click the renewal criteria link on Can I renew my road tax? Card")
    public void DRV_69_70_Verify_User_Can_Click_Renewal_Criteria_Link(){
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        howItWorkPage = roadTaxPage.when_Click_To_How_It_Works_Link();
        Assert.assertTrue(howItWorkPage.then_Verify_Renewal_Criteria_Link_Displayed());
        howItWorkPage.when_Click_To_Renewal_Criteria_Link();
        Assert.assertTrue(howItWorkPage.then_Verify_Renewal_Criteria_Screen_Displayed());
        howItWorkPage.when_Click_Close_Button();
        Assert.assertFalse(howItWorkPage.then_Verify_Renewal_Criteria_Screen_Un_Displayed());
        roadTaxPage = howItWorkPage.and_Open_Road_Tax_Screen();
        Assert.assertTrue(roadTaxPage.then_Verify_Road_Tax_Displayed());
    }
    @Test(description = "APP | Home page | How it works |",groups = "regression")
    @Description("Verify user can click on HOW IT WORKS link to view steps at the bottom sheet")
    public void DRV_68_Verify_User_Can_Click_On_HOW_IT_WORKS_Link(){
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        howItWorkPage = roadTaxPage.when_Click_To_How_It_Works_Link();
        Assert.assertTrue(howItWorkPage.then_Verify_How_It_Work_Screen_Displayed());
        Assert.assertTrue(howItWorkPage.then_Verify_Need_Help_Link_Displayed());
        Assert.assertTrue(howItWorkPage.then_Verify_Close_Button_Displayed());
        Assert.assertTrue(howItWorkPage.then_Verify_Renewal_Criteria_Link_Displayed());
        roadTaxPage = howItWorkPage.and_Open_Road_Tax_Screen();
        Assert.assertTrue(roadTaxPage.then_Verify_Road_Tax_Displayed());
    }

}
