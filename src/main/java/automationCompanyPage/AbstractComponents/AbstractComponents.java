package automationCompanyPage.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationCompanyPage.pageobjects.CartPage;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartButton;
	
	
	public void waitForElement2Appear(By findIt)
	{
	
	WebDriverWait wu=new WebDriverWait(driver, Duration.ofSeconds(5));
    wu.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findIt));
	}
	
	public void waitForElement2Disappear(By findIt)
	{
		WebDriverWait wu=new WebDriverWait(driver, Duration.ofSeconds(5));
		wu.until(ExpectedConditions.invisibilityOfElementLocated(findIt));
	}
	
	public CartPage GoToCartpage()
	{
		cartButton.click();
		CartPage cp= new CartPage(driver);
		return cp;
	}
}
