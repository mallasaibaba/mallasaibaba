package com.delo.accounts;

import org.testng.annotations.Test;

import com.delo.genericLib.BaseTest;
import com.delo.genericLib.FileLib;
import com.delo.genericLib.WebDriverCommonLIb;
import com.delo.pages.CreateLeadPage;
import com.delo.pages.CustomerViewPage;
import com.delo.pages.HomePage;
import com.delo.pages.LoginPage;

public class CreateLeadsTest extends BaseTest {
	@Test
	public void leads() throws Throwable
	{
		BaseTest bt = new BaseTest();
		bt.openBrowser();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage();
		FileLib flib = new FileLib();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "username"),flib.readPropertyData(PROP_PATH, "password"));
		Thread.sleep(2000);
		
		WebDriverCommonLIb wlib = new WebDriverCommonLIb();
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "home_Title"), "Home Page ");
		Thread.sleep(2000);
		
		HomePage hp = new HomePage();
		hp.clickLeadsTab();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Create View Page ");
		Thread.sleep(2000);
		
		CustomerViewPage cv = new CustomerViewPage();
		
		cv.clickNewLeadBtn();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "createLeadTitle"), "Create Lead Page ");
		
		CreateLeadPage cl = new CreateLeadPage();
		cl.createLeadWithMandatoryDetails(flib.readExcelData(EXCEL_PATH, "Leads", 0, 1), flib.readExcelData(EXCEL_PATH, "Leads", 1, 1));
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "leadDetailsTitle"), "Lead Details page");
		
		
	}
	
	 

}
