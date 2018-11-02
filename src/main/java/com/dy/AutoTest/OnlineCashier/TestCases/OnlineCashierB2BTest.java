package com.dy.AutoTest.OnlineCashier.TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OnlineCashier.POJO.OnlineCashierB2BBean;
import com.dy.AutoTest.OnlineCashier.PageObject.OnlineCashierB2BPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.actions.Switch;

public class OnlineCashierB2BTest extends SuperTest{
	OnlineCashierB2BPage OnlineCashierB2BPage;
    String URL;
    Switch switch1;
    
    @BeforeClass
	public void init() {
    	OnlineCashierB2BPage=new OnlineCashierB2BPage(driver);
		URL=host.toString();
		switch1=new Switch(driver);
	}
	
	@DataProvider(name="B2B")
	protected static Object[][] parametersPool(){
		data.loadDataBeanList("Online_Data_Cashier_B2B");
		return data.getDataBeanArray();
	}
	
	@Test(dataProvider="B2B")
	public void testOnlineCashierB2B(OnlineCashierB2BBean OnlineCashierB2BBean) {
		OnlineCashierB2BPage.navigateTo(URL);
		
		OnlineCashierB2BPage.setMerchantNO(OnlineCashierB2BBean.getMerchantNO());
		OnlineCashierB2BPage.setCertificatePassword(OnlineCashierB2BBean.getCertificatePassword());
		OnlineCashierB2BPage.resetMerchantResource();
		wait.waitFor(500);
		OnlineCashierB2BPage.GoToB2B();
		
		OnlineCashierB2BPage.setMerchantRequestNO(OnlineCashierB2BBean.getMerchantRequestNO());
		OnlineCashierB2BPage.setOrderNO(OnlineCashierB2BBean.getOrderNO());
		OnlineCashierB2BPage.setReceiptMerchantNO(OnlineCashierB2BBean.getReceiptMerchantNO());
		OnlineCashierB2BPage.setOrderAmount(OnlineCashierB2BBean.getOrderAmount());
		OnlineCashierB2BPage.setPaymentAmout(OnlineCashierB2BBean.getPaymentAmout());
		//ReceiptMerchantType : M代表多笔交易，O代表单笔交易
		OnlineCashierB2BPage.setReceiptMerchantType(OnlineCashierB2BBean.getReceiptMerchantType());
		
		OnlineCashierB2BPage.doSubOrderAdd();
		
		OnlineCashierB2BPage.setSub1OrderNO(OnlineCashierB2BBean.getSub1OrderNO());
		OnlineCashierB2BPage.setSub1OrderAmount(OnlineCashierB2BBean.getSub1OrderAmount());
		OnlineCashierB2BPage.setSub1PaymentAmount(OnlineCashierB2BBean.getSub1PaymentAmount());
		OnlineCashierB2BPage.setSub1ReceiptMerchantNO(OnlineCashierB2BBean.getSub1ReceiptMerchantNO());
		
		OnlineCashierB2BPage.setSub2OrderNO(OnlineCashierB2BBean.getSub2OrderNO());
		OnlineCashierB2BPage.setSub2OrderAmount(OnlineCashierB2BBean.getSub2OrderAmount());
		OnlineCashierB2BPage.setSub2PaymentAmount(OnlineCashierB2BBean.getSub2PaymentAmount());
		OnlineCashierB2BPage.setSub2ReceiptMerchantNO(OnlineCashierB2BBean.getSub2ReceiptMerchantNO());
		
		OnlineCashierB2BPage.doSubmit();
		OnlineCashierB2BPage.doSubmit2();
		
		switch(OnlineCashierB2BBean.getPaymentType()){
		
		case "E":	//企业网银支付
			OnlineCashierB2BPage.doEnterpriseEBank();
			OnlineCashierB2BPage.doChooseEnterpriseEBank();
			OnlineCashierB2BPage.doPayment();
			switch1.toSpecificWindow("银联在线支付");
			break;
		case "P":	//个人网银支付
			OnlineCashierB2BPage.doPersonalEBank();
			OnlineCashierB2BPage.doChoosePersonalEBank();
			OnlineCashierB2BPage.doPayment();
			switch1.toSpecificWindow("银联在线支付");
			OnlineCashierB2BPage.setEBank_CardNO(OnlineCashierB2BBean.getEBank_CardNO());
			OnlineCashierB2BPage.doEBank_UnionpayNext();
			OnlineCashierB2BPage.doEBank_GetUnionpaySMS();
			OnlineCashierB2BPage.setEBank_UnionpaySMS(OnlineCashierB2BBean.getEBank_SMS());
			OnlineCashierB2BPage.doEBank_UnionpayPay();
			
			if(OnlineCashierB2BPage.isEBank_UnionpaySuccess()) {
				OnlineCashierB2BPage.doEBank_UnionpayBack();
			}else {
				System.out.println(OnlineCashierB2BPage.getEBank_UnionpayMainWord());
				Reporter.log(OnlineCashierB2BPage.getEBank_UnionpayMainWord());
				assertTrue(false);
			}
			break;
		default :
			System.out.println("参数不正确，请检查数据库PaymentType字段的参数");
			break;
		}
	
		if(OnlineCashierB2BPage.isPaySuccess()) {
			System.out.println("[info]支付成功！ 在主商户 "
					+OnlineCashierB2BBean.getMerchantNO()+" 下，付款 "+Integer.parseInt(OnlineCashierB2BBean.getOrderAmount())*0.01+" 元");
			
			Reporter.log("[info]支付成功！ 在主商户 "
					+OnlineCashierB2BBean.getMerchantNO()+" 下，付款 "+Integer.parseInt(OnlineCashierB2BBean.getOrderAmount())*0.01+" 元");
		}else {
			System.out.println("支付失败");
			Reporter.log("支付失败");
			assertTrue(false,"Pay failed");
		}
		
		
	}
}
