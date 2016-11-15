package stepDefinition;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DriverHelper;
import pages.AbstractPage;
import pages.ForgotPasswordPage;
import pages.MyAccountPage;
import pages.SignInPage;

public class SignInSteps {
    
    DriverHelper driver = new DriverHelper();
    SignInPage signInPage = new SignInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    AbstractPage abstractPage = new AbstractPage();
    
    @When("^I type valid e-mail and password in correct fields$")
    public void i_type_valid_e_mail_and_password_in_correct_fields() throws Throwable {
        driver.findElement(signInPage.emailField).sendKeys("mytestingemail@inbox.lv");
        driver.findElement(signInPage.passwordField).sendKeys("Test151");
    }

    @Then("^I can see \"([^\"]*)\" header$")
    public void i_can_see_header(String text) throws Throwable {
        assertTrue(driver.findElement(myAccountPage.pageHeader).getText().equals(text));
    }
    
    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_enter_and(String email, String password) throws Throwable {
        driver.findElement(signInPage.emailField).sendKeys(email);
        driver.findElement(signInPage.passwordField).sendKeys(password);
    }

    @Then("^I see the appropriate \"([^\"]*)\" message$")
    public void i_see_the_appropriate_message(String error) throws Throwable {
        assertTrue(driver.findElement(signInPage.errorMessage).getText().contains(error));
    }
    
    @Then("^can see back to login button$")
    public void can_see_button() throws Throwable {
        assertTrue(driver.isElementPresent(forgotPasswordPage.backToLoginBtn));
    }

    @Then("^there is a field to type my email$")
    public void there_is_a_field_to_type_my_email() throws Throwable {
        assertTrue(driver.isElementPresent(forgotPasswordPage.emailField));
    }
    
    @Then("^if I enter incorrect or no \"([^\"]*)\" and press retrieve password button I see an \"([^\"]*)\"$")
    public void if_I_enter_incorrect_or_no_and_press_retrieve_password_button_I_see_an(String email, String error) throws Throwable {
        driver.findElement(forgotPasswordPage.emailField).sendKeys(email);
        driver.clickElement(driver.findElement(forgotPasswordPage.retrievePasswordBtn));
        driver.waitForElementPresent(forgotPasswordPage.errorMessage);
        assertTrue(driver.findElement(forgotPasswordPage.errorMessage).getText().contains(error));
    }

    
}
