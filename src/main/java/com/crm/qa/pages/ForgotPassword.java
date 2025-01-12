package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ForgotPassword extends TestBase{
	
	@FindBy(xpath="//h6[text()=\"Reset Password\"]")
	WebElement heading;
	
	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement userName;
	
	@FindBy(xpath="//button[text()=\" Reset Password \"]")
	WebElement resetBtn;
	
	@FindBy(xpath="//h6[contains(@class,'orangehrm-forgot-password-title')]")
	WebElement resetLink;
	
	public ForgotPassword() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeading() {
		return heading.getText();
	}
	
	public String resetPass() {
		userName.sendKeys(prop.getProperty("username"));
		resetBtn.click();
		
		return resetLink.getText();
	}

}
