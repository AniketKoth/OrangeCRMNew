package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Dashboard extends TestBase{
	
	@FindBy(xpath="//p[@class=\"oxd-userdropdown-name\"]")
	WebElement nameLablel;
	
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	WebElement dashboardLink;
	
	@FindBy(xpath="//p[contains(text(),'Actions')]//parent::div//..//following-sibling::div//child::div//child::div//p[contains(text(),'(1) Pending Self Review')]")
	WebElement selfReview;
	
	@FindBy(xpath="//span[text()=\"Admin\"]")
	WebElement adminLink;
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement pimLink;
	
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean userNameLabel() {
		return nameLablel.isDisplayed();
	}
	
	public boolean dashboardLink() {
		return dashboardLink.isEnabled();
	}
	
	public PerformanceReview selfReviewLink() {
		selfReview.click();
		
		return new PerformanceReview();
	}
	
	public AdminPage clickAdminLink() {
		adminLink.click();
		
		return new AdminPage();
	}
	
	public PIMPage clickPIMLink() {
		pimLink.click();
		
		return new PIMPage();
	}

}
