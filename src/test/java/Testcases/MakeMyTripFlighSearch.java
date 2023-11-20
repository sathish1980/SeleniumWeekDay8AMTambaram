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
import Pages.SearchPage;
import Pages.SearchResultPage;
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
		SearchPage s = new SearchPage(driver);
		SearchResultPage sp = new SearchResultPage(driver);
		s.SelectFromLocation("MAA");
		s.SelectTOLocation("BLR");
		s.SelectDepatureDate("25");
		String FromCityName=s.GetFromLocation();
		String ToCityName=s.GetTOLocation();
		s.ClickOnSearchButton();
		sp.WaitAndClickOnPopup();
		Assert.assertEquals(sp.GetActualSearchText(), sp.ExpectedSearchText(FromCityName,ToCityName));
		driver.navigate().back();
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

		Thread.sleep(5000);
		c.ClickIfElementExist(driver,"//*[@class='close']");
		Thread.sleep(2000);

		SearchPage s = new SearchPage(driver);
		s.SelectTOLocation("MAA");
		String ToCityName=s.GetTOLocation();
		Assert.assertEquals(s.GetSameCityActualErrorMessage(), s.GetExecpetedSamecityError());

	}

	@AfterSuite
	public void CloseTheApplication() throws IOException
	{
		CloseBrowser();
	}

}
