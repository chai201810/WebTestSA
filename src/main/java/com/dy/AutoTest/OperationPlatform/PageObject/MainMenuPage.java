package com.dy.AutoTest.OperationPlatform.PageObject;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.web.actions.DoPlus;
import com.dy.AutoTest.web.actions.SingletonSet;

public class MainMenuPage {
	
	private WebDriver driver=null;
	private DoPlus du=null;
	
	public MainMenuPage(WebDriver driver) {
		this.driver=driver;
		du=SingletonSet.du;
		du.loadLocator("POP_Loc_MainMenuPage");
	}

	
	/**
	 * 进入运营平台首页
	 * @param url
	 */
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	/**
	 * 跳转去“商户资料录入”
	 */
	public void gotoMechantInfoInsert() {
//		navigateTo();//每次操作前都需要先跳转首页一次，这样才健壮
		
		du.waitForElementPresent("MechantManagementOnLine");
		du.what("MechantManagementOnLine").click();
		
//		du.waitForElementPresent("OnLineMechantInfo");
		du.waitFor(2000);
		du.what("OnLineMechantInfo").click();
		
//		du.waitForElementPresent("OnLineMechantInfoInsert");
		du.waitFor(2000);
		du.what("OnLineMechantInfoInsert").click();
	}
	
	public String getCurrentAccountantDate() {
		String CurrentAccountantDate=du.what("CurrentAccountantDate").getText();
		CurrentAccountantDate=CurrentAccountantDate.substring(6);
		CurrentAccountantDate=CurrentAccountantDate.substring(0, 4)+"-"+CurrentAccountantDate.substring(5,7)+"-"+CurrentAccountantDate.substring(8,10);
		return CurrentAccountantDate;
	}
	
	
	/**
	 * 退出登录
	 */
	public void doQuit() {
		du.waitFor(2000);
		du.what("Personal").click();
		du.waitFor(500);
		du.what("Quit").click();
	}
	
	/**
	 * 修改密码（未完）
	 */
	public void doPasswordChange() {
		du.waitFor(3000);
		du.what("Personal").click();
		du.waitFor(500);
		du.what("ChangePassword").click();
		
	}
	

	
}
