package pujithaselenium.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitilizeDrivers {
	Properties prop;
	public static WebDriver driver;
public WebDriver Browsers() throws IOException
{
	 prop=new Properties();
	 FileInputStream input=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	 prop.load(input);
	// String BrowserName=System.getProperty("browser");
	 String BrowserName=prop.getProperty("browser");
	 if(BrowserName.contains("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver.exe");
		 ChromeOptions co=new ChromeOptions();
		 if(BrowserName.contains("headless"))
		 {
		 co.addArguments("headless");
		 }
		 driver=new ChromeDriver(co);
	 }
	 else if(BrowserName.equals("firefox"))
	 {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\geckodriver.exe");
		 driver=new FirefoxDriver();
}
	 else if(BrowserName.equals("IE"))
	 {
		 System.setProperty("webdriver.ie.driver", "C:\\Users\\User\\IEDriverServer.exe");
		 driver=new InternetExplorerDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
}
public String Screenshots(String testcasename) throws IOException
{
	TakesScreenshot screenshot=(TakesScreenshot)driver;
   File src=screenshot.getScreenshotAs(OutputType.FILE);
   String dest=System.getProperty("user.dir")+"\\reports\\" +testcasename+ ".png";
   FileUtils.copyFile(src,new File(dest));
   return dest;
}

}

