package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage{
    //Elements
    private By firstnameField = By.id("FirstName");
    private By lastnameField = By.id("LastName");
    private By dayOfBirthField = By.name("DateOfBirthDay");
    private By monthOfBirthField = By.name("DateOfBirthMonth");
    private By yearOfBirthField = By.name("DateOfBirthYear");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");

    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By confirmationMassage = By.cssSelector("[class='result']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
public void setFirstname(String firstname){
        type(firstname,firstnameField);
}
    public void setLastname(String lastname){
        type(lastname,lastnameField);
    }
 public void selectDate(By field,String value ){
     Select select = new Select(find(field));
     select.selectByVisibleText(value);
 }
public void selectBirthDay(String value){
        selectDate(dayOfBirthField,value);
}
    public void selectBirthMonth(String value){
        selectDate(monthOfBirthField,value);
    }
    public void selectBirthYear(String value){
        selectDate(yearOfBirthField,value);
    }

    public void setEmail(String mail){
        type(mail,emailField);
    }
    public void setPassword (String password){
        type(password,passwordField);
    }
    public void setConfirmPassword (String password){
        type(password,confirmPasswordField);
    }
    public void clickRegister(){
        click(registerButton);
    }

    //Class for confirmation page


        public String getConfirmationMassage(){
            return   find(confirmationMassage).getText();

        }



}
