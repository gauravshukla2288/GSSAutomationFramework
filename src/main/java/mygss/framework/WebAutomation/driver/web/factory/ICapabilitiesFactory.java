package mygss.framework.WebAutomation.driver.web.factory;

import org.openqa.selenium.remote.DesiredCapabilities;

import mygss.framework.WebAutomation.driver.web.WebDriverConfig;

public interface ICapabilitiesFactory {
	
	public DesiredCapabilities createcapabilities(WebDriverConfig config);
	
}
