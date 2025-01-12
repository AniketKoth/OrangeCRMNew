package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Dashboard;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DashboardPageTest extends TestBase{
	
	LoginPage loginPage;
	Dashboard dashboard;
	TestUtil testutil;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		//testutil.switchToFrame();
		loginPage = new LoginPage();
		dashboard  = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void userNameLabelTest() {
		boolean flag = dashboard.userNameLabel();
		Assert.assertTrue(flag);
	}
	 
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
