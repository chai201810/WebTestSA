package com.dy.AutoTest.web.business.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.dy.AutoTest.OperationPlatform.POJO.MerchantAuditBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantFeeRateBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantInfoBean;
import com.dy.AutoTest.OperationPlatform.POJO.OperBean;
import com.dy.AutoTest.web.beans.Data_URLBean;
import com.dy.AutoTest.web.business.DataBusiness;


public class DataBusinessTest {
	
	private DataBusiness dataBusiness=new DataBusiness();
	
	
	@Test
	public void testGetData_URLBean() {
		dataBusiness.loadData("Data_URL", "pop_uat");
		Data_URLBean data_URLBean =dataBusiness.getData_URLBean();
		data_URLBean.displayInfo();
	}
	
/*	@Test
	public void testGetOperBean() {
		dataBusiness.loadData("POP_Data_Oper", "T00107");
		OperBean operBean=dataBusiness.getOperBean();
		operBean.displayInfo();
		
	}
	*/
	@Test
	public void testGetMerchantInfoData() {
/*		dataBusiness.loadData("POP_Data_MerchantInfo", "1");
		MerchantInfoBean merchantInfoBean=dataBusiness.getMerchantInfoBean();
		merchantInfoBean.displayInfo();
		*/
	}

/*	@Test
	public void testGetMerchantAuditBean() {
		dataBusiness.loadData("POP_Data_MerchantAudit", "1");
		MerchantAuditBean merchantAuditBean =dataBusiness.getMerchantAuditBean();
		merchantAuditBean.displayInfo();
	}*/
	
	@Test
	public void testGetData_URL() {
		System.out.println(DataBusiness.getData_URL("pop_uat"));
		
	}
	
/*	@Test
	public void testUpdateMerchantInfoStatusToPass() {
		dataBusiness.updateMerchantInfoStatusToPass("123test", "线上Auto_1");
	}*/
	
/*	@Test
	public void testInsertMerchantSettlementInfo() {
		dataBusiness.insertMerchantSettlementInfo("1234", "test");
	}
	*/
/*	@Test
	public void testUpdateMerchantNextSettlementDate() {
		dataBusiness.updateMerchantNextSettlementDate(123, "test");
	}*/
/*	@Test
	public void testUpdateMerchantSettlementStatus() {
		dataBusiness.updateMerchantSettlementStatus(100, "1");
	}*/
/*	@Test
	public void testUpdateMerchantNOByID() {
		dataBusiness.updateMerchantNOByID(1, "11111");
	}*/
	/*@Test
	public void testUpdateSettlementByID() {
		Map<String , String >map=new HashMap<String ,String >();
		map.put("MerchantNO", "T00001");
		map.put("MerchantName", "T00001");

		dataBusiness.updateSettlementByID(3, map);
	}*/
/*	@Test
	public void testInsertMerchantFeeRate() {
		dataBusiness.insertMerchantFeeRate("abc", "11111");
	}
	*/
	@Test
	public void testLoadDataRef() {
//		MerchantSettlementBean merchantSettlementBean=dataBusiness.getDataBean("POP_Data_MerchantSettlement", "1");
//		merchantSettlementBean.displayInfo();
		MerchantFeeRateBean merchantFeeRateBean=dataBusiness.getDataBean("POP_Data_MerchantFeeRate", "1");
		merchantFeeRateBean.displayInfo();
	}
	
	
	@Test
	public void testGetMerchantSettlementBean() {
//		dataBusiness.loadDataRef("POP_Data_MerchantSettlement", "1"); 
//		MerchantSettlementBean merchantSettlementBean=dataBusiness.getMerchantSettlementBean();

//		dataBusiness.loadData("POP_Data_MerchantSettlement", "1");
//		MerchantSettlementBean merchantSettlementBean=dataBusiness.getMerchantSettlementBean();
		
//		merchantSettlementBean.displayInfo();
	}
	
	@Test
	public void testGetDataBeanArray() {
/*		dataBusiness.loadDataBeanList("POP_Data_MerchantSettlement");
		Object[][] aObjects=dataBusiness.getDataBeanArray();
		for(int i=0;i<aObjects.length;i++){
			MerchantSettlementBean merchantSettlementBean=(MerchantSettlementBean)aObjects[i][0];
			System.out.println(merchantSettlementBean.getAccount());
		}*/
	/*	dataBusiness.loadDataBeanList("POP_Data_MerchantFeeRate");
		Object[][] aObjects=dataBusiness.getDataBeanArray();
		for(int i=0;i<aObjects.length;i++){
			MerchantFeeRateBean MerchantFeeRateBean=(MerchantFeeRateBean)aObjects[i][0];
			System.out.println(MerchantFeeRateBean.getMerchantNO());
		}*/
		dataBusiness.loadDataBeanList("POP_Data_MerchantInfo");
		Object[][] aObjects=dataBusiness.getDataBeanArray();
		for(int i=0;i<aObjects.length;i++){
			MerchantInfoBean MerchantInfoBean=(MerchantInfoBean)aObjects[i][0];
			System.out.println(MerchantInfoBean.getA_MerchantName());
		}
		
	}
/*	@Test
	public void testQueryMerchantProductByNO() {
		List<String > list=new ArrayList<>();
		Map<String , String> map=new HashMap<>();
		list.add("ProductType");
		map.put("MerchantNO", "872290059475007");
		Map<String, Object> result=dataBusiness.querySingleMerchantProduct(list, map);
		
		System.out.println(result);
	}*/
/*	@Test
	public void testInsertMerchantProduct() {
		Map<String , Object> map=new HashMap<>();
		map.put("MerchantNO", "1111");
		map.put("MerchantName", "1111");
		map.put("ProductType", "1111");
		dataBusiness.insertMerchantProduct(map);
	}
	*/
	@Test
	public void testQuerySingle() {
		List<String> selectList=new ArrayList<>();
		Map<String, Object> whereMap=new HashMap<>();
		selectList.add("*");
		whereMap.put("ID", 7);
		System.out.println(DataBusiness.querySingle("POP_Data_MerchantProduct", selectList, whereMap));
	}
	
	@Test
	public void testQueryMore() {
		List<String> selectList=new ArrayList<>();
		Map<String, Object> whereMap=new HashMap<>();
		selectList.add("*");
		System.out.println(DataBusiness.queryMore("POP_Data_MerchantProduct", selectList, whereMap));
	}
	
	
	@Test
	public void testUpdateTestData() {
		Map<String, Object> updateMap=new HashMap<>();
		Map<String, Object> whereMap=new HashMap<>();
		updateMap.put("MerchantName", "123");
		updateMap.put("ProductType", "xxx");
		whereMap.put("ID", 7);
		DataBusiness.updateTestData("POP_Data_MerchantProduct", updateMap, whereMap);
	}
	
	
	@Test
	public void testInsertTestData() {
		Map<String, Object> insertMap=new HashMap<>();
		insertMap.put("MerchantName", "123");
		insertMap.put("ProductType", "xxx");
		DataBusiness.insertTestData("POP_Data_MerchantProduct", insertMap);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
