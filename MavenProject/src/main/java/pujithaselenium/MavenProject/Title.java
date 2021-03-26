package pujithaselenium.MavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Title {
public WebDriver driver;

public Title(WebDriver driver)
{
	this.driver=driver;
	
}
    By title1=By.className("homefeatured");
    By title2=By.className("blockbestsellers");
    
    public WebElement FirstTitle()
    {
    	return driver.findElement(title1);
    }
    public WebElement SecondTitle()
    {
    	return driver.findElement(title2);
    }
}
