package actions.commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class GlobalData {
    public static AppiumDriver<MobileElement> APPIUM_DRIVER;

    public class Login {
        public static final String PIN = "234235";
        public static final String MOBILENUMBER = "166661118";
    }

    public class RoadTaxHomePage {
        public static final String OLD_NRIC = "Old NRIC";
        public static final String OWNERID_OLD_NRIC = "5906654";
        public static final String OWNERID_OLD_NRIC_8_CHARACTERS = "59400110";
        public static final String OWNERID_OLD_NRIC_6_CHARACTERS = "594000";
        public static final String POLICE_ARMYID = "Police / Army ID";
        public static final String SPECIAL_CHARACTERS = "123@!#";
        public static final String POLICE_ARMYID_CHARACTERS = "AAAAAA";
        public static final String POLICE_ARMYID_INPUT = "G65456";
        public static final String PASS_PORT = "Passport";
        public static final String OWNERID_PASS_PORT_NUMBER = "546546987";
        public static final String OWNERID_PASS_PORT = "A32089892";
        public static final String OWNERID_PASS_PORT_ALPHANUMERIC = "AARDQERTF";
        public static final String COMPANY_REGISTRATION_NO = "Company registration no.";
        public static final String COMPANY_REGISTRATION_12_DIGITS = "201901009999";
        public static final String COMPANY_NAME_INPUT = "Setel Express Sdn. Bhd";
        public static final String COMPANY_REGISTRATION_6_CHARACTERS = "688555";
        public static final String NEW_NRIC = "New NRIC";
        public static final String OWNERID_NEW_NRIC = "590601-10-5220";
        public static final String OWNERID_NEW_NRIC_E2E = "594020-10-5220";
        public static final String OWNERID_NEW_NRIC_1 = "991122-04-6899";
        public static final String OWNERID_NEW_NRIC_14_CHARACTERS = "590601-10-522021";
        public static final String OWNERID_NEW_NRIC_WITHOUT_12_DIGITS = "590601-10-52";
        public static final String VEHICLE_PLATE_NAME_1 = "AD123";
        public static final String VEHICLE_PLATE_LOWERCASE = "ab123";
        public static final String VEHICLE_PLATE_NAME_2 = "KA123";
        public static final String VEHICLE_PLATE_UPPERCASE = "VEE56";
        public static final String VEHICLE_PLATE_E2E = "VEE56";
        public static final String VEHICLE_PLATE_CONTACT_SPACE = " VEE56";
        public static final String VEHICLE_PLATE_SPECIAL_CHARACTERS = "<,>,/,?,~.@,#,!,&,*,(,),....";
        public static final String VEHICLE_PLATE_HTML_CODE = "<h2>What Can JavaScript Do?</h2>";
        public static final String VEHICLE_PLATE_WITH_OUT_20_CHARACTERS = "AAAAAAA";
        public static final String VEHICLE_PLATE_MORE_THAN_20_CHARACTERS = "ASDEDSDFDFDFRDFGFDFGFF";
        public static final String VEHICLE_PLATE_MORE_THAN_20_ALPHANUMERIC_CHARACTERS = "ASDEDSD123453434543234";
        public static final String OWNER_NAME = "Fidelia test";
        public static final String SOFEA_ARYSSA_BINTI_LUQMAN = "Sofea Aryssa binti Luqman";
        public static final String VEHICLE_PLATE_NO_IS_REQUIRED = "Vehicle plate no. is required";
        public static final String OWNER_ID_NO_IS_REQUIRED = "Owner ID no. is required";
        public static final String OWNER_NAME_IS_REQUIRED = "Owner name is required";

    }

    public class MessageError {
        public static final String COMPANY_NAME_IS_REQUIRED = "Company name is required";
        public static final String PLEASE_ENTER_12_DIGIT_IDENTIFICATION_NUMBER = "Please enter 12-digit identification number";

    }
    public class VehicleInformation{
        public static final String VEHICLE_INFORMATION_VALUE = "YAMAHA LAGENDA 0.1 • 2009";
        public static final String SALOON_NAME = "Saloon";
        public static final String NON_SALOON_NAME = "Non-saloon";
        public static final String DEFAULT_SERVICE_FEE = "RM 15.00";
    }
}
