package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	
	WebDriver browser;
	public void FramesActions() throws InterruptedException
	{
		browser = new ChromeDriver();
		browser.get("https://leafground.com/frame.xhtml");
		browser.manage().window().maximize();
		List<WebElement> allFrames = browser.findElements(By.tagName("iframe"));
		for(int i=0;i<allFrames.size();i++)
		{
			browser.switchTo().frame(i);
			List<WebElement> elementExist= browser.findElements(By.xpath("//*[@id='Click' and contains(@style,'#ff7295')]"));
			if(elementExist.size()>0)
			{
				browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'#ff7295')]")).click();
				browser.switchTo().defaultContent();
				break;
			}
			browser.switchTo().defaultContent();
			
		}
		//Thread.sleep(3000);
		//browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'#ff7295')]")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Frames F = new Frames();
		F.FramesActions();
	}

}
