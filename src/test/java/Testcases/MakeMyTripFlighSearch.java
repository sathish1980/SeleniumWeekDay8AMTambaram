package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.Browser;
import CommonUtils.WebElementCommons;
import Utils.PropertyFileRead;


public class MakeMyTripFlighSearch extends Browser{

	WebElementCommons c = new WebElementCommons();

	@BeforeSuite
	public void LaunchTheBrowser() throws IOException
	{
		LaunchBrowser();
	}

	@BeforeTest
	public void OpenTheApplication() throws IOException
	{
		String applicationURL =PropertyFileRead.GetEnvironmentDetail().getProperty("url");
		driver.get(applicationURL);
		//driver.navigate().refresh();
	}
	@BeforeClass
	public void deleteAdds() throws InterruptedException
	{
		Thread.sleep(3000);
		c.ClickIfElementExist(driver,"//*[@data-cy='closeModal']");
		Thread.sleep(1000);
		c.ClickIfElementExist(driver,"//*[@class='close']");
		Thread.sleep(2000);
		c.CloseCreateAccountPopup(driver.findElement(By.xpath("//*[@data-cy='closeModal']")));
		Thread.sleep(2000);
		//c.ClickOnAddClose(driver);

		//Thread.sleep(2000);
	}

	@Test(priority=0)
	public void SearchWithValidValues()
	{

		/*
		 * Click on From Location
		 * Click on To Location
		 * Select the Date
		 * click on search Button
		 * Click Ok in the upcoming popup
		 * Get the search result text and validate with the input
		 */
		//Select From location
		c.WaitForElementToBeClickable(driver,By.xpath("//*[@for='fromCity']"),60);
		c.ClickOnButton(driver.findElement(By.xpath("//*[@for='fromCity']")));


		//WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
		c.WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
		c.SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),"MAA");
		String FromCityName=c.GetAttributeOfelement(driver.findElement(By.xpath("//input[@id='fromCity']")),"value");
		//Select To Location

		//WebElement toButton = driver.findElement(By.xpath("//*[@for='toCity']"));
		c.ClickOnButton(driver.findElement(By.xpath("//*[@for='toCity']")));
		//ClickOnButton(toField);

		c.SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),"BLR");
		String ToCityName=c.GetAttributeOfelement(driver.findElement(By.xpath("//input[@id='toCity']")),"value");
		//Select Date
		c. SelectValueinCalender(driver,"18");
		//click on Search Button
		c.clickOnButton(driver.findElement(By.xpath("//*[@data-cy='submit']//a")));
		//Wait and click on ok in the Popopup
		c.WaitForElementToBeClickable(driver,By.xpath("//*[text()='OKAY, GOT IT!']"),60);
		c.clickOnButton(driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")));
		// get the search Result:
		String actualSearchResult =c.GetTextOfelement(driver.findElement(By.xpath("//*[contains(@class,'journey-title')]")));
		System.out.println(actualSearchResult);
		String expectedSearchResult = "Flights from "+FromCityName+" to "+ToCityName;
		Assert.assertEquals(actualSearchResult, expectedSearchResult);	driver.navigate().back();
	}

	/*Created By : Sathish kumar R
	 * Created On :10-11-2023
	 * REQ NO :3
	 * TC NO :12
	 *
	 */
	@Test(priority=1)
	public void SearchWithSameFromAndToLocation() throws InterruptedException
	{

		/*
		 * Click on From Location and select a value
		 * Select same as From in To Location
		 * Validate "From & To airports cannot be the same" error is displayed
		 */
		//Click on back button in the browser
		//driver.navigate().back();

		Thread.sleep(5000);
		c.ClickIfElementExist(driver,"//*[@class='close']");
		Thread.sleep(2000);
		//c.CloseCreateAccountPopup(driver.findElement(By.xpath("//*[@data-cy='closeModal']")));
		//Thread.sleep(2000);

		//Select To Location

		//WebElement toButton = driver.findElement(By.xpath("//*[@for='toCity']"));
		c.ClickOnButton(driver.findElement(By.xpath("//*[@for='toCity']")));
		//ClickOnButton(toField);

		c.SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),"MAA");
		String ToCityName=c.GetAttributeOfelement(driver.findElement(By.xpath("//input[@id='toCity']")),"value");
		c.WaitForElementToBeVisible(driver, By.cssSelector("[data-cy='sameCityError']"), 60);
		String actualErrorMessage =c.GetTextOfelement(driver.findElement(By.cssSelector("[data-cy='sameCityError']")));
		String expectedErrorMessage ="From & To airports cannot be the same";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@AfterSuite
	public void CloseTheApplication() throws IOException
	{
		CloseBrowser();
	}

}
