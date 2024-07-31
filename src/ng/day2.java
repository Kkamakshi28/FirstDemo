package ng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
	@AfterTest
	public void aftest()
	{
		System.out.println("i will execute at the end");
	}
	
	@Test
	public void day2test1()
	{
		System.out.println("day2test1");
	}
	
	@Test(groups={"Smoke"})
	public void day2test2()
	{
		System.out.println("test on day 2");
	}
	
	@BeforeTest
	public void bftest()
	{
		System.out.println("i will execute first");
	}
	

	@Test
	public void day2test3()
	{
		System.out.println("day2test3");
	}


}
