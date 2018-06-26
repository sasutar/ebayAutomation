package PageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class productPage {
	
	//Call the driver from testcase to pageobject
	public productPage(AndroidDriver<AndroidElement> driver ){
		//Initialize all elements with driver
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(BUY IT NOW)")
	public AndroidElement BuyNow;

}
