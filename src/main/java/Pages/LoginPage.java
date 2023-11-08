package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("button.login-button");
    public LoginPage(WebDriver driver){
        super(driver);
    }
public void setEmail(String email){
        type( email,emailField);
}
public void setPassword (String password){
        type(password,passwordField);
}
public HomePage login(){
        click(loginButton);
        return new HomePage(driver);
}

}
