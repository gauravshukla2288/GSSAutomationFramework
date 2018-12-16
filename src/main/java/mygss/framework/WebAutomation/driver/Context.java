package mygss.framework.WebAutomation.driver;

import java.awt.ItemSelectable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.ITestContext;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

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
	public static final String BROWSER_WINDOW_SIZE = "browserWindowSize";

	public static final String FIREFOX_DRIVER_PATH = "firefoxDriverPath";
	public static final String CHROME_DRIVER_PATH = "chromeDriverPath";
	public static final String IE_DRIVER_PATH = "ieDriverPath";
	public static final String SAFARI_DRIVER_PATH = "safariDriverPath";
	public static final String OPERA_DRIVER_PATH = "operaDriverPath";
	public static final String SET_ACCEPT_UNTRUSTED_CERTIFICATE = "setAcceptUntrustedCertificate";

	public static final String BROWSER_DOWNLOAD_DIRECTORY = "browserDownloadDirectory";

	public static final String OUTPUT_DIRECTORY = "outputDirectory";

	public static final String ENABLE_COOKIE = "enableCookie";
	public static final String ENABLE_JAVASCRIPT = "enableJavascript";

	public static final String CAPTURE_SCREENSHOT = "captureScreenshot";

	public static final String WEB_PROXY_ENABLED = "webProxyEnables";
	public static final String WEB_PROXY_ADDRESS = "webProxyAddress";
	public static final String TEST_OBJECT = "testObject";

	public static final String WEBDRIVER_LISTENER = "webDriverListener";
	public static final String TEST_DATA_FILE = "testDataFile";

	public static final String PLUGIN_CONFIG_PATH = "pluginConfigPath";

	private Map<String, Object> contextMap = Collections.synchronizedMap(new HashMap<String, Object>());

	private LinkedList<ScreenShot> screenshots = new LinkedList<ScreenShot>();

	public List<ScreenShot> getScreenshots() {
		return screenshots;
	}

	public void setScreenshots(ScreenShot screenshot) {
		screenshots.addLast(screenshot);
	}

	private ITestContext testNGContext = null;

	public Context(ITestContext context) {
		this.testNGContext = context;

		setContextAttribute(context, POOL, System.getProperty(POOL), "staging");
		setContextAttribute(context, SITE, System.getProperty(SITE), "US");
		setContextAttribute(context, IS_MOBILE_SITE, System.getProperty(IS_MOBILE_SITE), "false");
		setContextAttribute(context, WEB_SESSION_TIMEOUT, System.getProperty(WEB_SESSION_TIMEOUT), "90000");
		setContextAttribute(context, IMPLICIT_WAIT_TIMEOUT, System.getProperty(IMPLICIT_WAIT_TIMEOUT), "5");
		setContextAttribute(context, EXPLICIT_WAIT_TIMEOUT, System.getProperty(EXPLICIT_WAIT_TIMEOUT), "15");
		setContextAttribute(context, PAGE_LOAD_TIMEOUT, System.getProperty(PAGE_LOAD_TIMEOUT), "90");
		setContextAttribute(context, WEB_RUN_BROWSER, System.getProperty(WEB_RUN_BROWSER), "*chrome");
		setContextAttribute(context, BROWSER_WINDOW_SIZE, System.getProperty(BROWSER_WINDOW_SIZE), "*chrome");
		setContextAttribute(context, FIREFOX_DRIVER_PATH, System.getProperty(FIREFOX_DRIVER_PATH), null);
		setContextAttribute(context, CHROME_DRIVER_PATH, System.getProperty(CHROME_DRIVER_PATH), null);
		setContextAttribute(context, IE_DRIVER_PATH, System.getProperty(IE_DRIVER_PATH), null);
		setContextAttribute(context, SAFARI_DRIVER_PATH, System.getProperty(SAFARI_DRIVER_PATH), null);
		setContextAttribute(context, OPERA_DRIVER_PATH, System.getProperty(OPERA_DRIVER_PATH), null);
		setContextAttribute(context, SET_ACCEPT_UNTRUSTED_CERTIFICATE,
				System.getProperty(SET_ACCEPT_UNTRUSTED_CERTIFICATE), null);
		setContextAttribute(context, BROWSER_DOWNLOAD_DIRECTORY, System.getProperty(BROWSER_DOWNLOAD_DIRECTORY), null);

		setContextAttribute(context, ENABLE_COOKIE, System.getProperty(ENABLE_COOKIE), null);
		setContextAttribute(context, ENABLE_JAVASCRIPT, System.getProperty(ENABLE_JAVASCRIPT), null);
		setContextAttribute(context, CAPTURE_SCREENSHOT, System.getProperty(CAPTURE_SCREENSHOT), "true");
		setContextAttribute(context, WEB_PROXY_ADDRESS, System.getProperty(WEB_PROXY_ADDRESS), null);
		setContextAttribute(context, WEBDRIVER_LISTENER, System.getProperty(WEBDRIVER_LISTENER), null);
		setContextAttribute(context, TEST_DATA_FILE, System.getProperty(TEST_DATA_FILE), "testCase");

		if (context != null) {
			setContextAttribute(OUTPUT_DIRECTORY, null, context.getOutputDirectory(), null);

			setContextAttribute(context);

			new File(context.getOutputDirectory() + "/screenshots").mkdirs();
			new File(context.getOutputDirectory() + "/htmls").mkdirs();
			new File(context.getOutputDirectory() + "/xmls").mkdirs();
			new File(context.getOutputDirectory() + "/textfiles").mkdirs();

			// If Plugin is required
//			String path = (String) contextMap.get(PLUGIN_CONFIG_PATH);
//			
//			if(path !=null && path.trim().length() > 0) {
//				File configFile = new File(path);
//				if(configFile.exists())
//					PluginsUtil.getInstance().loadPlugin(configFile);
//			}
		}

	}

	private void setContextAttribute(ITestContext context, String attributeName, String sysPropertyValue,
			String defaultValue) {

		String suiteValue = null;
		if (context != null) {
			suiteValue = context.getSuite().getParameter(attributeName);
		}
		contextMap.put(attributeName,
				sysPropertyValue != null ? sysPropertyValue : (suiteValue != null ? suiteValue : defaultValue));

	}

	private void setContextAttribute(String attributeName, String sysPropertyValue, String suiteValue,
			String defaultValue) {

		contextMap.put(attributeName,
				sysPropertyValue != null ? sysPropertyValue : (suiteValue != null ? suiteValue : defaultValue));
	}

	private void setContextAttribute(ITestContext context) {

		if (context != null) {
			Map<String, String> testParameters = context.getSuite().getXmlSuite().getParameters();

			for (Entry<String, String> entry : testParameters.entrySet()) {
				String attributeName = entry.getKey();

				if (contextMap.get(entry.getKey()) == null) {
					String sysPropertyValue = System.getProperty(entry.getKey());
					String suiteValue = entry.getValue();
					setContextAttribute(attributeName, sysPropertyValue, suiteValue, null);
				}
			}
		}
	}

	public String getBrowserWindowSize() {
		return (String) contextMap.get(BROWSER_WINDOW_SIZE);
	}

	public ITestContext getTestNGContext() {
		return testNGContext;
	}

	public void setTestNGContext(ITestContext testNGContext) {
		this.testNGContext = testNGContext;
	}

	public Object getTestObject() {
		return contextMap.get(TEST_OBJECT);
	}
	
	
	public String getPool() {
		return (String) contextMap.get(POOL);
	}

	public  String getSite() {
		return (String) contextMap.get(SITE);
	}
	
	
	public boolean isWebProxyEnabled() {
		try{
			return Boolean.parseBoolean((String) contextMap.get(WEB_PROXY_ENABLED));
		} catch(Exception e) {
			return false;
		}
	}
	

	public boolean isMobileSite() {
		try{
			return Boolean.parseBoolean((String) contextMap.get(IS_MOBILE_SITE));
		} catch(Exception e) {
			return false;
		}
	}

	public int getWebSessionTimeout() {
		try{
			return Integer.parseInt((String) contextMap.get(WEB_SESSION_TIMEOUT));
		}catch(Exception e) {
			return 90000;
		}
	}

	public double getImplicitWaitTimeout() {
		try {
			return Double.parseDouble((String) contextMap.get(IMPLICIT_WAIT_TIMEOUT));
		} catch (Exception e) {
			return 5;
		}

	}

	public int getExplicitWaitTimeout() {
		Integer timeout;
		try {
			timeout = Integer.parseInt((String) contextMap.get(EXPLICIT_WAIT_TIMEOUT));

		} catch (Exception e) {
			timeout = 15;
		}
		if (timeout < getImplicitWaitTimeout())
			return (int) getImplicitWaitTimeout();
		else
			return timeout;
	}

	public  int getPageLoadTimeout() {
		try {
			return Integer.parseInt((String) contextMap.get(PAGE_LOAD_TIMEOUT));
		}catch(Exception e) {
			return 90;
		}
	}

	public  String getWebRunBrowser() {
		return (String) contextMap.get(WEB_RUN_BROWSER);
	}

	public String getFirefoxDriverPath() {
		return (String) contextMap.get(FIREFOX_DRIVER_PATH);
	}

	public String getChromeDriverPath() {
		return (String) contextMap.get(CHROME_DRIVER_PATH);
	}

	public  String getIeDriverPath() {
		return (String) contextMap.get(IE_DRIVER_PATH);
	}

	public String getSafariDriverPath() {
		return (String) contextMap.get(SAFARI_DRIVER_PATH);
	}

	public  String getOperaDriverPath() {
		return (String) contextMap.get(OPERA_DRIVER_PATH);
	}

	

	public String getBrowserDownloadDirectory() {
		if (contextMap.get(BROWSER_DOWNLOAD_DIRECTORY) != null)
			return (String) contextMap.get(BROWSER_DOWNLOAD_DIRECTORY);
		else
			return this.getOutputDirectory() + "\\downloads\\";
	}

	public String getOutputDirectory() {
		return (String) contextMap.get(OUTPUT_DIRECTORY);
	}

	

	public boolean isCaptureScreenshot() {
		try{
			return Boolean.parseBoolean((String) contextMap.get(CAPTURE_SCREENSHOT));
		} catch(Exception e) {
			return true;
		}
	}

	public String getWebProxyAddress() {
		return (String) contextMap.get(WEB_PROXY_ADDRESS);
	}

	public  String getWebdriverListener() {
		return (String) contextMap.get(WEBDRIVER_LISTENER);
	}

	public  String getTestDataFile() {
		return (String) contextMap.get(TEST_DATA_FILE);
	}

	
	// Setter methods

	public void setExplicitWaitTimeout(double timeout) {
		contextMap.put(EXPLICIT_WAIT_TIMEOUT, timeout);
	}
	
	public void setImplicitWaitTimeout(double timeout) {
		contextMap.put(IMPLICIT_WAIT_TIMEOUT, timeout);
	}
	
	public void setPageLoadTimeout(int timeout) {
		contextMap.put(PAGE_LOAD_TIMEOUT, timeout);
	}
	
	public void setPool(String pool) {
		contextMap.put(POOL, pool);
	}

	public void setSite(String site) {
		contextMap.put(SITE, site);
	}
	
	public void setTEstDataFile(String file) {
		contextMap.put(TEST_DATA_FILE, file);
	}
	
}
