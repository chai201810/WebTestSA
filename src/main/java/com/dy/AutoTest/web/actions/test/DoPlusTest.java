package com.dy.AutoTest.web.actions.test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dy.AutoTest.web.actions.DoPlus;
import com.dy.AutoTest.web.actions.Wait;
import com.dy.AutoTest.web.beans.Browser;
import com.dy.AutoTest.web.beans.BrowserCategory;
import com.dy.AutoTest.web.business.DataBusiness;

public class DoPlusTest {
	private WebDriver driver=null;
	private DoPlus du=null;
	private Actions action=null;
	private Robot robot=null;
	private DataBusiness data;
	private Wait wait;
	
	@BeforeClass
	public void initBrowser() {
		Browser browser=new Browser(BrowserCategory.valueOf("chrome"));
		driver=browser.getWebDriver();
		action=new Actions(driver);
		wait=new Wait(driver);
		du=new DoPlus(driver);
		data=new DataBusiness();
	}
	@AfterClass
	public void realseBrowser() {
		du.waitFor(4000);
		driver.quit();
	}
		
  @Test
  public void isDisplayed() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void waitFor() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void waitForElementIsEnable() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void waitForElementPresentString() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void waitForElementPresentStringint() {
    throw new RuntimeException("Test not implemented");
  }

  /**
 * 个人门户安全控件的click()可以onfocus
 * 个人门户安全控件的sendKeys()无效
 */
@Test
  public void whatString() {
	  driver.get("http://pay.uat.sh.dy:50080/pweb/login.jsp");
	  driver.findElement(By.xpath("//a[@id='person-click']")).click();
//	  driver.findElement(By.xpath("//input[@id='_ocx_password']")).click();
	  du.what("password").click();
	  wait.waitFor(1000);
	  driver.findElement(By.xpath("//input[@id='_ocx_password']")).sendKeys("1111qqqq");
  }

  /**
 * test LocatorBusiness and DataBusiness
 */
/*@Test
  public void whatStringString() {
	  driver.get("http://pay.uat.sh.dy:58082/mrbui/module/login/jsp/login.jsp");
	  du.loadLocator("POP_Loc_LoginPage");
	  data.loadData("POP_Data_Oper", "T00105");
	  du.what("operID").sendKeys(data.getOperBean().getOperID());
	  du.what("operPassword").sendKeys(data.getOperBean().getPassword());
	  
	  
  }*/

  @Test
  public void whats() {
    throw new RuntimeException("Test not implemented");
  }
  
  @Test
  public void whatPoint() {
	  driver.get("https://www.baidu.com");
	  System.out.println("该元素坐标为：("+du.whatPoint("submit").getX()
			  +","+du.whatPoint("submit").getY()+")");
  }

  	/**
  	 * 可以失去焦点，但是不能失去鼠标右击的焦点
  	 */
  	@Test
  	public void testLeftClickBy() {
		  driver.get("https://www.baidu.com");
		  driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("123");
		  driver.findElement(By.xpath("//input[@id='su']")).click();
		  wait.waitFor(2000);
		  du.doContextClick("//input[@id='kw']", -20, 0);
//		  wait.waitFor(2000);
//		  du.doLeftClickBy("//input[@id='kw']", -20, 50);
  	}
  
  
  @Test
  public void doDragAndDropBy() {
	  throw new RuntimeException("Test not implemented");
  }
  @Test
  public void doDragAndDrop() {
	  throw new RuntimeException("Test not implemented");
  }
  
