package com.delo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.delo.genericLib.BaseTest;



public class CustomerViewPage {
	@FindBy(xpath="//input[@value=\"New Lead\"]") private WebElement newLeadsBtn;
	public CustomerViewPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	public void clickNewLeadBtn()
	{
		newLeadsBtn.click();
		
		
		
		
	}
	
	

}
