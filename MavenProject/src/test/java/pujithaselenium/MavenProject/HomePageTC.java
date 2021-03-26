package pujithaselenium.MavenProject;

import java.io.IOException;

import org.testng.annotations.Test;

public class HomePageTC extends InitilizeDrivers {
	@Test
	public void Browseropen() throws IOException
	{
		driver=Browsers();
		driver.get(prop.getProperty("url"));
		HomePage hp=new HomePage(driver);
		hp.SignIN().click();
	}

}
