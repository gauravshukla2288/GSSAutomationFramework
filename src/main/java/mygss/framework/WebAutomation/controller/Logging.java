package mygss.framework.WebAutomation.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Logging {
	
	public static Logger getLogger(Class<?> clazz) {
		
		boolean rootIsConfigured = Logger.getRootLogger().getAllAppenders().hasMoreElements();
		
		if(!rootIsConfigured) {
			BasicConfigurator.configure();
			Logger.getRootLogger().setLevel(Level.INFO);
			Appender append = (Appender)Logger.getRootLogger().getAllAppenders().nextElement();
			append.setLayout(new PatternLayout(" %-5p %d [%t] %C{1}: %m%n"));
		}
		return Logger.getLogger(clazz);
	}
	
	
	private static Map <String, Map<String,  Map<String, List <String>>>> pogeListenerLogMap = 
			Collections.synchronizedMap(new  HashMap <String ,  Map<String,  Map <String ,  List <String>>>>());

}
