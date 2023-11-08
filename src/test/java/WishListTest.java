import Pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest{
    WishListPage wishList;
    @Test
    public void addItemToWishList(){
        homePage.addToWishList(3);
        wishList = new WishListPage(driver);
        homePage.navToWishList();
        Assert.assertEquals(wishList.getPageTitle(), "Wishlist","Wrong Page Title");
        Assert.assertTrue(wishList.isWishListContentDisplayed());
        wishList.removeItem();
        Assert.assertTrue(wishList.pageBodyContent().contains("The wishlist is empty!"),"Wrong Page Content");

    }
}
