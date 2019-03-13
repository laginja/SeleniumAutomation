package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By emailField = By.xpath("//*[@id='user_email']");
	By passwordField = By.xpath("//*[@id='user_password']");
	By loginButton = By.xpath("//input[@value='Log In']");
	
	
	public WebElement getEmailField()
	{
		return driver.findElement(emailField);
	}
	
	public WebElement getPasswordField()
	{
		return driver.findElement(passwordField);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
}
