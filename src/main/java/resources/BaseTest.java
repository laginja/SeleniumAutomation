package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public static WebDriver driver = null;
	public Properties properties;
	
    public WebDriver initializeDriver() throws IOException
    {
    	// Depending on which browser we use, initialize the appropriate driver
    	properties = new Properties();
    	FileInputStream file = new FileInputStream("C:\\Users\\smoljanm\\SeleniumProjects\\FrameworkProject\\src\\main\\java\\resources\\data.properties");
   
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	
    	if(browser.equals("Chrome"))
    	{	
    		System.setProperty("webdriver.chrome.driver", "C:\\Work - Selenium\\chromedriver_win32\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}
    	else if(browser.equals("Firefox"))
    	{
    		// Firefox code
    	}
    	else if(browser.equals("IE"))
    	{
    		// IE code
    	}
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	
    	return driver;
    }
    
    public void TakeScreenshot(String TestName) throws IOException
    {
    	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	
    	FileUtils.copyFile(src, new File("C:\\Users\\smoljanm\\SeleniumProjects\\FrameworkProject\\screenshots\\" + TestName + "_Failed.png"));
    }
}
