package mygss.framework.WebAutomation.controller;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import mygss.framework.WebAutomation.driver.web.WebUXDriver;

public class TestPlan {
	private static Logger logger  = Logging.getLogger(TestPlan.class);
	
	private Date start;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeTestSuite(ITestContext testContext){
		start = new Date();
		System.setProperty("AUTOMATION_FRAMEWORK", "MYGSS");
		ContextManager.initContext(testContext);
		
	}
	
	@BeforeMethod(alwaysRun =true)
	public void beforeTestMethod(ITestContext testContext, Method method){
		logger.info(Thread.currentThread() + " Start Method " + method.getName());
		ContextManager.initContext(testContext);
	}

	@AfterSuite
	public void afterTestSuite() {
		logger.info("Test Suite Execution Time "+ (new Date().getTime() - start.getTime())/1000/60 +"minutes"); 
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void afterTestMethod(Method method){
		WebUXDriver.cleanUp();
		logger.info(Thread.currentThread() + " Finish method "+ method.getName());
	}
	
}