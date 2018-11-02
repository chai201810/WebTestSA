package com.dy.AutoTest.web.actions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.dy.AutoTest.web.beans.Browser;
import com.dy.AutoTest.web.beans.BrowserCategory;
import com.dy.AutoTest.web.business.DataBusiness;
import com.dy.AutoTest.web.util.JdbcUtil;

public class SingletonSet {
	public static JdbcUtil jdbcUtil_sqlite = new JdbcUtil("sqlite");
	public static JdbcUtil jdbcUtil_oracle = new JdbcUtil();

	public static StringBuffer URL = new StringBuffer();
	public static StringBuffer getURL() {
		return URL;
	}

	public static StringBuffer CurrentAccountantDate=new StringBuffer();
	
	public static WebDriver driver;
	public static Wait wait;
	public static DoPlus du;

	@Parameters({ "browserCategory", "environment" })
	@BeforeSuite
	public static void init(String browserCategory, String environment) {

		URL.append(DataBusiness.getData_URL(environment));

		Browser browser = new Browser(BrowserCategory.valueOf(browserCategory));
		driver = browser.getWebDriver();
		wait = new Wait(driver);
		du = new DoPlus(driver);
		du.waitTime = 300;
	}

	@AfterSuite
	public void releaseBrowser() {
		wait.waitFor(2000);
		jdbcUtil_sqlite.releaseConn();
		jdbcUtil_oracle.releaseConn();
		driver.quit();
	}
}
