package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

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

	@Test(priority=0,dataProvider="GetValidSearchTestData",dataProviderClass=MakeMyTripTestData.class)
	public void SearchWithValidValues(String from,String to ,String date)
	{

		/*
		 * Click on From Location
		 * Click on To Location
		 * Select the Date
		 * click on search Button
		 * Click Ok in the upcoming popup
		 * Get the search result text and validate with the input
		 */
		test.log(LogStatus.INFO, "Make My trip loaded sucessfully");
		SearchPage s = new SearchPage(driver);
		SearchResultPage sp = new SearchResultPage(driver);
		s.SelectFromLocation(from);
		test.log(LogStatus.INFO, "From Value Selected Sucefully: "+from);

		s.SelectTOLocation(to);
		test.log(LogStatus.INFO, "To Value Selected Sucefully: "+to);

		s.SelectDepatureDate(date);
		test.log(LogStatus.INFO, "Date Selected Sucefully: "+date);

		String FromCityName=s.GetFromLocation();
		String ToCityName=s.GetTOLocation();
		s.ClickOnSearchButton();
		test.log(LogStatus.INFO, "Search button clicked sucessfully");

		sp.WaitAndClickOnPopup();
		String screenshotPath = s.takescreenshot(driver);
		Assert.assertEquals(sp.GetActualSearchText(), sp.ExpectedSearchText(FromCityName,ToCityName));
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		driver.navigate().back();
	}

	/*Created By : Sathish kumar R
	 * Created On :10-11-2023
	 * REQ NO :3
	 * TC NO :12
	 *
	 */
	@Test(priority=1,dataProvider="GetinValidSearchTestData",dataProviderClass=MakeMyTripTestData.class)
	public void SearchWithSameFromAndToLocation(String from, String to) throws InterruptedException
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
		s.SelectFromLocation(from);
		test.log(LogStatus.INFO, "From Value Selected Sucefully: "+from);

		s.SelectTOLocation(to);
		test.log(LogStatus.INFO, "Same To location is selected");

		String ToCityName=s.GetTOLocation();
		String screenshotPath = s.takescreenshot(driver);

		Assert.assertEquals(s.GetSameCityActualErrorMessage(), s.GetExecpetedSamecityError());
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	}

	@AfterSuite
	public void CloseTheApplication() throws IOException
	{
		CloseBrowser();
	}

	@AfterMethod
	public void ReportUpdate(ITestResult result)
	{
		if (result.getStatus() == 1) {
			test.log(LogStatus.PASS, result.getMethod().getMethodName() +" Test Passed");  // new
		} else if (result.getStatus() == 2) {
			String screenshotPath = c.takescreenshot(driver);
			test.log(LogStatus.INFO, result.getMethod().getMethodName() +" Test Error info",test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() +" Test Error");  // new
		} else if (result.getStatus() == 3) {
			test.log(LogStatus.SKIP, result.getMethod().getMethodName()+" Test Skipped");  // new
		}
	}



}
