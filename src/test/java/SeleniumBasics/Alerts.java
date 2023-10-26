package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	
	public void AlertHandle()
	{
		WebDriver browser = new ChromeDriver();
		browser.get("https://leafground.com/alert.xhtml");
		browser.manage().window().maximize();
		browser.findElement(By.id("j_idt88:j_idt91")).click();
		//Alert a = browser.switchTo().alert();
		
		browser.switchTo().alert().accept();
		
		browser.findElement(By.id("j_idt88:j_idt93")).click();
		browser.switchTo().alert().dismiss();
		
		browser.findElement(By.id("j_idt88:j_idt104")).click();
		Alert a = browser.switchTo().alert();
		System.out.println(a.getText());
		a.sendKeys("Besant");
		a.accept();
		
		browser.findElement(By.id("j_idt88:j_idt95")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt98")));
		GetExplixtWait(browser,By.id("j_idt88:j_idt98"));
		browser.findElement(By.id("j_idt88:j_idt98")).click();
		
		
	}

	
	public void GetExplixtWait(WebDriver browser,By element)
	{
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alerts A = new Alerts();
		A.AlertHandle();
	}

}
