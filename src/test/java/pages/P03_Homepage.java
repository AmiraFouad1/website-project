package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.Hooks;

import java.util.List;
public class P03_Homepage {
    public P03_Homepage(){
        PageFactory.initElements(Hooks.driver,this);
    }
    WebDriver driver;
    public P03_Homepage(WebDriver driver){
        this.driver= driver;
    }
    // For currency
    public WebElement Currency(){
        return driver.findElement(By.id("customerCurrency"));
    }
    public WebElement verifyEuroSymbol(){
        return driver.findElement(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public List verifyEuroPrice(){
        return driver.findElements
                (By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
    }

    // For Search product
    @FindBy(id = "small-searchterms")
    public WebElement searchField;

    @FindBy(className ="button-1 search-box-button")
    public WebElement searchButton;

    public List<WebElement> productName()
    {
        List<WebElement> products = driver.findElements
                (By.cssSelector("h2[class=\"product-title\"]"));
        return products;
    }

    public List <WebElement> getData(){
        List<WebElement> sameText=
                Hooks.driver.findElements(By.className("item-box"));

        return sameText ;
    }
    public WebElement click_on_product(){
        WebElement element= Hooks.driver.findElement(By.className("picture"));
        return element;
    }
    public WebElement get_product_serial_text(){

        WebElement element =
                Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"]>span[class=\"value\"]"));

        return element;
    }

    // For slider

//    @FindBy(xpath = "(//a[@href=\"http://demo.nopcommerce.com/\"])[1]")
//    public WebElement sliderOne;
//
//    @FindBy(xpath = "(//a[@href=\"http://demo.nopcommerce.com/\"])[2]")
//    public WebElement sliderTwo;

    public WebElement slider(String sliderNum)
    {
        WebElement sliderElement =
                driver.findElement(By.xpath("(//a[@href=\"http://demo.nopcommerce.com/\"])["+sliderNum+"]"));
        return sliderElement;
    }

    //For Follow Us feature
    public WebElement facebook()
    {
        WebElement facebook = driver.findElement(By.xpath("//a[@href=\"https://www.facebook.com/nopCommerce\"]"));
        return facebook;
    }

    public WebElement twitter()
    {
        WebElement twitter= driver.findElement(By.xpath("//a[@href=\"https://twitter.com/nopCommerce\"]"));
        return twitter;
    }

    public WebElement rss()
    {
        WebElement rss= driver.findElement(By.xpath("//a[@href=\"/news/rss/1\"]"));
        return rss;
    }

    public WebElement youtube()
    {
        WebElement youtube= driver.findElement(By.xpath("//a[@href=\"https://www.youtube.com/user/nopCommerce\"]"));
        return youtube;
    }


    //for wishlist feature

    @FindBy(css = "button[class=\"button-2 add-to-wishlist-button\"]")
    public List<WebElement> wishlistButtons;

    @FindBy(id="bar-notification")
    public WebElement successMessage;
//    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div")
//    public WebElement barNotification;

    public WebElement notificationBar(){
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    @FindBy(className = "wishlist-label")
    public WebElement wishlistLabel;

    public WebElement getWishlistQty()
    {
        return driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]"));
    }

    //for hoverCategories feature
    public WebElement categoryList(){
        return driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
    }

    public WebElement desktops(){
        return driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] [href=\"/desktops\"]"));
    }

    public WebElement computers(){
        return driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] [href=\"/computers\"]"));
    }

}
