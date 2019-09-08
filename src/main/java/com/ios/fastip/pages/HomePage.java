package com.ios.fastip.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	private AppiumDriver<MobileElement> driver;
	
    public HomePage() {
    }
    public  HomePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "org.traeg.fastip:id/billAmtEditText")
    private AndroidElement billAmount;
    
    @AndroidFindBy(id = "org.traeg.fastip:id/calcTipButton")
    private AndroidElement calculateTipBtn;
    
    @AndroidFindBy(id = "org.traeg.fastip:id/tipAmtTextView")
	private AndroidElement tipAmount;
    
    @AndroidFindBy(id = "org.traeg.fastip:id/totalAmtTextView")
    private AndroidElement totalAmount;
    
    @AndroidFindBy(id = "org.traeg.fastip:id/tipPctTextView")
    private AndroidElement tipPercentage;
    
    @AndroidFindBy(id = "org.traeg.fastip:id/menu_settings")
    private AndroidElement settingsBtn;
    
    
    public void calculate(String amount)
	{
	    	billAmount.sendKeys(amount);
	    	calculateTipBtn.click();
    }
    
    public String getTipAmount()
    {
    		return tipAmount.getText();    		
    }
    
    public String getTotalAmount()
    {
    		return totalAmount.getText();   		
    }
    
    public String gettipPercentage()
    {
    		return tipPercentage.getText();   		
    }
    
    public void clickSettings()
    {
    		settingsBtn.click();
    }
    
    
    
}
