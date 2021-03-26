package pujithaselenium.MavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Email=By.id("email");
	By Password=By.id("passwd");
	By Login=By.id("SubmitLogin");
	
	public WebElement username()
	{
		return driver.findElement(Email);
	}
    public WebElement passwd()
    {
    	return driver.findElement(Password);
    }
    public WebElement signin()
    {
    	return driver.findElement(Login);
    }
}

