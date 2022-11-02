package setel;

import actions.commons.BaseTest;
import actions.pageObjects.setel.AskedQuestionsObjectPage;
import actions.pageObjects.setel.HomeSetelObjectPage;
import actions.pageObjects.setel.LoginSetelObjectPage;
import actions.commons.PageGeneratorSetelManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static actions.pageObjects.setel.GlobalPage.*;


public class AskedQuestionsTests extends BaseTest {
    private WebDriver driver;
    private String phoneNumber, pin;

    private HomeSetelObjectPage homePage;
    private LoginSetelObjectPage loginPage;
    private AskedQuestionsObjectPage askedQuestionsPage;

    @Parameters("browser")
    @BeforeClass()
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        askedQuestionsPage = PageGeneratorSetelManager.getAskQuestionPage(driver);
//        loginPage = PageGeneratorSetelManager.getLoginPage(driver);
//        phoneNumber = "166661118";
//        pin = "111111";
//        loginPage.enterPhoneNumber(phoneNumber);
//        loginPage.clickToContinue();
//        homePage = loginPage.enterPin(pin);
//        askedQuestionsPage = homePage.clickToFAQ();

    }

    @Description("Register to System")
    @Test
    public void TC_01_How_do_I_know_if_my_transaction_is_successful() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyHowDoIKnowIfMyTransactionSuccessful(), "How do I know if my transaction is successful?");
    }

    @Test
    public void TC_02_Can_I_renew_road_tax_only_without_insurance() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyCanIRenewRoadTaxOnlyWithoutInsurance(), "Can I renew road tax only, without insurance? ");
    }

    @Test
    public void TC_03_Can_i_renew_my_road_tax() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyCanIRenewMyRoadTax(), "Can I renew my road tax?");
    }

    @Test
    public void TC_04_Can_I_renew_my_Road_tax_if_I_have_a_blacklisted_summons() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyCanIRenewMyRoadTaxIfIHaveBlacklistedSummon(), "Can I renew my road tax if I have blacklisted summons?");
    }

    @Test
    public void TC_05_Can_I_renew_my_road_tax_if_my_car_located_at_Sabah_Sarawak_Labuan_Langkawi() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyCanIRenewMyRoadTaxIfMyCarLocatedSabahSarawak(), "Can I renew my road tax if my car is located in Sabah, Sarawak, Labuan, or Langkawi?");
    }

    @Test
    public void TC_06_Can_I_renew_my_Road_Tax_forvehicle_that_is_registered_with_Hailing() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyCanIRenewMyRoadTaxForVehicleWhatIsRegisteredE_Hailing(), "Can I renew my road tax for a vehicle that is registered with E-Hailing?");
    }

    @Test
    public void TC_07_Can_I_renew_my_Road_Tax_forvehicle_that_is_registered_with_Hailing() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhatCanIDoIfEngineCapacityShownForMyVehicleIsIncorrect(), "What can I do if the engine capacity (CC) shown for my vehicle is incorrect?");
    }

    @Test
    public void TC_08_How_much_do_Setel_charge_for_road_tax_renewal_service() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyHowMuchDoSetelChargeForRoadTaxRenewalService(), "How much does Setel charge for road tax renewal?");
    }

    @Test
    public void TC_09_What_can_I_do_if_my_vehicle_make_model_is_not_found_in_the_options_given() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhatcanIdoifmyvehiclemakemodelisnotfoundintheoptionsgiven(), "What can I do if my vehicle make/model is not found in the options given?");
    }

    @Test
    public void TC_10_Can_I_opt_for_6_months_Road_Tax_renewal_instead_of_12months() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyCanIoptfor6monthsRoadTaxrenewalinsteadof12months(), "Can I opt for 6 months road tax renewal instead of 12 months?");
    }

    @Test
    public void TC_11_Can_I_renew_my_Road_Tax_for_a_vehicle_that_is_registered_under_Company_Name() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyCanIrenewmyRoadTaxforvehiclethatisregisteredunderCompanyName(), "Can I renew my road tax for a vehicle that is registered under a company’s name?");
    }
    @Test
    public void TC_12_Is_there_a_transaction_limit_for_paying_road_tax_renewal_with_Setel() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyIsthereatransactionlimitforpayingroadtaxrenewalwithSetel(), "Is there a transaction limit for paying road tax renewal with Setel?");
    }

    @Test
    public void TC_13_The_FAQ_above_does_not_solve_my_problem_What_can_I_do() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyTheFAQabovedoesnotsolvemyproblemWhatcanIdo(), "The FAQ above does not solve my problem. What can I do?");
    }
    @Test
    public void TC_14_Why_have_I_not_received_my_road_tax_after_5_business_days() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhyhaveInotreceivedmyroadtaxafter5businessdays(), "Why have I not received my road tax after 5 business days?");
    }

    @Test
    public void TC_15_What_can_I_do_if_I_have_not_received_my_Road_Tax_within_5_working_days() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhatcanIdoifIhavenotreceivedmyRoadTaxwithin5workingdays(), "Can I opt for redelivery, if I do not receive my road tax within 5 working days?");
    }

    @Test
    public void TC_16_What_can_I_do_if_I_receive_the_wrong_Road_Tax() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhatcanIdoifIreceivethewrongRoadTax(), "What can I do if I receive the wrong road tax?");
    }

    @Test
    public void TC_17_How_can_I_track_my_Road_Tax_Delivery_Progress() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyHowCanITrackMyRoadTaxDeliveryProgress(), "How can I track my road tax delivery progress?");
    }

    @Test
    public void TC_18_How_long_does_the_Road_Tax_Delivery_take() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyHowLongDoesTheRoadTaxDeliveryTake(), "How long does the road tax delivery take?");
    }

    @Test
    public void TC_19_What_should_I_do_if_I_received_my_Road_Tax_damaged() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhatshouldIdoifIreceivedmyRoadTaxdamaged(), "What should I do if the road tax I received is damaged?");
    }

    @Test
    public void TC_20_Who_is_the_fulfilment_partner_for_road_tax() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhoisthefulfilmentpartnerforroadtax(), "Who is the fulfilment partner for road tax?");
    }

    @Test
    public void TC_21_What_should_I_do_if_I_wish_to_update_my_delivery_information() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhatshouldIdoifIwishtoupdatemydeliveryinformation(), "What should I do if I wish to update my delivery information?");
    }

    @Test
    public void TC_22_What_if_I_m_not_at_home_during_road_tax_delivery() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWhatifImnotathomeduringroadtaxdelivery(), "What if I’m not at home during road tax delivery?");
    }
    @Test
    public void TC_23_How_long_does_a_refund_take_once_requested_from_My_Roadtax_store() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyHowlongdoesarefundtakeoncerequestedfromMyRoadtaxStore(), "How long does a refund take once requested from My Roadtax Store?");
    }
    @Test
    public void TC_24_Where_can_I_get_refund_form_for_road_tax() {
        askedQuestionsPage.refreshCurrentPage();
        verifyEquals(askedQuestionsPage.verifyWherecanIgetarefundformforroadtax(),"Where can I get a refund form for road tax?");
    }
//    @Test
//    public void TC_25_Where_can_I_get_refund_form_for_road_tax() {
//        askedQuestionsPage.refreshCurrentPage();
//        verifyEquals(askedQuestionsPage.verifyWherecanIgetarefundformforroadtax(),"Where can I get a refund form for road tax?");
//    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
