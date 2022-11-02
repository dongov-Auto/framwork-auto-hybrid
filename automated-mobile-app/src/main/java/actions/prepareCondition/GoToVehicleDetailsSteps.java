package actions.prepareCondition;

import actions.commons.BaseTestMobile;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.RoadTaxObjectPage;
import actions.pageObjects.VehicleDetailsObjectPage;

import static actions.commons.GlobalData.APPIUM_DRIVER;

public class GoToVehicleDetailsSteps extends BaseTestMobile {
    private RoadTaxObjectPage roadTaxPage;
    private VehicleDetailsObjectPage vehicleDetailsPage;

    public void prepareGoToVehicleDetails(){
        roadTaxPage = PageGeneratorManager.given_Get_Road_Tax_Page(APPIUM_DRIVER);


    }
}
