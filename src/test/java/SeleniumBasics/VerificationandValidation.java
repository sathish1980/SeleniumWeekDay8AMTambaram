package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationandValidation {
	public void vvimplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/window.xhtml");
		System.out.println(browser.getTitle());
		System.out.println(browser.getCurrentUrl());
		String role = browser.findElement(By.id("j_idt88:new")).getAttribute("role");
		System.out.println("My role is : " +role);
		String nullText = browser.findElement(By.id("j_idt88:new")).getText();
		System.out.println(nullText);
		String actualText = browser.findElement(By.xpath("//button[@id='j_idt88:new']//span")).getText();
		System.out.println(actualText);
		String color = browser.findElement(By.id("j_idt88:new")).getCssValue("color");
		System.out.println(color);
		String borderradius = browser.findElement(By.id("j_idt88:new")).getCssValue("border-radius");
		System.out.println(borderradius);
		System.out.println(browser.getWindowHandle());
		browser.findElement(By.id("j_idt88:new")).click();
		System.out.println(browser.getWindowHandles());
		
		
		System.out.println(browser.getTitle());
		System.out.println(browser.getCurrentUrl());
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerificationandValidation VV = new VerificationandValidation();
		VV.vvimplementation();
	}

}
