package actions.pageObjects;

import actions.commons.BasePageMobile;
import actions.commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import pageUIs.GlobalUI;
import pageUIs.VehicleDetailsUI;

import static actions.commons.GlobalData.RoadTaxHomePage.VEHICLE_PLATE_E2E;
import static actions.commons.GlobalData.VehicleInformation.*;

public class VehicleDetailsObjectPage extends BasePageMobile {
    public VehicleDetailsObjectPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Step("Verify Vehicle details title is displayed")
    public boolean then_Verify_Vehicle_Details_Title_Displayed() {
        waitForElementVisible(VehicleDetailsUI.VEHICLE_DETAILS_TITLE);
        return isElementDisplayed(VehicleDetailsUI.VEHICLE_DETAILS_TITLE);
    }

    @Step("Verify Vehicle Detail screen is displayed")
    public boolean then_Verify_Vehicle_Details_Displayed() {
        waitForElementVisible(VehicleDetailsUI.VEHICLE_DETAILS_TITLE);
        return isElementDisplayed(VehicleDetailsUI.VEHICLE_DETAILS_TITLE);
    }

    @Step("Click to 'Forward' button ")
    public RoadTaxObjectPage and_Back_To_Road_Tax_Page() {
        waitForElementClickable(GlobalUI.BACK_BUTTON);
        clickToElement(GlobalUI.BACK_BUTTON);
        return PageGeneratorManager.given_Get_Road_Tax_Page(appiumDriver);
    }

    @Step("Verify vehicle icon is displayed")
    public boolean then_Verify_Vehicle_Icon_Displayed() {
        waitForElementVisible(VehicleDetailsUI.VEHICLE_ICON);
        return isElementDisplayed(VehicleDetailsUI.VEHICLE_ICON);
    }

    @Step("Verify '{0}' vehicle name is displayed")
    public boolean then_Verify_Vehicle_Name_Displayed(String name) {
        waitForElementVisible(GlobalUI.VEHICLE_INFORMATION, name);
        return isElementDisplayed(GlobalUI.VEHICLE_INFORMATION, name);
    }

    @Step("Verify '{0}' vehicle info is displayed")
    public boolean then_Verify_Vehicle_Information_Details_Displayed(String informationVehicle) {
        waitForElementVisible(GlobalUI.VEHICLE_INFORMATION, informationVehicle);
        return isElementDisplayed(GlobalUI.VEHICLE_INFORMATION, informationVehicle);
    }

    @Step("Verify '{0}' vehicle type is displayed")
    public boolean then_Verify_Vehicle_Type_Displayed(String typeVehicle) {
        waitForElementVisible(GlobalUI.VEHICLE_TYPE_RADIO, typeVehicle);
        return isElementDisplayed(GlobalUI.VEHICLE_TYPE_RADIO, typeVehicle);
    }

    @Step("Verify saloon specification label is displayed")
    public boolean then_Verify_Saloon_Specification_Displayed() {
        waitForElementVisible(VehicleDetailsUI.SALOON_SPECIFICATION_LABEL);
        return isElementDisplayed(VehicleDetailsUI.SALOON_SPECIFICATION_LABEL);
    }

    @Step("Verify non-saloon specification label is displayed")
    public boolean then_Verify_Non_Saloon_Specification_Displayed() {
        waitForElementVisible(VehicleDetailsUI.NON_SALOON_SPECIFICATION_LABEL);
        return isElementDisplayed(VehicleDetailsUI.NON_SALOON_SPECIFICATION_LABEL);
    }

    @Step("Verify continue button is undisplayed")
    public boolean then_Verify_Continue_Button_UnDisplayed() {
        waitForElementVisible(VehicleDetailsUI.CONTINUE_BUTTON);
        return isElementUndisplayed(VehicleDetailsUI.CONTINUE_BUTTON);
    }

