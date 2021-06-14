package com.ebanking.library;

import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class JavaPropertiesManager {

	final static Logger logger = Logger.getLogger(JavaPropertiesManager.class);
	private String propertiesFile;
	private Properties prop;
	private OutputStream output;
	private InputStream input;

	public JavaPropertiesManager(String propertiesFilePath) { // constructor created
		try {
			propertiesFile = propertiesFilePath;
			prop = new Properties(); // created instance of properties class.
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

	public String readProperty(String key) {
		String value = null;
		try {
			input = new FileInputStream(propertiesFile);
			prop.load(input);
			value = prop.getProperty(key);

		} catch (Exception e) {
			logger.error("Error: ", e);

		} finally {
			try {
				if (input != null) {
					input.close(); // cleaning object created in this method
				}
			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
			}
		}

		return value;
	}

	public void setProperty(String key, String value) {
		try {
			output= new FileOutputStream(propertiesFile);
			prop.setProperty(key, value);
		
			prop.store(output, null);
		} catch (Exception e) {
			logger.error("error:", e);
		}finally {
			try {
				if(output!=null) {
					output.close();
				}
				
			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
	
		}
	}

	}
	
	
	
	
	}// closing tag
