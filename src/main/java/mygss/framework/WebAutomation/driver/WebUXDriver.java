package mygss.framework.WebAutomation.driver;

import org.openqa.selenium.WebDriver;

public class WebUXDriver {
	
	private static ThreadLocal<WebDriver> driverSession = new ThreadLocal<WebDriver>();
	private static ThreadLocal<WebUXDriver> uxDriverSession = new ThreadLocal<WebUXDriver>();
	private static ThreadLocal<String> windowhandle = new ThreadLocal<String>();
	
	
	
	public static void cleanUp() {
		WebDriver driver = driverSession.get();
		
		if(driver!=null) {
			driver.quit();
			driver = null;
		}
		driverSession.remove();
		uxDriverSession.remove();
		
	}
	
	public static WebUXDriver getWebUXDriver() {
		if(uxDriverSession.get()==null)
			uxDriverSession.set(new WebUXDriver());
		 return uxDriverSession.get();
	}
	
	public static WebDriver getWebDriver() {
		if(driverSession.get()==null)
			getWebUXDriver().createWebDriver();
		 return driverSession.get();
	}

	public static 
	
}
