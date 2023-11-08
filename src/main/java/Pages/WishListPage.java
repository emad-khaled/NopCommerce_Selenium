package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage{
    private By productName = By.className("product-name");
    private By removeBtn = By.className("remove-btn");
    private By wishListContent = By.className("wishlist-content");
    private By pageTitle = By.className("page-title");
    private By pageBody = By.className("page-body");


    public WishListPage(WebDriver driver){super(driver);}

    public boolean isWishListContentDisplayed(){
     return find(wishListContent).isDisplayed();
    }
    public String getPageTitle(){
    return     find(pageTitle).getText();
    }
    public String pageBodyContent(){
        return     find(pageBody).getText();
    }
    public void removeItem(){
        click(removeBtn);
    }
}
