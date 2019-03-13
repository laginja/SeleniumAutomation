package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By loginButton = By.cssSelector("a[href*='http://qaclickacademy.usefedora.com/sign_in']");
	By featuredText = By.xpath("//*[@id='content']/div/div/h2");
	By contactLink = By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul/li[8]/a");
	
	
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement getFeaturedText()
	{
		return driver.findElement(featuredText);
	}
	
	public WebElement getContactLink()
	{
		return driver.findElement(contactLink);
	}
}
