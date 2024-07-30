package automationCompanyPage.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import automationCompanyPage.AbstractComponents.AbstractComponents;

public class CartPage<WebElements> extends AbstractComponents {
     
	WebDriver driver;
    public CartPage(WebDriver driver)
    {
    	super(driver);
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
	@FindBy(css=".cart h3")
	List<WebElement> CartProducts;
	
	
	@FindBy(css="li.totalRow button[class*='btn-primary']")
	WebElement checkout;
	
	public boolean verifyCartProducts(String ProductName)
	{
		boolean match =CartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(ProductName));
		return match;
	}
   
	public CheckoutPage GoTOCheckoutPage()
	{
		checkout.click();
		CheckoutPage chkpg= new CheckoutPage(driver);
		return chkpg;
		
	}
}
