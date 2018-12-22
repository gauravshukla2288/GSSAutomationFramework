package mygss.framework.WebAutomation.controller;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import mygss.framework.WebAutomation.driver.ContextManager;

public class TestPlan {
	//private static Logger  = Logging.getLogger(TestPlan.class);
	
	private Date start;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeTestSuite(ITestContext testContext){
		start = new Date();
		System.setProperty("AUTOMATION_FRAMEWORK", "MYGSS");
		ContextManager.initGlobalContext(testContext);
		ContextManager.initThreadConytext(testContext);
	}
}