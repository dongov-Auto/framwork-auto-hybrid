package setel.driver.roadTax.homePage;

import actions.commons.BaseTestMobile;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.*;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageUIs.RoadTaxPageUI;
import actions.prepareCondition.GoToRoadTaxPageSteps;
import actions.prepareCondition.LoginSetelSteps;

import static actions.commons.GlobalData.APPIUM_DRIVER;
import static actions.commons.GlobalData.RoadTaxHomePage.*;
import static actions.commons.GlobalData.RoadTaxHomePage.OWNER_NAME_IS_REQUIRED;
import static pageUIs.RoadTaxPageUI.PLEASE_ENTER_VALID_VEHICLE;

public class UIRoadTaxDisplayedField extends BaseTestMobile {

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
    @Test(description = "APP | Home page |", groups = "regression")
    @Description("Verify the validation when leave blank in all fields")
    public void DRV_83_Verify_Validation_When_Leave_Blank_All_Field() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No("");
        roadTaxPage.when_Input_Owner_Id_TextBox("");
        roadTaxPage.when_Input_To_Value_Owner_Name_TextBox("");
        roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_No_Is_Required_Displayed(),VEHICLE_PLATE_NO_IS_REQUIRED);
        Assert.assertEquals(roadTaxPage.then_Verify_Owner_ID_No_Is_Required_Displayed(),OWNER_ID_NO_IS_REQUIRED);
        Assert.assertTrue(roadTaxPage.then_Verify_Owner_Name_Is_Required_Displayed());
    }
    @Test(description = "APP | Home page |", groups = "regression")
    @Description("Check the validation of Vehicle plate no. field")
    public void DRV_79_Verify_Validation_When_Of_Vehicle_Plate_No_Field() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_SPECIAL_CHARACTERS);
        Assert.assertEquals(roadTaxPage.then_Verify_Please_Enter_Valid_Vehicle_Plate_Displayed(),PLEASE_ENTER_VALID_VEHICLE);

        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_HTML_CODE);
        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_No_Is_Required_Displayed(),PLEASE_ENTER_VALID_VEHICLE);

        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_WITH_OUT_20_CHARACTERS);
        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_No_Is_Required_Displayed(),PLEASE_ENTER_VALID_VEHICLE);

        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_MORE_THAN_20_CHARACTERS);
        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_No_Is_Required_Displayed(),PLEASE_ENTER_VALID_VEHICLE);

        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_MORE_THAN_20_ALPHANUMERIC_CHARACTERS);
        roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_No_Is_Required_Displayed(),PLEASE_ENTER_VALID_VEHICLE);

    }
    @Test(description = "APP | Home page |", groups = "regression")
    @Description("Verify UI of owner details that user has not done eKYC (eKYC = not found)")
    public void DRV_72_Verify_UI_Of_Owner_Details_That_User_Has_Not_Done_EKYC(){
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.When_step_Scroll_To_Element();
        Assert.assertTrue(roadTaxPage.then_Verify_Vehicle_Plate_No_Display());
        Assert.assertEquals(roadTaxPage.then_Verify_Option_New_NRIC_ListBox_Displayed(),NEW_NRIC);
        roadTaxPage.scrollToElement(RoadTaxPageUI.OWNER_NAME_TEXTBOX);
        Assert.assertEquals(roadTaxPage.then_Verify_Owner_Name_Is_Displayed(),SOFEA_ARYSSA_BINTI_LUQMAN);
    }
}
