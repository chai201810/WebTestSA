package com.dy.AutoTest.web.business;

import com.dy.AutoTest.web.dao.OperDao;

public class OperBusiness {
	
	private OperDao operDao;
	
	public OperBusiness(OperDao operDao) {
		this.operDao=operDao;
	}
	
	public String getPOPLoginSMS(String operMobileNo) {
		String sms ="";
		String VAL_LST = operDao.getPOPLoginVAL_LST(operMobileNo);
		if(VAL_LST.length()==22) {
			sms=VAL_LST.split("\\|")[1];
			System.out.println("短信验证码获取成功，sms为："+sms);
		}else if(VAL_LST.length()==9 ||VAL_LST.length()==10) {
			sms=VAL_LST.split("\\|")[0];
			System.out.println("短信验证码获取成功，sms为："+sms);
		}else {
			System.out.println("短信验证码获取失败，VAL_LST为："+VAL_LST);
		}
		return sms;
	}
}
