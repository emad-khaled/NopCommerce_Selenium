package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{
    private By  productName= By.className("product-title");
    private By itemCards=By.className("product-item");
    private By itemLinks = By.className("picture");

    public SearchPage(WebDriver driver){
        super(driver);
    }
    public Boolean searchForItemName(String search){
        var items =   driver.findElements(productName);
        for(WebElement item: items){
            if (item.getText().contains(search)){
                return true;
            }
        }
        return false;
    }
    public boolean isItemsDisplayed(){
       return find(itemCards).isDisplayed();
    }
    public ProductPage navToProduct() {
        driver.findElement(itemLinks).click();
        return new ProductPage(driver);
    }
}
