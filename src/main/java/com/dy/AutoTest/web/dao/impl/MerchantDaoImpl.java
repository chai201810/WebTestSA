package com.dy.AutoTest.web.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dy.AutoTest.web.actions.SingletonSet;
import com.dy.AutoTest.web.dao.MerchantDao;
import com.dy.AutoTest.web.util.JdbcUtil;

public class MerchantDaoImpl implements MerchantDao {
	private String sql="";
	private List<Object> params;
	private JdbcUtil jdbcUtil=SingletonSet.jdbcUtil_oracle;
	
	
	public String getMerchantNOByName(String merchantName) {
		String merchantNO="";
		
		sql="select a.MERC_ID from GSDPAY.T_URM_MINF a "
				+ "where a.MERC_CNM=?";
		params=new ArrayList<Object>();
		params.add(merchantName);
		try {
			Map<String, Object> map=jdbcUtil.findSimpleResult(sql, params);
			merchantNO=(String)map.get("MERC_ID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return merchantNO;
	}
	
	
	
	
	

}
