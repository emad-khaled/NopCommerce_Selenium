package Pages;

import io.opentelemetry.api.internal.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.stream.Collectors;

public class CartPage extends BasePage {
    private By productName = By.className("product-name");
    private By unitPrice = By.className("product-unit-price");
    private By quantityField = By.className("qty-input");
    private By productTotalPrice = By.className("product-subtotal");
    private By checkOutBtn = By.id("checkout");
    private By termsCheckBox =By.id("termsofservice");

    private By removeButton = By.cssSelector(".remove-from-cart button");
    private By emptyCartMsg = By.className("no-data");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return find(productName).getText();
    }

    public String getUnitPrice() {
        return find(unitPrice).getText();
    }

    public String getQuantity() {
        return find(quantityField).getAttribute("value");
    }

    public String getProductTotal() {
        return find(productTotalPrice).getText();
    }

    public void removeItem() {
        click(removeButton);
    }

    public String getEmptyCartMsg() {
        return find(emptyCartMsg).getText();
    }
    public void agreeTerms(){
        click(termsCheckBox);
    }
    public void acceptTerms (){
        click(termsCheckBox);
    }
    public CheckOutPage navToCheckOut(){
        click(checkOutBtn);
        return new CheckOutPage(driver);
    }

}