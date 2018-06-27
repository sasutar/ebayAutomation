package configDataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getAppiumURL() {
		String appium_url = properties.getProperty("implicitlyWait");
		if (appium_url != null)
			return appium_url;
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}
	
	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getAppPath() {
		String appPath = properties.getProperty("app_path");
		if (appPath != null)
			return appPath;
		else
			throw new RuntimeException("app_path not specified in the Configuration.properties file.");
	}

	public String getDeviceName() {
		String deviceName = properties.getProperty("device_name");
		if (deviceName != null)
			return deviceName;
		else
			throw new RuntimeException("device_name not specified in the Configuration.properties file.");
	}
	
	public String getPlatformName() {
		String platformName = properties.getProperty("platform_name");
		if (platformName != null)
			return platformName;
		else
			throw new RuntimeException("device_name not specified in the Configuration.properties file.");
	}

	public long getNewCommandTimeOut() {
		String commandTimeOut = properties.getProperty("new_command_timeout");
		if (commandTimeOut != null)
			return Long.parseLong(commandTimeOut);
		else
			throw new RuntimeException("new_command_timeout not specified in the Configuration.properties file.");
	}

	public String getAppDir() {
		String appDir = properties.getProperty("app_dir");
		if (appDir != null)
			return appDir;
		else
			throw new RuntimeException("new_command_timeout not specified in the Configuration.properties file.");
	}

}