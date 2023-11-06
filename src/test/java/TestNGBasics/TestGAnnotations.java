package TestNGBasics;

import org.testng.annotations.*;

public class TestGAnnotations {
	
	@BeforeSuite(alwaysRun=true)
	public void BeforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	
	
	@BeforeTest(alwaysRun=true)
	public void BeforeTest()
	{
		System.out.println("@BeforeTest");
	}
	
	
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClass()
	{
		System.out.println("BeforeClass");
	}
	
	@AfterClass(alwaysRun=true)
	public void AfterClass()
	{
		System.out.println("AfterClass");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethod()
	{
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod(alwaysRun=true)
	public void AfterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	@Test(priority=0,enabled=true,groups="Sanity")
	public void Testcase4()
	{
		System.out.println("Testcase4");
	}
	
	@Test(priority=-1,enabled=true,description="valid login",groups={"Sanity","SIT"})
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}
	
	@Test(priority=-3,enabled=true,invocationCount=5,invocationTimeOut=60,timeOut=60,groups="SIT")
	public void Testcase3()
	{
		System.out.println("Testcase3");
	}
	
	
	@Test(priority=-5,dependsOnMethods="Testcase1",groups= {"Sanity","SIT"})
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}
	

}
