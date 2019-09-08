package com.ios.fastip.testcases;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ios.fastip.pages.HomePage;
import com.fastip.utils.Projectutils;
import com.ios.fastip.pages.SettingsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AppiumDriver<MobileElement> driver;
	HomePage homepage;
	SettingsPage settingspage;
	Projectutils utils;
	
	@BeforeClass
	public void setup() throws Exception
	{
		utils = new Projectutils();
		String projectPath = System.getProperty("user.dir");
		String app_path=projectPath+"/src/test/resources/";
		
		DesiredCapabilities cap = new DesiredCapabilities();
		  
		  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, utils.getproperty("PLATFORM_NAME"));
		  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, utils.getproperty("PLATFORM_VERSION"));
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, utils.getproperty("DEVICE_NAME"));
		  cap.setCapability(MobileCapabilityType.UDID, utils.getproperty("UDID"));
		  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		  cap.setCapability(MobileCapabilityType.APP, app_path+utils.getproperty("APP"));
		  cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, utils.getproperty("APP_PACKAGE"));
		  cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, utils.getproperty("APP_ACTIVITY"));
		  
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");  
		  driver = new AndroidDriver<MobileElement>(url, cap);
		  		  
		  homepage=new HomePage(driver);
		  settingspage=new SettingsPage(driver);
	}
	
	@AfterClass
	  public void uninstallApp() throws InterruptedException {
	    driver.removeApp("org.traeg.fastip");
	  }

}
