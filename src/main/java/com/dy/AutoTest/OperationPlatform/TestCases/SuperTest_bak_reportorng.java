package com.dy.AutoTest.OperationPlatform.TestCases;

import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.dy.AutoTest.web.actions.SingletonSet;
import com.dy.AutoTest.web.actions.Wait;
import com.dy.AutoTest.web.business.DataBusiness;
import com.dy.AutoTest.web.util.BaseUtil;

public class SuperTest_bak_reportorng {
	protected Wait wait;
	protected WebDriver driver;

	protected static DataBusiness data = new DataBusiness();

	protected StringBuffer host = SingletonSet.URL;
	
	protected String testinfo=""; 
	
	
	
	@BeforeClass
	public void beforeClass() { 
		wait = SingletonSet.wait;
		driver = SingletonSet.driver;
	}

	@BeforeTest
	public void BeforeTest(ITestContext context) {
		Reporter.log("        "+BaseUtil.fomatDateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+"): [Test]-\""+context.getName()+"\" is started");
	}
	
	@AfterTest
	public void AfterTest(ITestContext context) {
		Reporter.log("        "+BaseUtil.fomatDateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+"): [Test]-\""+context.getName()+"\" is finished");
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		Reporter.log("                "+BaseUtil.fomatDateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+": [Method]-\""
		+this.getClass().getSimpleName()+"."+method.getName()+"\" is started");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			Reporter.log("                "+BaseUtil.fomatDateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+": [Method]-\""
					+this.getClass().getSimpleName()+"."+result.getName()+"\" is passed");
		}else if(result.getStatus()==ITestResult.FAILURE) {
			Reporter.log("                "+BaseUtil.fomatDateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+": [Method]-\""
					+this.getClass().getSimpleName()+"."+result.getName()+"\" is failed");
			Reporter.log("                        "+"The failure is "+result.getThrowable());
		}else if(result.getStatus()==ITestResult.SKIP){
			Reporter.log("                "+BaseUtil.fomatDateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+": [Method]-\""
					+this.getClass().getSimpleName()+"."+result.getName()+"\" is skiped");
		}
		wait.waitFor(2000);
	}
}

