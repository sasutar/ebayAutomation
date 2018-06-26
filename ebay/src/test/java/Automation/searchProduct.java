package Automation;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class searchProduct extends Login {
	@Test(dataProvider = "getData")
	public static void searchProduct(String username, String password, String product) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = login(username, password);

		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");

	}

}
