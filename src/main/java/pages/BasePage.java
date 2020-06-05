package pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class BasePage {
    WebDriver driver = BaseSteps.getDriver();

    public BasePage(){
        PageFactory.initElements(driver,this);
    }


        public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }
}
