package Automation;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import PageObjects.homePage;
import PageObjects.loginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Login extends Base {
    //Test Login functionality after launching the app
	@Test
	public static AndroidDriver<AndroidElement> login(String username, String password) throws MalformedURLException {
		// Invoke Android Driver with capabilities
		AndroidDriver<AndroidElement> driver = Launch();
	
		//Wrapper wrapper=new Wrapper();
		homePage home=new homePage(driver);
		
		loginPage login=new loginPage(driver);
		
		Wrapper.click(driver,  home.Home);
		Wrapper.click(driver, login.LoginImage);
		Wrapper.sendKeys(driver, login.UsernameEditText, username);
		Wrapper.sendKeys(driver, login.PasswordEditText, password);
		Wrapper.click(driver, login.LoginButton);
		
		
		return driver;

	}

}
