package techpro.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import techpro.pages.HomePage;
import techpro.pages.MyAccount;
import techpro.pages.ShippingAddressAdd;
import techpro.utilities.ConfigReader;
import techpro.utilities.Driver;
import techpro.utilities.ReusableMethods;

public class ShippingAddressAddTest {
    HomePage homePage;
    MyAccount myAccount;
    ShippingAddressAdd addressAdd;
    @Test
    public void tc01LoginMyAccount() {
        Driver.getDriver().get(ConfigReader.getProperty("homepage_url"));
        homePage= new HomePage();
        homePage.signInButton.click();
        ReusableMethods.waitForVisibility(homePage.userName,10);
        homePage.userName.sendKeys(ConfigReader.getProperty("email"));
        homePage.password.sendKeys(ConfigReader.getProperty("password"));
        homePage.loginButton.click();
        ReusableMethods.waitForVisibility(homePage.signOut,15);
        assert homePage.signOut.isDisplayed();
        homePage.myAccountLink.click();
        myAccount=new MyAccount();
        assert myAccount.myAccountText.getText().equals("My Account");
        Reporter.log("Login MyAccount Page");
    }


    @Test(dependsOnMethods = "tc01LoginMyAccount")
    public void tc02BlankFirstName(){
        shippingAddressAdd("",ConfigReader.getProperty("lastname"),
                ConfigReader.getProperty("company"),ConfigReader.getProperty("country"),
                ConfigReader.getProperty("street"),ConfigReader.getProperty("apartment"),
                ConfigReader.getProperty("zipcode"),ConfigReader.getProperty("towncity"),
                ConfigReader.getProperty("province"));
        ReusableMethods.waitForVisibility(addressAdd.verifyFirstName,15);
        addressAdd.verifyFirstName.getText().equals("First name is a required field.");
        Reporter.log("First Name Boş Geçilemez");

    }
    @Test(dependsOnMethods = "tc01LoginMyAccount")
    public void tc03BlankLastName(){
        shippingAddressAdd(ConfigReader.getProperty("firstname"),"",
                ConfigReader.getProperty("company"),ConfigReader.getProperty("country"),
                ConfigReader.getProperty("street"),ConfigReader.getProperty("apartment"),
                ConfigReader.getProperty("zipcode"),ConfigReader.getProperty("towncity"),
                ConfigReader.getProperty("province"));
        ReusableMethods.waitForVisibility(addressAdd.verifyLastName,15);
        addressAdd.verifyLastName.getText().equals("Last name is a required field.");
        Reporter.log("Last Name Boş Geçilemez");
    }
    @Test(dependsOnMethods = "tc01LoginMyAccount")
    public void tc04BlankCountry(){
        shippingAddressAdd(ConfigReader.getProperty("firstname"),ConfigReader.getProperty("lastname"),
                ConfigReader.getProperty("company"),null,
                ConfigReader.getProperty("street"),ConfigReader.getProperty("apartment"),
                ConfigReader.getProperty("zipcode"),ConfigReader.getProperty("towncity"),
                ConfigReader.getProperty("province"));
        ReusableMethods.waitForVisibility(addressAdd.verifyCountry,15);
        addressAdd.verifyCountry.getText().equals("Country/Region is a required field.");
        Reporter.log("Country Boş Geçilemez");

    }
    @Test(dependsOnMethods = "tc01LoginMyAccount")
    public void tc05BlankStreet(){
        shippingAddressAdd(ConfigReader.getProperty("firstname"),ConfigReader.getProperty("lastname"),
                ConfigReader.getProperty("company"),ConfigReader.getProperty("country"),
                "",ConfigReader.getProperty("apartment"),
                ConfigReader.getProperty("zipcode"),ConfigReader.getProperty("towncity"),
                ConfigReader.getProperty("province"));
        ReusableMethods.waitForVisibility(addressAdd.verifyStreet,15);
        addressAdd.verifyStreet.getText().equals("Street address is a required field.");
        Reporter.log("Street Boş Geçilemez");
            }
    @Test(dependsOnMethods = "tc01LoginMyAccount")
    public void tc06BlankZipCode(){
        shippingAddressAdd(ConfigReader.getProperty("firstname"),ConfigReader.getProperty("lastname"),
                ConfigReader.getProperty("company"),ConfigReader.getProperty("country"),
                ConfigReader.getProperty("street"),ConfigReader.getProperty("apartment"),
                "",ConfigReader.getProperty("towncity"),
                ConfigReader.getProperty("province"));
        ReusableMethods.waitForVisibility(addressAdd.verifyZipCode,15);
        addressAdd.verifyZipCode.getText().equals("Postcode / ZIP is a required field.");
        Reporter.log("ZipCode Boş Geçilemez");
    }
    @Test(dependsOnMethods = "tc01LoginMyAccount")
    public void tc07BlankTownCity(){
        shippingAddressAdd(ConfigReader.getProperty("firstname"),ConfigReader.getProperty("lastname"),
                ConfigReader.getProperty("company"),ConfigReader.getProperty("country"),
                ConfigReader.getProperty("street"),ConfigReader.getProperty("apartment"),
                ConfigReader.getProperty("zipcode"),"",
                ConfigReader.getProperty("province"));
        ReusableMethods.waitForVisibility(addressAdd.verifyTownCity,15);
        addressAdd.verifyTownCity.getText().equals("Town / City is a required field.");
        Reporter.log("TownCity Boş Geçilemez");
    }
    @Test(dependsOnMethods = "tc01LoginMyAccount")
    public void tc08BlankProvinceState(){
        shippingAddressAdd(ConfigReader.getProperty("firstname"),ConfigReader.getProperty("lastname"),
                ConfigReader.getProperty("company"),ConfigReader.getProperty("country"),
                ConfigReader.getProperty("street"),ConfigReader.getProperty("apartment"),
                ConfigReader.getProperty("zipcode"),ConfigReader.getProperty("towncity"),
                null);
        ReusableMethods.waitForVisibility(addressAdd.verifyState,15);
        addressAdd.verifyState.getText().equals("Province is a required field.");
        Reporter.log("Province Boş Geçilemez");
    }

