package com.fastip.utils;

import java.io.FileInputStream;

import java.util.Properties;

public class Projectutils {
	
	public String getproperty(String key) throws Exception
	{
		String value ="";
		
		String projectPath = System.getProperty("user.dir");
		
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(projectPath+"/config.properties");
		prop.load(fis);
		
		value=prop.getProperty(key);
		return value;
	}

}
