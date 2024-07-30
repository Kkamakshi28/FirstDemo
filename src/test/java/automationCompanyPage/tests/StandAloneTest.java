package automationCompanyPage.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automationCompanyPage.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver",
				"C:/Users/khetr/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/");
        driver.findElement(By.id("userEmail")).sendKeys("arshi.khan123@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Ka9!!!9akk");
        driver.findElement(By.id("login")).click();
        
        
        WebDriverWait wu=new WebDriverWait(driver, Duration.ofSeconds(5));
        wu.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.mb-3")));
       List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
      WebElement prod = products.stream().
    		  filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        WebDriverWait wu1=new WebDriverWait(driver, Duration.ofSeconds(5));
       wu1.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
       wu1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart h3"));
         boolean match = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
         Assert.assertTrue(match);
         //checkout button
         driver.findElement(By.cssSelector("li.totalRow button[class*='btn-primary']")).click();
         //country field
         driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
         wu1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='ng-star-inserted']")));
         driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[2]")).click();
        //place order button
         driver.findElement(By.cssSelector("div a[class*='ng-star-inserted']")).click();
         //thank you msg
         String ConfirmMsg = driver.findElement(By.className("hero-primary")).getText();
         //System.out.println(ConfirmMsg);
        Assert.assertTrue(ConfirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       driver.close();
         
         
	}

}
