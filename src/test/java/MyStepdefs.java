import Pages.CustomerRegistrationPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyStepdefs {
    WebDriver driver;


    LoginPage loginPage;
    CustomerRegistrationPage customerRegistrationPage;
    HomePage  homePage;
    WebDriverWait wait;

    Actions action;

    @Before
    public void start(){

        driver = TestRunner.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver,6000);
        action = new Actions(driver);

    }
    @Given("User navigates to the application")
    public void userNavigatesToTheApplication() throws InterruptedException {

        String actualtitle = driver.getTitle();
        String exptitle = "Private Hospitals & Health Care Services | Circle Health Group";
        Assert.assertEquals(exptitle,actualtitle);
        driver.findElement(By.xpath("(//*[contains(text(),\"Accept all cookies\")])[2]")).click();

        Thread.sleep(4000);
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {

        loginPage.My_account.click();
        loginPage.login.click();

        loginPage.username.sendKeys("admin");
        loginPage.pwd.sendKeys("admin");
    }

    @And("Clicks on Login button")
    public void clicksOnLoginButton() {
        loginPage.loginbtn.click();
    }

    @Then("User is navigated to the Dashboard page")
    public void userIsNavigatedToTheDashboardPage() {
    }

    @When("User navigates to find a treatment from menu displayed and clicks on knee replacement")
    public void userNavigatesToFindATreatmentFromMenuDisplayedAndClicksOnKneeReplacement() {


       // wait.until(ExpectedConditions.visibilityOf(homePage.find_treatment));

        //Actions action = new Actions(driver);
        //action.moveToElement(homePage.find_treatment).build().perform();
        homePage.mousehover_appointment();
        String actualtitle = driver.getTitle();
        String exptitle = "Find an appointment | Circle Health Group";
        Assert.assertEquals(exptitle,actualtitle);
    }

    @When("User navigates to find a appointment by clicking book appointment")
    public void userNavigatesToFindAAppointmentByClickingBookAppointment() {

        homePage.book_appointment.click();

    }

    @And("User searches and selects knee replacement")
    public void userSearchesAndSelectsKneeReplacement() {
        homePage.search_treatment.sendKeys("knee");
               //ul[@class='f-nav f-nav-autocomplete f-autocomplete-results']//li

    }


    @And("User searches{string} and selects {string}")
    public void userSearchesAndSelects(String search, String type) throws InterruptedException {

        homePage.search_treatment.sendKeys(search);

//        List<WebElement>option= driver.findElements(By.xpath("//ul[@class='f-nav f-nav-autocomplete f-autocomplete-results']"));
//
//
//        for(WebElement ele:option){
//
//
//            String currentoption = ele.getText();
//
//            if (currentoption.equals(type)){
//                ele.click();
//                break;
//            }}


       Thread.sleep(6000);


        //driver.findElement(By.xpath("//a[contains(text(),\"Knee replacement surgery\")]")).click();

        driver.findElement(By.linkText("Knee replacement surgery")).click();

    }



    @And("User enters postcode town and clicks on search")
    public void userEntersPostcodeTownAndClicksOnSearch() throws InterruptedException {
        homePage.cur_location.click();
        Thread.sleep(6000);
        homePage.search_btn.click();
        Thread.sleep(6000);
    }

    @And("User selects the calendar date displayed")
    public void userSelectsTheCalendarDateDisplayed() {
        homePage.date.click();
    }

    @And("User clicks on booknow option displayed")
    public void userClicksOnBooknowOptionDisplayed() {
        homePage.booknow.click();
    }

    @Then("User is navigated to the booking confirmation page to finish the booking")
    public void userIsNavigatedToTheBookingConfirmationPageToFinishTheBooking() {


        Assert.assertEquals(true,homePage.confirmation.isDisplayed());
        Assert.assertEquals(true,homePage.complete_booking.isDisplayed());
    }
}
