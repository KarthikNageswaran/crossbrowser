package com.test.crossbrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossBrowserTest {
	
	String chromedriver_path="C:\\Users\\knageswaran\\Downloads\\chromedriver_win32\\chromedriver.exe";
	String ieDriver_path="C:\\Users\\knageswaran\\Downloads\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe";
	WebDriver driver=null;
	@Test
	@Parameters("browser")
	public void browserTest(String browser) throws Exception{
		
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", chromedriver_path);
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver", ieDriver_path);
			driver=new InternetExplorerDriver();
			
		}else{
			System.out.println("Incorrect browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());	
		Thread.sleep(2000);
		driver.close();
		
		
	}
	
}
