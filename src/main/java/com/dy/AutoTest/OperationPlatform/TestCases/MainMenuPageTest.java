package com.dy.AutoTest.OperationPlatform.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dy.AutoTest.OperationPlatform.PageObject.MainMenuPage;
import com.dy.AutoTest.web.actions.SingletonSet;
import com.dy.AutoTest.web.actions.Wait;
import com.dy.AutoTest.web.business.DataBusiness;

public class MainMenuPageTest {
	private WebDriver driver;
	private Wait wait;
	private MainMenuPage mainMenuPage;

	private StringBuffer host=SingletonSet.URL;
	private String URL="";
	
	@BeforeClass
	public void init() {
		driver=SingletonSet.driver;
		wait=SingletonSet.wait;
		mainMenuPage=new MainMenuPage(driver); 
		
		URL=host.toString()+DataBusiness.getData_URL("pop_index");
	}
	
	@AfterClass
	public void releaseBrowser() {
		wait.waitFor(1000);
	}
	
	@Test
	public void testMechantInfoInsert() {
		mainMenuPage.navigateTo(URL);
		mainMenuPage.gotoMechantInfoInsert();
		
	}
	@Test
	public void testQuit() {
		mainMenuPage.doQuit();
	}
	@Test
	public void testGetCurrentAccountantDate() {
		System.out.println(mainMenuPage.getCurrentAccountantDate());
		
	}
	
}
