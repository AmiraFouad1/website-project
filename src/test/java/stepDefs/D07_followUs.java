package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.P03_Homepage;

import java.util.ArrayList;

public class D07_followUs {
   P03_Homepage Home_followUs = new P03_Homepage();

    @When("user opens facebook link")
    public void Open_Facebook_Link() throws InterruptedException {
        Home_followUs.facebook().click();
    }

    @When("user opens rss link")
    public void Open_RssLink()
    {
        Home_followUs.rss().click();
    }

    @When("user opens youtube link")
    public void Open_YoutubeLink()
    {
        Home_followUs.youtube().click();
    }

    @When("user opens twitter link")
    public void Open_TwitterLink()
    {
        Home_followUs.twitter().click();
    }

    @Then("^\"(.*)\" is opened in new tab$")
    public void Open_NewTab(String url)
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());

        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1 : actual url = "+Hooks.driver.getCurrentUrl());
        System.out.println("tab 1 : Expected url = "+url);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),url);
        Hooks.driver.close();

        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0 : actual url = "+Hooks.driver.getCurrentUrl());
        System.out.println("tab 1 : Expected url = "+url);
        //Hooks.driver.close();

        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

    }

}
