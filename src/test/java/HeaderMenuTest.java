import Pages.NoteBooksPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderMenuTest extends BaseTest{
    NoteBooksPage noteBook;

    @Test
    public void hoverableMenuTest(){
        noteBook=new NoteBooksPage(driver);
        noteBook =  homePage.navToNoteBooks();
        Assert.assertTrue(noteBook.getPageTitle().contains("Notebooks"),"Page title is wrong");
    }
    @Test
    public void secondaryMenuTest(){
        noteBook=new NoteBooksPage(driver);
        noteBook =  homePage.navToNoteBooks();
        noteBook.backHome();
        Assert.assertTrue(homePage.getWelcome().contains("Welcome to our store"));
    }
}
