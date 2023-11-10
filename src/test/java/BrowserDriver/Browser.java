package BrowserDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utils.PropertyFileRead;
public class Browser {
	public static WebDriver driver;

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
	}

	public void CloseBrowser()
	{
		if(driver!=null)
			driver.quit();
	}
}

