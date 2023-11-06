package TestNGBasics;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNGAnnotation2 {

	
	@BeforeClass(alwaysRun=true)
	public void BeforeClass()
	{
		System.out.println("class 2 @BeforeClass");
	}
	
	
	@Test(priority=0,groups="SIT")
	public void Testcase1()
	{
		System.out.println("class 2 Testcase1");
	}
	
	@Test(priority=1,groups="SIT")
	public void Testcase2()
	{
		System.out.println("class 2 Testcase2");
	}
	
}
