package com.dy.AutoTest.OnlineCashier.PageObject;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;
import com.dy.AutoTest.web.business.OperBusiness;
import com.dy.AutoTest.web.dao.OperDao;
import com.dy.AutoTest.web.dao.impl.OperDaoImpl;

public class OnlineCashierB2CPage extends SuperPage{
	
	public OnlineCashierB2CPage(WebDriver driver) {
		super(driver);
		du.loadLocator("Online_Loc_Cashier_B2C");
	}
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("Online_Loc_Cashier_B2C");
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
	
	public void GoToB2C(){
		du.what("B2C").click();
	}

	public void setOrderDate(String OrderDate) {
		du.what("OrderDate").clear();
		du.what("OrderDate").sendKeys(OrderDate);
	}
	
	/**
	 * @param CardType
	 * 1: 借记卡
	 * 2: 贷记卡
	 * 3: 支付账户
	 */
	public void setCardType(String CardType) {
		du.whatSelect("CardType").selectByValue(CardType);
	}
	
	public void setMerchantOrderNO(String MerchantOrderNO) {
		du.what("MerchantOrderNO").clear();
		du.what("MerchantOrderNO").sendKeys(MerchantOrderNO);
	}
	
	public void setAmount(String Amount) {
		du.what("Amount").clear();
		du.what("Amount").sendKeys(Amount);
	}
	
	public void setCallbackURL(String CallbackURL) {
		du.what("CallbackURL").clear();
		du.what("CallbackURL").sendKeys(CallbackURL);
	}
	
	public void setMobileNO(String MobileNO) {
		du.what("MobileNO").clear();
		du.what("MobileNO").sendKeys(MobileNO);
	}
	
	public void setProductName(String ProductName) {
		du.what("ProductName").clear();
		du.what("ProductName").sendKeys(ProductName);
	}
	
	public void setProductNO(String ProductNO) {
		du.what("ProductNO").clear();
		du.what("ProductNO").sendKeys(ProductNO);
	}
	
	public void setProductDescription(String ProductDescription) {
		du.what("ProductDescription").clear();
		du.what("ProductDescription").sendKeys(ProductDescription);
	}
	
	public void setBackParam(String BackParam) {
		du.what("BackParam").clear();
		du.what("BackParam").sendKeys(BackParam);
	}
	
	public void setValidity(String Validity) {
		du.what("Validity").clear();
		du.what("Validity").sendKeys(Validity);
	}
	
	/**
	 * @param ValidityUnit
	 * 00 : 分
	 * 01 : 小时
	 * 02 : 日
	 * 03 : 月
	 */
	public void setValidityUnit(String ValidityUnit) {
		du.whatSelect("ValidityUnit").selectByValue(ValidityUnit);
	}
	
	public void setUserBindFlag(String UserBindFlag) {
		du.whatSelect("UserBindFlag").selectByValue(UserBindFlag);
	}
	
	public void doSubmit() {
		du.what("Button_Submit").click();
	}
	
	/**
	 * @param PaymentPassword
	 * 等待实现
	 * 
	 */
	public void setPaymentPassword(String PaymentPassword) {
		du.waitFor(10000);
		
	}
	
	public void doNext() {
		du.what("Button_Next").click();
	}
	
	public boolean isAntiPhishing() {
		du.waitFor(1000);
		return du.isDisplayed("Div_AntiPhishing");
	}
	
	public void doAntiPhishing() {
		du.what("Button_AntiPhishing").click();
	}
	
	public void doBlance() {
		if(!du.what("Checkbox_Blance").isSelected())
			du.what("Checkbox_Blance").click();
	}
	
	public void doQuick() {
		if(!du.what("Checkbox_Quick").isSelected())
			du.what("Checkbox_Quick").click();
	}
	
			public void switchQuick_Card(String index) {
				if(index.equals(""))
					index="1";
				du.what("Quick_Card_Select").click();
				du.waitFor(500);
				du.what("Quick_Card", index).click();
				du.waitFor(500);
			}
	
			public void setQuick_SMS(String MobileNO) {
				du.waitFor(500);
				du.what("Quick_SendSMS").click();
				OperDao operDao=new OperDaoImpl();
				OperBusiness OperBusiness=new OperBusiness(operDao);
				du.waitFor(500);
				du.what("Quick_SMS").sendKeys(OperBusiness.getPOPLoginSMS(MobileNO));
				du.what("Quick_Next").click();
			}
			
			public boolean isQuick_Failed() {
				return du.what("Quick_Error").isDisplayed();
			}
			
			public String getQuick_Error() {
				return du.what("Quick_Error").getText();
			}
	
	public void doEBank() {
		if(!du.what("Checkbox_EBank").isSelected())
			du.what("Checkbox_EBank").click();
	}
	
			public void doChooseBank() {
				du.what("EBank_ChoosBank").click();
			}
			
			public void setEBank_CardNO(String EBank_CardNO) {
//				du.waitFor(5000);
				du.waitForElementPresent("EBank_UnionpayCard");
				du.what("EBank_UnionpayCard").sendKeys(EBank_CardNO);
			}
			
			public void doEBank_UnionpayNext() {
				du.what("EBank_UnionpayNext").click();
			}
			
			public void doEBank_GetUnionpaySMS() {
				du.waitForElementPresent("EBank_GetUnionpaySMS");
				du.what("EBank_GetUnionpaySMS").click();
			}
			
			public void setEBank_UnionpaySMS(String EBank_UnionpaySMS) {
				du.what("EBank_UnionpaySMS").sendKeys(EBank_UnionpaySMS);
			}
			
			public void doEBank_UnionpayPay() {
				du.what("EBank_UnionpayPay").click();
			}
			
			public boolean isEBank_UnionpaySuccess() {
				return du.what("EBank_UnionpaySuccess").isDisplayed();
			}
			
			public void doEBank_UnionpayBack() {
				du.what("EBank_UnionpayBack").click();
			}
			
			public String getEBank_UnionpayMainWord() {
				return du.what("EBank_UnionpayMainWord").getText();
			}
			
	public void doScanPay() {
		if(!du.what("Checkbox_ScanPay").isSelected())
			du.what("Checkbox_ScanPay").click();
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
