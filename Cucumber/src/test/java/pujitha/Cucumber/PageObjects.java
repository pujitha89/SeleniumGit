package pujitha.Cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {
	public WebDriver driver;

	public PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By signin = By.className("login");
	By username = By.id("email");
	By password = By.id("passwd");
	By login = By.id("SubmitLogin");
    By error= By.xpath("//div[@class='alert alert-danger']/ol/li[1]");
	public WebElement signUp() {
		return driver.findElement(signin);
	}

	public WebElement Email() {
		return driver.findElement(username);
	}

	public WebElement passwd() {
		return driver.findElement(password);
	}

	public WebElement LogIn() {
		return driver.findElement(login);
	}
	public WebElement ErrorMsg()
	{
		return driver.findElement(error);
	}
}