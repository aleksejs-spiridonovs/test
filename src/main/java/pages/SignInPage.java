package pages;

import org.openqa.selenium.By;

public class SignInPage {
    
    public By emailField = By.cssSelector("#email");
    public By passwordField = By.cssSelector("#passwd");
    public By signInButton = By.cssSelector("#SubmitLogin");
    public By errorMessage = By.xpath("//div[@class='alert alert-danger']//li");
    public By forgotPasswordLink = By.cssSelector(".lost_password>a");

}
