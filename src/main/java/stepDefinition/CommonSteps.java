package stepDefinition;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DriverHelper;
import pages.AbstractPage;
import pages.ForgotPasswordPage;
import pages.MyAccountPage;
import pages.SignInPage;

public class CommonSteps {

    DriverHelper driver = new DriverHelper();
    SignInPage signInPage = new SignInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    AbstractPage abstractPage = new AbstractPage();

    @Given("^I am on homepage$")
    public void i_am_on_abstractPage() throws Throwable {
        driver.get("http://automationpractice.com/index.php");
    }

    @Given("^I am signed in$")
    public void i_am_signed_in() throws Throwable {
        driver.get("http://automationpractice.com/index.php");
        driver.waitForElementPresent(abstractPage.signInButton);
        driver.clickElement(driver.findElement(abstractPage.signInButton));
        driver.findElement(signInPage.emailField).sendKeys("mytestingemail@inbox.lv");
        driver.findElement(signInPage.passwordField).sendKeys("Test151");
        driver.clickElement(driver.findElement(signInPage.signInButton));
        driver.waitForElementPresent(abstractPage.footer);
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String page) throws Throwable {
        switch (page) {
        case "sign in page":
            driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
            break;
        case "contact us page":
            driver.get("http://automationpractice.com/index.php?controller=contact");
            break;
        case "casual dresses page":
            driver.get("http://automationpractice.com/index.php?id_category=9&controller=category");
            break;
        default:
            throw new RuntimeException("Page name not recognized");
        }
    }

    @When("^I click \"([^\"]*)\"$")
    public void i_press(String button) throws Throwable {
        switch (button) {
        case "sign in button":
            driver.clickElement(driver.findElement(signInPage.signInButton));
            break;
        case "forgot your password":
            driver.clickElement(driver.findElement(signInPage.forgotPasswordLink));
            break;
        case "search button":
            driver.clickElement(driver.findElement(abstractPage.searchButton));
            break;
        case "contact us link":
            driver.clickElement(driver.findElement(abstractPage.contactUsLink));
            break;
        case "my persolan info link":
            driver.clickElement(driver.findElement(abstractPage.myInfoLink));
            break;
        case "sign out link":
            driver.clickElement(driver.findElement(abstractPage.signOutLink));
            break;
        case "newsletter submit button":
            driver.clickElement(driver.findElement(abstractPage.newsletterButton));
            break;
        case "t-shirts link":
            driver.clickElement(driver.findElement(abstractPage.menuTshirtsLink));
            break;
        case "casual dresses link":
            driver.clickElement(driver.findElement(abstractPage.menuCasualDressesLink));
            break;
        case "navigation bar home button":
            driver.clickElement(driver.findElement(abstractPage.navigationBarHome));
            break;
        default:
            throw new RuntimeException("Button or link name not recognized");
        }
    }

    @Then("^I am redirected to \"([^\"]*)\"$")
    public void i_am_redirected_to(String page) throws Throwable {
        switch (page) {
        case "my account page":
            assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account"));
            break;
        case "forgot your password page":
            assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=password"));
            break;
        case "search results page":
            assertTrue(driver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=search"));
            break;
        case "contact us page":
            assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=contact"));
            break;
        case "my persolan info page":
            assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=identity"));
            break;
        case "authentication page":
            assertTrue(driver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication"));
            break;
        case "t-shirts page":
            assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?id_category=5&controller=category"));
            break;
        case "casual dresses page":
            assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?id_category=9&controller=category"));
            break;
        case "home page":
            assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php"));
            break;
        default:
            throw new RuntimeException("Page name not recognized");
        }
    }

    @When("^I hover on \"([^\"]*)\" in header menu bar$")
    public void i_hover_on_in_header_menu_bar(String menu) throws Throwable {
        if (menu.equalsIgnoreCase("woman menu")) {
            driver.hoverOverElement(driver.findElement(abstractPage.womenMenu));
        } else if (menu.equalsIgnoreCase("dresses menu")) {
            driver.hoverOverElement(driver.findElement(abstractPage.dressesMenu));
        } else {
            throw new RuntimeException("Menu name not recognized");
        }
    }

    @Then("^I can see a footer with all the content$")
    public void i_can_see_a_footer_with_all_the_content() throws Throwable {
        if (driver.isElementPresent(abstractPage.footer)) {
            assertTrue(driver.isElementPresent(abstractPage.newsletterField));
            assertTrue(driver.isElementPresent(abstractPage.followUsField));
            assertTrue(driver.isElementPresent(abstractPage.storeInformationField));
        }
    }

    @Then("^I can see a header with all the content$")
    public void i_can_see_a_header_with_all_the_content() throws Throwable {
        if (driver.isElementPresent(abstractPage.header)) {
            assertTrue(driver.isElementPresent(abstractPage.searchField));
            assertTrue(driver.isElementPresent(abstractPage.headerMenuBar));
            assertTrue(driver.isElementPresent(abstractPage.homeButton));
        }
    }

    @Then("^I sign out$")
    public void i_sign_out() throws Throwable {
        if (driver.isElementPresent(abstractPage.logOutButton)) {
            driver.waitForElementPresent(abstractPage.logOutButton);
            driver.clickElement(driver.findElement(abstractPage.signOutLink));
            driver.waitForInvisibilityOfElement(abstractPage.logOutButton);
        } else {
            System.out.println("You are not signed in.");
        }
    }

    @When("^I type my email in the newsletter field$")
    public void i_type_my_email_in_the_newsletter_field() throws Throwable {
        String random = driver.generateRandomString(10);
        driver.findElement(abstractPage.newsletterField).sendKeys(random + "@email.com");
    }

    @Then("^I see alert message that I have been successfully subscribed or email allready registered$")
    public void i_see_alert_message_that_I_have_been_successfully_subscribed() throws Throwable {
        String alert = driver.findElement(abstractPage.alertMessage).getText();
        if (alert.contains("You have successfully subscribed")) {
            assertTrue(alert.equalsIgnoreCase("Newsletter : You have successfully subscribed to this newsletter."));
        } else {
            assertTrue(alert.equalsIgnoreCase("Newsletter : This email address is already registered."));
        }
    }

    @Given("^I can see the home and dress link on naviation bar$")
    public void i_can_see_the_home_and_dress_link_on_naviation_bar() throws Throwable {
        assertTrue(driver.isElementPresent(abstractPage.navigationBarHome));
        assertTrue(driver.isElementPresent(abstractPage.navigationBarHome));
    }

}
