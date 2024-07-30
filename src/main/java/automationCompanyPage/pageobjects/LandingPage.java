package automationCompanyPage.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationCompanyPage.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement email;
		

	@FindBy(id="userPassword")
	WebElement password;
	

	@FindBy(id="login")
	WebElement submit;
		
        
	public ProductsPage LoginApp(String emailID, String pass)
	{
		
		email.sendKeys(emailID);
		password.sendKeys(pass);
		submit.click();
		ProductsPage pp= new ProductsPage(driver);
		return pp;
	}
	
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
