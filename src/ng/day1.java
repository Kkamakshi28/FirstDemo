package ng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day1 {
	@AfterTest
	public void aftest()
	{
		System.out.println("i will execute at the end");
	}
	
	@AfterSuite
	public void bfsuite()
	{
		System.out.println("after test suite ends");
	}
	
	@Test
	public void day1test1()
	{
		System.out.println("day1test1");
	}
	
	@Test(groups={"Smoke"})
	public void day1test2()
	{
		System.out.println("day1test2");
	}
	
	@Test
	public void day1test3()
	{
		System.out.println("day1test3");
	}
	
	@AfterMethod
	public void afmethod()
	{
		System.out.println("method end");
	}
	
	@BeforeClass
	public void beforecls()
	{
		System.out.println("class starts");
	}
	
	

}
