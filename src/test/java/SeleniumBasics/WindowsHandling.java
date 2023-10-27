package SeleniumBasics;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {
	
	public void WindowHandleimplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/window.xhtml");
		String parentWindow = browser.getWindowHandle();
		browser.findElement(By.id("j_idt88:j_idt91")).click();
		Set<String> allWindows =browser.getWindowHandles();
		for(String eachWindow :allWindows)
		{
			if(!eachWindow.equals(parentWindow))
			{
				browser.switchTo().window(eachWindow);
				browser.manage().window().maximize();
				List<WebElement> elementExist =browser.findElements(By.id("menuform:j_idt40"));
				
				if(elementExist.size()>0)
				{
				browser.findElement(By.id("menuform:j_idt40")).click();
				WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("menuform:m_input")));
				browser.findElement(By.id("menuform:m_input")).click();

				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("j_idt88:name")));
				System.out.println(browser.getTitle());
				browser.findElement(By.id("j_idt88:name")).sendKeys("Sathish");
				
				browser.switchTo().window(parentWindow);
				browser.close();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowsHandling W = new WindowsHandling();
		W.WindowHandleimplementation();
	}

}
