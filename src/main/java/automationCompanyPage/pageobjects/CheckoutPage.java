package automationCompanyPage.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automationCompanyPage.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
    	super(driver);
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(css="input[placeholder='Select Country']")
    WebElement country;
    
    @FindBy(xpath="(//span[@class='ng-star-inserted'])[2]")
    WebElement selectCountry;
    
    @FindBy(css="div a[class*='ng-star-inserted']")
    WebElement OrderButton;
    
   // wu.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='ng-star-inserted']")));
	 By FindIt=By.cssSelector("span[class='ng-star-inserted']");
    public void checkout(String countryName)
    {
    	country.sendKeys(countryName);
    	waitForElement2Appear(FindIt);
    	selectCountry.click();
    }
    
   public ConfirmationPage SubmitOrder()
   {
	   OrderButton.click();
	   ConfirmationPage cnfrmpg=new ConfirmationPage(driver);
	   return cnfrmpg;
   }
    
  
	
}
