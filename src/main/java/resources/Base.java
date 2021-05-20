package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class Base {
	public WebDriver driver ;
	protected Properties prop ;
	// initialize driver
	public  WebDriver InitializeDriver()throws IOException {
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\workspace\\Learnselnium\\SeleniumDemo\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println("Bowser name is " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "F://workspace//chromedriver.exe");
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ChromeOptions cp = new ChromeOptions();
			cp.merge(dc);
			
			driver = new ChromeDriver(cp);

		}
		else if (browserName.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "F://workspace//geckodriver.exe");
			
			driver = new FirefoxDriver();

		}
		else if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.internetexplorer.driver", "F://workspace//iedriverserver.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;

	}
public 	void takeScreenshot(String testCaseName) throws IOException {
	File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	String destination = System.getProperty("user.dir")+"\\reports\\" + testCaseName+ ".png" ;
	
	
	FileUtils.copyFile(source,new File(destination));
		 	
}	
	

}
