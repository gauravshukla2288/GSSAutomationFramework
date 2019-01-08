package mygss.framework.WebAutomation.driver.web.factory;

import org.openqa.selenium.WebDriver;

import mygss.framework.WebAutomation.driver.web.WebDriverConfig;

public interface IWebDriverFactory {

	public void cleanUp();

	public WebDriver createWebDriver();

	public WebDriver getWebDriver();

	public WebDriverConfig getWebDriverConfig();

}