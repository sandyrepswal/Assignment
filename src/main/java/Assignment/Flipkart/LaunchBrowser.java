package Assignment.Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.URL;

public class LaunchBrowser {
	
	BrowserType browser;
	WebDriver Driver;
	LaunchBrowser(BrowserType requestedBrowser)
	{
		
		browser= requestedBrowser;
		initializerequestedBrowser();
	}
	
	public void initializerequestedBrowser()
	{
		switch(browser)
		{
			case Chrome :   System.setProperty("webdriver.chrome.driver", "C:\\workspace\\Training\\Project\\Flipkart\\chromedriver.exe");
							System.setProperty("java.net.preferIPv4Stack" , "true");
							 ChromeOptions chromeOpts = new ChromeOptions();
							 chromeOpts.setBinary( "C:\\workspace\\Training\\Project\\Flipkart\\chromedriver.exe");
							 DesiredCapabilities caps = new DesiredCapabilities();
							 caps.setCapability(ChromeOptions.CAPABILITY,  chromeOpts);
						
						
							Driver = new RemoteWebDriver(caps);
							Driver = new ChromeDriver();
							Driver.manage().window().maximize();
						
		}
	}
	
	public WebDriver getDriver() {
		return Driver;
	}
	

}

enum BrowserType
{
	Chrome, Firefox;
}
