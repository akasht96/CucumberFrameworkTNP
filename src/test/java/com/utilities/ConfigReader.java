package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties initializeProperties() {
		Properties prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/config/config.properties"));
			prop.load(fis);
			System.out.println(prop.getProperty("browser")+" "+prop.getProperty("url"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
}
