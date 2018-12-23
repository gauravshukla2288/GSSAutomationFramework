package mygss.framework.WebAutomation.driver.web;

import java.util.Date;

import javax.management.RuntimeErrorException;

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
		
		System.out.println(Thread.currentThread() + " : " +new Date() + "Starting creating webdriver instance : " + this.getBrowser());
		
		
		return driver;
	}
	
	
	public WebDriver createRemoteWebDriver(String browser) {
		
		WebDriver driver = null;
		config.setBrowserType(BrowserType.getBrowserType(browser));
		
		if(config.getBrowserType() == BrowserType.Chrome) {
			
		}
		else if(config.getBrowserType() == BrowserType.Firefox) {
			
		}
		else if((config.getBrowserType() == BrowserType.Opera)) {
			
		}
		else if(config.getBrowserType() == BrowserType.Safari) {
			
		}
		else if(config.getBrowserType() == BrowserType.InternetExplorer) {
			
		}
		else if(config.getBrowserType() == BrowserType.HtmlUnit){
			
		}
		else {
			throw new RuntimeException("Browser Not Supported");
		}
			
		
		
		return driver;
	}
	
	public WebUXDriver() {
		init();
		uxDriverSession.set(this);
	}
	
	public String getBrowser() {
		return config.getBrowserType().getType();
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
		
		config.setSetAcceptUntrustedCertificates(ContextManager.getGlobalContext().isSetAcceptUntrustedCertificate());
		
		config.setEnableJavascript(ContextManager.getGlobalContext().isEnableJavascript());
		
		config.setBrowserDownloadDirectory(ContextManager.getGlobalContext().getBrowserDownloadDirectory());
		
		String size = ContextManager.getGlobalContext().getBrowserWindowSize();
		
		if(size != null) {
			int width = Integer.parseInt(size.split(",")[0]);
			int height = Integer.parseInt(size.split(",")[1]);
			
			config.setBrowserWindowWidth(width);
			config.setBrowserWindowHeight(height);
			
		}
		
	}
}
