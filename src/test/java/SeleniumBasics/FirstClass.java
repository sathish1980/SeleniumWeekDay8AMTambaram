package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {
	
	
	public void launchBrowser() throws InterruptedException
	{
		//WebDriver browser = new ChromeDriver();
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		//Thread.sleep(2000);
		browser.get("https://www.facebook.com/");
		Thread.sleep(2000);
		/*browser.navigate().to("https://www.gmail.com/");
		//browser.quit();
		browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();*/
		WebElement userName = browser.findElement(By.id("email"));
		userName.sendKeys("sathish");
		userName.clear();
		//or
		browser.findElement(By.id("email")).sendKeys("Kumar");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.launchBrowser();
	}

}
