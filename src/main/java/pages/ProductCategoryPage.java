package pages;

import org.openqa.selenium.By;

public class ProductCategoryPage {
    
    public By addToCartButton = By.xpath("//a[@title='Add to cart']");
    public By popupContinueButton = By.xpath("//span[@title='Continue shopping']/span/i");
    public By popupCheckoutButton = By.xpath("//a[@title='Proceed to checkout']");
    public By closeButton = By.xpath("//span[@title='Close window']");

}
