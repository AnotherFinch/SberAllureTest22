
import com.google.common.base.Function;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MortgagePage;
import steps.BaseSteps;
import steps.MortgageSteps;
import steps.SberbankSteps;

public class BaseTest extends BaseSteps {

    @Test
    @DisplayName("Ипотека в сбербанке")
    public void Sberbank() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        SberbankSteps sberbankSteps = new SberbankSteps();
        MortgageSteps mortgageSteps = new MortgageSteps();
        MortgagePage mortgagePage = new MortgagePage();

        sberbankSteps.moveToMortgage();
        sberbankSteps.MortgageFinishedButton();

        mortgageSteps.switchToIframe();
        mortgageSteps.inputEstateCost();
        mortgageSteps.inputInitialFee();
        mortgageSteps.inputCreditTerm();
        mortgageSteps.paid();
        wait.until((Function<? super WebDriver, Boolean>) driver -> mortgageSteps.canConfirm());
        mortgageSteps.youngFamily();


        Assert.assertEquals("Стоимость квартиры не совпадает",
                "5 180 000 ₽", mortgageSteps.getAmountOfCredit());
        Assert.assertEquals("Сумма ежемесячного дохода не совпадает",
                "18 937 ₽", mortgageSteps.getMonthlyPayment());
        Assert.assertEquals("Сумма необходимого дохода не совпадет",
                "31 561 ₽", mortgageSteps.getRequiredIncome());
        Assert.assertEquals("Процентная ставка по ипотеке не совпадает",
                "11 %", mortgageSteps.getRate());
    }
}
