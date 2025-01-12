package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class PIMPage extends TestBase{
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement addEmp;
	
	@FindBy(xpath="//input[@name=\"firstName\"]")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name=\"lastName\"]")
	WebElement lastName;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement saveBtn;
	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddEmp() {
		addEmp.click();
	}
	
	public void createRecord(String fn , String ln) {
		
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		
		saveBtn.click();
		
	}

}
