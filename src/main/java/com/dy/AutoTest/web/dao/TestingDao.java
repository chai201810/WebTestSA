package com.dy.AutoTest.web.dao;

import java.util.List;
import java.util.Map;

public interface TestingDao {
	
	/**
	 * 获取表的条数（待完成）
	 * @return
	 */
	int getCount();
	/**
	 * 获取表的ID（待完成）
	 * @return
	 */
	List<String> getDataIDs();
	
	Map<String,Object> getData(String tableName,String ID);
	
	List<Map<String, Object>> getLocator(String tableName);
	
//	boolean updateMerchantInfoStatusToPass(String merchantNO,String merchantName);
	
//	boolean updateMerchantInfoStatusToRefuse(String merchantName);
	
//	boolean updateMerchantNextSettlementDate(int ID,String NextSettlementDate);
	
//	boolean insertMerchantSettlementInfo(String merchantID,String merchantName);
	
//	boolean updateMerchantSettlementStatus(int ID, String status);
	
//	boolean updateMerchantNOByID(int ID, String merchantName);
	
//	boolean updateSettlementByID(int ID, Map<String, String> map);
	
//	boolean updateMerchantInfoByID(int ID, Map<String, String> map); 
	
//	boolean insertMerchantFeeRate(String merchantID,String merchantName);
	
//	boolean insertMerchantProduct(String merchantID,String merchantName);
//	boolean insertMerchantProduct(Map<String , Object> map);

//	Map<String,Object> querySingleMerchantProduct(List<String> list,Map<String , String>map);
	
	
	
	<T> T getData(String tableName,String ID,Class<T> cls);
	<T> List<T> getDataList(String tableName,Class<T> cls);
	Map<String,Object> querySingle(String tableName,List<String> selectList,Map<String , Object> whereMap);
	List<Map<String,Object>> queryMore(String tableName,List<String> selectList,Map<String , Object> whereMap);
	boolean updateTestData(String tableName,Map<String, Object> updateMap, Map<String, Object> whereMap);
	boolean updateTestData(String tableName,Map<String, Object> updateMap, Map<String, Object> whereMap,boolean existExpression);
	boolean insertTestData(String tableName,Map<String , Object> insertMap);
	
	
	boolean updateMerchantProductType(String productType, Map<String, Object> whereMap);
	
}
