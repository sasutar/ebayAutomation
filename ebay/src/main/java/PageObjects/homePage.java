package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class homePage {
	//Call the driver from testcase to pageobject
	public homePage(AndroidDriver<AndroidElement> driver ){
		//Initialize all elements with driver
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.ebay.mobile:id/home")
	public AndroidElement Home;
	
	@AndroidFindBy(id="com.ebay.mobile:id/search_box")
	public AndroidElement SearchBox;
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_title")
	public AndroidElement ProductTitle;
	
	
}
