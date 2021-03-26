package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.backend.StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import pujitha.Cucumber.PageObjects;

@RunWith(Cucumber.class)
public class StepDefintionReq1 {
	public static Logger log = LogManager.getLogger(StepDefinition.class.getName());
	WebDriver driver;
	PageObjects po;

	@Given("^User navigate to homepage$")
	public void user_navigate_to_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		log.info("navigate to url");
	}

	@When("^User login to the application with invalid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_to_the_application_with_invalid_username_something_and_password_something(String username,
			String password) throws Throwable {
		PageObjects po = new PageObjects(driver);
		po.signUp().click();
		po.Email().sendKeys(username);
		po.passwd().sendKeys(password);
		po.LogIn().click();
		log.info("enter the invalid credentials");
		System.out.println(username);
		System.out.println(password);
	}

	@Then("^User should see an error message$")
	public void user_should_see_an_error_message() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(po.ErrorMsg().getText());
		log.info("printed the error message");
		driver.close();
	}

}
