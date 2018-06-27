package PageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BuyPage {
	// Call the driver from testcase to pageobject
	public BuyPage(AndroidDriver<AndroidElement> driver) {
		// Initialize all elements with driver
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android:id/numberpicker_input = 1")
	public AndroidElement picker;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(REVIEW)")
	public AndroidElement reviewOrder;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(select address)")
	public AndroidElement confirmaddress;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(SONY BRAVIA 65 INCH 65X9300D ULTRA HD 4K SMART LED TV +ONE YEAR DEALER WARRANTY)")
	public AndroidElement productTitle;

	@AndroidFindBy(className = "android.widget.EditText")
	public AndroidElement buyCount;

	@AndroidFindBy(id = "proceedToPay")
	public AndroidElement proceedToPay;

	@AndroidFindBy(id = "selectpaymentoption")
	public AndroidElement paymentOption;

}