    public void shippingAddressAdd( String firstName, String lastName,String company,
                                   String country,String street,String apartment,String zipCode,
                                   String townCity,String province){

        addressAdd = new ShippingAddressAdd();
        ReusableMethods.clickWithTimeOut(myAccount.adressLink,10);
        ReusableMethods.clickWithTimeOut(myAccount.shippingAddLink,10);

         if(country==null){
            addressAdd.firstName.sendKeys(firstName, Keys.TAB, lastName, Keys.TAB, company,
                    Keys.TAB, Keys.TAB, street, Keys.TAB, apartment, Keys.TAB, townCity,Keys.TAB
                    ,Keys.TAB, zipCode);

        }else if (province==null){
            addressAdd.firstName.sendKeys(firstName, Keys.TAB, lastName, Keys.TAB, company,
                    Keys.TAB, country, Keys.ENTER, Keys.TAB, street, Keys.TAB, apartment, Keys.TAB, zipCode,
                    Keys.TAB, townCity);
            }else {
            addressAdd.firstName.sendKeys(firstName, Keys.TAB, lastName, Keys.TAB, company,
                    Keys.TAB, country, Keys.ENTER, Keys.TAB, street, Keys.TAB, apartment, Keys.TAB, zipCode,
                    Keys.TAB, townCity, Keys.TAB, province,Keys.TAB);
        }
        ReusableMethods.clickWithTimeOut(addressAdd.saveButton,10);
        ReusableMethods.waitFor(3);
    }

    @AfterClass
    public void afterClass() {
    Driver.closeDriver();
    }
}
