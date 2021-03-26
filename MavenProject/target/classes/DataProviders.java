package resources;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider
	public static Object[][] getData() {
		Object data[][] = new Object[3][2];

		data[0][0] = "pujitha@gmail.com";
		data[0][1] = "12345";

		data[1][0] = "poorna@gmail.com";
		data[1][1] = "123456";

		data[2][0] = "sai@gmail.com";
		data[2][1] = "1234567";
		return data;
	}
}
