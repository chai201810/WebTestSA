package com.dy.AutoTest.web.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties properties=new Properties();
	String value=null;
	
	public ParseProperties(String propertiesPath) {
		this.loadProperties(propertiesPath);
	}

	private void loadProperties(String propertiesPath) {

		try {
			InputStream inputStream=new FileInputStream(propertiesPath);
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			properties.load(bufferedReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String keyname) {
		value=properties.getProperty(keyname).trim();
		
		try {
			value=new String(value.getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
}
