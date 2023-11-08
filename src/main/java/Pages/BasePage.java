package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver =driver;
    }
    public WebElement find(By locator){
       return driver.findElement(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void type(String text ,By locator){
        find(locator).clear();
        find(locator).sendKeys(text);
    }
    public void hover(WebElement locator){
        Actions hover = new Actions(driver) ;
        hover.moveToElement(locator).perform();
    }
    public void scroll(){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,450)");
    }
public void explicitWait(){
    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
}
}
