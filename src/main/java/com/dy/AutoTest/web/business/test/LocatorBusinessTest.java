package com.dy.AutoTest.web.business.test;

import org.testng.annotations.Test;

import com.dy.AutoTest.web.business.LocatorBusiness;

public class LocatorBusinessTest {
	 private LocatorBusiness locatorBusiness=new LocatorBusiness("POP_Loc_LoginPage");;
	
	  @Test
	  public void getXPath() {
 
		  try {
			System.out.println(locatorBusiness.getXPath("operPassword"));
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }

	  @Test
	  public void getCSS() {
  
		  try {
			System.out.println(locatorBusiness.getCSS("operPassword"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }

}
