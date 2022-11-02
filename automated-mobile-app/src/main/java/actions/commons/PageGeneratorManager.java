package actions.commons;

import actions.pageObjects.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class PageGeneratorManager {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public PageGeneratorManager(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Open Language page")
    public static ChooseLanguageObjectPage given_Get_Choose_Language_Page(AppiumDriver<MobileElement> driver){
        return new ChooseLanguageObjectPage(driver);
    }
    @Step("Open Login page")
    public static LoginObjectPage given_get_Login_Page(AppiumDriver<MobileElement> driver){
        return new LoginObjectPage(driver);
    }
    @Step("Open Home page")
    public static HomePageObjectPage given_Get_Home_Page(AppiumDriver<MobileElement> driver){
        return new HomePageObjectPage(driver);
    }
    @Step("Open Road Tax page")
    public static RoadTaxObjectPage given_Get_Road_Tax_Page(AppiumDriver<MobileElement> driver){
        return new RoadTaxObjectPage(driver);
    }
    @Step("Open Vehicle details page")
    public static VehicleDetailsObjectPage given_Get_Vehicle_Detail_Page(AppiumDriver<MobileElement> driver){
        return new VehicleDetailsObjectPage(driver);
    }
    @Step("Open How it work page")
    public static HowItWorkObjectPage given_Get_How_It_Work_Page(AppiumDriver<MobileElement> driver){
        return new HowItWorkObjectPage(driver);
    }
    @Step("Open Delivery Details page")
    public static DeliveryDetailsObjectPage given_Delivery_Details_Page(AppiumDriver<MobileElement> driver){
        return new DeliveryDetailsObjectPage(driver);
    }
    @Step("Open Confirm and Pay page")
    public static ConfirmAndPayObjectPage given_Confirm_Pay_Page(AppiumDriver<MobileElement> driver){
        return new ConfirmAndPayObjectPage(driver);
    }
    @Step("Open My road tax store page")
    public static MyRoadTaxStoreObjectPage given_my_road_tax_store_Page(AppiumDriver<MobileElement> driver){
        return new MyRoadTaxStoreObjectPage(driver);
    }
    @Step("Open Your order failed page")
    public static YourOrderFailedObjectPage given_your_order_failed_Page(AppiumDriver<MobileElement> driver){
        return new YourOrderFailedObjectPage(driver);
    }
}
