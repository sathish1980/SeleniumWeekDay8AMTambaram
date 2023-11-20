package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonUtils.WebElementCommons;

public class SearchResultPage extends WebElementCommons{

	WebDriver driver;

	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void WaitAndClickOnPopup()
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[text()='OKAY, GOT IT!']"),60);
		clickOnButton(driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")));

	}

	public String GetActualSearchText()
	{
		return GetTextOfelement(driver.findElement(By.xpath("//*[contains(@class,'journey-title')]")));
	}

	public String ExpectedSearchText(String FromCityName, String ToCityName)
	{
		return "Flights from "+FromCityName+" to "+ToCityName;

	}

}
