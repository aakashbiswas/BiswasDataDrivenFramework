package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase {

	public static String screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\";
	public static String screenshotName;

	public static void captureScreenshot() throws Throwable {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		Date d = new Date();

		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + "error";

		File DestFile = new File(screenshotPath + screenshotName + ".jpg");

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		// System.out.println(sheetName);
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		// System.out.println(rows);
		// System.out.println(cols);
		Object[][] data = new Object[rows - 1][1];
		Hashtable<String, String> table=null;
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table=new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;
	}

	public static boolean isTestRunnable(String testname, ExcelReader excel) {

		String sheetname = "test_suite";
		int rows = excel.getRowCount(sheetname);
		for (int rnum = 2; rnum <= rows; rnum++) {
			String testcase = excel.getCellData(sheetname, "TCID", rnum);
			System.out.println(testcase);
			if (testcase.equalsIgnoreCase(testname)) {
				String runmode = excel.getCellData(sheetname, "Runmode", rnum);
				System.out.println(runmode);
				if (runmode.equalsIgnoreCase("Y")) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;

	}
}
