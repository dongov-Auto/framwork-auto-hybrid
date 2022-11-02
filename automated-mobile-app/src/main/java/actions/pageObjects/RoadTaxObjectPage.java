package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pageUIs.GlobalUI;
import pageUIs.RoadTaxPageUI;

public class RoadTaxObjectPage extends BasePageMobile {
    public RoadTaxObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Step("When the mobile field is chosen random a '{0}' in list of vehicle")
    public void when_choose_Vehicle_From_DropDown_List(String nameChooseVehicle) {
        waitForElementClickable(RoadTaxPageUI.ROAD_TAX_TITLE);
        scrollDownToELement(RoadTaxPageUI.VEHICLE_TEXTBOX);
        waitForAllElementVisible(RoadTaxPageUI.VEHICLE_LIST);
        stepHidenKeyBoardAndroid();
        stepChooseRamdonElement(RoadTaxPageUI.VEHICLE_LIST,nameChooseVehicle);
    }
    @Step("Then vehicle plate name is displayed")
    public String then_Verify_Value_In_Vehicle_Plate_No_TextBox() {
        waitForElementVisible(RoadTaxPageUI.VEHICLE_TEXTBOX);
        return getElementText(RoadTaxPageUI.VEHICLE_TEXTBOX);
    }
    @Step("When the mobile field is clicked to reload button")
    public void when_Click_To_Reload_Button() {
        waitForElementClickable(GlobalUI.RELOAD_BUTTON);
        clickToElement(GlobalUI.RELOAD_BUTTON);
    }
    @Step("When the mobile field is inputted '{0}' to the  vehicle Name plate")
    public void when_Input_To_Vehicle_Number_Plate_No(String vehicleName) {
        waitForElementClickable(RoadTaxPageUI.VEHICLE_TEXTBOX);
        sendKeyToElement(RoadTaxPageUI.VEHICLE_TEXTBOX,vehicleName);
        stepHidenKeyBoardAndroid();
    }
    @Step("When mobile field is clicked to Owner dropdown button")
    public void when_Click_To_Owner_Dropdown() {
        waitForElementClickable(RoadTaxPageUI.OWNER_ID_DROPDOWN);
        clickToElement(RoadTaxPageUI.OWNER_ID_DROPDOWN);
    }
    @Step("When mobile field is selected '{0}' in owner list")
    public void when_Select_Owner_In_Dropdown(String ownerName) {
        waitForElementClickable(RoadTaxPageUI.LIST_OWNER_ID,ownerName);
        clickToElement(RoadTaxPageUI.LIST_OWNER_ID,ownerName);
    }
    @Step("Verify 'Old NRIC' is displayed")
    public String then_Verify_Option_New_NRIC_ListBox_Displayed() {
        waitForElementVisible(RoadTaxPageUI.OWNER_ID_DROPDOWN);
        sleepInSecond(1);
        return getElementText(RoadTaxPageUI.OWNER_ID_DROPDOWN);
    }
    @Step("Click to Renew Road Tax")
    public VehicleDetailsObjectPage and_Click_To_Renew_Road_Tax_Button() {
        waitForElementClickable(RoadTaxPageUI.RENEW_ROAD_TAX_BUTTON);
        clickToElement(RoadTaxPageUI.RENEW_ROAD_TAX_BUTTON);
        return PageGeneratorManager.given_Get_Vehicle_Detail_Page(appiumDriver);
    }
    @Step("Input '{0}' to owner ID textbox")
    public void when_Input_Owner_Id_TextBox(String ownerID) {
        waitForElementVisible(RoadTaxPageUI.OWNER_ID_TEXTBOX);
        sendKeyToElement(RoadTaxPageUI.OWNER_ID_TEXTBOX,ownerID);
        stepHidenKeyBoardAndroid();
    }
    @Step("Verify message 'Vehicle plate no. is required' is displayed")
    public String then_Verify_Vehicle_Plate_No_Is_Required_Displayed() {
        waitForElementVisible(RoadTaxPageUI.VEHICLE_PLATE_NO_REQUIRED);
        return getElementText(RoadTaxPageUI.VEHICLE_PLATE_NO_REQUIRED);
    }
    @Step("Verify message 'Please enter a valid vehicle plate no.' is displayed")
    public String then_Verify_Please_Enter_Valid_Vehicle_Plate_Displayed() {
        waitForElementVisible(RoadTaxPageUI.PLEASE_ENTER_VALID_VEHICLE);
        return getElementText(RoadTaxPageUI.PLEASE_ENTER_VALID_VEHICLE);
    }
    @Step("Input '{0}' value to owner name")
    public void when_Input_To_Value_Owner_Name_TextBox(String ownerName) {
        waitForElementVisible(RoadTaxPageUI.OWNER_NAME_TEXTBOX);
        sendKeyToElement(RoadTaxPageUI.OWNER_NAME_TEXTBOX,ownerName);
        stepHidenKeyBoardAndroid();
    }
    @Step("Verify message 'Owner ID no. is required' is displayed")
    public String then_Verify_Owner_ID_No_Is_Required_Displayed() {
        waitForElementVisible(RoadTaxPageUI.OWNER_ID_NO_REQUIRED);
        return getElementText(RoadTaxPageUI.OWNER_ID_NO_REQUIRED);
    }
    @Step("Verify 'Owner name is required' message is displayed")
    public boolean then_Verify_Owner_Name_Is_Required_Displayed() {
        waitForElementVisible(RoadTaxPageUI.OWNER_NAME_REQUIRED);
        return isElementDisplayed(RoadTaxPageUI.OWNER_NAME_REQUIRED);
    }
//    @Step("Verify vehicle plate dropdown is displayed")
//    public boolean then_Verify_Vehicle_Plate_Dropdown_Displayed() {
//        waitForElementVisible(RoadTaxPageUI.VEHICLE_PLATE_DROPDOWN);
//        return isElementDisplayed(RoadTaxPageUI.VEHICLE_PLATE_DROPDOWN);
//    }
    @Step("Click to vehicle plate textbox")
    public void when_Click_To_Vehicle_Plate_TextBox() {
        waitForElementClickable(RoadTaxPageUI.VEHICLE_TEXTBOX);
        clickToElement(RoadTaxPageUI.VEHICLE_TEXTBOX);
    }
    @Step("Verify 'Owner ID no. must be alpanumeric' message is displayed")
    public boolean then_Verify_ID_No_Must_Be_Alphanumeric_Displayed() {
        waitForElementVisible(RoadTaxPageUI.OWNER_ID_NO_MUST_BE_ALPANUMERIC);
        return isElementDisplayed(RoadTaxPageUI.OWNER_ID_NO_MUST_BE_ALPANUMERIC);
    }
    @Step("Verify 'Owner name is required' message is displayed")
    public boolean then_Verify_Owner_Name_Is_Message_Displayed() {
        waitForElementVisible(RoadTaxPageUI.OWNER_NAME_REQUIRED);
        return isElementDisplayed(RoadTaxPageUI.OWNER_NAME_REQUIRED);
    }
    @Step("Verify 'ID no. must contain 7 digits' message is displayed")
    public boolean then_Verify_Owner_Id_No_Must_Contain_7_Digits_Displayed() {
        waitForElementVisible(RoadTaxPageUI.OWNER_ID_NO_MUST_CONTAIN_7_DIGITS);
        return isElementDisplayed(RoadTaxPageUI.OWNER_ID_NO_MUST_CONTAIN_7_DIGITS);
    }
    @Step("Verify 'ID no. must contain 12 digits' message is displayed")
    public boolean then_Verify_Owner_Id_No_Must_Contain_12_Digits_Displayed() {
        waitForElementVisible(RoadTaxPageUI.OWNER_ID_NO_MUST_CONTAIN_12_DIGITS);
        return isElementDisplayed(RoadTaxPageUI.OWNER_ID_NO_MUST_CONTAIN_12_DIGITS);
    }
    @Step("Verify 'Road Tax screen' displayed")
    public boolean then_Verify_Road_Tax_Displayed() {
        waitForElementVisible(RoadTaxPageUI.ROAD_TAX_TITLE);
        return isElementDisplayed(RoadTaxPageUI.ROAD_TAX_TITLE);
    }
    @Step("Scroll to element")
    public void When_step_Scroll_To_Element() {
        waitForElementClickable(GlobalUI.RELOAD_BUTTON);
        scrollDownToELement(RoadTaxPageUI.OWNER_ID_TITLE);
    }
    @Step("Verify Vehicle plate no is display")
    public boolean then_Verify_Vehicle_Plate_No_Display() {
        waitForElementVisible(RoadTaxPageUI.OWNER_ID_TITLE);
        return isElementDisplayed(RoadTaxPageUI.OWNER_ID_TITLE);
    }
    @Step("Verify Owner name is displayed")
    public String then_Verify_Owner_Name_Is_Displayed() {
        waitForElementVisible(RoadTaxPageUI.OWNER_NAME_TEXTBOX);
        return getElementText(RoadTaxPageUI.OWNER_NAME_TEXTBOX);
    }
    @Step("click on HOW IT WORKS link to view steps at the bottom sheet")
    public HowItWorkObjectPage when_Click_To_How_It_Works_Link() {
        waitForElementClickable(RoadTaxPageUI.HOW_IT_WORKS_LINK);
        clickToElement(RoadTaxPageUI.HOW_IT_WORKS_LINK);
        return PageGeneratorManager.given_Get_How_It_Work_Page(appiumDriver);
    }
    @Step("Input '{0}' value to Company name text box")
    public void when_Input_To_Value_Company_Name_TextBox(String companyName) {
        waitForElementVisible(RoadTaxPageUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(RoadTaxPageUI.COMPANY_NAME_TEXTBOX,companyName);
    }

    public boolean then_Verify_How_It_Work_Link_Displayed() {
        waitForElementVisible(RoadTaxPageUI.HOW_IT_WORKS_LINK);
        return isElementDisplayed(RoadTaxPageUI.HOW_IT_WORKS_LINK);
    }
}
