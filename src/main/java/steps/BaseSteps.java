package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SingleProperty;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {


    private static WebDriverWait wait;
    private static WebDriver driver;
    private static String baseUrl;
    private static Properties properties = SingleProperty.getInstance().getProperties();

    public static WebDriver getDriver(){

        return driver;
    }
    public static WebDriverWait getWait() {
        return wait;
    }

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();

        baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
