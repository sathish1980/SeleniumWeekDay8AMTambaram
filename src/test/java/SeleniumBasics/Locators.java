package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {
	
	public void Launch()
	{
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		browser.findElement(By.id("email")).sendKeys("kumar");
		browser.findElement(By.id("email")).clear();
		
		//WebElement username =browser.findElement(By.id("email"));
		//WebElement username =browser.findElement(By.name("email"));
		//WebElement username =browser.findElement(By.className("inputtext _55r1 _6luy"));
	//	CSS selector
		WebElement username =browser.findElement(By.cssSelector("input#email"));
		
		username.sendKeys("sathish");
		//browser.findElement(By.linkText("Forgotten password?")).click();
		//browser.findElement(By.partialLinkText("tten")).click();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locators L = new Locators();
		L.Launch();
	}

}
