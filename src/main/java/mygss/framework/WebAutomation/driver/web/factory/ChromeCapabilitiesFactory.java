package mygss.framework.WebAutomation.driver.web.factory;

import java.util.HashMap;
import java.util.Map;

import javax.management.DescriptorRead;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import mygss.framework.WebAutomation.driver.web.WebDriverConfig;

public class ChromeCapabilitiesFactory implements ICapabilitiesFactory{

	public DesiredCapabilities createcapabilities(WebDriverConfig config) {
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		ChromeOptions chromeOptions =  new ChromeOptions();
		
		if(!config.isEnableJavascript()) {
			Map<String, Integer> prefs = new HashMap<String, Integer>();
			prefs.put("profile.default_content_settings.cookies", 2);
			chromeOptions.setExperimentalOption("prefs", prefs);
		}
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		//JavaScript
		if(config.isEnableJavascript()) {
			capabilities.setJavascriptEnabled(true);
		}
		else {
			capabilities.setJavascriptEnabled(false);
		}
		
		capabilities.setCapability(, value);
		if(config.get)
			
		
		return null;
	
	}
	
	
}
