package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P03_Homepage;

public class D08_wishlist {
    P03_Homepage Home_Wishlist_ = new P03_Homepage();
    SoftAssert soft = new SoftAssert();

    @When("user clicks on wishlist button on product")
    public void Click_On_Wishlist () throws InterruptedException {
        Home_Wishlist_.wishlistButtons.get(2).click();
        Thread.sleep(2000);
    }

    @Then("success message is visible")
    public void See_Green_Message() throws InterruptedException {
        Assert.assertTrue(Home_Wishlist_.notificationBar().isDisplayed());
        Thread.sleep(3000);
        soft.assertTrue(Home_Wishlist_.successMessage.getText().contains("The product has been added to your wishlist"),"First Assertion");
        String actual = Home_Wishlist_.successMessage.getCssValue("background-color");
        String expected = "rgba(75, 176, 122, 1)";
        soft.assertEquals(actual, expected, "MSG error: Second Assertion");
        soft.assertAll();
    }
    int number;
    @And("user get the number wishlist items")
    public void Get_Number_Items()
    {
        String text = Home_Wishlist_.getWishlistQty().getText();
        text= text.replaceAll("[^0-9]","");
        number = Integer.parseInt(text);
    }

    @Then("number of wishlist increased")
    public void Number_Increased()
    {
        Assert.assertTrue(number>0);

    }

}
