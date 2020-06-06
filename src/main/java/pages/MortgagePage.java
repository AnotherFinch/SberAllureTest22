package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgagePage extends BasePage {

    @FindBy(xpath = "//iframe[@id='iFrameResizer0']")
    public WebElement iframe;

    @FindBy(xpath = "//input[@id='estateCost']")
    public WebElement estateCost;

    @FindBy(xpath = "//input[@id='initialFee']")
    public WebElement initialFee;

    @FindBy(xpath = "//input[@id='creditTerm']")
    public WebElement creditTerm;

    @FindBy(xpath = "//div[div[text()='Молодая семья']]//label")
    public WebElement youngFamilyDiscount;

    @FindBy(xpath = "//div[@class=\"dcCalc_switch-tablet__title\" and contains(text(),'Есть возможность подтвердить доход справкой')]/parent::div")
    public WebElement canConfirmIncome;

    @FindBy(xpath = "//div[div[text()='Есть зарплатная карта Сбербанка']]//label")
    public WebElement paidToCardCheck;

    @FindBy(xpath = "//div[@class='dcCalc_disclaimer']")
    public WebElement viewPort1;

    @FindBy(xpath = "//h2[contains(text(),'подать заявку')]")
    public WebElement viewPort2;

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    public WebElement amountOfCredit;

    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    public WebElement monthlyPayment;

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    public WebElement requiredIncome;

    @FindBy(xpath = "//span[@data-test-id='rate']")
    public WebElement rate;

    private void fillField(WebElement element, String value) {
        waitUntilClickable(element);
        clearField(element);
        clickElement(element);
        element.sendKeys(value);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Стоимость":
                fillField(estateCost, value);
                break;
            case "Взнос":
                fillField(initialFee, value);
                break;
            case "Срок":
                fillField(creditTerm, value);
                break;
        }
    }


}
