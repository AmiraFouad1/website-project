package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.P03_Homepage;

public class D05_categories {
    P03_Homepage Home_Hover = new P03_Homepage();
    String subCategoryName;

    @When("user hover category and select subcategory")
    public void Category() throws InterruptedException {


        Actions action = new Actions(Hooks.driver);
        action.moveToElement(Home_Hover.computers()).perform();
        action.moveToElement(Home_Hover.computers()).perform();

        subCategoryName = Home_Hover.desktops().getText().toLowerCase();

        Thread.sleep(2000);
    }

    @And("user click on subcategory")
    public void Click_Subcategory(){
        Home_Hover.desktops().click();
    }

    @Then("user go to relative product page")
    public void relative_page(){
        Assert.assertEquals(Home_Hover.categoryList().getText().toLowerCase(),subCategoryName,"MSG:subcategory error");
    }

}
