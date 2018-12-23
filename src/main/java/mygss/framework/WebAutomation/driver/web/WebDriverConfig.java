package mygss.framework.WebAutomation.driver.web;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class WebDriverConfig {
	
	private boolean setAcceptUntrustedCertificates = true;
	private boolean enableJavascript = true;
	private boolean enableCookie = true;

	private WebDriver driver;
	private BrowserType browserType = BrowserType.Chrome;
	private String ieDriverPath;
	private String chromeDriverPath;
	private String firefoxDriverPath;
	private String safariDriverPath;
	private String operaDriverPath;
	private WebDriverEventListener webDriverListener;
	private int webSessionTimeout = 90000;
	final static public int DEAFULT_IMPLICIT_WAIT_TIMEOUT = 5;
	final static public int DEFAULT_EXPLICIT_WAIT_TIMEOUT = 15;
	final static public int DEFAULT_PAGE_LOAD_TIMEOUT = 90;
	private double implicitWaitTimeout = DEAFULT_IMPLICIT_WAIT_TIMEOUT;
	private int explicitWaitTimeout = DEFAULT_EXPLICIT_WAIT_TIMEOUT;
	private int pageLoadTimeout = DEFAULT_PAGE_LOAD_TIMEOUT;
	private String outputDirectory;
	private String browserDownloadDirectory;
	private int browserWindowWidth = -1;
	private int browserWindowHeight = -1;
	private String proxyHost;
	
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public BrowserType getBrowserType() {
		return browserType;
	}
	public void setBrowserType(BrowserType browserType) {
		this.browserType = browserType;
	}
	public String getIeDriverPath() {
		return ieDriverPath;
	}
	public void setIeDriverPath(String ieDriverPath) {
		this.ieDriverPath = ieDriverPath;
	}
	public String getChromeDriverPath() {
		return chromeDriverPath;
	}
	public void setChromeDriverPath(String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}
	
	public String getFirefoxDriverPath() {
		return firefoxDriverPath;
	}

	public void setFirefoxDriverPath(String firefoxDriverPath) {
		this.firefoxDriverPath = firefoxDriverPath;
	}
	
	public String getOperaDriverPath() {
		return operaDriverPath;
	}
	
	public void setOperaDriverPath(String operaDriverPath) {
		this.operaDriverPath = operaDriverPath;
	}
	
	public String getSafariDriverPath() {
		return safariDriverPath;
	}
	public void setSafariDriverPath(String safariDriverPath) {
		this.safariDriverPath = safariDriverPath;
	}
	
	public WebDriverEventListener getWebDriverListener() {
		return webDriverListener;
	}
	public void setWebDriverListener(WebDriverEventListener webDriverListener) {
		this.webDriverListener = webDriverListener;
	}
	
	public int getWebSessionTimeout() {
		return webSessionTimeout;
	}
	public void setWebSessionTimeout(int webSessionTimeout) {
		this.webSessionTimeout = webSessionTimeout;
	}
	
	public double getImplicitWaitTimeout() {
		return implicitWaitTimeout;
	}
	public void setImplicitWaitTimeout(double implicitWaitTimeout) {
		this.implicitWaitTimeout = implicitWaitTimeout;
	}
	
	public int getExplicitWaitTimeout() {
		if(explicitWaitTimeout < getImplicitWaitTimeout())
			return (int) getImplicitWaitTimeout();
		else
			return explicitWaitTimeout;
	}
	public void setExplicitWaitTimeout(int explicitWaitTimeout) {
		this.explicitWaitTimeout = explicitWaitTimeout;
	}
	public int getPageLoadTimeout() {
		return pageLoadTimeout;
	}
	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}
	public String getOutputDirectory() {
		return outputDirectory;
	}
	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}
	public String getBrowserDownloadDirectory() {
		return browserDownloadDirectory;
	}
	public void setBrowserDownloadDirectory(String browserDownloadDirectory) {
		this.browserDownloadDirectory = browserDownloadDirectory;
	}
	public int getBrowserWindowWidth() {
		return browserWindowWidth;
	}
	public void setBrowserWindowWidth(int browserWindowWidth) {
		this.browserWindowWidth = browserWindowWidth;
	}
	public int getBrowserWindowHeight() {
		return browserWindowHeight;
	}
	public void setBrowserWindowHeight(int browserWindowHeight) {
		this.browserWindowHeight = browserWindowHeight;
	}
	
	public String getProxyHost() {
		return proxyHost;
	}
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}
	
	public Proxy getProxy() {
		Proxy proxy = null;
		if(proxyHost != null){
			proxy = new Proxy();
			proxy.setProxyType(ProxyType.MANUAL);
			proxy.setFtpProxy(proxyHost);
			proxy.setHttpProxy(proxyHost);
			proxy.setSslProxy(proxyHost);
		}
		return proxy;
	}
	
}
