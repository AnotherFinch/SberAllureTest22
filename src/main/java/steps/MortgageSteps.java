package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MortgagePage;

import static steps.BaseSteps.getDriver;

public class MortgageSteps{

    MortgagePage mortgagePage = new MortgagePage();

   @Step("Ввод стоимости квартиры")
    public void inputEstateCost()  {
        mortgagePage.estateCost.clear();
        mortgagePage.estateCost.sendKeys("5 180 000");
    }

    @Step("Ввод суммы первоначального взнос")
    public void inputInitialFee() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mortgagePage.initialFee).build().perform();
        actions.click();
        mortgagePage.initialFee.clear();
        mortgagePage.initialFee.sendKeys(Keys.CONTROL+"a");
        mortgagePage.initialFee.sendKeys("3 058 000");
    }

    @Step("Ввод срока ипотеки")
    public void inputCreditTerm() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mortgagePage.creditTerm).build().perform();
        actions.click();
        mortgagePage.creditTerm.sendKeys(Keys.CONTROL+"a");
        mortgagePage.creditTerm.clear();
        String text = "30";
        for (char c: text.toCharArray()) {
            Thread.sleep(200);
            mortgagePage.creditTerm.sendKeys(String.valueOf(c));
        }

    }

    @Step("Клик по зарплатной карте")
    public void paid(){
        mortgagePage.scroll(mortgagePage.viewPort1);
        mortgagePage.paidToCardCheck.click();
    }

    @Step("Клик по молодой семье")
    public void youngFamily(){
        getDriver().switchTo().defaultContent();
        mortgagePage.scroll(mortgagePage.viewPort2);
        getDriver().switchTo().frame(mortgagePage.iframe);
        mortgagePage.youngFamilyDiscount.click();
    }

    @Step("Проверка, что появилась возможность подтвердить доход")
    public Boolean canConfirm() {
        return mortgagePage.canConfirmIncome.isEnabled();
    }

    @Step("Получить суммы ипотеки")
    public String getAmountOfCredit() {
        return mortgagePage.amountOfCredit.getText();
    }

    @Step("Получить сумму ежемесячного платежа")
    public String getMonthlyPayment() {
        return mortgagePage.monthlyPayment.getText();
    }

    @Step("Получить сумму необходимого дохода")
    public String getRequiredIncome() {
        return mortgagePage.requiredIncome.getText();
    }

    @Step("Получить процентную ставку по ипотеке")
    public String getRate() {
        return mortgagePage.rate.getText();
    }

    @Step("Переход к iframe")
    public void switchToIframe(){
        getDriver().switchTo().frame(mortgagePage.iframe);
    }


}
