package Academy;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.BaseTest;


public class ValidateTitle extends BaseTest{

	@BeforeTest
	public void initialize() throws IOException
	{
		System.out.println("ValidateTitle: initialize()");
		driver = initializeDriver();
		driver.get(properties.getProperty("url"));
	}
	
	@Test
	public void Validate() throws IOException
	{		
		System.out.println("ValidateTitle: validate()");
		LandingPage landingPage = new LandingPage(driver);
		String featureTitle = landingPage.getFeaturedText().getText();
		Assert.assertEquals(featureTitle, "FEATURED COURSES");
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	}
}
