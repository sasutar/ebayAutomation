package Automation;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

import PageObjects.homePage;
import PageObjects.productPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class searchProduct extends Login {
	@Test(dataProvider = "getData")
	public static void search(String username, String password, String product) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = login(username, password);
		
		homePage home=new homePage(driver);
		productPage prodPage= productPage(driver);
		
		Wrapper.sendKeys(driver, home.SearchBox, product);
		Wrapper.scroll(driver, home.ProductTitle, product);
		Wrapper.click(driver, home.ProductTitle);
		
		Wrapper.assertTrue(driver, home.ProductTitle, product);
		
		Wrapper.click(driver,prodPage.BuyNow);

	}

	private static productPage productPage(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
