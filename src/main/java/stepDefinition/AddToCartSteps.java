package stepDefinition;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DriverHelper;
import pages.AbstractPage;
import pages.ProductCategoryPage;
import pages.SearchPage;

public class AddToCartSteps {

    DriverHelper driver = new DriverHelper();
    AbstractPage abstractPage = new AbstractPage();
    ProductCategoryPage productCategoryPage = new ProductCategoryPage();
    SearchPage searchPage = new SearchPage();
    String currentWindow;
    String homepage;
    String popupWindow;

    @When("^I click on add to cart button$")
    public void i_click_on_add_to_cart_button() throws Throwable {
        homepage = driver.getWindowHandle();
        driver.clickElement(driver.findElement(searchPage.listViewButton));
        driver.waitForElementPresent(productCategoryPage.addToCartButton);
        driver.clickElement(driver.findElement(productCategoryPage.addToCartButton));
    }

    @When("^I choose to \"([^\"]*)\" in pop up window$")
    public void i_choose_to_in_pop_up_window(String button) throws Throwable {
        driver.waitForElementPresent(abstractPage.cartProductCount);
        if (button.equalsIgnoreCase("continue shopping")) {
            driver.waitForElementPresent(productCategoryPage.popupContinueButton);
            driver.clickElement(driver.findElement(productCategoryPage.popupContinueButton));
//            driver.findElement(productCategoryPage.popupContinueButton).click();
        } else if (button.equalsIgnoreCase("proceed to checkout")) {
            driver.waitForElementPresent(productCategoryPage.popupCheckoutButton);
            driver.clickElement(driver.findElement(productCategoryPage.popupCheckoutButton));
        } else {
            throw new RuntimeException("Specify proceed to checkout or continue shopping");
        }
    }

    @Then("^I can see a product added to my cart$")
    public void i_can_see_a_product_added_to_my_cart() throws Throwable {
        driver.waitForElementPresent(abstractPage.cartProductCount);
        assertTrue(driver.findElement(abstractPage.cartProductCount).getText().equals("1"));
        driver.waitForElementPresent(abstractPage.cartProductCount);
        System.out.println(driver.findElement(abstractPage.cartProductCount).getText());
    }

}
