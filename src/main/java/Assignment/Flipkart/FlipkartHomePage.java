package Assignment.Flipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartHomePage {
	
	By SearchBox = By.cssSelector("[name='q']");
	By SearchResList = By.cssSelector("li.Y5N33s");
	By listWithCategory = By.cssSelector("div[class='_1HeMA2']");
	
	public void SearchText(String input,WebDriver driver)
	{
		driver.findElement(SearchBox).clear();
		driver.findElement(SearchBox).sendKeys(input);
	}
	
	public WebElement locateCategoryResult(String categorySearch,WebDriver driver)
	{
		List<WebElement> resultList =  driver.findElements(SearchResList);
	
		for(WebElement currElem : resultList )
		{
			WebElement childElement = currElem.findElement(listWithCategory);
			if(childElement.getText().toLowerCase().contains(categorySearch))
			{
				return childElement;
			}
		}
		return null;
	}
	
	
	

}
