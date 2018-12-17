package mygss.framework.WebAutomation.driver;

import java.io.File;
import java.util.Map;

import org.testng.ITestContext;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import mygss.framework.WebAutomation.util.XMLHelper;

public class ContextManager {
	
	private static Context globalContext;
	
	private static ThreadLocal<Context> localContext = new ThreadLocal<Context>();
	
	public static Context getLocalContext() {
		return localContext.get();
	}

	public static Context getGlobalContext() {
		return globalContext;
	}

	public static void initThreadConytext(ITestContext testNGContext) {
		Context ctx = new Context(testNGContext);
		localContext.set(ctx);
	}
	
	public static void initGlobalContext(ITestContext iTestCtx) {
		iTestCtx = getContextFromConfigFile(iTestCtx);
		globalContext = new Context(iTestCtx);
	}

	private static ITestContext getContextFromConfigFile(ITestContext iTestCtx) {
		if(iTestCtx != null) {
			if(iTestCtx.getSuite().getParameter(Context.TEST_CONFIG) != null) {
				File suiteFile = new File(iTestCtx.getSuite().getXmlSuite().getFileName());
				String configFile = suiteFile.getPath().replace(suiteFile.getName(), "") + iTestCtx.getSuite().getParameter("testConfig");
				NodeList nList=XMLHelper.getXMLNodes(configFile, "parameter");
				Map<String, String> parameters = iTestCtx.getSuite().getXmlSuite().getParameters();
			
				for(int i = 0 ;i< nList.getLength() ; i++) {
					Node nNode = nList.item(i);
					parameters.put(nNode.getAttributes().getNamedItem("name").getNodeValue(), nNode.getAttributes().getNamedItem("value").getNodeValue());
				}
			}
		}
		return iTestCtx;
	}
	
}
