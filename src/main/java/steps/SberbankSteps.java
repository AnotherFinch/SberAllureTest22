package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import pages.SberbankPage;

import static steps.BaseSteps.getDriver;

public class SberbankSteps {


    SberbankPage sberbankPage = new SberbankPage();

    @Step("Клик по ипотеке")
    public void moveToMortgage(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sberbankPage.mortgageButton).build().perform();
    }

    @Step("Клик по вкладке готовое жилье")
    public void MortgageFinishedButton(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sberbankPage.mortgageFinishedButton).build().perform();
        sberbankPage.mortgageFinishedButton.click();
    }






}
