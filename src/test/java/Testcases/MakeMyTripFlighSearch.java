package Testcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.Browser;
import Utils.PropertyFileRead;

public class MakeMyTripFlighSearch extends Browser{

	@BeforeSuite
	public void LaunchTheBrowser() throws IOException
	{
		LaunchBrowser();
	}

	@BeforeTest
	public void OpenTheApplication() throws IOException
	{
		String applicationURL =PropertyFileRead.GetEnvironmentDetail().getProperty("url");
		driver.get(applicationURL);
	}

	@Test
	public void sampleTestcase()
	{
		System.out.println("This is first Testcae");
	}

	@AfterSuite
	public void CloseTheApplication() throws IOException
	{
		CloseBrowser();
	}

}
