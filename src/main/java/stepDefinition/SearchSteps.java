package stepDefinition;

import helper.DriverHelper;
import pages.AbstractPage;
import pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchSteps {
    
    DriverHelper driver = new DriverHelper();
    SearchPage searchPage = new SearchPage();
    AbstractPage abstractPage = new AbstractPage();
    
    @When("^I type a \"([^\"]*)\" of a product in a search field$")
    public void i_type_a_of_a_product_in_a_search_field(String name) throws Throwable {
        driver.findElement(abstractPage.searchField).sendKeys(name);
    }

    @Then("^I can see number of results or \"([^\"]*)\" message if no results$")
    public void i_can_see_number_of_results_or_message_if_no_results(String name) throws Throwable {
        if(driver.isElementPresent(abstractPage.alertMessage) && driver.findElement(searchPage.resultCount).getText().contains("0")){
            String errorText = driver.findElement(abstractPage.alertMessage).getText();
            assertTrue(errorText.equals("No results were found for your search \"" + name + "\""));
        }else if(driver.isElementPresent(searchPage.searchText)){
            String searchText = driver.findElement(searchPage.searchText).getText();
            assertTrue(searchText.equalsIgnoreCase("\"" + name + "\""));
        }
        System.out.println(driver.findElement(searchPage.resultCount).getText());
    }
    
    @Given("^I type \"([^\"]*)\" in a search field$")
    public void i_type_in_a_search_field(String name) throws Throwable {
        driver.findElement(abstractPage.searchField).sendKeys(name);
    }

    @Then("^I switch to \"([^\"]*)\" view$")
    public void i_switch_to_view(String viewType) throws Throwable {
        if(viewType.equals("list")){
            driver.findElement(searchPage.listViewButton).click();
        }else if(viewType.equals("grid")){
            driver.findElement(searchPage.gridViewButton).click();
        }else{
            throw new RuntimeException("Invalid view type, choose list or grid view");
        }
    }

    @Then("^I sort results by \"([^\"]*)\"$")
    public void i_sort_results_by(String type) throws Throwable {
         WebElement dropDownListBox = driver.findElement(searchPage.productSortBox);
         Select clickThis = new Select(dropDownListBox);
         clickThis.selectByVisibleText(type);
    }
}
