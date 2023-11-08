
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RegisterTest extends BaseTest{

    @Test
    public void validRegisterTest()  {
    RegisterPage registerPage= homePage.navToRegister();
    registerPage.setFirstname("emad");
    registerPage.setLastname("khaled");
    registerPage.selectBirthDay("20");
    registerPage.selectBirthMonth("January");
    registerPage.selectBirthYear("1998");
    registerPage.setEmail("emad11@gmail.com");
    registerPage.setPassword("Test123");
    registerPage.setConfirmPassword("Test123");
    registerPage.clickRegister();
    Assert.assertTrue(registerPage.getConfirmationMassage().contains("Your registration completed"));
    }
}

