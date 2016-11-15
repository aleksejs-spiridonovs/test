package pages;

import org.openqa.selenium.By;

public class AbstractPage {
    
    public By footer = By.cssSelector("#footer");
    public By header = By.cssSelector("#header");
    public By logOutButton = By.cssSelector(".logout");
    public By alertMessage = By.cssSelector("p.alert");
    public By newsletterField = By.cssSelector("#newsletter-input");
    public By followUsField = By.cssSelector("#social_block");
    public By storeInformationField = By.cssSelector("#block_contact_infos");
    public By contactUsLink = By.xpath("//a[@title='Contact us']");
    public By myInfoLink = By.xpath("//a[@title='Manage my personal information']");
    public By signOutLink = By.xpath("//a[@title='Sign out']");
    public By signInButton = By.cssSelector(".login");
    public By searchField = By.cssSelector("#search_query_top");
    public By searchButton = By.xpath("//button[@name='submit_search']");
    public By contactUsButton = By.cssSelector("#contact-link");
    public By newsletterButton = By.xpath("//button[@name='submitNewsletter']");
    public By headerMenuBar = By.cssSelector("#block_top_menu");
    public By homeButton = By.xpath("//a[@title='My Store']");
    public By womenMenu = By.xpath("//a[@title='Women']");
    public By dressesMenu = By.xpath("//a[@title='Dresses']");
    public By menuTshirtsLink = By.xpath("//a[@title='T-shirts']");
    public By menuCasualDressesLink = By.xpath("//a[@title='Casual Dresses']");
    public By navigationBarHome = By.cssSelector(".home");
    public By cartProductCount = By.cssSelector("#layer_cart_product_quantity");
    
}
