package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    public WebElement My_account;


    @FindBy(linkText = "Find a treatment ")
    public  WebElement  find_treatment;

    @FindBy(xpath = "(//span[contains(text(),'Book an appointment')])[1]")
    public WebElement book_appointment;


    @FindBy(id="treatment")
    public WebElement search_treatment;


    @FindBy(xpath = "//ul[@class='f-nav f-nav-autocomplete f-autocomplete-results']//li")
    public WebElement options;


    @FindBy(id = "Location")
    public WebElement location;

    @FindBy(xpath = "//*[@class='f-btn-faux search-form--coords']")
    public WebElement cur_location;

    @FindBy(xpath = "//button[contains(text(),\"Search\")]")
    public WebElement  search_btn;

    @FindBy(xpath = "//*[@id=\"datepicker\"]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[41]/span")
    public WebElement date;

    @FindBy(xpath = "(//*[contains(text(),\"Book now\")])[1]")
    public WebElement booknow;

    @FindBy(xpath = "(//*[contains(text(),\" Confirmation\")])")
    public WebElement confirmation;

    @FindBy(xpath = "(//*[contains(text(),\"Complete booking\")])")
    public WebElement complete_booking;


    public void mousehover_appointment(){

        Actions action = new Actions(driver);
        action.moveToElement(find_treatment).build().perform();
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
