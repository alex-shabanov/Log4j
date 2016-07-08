package com.pkg;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class LogFile {
	private static String SPACE = ": ";
	private static String EXCEPTION_CAUSE = "Exception Cause:  ";
	private static final Logger logger = Logger.getLogger(LogFile.class.getName().toString());

	public static Logger getLogger() {
		return logger;
	}
	
	private static String format(Object object, String method, String message, Exception exception) {
		StringBuffer buffer = new StringBuffer();
		
		if (object == null){
			buffer.append(method + SPACE + message + SPACE);
		}
		else{
			buffer.append(object.getClass().getName() + SPACE + method + SPACE + message + SPACE);
		}
		if(exception != null){
		    buffer.append(EXCEPTION_CAUSE + exception.getCause());
		}
		return buffer.toString();
	}
	
	public static void warn(Object object, String method, String message, Exception exception) {
		String displayMessage = format(object, method, message, exception);
		getLogger().log(Level.WARN, displayMessage, exception);
	}
	
	public static void info(Object object, String method, String message, Exception exception) {
		String displayMessage = format(object, method, message, exception);
		getLogger().log(Level.INFO, displayMessage, exception);
	}

	public static void severe(Object object, String method, String message, Exception exception) {
		String displayMessage = format(object, method, message, exception);
		getLogger().log(Level.ERROR, displayMessage, exception);
	}
}
