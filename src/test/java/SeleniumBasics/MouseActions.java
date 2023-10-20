package SeleniumBasics;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions {
	
	public void MouseMove()
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://www.ebay.com/");
		browser.manage().window().maximize();
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//a[text()='Electronics']"))).perform();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Computers and tablets']")));
		mouse.moveToElement(browser.findElement(By.xpath("//*[text()='Computers and tablets']"))).click().perform();
		
	}
	
	public void MouseMove2()
	{
		WebDriver browser = new ChromeDriver();
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}
	
	public void dragandDrop()
	{
		WebDriver browser = new ChromeDriver();
		browser.get("https://leafground.com/drag.xhtml");
		browser.manage().window().maximize();
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.cssSelector("[id='form:drag']"))).dragAndDrop(browser.findElement(By.cssSelector("[id='form:drag']")), browser.findElement(By.cssSelector("[id='form:drop_content']"))).perform();
	}
	
	public void slider()
	{
		WebDriver browser = new ChromeDriver();
		browser.get("https://leafground.com/drag.xhtml");
		browser.manage().window().maximize();
		Actions mouse = new Actions(browser);
		JavascriptExecutor js= (JavascriptExecutor)browser;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		mouse.moveToElement(browser.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]"))).dragAndDropBy(browser.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]")),-50,0).perform();
		mouse.moveToElement(browser.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]"))).dragAndDropBy(browser.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]")),50,0).perform();

	}
	
	public void MouseMovewithKeyboard() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(1000);
		mouse.keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).perform();
		mouse.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		M.MouseMovewithKeyboard();
	}

}
