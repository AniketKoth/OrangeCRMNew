package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AdminPage extends TestBase{
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[3]")
	WebElement checkBoxWithoutText;
	
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickCheckbox(String name) {
		
		WebElement checkBox = driver.findElement(By.xpath("//div[text()='"+name+"']//parent::div//preceding-sibling::div//child::div//child::div//child::label//child::span//child::i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"));
		
		checkBox.click();
	}
	
	public void clickCheckBoxWithoutText() {
		checkBoxWithoutText.click();
	}

}
