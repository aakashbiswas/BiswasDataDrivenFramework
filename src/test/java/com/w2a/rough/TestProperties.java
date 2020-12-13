package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TestProperties {

	public static void main(String args[]) throws Exception
	{
		Properties config=new Properties();
		Properties OR=new Properties();
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fs);
		fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fs);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("bmlbutton"));
	}
}