  /**
 * use this test method to test password input
 * 		seprate password cleartext to char
 * 
 */
@Test
  public void doSendKeysToChar() {
	  driver.get("http://pay.uat.sh.dy:50080/pweb/login.jsp");
		driver.findElement(By.xpath("//a[@id='person-click']")).click();
		du.what("userid").sendKeys("134");
		
		du.what("password").click();
		du.waitFor(1000);
		/*
		//使用element.sendKeys方法输入密码，无效
		driver.findElement(By.xpath("//input[@id='_ocx_password']")).sendKeys("1");
	*/
		
/*		//使用actions.sendKeys方法输入密码，有效
		String a="A";
		for(int i=0;i<=4;i++) {
		action.sendKeys(a).perform();
		System.out.println(i);
		}
	*/
/*		
		String content="abcdefgh";
		for(char c : content.toCharArray()) {  
			String cString=c+"";
			action.sendKeys(cString).perform();
		}
		*/
		
		//使用du里面的封装actions.sendKeys方法输入密码，有效
		du.doSendKeysToChar("abcdefgh");
	
		du.what("userid").click();
  }
  
		@Test
		public void doSendKeysBy() {
			  
			  
		}
		
		@Test
		public void doSendKesPageDown() {
			  driver.get("https://www.baidu.com");
			  driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("123");
			  driver.findElement(By.xpath("//input[@id='su']")).click();
			  wait.waitFor(500);
//			  driver.findElement(By.xpath("//div[@class='nums']/span[@class='nums_text']")).click();
//			  wait.waitFor(500);
			  du.doSendKeys(Keys.PAGE_DOWN);
//			  action.sendKeys(Keys.PAGE_DOWN).perform();
		}
  @Test
  public void doSendKeysByRobote() {
	  driver.get("http://pay.uat.sh.dy:50080/pweb/login.jsp");
	  driver.findElement(By.xpath("//a[@id='person-click']")).click();
	  driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("1862012");
	  
//	try {
//		robot=new Robot();
//		robot.keyPress(KeyEvent.VK_7); 
//		robot.keyPress(KeyEvent.VK_9); 
//		robot.keyPress(KeyEvent.VK_7); 
//		robot.keyPress(KeyEvent.VK_2); 
//		
//		robot.keyPress(KeyEvent.VK_TAB); 
//		
//		robot.keyPress(KeyEvent.VK_TAB); 
//		
//		robot.keyPress(KeyEvent.VK_A); robot.keyPress(KeyEvent.VK_A); robot.keyPress(KeyEvent.VK_A); 
//	} catch (AWTException e) {
//		e.printStackTrace();
	  du.what("password").click();
	  du.waitFor(2000);
/*	
 * 		//invoke du.doSendKeysByRobot(), failed
		du.doSendKeysByRobot();
		*/
	/*  
	 // invoke Robot.keypress() directly, faied
	 // 在用户名文本框里显示成功
	 // 怀疑传的是键值，被密码控件挡下来了
	  try {
			robot=new Robot();
	  } catch (AWTException e) {
		  e.printStackTrace();
	  }
		robot.keyPress(KeyEvent.VK_1);robot.delay(2000);robot.keyRelease(KeyEvent.VK_1);robot.delay(1000);
		robot.keyPress(KeyEvent.VK_1);robot.delay(1000);robot.keyRelease(KeyEvent.VK_1);robot.delay(1000);
		robot.keyPress(KeyEvent.VK_Q);robot.delay(1000);robot.keyRelease(KeyEvent.VK_Q);robot.delay(1000);
		robot.keyPress(KeyEvent.VK_Q);robot.delay(1000);robot.keyRelease(KeyEvent.VK_Q);robot.delay(1000);
	*/	
	  du.waitFor(1000);
	  du.what("userid").click();
	  du.waitFor(1000);
	  du.what("password").click();
		
	}
  
  /**
 * Robot did work !
 * that is test 2
 * for system native widget:notepad
 */
	@Test()
	public void doSendKeysByRobote2() {
		 try {
			robot=new Robot();
		 } catch (AWTException e) {
			e.printStackTrace();
		 }
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_R);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_N);robot.keyPress(KeyEvent.VK_O);robot.keyPress(KeyEvent.VK_T);robot.keyPress(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_P);robot.keyPress(KeyEvent.VK_A);robot.keyPress(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent.VK_N);robot.keyRelease(KeyEvent.VK_O);robot.keyRelease(KeyEvent.VK_T);robot.keyRelease(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_P);robot.keyRelease(KeyEvent.VK_A);robot.keyRelease(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
  }
  
  

