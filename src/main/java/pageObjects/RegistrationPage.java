package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
	}

	By signUP = By.cssSelector("a[href*='sign_up']");
	By username = By.id("user_name");
	By email = By.id("user_email");
	By password = By.name("user[password]");
	By confirmPass = By.name("user[password_confirmation]");
	By promo = By.id("user_unsubscribe_from_marketing_emails");
	By termCondition = By.name("user[agreed_to_terms]");
	By confirmSignUP = By.xpath("//input[@name='commit']");

	public WebElement signUp() {
		return driver.findElement(signUP);

	}

	public WebElement username() {
		return driver.findElement(username);

	}

	public WebElement email() {
		return driver.findElement(email);

	}

	public WebElement password() {
		return driver.findElement(password);

	}

	public WebElement confirmPass() {
		return driver.findElement(confirmPass);

	}

	public WebElement promo() {
		return driver.findElement(promo);

	}

	public WebElement termCondition() {
		return driver.findElement(termCondition);

	}

	public WebElement confirmSignUP() {
		return driver.findElement(confirmSignUP);

	}

}
