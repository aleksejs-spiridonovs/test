package pages;

import org.openqa.selenium.By;

public class ForgotPasswordPage {
    
    public By backToLoginBtn = By.xpath("//a[@title='Back to Login']");
    public By emailField = By.cssSelector("#email");
    public By retrievePasswordBtn = By.cssSelector("p.submit>button");
    public By errorMessage = By.xpath("//div[@class='alert alert-danger']//li");

}
