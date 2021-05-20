package Automation.SeleniumDemo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.RegistrationPage;
import resources.Base;

public class HomePage extends Base {
	
public static Logger logger = LogManager.getLogger(Base.class.getName());
	@BeforeMethod
	public void fetchURL() throws IOException {
		driver = InitializeDriver();
		
		logger.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		
		//driver.get("https://qaclickacademy.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		logger.info("Title verified");
		
		
		
	}

	@Test(description = "Login test" , dataProvider ="testData")

	public void homePage(String username ,String password) throws IOException {
		LandingPage lp = new LandingPage(driver);
		logger.always();
		lp.getLogin().click();
		lp.getUserId().sendKeys(username);
		lp.password().sendKeys(password);
		lp.signButton().click();
		Assert.assertTrue(true, "Sign in is successful");
		logger.info("Customer is signed in");

	}

	

	@AfterMethod()
	public void closeBrowser() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] testData() {
		Object[][] data = {{"Bindu","Tester"},{"Chandu","Tester11"}};
		return data;
		
	}

}
