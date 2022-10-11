package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.P03_Homepage;

public class D06_sliders {
  P03_Homepage Home_Slider = new P03_Homepage();

    @When("user clicks on first slider")
    public void click_First()
    {
        Home_Slider.slider("1").click();
    }
    @Then("relative product for first slider is displayed")
    public void displayed_First() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals
                (Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
    }
    @When("user clicks on second slider")
    public void click_second()
    {
        Home_Slider.slider("2").click();
    }
    @Then("relative product for second slider is displayed")
    public void Displayed_second() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals
                (Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
    }

}
