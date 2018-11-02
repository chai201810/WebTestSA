package com.dy.AutoTest.web.business.test;

import org.testng.annotations.Test;

import com.dy.AutoTest.web.business.MerchantBusiness;
import com.dy.AutoTest.web.dao.MerchantDao;
import com.dy.AutoTest.web.dao.impl.MerchantDaoImpl;

public class MerchantBusinessTest {

  @Test
  public void getMerchantNOByName() {
	  MerchantDao merchantDaoImpl=new MerchantDaoImpl();
	  MerchantBusiness merchantBusiness=new MerchantBusiness(merchantDaoImpl);
	  System.out.println(merchantBusiness.getMerchantNOByName("线上Auto_04"));
	  
    
  }
}
