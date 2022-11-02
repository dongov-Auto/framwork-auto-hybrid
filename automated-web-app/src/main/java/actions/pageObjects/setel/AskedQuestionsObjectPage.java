package actions.pageObjects.setel;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

import static actions.pageObjects.setel.GlobalPage.*;
import static pageUIs.setel.FrequentlyAskedQuestionsPageUI.*;

public class AskedQuestionsObjectPage extends BasePage {
    public AskedQuestionsObjectPage(WebDriver driver) {
        super(driver);
    }

    public String verifyCanIRenewRoadTaxOnlyWithoutInsurance() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Can I renew road tax only, without insurance? ");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew road tax only, without insurance? ");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew road tax only, without insurance? ");
        String js = getElementValueByJsXpath(ANSWERS_DYNAMIC_TEXT, "Can I renew road tax only, without insurance? ");
//        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "Can I renew road tax only, without insurance? ");
//        String test = elementsList.get(0).getText();
//        String test1 = elementsList.get(1).getText();
        verifyTrue(js.contains("Your vehicle must have an active insurance coverage for road tax renewal."));
        verifyTrue(js.contains("If your insurance coverage is expiring, you can insure your vehicle with us at motor insurance."));
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Can I renew road tax only, without insurance? ");
    }

    public String verifyCanIRenewMyRoadTax() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax?");
        List<WebElement> elements = getListWebElement(ANSWERS_DYNAMIC_TEXT, "Can I renew my road tax?");
        String a = elements.get(0).getText();
        String a1 = elements.get(1).getText();

        verifyEquals(a, "Of course!");
        verifyEquals(a1, "You will be eligible if you meet all of the criteria below:");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_LIST_TEXT, "Can I renew my road tax?");
        String test1 = elementsList.get(0).getText();
        String test2 = elementsList.get(1).getText();
        String test3 = elementsList.get(2).getText();
        String test4 = elementsList.get(3).getText();
        String test5 = elementsList.get(4).getText();
        String test6 = elementsList.get(5).getText();
        String test7 = elementsList.get(6).getText();
        verifyEquals(test1, "The motor insurance policy hasn’t expired.");
        verifyEquals(test2, "The road tax is at most 2 months away from expiring.");
        verifyEquals(test3, "The vehicle is less than 20 years old.");
        verifyEquals(test4, "You are between 18-75 years old.");
        verifyEquals(test5, "The vehicle has not been blacklisted.");
        verifyEquals(test6, "The vehicle is not used for e-hailing purposes.");
        verifyEquals(test7, "The vehicle is not a motorcycle.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax?");
    }

    public String verifyWhatCanIDoIfEngineCapacityShownForMyVehicleIsIncorrect() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "What can I do if the engine capacity (CC) shown for my vehicle is incorrect?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "What can I do if the engine capacity (CC) shown for my vehicle is incorrect?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "What can I do if the engine capacity (CC) shown for my vehicle is incorrect?");
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "What can I do if the engine capacity (CC) shown for my vehicle is incorrect?"), "Please contact My Roadtax Store to resolve the issue at +603 7491 0102(Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "What can I do if the engine capacity (CC) shown for my vehicle is incorrect?");
    }

    public String verifyHowCanITrackMyRoadTaxDeliveryProgress() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "How can I track my road tax delivery progress?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "How can I track my road tax delivery progress?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "How can I track my road tax delivery progress?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "How can I track my road tax delivery progress?");
        String test = elementsList.get(0).getText();
        verifyEquals(test, "You will receive an email from My Roadtax Store with your delivery tracking code within one business day after your road tax has been shipped.");
        verifyEquals(elementsList.get(1).getText(), "If you did not receive the road tax delivery after five business days, please contact My Roadtax Store to resolve the issue at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "How can I track my road tax delivery progress?");
    }

    public String verifyHowLongDoesTheRoadTaxDeliveryTake() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "How long does the road tax delivery take?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "How long does the road tax delivery take?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "How long does the road tax delivery take?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "How long does the road tax delivery take?");
        String test = elementsList.get(0).getText();
        String test1 = elementsList.get(1).getText();
        verifyEquals(test, "West Malaysia: 3-5 business days.");
        verifyEquals(test1, "East Malaysia: 5-7 business days (if the road tax delivery address is located in East Malaysia).");
        List<WebElement> elementTextBlack = getListWebElement(TEXT_BLACK, "How long does the road tax delivery take?");
        verifyEquals(elementTextBlack.get(0).getText(), "West Malaysia:");
        verifyEquals(elementTextBlack.get(1).getText(), "East Malaysia:");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "How long does the road tax delivery take?");
    }

    public String verifyHowDoIKnowIfMyTransactionSuccessful() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "How do I know if my transaction is successful?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "How do I know if my transaction is successful?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "How do I know if my transaction is successful?");
        sleepInSecond(1);
        List<WebElement> elements = getListWebElement(ANSWERS_DYNAMIC_TEXT, "How do I know if my transaction is successful?");
        String text = elements.get(0).getText();
        String text1 = elements.get(1).getText();
        verifyEquals(text, "You will be able to see a successful payment page and a View Receipt button to view the receipt.");
        verifyEquals(text1, "Alternatively, you can also check the transaction history in the Setel app. Refer to our how-to guide on how to check your payment history to check your recent transactions.");
        List<WebElement> elementsTextBlack = getListWebElement(TEXT_BLACK, "How do I know if my transaction is successful?");
        String test = elementsTextBlack.get(0).getText();
        verifyEquals(test, "View Receipt");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "How do I know if my transaction is successful?");
    }

    public String verifyCanIRenewMyRoadTaxIfIHaveBlacklistedSummon() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax if I have blacklisted summons?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax if I have blacklisted summons?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax if I have blacklisted summons?");
        List<WebElement> elements = getListWebElement(ANSWERS_DYNAMIC_TEXT, "Can I renew my road tax if I have blacklisted summons?");
        String text = elements.get(0).getAttribute("value");
        String text1 = elements.get(1).getAttribute("value");
        System.out.println("text: " + text);
        System.out.println("text1: " + text1);
        verifyEquals(text, "Yes, you can renew your road tax if you are not blacklisted by the Jabatan Pengangkutan Jalan (JPJ) / police.");
        verifyEquals(text1, "If you have pending summons but you are not blacklisted, you can still renew your road tax.");
        List<WebElement> elementsTextBlack = getListWebElement(TEXT_BLACK, "Can I renew my road tax if I have blacklisted summons?");
        verifyEquals(elementsTextBlack.get(0).getText(), "not blacklisted");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax if I have blacklisted summons?");
    }

    public String verifyCanIRenewMyRoadTaxIfMyCarLocatedSabahSarawak() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax if my car is located in Sabah, Sarawak, Labuan, or Langkawi?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax if my car is located in Sabah, Sarawak, Labuan, or Langkawi?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax if my car is located in Sabah, Sarawak, Labuan, or Langkawi?");
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "Can I renew my road tax if my car is located in Sabah, Sarawak, Labuan, or Langkawi?"), "Yes, you can renew your road tax but the road tax pricing will follow the Peninsular Malaysia road tax pricing.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax if my car is located in Sabah, Sarawak, Labuan, or Langkawi?");
    }

    public String verifyCanIRenewMyRoadTaxForVehicleWhatIsRegisteredE_Hailing() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered with E-Hailing?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered with E-Hailing?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered with E-Hailing?");
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered with E-Hailing?"), "Unfortunately, we are unable to process road tax renewal for E-Hailing vehicles at the moment due to JPJ restrictions. You will need to walk into JPJ to renew the road tax for said vehicle.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered with E-Hailing?");
    }

    public String verifyWherecanIgetarefundformforroadtax() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Where can I get a refund form for road tax?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Where can I get a refund form for road tax?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Where can I get a refund form for road tax?");
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "Where can I get a refund form for road tax?"), "My Roadtax Store will email the refund form to your email address upon request.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Where can I get a refund form for road tax?");
    }

    public String verifyWhatcanIdoifmyvehiclemakemodelisnotfoundintheoptionsgiven() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "What can I do if my vehicle make/model is not found in the options given?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "What can I do if my vehicle make/model is not found in the options given?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "What can I do if my vehicle make/model is not found in the options given?");

        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "What can I do if my vehicle make/model is not found in the options given?"), "Please contact My Roadtax Store to resolve the issue at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "What can I do if my vehicle make/model is not found in the options given?");
    }

    public String verifyCanIoptfor6monthsRoadTaxrenewalinsteadof12months() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Can I opt for 6 months road tax renewal instead of 12 months?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Can I opt for 6 months road tax renewal instead of 12 months?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Can I opt for 6 months road tax renewal instead of 12 months?");
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "Can I opt for 6 months road tax renewal instead of 12 months?"), "At the moment, we only cater for 12 months of road tax renewal.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Can I opt for 6 months road tax renewal instead of 12 months?");
    }

    public String verifyCanIrenewmyRoadTaxforvehiclethatisregisteredunderCompanyName() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered under a company’s name?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered under a company’s name?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered under a company’s name?");
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered under a company’s name?"), "Yes, you may renew road tax for company-owned vehicles. Just select Company Registration No. for the ID Type field and fill it in accordingly.");
        List<WebElement> elementsList = getListWebElement(TEXT_BLACK, "Can I renew my road tax for a vehicle that is registered under a company’s name?");
        verifyEquals(elementsList.get(0).getText(), "Company Registration No.");
        verifyEquals(elementsList.get(1).getText(), "ID Type");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Can I renew my road tax for a vehicle that is registered under a company’s name?");
    }
    public String verifyIsthereatransactionlimitforpayingroadtaxrenewalwithSetel() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Is there a transaction limit for paying road tax renewal with Setel?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Is there a transaction limit for paying road tax renewal with Setel?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Is there a transaction limit for paying road tax renewal with Setel?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "Is there a transaction limit for paying road tax renewal with Setel?");
        verifyEquals(elementsList.get(0).getText(), "Road tax renewal follows the single transaction limit of your account.");
        verifyEquals(elementsList.get(1).getText(), "The single transaction limit is:");
        List<WebElement> elementsTextBlack = getListWebElement(LIST_TEXT_BLACK, "Is there a transaction limit for paying road tax renewal with Setel?");
        verifyEquals(elementsTextBlack.get(0).getText(), "not");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Is there a transaction limit for paying road tax renewal with Setel?");
    }

    public String verifyTheFAQabovedoesnotsolvemyproblemWhatcanIdo() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "The FAQ above does not solve my problem. What can I do?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "The FAQ above does not solve my problem. What can I do?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "The FAQ above does not solve my problem. What can I do?");
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "The FAQ above does not solve my problem. What can I do?"), "Please contact My Roadtax Store to resolve the issue at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "The FAQ above does not solve my problem. What can I do?");
    }
    public String verifyWhyhaveInotreceivedmyroadtaxafter5businessdays() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Why have I not received my road tax after 5 business days?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Why have I not received my road tax after 5 business days?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Why have I not received my road tax after 5 business days?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "Why have I not received my road tax after 5 business days?");
        String test = elementsList.get(0).getText();
        String test2 = elementsList.get(1).getText();
        verifyEquals(test, "There are a couple of reasons for not receiving your road tax on time:");
        verifyEquals(test2, "Please contact My Roadtax Store to resolve the issue at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        verifyEquals(elementsList.get(2).getText(), "Please provide the following information to speed up the process:");
        List<WebElement> elements = getListWebElement(ANSWERS_DYNAMIC_LIST_TEXT, "Why have I not received my road tax after 5 business days?");
        String list1 = elements.get(0).getText();
        String list2 = elements.get(1).getText();
        String list3 = elements.get(2).getText();
        verifyEquals(list1, "The road tax is blacklisted by JPJ.");
        verifyEquals(list2, "The road tax delivery attempt has failed.");
        verifyEquals(list3, "The vehicle details are incorrect.");
        verifyEquals(elements.get(3).getText(), "Vehicle plate number");
        verifyEquals(elements.get(4).getText(), "NRIC");
        verifyEquals(elements.get(5).getText(), "Insurance/Takaful Expiry Date");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Why have I not received my road tax after 5 business days?");
    }

    public String verifyWhatcanIdoifIhavenotreceivedmyRoadTaxwithin5workingdays() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Can I opt for redelivery, if I do not receive my road tax within 5 working days?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Can I opt for redelivery, if I do not receive my road tax within 5 working days?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Can I opt for redelivery, if I do not receive my road tax within 5 working days?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "Can I opt for redelivery, if I do not receive my road tax within 5 working days?");
        String test = elementsList.get(0).getText();
        String test2 = elementsList.get(1).getText();
        verifyEquals(test, "Yes. Please contact My Roadtax Store to engage in redelivery at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        verifyEquals(test2, "Please provide the following information to speed up the process:");
        List<WebElement> elements = getListWebElement(ANSWERS_DYNAMIC_LIST_TEXT, "Can I opt for redelivery, if I do not receive my road tax within 5 working days?");
        String list1 = elements.get(0).getText();
        String list2 = elements.get(1).getText();
        String list3 = elements.get(2).getText();
        verifyEquals(list1, "Vehicle plate number");
        verifyEquals(list2, "NRIC");
        verifyEquals(list3, "Insurance/Takaful Expiry Date");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Can I opt for redelivery, if I do not receive my road tax within 5 working days?");
    }

    public String verifyCanIoptforredeliveryifIdonotreceivemyRoadTaxwithin5workingdays() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, Can_I_opt_for_re_delivery_if_I_do_not_receive_my_Road_Tax_within_5_working_days);
        clickToElement(QUESTIONS_DYNAMIC_TEXT, Can_I_opt_for_re_delivery_if_I_do_not_receive_my_Road_Tax_within_5_working_days);
        sleepInSecond(1);
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, Can_I_opt_for_re_delivery_if_I_do_not_receive_my_Road_Tax_within_5_working_days);
        String test = elementsList.get(0).getText();
        String test2 = elementsList.get(1).getText();
