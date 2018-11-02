package com.dy.AutoTest.OperationPlatform.PageObject.MerchantManagementOnLine.OnLineMerchantInfo;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;

public class MerchantFeeRatePage extends SuperPage{

	public MerchantFeeRatePage(WebDriver driver) {
		super(driver);
		du.loadLocator("POP_Loc_MerchantFeeRate");
	}
 
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_MerchantFeeRate");
	}
	
	public void doMerchantFeeRateAdd() {
		du.what("Button_FeeRateAdd").click();
	}
		
	public void setMerchantNO(String MerchantNO) {
		du.what("Button_SearchMerchant2").click();
		du.waitFor(500);
		du.what("Search_MerchantNO").clear();
		du.what("Search_MerchantNO").sendKeys(MerchantNO);
		du.what("Button_Search").click();
		du.waitFor(500);
		du.what("Merchant_Radio").click();
		du.what("Button_SearchSubmit").click();
	}
	public void setMerchantName(String merchantName) {
		du.what("Button_SearchMerchant2").click();
		du.waitFor(500);
		du.what("Search_MerchantName").clear();
		du.what("Search_MerchantName").sendKeys(merchantName);
		du.what("Button_Search").click();
		du.waitFor(500);
		du.what("Merchant_Radio").click();
		du.what("Button_SearchSubmit").click();
		
	}
	
	
	public void setProductType(String ProductType) {
		du.whatSelect("ProductType").selectByValue(ProductType);
	}
	
	public void setFeeRate_StartDate(String FeeRate_StartDate) {
		du.what("FeeRate_StartDate").sendKeys(FeeRate_StartDate);
	}
	public void setFeeRate_ExpireDate(String FeeRate_ExpireDate) {
		du.what("FeeRate_ExpireDate").sendKeys(FeeRate_ExpireDate);
	}
	
	
	
	
	public void setFeeRateType(String FeeRateType) {
		du.whatSelect("FeeRateType").selectByValue(FeeRateType);
	}
	public void setSettlementType(String SettlementType) {
		du.whatSelect("SettlementType").selectByValue(SettlementType);
	}
	public void setRefundType(String RefundType) {
		du.whatSelect("RefundType").selectByValue(RefundType);
	}
	public void setRefundMode(String RefundMode) {
		du.whatSelect("RefundMode").selectByValue(RefundMode);
	}
	
	public void setFeeRateCode(String FeeRateCode) {
		du.what("Button_FeeRate").click();
		du.waitFor(500);
		du.what("Search_FeeRateCode").clear();
		du.what("Search_FeeRateCode").sendKeys(FeeRateCode);
		du.what("Button_SearchFeeRate").click();
		du.waitFor(500);
		du.what("FeeRate_Radio").click();
		du.what("Button_SearchFeeRateCodeSubmit").click();
	}
	
	public void doButton_Confirm() {
		du.what("Button_Confirm").click();
	}
	public void doButton_Cancel() {
		du.what("Button_Cancel").click();
	}



	
}
