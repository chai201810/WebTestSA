package com.dy.AutoTest.web.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dy.AutoTest.web.business.LocatorBusiness;


/**
 * Locator取值从ParseProperties到从数据库
 * @version Do_1.0.1
 * @author Jerry
 *
 */
public class DoPlus{
	public long waitTime=0;
	
	private WebDriver driver;
	private Wait waiter;
	private Point point;
	private Actions action=null;
	private Select select =null;
	
	private LocatorBusiness locator;
	
	public DoPlus(WebDriver driver) {
		this.driver=driver;
		waiter=new Wait(driver);
		action=new Actions(driver);
	}
	
	public DoPlus(WebDriver driver,String tableName) {
		this.driver=driver;
		waiter=new Wait(driver);
		action=new Actions(driver);
		loadLocator(tableName);
	}
	
	public void loadLocator(String tableName) {
		locator=new LocatorBusiness(tableName);
	}
	
	public boolean isDisplayed(String locationName) {
		
		return driver.findElement(By.xpath(locator.getXPath(locationName))).isDisplayed();
	}
	
	public WebElement what(String locationName) {
//		waitForElementPresent(locationName);
		if(waitTime!=0) waiter.waitFor(waitTime);
		return driver.findElement(By.xpath(locator.getXPath(locationName)));
	}
	public WebElement what(String locationName,String replaceString) {
		if(waitTime!=0) waiter.waitFor(waitTime);
		locationName=locator.getXPath(locationName).replace("??", replaceString);
		waiter.waitForElementPresent(locationName);
		return driver.findElement(By.xpath(locationName));
	}
	public List<WebElement> whats(String locationName) {
		if(waitTime!=0) waiter.waitFor(waitTime);
		return driver.findElements(By.xpath(locator.getXPath(locationName)));
	}
	
	public void waitForElementPresent(String locationName) {
		waiter.waitForElementPresent(locator.getXPath(locationName));
/*		try {
			(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator.getXPath(locationName))));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The element can not find!");
		}*/
	}
	public void waitForElementPresent(String locationName,int time) {
		waiter.waitForElementPresent(locator.getXPath(locationName),time);
/*		try {
			(new WebDriverWait(driver, time))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator.getXPath(locationName))));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The element can not find!");
		}*/
	}
		
	public void waitForElementIsEnable(String locationName) {
		waiter.waitForElementIsEnable(locator.getXPath(locationName));
	}
	
