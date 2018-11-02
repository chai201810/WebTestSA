package com.dy.AutoTest.OperationPlatform.TestCases.MerchantManagementOnLine.OnLineMechantInfo;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OperationPlatform.POJO.MerchantSettlementBean;
import com.dy.AutoTest.OperationPlatform.PageObject.MerchantManagementOnLine.OnLineMerchantInfo.MerchantSettlementPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.actions.SingletonSet;
import com.dy.AutoTest.web.business.DataBusiness;

/**
 * @author Jerry
 * @description
 * Process of Testing MerchantInfoInsert:
 * 	- Get url from Database ;
 * 	- Load dataProvider ;
 * 	- 两种方式搜索到指定商户：通过MerchantNO；通过MerchantName;
 * 	- 判断该商户状态是否可以被新增、修改、查询
 * 	- 新增流程，注意：起始日期需要取当前会计日期，"下一个结算日期"也需要取当前会计日期，早了无效；日期js需要失焦
 *  - Assert Notice is or not equal/contains expected value ;
 * 	- If true , insert new record in table "POP_Data_MerchantSettlement"
 * 
 */
public class MerchantSettlementPageTest extends SuperTest{
	
	MerchantSettlementPage merchantSettlementPage;
	String URL;
	
	
	@BeforeClass
	public void init() {
		merchantSettlementPage=new MerchantSettlementPage(driver);
		URL=host.toString()+DataBusiness.getData_URL("pop_OnlineMerchantSettlementInsert");
	}
	
	@DataProvider(name="SettlementInfo")
	protected static Object[][] parametersPoolForSqlite(){
		data.loadDataBeanList("POP_Data_MerchantSettlement");
		return data.getDataBeanArray();
	}
	
	/**
	 * @param merchantSettlementBean
	 * 商户结算信息新增
	 */
	@Test(dataProvider="SettlementInfo")
	public void testMerchantSettlementInsert(MerchantSettlementBean merchantSettlementBean) {
		//跳转商户结算页面
		merchantSettlementPage.navigateTo(URL);
		//如果数据中商户号和商户名都为空，直接打断测试
		if(merchantSettlementBean.getMerchantNO().equals("")
				&&merchantSettlementBean.getMerchantName().equals("")) {
			System.out.println("Both of NO and Name is null! Please check (SQLite--POP_Data_MerchantSettlement) ID= "+merchantSettlementBean.getID());
			Reporter.log("Both of NO and Name is null! Please check (SQLite--POP_Data_MerchantSettlement) ID= "+merchantSettlementBean.getID());

			assertTrue(false);
		}//如果商户号为空，使用商户名去搜索商户
		else if(!merchantSettlementBean.getMerchantNO().equals("")) {
			merchantSettlementPage.setMerchantNO(merchantSettlementBean.getMerchantNO());
		}//如果商户号不为空，设置商户号
		else {
			merchantSettlementPage.setMerchantNOByName(merchantSettlementBean.getMerchantName());
		}
		//查询结算信息
		merchantSettlementPage.doQuery();
		
		//判断是否可以新增结算信息
		String merchantNO=merchantSettlementPage.getMerchantNO();
		assertTrue(merchantSettlementPage.isSettlementInfoAddEnable()); 
		
		//插入当前会计日期为下个结算日期
		Map<String , Object > updateMap=new HashMap<>();
		if(merchantSettlementBean.getNextSettlementDate().equals("")){
			updateMap.put("NextSettlementDate", SingletonSet.CurrentAccountantDate.toString());
		}
		//插入当前会计日期为结算开始日期
		if(merchantSettlementBean.getSettlement_StartDate().equals("")){
			updateMap.put("Settlement_StartDate", SingletonSet.CurrentAccountantDate.toString());
		}
		//如果商户号为空，更新商户号
		if(merchantSettlementBean.getMerchantNO().equals("")) {
			updateMap.put("MerchantNO", merchantNO);
		}
		if(!updateMap.isEmpty()) {
//			data.updateSettlementByID(merchantSettlementBean.getID(),updateMap);
			Map<String , Object> whereMap=new HashMap<>();
			whereMap.put("ID", merchantSettlementBean.getID());
			DataBusiness.updateTestData("POP_Data_MerchantSettlement", updateMap, whereMap);
		}
		
		merchantSettlementPage.setBankName(merchantSettlementBean.getBankName());
		merchantSettlementPage.setSubBankBelongProvice(merchantSettlementBean.getSubBankBelongProvice());
		merchantSettlementPage.setSubBankBelongCity(merchantSettlementBean.getSubBankBelongCity());
		merchantSettlementPage.setSubBankInfo(merchantSettlementBean.getSubBankInfo());
		
		merchantSettlementPage.setAccount(merchantSettlementBean.getAccount());
		merchantSettlementPage.setAccountName(merchantSettlementBean.getAccountName());
		
		merchantSettlementPage.setSettlementCycle(merchantSettlementBean.getSettlementCycle());
		merchantSettlementPage.setSettlementDays(merchantSettlementBean.getSettlementDays());
		
		merchantSettlementPage.setNextSettlementDate(merchantSettlementBean.getNextSettlementDate());
		merchantSettlementPage.setSettlement_StartDate(merchantSettlementBean.getSettlement_StartDate());
		merchantSettlementPage.setSettlement_ExpireDate(merchantSettlementBean.getSettlement_ExpireDate());
				merchantSettlementPage.doLoseFocus();
		
		merchantSettlementPage.setStart_Amount(merchantSettlementBean.getStart_Amount());
		merchantSettlementPage.setMinimum_Amount(merchantSettlementBean.getMinimum_Amount());
		
		merchantSettlementPage.doButton_Submit();
		
		if(merchantSettlementPage.getNotice().contains("成功")) {
			Map<String , Object > updateMap2 =new HashMap<>();
			updateMap2.put("Status", "0");
//			data.updateSettlementByID(merchantSettlementBean.getID(), map2);
			Map<String , Object> whereMap2=new HashMap<>();
			whereMap2.put("ID", merchantSettlementBean.getID());
			DataBusiness.updateTestData("POP_Data_MerchantSettlement", updateMap2, whereMap2);
		}else {
			System.out.println(merchantSettlementPage.getNotice());
			Reporter.log(merchantSettlementPage.getNotice());
			assertTrue(false);
		}
		
	}
	
	
	
}
