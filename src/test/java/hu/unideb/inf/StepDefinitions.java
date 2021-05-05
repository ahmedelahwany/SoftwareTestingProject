package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {

    private static final int WAIT_TIME = 20;

    static WebDriver driver;

    private HomePage homePage;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        //options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
    }

    @Given("The AutomationPractice site is open")
    public void theHomePageIsOpened() {
        homePage = new HomePage(driver);
    }

    @And("The Contact Us link is clicked")
    public void theSignInLinkIsClicked() {
        homePage.clickContactLink();
    }

    @When("The Send button is clicked")
    public void theSendButtonIsClicked() {

          homePage.clicksubmitMessageButton();
    }

    @Given("The {string} is filled with {string}")
    public void theFieldIsFilledWithParameter(String field, String parameter) {
        homePage.clearField(field);
        homePage.fillField(field, parameter);
    }

    @Then("The {string} message is shown")
    public void theMsgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getErrorMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }


    @And("The email field is filled with valid email")
    public void theEmailFieldIsFilledWithValidEmail() {
        homePage.clearField("email");
            homePage.fillField("email", "valid@email.com");
    }

    @When("The search button is clicked")
    public void theSearchButtonIsClicked() {
        homePage.clickSearchBtn();
    }

    @Then("The {string} search error message is shown")
    public void theMsgSearchErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getSearchErrorMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    /////// Registration features
    @And("User Navigate to the login page and submit an email to create account")
    public void userNavigateToTheLoginPageAndSubmitAnEmailToCreateAccount() {
        homePage.clickSignInBtn();
        homePage.fillField("email_create", RandomStringUtils.randomAlphabetic(8) + "@mailnon.com");
        homePage.clickEmailCreateBn();
    }

    @When("The random user details filled in the registeration page")
    public void theRandomUserDetailsFilledInTheRegisterationPage() {
        RegisterationPage registerationPage = new RegisterationPage(driver);
        registerationPage.registerUsingRandomData("All data");

    }

   
    @Given("The {string} is not filled and the rest fields are filled with random registration data")
    public void theFieldIsNotFilledAndTheRestFieldsAreFilledWithRandomRegistrationData(String field) {
        RegisterationPage registerationPage = new RegisterationPage(driver);
        registerationPage.registerUsingRandomData(field);
    }

    @Given("The {string} is filled incorrectly with {string} and the rest fields are filled with correct registration data")
    public void theFieldIsFilledIncorrectlyWithParameterAndTheRestFieldsAreFilledWithCorrectRegistrationData(String field , String parameter) {
        RegisterationPage registerationPage = new RegisterationPage(driver);
        registerationPage.registerUsingSomeInvalidData(field,parameter);
    }


    @Then("verify Created user {string} on the home page")
    public void verifyCreatedUserSoftwareTestingOnTheHomePage(String field) {
        assertEquals(field,homePage.getRegisteredElementText());

    }
    //////////////////////////////////////////////////////////

    @And("The email field is filled with valid user email")
    public void theEmailFieldIsFilledWithValidUserEmail() {
        homePage.clearField("email");
        homePage.fillField("email", "softwaretesting@gmail.com");
    }


    @And("The Sign In Button is clicked")
    public void theSignInButtonIsClicked() {
        homePage.clickSignInBtn();
    }

    @When("The Login button is clicked")
    public void theLoginButtonIsClicked() {
        homePage.clickLoginBtn();
    }

    @And("Sign out")
    public void signOut() {
        homePage.clickSignOutBtn();
    }



    @Then("The {string} successful message is shown")
    public void theProductSuccessfullyAddedToYourShoppingCartSuccessfulMessageIsShown(String msg) {
        Optional<String> successMessage = homePage.getSucessMessage();
        if (successMessage.isPresent()) {
            Assert.assertEquals(msg, successMessage.get());
        } else {
            fail();
        }
    }

    @And("The search button ,add to cart button and proceed to checkout button are clicked")
    public void theSearchButtonAddToCartButtonAndProceedToCheckoutButtonAreClicked() {
        homePage.clickSearchBtn();
        homePage.clickItemImgBtn();
        homePage.clickAddToCartBtn();
        homePage.clickProceedToCheckoutBtn();

    }

    @When("The plus button is clicked")
    public void thePlusButtonIsClicked() {
        homePage.clickPlusBtn();
    }

    @Then("The item count changes to {string}")
    public void theItemCountChangesTo(String number) {
        Optional<String> itemCount = homePage.getItemCount();
        System.out.println(itemCount);
        if (itemCount.isPresent()) {
            Assert.assertEquals(number, itemCount.get());
        } else {
            fail();
        }
    }

    @When("The empty button is clicked")
    public void theEmptyButtonIsClicked() {
        homePage.clickEmptyBtn();
    }


    @And("Sign In")
    public void signIn() {
        homePage.clickSignInBtn();
        homePage.fillField("email", "softwaretesting@gmail.com");
        homePage.fillField("passwd","software");
        homePage.clickLoginBtn();
    }

    @When("The Add To cart Button and the proceed to checkout Btn is clicked")
    public void theAddToCartButtonAndTheProceedToCheckoutBtnIsClicked() {
        homePage.clickAddToCartBtn();
        homePage.clickProceedToCheckoutBtn();
    }

    @Then("The {string} cart message is shown")
    public void theYourShoppingCartIsEmptyCartMessageIsShown( String msg) {
        Optional<String> errorMessage = homePage.getCartMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    @When("The minus button is clicked")
    public void theMinusButtonIsClicked() {
        homePage.clickMinusBtn();
    }

    @And("The Image of the Item is clicked")
    public void theImageOfTheItemIsClicked() {
        homePage.clickItemImgBtn();
    }
}
