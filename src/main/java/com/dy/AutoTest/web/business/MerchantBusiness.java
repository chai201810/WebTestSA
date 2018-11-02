package com.dy.AutoTest.web.business;

import com.dy.AutoTest.web.dao.MerchantDao;

public class MerchantBusiness {
	
	MerchantDao merchantDaoImpl;
	
	public MerchantBusiness(MerchantDao merchantDaoImpl) {
		this.merchantDaoImpl=merchantDaoImpl;
	}
	
	
	public String getMerchantNOByName(String merchantName) {
		
		String merchantNO=merchantDaoImpl.getMerchantNOByName(merchantName);
		
		if(merchantNO.equals("")) {
			System.out.println("select merchantNO is null! Please check!");
		}
		
		return merchantNO;
	}
	
}
