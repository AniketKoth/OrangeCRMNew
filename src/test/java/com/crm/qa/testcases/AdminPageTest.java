package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.Dashboard;
import com.crm.qa.pages.LoginPage;

public class AdminPageTest extends TestBase{
	
	AdminPage adminPage;
	LoginPage loginPage;
	Dashboard dashboard;
	
	public AdminPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		adminPage = new AdminPage();
		adminPage =  dashboard.clickAdminLink();
	}
	
	@Test
	public void clickCheckBoxTest() {
		//adminPage.clickCheckbox("Beta002");
		adminPage.clickCheckBoxWithoutText();
	}
	
	@DataProvider
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