	public void waitFor(long timeout) {
		waiter.waitFor(timeout);
/*		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
/*************************下拉框************************************/
	public Select whatSelect(String locationName) {
		if(waitTime!=0) waiter.waitFor(waitTime);
		select =new Select(what(locationName));
		return select;
	}
//	Select select = new Select(Element);
//	select.selectByVisibleText("标签里的文字");
//	select.selectByValue("  ");
//	select.selctByIndex(" ");
	
/*************************元素坐标************************************/	
	/**get Element point(x,y)
	 * @param locationName
	 * @return
	 */
	public Point whatPoint(String locationName) {
		if(waitTime!=0) waiter.waitFor(waitTime);
		point=driver.findElement(By.xpath(locator.getXPath(locationName))).getLocation();
		return point;
	}

	
/*************************鼠标事件************************************/
	
	public void doLeftClickBy(String locationName,int xOffset,int yOffset) {
		action.moveToElement(what(locationName), xOffset, yOffset).click()
		.build().perform();
	}
	public void doLeftClickBy(WebElement element,int xOffset,int yOffset) {
		action.moveToElement(element, xOffset, yOffset).click()
		.build().perform();
	}
	
	
	
	/**鼠标右击，未完成，鼠标右击后，选项应该如何选择，需要考虑解决方案
	 * @param locationName
	 * 未完成
	 */
	public void doContextClick(String locationName) {
		action.contextClick(driver.findElement(By.xpath(locationName)))
		.build().perform();
	}
	public void doContextClick(String locationName,int xOffset,int yOffset) {
		action.moveToElement(driver.findElement(By.xpath(locationName)), xOffset, yOffset).contextClick()
		.build().perform();
	}
	
	/**鼠标拖拽元素到指定的位置
	 * click-and-hold at the location of the source element,
	 * moves by a given offset, then releases the mouse.
	 * @param locationName
	 * @param xPoint
	 * @param yPoint
	 */
	public void doDragAndDropBy(String locationName,int xPoint,int yPoint) {
		action.dragAndDropBy(driver.findElement(By.xpath(locationName)), xPoint, yPoint)
			.build().perform();
	}
	
	/**鼠标拖拽元素到目标元素位置
	 * click-and-hold at the location of the source element,
	 * moves to the location of the target element, 
	 * @param source
	 * @param target
	 */
	public void doDragAndDrop(String source,String target) {
		action.dragAndDrop(driver.findElement(By.xpath(source)), driver.findElement(By.xpath(target)))
			.build().perform();
	}

/*************************键盘事件************************************/
	
	/**
	 * 通过Actions执行键盘操作
	 * @param key
	 * @return
	 */
	
	
	public void doSendKeys(CharSequence keys) {
		action.sendKeys(keys).perform();
	}
	public void doSendKeys(String content) {
		
//		action.sendKeys(Keys.TAB);// 模拟按下并释放 TAB 键
//		action.sendKeys(Keys.SPACE);// 模拟按下并释放空格键
//		action.sendKeys(Keys.ALT);
//		action.sendKeys(Keys.CONTROL); 
//		action.sendKeys(Keys.SHIFT); 
//		action.sendKeys(Keys.NULL);
//		action.keyDown(Keys.CONTROL).sendKeys("a").perform();
//		action.sendKeys(driver.findElement(By.xpath("")), Keys.CONTROL);
		
/*
		for(char c : content.toCharArray()) {  
			action.sendKeys(c+"").perform();
			waitFor(2000);
		}
		*/
		action.sendKeys(content).perform();
	}
	
	public void doSendKeysToChar(String content) {
		
//		action.sendKeys(Keys.TAB);// 模拟按下并释放 TAB 键
//		action.sendKeys(Keys.SPACE);// 模拟按下并释放空格键
//		action.sendKeys(Keys.ALT);
//		action.sendKeys(Keys.CONTROL); 
//		action.sendKeys(Keys.SHIFT); 
//		action.sendKeys(Keys.NULL);
//		action.keyDown(Keys.CONTROL).sendKeys("a").perform();
//		action.sendKeys(driver.findElement(By.xpath("")), Keys.CONTROL);
		
		for(char c : content.toCharArray()) {  
			action.sendKeys(String.valueOf(c)).perform();
			System.out.println(String.valueOf(c));
		}
	}
	
	public Actions doSendKeysBy(String elementXpath,String content) {
		
		action.sendKeys(driver.findElement(By.xpath(elementXpath)),content);
		
		return action;
	}
	
//	public void doSendKeysByRobot(char key) {
	public void doSendKeysByRobot() {
		try {
			Robot robot=new Robot();
//			System.out.println(	KeyEvent.getKeyText(key));
//			KeyEvent.getKeyText(key);
//			robot.keyPress(KeyEvent.VK_7); 
//			robot.keyPress(KeyEvent.VK_9); 
//			robot.keyPress(KeyEvent.VK_7); 
//			robot.keyPress(KeyEvent.VK_2); 
//			
//			robot.keyPress(KeyEvent.VK_TAB); 
//			
//			robot.keyPress(KeyEvent.VK_TAB); 
			robot.keyPress(KeyEvent.VK_1);robot.keyRelease(KeyEvent.VK_1);robot.delay(1000);
			robot.keyPress(KeyEvent.VK_1);robot.keyRelease(KeyEvent.VK_1);robot.delay(1000);
			robot.keyPress(KeyEvent.VK_1);robot.keyRelease(KeyEvent.VK_1);robot.delay(1000);
			robot.keyPress(KeyEvent.VK_1);robot.keyRelease(KeyEvent.VK_1);robot.delay(1000);
			robot.keyPress(KeyEvent.VK_Q);robot.keyRelease(KeyEvent.VK_Q);robot.delay(1000);
			robot.keyPress(KeyEvent.VK_Q);robot.keyRelease(KeyEvent.VK_Q);robot.delay(1000);
			robot.keyPress(KeyEvent.VK_Q);robot.keyRelease(KeyEvent.VK_Q);robot.delay(1000);
			robot.keyPress(KeyEvent.VK_Q);robot.keyRelease(KeyEvent.VK_Q);robot.delay(1000);
				
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
/*************************上传文件************************************/
	
//	直接使用 WebElement 类的 sendKeys(keysToSend) 方法就可以实现文件上传了
	/** 
	* 
	* @Description: 在百度云上测试文件批量上传功能，主要是通过循环的方式去做单一
	* 的上传动作 , 登陆过程已经去掉
	*/ 
	@Test
	public void test_mutilUploadFile() throws Exception { 
	System.out.println("upload start"); 
	        // 获取上传控件元素
	WebElement uploadButton = driver.findElement(By.name("html5uploader")); 
	// 构建上传文件路径，将需要上传的文件添加到 CharSequence 数组
	CharSequence[] files = new CharSequence[5]; 
	        files[0] = "C:\\test\\test1.txt"; 
	        files[1] = "C:\\test\\test2.txt"; 
	        files[2] = "C:\\test\\test3.txt"; 
	        files[3] = "C:\\test\\test4.txt"; 
	        files[4] = "C:\\test\\test5.txt"; 
	        // 循环列出每支需要上传的文件路径，做单一上传动作
	        for(CharSequence file: files){ 
	uploadButton.sendKeys(file); 
	        } 
	        Thread.sleep(2000); 
	System.out.println("upload end"); 
	    }

	
	
	
}
