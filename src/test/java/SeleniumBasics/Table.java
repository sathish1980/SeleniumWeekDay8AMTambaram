package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {
	
	public void tableImplementation(String expectedCountry) throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://leafground.com/table.xhtml");
		// pagination
		List<WebElement> totalPages = browser.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for(int j=1;j<=totalPages.size();j++)
		{
			 browser.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
			 Thread.sleep(1000);
		//Each Page
			List<WebElement> AllRows = browser.findElements(By.xpath("//*[@id='form:j_idt89_data']//tr"));
			for(int i=1;i<=AllRows.size();i++)
			{
				String actualCountry = browser.findElement(By.xpath("//*[@id='form:j_idt89_data']//tr["+i+"]//td[2]//span[contains(@style,'vertical-align:')]")).getText();
				if(actualCountry.equalsIgnoreCase(expectedCountry))
				{
					String  Name = browser.findElement(By.xpath("//*[@id='form:j_idt89_data']//tr["+i+"]//td[1]")).getText();
					System.out.println(Name);
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Table T = new Table();
		T.tableImplementation("Italy");
	}

}
