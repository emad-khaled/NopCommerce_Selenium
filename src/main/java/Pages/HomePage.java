package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    //Elements
    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Log in");
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.className("search-box-button");
    private By computersLink = By.partialLinkText("Computers");
    private By notebooksLink = By.partialLinkText("Notebooks");
    private By apparelLink = By.partialLinkText("Apparel");
    private By clothingLink = By.partialLinkText("Clothing");
    private By cartLink = By.id("topcartlink");
    private By addToWishList = By.cssSelector("[title='Add to wishlist']");
    private By wishListLink = By.className("ico-wishlist");
    private By welcome = By.xpath("//div[@class ='topic-block-title']/h2");
    private By notification =By.id("bar-notification");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage navToRegister() {
        click(registerLink);
        return new RegisterPage(driver);
    }

    public LoginPage navToLogin() {
        click(loginLink);
        return new LoginPage(driver);
    }

    //Get welcome massage after login
    public String getWelcome() {
        return find(welcome).getText();
    }
    //Navigate to section by hover To header Dropdown Menu and click on link

    public NoteBooksPage navToNoteBooks() {
        hover(find(computersLink));
        click(notebooksLink);
        return new NoteBooksPage(driver);
    }
    //Navigate to Macbook product page


    //Navigate to Shopping Cart
    public CartPage navToCart() {
        click(cartLink);
        return new CartPage(driver);
    }

    //Search for items
    public SearchPage searchItem(String searchText) {
        type(searchText, searchBox);
        click(searchButton);
        return new SearchPage(driver);
    }

    public void addToWishList(int ItemNumber) {
        var addToWishListBtn = driver.findElements(addToWishList);
        addToWishListBtn.get(ItemNumber-1).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notification));
    }

    public WishListPage navToWishList() {
        click(wishListLink);
        return new WishListPage(driver);
    }
}