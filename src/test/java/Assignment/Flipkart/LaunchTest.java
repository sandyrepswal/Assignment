package Assignment.Flipkart;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Assignment.Flipkart.BrowserType;

/**
 * Unit test for simple App.
 */
public class LaunchTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LaunchTest( String testName )
    {
    }

    @Test(dataProvider = "data-provider")
    public void TestFlipkart(BrowserType browser) throws Exception
    {
    	LaunchBrowser objLaunch = new LaunchBrowser(browser);
    	WebDriver driver = objLaunch.getDriver();
    	 driver.get("https://www.flipkart.com"); 
    	 FlipkartHomePage objHomePage = new FlipkartHomePage();
    	 objHomePage.SearchText("Samsung Galaxy S10", driver);
    	 WebElement categoryElem = objHomePage.locateCategoryResult("mobile",driver);
    	 if(categoryElem == null)
    	 {
    		 throw new Exception("Test failed :Desired category not found");
    	 }
    	 categoryElem.click();
    	 FlipkartResultPage objResultPage = new FlipkartResultPage();
    	 List<ProductResults> testResult = objResultPage.GetProductResults(driver);
    	 for(ProductResults currResult : testResult)
    	 {
    		 System.out.println("Product Name is:"+currResult.productname);
    		 System.out.println("Product Url is:"+currResult.productUrl);
    		 System.out.println("Product Price is:"+currResult.productPrice);
    	 }
    
    
    	
    }
    
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
    return new Object[][] {{BrowserType.Chrome}};
    }
}
