package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebDriver driver ;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By userId= By.name("email");
	By password= By.name(" password");
	By signButton = By.name("commit");
	
	public WebElement getLogin() {
	return driver.findElement(signin);
	
	
	
	}	
	public WebElement getUserId() {
		return driver.findElement(userId);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement signButton() {
		return driver.findElement(signButton);
	}
}
