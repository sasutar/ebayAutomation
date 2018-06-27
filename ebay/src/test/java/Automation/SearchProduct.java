package Automation;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

import PageObjects.BuyPage;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchProduct extends Login {
	@Test(dataProvider = "getData")
	public static void search(String username, String password, String product) throws MalformedURLException {
		// Call login class to first login to the app
		AndroidDriver<AndroidElement> driver = login(username, password);

		HomePage home = new HomePage(driver);
		ProductPage prodPage = new ProductPage(driver);
		BuyPage buy = new BuyPage(driver);

		// Search for product in search box
		Wrapper.sendKeys(driver, home.SearchBox, product);
		// Find the product in search result: scroll down if the product in not in the
		// view
		Wrapper.scroll(driver, home.ProductTitle);
		// Click on the search result matching product title
		Wrapper.click(driver, home.ProductTitle);
		// Validate if the product opened is the right one by validating the Product
		// title
		Wrapper.assertTrue(driver, home.ProductTitle, product);
		// Scroll to view Buy Now button
		Wrapper.scroll(driver, prodPage.BuyNow);
		// Click on Buy Now button
		Wrapper.click(driver, prodPage.BuyNow);
		// Select the item count
		Wrapper.sendKeys(driver, buy.picker, "1");
		// Scroll to view Review button
		Wrapper.scroll(driver, buy.reviewOrder);
		// Click on review
		Wrapper.click(driver, buy.reviewOrder);
		// Click on address to confirm address
		Wrapper.click(driver, buy.confirmaddress);
		// Validate if the product seen in the cart before making payment is the right
		// one
		Wrapper.assertTrue(driver, buy.productTitle, product);
		// Validate the displayed item count matches to eirlier selected
		Wrapper.assertTrue(driver, buy.buyCount, "1");
		// Scroll to view Proceed to Pay button
		Wrapper.scroll(driver, buy.proceedToPay);
		// Click Proceed
		Wrapper.click(driver, buy.proceedToPay);
		// Select Payment options
		Wrapper.assertTrue(driver, buy.paymentOption, "Select Payment Option");

	}

}
