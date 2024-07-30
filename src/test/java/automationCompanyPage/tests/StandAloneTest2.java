package automationCompanyPage.tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import automationCompanyPage.pageobjects.CartPage;
import automationCompanyPage.pageobjects.CheckoutPage;
import automationCompanyPage.pageobjects.ConfirmationPage;
import automationCompanyPage.pageobjects.LandingPage;
import automationCompanyPage.pageobjects.ProductsPage;
import automationCompanyPage.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2 extends BaseTest {
      @Test
      public void order() throws IOException, InterruptedException
      {
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
        //WebDriverManager.chromedriver().setup();
		String ProductName="ZARA COAT 3";
		//LandingPage lp=launchapp();
        
        
        //LandingPage lp=new LandingPage(driver);
        //lp.Goto();
		ProductsPage pp=lp.LoginApp("arshi.khan123@gmail.com", "Ka9!!!9akk");
        
        //ProductsPage pp= new ProductsPage(driver);
        List<WebElement> products = pp.getProdList();
        pp.addProductToCart(ProductName);
        CartPage cp=pp.GoToCartpage();
       
        //CartPage cp= new CartPage(driver);
        boolean match=cp.verifyCartProducts(ProductName);
        Assert.assertTrue(match);
       CheckoutPage chkpg=cp.GoTOCheckoutPage();
        
        //CheckoutPage chkpg= new CheckoutPage(driver);
        chkpg.checkout("ind");
        ConfirmationPage cnfrmpg=chkpg.SubmitOrder();
        
        //ConfirmationPage cnfrmpg=new ConfirmationPage(driver);
       String successMsg = cnfrmpg.verifyConfirmMsg();
        Assert.assertTrue(successMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
         
       //driver.quit();
      
         
         
      }
}
