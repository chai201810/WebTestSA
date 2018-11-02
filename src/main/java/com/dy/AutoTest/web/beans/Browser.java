package com.dy.AutoTest.web.beans;


import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {
	
	@SuppressWarnings("unused")
	private BrowserCategory category; 
	private WebDriver driver;
	private String projectpath=System.getProperty("user.dir");
	private DesiredCapabilities	caps=null;
	private ChromeOptions chromeOptions=null;
	
	public Browser(BrowserCategory category) {
		this.category=category;
		setWebDriver(category);
	}
	public WebDriver getWebDriver() {
		return driver;
	}
	@SuppressWarnings("deprecation")
	public void setWebDriver(BrowserCategory category) {
		switch (category) {
		case chrome:
			System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver_2.40_win32.exe");
//			String userProfile = browserProfilePath.replace("/", "\\"); 
			chromeOptions=new ChromeOptions();
			chromeOptions.addArguments(Arrays.asList("--start-maximized"));
			driver=new ChromeDriver(chromeOptions);
			break;
		case firefox:
			System.setProperty("webdriver.gecko.driver", projectpath+"/tool/geckodriver-v0.21.0-win64.exe");	
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("insecure_field_warning.contextual.enabled", false);
			options.addPreference("security.insecure_field_warning.contextual.enabled", false);
			driver=new FirefoxDriver(options);
			break;
		case edge:
			System.setProperty("webdriver.edge.driver", projectpath+"/tool/MicrosoftWebDriver_6.17134_17.17134.exe");
			driver=new EdgeDriver();
			break;
		case ie:
			System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer_x64_3.12.0.exe");
			caps=DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "- private");
			caps.setCapability("ignoreZoomSetting", true);
			driver=new InternetExplorerDriver(caps);
		default:
			break;
		}
	}
}
