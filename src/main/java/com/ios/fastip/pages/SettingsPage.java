package com.ios.fastip.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage {
		
		private AppiumDriver<MobileElement> driver;
		
	    public SettingsPage() {
	    }
	    
	    public  SettingsPage(AppiumDriver<MobileElement> driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	    
	    @AndroidFindBy(id = "org.traeg.fastip:id/tipPercentageEditText")
	    private AndroidElement tipPercentage;
	    
	    @AndroidFindBy(id = "org.traeg.fastip:id/saveSettingsButton")
	    private AndroidElement savesettingsbtn;
	    
	    @AndroidFindBy(id = "android:id/alertTitle")
	    private AndroidElement alertTitle;
	    
	    @AndroidFindBy(id = "android:id/message")
	    private AndroidElement alertMessage;
	    
	    @AndroidFindBy(id = "android:id/button1")
	    private AndroidElement alertOKButton;
	    
	    
	    public void changetipPercentage(String percentage)
	    {
	    		tipPercentage.clear();
	    		tipPercentage.sendKeys(percentage);
	    		savesettingsbtn.click();
	    }
	    
	    public String getAlertTitle()
	    {
	    		return alertTitle.getText();
	    }

	    public String getAlertMessage()
	    {
	    		return alertMessage.getText();
	    }
	    
	    public void clickAlertOK()
	    {
	    		 alertOKButton.click();
	    }
}
