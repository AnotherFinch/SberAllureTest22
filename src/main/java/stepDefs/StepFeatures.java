package stepDefs;
import io.cucumber.java.en.When;
import steps.MortgageSteps;
import steps.SberbankSteps;

public class StepFeatures {

    private SberbankSteps sberbankSteps = new SberbankSteps();
    private MortgageSteps mortgageSteps = new MortgageSteps();

    @When("В верхнем меню выбрана Ипотека")
    public void selectMenuItem(){
        sberbankSteps.moveToMortgage();
    }

    @When("выбрана 'Ипотека на готовое жилье'")
    public void selectMenuInsurance(){
        sberbankSteps.MortgageFinishedButton();
    }


    @When("Снять галочку - есть зарплатная карта сбербанка")
    public void removeCheckBox (){
        mortgageSteps.paid();
    }

    @When("дождаться появления 'есть возможность подтвердить доход справкой'")
    public void waitApprove (){
        mortgageSteps.canConfirm();
    }


    @When("поставить галочку 'молодая семья'")
    public void updateCheckFamilyBox(){
        mortgageSteps.youngFamily();
    }




}


