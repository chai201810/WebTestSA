package com.dy.AutoTest.OperationPlatform.PageObject.MerchantManagementOnLine.OnLineMerchantInfo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;

public class MerchantAuditPage extends SuperPage{


	public MerchantAuditPage(WebDriver driver) { 
		super(driver);
		du.loadLocator("POP_Loc_MerchantAudit");
	}





	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_MerchantAudit");
	}
	
	public void setTrasactionName(String TransactionName) {
		du.whatSelect("TransactionName").selectByValue(TransactionName);
	}
	
	public void setOperID(String OperID) {
		du.what("OperID").sendKeys(OperID);
	}
	
	public void doQuery() {
		du.what("Button_Query").click();
	}
	
	public void doReset() {
		du.what("Button_Reset").click();
	}
	
	public List<WebElement> getRadioes() {
		return du.whats("Radioes");
	}
	public boolean isTestingData(int index) {
		return du.what("KeyInfo",String.valueOf(index)).getText().contains("商户名:");
	}
	
	public void selectRadio(int index) {
		du.what("Radio",String.valueOf(index)).click();
	}
	
	public void doLoseFocus(int index) {
		du.doLeftClickBy(du.what("Radio",String.valueOf(index)),-10,0);
	}
	
	public String getMerchantName() {
		
		return du.what("MerchantName").getAttribute("value");
	}
	
	public void doAudit() {
		du.what("Button_Audit").click();
	}
	
	public void setAuditComment(String AuditComment) {
		du.what("AuditComment").sendKeys(AuditComment);
	}
	
	public String getNotice() {
		du.waitForElementPresent("Notice");
		return du.what("Notice").getAttribute("textContent");

	}
	
	public void doPass() {
		du.what("Pass").click();
	}
	
	public void doRefuse() {
		du.what("Refuse").click();
	}
	
	public void doMerchantInfoAdd_Cancel() {
		du.what("Button_MerchantInfoAdd_Cancel").click();
	}
	
	//settlement
	public String getSettlementMerchantNO() {
		return du.what("Settlement_MerchantNO").getAttribute("value");
	}
	
	public String getSettlementMerchantName() {
		return du.what("Settlement_MerchantName").getAttribute("value");
	}
	
	public void setAuditComment2(String AuditComment2) {
		du.what("AuditComment2").sendKeys(AuditComment2);
	}
	
	public void doSettlement_Pass() {
		du.what("Button_Settlement_Pass").click();
	}
	
	public void doSettlement_Refuse() {
		du.what("Button_Settlement_Refuse").click();
	}
	
	public void doSettlementAdd_Cancel() {
		du.what("Button_SettlementAdd_Cancel").click();
	}
	
	//FeeRate
	public String getFeeRate_MerchantNO() {
		return du.what("FeeRate_MerchantNO").getAttribute("value");
	}
	
	public String getFeeRate_MerchantName() {
		return du.what("FeeRate_MerchantName").getAttribute("value");
	}
	
	public String getProductType() {
		return du.what("ProductType").getAttribute("value");
	}
	
	public void setAuditComment3(String AuditComment3) {
		du.what("AuditComment3").sendKeys(AuditComment3);
	}
	
	public void doFeeRate_Pass() {
		du.what("Button_FeeRate_Pass").click();
	}
	
	public void doFeeRate_Refuse() {
		du.what("Button_FeeRate_Refuse").click();
	}
	
	public void doFeeRateAdd_Cancel() {
		du.what("Button_FeeRateAdd_Cancel").click();
	}

}
