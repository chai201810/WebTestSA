package com.dy.AutoTest.OperationPlatform.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dy.AutoTest.web.actions.DoPlus;
import com.dy.AutoTest.web.actions.SingletonSet;

public abstract class SuperPage {
	protected WebDriver driver=null;
	protected DoPlus du=null;
	
	public SuperPage(WebDriver driver) {
		this.driver=driver;
		du=SingletonSet.du;
	}
	public void navigateTo(String url) {
		driver.get(url);
	}

	public void doLoseFocus(String locationName) {
		du.doLeftClickBy(locationName, 0, -20);
	}
	public void doLoseFocus(String locationName,int xOffset,int yOffset) {
		du.doLeftClickBy(locationName, xOffset, yOffset);
	}
	
	public void doCancel() {
		du.doSendKeys(Keys.ESCAPE);
	}
	public void doDown() {
		du.doSendKeys(Keys.DOWN);
		du.doSendKeys(Keys.DOWN);
		du.doSendKeys(Keys.DOWN);
	}
	public void doUp() {
		du.doSendKeys(Keys.UP);
		du.doSendKeys(Keys.UP);
		du.doSendKeys(Keys.UP);
	}
	public void doPageDown() {
		du.doSendKeys(Keys.PAGE_DOWN);
	}
	public void doPageUp() {
		du.doSendKeys(Keys.PAGE_UP);
	}
	
	
	public String getCurrentAccountantDate() {
		String CurrentAccountantDate=
				driver.findElement(By.xpath("//span[@class='badge acdt']")).getText();
		CurrentAccountantDate=CurrentAccountantDate.substring(6);
		CurrentAccountantDate=CurrentAccountantDate.substring(0, 4)+"-"+CurrentAccountantDate.substring(5,7)+"-"+CurrentAccountantDate.substring(8,10);
		return CurrentAccountantDate;
	}
	
	public String getNotice() {
		String xpath="//li[@class='messenger-message-slot'][1]/div[@class='messenger-message message alert info message-info alert-info messenger-will-hide-after messenger-hidden']/div";
//		try {
//			(new WebDriverWait(driver, 10))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//		}
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("The element can not find!");
		}
//		return du.what("Notice").getAttribute("textContent");
		return driver.findElement(By.xpath(xpath)).getAttribute("textContent");
	}
	
	
	public abstract void setWaitTime(long waitTime);
}
