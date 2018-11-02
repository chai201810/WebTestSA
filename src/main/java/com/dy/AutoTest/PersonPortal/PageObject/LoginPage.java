package com.dy.AutoTest.PersonPortal.PageObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.web.actions.Do;
import com.dy.AutoTest.web.util.JdbcUtil_1_0_0;

public class LoginPage {
	private WebDriver driver=null;
	private Do du=null;
	private JdbcUtil_1_0_0 jdbcUtils=null;
	private String sql;
	private List<Object> params;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		du=new Do(driver);
	}
	
	/**打开浏览器，进入个人门户
	 * @param url
	 */
	public void navigateToPersonPortal(String url) {
		driver.get(url);
	}
	
	/**首页选择“个人门户”
	 * 
	 */
	public void doSelectPersonPortal() {
		du.what("person_click").click();
	}
	
	/**填写用户名
	 * @param userid
	 */
	public void setUserid(String userid) {
		du.what("userid").sendKeys(userid);
	}
	
	/** 等待密码控件的键盘捕捉
	 * @param password
	 */
	public void setPassword(String password) {

		/*
		 //使用actions的方法键入，测过发现无效，
		 //提交后提示密码为空，重新激活焦点，密码被清空，可见这种方法录入密码只是表面操作
		du.what("password").click();
		du.waitFor(1000);
		du.doSendKeysToChar(password);
		*/
		
		
		
		
		
	}
	
	/**发送短信验证码
	 * 
	 */
	public void sendCode_SMS() {
		du.what("get_sms").click();
	}
	
	public String getCode_SMS(String userid) {
		jdbcUtils=new JdbcUtil_1_0_0();
//		jdbcUtils.getConnection();
		String sms="";
		try {	
			sql="select val_lst from " + 
					"(select * from CGDGW.T_NTC_EVTREC a where a.NTF_TO=? order BY TM_SMP DESC)" + 
					"where rownum <= 1";
			params=new ArrayList<Object>();
			params.add(userid);
			Map<String, Object> map=jdbcUtils.findSimpleResult(sql, params);
			String VAL_LST=(String)map.get("VAL_LST");
			if(VAL_LST.length()==22) {
				sms=VAL_LST.split("\\|")[1];
				System.out.println("短信验证码获取成功，sms为："+sms);
			}else if(VAL_LST.length()==9) {
				sms=VAL_LST.split("\\|")[0];
				System.out.println("短信验证码获取成功，sms为："+sms);
			}else {
				System.out.println("短信验证码获取失败，VAL_LST为："+VAL_LST);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbcUtils.releaseConn();
		return sms;
	}
	
	/**填入短信验证码
	 * @param code_sms
	 */
	public void setCode_SMS(String code_sms) {
		du.what("code_sms").sendKeys(code_sms);
	}
	
	/**点击登录
	 * @param url
	 */
	public void dologin() {
		du.what("login").click();
	}
}