    @Step("Verify vehicle information is displayed")
    public VehicleDetailsObjectPage then_Verify_Vehicle_Informations_Displayed() {
        then_Verify_Vehicle_Icon_Displayed();
        then_Verify_Vehicle_Name_Displayed(VEHICLE_PLATE_E2E);
//        then_Verify_Vehicle_Information_Details_Displayed(VEHICLE_INFORMATION_VALUE);
        if(isElementDisplayed(GlobalUI.VEHICLE_TYPE_RADIO,SALOON_NAME)) {
            then_Verify_Vehicle_Type_Displayed(SALOON_NAME);
            then_Verify_Saloon_Specification_Displayed();
        } else {
            System.out.println("Verify Saloon type is not Displayed");
        }
        if(isElementDisplayed(GlobalUI.VEHICLE_TYPE_RADIO,NON_SALOON_NAME)) {
            then_Verify_Vehicle_Type_Displayed(NON_SALOON_NAME);
            then_Verify_Non_Saloon_Specification_Displayed();
        } else {
            System.out.println("Verify Non-Saloon type is not Displayed");
        }
        return this;
    }

    @Step("Click to cheveron up icon")
    public void clickToCheveronUpIcon() {
        waitForElementClickable(VehicleDetailsUI.CHEVERON_UP_ICON);
        clickToElement(VehicleDetailsUI.CHEVERON_UP_ICON);
    }

    @Step("Verify payment smmart screen is displayed")
    public boolean then_Verify_Payment_Summart_Displayed() {
        waitForElementVisible(VehicleDetailsUI.PAYMENT_SUMMARY_TITLE);
        return isElementDisplayed(VehicleDetailsUI.PAYMENT_SUMMARY_TITLE);
    }

    @Step("Get value of Service fee is RM 15.00")
    public String then_Verify_Service_Fee_Default() {
        waitForElementVisible(VehicleDetailsUI.SERVICE_FEE);
        return getElementText(VehicleDetailsUI.SERVICE_FEE);
    }

    @Step("Get value of Delivery fee is displayed")
    public boolean then_Verify_Delivery_Fee() {
        waitForElementVisible(VehicleDetailsUI.DELIVERY_FEE);
        return isElementDisplayed(VehicleDetailsUI.DELIVERY_FEE);
    }

    @Step("Get value of Estimated total is displayed")
    public boolean then_Verify_Estimated_Total() {
        waitForElementVisible(VehicleDetailsUI.ESTIMATED_TOTAL_VALUE);
        return isElementDisplayed(VehicleDetailsUI.ESTIMATED_TOTAL_VALUE);
    }

    @Step("Get value of road tax price is displayed")
    public boolean then_Verify_Estimated_Road_Tax_Price() {
        waitForElementVisible(VehicleDetailsUI.ESTIMATED_ROAD_TAX_PRICE);
        return isElementDisplayed(VehicleDetailsUI.ESTIMATED_ROAD_TAX_PRICE);
    }

    @Step("Verify calculate the estimated total same Estimated total is displayed")
    public VehicleDetailsObjectPage then_Verify_Caculated_Estimated_Total_Successfully() {
        double price = Double.parseDouble( getElementText(VehicleDetailsUI.ESTIMATED_ROAD_TAX_PRICE).replaceAll("[a-zA-Z]", ""));
        double fee = Double.parseDouble(getElementText(VehicleDetailsUI.SERVICE_FEE).replaceAll("[a-zA-Z]", ""));
        double total = (price + fee);
        double value = Double.parseDouble(getElementText(VehicleDetailsUI.ESTIMATED_TOTAL_VALUE).replaceAll("[a-zA-Z]",""));
        Assert.assertEquals(total,value);
        return this;
    }

    @Step("Click to {0} radio button")
    public void clickToVehicleType(String vehicleType) {
        waitForElementClickable(GlobalUI.VEHICLE_TYPE_RADIO, vehicleType);
        clickToElement(GlobalUI.VEHICLE_TYPE_RADIO, vehicleType);
    }
    @Step("Click to continue button")
    public DeliveryDetailsObjectPage clickToContinue() {
        waitForElementClickable(VehicleDetailsUI.CONTINUE_BUTTON);
        clickToElement(VehicleDetailsUI.CONTINUE_BUTTON);
        return PageGeneratorManager.given_Delivery_Details_Page(appiumDriver);
    }
}
