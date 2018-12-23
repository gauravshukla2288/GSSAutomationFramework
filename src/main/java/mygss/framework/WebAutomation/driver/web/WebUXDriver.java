package mygss.framework.WebAutomation.driver.web;

import org.openqa.selenium.WebDriver;

import mygss.framework.WebAutomation.controller.ContextManager;

public class WebUXDriver {
	
	private static ThreadLocal<WebDriver> driverSession = new ThreadLocal<WebDriver>();
	private static ThreadLocal<WebUXDriver> uxDriverSession = new ThreadLocal<WebUXDriver>();
	private static ThreadLocal<String> windowhandle = new ThreadLocal<String>();
	
	private WebDriverConfig config = new WebDriverConfig();
	private WebDriver driver;
	
	
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

	public WebDriver createWebDriver() {
		
	}
	
	public WebUXDriver() {
		init();
		uxDriverSession.set(this);
	}
	
	private void init() {
		if(ContextManager.getLocalContext()==null) {
			return;
		}
		config.setBrowserType(BrowserType.getBrowserType(ContextManager.getGlobalContext().getWebRunBrowser()));
		
		config.setFirefoxDriverPath(ContextManager.getGlobalContext().getFirefoxDriverPath());
		
		config.setChromeDriverPath(ContextManager.getGlobalContext().getChromeDriverPath());
		
		config.setIeDriverPath(ContextManager.getGlobalContext().getIeDriverPath());
		
		config.setOperaDriverPath(ContextManager.getGlobalContext().getOperaDriverPath());
		
		config.setSafariDriverPath(ContextManager.getGlobalContext().getSafariDriverPath());
		
		config.setWebSessionTimeout(ContextManager.getGlobalContext().getWebSessionTimeout());

		config.setImplicitWaitTimeout(ContextManager.getGlobalContext().getImplicitWaitTimeout());
		
		config.setExplicitWaitTimeout(ContextManager.getGlobalContext().getExplicitWaitTimeout());
		
		config.setPageLoadTimeout(ContextManager.getGlobalContext().getPageLoadTimeout());
		
		config.setOutputDirectory(ContextManager.getGlobalContext().getOutputDirectory());
		
		if(ContextManager.getGlobalContext().isWebProxyEnabled()==true) {
			config.setProxyHost(ContextManager.getGlobalContext().getWebProxyAddress());
		}
		
		config.setSetAcceptUntrustedCertificates(ContextManager.getGlobalContext().);
		
	}
}
