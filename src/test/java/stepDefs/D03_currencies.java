package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.P03_Homepage;

public class D03_currencies {
    P03_Homepage Home_Currency = new P03_Homepage(Hooks.driver);

    @When("user Select Euro currency option from the dropdown list on the top left of home page")
    public void select_EuroCurrency() {
        //Static dropdown
        Select select = new Select(Home_Currency.Currency());
        select.selectByVisibleText("Euro");
    }

    @Then("Euro Symbol is displayed on all product")
    public void displayed_EuroSymbol() {
        int count = Home_Currency.verifyEuroPrice().size();
        for (int i = 0; i < count; i++) {
            String symbol = Home_Currency.verifyEuroSymbol().getText();
            Assert.assertTrue(symbol.contains("€"));
        }

    }
}