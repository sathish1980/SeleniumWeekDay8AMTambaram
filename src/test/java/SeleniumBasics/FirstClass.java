package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {
	
	
	public void launch() throws InterruptedException
	{
		//WebDriver browser = new ChromeDriver();
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		//Thread.sleep(2000);
		browser.get("https://www.facebook.com/");
		Thread.sleep(2000);
		browser.navigate().to("https://www.gmail.com/");
		//browser.quit();
		browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.launch();
	}

}
