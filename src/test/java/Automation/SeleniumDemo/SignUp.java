package Automation.SeleniumDemo;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.RegistrationPage;
import resources.Base;

public class SignUp extends Base {

	@BeforeMethod
	public void fetchURL() throws IOException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		// driver.get("https://qaclickacademy.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}

	@Test(description = "New user sign up")
	public void signUp() {
		RegistrationPage rp = new RegistrationPage(driver);
		rp.signUp().click();
		rp.username().sendKeys("Bindu");
		rp.email().sendKeys("bindu.ch@test.com");
		rp.password().sendKeys("Tester99");
		rp.confirmPass().sendKeys("Tester99");
		rp.promo().click();
		rp.confirmSignUP().click();

	}

	@AfterMethod()
	public void closeBrowser() {
		driver.close();
	}

}
