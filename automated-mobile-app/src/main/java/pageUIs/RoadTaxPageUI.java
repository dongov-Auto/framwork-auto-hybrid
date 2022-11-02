package pageUIs;

public class RoadTaxPageUI {
    public static final String ROAD_TAX_TITLE = "id=com.setel.mobile.dev:id/text_title";
    public static final String DONE_BUTTON = "id=com.setel.mobile.dev:id/button_done";
    public static final String OWNER_ID_TITLE = "xpath=//android.view.View[@text='Owner’s identification']";
        public static final String VEHICLE_TEXTBOX = "xpath=(//android.view.View[@text='Vehicle plate number']/following-sibling::android.view.View/android.widget.EditText)[1]";
    public static final String VEHICLE_LIST = "xpath=//android.view.View[@resource-id='vehiclePlateDrop']/android.view.View";
    public static final String OWNER_ID_DROPDOWN = "xpath=//android.widget.Spinner[contains(@resource-id,'button--listbox-input')]/android.view.View";
    public static final String LIST_OWNER_ID = "xpath=//android.widget.ListView[contains(@resource-id,'listbox--listbox-input')]/android.view.View[@text='%s']";
    public static final String OWNER_ID_TEXTBOX = "xpath=//android.view.View[@text='Owner’s identification']/following-sibling::android.view.View/android.widget.EditText";
    public static final String OWNER_NAME_TEXTBOX = "xpath=//android.view.View[@text='Owner’s full name']/following-sibling::android.view.View/android.widget.EditText";
    public static final String COMPANY_NAME_TEXTBOX = "xpath=//android.view.View[@text='Company name']/following-sibling::android.view.View/android.widget.EditText";
    public static final String RENEW_ROAD_TAX_BUTTON = "xpath=//android.widget.Button[@text='RENEW ROAD TAX']";
    public static final String RENEWAL_CRITERIA_LINK = "xpath=//android.widget.TextView[@text='Renewal criteria']";
    public static final String FAQ_LINK = "xpath=//android.widget.TextView[@text='FAQ']";
//    public static final String VEHICLE_PLATE_DROPDOWN = "xpath=";


    public static final String PLEASE_ENTER_VALID_VEHICLE = "xpath=//android.view.View[@text='Please enter a valid vehicle plate number']";
    public static final String OWNER_ID_NO_REQUIRED = "xpath=//android.view.View[@text='Owner’s identification no. is required']";
    public static final String OWNER_NAME_REQUIRED = "xpath=//android.view.View[@text='Company name is required']";
    public static final String VEHICLE_PLATE_NO_REQUIRED = "xpath=//android.view.View[@text='Vehicle plate number is required']";
    public static final String OWNER_ID_NO_MUST_CONTAIN_12_DIGITS = "xpath=//android.view.View[@text='ID no. must contain 12 digits']";
    public static final String OWNER_ID_NO_MUST_CONTAIN_7_DIGITS = "xpath=//android.view.View[@text='ID no. must contain 7 digits']";
    public static final String OWNER_ID_NO_MUST_BE_ALPANUMERIC = "xpath=//android.view.View[@text='ID no. must be alphanumeric']";

    public static final String HOW_IT_WORKS_LINK = "xpath=//android.view.View[@text='HOW IT WORKS']";

}
