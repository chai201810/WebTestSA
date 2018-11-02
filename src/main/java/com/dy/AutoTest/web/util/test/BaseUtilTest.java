package com.dy.AutoTest.web.util.test;

import org.testng.annotations.Test;

import com.dy.AutoTest.web.util.BaseUtil;

public class BaseUtilTest {
	

  @Test
  public void fomatDate() {
	  System.out.println(BaseUtil.fomatDateStringToString("20180820"));
	  
  }
}
