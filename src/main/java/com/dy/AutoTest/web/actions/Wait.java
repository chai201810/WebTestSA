package com.dy.AutoTest.web.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver driver;
	private int timeout=10;
	
	public Wait(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElementPresent(String xpath) {
		
		try {
			(new WebDriverWait(driver, timeout))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The element can not find!");
		}
	}
public void waitForElementPresent(String xpath,int time) {
	
	try {
		(new WebDriverWait(driver, time))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("�ȴ���ʱ");
	}
}
	
	public void waitForElementIsEnable(String xpath) {
		
		(new WebDriverWait(driver, timeout))
			.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public void waitFor(long timeout) {
		
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
