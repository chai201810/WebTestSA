package com.dy.AutoTest.web.actions;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Switch {
	private WebDriver driver;
	private String currentWindow;
	
	public Switch(WebDriver driver) {
		this.driver=driver;
		currentWindow=driver.getWindowHandle();
	}
	
	
	/**
	 * Description: switch to specific window
	 * @author Jerry
	 * @param partialTitleName
	 * @version: 1.0
	 */
	public void toSpecificWindow(String partialTitleName) {
		Set<String> handles=driver.getWindowHandles();
		String titleName;
		for(String handle:handles) {
			titleName=driver.switchTo().window(handle).getTitle();
			if(titleName.contains(partialTitleName))
				break;
		}
	}
	/**
	 * Description: back to parent window but don't close the source window
	 * @author Jerry
	 * @param partialTitleName
	 * @version: 1.0
	 */
	public void backToCurrentWindow() {
		driver.switchTo().window(currentWindow);
	}

}
