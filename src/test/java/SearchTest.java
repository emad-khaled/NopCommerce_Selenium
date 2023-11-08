import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    SearchPage searchPage;
    @Test
    public void invalidSearchTest()  {
        homePage.searchItem("");
        driver.switchTo().alert().accept();
    }
    @Test
    public void searchResultTest() {
        homePage.searchItem("Apple");
        searchPage=new SearchPage(driver);
        Assert.assertTrue(searchPage.isItemsDisplayed());
        Assert.assertTrue(searchPage.searchForItemName("Apple"));
    }


}
