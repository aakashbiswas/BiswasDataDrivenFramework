package com.w2a.utilities;


import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		String filename=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html";
		 if(extent==null)
		 {
			 extent=new ExtentReports(filename,true,DisplayOrder.OLDEST_FIRST);
			 extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		 }
		return extent;
	}
}
