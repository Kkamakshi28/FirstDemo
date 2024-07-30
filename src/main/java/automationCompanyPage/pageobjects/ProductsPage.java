package automationCompanyPage.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationCompanyPage.AbstractComponents.AbstractComponents;

public class ProductsPage extends AbstractComponents{
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="div.mb-3")
	List<WebElement> products;
		
	By findIt=By.cssSelector("div.mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMsg=By.id("toast-container");
	By spinner=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProdList()
	{
		waitForElement2Appear(findIt);
		return products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement prod = products.stream().
	    		  filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String ProductName) throws InterruptedException
	{
		WebElement prod = getProductByName(ProductName);
		 prod.findElement(addToCart).click();
		 waitForElement2Appear(toastMsg);
		 //waitForElement2Disappear(spinner);
		 Thread.sleep(2000);
	}

	//List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
    
}
