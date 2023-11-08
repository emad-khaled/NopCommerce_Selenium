package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoteBooksPage extends BasePage{
    private By pageTitle = By.cssSelector(".page-title h1");
    private   By homeLink = By.linkText("Home");

    public NoteBooksPage(WebDriver driver){
        super(driver);
    }
    public String getPageTitle(){
      return  find(pageTitle).getText();
    }
    public HomePage backHome(){
       click(homeLink);
       return new HomePage(driver);
    }
}
