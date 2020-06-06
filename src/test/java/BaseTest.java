
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        sberbankSteps.moveToMortgage();
        sberbankSteps.MortgageFinishedButton();

        mortgageSteps.switchToIframe();
        mortgageSteps.inputEstateCost();
        mortgageSteps.inputInitialFee();
        mortgageSteps.inputCreditTerm();
        mortgageSteps.paid();
        mortgageSteps.mortgageStepsConf();
        mortgageSteps.youngFamily();
        mortgageSteps.checkCheck();
    }
}
