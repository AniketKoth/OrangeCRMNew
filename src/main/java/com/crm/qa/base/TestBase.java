package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	@SuppressWarnings("rawtypes")
	public static EventFiringDecorator e_driver;
	public static WebEventListener weblistener;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/aniketkothawade/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			
			prop.load(fis);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() throws InterruptedException {
		
//		WebDriver webdriver = new ChromeDriver();
//		WebDriverListener listener =  new WebEventListener();
//		driver = new EventFiringDecorator<WebDriver>(listener).decorate(webdriver);	
//		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			driver = new FirefoxDriver();
		}
		

//		e_driver = new EventFiringDecorator();
//		weblistener = new WebEventListener();
//		
//		e_driver.register(weblistener);
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
				
		driver.get(prop.getProperty("url"));
	}
	

}
