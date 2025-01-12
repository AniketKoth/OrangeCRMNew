package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Dashboard;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PIMPage;
import com.crm.qa.util.TestUtil;

public class PIMPageTest extends TestBase{
	
	LoginPage loginPage;
	Dashboard dashboard;
	PIMPage pimPage;
	TestUtil testUtil;
	
	String sheetName = "employee";
	

	public PIMPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		dashboard =  loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		pimPage =  dashboard.clickPIMLink();
		pimPage.clickAddEmp();
		
	}
	
	@DataProvider
	public Object[][] getDataTest(){
		Object data[][] = TestUtil.getTestData(sheetName);
		
		return data;
	}
	
	@Test(priority = 1 , dataProvider = "getDataTest")
	public void createRecordTest(String fName , String lName) {
		pimPage.createRecord(fName, lName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
