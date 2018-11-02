package com.dy.AutoTest.OnlineCashier.TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OnlineCashier.POJO.OnlineCashierB2CBean;
import com.dy.AutoTest.OnlineCashier.PageObject.OnlineCashierB2CPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.actions.Switch;

public class OnlineCashierB2CTest extends SuperTest{
	OnlineCashierB2CPage OnlineCashierB2CPage;
    String URL;
    Switch switch1;
    
    @BeforeClass
	public void init() {
    	OnlineCashierB2CPage=new OnlineCashierB2CPage(driver);
		URL=host.toString();
		switch1=new Switch(driver);
	}
	
	@DataProvider(name="B2C")
	protected static Object[][] parametersPool(){
		data.loadDataBeanList("Online_Data_Cashier_B2C");
		return data.getDataBeanArray();
	}
	
	@Test(dataProvider="B2C")
	public void testOnlineCashierB2C(OnlineCashierB2CBean OnlineCashierB2CBean) {
		OnlineCashierB2CPage.navigateTo(URL);
		
		OnlineCashierB2CPage.setMerchantNO(OnlineCashierB2CBean.getMerchantNO());
		OnlineCashierB2CPage.setCertificatePassword(OnlineCashierB2CBean.getCertificatePassword());
		OnlineCashierB2CPage.resetMerchantResource();
		OnlineCashierB2CPage.GoToB2C();
		
		OnlineCashierB2CPage.setAmount(OnlineCashierB2CBean.getAmount());
		OnlineCashierB2CPage.setMobileNO(OnlineCashierB2CBean.getMobileNO());
		OnlineCashierB2CPage.doSubmit();
		
		OnlineCashierB2CPage.setPaymentPassword(OnlineCashierB2CBean.getPaymentPassword());
		OnlineCashierB2CPage.doNext();
		
		if(OnlineCashierB2CPage.isAntiPhishing()) {
			OnlineCashierB2CPage.doAntiPhishing();
		}
		
		if(OnlineCashierB2CBean.getPaymentType().equals(""))
			OnlineCashierB2CBean.setPaymentType("0");
		
		/**
		 * @param PaymentChannel
		 * @param MobileNO
		 * 
		 * 0 : 余额支付
		 * 1 : 快捷支付
		 * 2 : 网银支付
		 * 3 : 扫码支付
		 * 
		 */
		switch (OnlineCashierB2CBean.getPaymentType()) {
		case "0":
			OnlineCashierB2CPage.doBlance();
			OnlineCashierB2CPage.doPayment();
			break;
		case "1":
			OnlineCashierB2CPage.doQuick();
			OnlineCashierB2CPage.switchQuick_Card(OnlineCashierB2CBean.getQuick_CardIndex());	
			OnlineCashierB2CPage.doPayment();
			
			wait.waitFor(500);
			if(OnlineCashierB2CPage.isPaymentError()) {
				System.out.println("支付失败，失败原因："+OnlineCashierB2CPage.getPaymentError());
				Reporter.log("支付失败，失败原因："+OnlineCashierB2CPage.getPaymentError());
				assertTrue(false,"Pay failed");
			}
			
			OnlineCashierB2CPage.setQuick_SMS(OnlineCashierB2CBean.getMobileNO());
			if(OnlineCashierB2CPage.isQuick_Failed()) {
				System.out.println("支付失败，失败原因："+OnlineCashierB2CPage.getQuick_Error());
				Reporter.log("支付失败，失败原因："+OnlineCashierB2CPage.getQuick_Error());
				assertTrue(false, "Payment failed");
			}
			break;
		case "2":
			OnlineCashierB2CPage.doEBank();
//			OnlineCashierB2CPage.doLoseFocus("Checkbox_EBank", -50, 0);
//			OnlineCashierB2CPage.doPageDown();
			OnlineCashierB2CPage.doChooseBank();
			OnlineCashierB2CPage.doPayment();
			switch1.toSpecificWindow("银联在线支付");
			OnlineCashierB2CPage.setEBank_CardNO(OnlineCashierB2CBean.getEBank_CardNO());
			OnlineCashierB2CPage.doEBank_UnionpayNext();
			OnlineCashierB2CPage.doEBank_GetUnionpaySMS();
			OnlineCashierB2CPage.setEBank_UnionpaySMS(OnlineCashierB2CBean.getEBank_SMS());
			OnlineCashierB2CPage.doEBank_UnionpayPay();
			
			if(OnlineCashierB2CPage.isEBank_UnionpaySuccess()) {
				OnlineCashierB2CPage.doEBank_UnionpayBack();
			}else {
				System.out.println(OnlineCashierB2CPage.getEBank_UnionpayMainWord());
				Reporter.log(OnlineCashierB2CPage.getEBank_UnionpayMainWord());
				assertTrue(false);
			}
			
			break;
		case "3":
			OnlineCashierB2CPage.doScanPay();
			OnlineCashierB2CPage.doPayment();
			break;
		default:
			break;
		}
		
		if(OnlineCashierB2CPage.isPaySuccess()) {
			System.out.println("[info]支付成功！用户 "+OnlineCashierB2CBean.getMobileNO()
			+" 在 "+OnlineCashierB2CBean.getMerchantNO()+" 下，消费 "+Integer.parseInt(OnlineCashierB2CBean.getAmount())*0.01+" 元");
			
			Reporter.log("[info]支付成功！用户 "+OnlineCashierB2CBean.getMobileNO()
			+" 在 "+OnlineCashierB2CBean.getMerchantNO()+" 下，消费 "+Integer.parseInt(OnlineCashierB2CBean.getAmount())*0.01+" 元");
		}else {
			System.out.println("支付失败");
			Reporter.log("支付失败");
			assertTrue(false,"Pay failed");
		}
		
		
	}
}
