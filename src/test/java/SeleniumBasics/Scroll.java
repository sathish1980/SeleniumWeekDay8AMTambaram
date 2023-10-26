package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Scroll {
	
	public void ScrollAction() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//browser.get("https://www.ebay.com/");
		browser.manage().window().maximize();
		browser.navigate().to("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)browser;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,50)", "");
		Thread.sleep(2000);
		//vertical scroll up
		js.executeScript("window.scrollBy(0,-50)", "");
		Thread.sleep(2000);
		//horizontal scroll right
		js.executeScript("window.scrollBy(750,0)", "");
		Thread.sleep(2000);
		//horizontal scroll left
		js.executeScript("window.scrollBy(-750,0)", "");
		Thread.sleep(2000);
		//vertical scroll to the bottom
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(2000);
		//vertical scroll to the up
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		Thread.sleep(2000);
		WebElement startbutton=browser.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scroll s = new Scroll();
		s.ScrollAction();
	}

}
