package techpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techpro.utilities.Driver;

public class ShippingAddressAdd {

    public ShippingAddressAdd(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(name = "shipping_first_name")
    public WebElement firstName;
    
    @FindBy(xpath = "//li[@data-id='shipping_first_name']")
    public WebElement verifyFirstName;

    @FindBy(xpath = "//li[@data-id='shipping_last_name']")
    public WebElement verifyLastName;

    @FindBy(xpath = "//li[@data-id='shipping_country']")
    public WebElement verifyCountry;
    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement saveButton;
    @FindBy(xpath = "//li[@data-id='shipping_address_1']")
    public WebElement verifyStreet;
    @FindBy(xpath = "//li[@data-id='shipping_postcode']")
    public WebElement verifyZipCode;
    @FindBy(xpath = "//li[@data-id='shipping_city']")
    public WebElement verifyTownCity;
    @FindBy(xpath = "//li[@data-id='shipping_state']")
    public WebElement verifyState;
    @FindBy(xpath = "//li[@data-id='shipping_phone']")
    public WebElement verifyPhone;




}
