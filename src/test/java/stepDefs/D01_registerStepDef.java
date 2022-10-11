package stepDefs;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.Select;

import org.testng.asserts.SoftAssert;
import pages.P01_register;

public class D01_registerStepDef {

        P01_register register = new P01_register();

        @Given("user go to register page")
        public void Register_Page()
        {
                register.registerLink.click();
        }
        @When("user select gender type")
        public void select_Gender()
        {
                register.gender.click();
        }
        @And("user enter first name and last name")
        public void Set_Name()
        {
                register.firstName.sendKeys("amira");
                register.lastName.sendKeys("fouad");
        }
        @And("user enter date of birth")
        public void Date_Of_Brith()
        {
                Select selectDay = new Select(register.dayOfDate);
                selectDay.selectByVisibleText("20");

                Select selectMonth = new Select(register.monthOfDate);
                selectMonth.selectByVisibleText("April");

                Select selectYear = new Select(register.yearOfDate);
                selectYear.selectByVisibleText("2000");
        }
        @And("user enter email and company Name")
        public void set_Email()
        {
                register.email.sendKeys("amirafouad123@gmail.com");
                register.company.sendKeys("Company Name");
        }
        @And("user fills Password fields")
        public void set_Password()
        {
                register.password.sendKeys("P@ssw0rd");
                register.confirmPassword.sendKeys("P@ssw0rd");
        }

        @Then("user clicks on register button")
        public void clicksRegister()
        {
                register.registerButton.click();
        }
        @And("success message is displayed")
        public void successMsg(){
                SoftAssert soft = new SoftAssert();
                soft.assertTrue(register.successMsg.isDisplayed(),
                        "Your registration completed");
                String expectedResult = "rgba(76, 177, 124, 1)";
                String actualResult = register.successMsg.getCssValue("color");
                soft.assertEquals(actualResult,expectedResult,"Msg Color");
                soft.assertAll();
        }



        }



