package TestNGBasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestNGAnnotation3 {
	@Test(priority=1)
	public void Testcase1()
	{
		System.out.println("class 3 Testcase1");
	}
	
	@AfterSuite(alwaysRun=true)
	public void AfterSuite()
	{
		System.out.println("AfterSuite");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest");
	}

}
