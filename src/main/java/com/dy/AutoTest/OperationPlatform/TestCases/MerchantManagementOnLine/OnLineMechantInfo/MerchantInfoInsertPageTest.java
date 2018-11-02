package com.dy.AutoTest.OperationPlatform.TestCases.MerchantManagementOnLine.OnLineMechantInfo;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OperationPlatform.POJO.MerchantInfoBean;
import com.dy.AutoTest.OperationPlatform.PageObject.MerchantManagementOnLine.OnLineMerchantInfo.MerchantInfoInsertPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.business.DataBusiness;

/**
 * @author Jerry
 * @description
 * Process of Testing MerchantInfoInsert:
 * 	- Get url from Database ;
 *  - Load dataProvider ;
 *  - Set merchant basic info ;
 *  	注意该模块日期js的失去焦点操作
 *  	注意该模块元素较多，需要配合上翻页下翻页调整，不然元素取不到
 * 	- Set store info ;
 * 		注意营业时间的数据格式，不满足格式的提交是不成功的
 * 	- Set Staff Info ;
 * 		注意该模块日期js的失去焦点操作
 *  	注意该模块元素较多，需要配合上翻页下翻页调整，不然元素取不到
 * 	- Set Addition Info ;
 * 	- Assert Notice is or not equal/contains expected value ;
 * 	- If true , insert new record in table "POP_Data_MerchantSettlement"
 */
public class MerchantInfoInsertPageTest extends SuperTest{ 
	
	private MerchantInfoInsertPage merchentInfoInsertPage;
	private String URL="";
	
	@BeforeClass
	public void init() {
		merchentInfoInsertPage=new MerchantInfoInsertPage(driver);
		URL=host.toString()+DataBusiness.getData_URL("pop_OnlineMerchantInfoInsert");
	}
	@DataProvider(name="merchantInfoInsert")
	protected static Object[][] parametersPool(){
		data.loadDataBeanList("POP_Data_MerchantInfo");
		return data.getDataBeanArray();
	}
	
