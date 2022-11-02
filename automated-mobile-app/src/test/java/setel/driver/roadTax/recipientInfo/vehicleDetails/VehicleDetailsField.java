package setel.driver.roadTax.recipientInfo.vehicleDetails;

import actions.commons.BaseTestMobile;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.*;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import actions.prepareCondition.GoToRoadTaxPageSteps;
import actions.prepareCondition.LoginSetelSteps;
import org.testng.annotations.Test;

import static actions.commons.GlobalData.APPIUM_DRIVER;

public class VehicleDetailsField extends BaseTestMobile {
    private RoadTaxObjectPage roadTaxPage;
    private VehicleDetailsObjectPage vehicleDetailsPage;
    @BeforeClass()
    public void beforeClass(){
        APPIUM_DRIVER = getDriver();
        LoginSetelSteps loginSetelSteps = new LoginSetelSteps();
        loginSetelSteps.prepareLogin();
        GoToRoadTaxPageSteps stepGoTo =new GoToRoadTaxPageSteps();
        stepGoTo.prepareGoToRoadTaxPage();

    }
    @Test(description = "APP | Vehicle info | Vehicle details | ",groups = "regression")
    @Description("Verify UI of Vehicle details page without selected vehicle type")
    public void DRV_69_70_Verify_User_Can_Click_Renewal_Criteria_Link(){
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);

    }
}
