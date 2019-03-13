package Academy;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.BaseTest;

public class ValidateContactLink extends BaseTest{

	@BeforeTest
	public void initialize() throws IOException
	{
		System.out.println("ValidateContactLink: initialize()");
		driver = initializeDriver();
		driver.get(properties.getProperty("url"));
	}
	
	@Test
	public void ValidateLink() throws IOException
	{
		LandingPage landingPage = new LandingPage(driver);
		
		Assert.assertTrue(landingPage.getContactLink().isDisplayed());
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	}
}
