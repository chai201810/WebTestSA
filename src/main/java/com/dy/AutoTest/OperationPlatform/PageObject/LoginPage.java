package com.dy.AutoTest.OperationPlatform.PageObject;


import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.web.actions.DoPlus;
import com.dy.AutoTest.web.business.OperBusiness;
import com.dy.AutoTest.web.dao.OperDao;
import com.dy.AutoTest.web.dao.impl.OperDaoImpl;

public class LoginPage extends SuperPage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		du.loadLocator("POP_Loc_LoginPage");
		
	}
		
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_LoginPage");
	}
	
	
	/**填写用户名
	 * @param userid
	 */
	public void setOperID(String userid) {
		du.what("operID").sendKeys(userid);
	}
	
	/**填写密码控件
	 * @param password
	 */
	public void setPassword(String password) {
		du.what("operPassword").sendKeys(password);
	}
	
	/**发送短信验证码
	 * 
	 */
	public void sendCode_SMS() {
		du.what("operGet_sms").click();
	}
	
	/**获取短信验证码
	 * @param userid
	 * @return
	 */
	public String getCode_SMS(String operMobileNo) {
		OperDao operDao=new OperDaoImpl();
		OperBusiness OperBusiness=new OperBusiness(operDao);
		return OperBusiness.getPOPLoginSMS(operMobileNo);
	}
	
	/**填入短信验证码
	 * @param code_sms
	 */
	public void setCode_SMS(String code_sms) {
		du.what("operCode_sms").sendKeys(code_sms);
	}
	
	/**点击登录
	 * @param url
	 */
	public void doLogin() {
		du.what("operLogin").click();
	}
}
