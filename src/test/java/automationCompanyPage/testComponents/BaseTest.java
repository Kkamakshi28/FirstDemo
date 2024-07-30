package automationCompanyPage.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import automationCompanyPage.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage lp;
	public void initializeBrowser() throws IOException
	{
	
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//automationCompanyPage//resources//globaldata.properties");
		prop.load(fis);
		String name = prop.getProperty("browser");
		
		if(name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/khetr/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
	        driver= new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1440,900));
			
		}
		else if (name.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.Gecko.driver","");
	        //driver= new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("edge"))
		{
			//System.setProperty("webdriver.Edge.driver","");
	        //driver= new EdgeDriver();
		}
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
	}
	@BeforeMethod
	public LandingPage launchapp() throws IOException
	{
		initializeBrowser();
		lp=new LandingPage(driver);
		lp.Goto();
		return lp;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
