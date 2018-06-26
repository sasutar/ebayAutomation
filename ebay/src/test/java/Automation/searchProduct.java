package Automation;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

import PageObjects.buyPage;
import PageObjects.homePage;
import PageObjects.productPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class searchProduct extends Login {
	@Test(dataProvider = "getData")
	public static void search(String username, String password, String product) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = login(username, password);

		homePage home = new homePage(driver);
		productPage prodPage = new productPage(driver);
		buyPage buy = new buyPage(driver);

		Wrapper.sendKeys(driver, home.SearchBox, product);

		Wrapper.scroll(driver, home.ProductTitle, product);

		Wrapper.click(driver, home.ProductTitle);

		Wrapper.assertTrue(driver, home.ProductTitle, product);

		Wrapper.click(driver, prodPage.BuyNow);

		Wrapper.sendKeys(driver, buy.picker, "1");

		Wrapper.click(driver, buy.reviewOrder);

		Wrapper.click(driver, buy.confirmaddress);

		Wrapper.assertTrue(driver, buy.productTitle, product);

		Wrapper.assertTrue(driver, buy.buyCount, "1");

		Wrapper.click(driver, buy.proceedToPay);

		Wrapper.assertTrue(driver, buy.paymentOption, "Select Payment Option");

	}

	private static productPage productPage(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
