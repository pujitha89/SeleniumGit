package ExtentReports;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
	ExtentReports reports;
	@BeforeMethod
	public void reports()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("MavenReports");
		reporter.config().setReportName("MavenExtentReports");
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "pujitha");
	}
	@Test
	public void test()
	{
		ExtentTest test=reports.createTest("test");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://uk.yahoo.com/");
		test.fail("not match");
		reports.flush();
	}
}
