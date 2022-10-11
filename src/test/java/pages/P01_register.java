package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepDefs.Hooks;
import org.openqa.selenium.support.PageFactory;

public class P01_register {
    public P01_register(){

        PageFactory.initElements(Hooks.driver,this);
}
    @FindBy(className= "ico-register")
    public WebElement registerLink;

    @FindBy(className = "gender")
    public WebElement gender;

    //User Name
    @FindBy(id = "FirstName")
    public WebElement firstName;
    @FindBy(id = "LastName")
    public WebElement lastName;

    //User DateOfBrith
    @FindBy(name = "DateOfBirthDay")
    public WebElement dayOfDate;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthOfDate;

    @FindBy(name = "DateOfBirthYear")
    public WebElement yearOfDate;

    // user email and company
    @FindBy(id="Email")
    public WebElement email;

    @FindBy(id="Company")
    public WebElement company;

    //user Password and confirm Password
    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id="register-button")
    public WebElement registerButton;

    @FindBy(className = "result")
    public WebElement successMsg;

}
