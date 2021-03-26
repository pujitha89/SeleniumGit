package pujithaselenium.MavenProject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TitleValidation extends InitilizeDrivers {
@BeforeTest
public void BrowserOpen() throws IOException
{
	driver=Browsers();
	driver.get(prop.getProperty("url"));
}
@Test
public void Validation()
{
	Title t=new Title(driver);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window, scrollBy(0,500)");
	String titleone=t.FirstTitle().getText();
	String titletwo=t.SecondTitle().getText();
	
	Assert.assertEquals(titleone, "POPULAR");
	Assert.assertEquals(titletwo, "BEST SELLERS");
}
@AfterTest
public void browserclose()
{
	driver.close();
}
}
