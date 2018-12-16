package mygss.framework.WebAutomation.driver;

public enum BrowserType {

	Firefox("*firefox"),
	Chrome("*chrome"),
	InternetExplorer("*iexplorer"),
	Safari("*safari"),
	Opera("*opera"),
	HtmlUnit("*htmlunit"),
	Android("*android"),
	Iphone("*iphone");
	
	private String type;
	
	private BrowserType(String type) {
		this.type = type;
	}
	
	public static BrowserType getBrowserType(String type) {
		if(type == null)
			return BrowserType.Chrome;
		
		for(BrowserType browserType : BrowserType.values()) {
			if(browserType.type.contains(type.toLowerCase()))
				return browserType;
		}
		return BrowserType.Chrome;
	}
	
	
	public String getType() {
		return this.type;
	}
}
