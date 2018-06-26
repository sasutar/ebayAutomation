package Automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppTest extends Base {
	@Test
	public static void main(String[] args) throws MalformedURLException {
		

		AndroidDriver<AndroidElement> driver=capabilities();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");

	
	}
	
	

}
