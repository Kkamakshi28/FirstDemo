package ng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day3 {
	
	@Test
	public void day3test1()
	{
		System.out.println("day3test1");
	}
	
	@Test
	public void day3test2()
	{
		System.out.println("day3test2");
	}
	
	@BeforeMethod
	public void bftest()
	{
		System.out.println("method start");
	}
	
	@BeforeSuite
	public void bfsuite()
	{
		System.out.println("before test suite starts");
	}

	@Test(groups={"Smoke"})
	public void day3test3()
	{
		System.out.println("day3test3");
		Assert.assertTrue(false);
	}


}
