package PageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	// Call the driver from testcase to pageobject
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		// Initialize all elements with driver
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(className = "android.widget.ImageView")
	public AndroidElement LoginImage;

	@AndroidFindBy(className = "android.widget.EditText")
	public AndroidElement UsernameEditText;

	@AndroidFindBy(className = "android.widget.EditText1")
	public AndroidElement PasswordEditText;

	@AndroidFindBy(className = "android.widget.Button")
	public AndroidElement LoginButton;
}
