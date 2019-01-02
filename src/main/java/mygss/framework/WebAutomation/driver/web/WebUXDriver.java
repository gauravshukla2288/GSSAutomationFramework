package mygss.framework.WebAutomation.driver.web;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;

import mygss.framework.WebAutomation.controller.ContextManager;

public class WebUXDriver {
	
	private static ThreadLocal<WebDriver> driverSession = new ThreadLocal<WebDriver>();
	private static ThreadLocal<WebUXDriver> uxDriverSession = new ThreadLocal<WebUXDriver>();
	private static ThreadLocal<String> windowHandle = new ThreadLocal<String>();
	
	

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
		if(ContextManager.getContext()==null) {
			return;
		}
		config.setBrowserType(BrowserType.getBrowserType(ContextManager.getContext().getWebRunBrowser()));
		
		config.setFirefoxDriverPath(ContextManager.getContext().getFirefoxDriverPath());
		
		config.setChromeDriverPath(ContextManager.getContext().getChromeDriverPath());
		
		config.setIeDriverPath(ContextManager.getContext().getIeDriverPath());
		
		config.setOperaDriverPath(ContextManager.getContext().getOperaDriverPath());
		
		config.setSafariDriverPath(ContextManager.getContext().getSafariDriverPath());
		
		config.setWebSessionTimeout(ContextManager.getContext().getWebSessionTimeout());

		config.setImplicitWaitTimeout(ContextManager.getContext().getImplicitWaitTimeout());
		
		config.setExplicitWaitTimeout(ContextManager.getContext().getExplicitWaitTimeout());
		
		config.setPageLoadTimeout(ContextManager.getContext().getPageLoadTimeout());
		
		config.setOutputDirectory(ContextManager.getContext().getOutputDirectory());
		
		if(ContextManager.getContext().isWebProxyEnabled()==true) {
			config.setProxyHost(ContextManager.getContext().getWebProxyAddress());
		}
		
		config.setSetAcceptUntrustedCertificates(ContextManager.getContext().isSetAcceptUntrustedCertificate());
		
		config.setEnableJavascript(ContextManager.getContext().isEnableJavascript());
		
		config.setBrowserDownloadDirectory(ContextManager.getContext().getBrowserDownloadDirectory());
		
		String size = ContextManager.getContext().getBrowserWindowSize();
		
		if(size != null) {
			int width = Integer.parseInt(size.split(",")[0]);
			int height = Integer.parseInt(size.split(",")[1]);
			
			config.setBrowserWindowWidth(width);
			config.setBrowserWindowHeight(height);
			
		}
		
	}
	
	// Getter 
	
	public BrowserType getBrowserType() {
		return config.getBrowserType();
	}
	
	public String getFirefoxDriverPath() {
		return config.getFirefoxDriverPath();
	}
	
	public int getWebSessionTimeout() {
		return config.getWebSessionTimeout();
	}
	
	public double getImplicitWaitTimeout() {
		return config.getImplicitWaitTimeout();
	}
	
	public int getExplicitWaitTimeout() {
		return config.getExplicitWaitTimeout();
	}
	
	public int getPageLoadTimeout() {
		return config.getPageLoadTimeout();
	}

	public static String getWindowhandle() {
		return windowHandle.get();
	}

	public WebDriverConfig getConfig() {
		return config;
	}
	
	public String getOutputDirectory() {
		return config.getOutputDirectory();
	}
	
	public boolean isSetAcceptUntrustedCertificate() {
		return config.isSetAcceptUntrustedCertificates();
	}
	
	public boolean isEnableJavascript() {
		return config.isEnableJavascript();
	}
	
	public String getBrowserDownloadDirectory() {
		return config.getBrowserDownloadDirectory();
	}
	
	public int getBrowserWindowHeight() {
		return config.getBrowserWindowHeight();
	}
	
	public int getBrowserWindowWidth() {
		return config.getBrowserWindowWidth();
	}
	
	//// Setter
	public static void setWindowhandle(String windowhandle) {
		windowHandle.set(windowhandle);
	}
	
	public void setConfig(WebDriverConfig config) {
		this.config = config;
	}
	
	
	public void setBrowserType(BrowserType browserType) {
		config.setBrowserType(browserType);
	}
	
	public void setFirefoxDriverPath(String path) {
		config.setFirefoxDriverPath(path);
	}
	
	public void setWebSessionTimeout(int timeout) {
		config.setWebSessionTimeout(timeout);
	}
	
	public void setImplicitWaitTimeout(double timeout) {
		config.setImplicitWaitTimeout(timeout);
	}
	
	public void setExplicitWaitTimeout(int timeout) {
		config.setExplicitWaitTimeout(timeout);
	}
	
	public void setPageLoadTimeout(int timeout) {
		config.setPageLoadTimeout(timeout);
	}
	
	public void setOutputDirectory(String path) {
		config.setOutputDirectory(path);
	}
	
	public void setSetAcceptUntrustedCertificate(boolean val) {
		config.setSetAcceptUntrustedCertificates(val);
	}
	
	public void setEnableJavascript(boolean val) {
		config.setEnableJavascript(val);;
	}
	
	public void setBrowserDownloadDirectory(String path) {
		config.setBrowserDownloadDirectory(path);
	}
	
	public void setBrowserWindowHeight(int height) {
		config.setBrowserWindowHeight(height);
	}
	
	public void getBrowserWindowWidth(int width) {
		config.setBrowserWindowWidth(width);
	}
	
	
	
	
}
