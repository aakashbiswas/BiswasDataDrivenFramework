package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void bankManagerLoginTest() throws Throwable {
		if (!TestUtil.isTestRunnable("bankManagerLoginTest", excel)) {
			throw new SkipException("Skipping the test"+"bankManagerLoginTest".toUpperCase()+" as the Run mode is no");
		}
		log.debug("inside Login Test");
		//driver.findElement(By.xpath(OR.getProperty("bmlbutton"))).click();
		click("bmlbutton_xpath");
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_css"))),"login not successfull");
		log.debug("login successfully executed");
		//Assert.fail("I want to fail the test");
		
	}
}
