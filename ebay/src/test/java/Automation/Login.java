package Automation;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Login extends Base {

	public static AndroidDriver<AndroidElement> login(String username, String password) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Launch();

		driver.findElementById("com.ebay.mobile:id/home").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");

		return driver;

	}

}
