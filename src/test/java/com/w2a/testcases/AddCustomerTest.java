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

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomerTest(Hashtable<String, String> data) throws Exception
	{
		if (!TestUtil.isTestRunnable("addCustomerTest", excel)) {
			throw new SkipException("Skipping the test"+"addCustomerTest".toUpperCase()+" as the Run mode is no");
		}
		if(!data.get("runmode").equals("Y"))
		{
			throw new SkipException("Skipping the run test as the data test is no");
		}
		//driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		click("addCustBtn_css");
		//driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(username);
		type("firstname_xpath", data.get("Firstname"));
		//driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(password);
		type("lastname_xpath", data.get("lastname"));
		//driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(pincode);
		type("postcode_xpath", data.get("pincode"));
		//driver.findElement(By.xpath(OR.getProperty("addbtn"))).click();
		click("addbtn_xpath");
		//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//Assert.assertTrue(alert.getText().contains(alerttext));
		Alert alert=driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains(data.get("alertTest")));
		alert.accept();
	}
	
}
