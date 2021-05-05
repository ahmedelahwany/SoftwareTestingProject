package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com/";



    @FindBy(id = "contact-link")
    private WebElement contactLink;

    @FindBy(xpath = "//*[@class='account']/span")
    private  WebElement registeredUserName;

    @FindBy(className = "login")
    private WebElement SignInBtn;

    @FindBy(className = "logout")
    private WebElement SignoutBtn;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement LoginBtn;

    @FindBy(id = "email")
    private WebElement emailBtnContact;
    @FindBy(name = "SubmitCreate")
    private WebElement EmailCreateBtn;

    @FindBy(name = "submit_search")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    private WebElement AddToCartBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]")
    private WebElement ItemImgBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement SearchErr;
    @FindBy(xpath = "//*[@id=\"cart_title\"]/span")
    private WebElement SuccesMessage;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement ProceedToCheckoutBtn;

    @FindBy(xpath = "//*[@id=\"cart_quantity_up_5_19_0_0\"]/span")
    private WebElement PlusButton;

    @FindBy(xpath = "//*[@id=\"cart_quantity_down_5_19_0_0\"]/span")
    private WebElement MinusButton;

    @FindBy(xpath = "//*[@id=\"product_5_19_0_0\"]/td[5]/input[1]")
    private WebElement itemCount;

    @FindBy(xpath = "//*[@id=\"submitMessage\"]/span")
    private WebElement submitMessageButton;

    @FindBy(className = "cart_quantity_delete")
    private WebElement EmptyCartBtn;

    @FindBy(className = "alert-warning")
    private WebElement cartMsg;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

   ///////////////////// Clicks //////////////////////////
    public void clickContactLink() {
        contactLink.click();
    }
    public void clickSearchBtn() {
        searchBtn.click();
    }
    public void clickSignInBtn() {
        SignInBtn.click();
    }
    public void clickEmailCreateBn() {
        EmailCreateBtn.click();
    }
    public void clickLoginBtn() {
        LoginBtn.click();
    }
    public void clickSignOutBtn() {
        SignoutBtn.click();
    }
    public void clickAddToCartBtn() {
        AddToCartBtn.click();
    }
    public void clickProceedToCheckoutBtn() {
        ProceedToCheckoutBtn.click();
    }
    public void clickPlusBtn() {
        PlusButton.click();
    }
    public void clickMinusBtn() {
        MinusButton.click();
    }
    public void clickEmptyBtn() {
        EmptyCartBtn.click();
    }
    public void clickItemImgBtn() {
        ItemImgBtn.click();
    }

/////////////////////////////////////////////////////////
    public void clicksubmitMessageButton() {
        submitMessageButton.click();
    }

    public Optional<String> getErrorMessage() {
        Optional<WebElement> error = getError();
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }


    public Optional<String> getSearchErrorMessage() {

            return Optional.of(SearchErr.getText());
    }

    public Optional<String> getSucessMessage() {

        return Optional.of(SuccesMessage.getText());
    }
    public Optional<String> getItemCount() {

        return Optional.of(itemCount.getAttribute("value"));
    }

    public void fillField(String field, String value) {
        getField(By.id(field)).sendKeys(value);
    }
    public void clearField(String field) {
        getField(By.id(field)).clear();
    }
    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public  String getRegisteredElementText(){

          return  registeredUserName.getText();
    }


    private Optional<WebElement> getError() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }


    public Optional<String> getCartMessage() {
        return Optional.of(cartMsg.getText());
    }
}
