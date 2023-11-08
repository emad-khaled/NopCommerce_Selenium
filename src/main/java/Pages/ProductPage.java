package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{
    private By productName=By.className("product-name");
    private By addToCartBtn=By.id("add-to-cart-button-4");
    private By productQuantityField=By.id("product_enteredQuantity_4");
    private By notification = By.id("bar-notification");

    public ProductPage(WebDriver driver){
        super(driver);
    }
    public String getProductName(){
     return find(productName).getText();
    }
    public void addToCart(){
        click(addToCartBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notification));
    }
    public void setProductQuantity(String quantity){
        type(quantity,productQuantityField);
    }
}
