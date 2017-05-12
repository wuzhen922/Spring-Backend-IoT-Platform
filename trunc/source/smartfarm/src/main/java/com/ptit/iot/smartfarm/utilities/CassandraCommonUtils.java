package com.ptit.iot.smartfarm.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CassandraCommonUtils {

	public static String getProperty(String name) {
		InputStream input;
		Properties properties = new Properties();
		try {
			ClassLoader classLoader = CassandraCommonUtils.class.getClassLoader();
			input = new FileInputStream(classLoader.getResource("/com/ptit/iot/smartfarm/config/cassandra.properties").getFile());
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
		try {
			return CassandraCommonUtils.getProperty(name) == null ? nvl : CassandraCommonUtils.getProperty(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nvl;
	}
}
