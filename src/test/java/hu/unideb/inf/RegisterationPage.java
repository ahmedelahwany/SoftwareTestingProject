package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class RegisterationPage {


    @FindBy(id = "id_gender2")
    private WebElement femaleGenderBtn;
    @FindBy(id = "customer_firstname")
    private WebElement firstName;
    @FindBy(id = "customer_lastname")
    private WebElement lastName;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "address1")
    private WebElement address;
    @FindBy(id = "city")
    private WebElement cityName;
    @FindBy(id = "id_state")
    private WebElement stateName;
    @FindBy(id = "postcode")
    private WebElement zipCode;
    @FindBy(id = "id_country")
    private WebElement countryName;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;
    @FindBy(id = "alias")
    private WebElement aliasName;
    @FindBy(id = "submitAccount")
    private WebElement registerBtn;


    private WebDriver driver;

    public RegisterationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void registerUsingRandomData(String field ) {

        //Filling the random data on registration page
       femaleGenderBtn.click();
        if(field.equals("firstName")) {fillField(firstName, "");}else{fillField(firstName, "John");}
        if(field.equals("lastName")) {fillField(lastName, "");}else{fillField(lastName, "Doe");}
        if(field.equals("password")) {fillField(password, "");}else{fillField(password, "Johndoe");};

        if(field.equals("address")) {fillField(address, "");}else{fillField(address, "23 street.st");}

        // city , state and country name
        String city = "NAN";
        String state = "Delaware";
        String country = "United States";
        fillField(cityName, city);
        selectValueFromDropDown(stateName, state);
        fillField(zipCode, "32234");
        selectValueFromDropDown(countryName, country);
        fillField(mobilePhone, "+363333333333");
        fillField(aliasName, "Howard");
        registerBtn.click();
    }
    public void registerUsingSomeInvalidData(String field, String parameter ) {

        //Filling the random data on registration page
        femaleGenderBtn.click();
        if(field.equals("firstname")) {fillField(firstName, parameter);}else{fillField(firstName, "John");}
        if(field.equals("phone_mobile")) {fillField(mobilePhone, parameter);}else{fillField(mobilePhone, "+363333333333");}
        if(field.equals("password")) {fillField(password, parameter);}else{fillField(password, "Johndoe");};

        if(field.equals("lastname")) {  fillField(lastName, parameter);}else{fillField(lastName, "Doe");}
        fillField(address, "23 street.st");
        fillField(lastName, "Doe");
        // city , state and country name
        String city = "NAN";
        String state = "Delaware";
        String country = "United States";
        fillField(cityName, city);
        fillField(zipCode, "22222");
        selectValueFromDropDown(stateName, state);
        selectValueFromDropDown(countryName, country);
        fillField(aliasName, "Howard");
        registerBtn.click();
    }

    private static void selectValueFromDropDown(WebElement element, String value) {
        Select option = new Select(element);
        option.selectByVisibleText(value);
    }
    private void fillField(WebElement element, String value) {
        element.sendKeys(value);
    }


}
