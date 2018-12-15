package mygss.framework.WebAutomation.driver;

import java.awt.ItemSelectable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;

public class Context {

	public static final String TEST_CONFIG = "testconfig";
	public static final String POOL = "pool";
	public static final String SITE = "site";
	public static final String IS_MOBILE_SITE = "isMobileSite";
	
	public static final String WEB_SESSION_TIMEOUT = "webSessionTimeout";
	public static final String IMPLICIT_WAIT_TIMEOUT = "implicitWaitTimeout";
	public static final String EXPLICIT_WAIT_TIMEOUT = "explicitWaitTimeout";
	public static final String PAGE_LOAD_TIMEOUT = "pageLoadTimeout";
	public static final String WEB_RUN_BROWSER = "browser";
	public static final String FIREFOX_DRIVER_PATH = "firefoxDriverPath";
	public static final String CHROME_DRIVER_PATH = "chromeDriverPath";
	public static final String IE_DRIVER_PATH = "ieDriverPath";
	public static final String SAFARI_DRIVER_PATH = "safariDriverPath";
	public static final String OPERA_DRIVER_PATH = "operaDriverPath";
	public static final String SET_ACCEPT_UNTRUSTED_CERTIFICATE = "setAcceptUntrustedCertificate";
	
	public static final String BROWSER_DOWNLOAD_DIRECTORY ="browserDownloadDirectory";
	
	public static final String OUTPUT_DIRECTORY = "outputDirectory";
	
	public static final String ENABLE_COOKIE = "enableCookie";
	public static final String ENABLE_JAVASCRIPT = "enableJavascript";
	
	public static final String CAPTURE_SCREENSHOT = "captureScreenshot";
	
	public static final String WEB_PROXY_ADDRESS = "webProxyAddress";
	
	public static final String WEBDRIVER_LISTENER = "webDriverListener";
	public static final String TEST_DATA_FILE = "testDataFile";
	
	private Map<String, Object> contextMap = Collections.synchronizedMap(new HashMap<String, Object>());
	
	List<ScreenShot> screenshots = new 
	
	public Context(ITestContext context) {
		
		
	}
	
}
