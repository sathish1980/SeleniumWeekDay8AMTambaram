package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxandRadioButton {
	
	WebDriver browser;
	public void Checkbox(String[] expectedCourseNames)
	{
		browser = new ChromeDriver();
		browser.get("https://leafground.com/checkbox.xhtml");
		browser.manage().window().maximize();
		WebElement basicCheckbox= browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//div[contains(@class,'ui-chkbox-box')]")); 
		basicCheckbox.click();
		String classAttribute = basicCheckbox.getAttribute("class");
		if(classAttribute.contains("ui-state-active"))
		{
			System.out.println("Yes ! its avaialble");
		}
		
		
		for(String expectedCourseName : expectedCourseNames)
		{
		List<WebElement> AllCourses = browser.findElements(By.xpath("//*[@id='j_idt87:basic']//td"));
		for(int i=1;i<=AllCourses.size();i++)
		{
			String actualCourseName = browser.findElement(By.xpath("//*[@id='j_idt87:basic']//td["+i+"]//label")).getText();
			if(actualCourseName.equalsIgnoreCase(expectedCourseName))
			{
				browser.findElement(By.xpath("//*[@id='j_idt87:basic']//td["+i+"]//div[contains(@class,'ui-chkbox-box')]")).click();
				break;
				
			}
		}
		}
		Toggle();
		// toggle slider()
	}
	
	public void Toggle()
	{
		browser.findElement(By.xpath("//*[@id='j_idt87:j_idt100']//div[@class='ui-toggleswitch-slider']")).click();
		String classAttribute = browser.findElement(By.xpath("//*[@id='j_idt87:j_idt100']")).getAttribute("class");
		if(classAttribute.contains("ui-toggleswitch-checked"))
		{
			System.out.println("Yes ! its avaialble");
		}
		
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='ui-growl-message']//span")));
		String Toast = browser.findElement(By.xpath("//*[@class='ui-growl-message']//span")).getText();
		System.out.println(Toast);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='ui-growl-message']//span")));
		
		//uncheck
		browser.findElement(By.xpath("//*[@id='j_idt87:j_idt100']//div[@class='ui-toggleswitch-slider']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='ui-growl-message']//span")));
		String Toast1 = browser.findElement(By.xpath("//*[@class='ui-growl-message']//span")).getText();
		System.out.println(Toast1);
		
	}
	
	public void RadioButton()
	{
		WebDriver browser = new ChromeDriver();
		browser.get("https://leafground.com/radio.xhtml");
		browser.manage().window().maximize();
		browser.findElement(By.xpath("(//*[@id='j_idt87:console1']//tr[1]//div[contains(@class,'ui-radiobutton-box')])[4]")).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckboxandRadioButton C= new CheckboxandRadioButton();
		String[] cousrses = {"javascript","Others","Python"};
		//C.Checkbox(cousrses);
		//C.Checkbox("javascript");
		C.RadioButton();
		
	}

}
