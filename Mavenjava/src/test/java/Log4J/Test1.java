package Log4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test1 {
	
	private static Logger log = LogManager.getLogger(Test1.class.getName());
	ExtentReports report;
	@BeforeTest
	public void reports()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index1.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("MavenExtentReports");
		reporter.config().setReportName("Logged.file.Log4J");

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("tester", "pujitha");
	}
 @Test
  public void test()
	{
		report.createTest("test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.info("navigate to url");
		driver.get("https://uk.yahoo.com/?p=us");

	}

}
