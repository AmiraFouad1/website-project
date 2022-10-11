package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.P02_login;

public class D02_login {
    P02_login login = new P02_login(Hooks.driver);


    @Given("user go to login page")
    public void goToLoginPage()
    {
        login.loginLink().click();
    }

    @When("^user login with \"valid\" \"(.*)\" and \"(.*)\"$")
    public void Login_With_Valid_Data(String username,String password)throws InterruptedException
    {
        login.loginSteps(username,password);
        Thread.sleep(3000);
    }

    @When("^user login with \"invalid\" \"(.*)\" and \"(.*)\"$")
    public void Login_With_Invalid_Data(String username , String password)
    {
        login.loginSteps(username,password);
    }

    @And("user press on login button")
    public void Login_Button(){
        login.loginButton().click();
    }

    @Then("user login to the system successfully")
    public void SuccessLogin() throws InterruptedException
    {
        SoftAssert soft = new SoftAssert();
        String expectedResult = "https://demo.nopcommerce.com/login?returnurl=%2F";
        String actualResult = Hooks.driver.getCurrentUrl();
        soft.assertEquals(actualResult,expectedResult,"URL");
        soft.assertAll();
        Thread.sleep(3000);
    }

    @Then("user could not login to the system")
    public void error()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.ErrorMsg().getText().contains("Login was unsuccessful."));
        soft.assertAll();
    }

}
