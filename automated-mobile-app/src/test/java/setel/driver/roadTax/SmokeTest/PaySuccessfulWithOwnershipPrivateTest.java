package setel.driver.roadTax.SmokeTest;

import actions.commons.BaseTestMobile;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.*;
import actions.prepareCondition.GoToRoadTaxPageSteps;
import actions.prepareCondition.LoginSetelSteps;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static actions.commons.GlobalData.APPIUM_DRIVER;
import static actions.commons.GlobalData.RoadTaxHomePage.*;
import static actions.commons.GlobalData.VehicleInformation.DEFAULT_SERVICE_FEE;
import static actions.commons.GlobalData.VehicleInformation.SALOON_NAME;

public class PaySuccessfulWithOwnershipPrivateTest extends BaseTestMobile {
    private RoadTaxObjectPage roadTaxPage;
    private VehicleDetailsObjectPage vehicleDetailsPage;
    private ConfirmAndPayObjectPage confirmPayPage;
    private DeliveryDetailsObjectPage deliveryDetailsPage;
    private MyRoadTaxStoreObjectPage myRoadTaxStorePage;
    LoginSetelSteps loginSetelSteps = new LoginSetelSteps();
    GoToRoadTaxPageSteps stepGoTo = new GoToRoadTaxPageSteps();

    @BeforeClass()
    public void beforeClass() {
        APPIUM_DRIVER = getDriver();
    }

    @Test(description = "E2E: APP - Pay for road tax with Hosted checkout", groups = "regression")
    @Description("Verify successful payment when create roadtax order with Ownership = PRIVATE")
    @Story("Pay for road tax with Hosted checkout")
    @TmsLink("DRV-297")
    public void DRV_297_Verify_successful_payment_When_create_roadtax_order_with_Ownership_is_PRIVATE() {
        loginSetelSteps.prepareLogin();
        stepGoTo.prepareGoToRoadTaxPage();
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_E2E);
        roadTaxPage.when_Click_To_Owner_Dropdown();
        roadTaxPage.when_Select_Owner_In_Dropdown(NEW_NRIC);
        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_NEW_NRIC_E2E);
        vehicleDetailsPage = roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertTrue(vehicleDetailsPage.then_Verify_Vehicle_Details_Displayed());
        vehicleDetailsPage.then_Verify_Vehicle_Informations_Displayed();
        vehicleDetailsPage.clickToVehicleType(SALOON_NAME);
        vehicleDetailsPage.clickToCheveronUpIcon();
        Assert.assertTrue(vehicleDetailsPage.then_Verify_Payment_Summart_Displayed());

//        Assert.assertTrue(vehicleDetailsPage.then_Verify_Estimated_Total_price(Estimated road tax price + Service fee + Delivery fee));
        Assert.assertEquals(vehicleDetailsPage.then_Verify_Service_Fee_Default(), DEFAULT_SERVICE_FEE);
//        vehicleDetailsPage.then_Verify_Caculated_Estimated_Total_Successfully();
        deliveryDetailsPage = vehicleDetailsPage.clickToContinue();
        confirmPayPage = deliveryDetailsPage.clickToContinue();
        confirmPayPage.scrollToFindElement();
        confirmPayPage.clickToRenewalCriteriaCheckbox();
        Assert.assertTrue(confirmPayPage.then_Verify_CheckOut_Not_Click());
        confirmPayPage.clickToPrivacyPolicyCheckbox();
        myRoadTaxStorePage = confirmPayPage.clickToCheckoutButton();
        myRoadTaxStorePage.clickToPayType();
        myRoadTaxStorePage.clickToPayButton();

    }
}
