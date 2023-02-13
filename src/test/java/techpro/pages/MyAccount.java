package techpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techpro.utilities.Driver;

public class MyAccount {
    public MyAccount(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//div[@class='page-title-wrap']")
    public WebElement myAccountText;

    @FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation col-md-3 mb-8']//ul//li[4]")
    public WebElement  adressLink;

    @FindBy(xpath = "//div[@class='woocommerce-Address']//a")
    public WebElement addLink;

   @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement shippingAddLink;

}
