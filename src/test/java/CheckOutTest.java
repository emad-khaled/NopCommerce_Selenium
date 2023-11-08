import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest{
LoginPage loginPage;
SearchPage searchPage;
ProductPage productPage;
CartPage cartPage;
CheckOutPage checkOutPage;
    @Test
    public void validRegisterTest()  {
        RegisterPage registerPage= homePage.navToRegister();
        registerPage.setFirstname("emad");
        registerPage.setLastname("khaled");
        registerPage.selectBirthDay("20");
        registerPage.selectBirthMonth("January");
        registerPage.selectBirthYear("1998");
        registerPage.setEmail("emad01@gmail.com");
        registerPage.setPassword("Test123");
        registerPage.setConfirmPassword("Test123");
        registerPage.clickRegister();
        Assert.assertTrue(registerPage.getConfirmationMassage().contains("Your registration completed"));
    }
    @Test(priority = 1)
    public void validLoginTest()  {
        homePage.navToLogin();
        loginPage =new LoginPage(driver);
        loginPage.setEmail("emad01@gmail.com");
        loginPage.setPassword("Test123");
        loginPage.login();
        Assert.assertTrue(homePage.getWelcome().contains("Welcome to our store"));
    }
    @Test(priority = 2)
    public void searchResultTest() {
        homePage.searchItem("Apple");
        searchPage=new SearchPage(driver);
        Assert.assertTrue(searchPage.searchForItemName("Apple"));
    }
    @Test (priority = 3)
    public void AddItemToCartTest(){
        searchPage=new SearchPage(driver);
        searchPage.navToProduct();
        productPage=new ProductPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
        productPage.addToCart();
    }
    @Test(priority = 4)
    public void testItemsInCart() {
        homePage.navToCart();
        cartPage = new CartPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/cart");
        Assert.assertTrue(cartPage.getProductName().contains("Apple MacBook Pro 13-inch"), "Wrong item in cart");
    }
    @Test(priority = 5)
    public void checkOutTest () {
        cartPage=new CartPage(driver);
        cartPage.acceptTerms();
        cartPage.navToCheckOut();
        checkOutPage =new CheckOutPage(driver);
        Assert.assertEquals(checkOutPage.getPageTitle(),"Checkout");
        checkOutPage.setCountryField("Egypt");
        checkOutPage.setCityField("Cairo");
        checkOutPage.setAddressOneField("Cairo street");
        checkOutPage.setZipCodeField("1234");
        checkOutPage.setPhoneNumberField("01234567890");
        checkOutPage.continueBillingAddressForm();
        checkOutPage.continueShippingMethodForm();
        checkOutPage.continuePaymentMethod();
        checkOutPage.continuePaymentInformation();
        checkOutPage.confirmOrder();
        Assert.assertTrue(checkOutPage.getConfirmationMsg().contains("Your order has been successfully processed!"),"CheckOut process Failed");
    }
}
