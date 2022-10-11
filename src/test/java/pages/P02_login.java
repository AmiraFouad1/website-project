package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class P02_login {
    WebDriver driver ;
    public P02_login(WebDriver driver) {
        this.driver = driver;
    }
    //user go to login page
    public WebElement loginLink(){
        return driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }

    //loginWithValidData
    public WebElement setEmail(){
        return driver.findElement(By.id("Email"));
    }
    public WebElement setPassword(){
        return driver.findElement(By.id("Password"));
    }

    public void loginSteps( String username , String password){
        setEmail().clear();
        setEmail().sendKeys(username);
        setPassword().sendKeys(password);
    }

    //user press on login button
    public WebElement loginButton(){
        return driver.findElement
                (By.cssSelector("button[class=\"button-1 login-button\"]"));
    }

    public WebElement ErrorMsg(){
        return driver.findElement(By.cssSelector
                ("div[class=\"message-error validation-summary-errors\"]"));
    }


}


