package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SberbankPage extends BasePage{


        @FindBy(xpath = "//span[text()='Ипотека']")
        public WebElement mortgageButton;

        @FindBy(xpath = "//a[contains(text(),'готовое') and contains(@class,'lg')]")
        public WebElement mortgageFinishedButton;


}
