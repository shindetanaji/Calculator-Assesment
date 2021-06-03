package com.qc.calc.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qc.calc.pages.CalculatorPage;

public class CalculatorTest extends BaseIntegration{

	CalculatorPage cal;
	
	@Test(dataProvider="getInput")
	public void peroformOperations(String n1, String n2, String task, String expResult) {
		cal = new CalculatorPage(driver);
		String actualResult= cal.doCalculation(n1, n2, task);
		Assert.assertEquals(actualResult.substring(1), expResult);
	}
	
	@AfterMethod
	public void doSometing() throws InterruptedException {
		cal = new CalculatorPage(driver);
		Thread.sleep(3000);
		cal.clickOnClear();
		
	}
	
}
