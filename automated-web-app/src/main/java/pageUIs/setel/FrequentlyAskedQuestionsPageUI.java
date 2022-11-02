package pageUIs.setel;

public class FrequentlyAskedQuestionsPageUI {
    public static final String QUESTIONS_DYNAMIC_TEXT = "xpath=//span[text()='%s']";
    public static final String ANSWERS_DYNAMIC_TEXT = "xpath=(//span[text()='%s']/parent::button/following-sibling::div/p)";
    public static final String ANSWERS_DYNAMIC_LIST_TEXT = "xpath=//span[text()='%s']/parent::button/following-sibling::div/ol/li";
    public static final String LIST_TEXT_BLACK = "xpath=//span[text()='%s']/parent::button/following-sibling::div/ol/li/a[@class='font-medium']";
    public static final String TEXT_BLACK = "xpath=//span[text()='%s']/parent::button/following-sibling::div/p/a[@class='font-medium']";
}
