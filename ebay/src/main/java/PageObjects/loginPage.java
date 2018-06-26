package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {
	// Call the driver from testcase to pageobject
	public loginPage(AndroidDriver<AndroidElement> driver) {
		// Initialize all elements with driver
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(className = "android.widget.ImageView")
	public AndroidElement LoginImage;

	@AndroidFindBy(className = "android.widget.ImageView")
	public AndroidElement UsernameEditText;

	@AndroidFindBy(className = "android.widget.ImageView")
	public AndroidElement PasswordEditText;

	@AndroidFindBy(className = "android.widget.ImageView")
	public AndroidElement LoginButton;
}
