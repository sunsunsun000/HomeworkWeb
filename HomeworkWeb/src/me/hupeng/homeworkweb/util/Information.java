package me.hupeng.homeworkweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Information {
	public String getErrorInfo(int errorCode) {
		Properties properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/errorCode.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(errorCode + "", "null");
	}
	
	public String getConfigInfo(String param){
		Properties properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/config.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(param, "null");
	}
}
