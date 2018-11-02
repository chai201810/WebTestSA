package com.dy.AutoTest.web.util.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dy.AutoTest.web.util.JdbcUtil_1_0_0;

public class JdbcUtil_1_0_0Test {
	private JdbcUtil_1_0_0 jdbcUtil;
	private String sql="";
	private List<Object> params;
	@BeforeClass
	public void initjdbcUtil() {
		jdbcUtil =new JdbcUtil_1_0_0();
		jdbcUtil.getConnection();
	}
	@AfterClass
	 public void releaseConn() {
		jdbcUtil.releaseConn();
	  }
	
	 @Test(enabled = false)
	 public void updateByPreparedStatement() {
		 		 
		 try {
		 //个人门户-把登录密码重置成1234qwer
			sql="update GSDPAY.T_URM_OPER set LOG_PSWD=replace(LOG_PSWD,substr(LOG_PSWD,1,16),'CC2882F17D5D635A')"
					+"where usr_no=(select a.USR_NO from gsdpay.t_urm_pinf a " 
					+"where a.reg_mbl=GSDPAY.RETURN_ENCRYPTED_DATA('18918182584') and a.USR_STS=0)";
			 
		/*//个人门户-把支付密码重置成258025
			sql="update GSDPAY.T_URM_PINF set PAY_PSWD =replace(PAY_PSWD,substr(PAY_PSWD,1,16),'D1F79E023D479611')"
					+"where reg_mbl=GSDPAY.RETURN_ENCRYPTED_DATA('18918182584') and USR_STS='0'" ;
			*/
			if(jdbcUtil.updateByPreparedStatement(sql, null)) {
				System.out.println("重置密码成功");
			}else {
				System.out.println("重置密码失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	  }

	 /**
	 * 测试使用的业务是获取短信验证码
	 * 短信验证码样式为    18918182584|210758|57|
	 * 特定coding： aString.split("\\|")[1])，取第二个数组的值
	 */
	@Test
	 public void findSimpleResult() { 
		sql="select val_lst from "
		 		+ "(select * from CGDGW.T_NTC_EVTREC a where a.NTF_TO=? order BY TM_SMP DESC) "
		 		+ "where rownum <= 1";
		 params=new ArrayList<Object>();
		 params.add("18918182584");
		 try {
			Map<String, Object> map=jdbcUtil.findSimpleResult(sql, params);
			//遍历map
			for (String key : map.keySet()) {
				System.out.println(key+">>"+map.get(key));
			//特定coding
			String aString=(String)map.get("VAL_LST");
			if(aString.length()==22) {
			System.out.println(aString.split("\\|")[1]);
			}else if (aString.length()==9) {
				System.out.println(aString.split("\\|")[0]);
			}else {
				System.out.println("短信验证码获取失败，VAL_LST为："+aString);
			}
			
			}
		} catch (SQLException e) {
			System.out.println("test findSimpleResult() is failed!");
			e.printStackTrace();
		}
	 }
	 
	 @Test
	 public void findMoreResult() {
		 sql="select * from CGDGW.T_NTC_EVTREC a "
			 		+ "where a.ntf_to=? and rownum<6";
			 params=new ArrayList<Object>();
			 params.add("18918182584");
			 try {
				 List<Map<String, Object>> list=jdbcUtil.findMoreResult(sql, params);
				 for(int i=0;i<list.size();i++) {
					 for (String key : list.get(i).keySet()) {
							System.out.print(key+">>"+list.get(i).get(key));
						}
					 System.out.println();
				 }
			 } catch (SQLException e) {
				System.out.println("test findMoreResult() failed!");
				e.printStackTrace();
			}
	  }
	
	 @Test
	 public void findMoreRefResult() {
	    throw new RuntimeException("Test not implemented");
	 }
	
	 @Test
	 public void findSimpleRefResult() {
	    throw new RuntimeException("Test not implemented");
	 }

}
