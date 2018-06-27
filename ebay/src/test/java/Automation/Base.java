package Automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import configDataProvider.ConfigFileReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

abstract class Base {

	
	public static AndroidDriver<AndroidElement> Launch() throws MalformedURLException {
		
		// Declare AndroidDriver as the project only targets Android devices
		// Use Appium Driver in case both IOS and Android devices are going to be the
		// DUT
		AndroidDriver<AndroidElement> driver;
		//Use configured values instead of hardcoding
		ConfigFileReader configFileReader;
	
		configFileReader= new ConfigFileReader();

		// TODO Auto-generated method stub
		File appDir = new File(configFileReader.getAppDir());
		File app = new File(appDir, configFileReader.getAppPath());
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configFileReader.getDeviceName());
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, configFileReader.getPlatformName());
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, configFileReader.getNewCommandTimeOut());
		driver = new AndroidDriver<>(new URL(configFileReader.getAppiumURL()), capabilities);

		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);

		return driver;
	}

}
