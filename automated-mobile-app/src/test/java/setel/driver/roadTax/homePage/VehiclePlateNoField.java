package setel.driver.roadTax.homePage;//package setel.driver.roadTax.homePage;
//
//import actions.commons.BaseTestMobile;
//import actions.commons.PageGeneratorManager;
//import actions.pageObjects.*;
//import org.springframework.context.annotation.Description;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import actions.prepareCondition.GoToRoadTaxPageSteps;
//import actions.prepareCondition.LoginSetelSteps;
//
//import static actions.commons.GlobalData.APPIUM_DRIVER;
//import static actions.commons.GlobalData.RoadTaxHomePage.*;
//
//public class VehiclePlateNoField extends BaseTestMobile {
//    private RoadTaxObjectPage roadTaxPage;
//    @BeforeClass()
//    public void beforeClass(){
//        APPIUM_DRIVER = getDriver();
//        LoginSetelSteps loginSetelSteps = new LoginSetelSteps();
//        loginSetelSteps.prepareLogin();
//        GoToRoadTaxPageSteps stepGoTo =new GoToRoadTaxPageSteps();
//        stepGoTo.prepareGoToRoadTaxPage();
//    }
//    @Test(description = "APP | Home page | Vehicle plate |", groups = "regression")
//    @Description("Verify user can choose vehicle from dropdown list with five vehicles in profile")
//    public void DRV_77_Verify_user_can_choose_vehicle_from_dropdown_list_with_five_vehicle_in_profile() {
//        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
//        roadTaxPage.when_choose_Vehicle_From_DropDown_List(VEHICLE_PLATE_NAME_1);
//        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed(),VEHICLE_PLATE_NAME_1);
//        roadTaxPage.when_choose_Vehicle_From_DropDown_List(VEHICLE_PLATE_NAME_2);
//        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed(),VEHICLE_PLATE_NAME_2);
//        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
//        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed(),VEHICLE_PLATE_UPPERCASE);
//    }
//    @Test(description = "APP | Home page | Vehicle plate |", groups = "regression")
//    @Description("Verify user can choose vehicle from dropdown list with one vehicle in profile")
//    public void DRV_76_Verify_user_can_choose_vehicle_from_dropdown_list_with_one_vehicle_in_profile() {
//        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
//        roadTaxPage.when_choose_Vehicle_From_DropDown_List(VEHICLE_PLATE_NAME_1);
//        Assert.assertEquals(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed(),VEHICLE_PLATE_NAME_1);
//    }
//    @Test(description = "APP | Home page | Vehicle plate |", groups = "regression")
//    @Description("Verify user can enter Vehicle plate no. manually with zero vehicle in profile")
//    public void DRC_75_Verify_User_Can_Enter_Vehicle_Plate_No_Manually_With_Zero_Vehicle_In_Profile(){
//        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);
//        roadTaxPage.when_Click_To_Reload_Button();
//        roadTaxPage.when_Click_To_Vehicle_Plate_TextBox();
//        Assert.assertTrue(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed());
//        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_UPPERCASE);
//        Assert.assertEquals(roadTaxPage.then_Verify_Value_In_Vehicle_Plate_No_TextBox(),VEHICLE_PLATE_UPPERCASE);
//        Assert.assertFalse(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed());
//        roadTaxPage.when_Click_To_Vehicle_Plate_TextBox();
//        Assert.assertTrue(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed());
//        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_LOWERCASE);
//        Assert.assertEquals(roadTaxPage.then_Verify_Value_In_Vehicle_Plate_No_TextBox(),VEHICLE_PLATE_LOWERCASE);
//        Assert.assertFalse(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed());
//        roadTaxPage.when_Click_To_Vehicle_Plate_TextBox();
//        Assert.assertTrue(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed());
//        roadTaxPage.when_Input_To_Vehicle_Number_Plate_No(VEHICLE_PLATE_CONTACT_SPACE);
//        Assert.assertEquals(roadTaxPage.then_Verify_Value_In_Vehicle_Plate_No_TextBox(),VEHICLE_PLATE_CONTACT_SPACE);
//        Assert.assertFalse(roadTaxPage.then_Verify_Vehicle_Plate_Dropdown_Displayed());
//    }
//}
