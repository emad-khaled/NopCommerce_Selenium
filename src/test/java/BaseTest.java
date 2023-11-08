import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    private final String url ="https://demo.nopcommerce.com/";

@BeforeClass
@Parameters({"browser"})
public void SetUp(@Optional("Chrome Browser")  String browserName) {
    if (browserName.equalsIgnoreCase("Chrome Browser")) {
        driver = new ChromeDriver();
    } else if (browserName.equalsIgnoreCase("Firefox Browser")) {
        driver = new FirefoxDriver();
    } else if (browserName.equalsIgnoreCase("Edge Browser")) {
        driver = new EdgeDriver();
    }
    homePage = new HomePage(driver);
    driver.manage().window().maximize();
    driver.get(url);
}
    @AfterClass
    public void TearDown(){
    driver.quit();
    }
}
