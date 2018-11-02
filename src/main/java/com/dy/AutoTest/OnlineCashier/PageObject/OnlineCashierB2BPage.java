package com.dy.AutoTest.OnlineCashier.PageObject;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;
import com.dy.AutoTest.web.business.OperBusiness;
import com.dy.AutoTest.web.dao.OperDao;
import com.dy.AutoTest.web.dao.impl.OperDaoImpl;

public class OnlineCashierB2BPage extends SuperPage{
	
	public OnlineCashierB2BPage(WebDriver driver) {
		super(driver);
		du.loadLocator("Online_Loc_Cashier_B2B");
	}
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("Online_Loc_Cashier_B2B");
	}
	
	public void setMerchantNO(String MerchantNO) {
		du.what("MerchantNO").clear();
		du.what("MerchantNO").sendKeys(MerchantNO);
	}
	
	public void setCertificatePassword(String CertificatePassword) {
		du.what("CertificatePassword").clear();
		du.what("CertificatePassword").sendKeys(CertificatePassword);
	}
	
	public void resetMerchantResource() {
		du.what("Button_Reset").click();
	}
	
	public void GoToB2B(){
		du.what("B2B").click();
	}

	public void setMerchantRequestNO(String MerchantRequestNO) {
		du.what("MerchantRequestNO").clear();
		du.what("MerchantRequestNO").sendKeys(MerchantRequestNO);
	}
	
	public void setOrderNO(String OrderNO) {
		du.what("OrderNO").clear();
		du.what("OrderNO").sendKeys(OrderNO);
	}
	
	public void setReceiptMerchantNO(String ReceiptMerchantNO) {
		du.what("ReceiptMerchantNO").clear();
		du.what("ReceiptMerchantNO").sendKeys(ReceiptMerchantNO);
	}
	
	public void setOrderAmount(String OrderAmount) {
		du.what("OrderAmount").clear();
		du.what("OrderAmount").sendKeys(OrderAmount);
	}
	
	public void setPaymentAmout(String PaymentAmout) {
		du.what("PaymentAmout").clear();
		du.what("PaymentAmout").sendKeys(PaymentAmout);
	}
	
	public void doSubOrderAdd() {
		du.what("SubOrderAdd").click();
	}
	
	public void setReceiptMerchantType(String ReceiptMerchantType) {
		du.whatSelect("ReceiptMerchantType").selectByValue(ReceiptMerchantType);
	}
	
	public void setSub1OrderNO(String Sub1OrderNO) {
		du.what("Sub1OrderNO").clear();
		du.what("Sub1OrderNO").sendKeys(Sub1OrderNO);
	}
	
	public void setSub1OrderAmount(String Sub1OrderAmount) {
		du.what("Sub1OrderAmount").clear();
		du.what("Sub1OrderAmount").sendKeys(Sub1OrderAmount);
	}
	
	public void setSub1PaymentAmount(String Sub1PaymentAmount) {
		du.what("Sub1PaymentAmount").clear();
		du.what("Sub1PaymentAmount").sendKeys(Sub1PaymentAmount);
	}
	
	public void setSub1ReceiptMerchantNO(String Sub1ReceiptMerchantNO) {
		du.what("Sub1ReceiptMerchantNO").clear();
		du.what("Sub1ReceiptMerchantNO").sendKeys(Sub1ReceiptMerchantNO);
	}
	
	public void setSub2OrderNO(String Sub2OrderNO) {
		du.what("Sub2OrderNO").clear();
		du.what("Sub2OrderNO").sendKeys(Sub2OrderNO);
	}
	
	public void setSub2OrderAmount(String Sub2OrderAmount) {
		du.what("Sub2OrderAmount").clear();
		du.what("Sub2OrderAmount").sendKeys(Sub2OrderAmount);
	}
	
	public void setSub2PaymentAmount(String Sub2PaymentAmount) {
		du.what("Sub2PaymentAmount").clear();
		du.what("Sub2PaymentAmount").sendKeys(Sub2PaymentAmount);
	}
	
	public void setSub2ReceiptMerchantNO(String Sub2ReceiptMerchantNO) {
		du.what("Sub2ReceiptMerchantNO").clear();
		du.what("Sub2ReceiptMerchantNO").sendKeys(Sub2ReceiptMerchantNO);
	}
	
	public void doSubmit() {
		du.what("Button_Submit").click();
	}
	public void doSubmit2() {
		du.what("Button_Submit2").click();
	}
	
	/**
	 * @param PaymentType
	 * 
	 * E : 企业网银
	 * P : 个人网银
	 */
	public void doEnterpriseEBank() {
		du.what("EnterpriseEBank").click();
	}
	
			public void doChooseEnterpriseEBank() {
				du.what("EnterpriseEBank_ChoosBank").click();
			}
			
	public void doPersonalEBank() {
		du.what("PersonalEBank").click();
	}
	
			public void doChoosePersonalEBank() {
				du.what("PersonalEBank_ChoosBank").click();
			}
			
			public void setEBank_CardNO(String EBank_CardNO) {
				du.waitForElementPresent("PersonalEBank__UnionpayCard");
				du.what("PersonalEBank__UnionpayCard").sendKeys(EBank_CardNO);
			}
			
			public void doEBank_UnionpayNext() {
				du.what("PersonalEBank_UnionpayNext").click();
			}
			
			public void doEBank_GetUnionpaySMS() {
				du.waitForElementPresent("PersonalEBank_GetUnionpaySMS");
				du.what("PersonalEBank_GetUnionpaySMS").click();
			}
			
			public void setEBank_UnionpaySMS(String EBank_UnionpaySMS) {
				du.what("PersonalEBank_UnionpaySMS").sendKeys(EBank_UnionpaySMS);
			}
			
			public void doEBank_UnionpayPay() {
				du.what("PersonalEBank_UnionpayPay").click();
			}
			
			public boolean isEBank_UnionpaySuccess() {
				return du.what("PersonalEBank_UnionpaySuccess").isDisplayed();
			}
			
			public void doEBank_UnionpayBack() {
				du.what("PersonalEBank_UnionpayBack").click();
			}
			
			public String getEBank_UnionpayMainWord() {
				return du.what("PersonalEBank_UnionpayMainWord").getText();
			}
	
	public void doPayment() {
		du.what("Payment").click();
	}
	
	
	public boolean isPaymentError() {
		return du.what("Payment_Error").isDisplayed();
	}
	
	public String getPaymentError() {
		return du.what("Payment_Error").getText();
	}
	
	
	public boolean isPaySuccess() {
		du.waitForElementPresent("Message_PaySuccess");
		
		return du.isDisplayed("Message_PaySuccess");
	}
	
	
}
