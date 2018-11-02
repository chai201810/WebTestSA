package  com.dy.AutoTest.PersonPortal.testcases;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dy.AutoTest.PersonPortal.PageObject.IndexPage;
import com.dy.AutoTest.PersonPortal.PageObject.LoginPage;
import com.dy.AutoTest.PersonPortal.PageObject.TransactionPage;
import com.dy.AutoTest.web.actions.Do;
import com.dy.AutoTest.web.beans.Browser;
import com.dy.AutoTest.web.beans.BrowserCategory;
import com.dy.AutoTest.web.util.ParseProperties;


public class TestTransactionManagement {
	private String projectpath=System.getProperty("user.dir");
	private WebDriver driver=null;
	private ParseProperties data=null;
	private Do du=null;//是否需要du
	private String code_SMS;
	private LoginPage loginPage;
	private IndexPage indexPage;
	private TransactionPage transactionPage;
	

	
	@Parameters({"data","locator"})//这个locator是否需要
	@BeforeClass(groups="Class")
	public void loadProperties(String data,String locator) {
		this.data=new ParseProperties(projectpath+data);
	}
	
	@Parameters({"browserCategory"})	
	@BeforeClass(groups="Class")
	public void init(String browserCategory) {
		Browser browser=new Browser(BrowserCategory.valueOf(browserCategory));
		driver=browser.getWebDriver();
		du=new Do(driver);//是否需要du
		
		loginPage=new LoginPage(driver);
		indexPage=new IndexPage(driver);
		transactionPage=new TransactionPage(driver);
	}
	
	@AfterClass(groups="Class")
	public void releaseBrowser() {
		du.waitFor(3000);
		driver.quit();
	}
	
	@Test
	public void doLogin() {
		loginPage.navigateToPersonPortal(data.getValue("url"));
		assertEquals(du.isDisplayed("person_click"), true);
		loginPage.doSelectPersonPortal();
		loginPage.setUserid(data.getValue("userid"));
//		loginPage.setPassword(data.getValue("password"));
		
		loginPage.sendCode_SMS();
		code_SMS=loginPage.getCode_SMS(data.getValue("userid"));
		loginPage.setCode_SMS(code_SMS);
	
		du.waitFor(15000);
		loginPage.dologin();
	}
	
	
	@Test(dependsOnMethods="doLogin")
	public void doIndex() {		
		du.waitFor(2000);//需要优化
		indexPage.navigateToIndex(data.getValue("url_index"));
		assertEquals(du.isDisplayed("checkIndex"), true);
		indexPage.doTransactionManagement();
	}
	
	@Test(dependsOnMethods="doIndex")
	public void testTransactionManagement() {
		du.waitForElementPresent("check_TrasactionManage_h6");//edge浏览器需要加入这行
		assertEquals(du.isDisplayed("check_TrasactionManage_h6"), true);
		System.out.println(1);
		transactionPage.doDateSearch();
		transactionPage.doDeposit();
		transactionPage.doWithdraw();
		transactionPage.doTransfer();
		transactionPage.doPurchaseSearch();
		
		du.waitForElementPresent("trasaction_record_purchase");
		
		transactionPage.doPageTurning();
	}
	
	

}
