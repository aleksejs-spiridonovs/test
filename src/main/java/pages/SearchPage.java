package pages;

import org.openqa.selenium.By;

public class SearchPage {
    
    public By searchText = By.cssSelector("h1>span.lighter");
    public By resultCount = By.cssSelector("h1>span.heading-counter");
    public By listViewButton = By.cssSelector("#list");
    public By gridViewButton = By.cssSelector("#grid");
    public By productSortBox = By.cssSelector("#selectProductSort");
    
}
