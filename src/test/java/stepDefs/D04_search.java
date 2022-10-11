package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P03_Homepage;

public class D04_search {
    P03_Homepage Home_Search = new P03_Homepage();
    SoftAssert soft = new SoftAssert();
    @Given("user click on search field")
    public void search()
    {
        Home_Search.searchField.click();
    }

    @And("user search with {string}")
    public void Search_With(String text) {
        Home_Search.searchField.sendKeys(text);
        Home_Search.searchField.sendKeys(Keys.ENTER);
    }

    @Then("user could find  {string} relative words")
    public void Find_Relative_Words(String word) {
        String text = null;
        for (int i = 0; i < Home_Search.getData().size(); i++) {
            text = Home_Search.getData().get(i).getText().toLowerCase();
        }
        soft.assertTrue(text.contains(word));
        String url_expected="https://demo.nopcommerce.com/search?q=";
        String url = Hooks.driver.getCurrentUrl();
        soft.assertTrue(url.contains(url_expected));
        soft.assertAll();

    }

    @Then("user could find  {string} inside product detail page")
    public void Find_Inside_Product_DetailPage(String word1) {
        Home_Search.click_on_product().click();
        String serial_text = Home_Search.get_product_serial_text().getText();
        Assert.assertTrue(word1.contains(serial_text));

    }

}
