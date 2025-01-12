package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ForgotPassword;
import com.crm.qa.pages.LoginPage;

public class ForgotPasswordPageTest extends TestBase{
	
	LoginPage loginPage;
	ForgotPassword forgotPass;
	
	public ForgotPasswordPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void clickonForgotPass() {
		forgotPass = loginPage.forgotPassword();
	}
	
	@Test(priority = 2)
	public void validateHeading() {
		clickonForgotPass();
		String heading = forgotPass.getHeading();
		System.out.println(heading);
		Assert.assertEquals(heading, "Reset Password");
	}
	
	@Test(priority = 3)
	public void resetPasswordTest() {
		clickonForgotPass();
		String restLinkText = forgotPass.resetPass();
		System.out.println(restLinkText);
		
		Assert.assertEquals(restLinkText, "Reset Password link sent successfully");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
