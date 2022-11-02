package actions.prepareCondition;

import actions.commons.BaseTestMobile;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.HomePageObjectPage;
import actions.pageObjects.RoadTaxObjectPage;
import org.testng.Assert;

import static actions.commons.GlobalData.APPIUM_DRIVER;

public class GoToRoadTaxPageSteps extends BaseTestMobile {
    private HomePageObjectPage homePagePage;
    private RoadTaxObjectPage roadTaxPage;

    public void prepareGoToRoadTaxPage(){
        homePagePage = PageGeneratorManager.given_Get_Home_Page(APPIUM_DRIVER);
        homePagePage.when_Click_To_Content_Card();
        Assert.assertTrue(homePagePage.then_Verify_Welcome_To_Setel_Displayed());
        homePagePage.when_Scroll_To_Fuel_Subsidy_Button();
        Assert.assertTrue(homePagePage.then_Verify_Mini_Card_Displayed());
        roadTaxPage = homePagePage.when_Click_To_Road_Tax_Button();
        Assert.assertTrue(roadTaxPage.then_Verify_Road_Tax_Displayed());
    }
}
