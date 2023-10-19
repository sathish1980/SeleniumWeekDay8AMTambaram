package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
	
	public void FBCreateAccount() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.findElement(By.xpath("//a[@role='button' and text()='Create new account']")).click();
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstname")));
		browser.findElement(By.name("firstname")).sendKeys("sathish");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("lastname")));
		
		browser.findElement(By.name("lastname")).sendKeys("sathish");
		
		Select dayDropdown = new Select(browser.findElement(By.cssSelector("[id='day']")));
		dayDropdown.selectByIndex(5);
		
		Select monthDropdown = new Select(browser.findElement(By.cssSelector("[id='month']")));
		monthDropdown.selectByValue("4");
		
		Select yearDropdown = new Select(browser.findElement(By.cssSelector("[id='year']")));
		yearDropdown.selectByVisibleText("2004");
		
	}
	
	public void multiselect() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		browser.manage().window().maximize();
		Select food = new Select(browser.findElement(By.cssSelector("select[id='second']")));
		if(food.isMultiple())
		{
			food.selectByIndex(0);
			Thread.sleep(1000);
			food.selectByVisibleText("Bonda");
			Thread.sleep(1000);
			food.selectByValue("donut");
			Thread.sleep(1000);
			food.deselectByVisibleText("Bonda");
			Thread.sleep(1000);
			food.deselectAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CreateAccount C = new CreateAccount();
		C.multiselect();
	}

}
