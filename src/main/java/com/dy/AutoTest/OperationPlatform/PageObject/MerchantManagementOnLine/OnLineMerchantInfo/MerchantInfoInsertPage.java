package com.dy.AutoTest.OperationPlatform.PageObject.MerchantManagementOnLine.OnLineMerchantInfo;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;

public class MerchantInfoInsertPage extends SuperPage{

	public MerchantInfoInsertPage(WebDriver driver) {
		super(driver);
		du.loadLocator("POP_Loc_OnlineMerchantInsert");
	} 
	@Override
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_OnlineMerchantInsert");
	}
	
	/**
	 * 为了让日期js失去焦点（无法实现，必须click元素才能失去焦点）
	 * @param locationName
	 */
	public void doLoseFocus(String locationName) {
		du.doLeftClickBy(locationName, 0, -20);
	}
	public void doLoseFocus(String locationName,int xOffset,int yOffset) {
		du.doLeftClickBy(locationName, xOffset, yOffset);
	}
	
	public void set1BasicInfo() {
		du.what("BasicInfo").click();
	}
			public void set11BasicInofInsertArea() {
				du.what("BasicInofInsertArea").click();
			}
					public void set111A_MerchantType(String A_MerchantType) {
						du.whatSelect("A_MerchantType").selectByValue(A_MerchantType);
					}
					public void set112A_MerchantName(String A_MerchantName) {
						du.what("A_MerchantName").sendKeys(A_MerchantName);
					}
					public void set113A_shortName(String A_shortName) {
						du.what("A_shortName").sendKeys(A_shortName);
					}
					public void set114A_mcc_super(String A_mcc_super) {
						du.whatSelect("A_mcc_super").selectByValue(A_mcc_super);
					}
					public void set115A_mcc(String A_mcc) {
						du.whatSelect("A_mcc").selectByValue(A_mcc);
					}
					public void set116A_Province(String A_Province) {
						du.whatSelect("A_Province").selectByValue(A_Province);
					}
					public void set117A_City(String A_City) {
						du.whatSelect("A_City").selectByValue(A_City);
					}
					public void set118A_Business_Address(String A_Business_Address) {
						du.what("A_Business_Address").sendKeys(A_Business_Address);
					}
		
			
			public void set12Account_Permits() {
				du.what("Account_Permits").click();
			}
					public void set121A_Account_Permits(String A_Account_Permits) {
						du.what("A_Account_Permits").sendKeys(A_Account_Permits);
					}
			public void set13BusOrgTaxCorpInsertArea() {
				du.what("BusOrgTaxCorpInsertArea").click();
			}
		
					public void set131A_Merchant_Property(String A_Merchant_Property) {
						du.whatSelect("A_Merchant_Property").selectByValue(A_Merchant_Property);
					}
					public void set132A_Business_License(String A_Business_License) {
						du.what("A_Business_License").sendKeys(A_Business_License);
					}
					public void set133A_Business_License_StartDate(String A_Business_License_StartDate) {
						du.what("A_Business_License_StartDate").sendKeys(A_Business_License_StartDate);
					}
					public void set133A_Business_License_ExpiredDate(String A_Business_License_ExpiredDate) {
						du.what("A_Business_License_ExpiredDate").sendKeys(A_Business_License_ExpiredDate);
					}
					public void set134A_Business_Scope(String A_Business_Scope) {
						du.what("A_Business_Scope").sendKeys(A_Business_Scope);
					}
					public void set135A_Registered_Capital(String A_Registered_Capital) {
						du.what("A_Registered_Capital").sendKeys(A_Registered_Capital);
					}
					public void set136A_Registered_Address(String A_Registered_Address) {
						du.what("A_Registered_Address").sendKeys(A_Registered_Address);
					}
					public void set137A_Organization_Code(String A_Organization_Code) {
						du.what("A_Organization_Code").sendKeys(A_Organization_Code);
					}
					public void set138A_Tax_Registration_Certificate(String A_Tax_Registration_Certificate) {
						du.what("A_Tax_Registration_Certificate").sendKeys(A_Tax_Registration_Certificate);
					}
					public void set139A_CorpName(String A_CorpName) {
						du.what("A_CorpName").sendKeys(A_CorpName);
					}
					public void set1310A_CorpID_Type(String A_CorpID_Type) {
						du.whatSelect("A_CorpID_Type").selectByValue(A_CorpID_Type);
					}
					public void set1311A_CorpID(String A_CorpID) {
						du.what("A_CorpID").sendKeys(A_CorpID);
					}
					public void set1312A_CopID_StartDate(String A_CopID_StartDate) {
						du.what("A_CopID_StartDate").sendKeys(A_CopID_StartDate);
					}
					public void set1312A_CopID_ExpiredDate(String A_CopID_ExpiredDate) {
						du.what("A_CopID_ExpiredDate").sendKeys(A_CopID_ExpiredDate);
					}
					
					/**
					 * 为了让日期js失去焦点
					 * @param A_Merchant_Property_label
					 */
					public void do130LoseFocus() {
						du.what("A_Business_Scope_label").click();
					}
			
	public void set2StoreInfo() {
		du.what("StoreInfo").click();
	}
					public void set21B_StoreName(String B_StoreName) {
						du.what("B_StoreName").sendKeys(B_StoreName);
					}
					public void set22B_StoreShortName(String B_StoreShortName) {
						du.what("B_StoreShortName").sendKeys(B_StoreShortName);
					}
					public void set23B_Store_Address(String B_Store_Address) {
						du.what("B_Store_Address").sendKeys(B_Store_Address);
					}
					public void set24B_Store_PhoneNO(String B_Store_PhoneNO) {
						du.what("B_Store_PhoneNO").sendKeys(B_Store_PhoneNO);
					}
					public void set25B_Business_Hours(String B_Business_Hours) {
						du.what("B_Business_Hours").sendKeys(B_Business_Hours);
					}
		
	public void set3StaffInfo() {
		du.what("StaffInfo").click();
	}
			public void set31MerchantContactInfo() {
				du.what("MerchantContactInfo").click();
			}
			public void set32ControllerInfo() {
				du.what("ControllerInfo").click();
			}
			public void set33Stakeholder() {
				du.what("Stakeholder").click();
			}
					public void set321C_Controller_Type(String C_Controller_Type) {
						du.what("C_Controller_Type").sendKeys(C_Controller_Type);
					}
					public void set322C_ControllerName(String C_ControllerName) {
						du.what("C_ControllerName").sendKeys(C_ControllerName);
					}
					public void set323C_ControllerID_Type(String C_ControllerID_Type) {
						du.whatSelect("C_ControllerID_Type").selectByValue(C_ControllerID_Type);
					}
					public void set324C_ControllerID(String C_ControllerID) {
						du.what("C_ControllerID").sendKeys(C_ControllerID);
					}
					public void set325C_ControlleID_StartDate(String C_ControlleID_StartDate) {
						du.what("C_ControlleID_StartDate").sendKeys(C_ControlleID_StartDate);
					}
					public void set325C_ControlleID_ExpiredDate(String C_ControlleID_ExpiredDate) {
						du.what("C_ControlleID_ExpiredDate").sendKeys(C_ControlleID_ExpiredDate);
					}
					public void set331C_Stakeholder_Type(String C_Stakeholder_Type) {
						du.what("C_Stakeholder_Type").sendKeys(C_Stakeholder_Type);
					}
					public void set332C_StakeholderName(String C_StakeholderName) {
						du.what("C_StakeholderName").sendKeys(C_StakeholderName);
					}
					public void set333C_StakeholderID_Type(String C_StakeholderID_Type) {
						du.whatSelect("C_StakeholderID_Type").selectByValue(C_StakeholderID_Type);
					}
					public void set334C_StakeholderID(String C_StakeholderID) {
						du.what("C_StakeholderID").sendKeys(C_StakeholderID);
					}
					public void set335C_Stakeholder_StartDate(String C_Stakeholder_StartDate) {
						du.what("C_Stakeholder_StartDate").sendKeys(C_Stakeholder_StartDate);
					}
					public void set335C_Stakeholder_ExpiredDate(String C_Stakeholder_ExpiredDate) {
						du.what("C_Stakeholder_ExpiredDate").sendKeys(C_Stakeholder_ExpiredDate);
					}
					
	public void set4AggreementInfo() {
		du.what("AggreementInfo").click();
	}
					public void set41D_Introduce_Channel(String D_Introduce_Channel) {
						du.whatSelect("D_Introduce_Channel").selectByValue(D_Introduce_Channel);
					}
					public void set42D_AgreementNO(String D_AgreementNO) {
						du.what("D_AgreementNO").sendKeys(D_AgreementNO);
					}
					public void set43D_AgreementExpiredDate(String D_AgreementExpiredDate) {
						du.what("D_AgreementExpiredDate").sendKeys(D_AgreementExpiredDate);
					}
					public void set44D_HandlerName(String D_HandlerName) {
						du.what("D_HandlerName").sendKeys(D_HandlerName);
					}
					public void set45D_HandlerID_Type(String D_HandlerID_Type) {
						du.whatSelect("D_HandlerID_Type").selectByValue(D_HandlerID_Type);
					}
					public void set46D_HandlerID(String D_HandlerID) {
						du.what("D_HandlerID").sendKeys(D_HandlerID);
					}
					public void set47D_Handler_StartDate(String D_Handler_StartDate) {
						du.what("D_Handler_StartDate").sendKeys(D_Handler_StartDate);
					}
					public void set47D_Handler_ExpiredDate(String D_Handler_ExpiredDate) {
						du.what("D_Handler_ExpiredDate").sendKeys(D_Handler_ExpiredDate);
					}
	/**
	 * 暂不实现
	 */
	public void set5InvoiceInfo() {
		du.what("InvoiceInfo").click();
	}
	/**
	 * 暂不实现
	 */
	public void set6ReconciliationInfo() {
		du.what("ReconciliationInfo").click();
	}
	/**
	 * 暂不实现
	 */
	public void set7PhotocopyRes() {
		du.what("PhotocopyRes").click();
	}
	
	public void set8AdditionInfo() {
		du.what("AdditionInfo").click();
	}
					public void set81H_MerchantAdminName(String H_MerchantAdminName) {
						du.what("H_MerchantAdminName").sendKeys(H_MerchantAdminName);
					}
					public void set82H_MerchantAdmin_MobileNO(String H_MerchantAdmin_MobileNO) {
						du.what("H_MerchantAdmin_MobileNO").sendKeys(H_MerchantAdmin_MobileNO);
					}
					public void set83H_MerchantAdmin_Email(String H_MerchantAdmin_Email) {
						du.what("H_MerchantAdmin_Email").sendKeys(H_MerchantAdmin_Email);
					}
					public void set84H_MerchantInterfaceType(String H_MerchantInterfaceType) {
						du.whatSelect("H_MerchantInterfaceType").selectByValue(H_MerchantInterfaceType);
					}
					public void set85submit() {
						du.what("submit").click();
					}


					

}
