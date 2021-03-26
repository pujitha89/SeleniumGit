package pujithaselenium.MavenProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.DataProviders;

public class LoginPageTC extends InitilizeDrivers {
	public static Logger log=LogManager.getLogger(LoginPageTC.class.getName());
	@BeforeTest
	public void BrowserOpen() throws IOException {
		driver = Browsers();
		
	}

	@Test(dataProvider="getData",dataProviderClass = DataProviders.class)
	public void AccountVerification(String username,String password) {
		driver.get(prop.getProperty("url"));
		log.info("invoke browser");
		HomePage hp = new HomePage(driver);
		hp.SignIN().click();
		log.info("click the signin button");
		LoginPage lp = new LoginPage(driver);
		lp.username().sendKeys(username);
		lp.passwd().sendKeys();
		lp.signin().click();
		log.info("click on Login button after enter the credentials");
	}

	@AfterTest
	public void BrowserClose() {
		driver.close();
	}

}
