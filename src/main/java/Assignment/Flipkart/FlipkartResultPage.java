package Assignment.Flipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartResultPage {
	
	By resultList = By.cssSelector("div[class='col col-7-12']");
	By resultName = By.cssSelector("_4rR01T");
	By urlLocator = By.xpath(".//ancestor::a");
	By priceLocator = By.cssSelector("div[class='_30jeq3 _1_WHN1']");
	
	
	public List<ProductResults> GetProductResults(WebDriver driver)
	{
		List<ProductResults> result = null ;
		List<WebElement> resultElems = driver.findElements(resultList);
		if(resultElems.size()<=0)
		{
			return null;
		}
		for(WebElement currElem :resultElems)
		{
			ProductResults temp = new ProductResults();
			WebElement nameElem = currElem.findElement(resultName);
			temp.productname = nameElem.getText();
			WebElement urlElem = currElem.findElement(urlLocator);
			temp.productUrl = urlElem.getAttribute("href");
			WebElement priceElem = currElem.findElement(priceLocator);
			temp.productPrice = priceElem.getText();
			
			result.add(temp);		
			
		}
		
		return(result);
		
		
		
	}

}

class ProductResults{
	public String productname;
	public String productPrice;
	public String productUrl;
}