//        verifyEquals()(test,"Please contact our partner My Roadtax Store to engage in re-delivery stated above at +603 7491 0102 (Monday-Friday; 10am-7pm) or email general@myroadtax.store");
        verifyEquals(test2, "Do provide the following information to ease the whole process:");
        List<WebElement> elements = getListWebElement(ANSWERS_DYNAMIC_LIST_TEXT, Can_I_opt_for_re_delivery_if_I_do_not_receive_my_Road_Tax_within_5_working_days);
        String list1 = elements.get(0).getText();
        String list2 = elements.get(1).getText();
        String list3 = elements.get(2).getText();
        verifyEquals(list1, "Vehicle No.");
        verifyEquals(list2, "NRIC");
        verifyEquals(list3, "Insurance/Takaful Expiry Date");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, Can_I_opt_for_re_delivery_if_I_do_not_receive_my_Road_Tax_within_5_working_days);
    }

    public String verifyWhatcanIdoifIreceivethewrongRoadTax() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "What can I do if I receive the wrong road tax?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "What can I do if I receive the wrong road tax?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "What can I do if I receive the wrong road tax?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "What can I do if I receive the wrong road tax?");
        verifyEquals(elementsList.get(0).getText(), "Please contact My Roadtax Store to resolve the issue at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        verifyEquals(elementsList.get(1).getText(), "My Roadtax Store will promptly deliver the correct road tax to you.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "What can I do if I receive the wrong road tax?");
    }

    public String verifyWhatshouldIdoifIreceivedmyRoadTaxdamaged() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "What should I do if the road tax I received is damaged?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "What should I do if the road tax I received is damaged?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "What should I do if the road tax I received is damaged?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "What should I do if the road tax I received is damaged?");
        verifyEquals(elementsList.get(0).getText(), "Please contact My Roadtax Store to resolve the issue at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        verifyEquals(elementsList.get(1).getText(), "My Roadtax Store will reissue a new road tax free of charge.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "What should I do if the road tax I received is damaged?");
    }
    public String verifyWhoisthefulfilmentpartnerforroadtax() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "Who is the fulfilment partner for road tax?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "Who is the fulfilment partner for road tax?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "Who is the fulfilment partner for road tax?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "Who is the fulfilment partner for road tax?");
        verifyEquals(elementsList.get(0).getText(), "We are partnering with My Roadtax Store as our fulfilment partner. They are responsible to deliver your road tax and processing any refunds or requests for top-ups.");
        verifyEquals(elementsList.get(1).getText(), "MPlease contact My Roadtax Store to resolve any issue at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "Who is the fulfilment partner for road tax?");
    }
    public String verifyWhatshouldIdoifIwishtoupdatemydeliveryinformation() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "What should I do if I wish to update my delivery information?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "What should I do if I wish to update my delivery information?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "What should I do if I wish to update my delivery information?");
        sleepInSecond(1);
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "What should I do if I wish to update my delivery information?");
        String test = elementsList.get(0).getText();
        String test2 = elementsList.get(1).getText();
        verifyEquals(test, "Please contact My Roadtax Store to resolve the issue at +603 7491 0102 (Monday-Friday; 10:00 AM-7:00 PM) or email at general@myroadtax.store.");
        verifyEquals(test2, "Do note that once the road tax is out for delivery, the delivery details for it will not be able to be updated.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "What should I do if I wish to update my delivery information?");
    }

    public String verifyWhatifImnotathomeduringroadtaxdelivery() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "What if I’m not at home during road tax delivery?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "What if I’m not at home during road tax delivery?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "What if I’m not at home during road tax delivery?");
        sleepInSecond(1);
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "What if I’m not at home during road tax delivery?"), "The courier services will attempt to redeliver for a 2nd time. If the 2nd attempt fails, your parcel will be delivered to the nearest district stock centre from your home.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "What if I’m not at home during road tax delivery?");
    }
    public String verifyHowlongdoesarefundtakeoncerequestedfromMyRoadtaxStore() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "How long does a refund take once requested from My Roadtax Store?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "How long does a refund take once requested from My Roadtax Store?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "How long does a refund take once requested from My Roadtax Store?");
        sleepInSecond(1);
        verifyEquals(getElementText(ANSWERS_DYNAMIC_TEXT, "How long does a refund take once requested from My Roadtax Store?"), "Once the refund form is submitted successfully, it should take no longer than 14 business days to be reflected in your preferred bank account.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "How long does a refund take once requested from My Roadtax Store?");
    }
    public String verifyHowMuchDoSetelChargeForRoadTaxRenewalService() {
        waitForElementVisible(QUESTIONS_DYNAMIC_TEXT, "How much does Setel charge for road tax renewal?");
        scrollToElement(QUESTIONS_DYNAMIC_TEXT, "How much does Setel charge for road tax renewal?");
        clickToElement(QUESTIONS_DYNAMIC_TEXT, "How much does Setel charge for road tax renewal?");
        List<WebElement> elementsList = getListWebElement(ANSWERS_DYNAMIC_TEXT, "How much does Setel charge for road tax renewal?");
        String test = elementsList.get(0).getText();
        String test2 = elementsList.get(1).getText();
        String test3 = elementsList.get(2).getText();
        String test4 = elementsList.get(3).getText();
        verifyEquals(test, "We charge RM20-RM23 for the road tax renewal.");
        verifyEquals(test2, "Delivery fees for peninsular Malaysia is RM15 while Sabah and Sarawak is RM18.");
        verifyEquals(test3, "Delivery fees are inclusive of printing fee, delivery fee & 6% SST.");
        verifyEquals(test4, "RM5 is for the service fee.");
        List<WebElement> elementsTextBlack = getListWebElement(TEXT_BLACK, "How much does Setel charge for road tax renewal?");
        verifyEquals(elementsTextBlack.get(0).getText(), "peninsular Malaysia is RM15");
        verifyEquals(elementsTextBlack.get(1).getText(), "Sabah and Sarawak is RM18.");
        return getElementText(QUESTIONS_DYNAMIC_TEXT, "How much does Setel charge for road tax renewal?");
    }


}
