package CommonUtils;

import org.openqa.selenium.WebElement;

public class WebElementCommons {

	public void EnterTextInTextbox(WebElement textBox,String textToBeEnter)
	{
		if(textBox.isDisplayed())
		{
			textBox.clear();
			textBox.sendKeys(textToBeEnter);
		}
	}

	public String RetriveTextFromTextbox(WebElement textBox,String attribute)
	{
		if(textBox.isDisplayed())
		{
			String actualText;
			if(attribute==null)
			{
				actualText = textBox.getText();
			}
			else
			{
				actualText = textBox.getAttribute(attribute);
			}
			if(actualText!=null)
				return actualText;
		}
		return null;
	}

}

