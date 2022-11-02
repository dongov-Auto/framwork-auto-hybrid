package pageUIs;

public class ConfirmAndPayPageUI {
    public static final String CONFIRM_AND_PAY_TITLE = "xpath=//android.view.View[@text='Confirm & pay']";
    public static final String CHECK_OUT_BUTTON = "xpath=//android.widget.Button[@text='CHECK OUT' and @clickable='true']";
    public static final String EDIT_OWNER_NAME = "xpath=(//android.view.View[@text=\"Owner's name\"]/following-sibling::android.view.View[@text='Edit'])[1]";
    public static final String EDIT_DELIVERY_DETAILS = "xpath=//android.view.View[@text='Delivery details']/following-sibling::android.view.View[@text='Edit']";
    public static final String RENEWAL_CRITERIA_CHECKBOX = "xpath=//android.widget.Button[@text='renewal criteria']/preceding-sibling::android.view.View/android.widget.CheckBox";
    public static final String PRIVACY_POLICY_CHECKBOX = "xpath=//android.widget.Button[@text='renewal criteria']/following-sibling::android.view.View/android.widget.CheckBox";
}
