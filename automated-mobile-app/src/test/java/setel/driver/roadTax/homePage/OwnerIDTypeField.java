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
import static actions.commons.GlobalData.MessageError.COMPANY_NAME_IS_REQUIRED;
import static actions.commons.GlobalData.MessageError.PLEASE_ENTER_12_DIGIT_IDENTIFICATION_NUMBER;
import static actions.commons.GlobalData.RoadTaxHomePage.*;

public class OwnerIDTypeField extends BaseTestMobile {

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
    @Test(description = "APP | Home page | Owner details |", groups = "regression")
    @Description("Verify the validation of ID number with Company registration no. type")
    public void DRV_90_Verify_Validation_Of_Id_Number_With_Company_Registration_Type() {
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
        roadTaxPage.when_Click_To_Reload_Button();
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
        roadTaxPage.when_Click_To_Owner_Dropdown();
        roadTaxPage.when_Select_Owner_In_Dropdown(COMPANY_REGISTRATION_NO);
        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
        roadTaxPage.when_Input_Owner_Id_TextBox(COMPANY_REGISTRATION_12_DIGITS);
        roadTaxPage.when_Input_To_Value_Company_Name_TextBox("");
        roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
        Assert.assertTrue(roadTaxPage.then_Verify_Message_Is_Required_Displayed(COMPANY_NAME_IS_REQUIRED));
        roadTaxPage.when_Input_To_Value_Company_Name_TextBox(COMPANY_NAME_INPUT);
        roadTaxPage.when_Input_Owner_Id_TextBox(SPECIAL_CHARACTERS);
        Assert.assertTrue(roadTaxPage.then_Verify_Message_Is_Required_Displayed(PLEASE_ENTER_12_DIGIT_IDENTIFICATION_NUMBER));
        roadTaxPage.when_Input_Owner_Id_TextBox(COMPANY_REGISTRATION_6_CHARACTERS);
        Assert.assertTrue(roadTaxPage.then_Verify_Message_Is_Required_Displayed(PLEASE_ENTER_12_DIGIT_IDENTIFICATION_NUMBER));
    }
//    @Test(description = "APP | Home page | Owner details |", groups = "regression")
//    @Description("Verify the validation of ID number with Police / Army ID type")
//    public void DRV_89_Verify_Validation_Of_Id_Number_With_Police_Or_Army_ID_Type() {
//        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
//        roadTaxPage.when_Click_To_Reload_Button();
//        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
//        roadTaxPage.when_Click_To_Owner_Dropdown();
//        roadTaxPage.when_Select_Owner_In_Dropdown(POLICE_ARMYID);
//        roadTaxPage.when_Input_Owner_Id_TextBox(SPECIAL_CHARACTERS);
//        roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
//        Assert.assertTrue(roadTaxPage.then_Verify_ID_No_Must_Be_Alphanumeric_Displayed());
//        roadTaxPage.when_Input_Owner_Id_TextBox(POLICE_ARMYID_CHARACTERS);
//        roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
//        Assert.assertTrue(roadTaxPage.then_Verify_ID_No_Must_Be_Alphanumeric_Displayed());
//    }
//    @Test(description = "APP | Home page | Owner details |", groups = "regression")
//    @Description("Verify the validation of ID number with Passport type")
//    public void DRV_88_Verify_Validation_Of_Id_Number_With_Passport_Type() {
//        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
//        roadTaxPage.when_Click_To_Reload_Button();
//        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
//        roadTaxPage.when_Click_To_Owner_Dropdown();
//        roadTaxPage.when_Select_Owner_In_Dropdown(PASS_PORT);
//        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_PASS_PORT_ALPHANUMERIC);
//        roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
//        Assert.assertTrue(roadTaxPage.then_Verify_ID_No_Must_Be_Alphanumeric_Displayed());
//        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_PASS_PORT_NUMBER);
//        roadTaxPage.and_Click_To_Renew_Road_Tax_Button();
//        Assert.assertTrue(roadTaxPage.then_Verify_ID_No_Must_Be_Alphanumeric_Displayed());
//    }
//    @Test(description = "APP | Home page | Owner details |", groups = "regression")
//    @Description("Verify the validation of ID number with Mykad (Old NRIC) type")
//    public void DRV_87_Verify_Validation_Of_Id_Number_With_Old_NRIC_Type() {
//        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
//        roadTaxPage.when_Click_To_Reload_Button();
//        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
//        roadTaxPage.when_Click_To_Owner_Dropdown();
//        roadTaxPage.when_Select_Owner_In_Dropdown(OLD_NRIC);
//        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_OLD_NRIC_8_CHARACTERS);
//        Assert.assertTrue(roadTaxPage.then_Verify_Owner_Id_No_Must_Contain_7_Digits_Displayed());
//        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_OLD_NRIC_6_CHARACTERS);
//        Assert.assertTrue(roadTaxPage.then_Verify_Owner_Id_No_Must_Contain_7_Digits_Displayed());
//    }
//    @Test(description = "APP | Home page | Owner details |", groups = "regression")
//    @Description("Verify the validation of ID number with Mykad (NRIC) type")
//    public void DRV_86_Verify_Validation_Of_Id_Number_With_Mykad_NRIC_Type() {
//        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
//        roadTaxPage.when_Click_To_Reload_Button();
//        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
//        roadTaxPage.when_Click_To_Owner_Dropdown();
//        roadTaxPage.when_Select_Owner_In_Dropdown(NEW_NRIC);
//        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_NEW_NRIC_14_CHARACTERS);
//        Assert.assertTrue(roadTaxPage.then_Verify_Owner_Id_No_Must_Contain_12_Digits_Displayed());
//        roadTaxPage.when_Input_Owner_Id_TextBox(OWNERID_NEW_NRIC_WITHOUT_12_DIGITS);
//        Assert.assertTrue(roadTaxPage.then_Verify_Owner_Id_No_Must_Contain_12_Digits_Displayed());
//    }

}
