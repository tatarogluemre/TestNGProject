package techpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techpro.utilities.Driver;

public class HomePage {

    public HomePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//a[@class='login inline-type']")
    public WebElement signInButton;
    @FindBy(name = "username")
    public WebElement userName;
    @FindBy(name="password")
    public WebElement password;
    @FindBy(name="login")
    public WebElement loginButton;
    @FindBy(xpath ="//a[@class='login logout inline-type']")
    public WebElement signOut;
    @FindBy(partialLinkText = "My Account")
    public WebElement myAccountLink;
}
