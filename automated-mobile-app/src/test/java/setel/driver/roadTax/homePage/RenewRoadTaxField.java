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
import static actions.commons.GlobalData.RoadTaxHomePage.*;

public class RenewRoadTaxField extends BaseTestMobile {
    private RoadTaxObjectPage roadTaxPage;
    private VehicleDetailsObjectPage vehicleDetailsPage;

    @BeforeClass()
    public void beforeClass(){
        APPIUM_DRIVER = getDriver();
        LoginSetelSteps loginSetelSteps = new LoginSetelSteps();
        GoToRoadTaxPageSteps stepGoTo =new GoToRoadTaxPageSteps();
        loginSetelSteps.prepareLogin();
        stepGoTo.prepareGoToRoadTaxPage();
    }
    @Test(description = "APP | Home page | Renew Read Tax |", groups = "regression")
    @Description("Verify user can click Renewal road tax when choose Owner ID is Company registration no. type")
    public void DRV_85_Verify_User_Can_Click_Renewal_Road_Tax_When_Choose_Owner_ID_Is_Company_Registration_Type() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
        roadTaxPage.when_Click_To_Owner_Dropdown();
        roadTaxPage.when_Select_Owner_In_Dropdown(COMPANY_REGISTRATION_NO);
        roadTaxPage.when_Input_Owner_Id_TextBox(COMPANY_REGISTRATION_12_DIGITS);
        roadTaxPage.when_Input_To_Value_Company_Name_TextBox(COMPANY_NAME_INPUT);
        vehicleDetailsPage = roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertTrue(vehicleDetailsPage.then_Verify_Vehicle_Details_Displayed());
    }
    @Test(description = "APP | Home page | Renew Read Tax |", groups = "regression")
    @Description("Verify user can click Renewal road tax when choose Owner ID is Police/Army ID type")
    public void DRV_84_Verify_USer_Can_Click_Renewal_Road_Tax_When_Choose_Owner_ID_Is_Police_Army_ID_Type() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
        roadTaxPage.when_Click_To_Owner_Dropdown();
        roadTaxPage.when_Select_Owner_In_Dropdown(POLICE_ARMYID);
        roadTaxPage.when_Input_Owner_Id_TextBox(POLICE_ARMYID_INPUT);
        roadTaxPage.when_Input_To_Value_Owner_Name_TextBox(OWNER_NAME);
        vehicleDetailsPage = roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertTrue(vehicleDetailsPage.then_Verify_Vehicle_Details_Displayed());
        roadTaxPage = vehicleDetailsPage.and_Back_To_Road_Tax_Page();
    }
    @Test(description = "APP | Home page | Renew Read Tax |", groups = "regression")
    @Description("Verify user can click Renewal road tax when choose Owner ID is Passport type")
    public void DRV_82_Verify_USer_Can_Click_Renewal_Road_Tax_When_Choose_Owner_ID_Is_Passport_Type() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
        roadTaxPage.when_Click_To_Owner_Dropdown();
        roadTaxPage.when_Select_Owner_In_Dropdown(PASS_PORT);
        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_PASS_PORT);
        roadTaxPage.when_Input_To_Value_Owner_Name_TextBox(OWNER_NAME);
        vehicleDetailsPage = roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertTrue(vehicleDetailsPage.then_Verify_Vehicle_Details_Displayed());
        roadTaxPage = vehicleDetailsPage.and_Back_To_Road_Tax_Page();
    }
    @Test(description = "APP | Home page | Renew Read Tax |", groups = "regression")
    @Description("Verify user can click Renewal road tax when choose Owner ID is Mykad (OLD NRIC) type")
    public void DRV_81_Verify_User_Can_Click_Renewal_Road_Tax_When_Choose_Owner_ID_Is_Myka_Type() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
        roadTaxPage.when_Click_To_Owner_Dropdown();
        roadTaxPage.when_Select_Owner_In_Dropdown(OLD_NRIC);
        Assert.assertEquals(roadTaxPage.then_Verify_Option_New_NRIC_ListBox_Displayed(),OLD_NRIC);
        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_OLD_NRIC);
        vehicleDetailsPage = roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertTrue(vehicleDetailsPage.then_Verify_Vehicle_Details_Displayed());
        roadTaxPage = vehicleDetailsPage.and_Back_To_Road_Tax_Page();
    }
    @Test(description = "APP | Home page | Renew Read Tax |", groups = "regression")
    @Description("Verify user can click Renewal road tax when choose Owner ID is Mykad (NEW NRIC) type")
    public void DRV_80_Verify_User_Can_Click_Renewal_Road_Tax_When_Choose_Owner_ID_Is_Myka_Type() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
        roadTaxPage.when_Click_To_Owner_Dropdown();
        roadTaxPage.when_Select_Owner_In_Dropdown(NEW_NRIC);
        Assert.assertEquals(roadTaxPage.then_Verify_Option_New_NRIC_ListBox_Displayed(),NEW_NRIC);
        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_NEW_NRIC_1);
        vehicleDetailsPage = roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertTrue(vehicleDetailsPage.then_Verify_Vehicle_Details_Displayed());
        roadTaxPage = vehicleDetailsPage.and_Back_To_Road_Tax_Page();
    }

    @Test(description = "APP | Home page | Renew Read Tax |", groups = "regression")
    @Description("Verify user can add new owner details that has not been upgraded (eKYC = not found)")
    public void DRV_73_Verify_User_Can_Add_New_Owner_Details_That_Has_Not_Been_Upgraded() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_NEW_NRIC);
        roadTaxPage.when_Input_To_Value_Owner_Name_TextBox(OWNER_NAME);
        vehicleDetailsPage = roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertTrue(vehicleDetailsPage.then_Verify_Vehicle_Details_Displayed());
        roadTaxPage = vehicleDetailsPage.and_Back_To_Road_Tax_Page();
    }
}
