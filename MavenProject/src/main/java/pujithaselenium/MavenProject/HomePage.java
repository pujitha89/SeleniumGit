package pujithaselenium.MavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
   public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
    By signin= By.className("login");
    
    public WebElement SignIN()
    {
    	return driver.findElement(signin);
    }
}
