package Automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class Wrapper {

	static Logger logger = Logger.getLogger("Wrapper_Class");

	// Clicks on provided Android element
	public static void click(AndroidDriver<AndroidElement> driver, AndroidElement el) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(el));
			el.click();
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			el.click();
		} catch (TimeoutException toe) {
			logger.debug("Element identified by " + el.toString() + " was not clickable after 10 seconds");
		}
	}

	// Enters text to the provided Edit text field element
	public static void sendKeys(AndroidDriver<AndroidElement> driver, AndroidElement el, String text) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(el));
			el.sendKeys(text);
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			el.sendKeys(text);
		} catch (TimeoutException toe) {
			logger.debug("Element identified by " + el.toString() + " could not enter text");
		}
	}

	// Scroll down untill the element is present
	public static void scroll(AndroidDriver<AndroidElement> driver, AndroidElement el) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeSelected((el)));
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(" + el.toString() + ");");
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(" + el.toString() + ");");

		} catch (TimeoutException toe) {
			logger.debug("Element identified by " + el.toString() + " was not scrollable after 10 seconds");
		}
	}

	// Return Text of an element
	public static String getText(AndroidDriver<AndroidElement> driver, AndroidElement el) {
		String text = null;
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(el));
			text = el.getText();
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			text = el.getText();
		} catch (TimeoutException toe) {
			logger.debug("Element identified by " + el.toString() + " could not be found");
		}
		return text;
	}

	// Validate if the result macthes to expected condition
	public static void assertTrue(AndroidDriver<AndroidElement> driver, AndroidElement el, String expected) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(el));
			Assert.assertTrue(el.getText() == expected);
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			el.getText();
		} catch (TimeoutException toe) {
			logger.debug("Element identified by " + el.toString() + " could not be found");
		}
	}
}
