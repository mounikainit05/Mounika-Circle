package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    public WebElement My_account;

    @FindBy(linkText = "Login")
    public WebElement login;

    @FindBy(id="input-email")
    public WebElement username;

    @FindBy(id="input-password")
    public WebElement pwd;

    @FindBy(xpath = "//*[@value=\"Login\"]")
    public WebElement loginbtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
