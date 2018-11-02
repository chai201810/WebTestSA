package com.dy.AutoTest.PersonPortal.PageObject;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.web.actions.Do;

public class IndexPage {
	private WebDriver driver=null;
	private Do du=null;
	
	public IndexPage(WebDriver driver) {
		this.driver=driver;
		du=new Do(driver);
	}
	
	/**打开浏览器，进入个人门户
	 * @param url
	 */
	public void navigateToIndex(String url) {
		driver.get(url);
	}
	
	/**跳转到交易管理页面
	 * 
	 */
	public void doTransactionManagement() {
		du.what("TrasactionManage").click();
	}
	
	
	
}
