package Automation;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Login extends Base {
	// Test Login functionality after launching the app
	@Test
	public static AndroidDriver<AndroidElement> login(String username, String password) throws MalformedURLException {
		// Invoke Android Driver with capabilities
		AndroidDriver<AndroidElement> driver = Launch();

		// Wrapper wrapper=new Wrapper();
		HomePage home = new HomePage(driver);

		LoginPage login = new LoginPage(driver);

		// Click on the three horizontal line icon on top left
		Wrapper.click(driver, home.Home);
		// Click on Login Image
		Wrapper.click(driver, login.LoginImage);
		// Enter Username
		Wrapper.sendKeys(driver, login.UsernameEditText, username);
		// Enter Password
		Wrapper.sendKeys(driver, login.PasswordEditText, password);
		// Click Login button
		Wrapper.click(driver, login.LoginButton);
		// Validate if login was successful
		Wrapper.assertTrue(driver, home.signInStatus, "expected name");

		return driver;

	}

}
