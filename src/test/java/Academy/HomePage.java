package Academy;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseTest;

public class HomePage extends BaseTest{

	@BeforeMethod
	public void initialize() throws IOException
	{
		System.out.println("HomePage: initialize()");
		driver = initializeDriver();
		driver.get(properties.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		landingPage.getLoginButton().click();
		
		loginPage.getEmailField().sendKeys(username);
		loginPage.getPasswordField().sendKeys(password);
		loginPage.getLoginButton().click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "firstUser@email.com";
		data[0][1] = "password00111";
		
		data[1][0] = "secondUser@gmail.com";
		data[1][1] = "drugipass";
		
		return data;
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	}
}
