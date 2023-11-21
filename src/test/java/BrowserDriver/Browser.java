package BrowserDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.PropertyFileRead;
public class Browser {
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;

	public void LaunchBrowser() throws IOException
	{
		String browserName=PropertyFileRead.GetEnvironmentDetail().getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else
		{
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		StartReport();
	}

	public void StartReport()
	{
		reports= new ExtentReports(System.getProperty("user.dir")+"\\Reports\\extentReports.html",false);
		test = reports.startTest("Automation Report");
	}

	public void CloseBrowser()
	{
		reports.flush();
		if(driver!=null)
			driver.quit();
	}
}

