package com.delo.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest implements IAutoConsts
{
	public static WebDriver driver;
	
	
	
	
	public void openBrowser() throws Throwable
	
	{
		FileLib flib = new FileLib();
		 String browsername = flib.readPropertyData(PROP_PATH, "browser");
		 
		 if(browsername.equals("chrome"))
		 {
			 System.setProperty(CHROME_KEY, CHROME_VALUE);
		 driver = new ChromeDriver();
		 }
		 else if(browsername.equalsIgnoreCase("firefox"))
		 {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
			
			 
		 }
		 else
		 {
			System.out.println("enter proper browser name ");

		 }
		 driver.manage().window().maximize();
		String testurl = flib.readPropertyData(PROP_PATH, "url");
		driver.get(testurl);
		WebDriverCommonLIb wlib = new WebDriverCommonLIb();
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "loginTitle"), "Login page");
		 
		 
	
	}
	public void closeBrowser()
	{
		driver.quit();
	}

}
