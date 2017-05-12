package com.ptit.iot.smartfarm.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {

	public static String getProperty(String name) {
		InputStream input;
		Properties properties = new Properties();
		try {
			input = new FileInputStream("/home/kt1755/database.properties");
			properties.load(input);
			System.out.println("Load properties: " + name + " : " + properties.getProperty(name));
			return properties.getProperty(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getProperties(String name, String nvl) {
		InputStream input;
		Properties properties = new Properties();
		try {
			input = new FileInputStream("/home/kt1755/database.properties");
			properties.load(input);
			return properties.getProperty(name) == null ? nvl : properties.getProperty(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nvl;
	}
}
