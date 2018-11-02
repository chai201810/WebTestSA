package com.dy.AutoTest.web.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dy.AutoTest.web.actions.SingletonSet;
import com.dy.AutoTest.web.dao.OperDao;
import com.dy.AutoTest.web.util.JdbcUtil;

public class OperDaoImpl implements OperDao {
	private String sql="";
	private List<Object> params;
	private JdbcUtil jdbcUtil=SingletonSet.jdbcUtil_oracle;

	public String getPOPLoginVAL_LST(String operMobileNo) {
		String VAL_LST="";
		try {	
			sql="select val_lst from " + 
					"(select * from CGDGW.T_NTC_EVTREC a where a.NTF_TO=? order BY TM_SMP DESC)" + 
					"where rownum <= 1";
			params=new ArrayList<Object>();
			params.add(operMobileNo);
			Map<String, Object> map=jdbcUtil.findSimpleResult(sql, params);
			VAL_LST=(String)map.get("VAL_LST");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return VAL_LST;
	}
	
}
