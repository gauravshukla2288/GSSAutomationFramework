package mygss.framework.WebAutomation.driver.web;

public class ScreenShot {
	
	
	private String location;
	private String htmlSourcePath;
	private String title;
	private String imagePath;
	private String suiteName;
	private String outputDirectory;
	
	public ScreenShot() {
		
		// if context ->  suitename is not null 
		// and output directory should be pulled
		
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getSuiteName() {
		return suiteName;
	}
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	public String getOutputDirectory() {
		return outputDirectory;
	}
	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}
	public String getHtmlSourcePath() {
		return htmlSourcePath;
	}
	public void setHtmlSourcePath(String htmlSourcePath) {
		this.htmlSourcePath = htmlSourcePath;
	}
	
	
	
	public String getFullImagePath() {
		if(this.imagePath != null)
			return imagePath.replace(suiteName, outputDirectory);
		else 
			return null;
	}
	
	
	public String getFullHtmlPath() {
		if(this.htmlSourcePath != null)
			return htmlSourcePath.replace(suiteName, outputDirectory);
		else 
			return null;
	}

	
	
}
