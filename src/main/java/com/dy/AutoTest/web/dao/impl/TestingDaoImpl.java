package com.dy.AutoTest.web.dao.impl;


import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dy.AutoTest.web.actions.SingletonSet;
import com.dy.AutoTest.web.dao.TestingDao;
import com.dy.AutoTest.web.util.JdbcUtil;

/**
 * @author Jerry
 * 
 */
public class TestingDaoImpl implements TestingDao{

	private JdbcUtil jdbcUtil=null;
	private String sql=""; 
	private List<Object> params;
	
	public TestingDaoImpl() {
		jdbcUtil=SingletonSet.jdbcUtil_sqlite;
	}
	
	//为了小范围测试，设置一个特定的构造方法，测试时使用
	public TestingDaoImpl(boolean isTesting) {
		if (isTesting) {
			jdbcUtil=new JdbcUtil("sqlite");
		}else jdbcUtil=SingletonSet.jdbcUtil_sqlite;
	}
	
//	public TestingDao(String databaseName) {
//		jdbcUtil=new JdbcUtil(databaseName);
//	}
	
	
	/**
	 * 获取表的条数（待完成）
	 * @return
	 */
	public int getCount() {
		
		return 0;
	}
	
	
	
	/*********************Data***********************************/
	
	
	public  Map<String,Object> getData(String tableName,String ID){
		sql="select * from "+tableName+" ";
		if(tableName.equals("POP_Data_Oper")&&ID!="") {
			sql=sql+" where operID=? ";
		}else if(tableName!=""&&ID!="") {
			sql=sql+" where ID=? ";
		}else if(tableName=="") {
			System.out.println("tableName is not exist! Please check!");
			return null;
		}
		
		params=new ArrayList<Object>();
		if(ID!="")
			params.add(ID);
		Map<String, Object> map=null;
		try {
			map=jdbcUtil.findSimpleResult(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public  <T> T  getData(String tableName,String ID,Class<T> cls){
		
		if(ID.equals("")) {
			System.out.println("ID is null! Please check!");
			assertTrue(false);
		}
		if(tableName.equals("")) {
			System.out.println("TestingDao.getData: TableName is null! Please check!");
			assertTrue(false);
		}
		
		sql="select * from "+tableName+" ";
		if(tableName.equals("POP_Data_Oper")) {
			sql=sql+" where operID=? ";
		}else {
			sql=sql+" where ID=? ";
		}
		
		params=new ArrayList<Object>();
		params.add(ID);
		T resultObject = null;
		try {
				resultObject=jdbcUtil.findSimpleRefResult(sql, params, cls);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultObject;
	}
	
	public  <T> List<T> getDataList(String tableName,Class<T> cls){
		List<T> list=null;
		
		if(tableName.equals("")) {
			System.out.println("TableName is null! Please check!");
			assertTrue(false);
		}
		
		sql="select * from "+tableName;
		try {
			list=jdbcUtil.findMoreRefResult(sql, null, cls);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 获取表的ID（待完成）
	 * @return
	 */
	public List<String> getDataIDs() {
		
		return null;
	}
	
	/*********************Locator***********************************/
	
	public List<Map<String, Object>> getLocator(String tableName){
		sql="select * from "+tableName+" ";
		if(tableName=="") {
			System.out.println("tableName is null! Please check!");
			return null;
		}
//		params=new ArrayList<Object>();
		
		 List<Map<String, Object>> list=null;
		 try {
			 list=jdbcUtil.findMoreResult(sql, null);
		 }catch (SQLException e) {
				System.out.println("test jdbcUtil.findMoreResult() is failed!");
				e.printStackTrace();
		}
//		 jdbcUtil.releaseConn();
		return list;
		
	}

/*	@Override
	public boolean updateMerchantInfoStatusToPass(String merchantNO,String merchantName) {
		boolean flag=false;
		sql="update POP_Data_MerchantInfo set MerchantNO=? , AuditStatus='1' "
				+ "where A_MerchantName=?";
		params=new ArrayList<Object>();
		params.add(merchantNO);
		params.add(merchantName);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}*/

/*	@Override
	public boolean updateMerchantInfoStatusToRefuse(String merchantName) {
		boolean flag=false;
		sql="update POP_Data_MerchantInfo set AuditStatus='2' "
				+ "where A_MerchantName=?";
		params=new ArrayList<Object>();
		params.add(merchantName);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
*/
/*	@Override
	public boolean insertMerchantSettlementInfo(String merchantID, String merchantName) {
		boolean flag=false;
		sql="INSERT INTO POP_Data_MerchantSettlement (MerchantNO, MerchantName) " + 
				"VALUES(?,?);";
		params=new ArrayList<Object>();
		params.add(merchantID);
		params.add(merchantName);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}*/

/*	public boolean updateMerchantNextSettlementDate(int ID,String NextSettlementDate) {
		boolean flag=false;
		sql="update POP_Data_MerchantSettlement set NextSettlementDate=? "
				+ "where ID=?";
		params=new ArrayList<Object>();
		params.add(NextSettlementDate);
		params.add(ID);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
*/
	/*public boolean updateMerchantSettlementStatus(int ID, String status) {
		boolean flag=false;
		sql="update POP_Data_MerchantSettlement set Status=? "
				+ "where ID=?";
		params=new ArrayList<Object>();
		params.add(status);
		params.add(ID);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}*/
	
	/*public boolean updateMerchantNOByID(int ID, String merchantNO) {
		boolean flag=false;
		sql="update POP_Data_MerchantSettlement set merchantNO=? "
				+ "where ID=?";
		params=new ArrayList<Object>();
		params.add(merchantNO);
		params.add(ID);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}*/
	/*
	public boolean updateSettlementByID(int ID, Map<String, String> map) {
		boolean flag=false;
		sql="update POP_Data_MerchantSettlement set ";
		params=new ArrayList<Object>();
		if(map==null) {
			System.out.println("In DataBusiness.updateSettlementByID(), map can not be null!");
			assertTrue(false);
		}
		int i=0;
		for (Map.Entry<String, String> entry : map.entrySet()) { 
				sql+=entry.getKey()+"=?";
				if(i<map.size()-1) 
					sql+=",";
				params.add(entry.getValue());
				i++;
			}
		sql+=" where ID=?";
		params.add(ID);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	*/
/*	public boolean updateMerchantInfoByID(int ID, Map<String, String> map) {
		boolean flag=false;
		sql="update POP_Data_MerchantInfo set ";
		params=new ArrayList<Object>();
		
		int i=0;
		for (Map.Entry<String, String> entry : map.entrySet()) { 
				sql+=entry.getKey()+"=?";
				if(i<map.size()-1) 
					sql+=",";
				params.add(entry.getValue());
				i++;
			}
		sql+=" where ID=?";
		params.add(ID);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
*/
	/*
	@Override
	public boolean insertMerchantFeeRate(String merchantID, String merchantName) {
		boolean flag=false;
		sql="INSERT INTO POP_Data_MerchantFeeRate (MerchantNO, MerchantName) " + 
				"VALUES(?,?);";
		params=new ArrayList<Object>();
		params.add(merchantID);
		params.add(merchantName);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}*/
/*
	@Override
	public boolean insertMerchantProduct(String merchantID, String merchantName) {
		boolean flag=false;
		sql="INSERT INTO POP_Data_MerchantProduct (MerchantNO, MerchantName) " + 
				"VALUES(?,?);";
		params=new ArrayList<Object>();
		params.add(merchantID);
		params.add(merchantName);
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
*/
/*	
	@Override
	public boolean insertMerchantProduct(Map<String , Object> insertMap) {
		boolean flag=false;
		sql= "INSERT INTO POP_Data_MerchantProduct(";
		String temp=" VALUES(";
		params=new ArrayList<>();
		int i=0;
		for (Map.Entry<String, Object> entry : insertMap.entrySet()){
			sql+=entry.getKey();
			temp+="?";
			if(i<insertMap.size()-1) {
				sql+=",";
				temp+=",";
			}
			params.add(entry.getValue());
			i++;
		}
		sql+=")"+temp+")";
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	*/
	
	/*@Override
	public Map<String, Object> querySingleMerchantProduct(List<String> list, Map<String, String> map) {
		String fields="";
		for(int i=0;i<list.size();i++) {
			fields+=list.get(i);
			if(i<list.size()-1) fields+=",";
		}
		sql="select "+fields+" from POP_Data_MerchantProduct";
		params=new ArrayList<Object>();
		if(!map.isEmpty()) {
			sql+=" where ";
			int i=0;
			for (Map.Entry<String, String> entry : map.entrySet()) { 
				sql+=entry.getKey()+"=?";
				if(i<map.size()-1) 
					sql+=" and ";
				params.add(entry.getValue());
				i++;
			}
		}
		Map<String, Object> result=null;
		try {
			result=jdbcUtil.findSimpleResult(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
*/
	public Map<String, Object> querySingle(String tableName, List<String> selectList, Map<String, Object> whereMap) {
		String fields="";
		for(int i=0;i<selectList.size();i++) {
			fields+=selectList.get(i);
			if(i<selectList.size()-1) fields+=",";
		}
		sql="select "+fields+" from "+tableName;
		params=new ArrayList<Object>();
		if(whereMap!=null && !whereMap.isEmpty()) {
			sql+=" where ";
			int i=0;
			for (Map.Entry<String, Object> entry : whereMap.entrySet()) { 
				sql+=entry.getKey()+"=?";
				if(i<whereMap.size()-1) 
					sql+=" and ";
				params.add(entry.getValue());
				i++;
			}
		}
		Map<String, Object> result=null;
		try {
			result=jdbcUtil.findSimpleResult(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> queryMore(String tableName, List<String> selectList,
			Map<String, Object> whereMap) {
		String fields="";
		for(int i=0;i<selectList.size();i++) {
			fields+=selectList.get(i);
			if(i<selectList.size()-1) fields+=",";
		}
		sql="select "+fields+" from "+tableName;
		params=new ArrayList<Object>();
		if(whereMap!=null && !whereMap.isEmpty()) {
			sql+=" where ";
			int i=0;
			for (Map.Entry<String, Object> entry : whereMap.entrySet()) { 
				sql+=entry.getKey()+"=?";
				if(i<whereMap.size()-1) 
					sql+=" and ";
				params.add(entry.getValue());
				i++;
			}
		}
		List<Map<String, Object>> result=null;
		try {
			result=jdbcUtil.findMoreResult(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateTestData(String tableName, Map<String, Object> updateMap, Map<String, Object> whereMap) {
		boolean flag=false;
		sql="update "+tableName+" set ";
		params=new ArrayList<Object>();
		int i=0;
		for (Map.Entry<String, Object> entry : updateMap.entrySet()) { 
			sql+=entry.getKey()+"=?";
			if(i<updateMap.size()-1) 
				sql+=",";
			params.add(entry.getValue());
			i++;
		}
		if(whereMap!=null && !whereMap.isEmpty()) {
			sql+=" where ";
			i=0;
			for(Map.Entry<String , Object> entry:whereMap.entrySet()) {
				sql+=entry.getKey()+"=?";
				if(i<whereMap.size()-1) {
					sql+=" and ";
				}
				params.add(entry.getValue());
				i++;
			}
		}
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean updateTestData(String tableName,Map<String, Object> updateMap, Map<String, Object> whereMap,boolean existExpression) {
		boolean flag=false;
		sql="update "+tableName+" set ";
		params=new ArrayList<Object>();
		int i=0;
		for (Map.Entry<String, Object> entry : updateMap.entrySet()) { 
			sql+=entry.getKey();
			if(existExpression && !entry.getValue().equals("")) {
				sql+="=?";
				if(i<updateMap.size()-1) 
					sql+=",";
				params.add(entry.getValue());
			}
			i++;
		}
		if(whereMap!=null && !whereMap.isEmpty()) {
			sql+=" where ";
			i=0;
			for(Map.Entry<String , Object> entry:whereMap.entrySet()) {
				sql+=entry.getKey()+"=?";
				if(i<whereMap.size()-1) {
					sql+=" and ";
				}
				params.add(entry.getValue());
				i++;
			}
		}
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean insertTestData(String tableName, Map<String, Object> insertMap) {
		boolean flag=false;
		sql= "INSERT INTO "+tableName+" (";
		String temp=" VALUES(";
		params=new ArrayList<Object>();
		int i=0;
		for (Map.Entry<String, Object> entry : insertMap.entrySet()){
			sql+=entry.getKey();
			temp+="?";
			if(i<insertMap.size()-1) {
				sql+=",";
				temp+=",";
			}
			params.add(entry.getValue());
			i++;
		}
		sql+=")"+temp+")";
		try {
			flag=jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateMerchantProductType(String productType, Map<String, Object> whereMap) {
		sql="UPDATE POP_Data_MerchantProduct SET "
				+ "ProductType=ProductType||','||"+productType;
		
		if(whereMap!=null && !whereMap.isEmpty()) {
			sql+=" where ";
			int i=0;
			for(Map.Entry<String , Object> entry:whereMap.entrySet()) {
				sql+=entry.getKey()+"=?";
				if(i<whereMap.size()-1) {
					sql+=" and ";
				}
				params.add(entry.getValue());
				i++;
			}
		}
		return false;
	}


	
	/*
	public List<Map<String, Object>> getLoginPageLocator(){
		return getLocator("POP_Loc_LoginPage");
	}
	
	public List<Map<String, Object>> getMainMenuPageLocator(){
		return getLocator("POP_Loc_MainMenuPage");
	}
	
	public List<Map<String, Object>> getMerchantInsertLocator(){
		return getLocator("POP_Loc_MerchantInsert");
	}
	*/
	
}
