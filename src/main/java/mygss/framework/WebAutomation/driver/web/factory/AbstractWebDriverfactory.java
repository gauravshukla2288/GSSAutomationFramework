package mygss.framework.WebAutomation.driver.web.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import mygss.framework.WebAutomation.driver.web.WebDriverConfig;

public abstract class AbstractWebDriverfactory {
	
	protected WebDriverConfig config;
	protected WebDriver driver;

	public AbstractWebDriverfactory(WebDriverConfig config) {
		this.config = config;
	}

	public void cleanUp() {
		try {
			if(driver!=null) {
				System.out.println(Thread.currentThread() + " : quiting webdriver");
				driver.quit();
			}
		}
		catch(WebDriverException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void setImplicitWaitTimeout(double timeout) {
		try {
			driver.manage().timeouts().implicitlyWait((long)timeout, TimeUnit.SECONDS);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver createWebDriver() {
		return null;
	}
	
	
	// Getter and Setter
	public WebDriverConfig getConfig() {
		return config;
	}


	public void setConfig(WebDriverConfig config) {
		this.config = config;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


}
