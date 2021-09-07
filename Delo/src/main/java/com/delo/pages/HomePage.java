package com.delo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.delo.genericLib.BaseTest;



public class HomePage {
	@FindBy(xpath="//a[text()='Leads']") private WebElement leadsTab;
	@FindBy(xpath="//a[text()='Contacts']") private WebElement contactsTab;
	@FindBy(xpath="//a[text()='Potentials']") private WebElement potentialsTab;
	@FindBy(xpath="//a[text()='Accounts']") private WebElement accountsTab;
	
	
	
public HomePage()
{
	PageFactory.initElements(BaseTest.driver, this);
}
public void clickLeadsTab()
{
	leadsTab.click();
	
}
public void clickcontactsTab()
{
	contactsTab.click();
}
public void clickpotentialsTab()
{
	potentialsTab.click();
}
public void clickaccountsTab()
{
	accountsTab.click();
}
}
