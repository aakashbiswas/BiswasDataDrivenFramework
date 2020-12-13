package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void openAccountTest(Hashtable<String, String> data) throws Exception
	{
		if (!TestUtil.isTestRunnable("openAccountTest", excel)) {
			throw new SkipException("Skipping the test"+"openAccountTest".toUpperCase()+" as the Run mode is no");
		}
		click("openaccount_css");
		//Thread.sleep(5000);
		select("customer_css", data.get("customer"));
		select("currency_css", data.get("currency"));
		click("process_xpath");
		Alert alert=driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains(data.get("alertTest")));
		alert.accept();

	}
	 
}
