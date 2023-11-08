package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends BasePage {
    private By pageTitle =By.className("page-title");
    private By countryField = By.id("BillingNewAddress_CountryId");
    private By cityField = By.id("BillingNewAddress_City");
    private By addressOneField = By.id("BillingNewAddress_Address1");
    private By zipCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    private By continueBillingBtn = By.name("save");
    private By continueShippingMethodBtn = By.className("shipping-method-next-step-button");
    private By continuePaymentBtn = By.className("payment-method-next-step-button");
    private By continuePaymentInfoBtn = By.className("payment-info-next-step-button");
    private By confirmBtn = By.className("confirm-order-next-step-button");
    private By confirmationMsg =By.xpath("//strong[text()='Your order has been successfully processed!']");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return find(pageTitle).getText();
    }

    //Methods for filling billing address form
    public void setCountryField(String country) {
        Select select = new Select(find(countryField));
        select.selectByVisibleText(country);
    }

    public void setCityField(String city) {
        type(city, cityField);
    }

    public void setAddressOneField(String addressOne) {
        type(addressOne, addressOneField);
    }

    public void setPhoneNumberField(String phoneNumber) {
        type(phoneNumber, phoneNumberField);
    }

    public void setZipCodeField(String zipCode) {
        type(zipCode, zipCodeField);
    }

    public void continueBillingAddressForm() {
        click(continueBillingBtn);
    }

    public void continueShippingMethodForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingMethodBtn));
        click(continueShippingMethodBtn);
    }

    //Methods for navigate to next form
    public void continuePaymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentBtn));
        click(continuePaymentBtn);

    }

    public void continuePaymentInformation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentInfoBtn));
        click(continuePaymentInfoBtn);

    }

    public void confirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        click(confirmBtn);
    }

    public String getConfirmationMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsg));
        return find(confirmationMsg).getText();
    }
}
