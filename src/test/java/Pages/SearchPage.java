package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebElementCommons;

public class SearchPage extends WebElementCommons{

	@FindBy(xpath="//*[@for='fromCity']")
	WebElement FromCityElement;

	By fromCity = By.xpath("//*[@for='fromCity']");

	WebDriver driver;

	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	private String expectedErrorMessage ="From & To airports cannot be the same";


	public void SelectFromLocation(String fromLocation)
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[@for='fromCity']"),60);
		//ClickOnButton(driver.findElement(fromCity));
		ClickOnButton(FromCityElement);
		//WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
		WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
		SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),fromLocation);

	}

	public String GetFromLocation()
	{
		return GetAttributeOfelement(driver.findElement(By.xpath("//input[@id='fromCity']")),"value");
	}

	public void SelectTOLocation(String toLocation)
	{
		ClickOnButton(driver.findElement(By.xpath("//*[@for='toCity']")));
		//ClickOnButton(toField);

		SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),toLocation);
	}

	public String GetTOLocation()
	{
		return GetAttributeOfelement(driver.findElement(By.xpath("//input[@id='toCity']")),"value");
	}

	public void SelectDepatureDate(String depatureDate)
	{
		SelectValueinCalender(driver,depatureDate);
	}

	public void ClickOnSearchButton()
	{
		clickOnButton(driver.findElement(By.xpath("//*[@data-cy='submit']//a")));
	}

	public String GetSameCityActualErrorMessage()
	{
		WaitForElementToBeVisible(driver, By.cssSelector("[data-cy='sameCityError']"), 60);
		return GetTextOfelement(driver.findElement(By.cssSelector("[data-cy='sameCityError']")));

	}

	public String GetExecpetedSamecityError()
	{
		return expectedErrorMessage;
	}



}
