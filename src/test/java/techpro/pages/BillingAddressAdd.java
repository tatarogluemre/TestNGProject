package techpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techpro.utilities.Driver;

public class BillingAddressAdd {

    public BillingAddressAdd(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(name = "billing_first_name")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='billing_email']")
    public WebElement emailText;

    @FindBy(xpath = "//li[@data-id='billing_first_name']")
    public WebElement verifyFirstName;

    @FindBy(xpath = "//li[@data-id='billing_last_name']")
    public WebElement verifyLastName;

    @FindBy(xpath = "//li[@data-id='billing_country']")
    public WebElement verifyCountry;
    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement saveButton;
    @FindBy(xpath = "//li[@data-id='billing_address_1']")
    public WebElement verifyStreet;
    @FindBy(xpath = "//li[@data-id='billing_postcode']")
    public WebElement verifyZipCode;
    @FindBy(xpath = "//li[@data-id='billing_city']")
    public WebElement verifyTownCity;
    @FindBy(xpath = "//li[@data-id='billing_state']")
    public WebElement verifyState;
    @FindBy(xpath = "//li[@data-id='billing_phone']")
    public WebElement verifyPhone;




}
