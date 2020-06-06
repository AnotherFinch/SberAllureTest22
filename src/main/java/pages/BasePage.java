package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class BasePage {
    WebDriver driver = BaseSteps.getDriver();
    WebDriverWait wait = BaseSteps.getWait();

    public BasePage(){
        PageFactory.initElements(driver,this);
    }


    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void scrollIntoView(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) BaseSteps.getDriver();
        js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
    }

    public void waitEnableFrame(WebElement element) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void waitUntilClickable(WebElement element) {
        BaseSteps.getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clearField(WebElement element) {
        waitUntilClickable(element);
        element.clear();
        while (element.getText().length() > 0) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clickElement(WebElement element) {
        BaseSteps.getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