	@Test(dataProvider="merchantInfoInsert")
	public void testMerchantInfoInsert(MerchantInfoBean merchantInfoBean) {
		
		merchentInfoInsertPage.navigateTo(URL);
//		merchentInfoInsertPage.set1BasicInfo();
//			merchentInfoInsertPage.set11BasicInofInsertArea();
				merchentInfoInsertPage.set111A_MerchantType(merchantInfoBean.getA_MerchantType());
				
				merchentInfoInsertPage.set112A_MerchantName(merchantInfoBean.getA_MerchantName());
				merchentInfoInsertPage.set113A_shortName(merchantInfoBean.getA_shortName());
				
				merchentInfoInsertPage.set114A_mcc_super(merchantInfoBean.getA_mcc_super());
				
				merchentInfoInsertPage.set115A_mcc(merchantInfoBean.getA_mcc());
				
				merchentInfoInsertPage.set116A_Province(merchantInfoBean.getA_Province());
				
				merchentInfoInsertPage.set117A_City(merchantInfoBean.getA_City());
				
				merchentInfoInsertPage.set118A_Business_Address(merchantInfoBean.getA_Business_Address());
				
			merchentInfoInsertPage.set11BasicInofInsertArea();
			
			merchentInfoInsertPage.set12Account_Permits();
			
				merchentInfoInsertPage.set121A_Account_Permits(merchantInfoBean.getA_Account_Permits());
				
			merchentInfoInsertPage.set13BusOrgTaxCorpInsertArea();
			
				merchentInfoInsertPage.set131A_Merchant_Property(merchantInfoBean.getA_Merchant_Property());
				
				merchentInfoInsertPage.set132A_Business_License(merchantInfoBean.getA_Business_License());
				
				merchentInfoInsertPage.set133A_Business_License_StartDate(merchantInfoBean.getA_Business_License_StartDate());
				
				merchentInfoInsertPage.set133A_Business_License_ExpiredDate(merchantInfoBean.getA_Business_License_ExpiredDate());
				
				merchentInfoInsertPage.set134A_Business_Scope(merchantInfoBean.getA_Business_Scope());
				
//						//让js日期控件失去焦点
//						merchentInfoInsertPage.do130LoseFocus();
						merchentInfoInsertPage.doLoseFocus("A_Business_License_StartDate",0,-20);
						
						//向下翻页
//						merchentInfoInsertPage.doPageDown();
						
						merchentInfoInsertPage.doDown();
						
						merchentInfoInsertPage.doDown();
						
						merchentInfoInsertPage.doDown();
						
				merchentInfoInsertPage.set135A_Registered_Capital(merchantInfoBean.getA_Registered_Capital());
				
				merchentInfoInsertPage.set136A_Registered_Address(merchantInfoBean.getA_Registered_Address());
				
				merchentInfoInsertPage.set137A_Organization_Code(merchantInfoBean.getA_Organization_Code());
				
				merchentInfoInsertPage.set138A_Tax_Registration_Certificate(merchantInfoBean.getA_Tax_Registration_Certificate());
				
				merchentInfoInsertPage.set139A_CorpName(merchantInfoBean.getA_CorpName());
				
				merchentInfoInsertPage.set1310A_CorpID_Type(merchantInfoBean.getA_CorpID_Type());
				
				merchentInfoInsertPage.set1311A_CorpID(merchantInfoBean.getA_CorpID());
				
				merchentInfoInsertPage.set1312A_CopID_StartDate(merchantInfoBean.getA_CopID_StartDate());
				
				merchentInfoInsertPage.set1312A_CopID_ExpiredDate(merchantInfoBean.getA_CopID_ExpiredDate());
				

						//让js日期控件失去焦点
//						merchentInfoInsertPage.do130LoseFocus();
						merchentInfoInsertPage.doLoseFocus("A_CopID_StartDate",-80,0);
						
						//向上翻页
						merchentInfoInsertPage.doPageUp();
						
			//菜单太长，需要回收
			merchentInfoInsertPage.set13BusOrgTaxCorpInsertArea();
				
		merchentInfoInsertPage.set2StoreInfo();
				merchentInfoInsertPage.set21B_StoreName(merchantInfoBean.getB_StoreName());
				
				merchentInfoInsertPage.set22B_StoreShortName(merchantInfoBean.getB_StoreShortName());
				
				merchentInfoInsertPage.set23B_Store_Address(merchantInfoBean.getB_Store_Address());
				
				merchentInfoInsertPage.set24B_Store_PhoneNO(merchantInfoBean.getB_Store_PhoneNO());
				
				merchentInfoInsertPage.set25B_Business_Hours(merchantInfoBean.getB_Business_Hours());
				
		merchentInfoInsertPage.set3StaffInfo();
		
			merchentInfoInsertPage.set32ControllerInfo();
			
				merchentInfoInsertPage.set321C_Controller_Type(merchantInfoBean.getC_Controller_Type());
				
				merchentInfoInsertPage.set322C_ControllerName(merchantInfoBean.getC_ControllerName());
				
				merchentInfoInsertPage.set323C_ControllerID_Type(merchantInfoBean.getC_ControllerID_Type());
				
				merchentInfoInsertPage.set324C_ControllerID(merchantInfoBean.getC_ControllerID());
				
				merchentInfoInsertPage.set325C_ControlleID_StartDate(merchantInfoBean.getC_ControlleID_StartDate());
				
				merchentInfoInsertPage.set325C_ControlleID_ExpiredDate(merchantInfoBean.getC_ControlleID_ExpiredDate());
				
			merchentInfoInsertPage.set33Stakeholder();
			
				merchentInfoInsertPage.set331C_Stakeholder_Type(merchantInfoBean.getC_Stakeholder_Type());
				
				merchentInfoInsertPage.set332C_StakeholderName(merchantInfoBean.getC_StakeholderName());
				
				merchentInfoInsertPage.set333C_StakeholderID_Type(merchantInfoBean.getC_StakeholderID_Type());
				
				merchentInfoInsertPage.set334C_StakeholderID(merchantInfoBean.getC_StakeholderID());
				
				merchentInfoInsertPage.set335C_Stakeholder_StartDate(merchantInfoBean.getC_Stakeholder_StartDate());
				
				merchentInfoInsertPage.set335C_Stakeholder_ExpiredDate(merchantInfoBean.getC_Stakeholder_ExpiredDate());
				
			merchentInfoInsertPage.set33Stakeholder();
			
		merchentInfoInsertPage.set4AggreementInfo();
		
				merchentInfoInsertPage.set41D_Introduce_Channel(merchantInfoBean.getD_Introduce_Channel());
				
				merchentInfoInsertPage.set41D_Introduce_Channel(merchantInfoBean.getD_Introduce_Channel());
				
				merchentInfoInsertPage.set42D_AgreementNO(merchantInfoBean.getD_AgreementNO());
				
				merchentInfoInsertPage.set43D_AgreementExpiredDate(merchantInfoBean.getD_AgreementExpiredDate());
				
							merchentInfoInsertPage.doLoseFocus("D_AgreementExpiredDate",50,0);
							
				merchentInfoInsertPage.set44D_HandlerName(merchantInfoBean.getD_HandlerName());
				
				merchentInfoInsertPage.set45D_HandlerID_Type(merchantInfoBean.getD_HandlerID_Type());
				
				merchentInfoInsertPage.set46D_HandlerID(merchantInfoBean.getD_HandlerID());
				
				merchentInfoInsertPage.set47D_Handler_StartDate(merchantInfoBean.getD_Handler_StartDate());
				
				merchentInfoInsertPage.set47D_Handler_ExpiredDate(merchantInfoBean.getD_Handler_ExpiredDate());
				
							merchentInfoInsertPage.doLoseFocus("D_Handler_ExpiredDate",50,0);
							
							//向下翻页
							merchentInfoInsertPage.doPageUp();
							
		merchentInfoInsertPage.set5InvoiceInfo();
		
		
		merchentInfoInsertPage.set6ReconciliationInfo();
		
		
		merchentInfoInsertPage.set7PhotocopyRes();
		
		merchentInfoInsertPage.set8AdditionInfo();
		
				merchentInfoInsertPage.set81H_MerchantAdminName(merchantInfoBean.getH_MerchantAdminName());
				
				merchentInfoInsertPage.set82H_MerchantAdmin_MobileNO(merchantInfoBean.getH_MerchantAdmin_MobileNO());
				
				merchentInfoInsertPage.set83H_MerchantAdmin_Email(merchantInfoBean.getH_MerchantAdmin_Email());
				
				merchentInfoInsertPage.set84H_MerchantInterfaceType(merchantInfoBean.getH_MerchantInterfaceType());
				
				merchentInfoInsertPage.set85submit();
		
		if(merchentInfoInsertPage.getNotice().contains("新增商户信息成功")) {
			System.out.println("新增商户 "+merchantInfoBean.getA_MerchantName()+" 成功，等待审核");
//			Map<String ,String > map=new HashMap<String , String >();
//			map.put("AuditStatus", "");
//			data.updateMerchantInfoByID(merchantInfoBean.getID(), map);
		}else {
			System.out.println(merchentInfoInsertPage.getNotice());
		}
			
	}
	
}
