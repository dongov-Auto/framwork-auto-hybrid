package pageUIs;

public class VehicleDetailsUI {
    public static final String VEHICLE_DETAILS_TITLE = "xpath=//android.view.View[@text='Vehicle details']";
    public static final String STEP_2_OF_4_TITLE = "xpath=//android.view.View[@text='STEP 2 OF 4']";
    public static final String VEHICLE_NAME = "xpath=(//android.view.View[@text='Vehicle details']/following-sibling::android.view.View)[1]";
    public static final String VEHICLE_INFORMATION = "xpath=(//android.view.View[@text='S']/following-sibling::android.view.View)[2]";
    public static final String VEHICLE_TYPE_TITLE = "xpath=//android.view.View[@text='Vehicle type']";
    public static final String ESTIMATED_TOTAL_TITLE = "xpath=//android.view.View[@text='Estimated total']";
    public static final String ESTIMATED_TOTAL_VALUE = "xpath=(//android.view.View[@text='Estimated total']/following-sibling::android.view.View)[1]";
    public static final String CHEVERON_UP_ICON = "xpath=(//android.view.View[@text='Estimated total']/following-sibling::android.view.View)[2]";
    public static final String CONTINUE_BUTTON = "xpath=//android.widget.Button[@text='CONTINUE']";
    public static final String VEHICLE_ICON = "xpath=//android.view.View[@resource-id='app']/android.widget.Image";
    public static final String SALOON_SPECIFICATION_LABEL = "xpath=//android.view.View[@text='Saloon']/following-sibling::android.view.View[@text='Sedan / Hatchback / Coupe / Wagon / Convertible']";
    public static final String NON_SALOON_SPECIFICATION_LABEL = "xpath=//android.view.View[@text='Non-saloon']/following-sibling::android.view.View[@text='MPV / SUV / Pick-up / Commercial']";
    // Payment summary screen
    public static final String PAYMENT_SUMMARY_TITLE = "xpath=//android.view.View[@text='Payment summary']";
    public static final String ESTIMATED_ROAD_TAX_PRICE = "xpath=(//android.view.View[@text='Estimated road tax price']/following-sibling::android.view.View)[1]";
    public static final String SERVICE_FEE = "xpath=(//android.view.View[@text='Service fee']/following-sibling::android.view.View)[1]";
    public static final String DELIVERY_FEE = "xpath=(//android.view.View[@text='Delivery fee']/following-sibling::android.view.View)[1]";

}
