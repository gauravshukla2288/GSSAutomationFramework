package mygss.framework.WebAutomation.driver.web.element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import mygss.framework.WebAutomation.driver.web.BrowserType;
import mygss.framework.WebAutomation.driver.web.WebUXDriver;



public class HtmlElement {

	private static Logger logger = LogManager.getLogger(SpreadSheetUtil.class);

	private static enum LocatorType {
		ID, NAME, CLASSNAME, XPATH, CSSSELECTOR, LINKTEXT, PARTIALLINKTEXT, TAGNAME;
	}

	WebDriver driver;
	WebUXDriver webUXDriver;
	BrowserType browserType;
	WebElement webElement;
	By by;
	String Label;
	String locator;

	// Find element using text locator / xpath
	HtmlElement(String label, String locator) {
		this.Label = label;
		if (!locator.startsWith("/"))
			locator = "//*[@id='" + locator + "' or @name='" + locator + "']";
		this.locator = locator;
		this.by = By.xpath(locator);
	}

	// Find element using By
	HtmlElement(String label, By by) {
		this.Label = label;
		this.by = by;
	}

	// Find element using Locator Type
	HtmlElement(String label, LocatorType locatorType, String locator) {
		this.Label = label;
		this.locator = locator;
		switch (locatorType) {
		case ID:
			by = By.id(locator);
		case CLASSNAME:
			by = By.className(locator);
		case NAME:
			by = By.name(locator);
		case TAGNAME:
			by = By.tagName(locator);
		case CSSSELECTOR:
			by = By.cssSelector(locator);
		case LINKTEXT:
			by = By.linkText(locator);
		case PARTIALLINKTEXT:
			by = By.partialLinkText(locator);
		default:
			by = By.id(locator);
		}
	}

	// Find element by passing webelement

	HtmlElement(WebElement element) {
		this.webElement = element;
		this.by = null;
	}

	public void findElement() {
		driver = WebUXDriver.getWebDriver();
		try {
			if (by != null) {
				try {
					webElement = driver.findElement(by);
				} catch (NoSuchElementException e1) {
					throw new NoSuchElementException(
							"Element {" + by.toString() + "} was not found. " + e1.getMessage(), e1);
				}
			}
		} catch (UnhandledAlertException e2) {
			try {
				// Ignore the UnhandleAlertException for IEDriver
				Thread.sleep(1000);
			}catch (org.openqa.selenium.TimeoutException ex) {
				logger.info("Get timeout exception, ignore"); 
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void click(){
		findElement();
		try {
			webElement.click();
		} catch (ElementNotVisibleException enve ) {
			// TODO Auto-generated catch block
			throw new ElementNotVisibleException("Element {" + by.toString()
			+ "} was not visible. " + enve.getMessage(), enve);
		}
		
	}
	
	public void clickAt(String coordinate){
		if(coordinate.startsWith("(")){
			coordinate = coordinate.substring(1);
			coordinate = coordinate.substring(0, coordinate.length());
		}
		String[] values = coordinate.split(",");
		int xPos = Integer.parseInt(values[0]);
		int yPos = Integer.parseInt(values[1]);
		try{
			new Actions(driver).moveToElement(webElement, xPos, yPos).click().build().perform();
		}catch(Exception e){
			
		}
	}
	
	
}
