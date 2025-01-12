package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	 @FindBy(name="username")
	 WebElement userName;
	 
	 @FindBy(name="password")
	 WebElement passWord;
	 
	 @FindBy(xpath="//button[@type='submit']")
	 WebElement loginBtn; 
	 
	 @FindBy(xpath= "//p[contains(@class,'orangehrm-login-forgot-header')]")
	 WebElement forgotPass;
	 
	 @FindBy(xpath="//div[@class='orangehrm-login-logo']")
	 WebElement imagelogo;
	 
	 public LoginPage() {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public String validateLoginPageTitle() {
		 return driver.getTitle();
	 }
	 
	 public boolean validateCRMLogo() {
		 return imagelogo.isDisplayed();
	 }
	 
	 public Dashboard Login(String un , String pw) {
		 userName.sendKeys(un);
		 passWord.sendKeys(pw);
		 loginBtn.click();
		 
		 return new Dashboard();
	 }
	 
	 public ForgotPassword forgotPassword() {
		 forgotPass.click();
		 
		 return new ForgotPassword();
	 }

}
