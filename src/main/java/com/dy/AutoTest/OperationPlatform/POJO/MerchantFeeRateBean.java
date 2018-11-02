package com.dy.AutoTest.OperationPlatform.POJO;

import java.io.Serializable;

public class MerchantFeeRateBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ID                 ;
	private String CaseNO;
	private String MerchantNO         ;
	private String MerchantName       ;
	private String ValidIdentify      ;
	private String Timpstamp          ;
	private String ProductType        ;
	private String FeeRate_StartDate ;
	private String FeeRate_ExpireDate;
	private String FeeRateType        ;
	private String SettlementType     ;
	private String RefundType         ;
	private String RefundMode         ;
	private String FeeRateCode            ;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCaseNO() {
		return CaseNO;
	}
	public void setCaseNO(String caseNO) {
		CaseNO = caseNO;
	}
	public String getMerchantNO() {
		return MerchantNO;
	}
	public void setMerchantNO(String merchantNO) {
		MerchantNO = merchantNO;
	}
	public String getMerchantName() {
		return MerchantName;
	}
	public void setMerchantName(String merchantName) {
		MerchantName = merchantName;
	}
	public String getValidIdentify() {
		return ValidIdentify;
	}
	public void setValidIdentify(String validIdentify) {
		ValidIdentify = validIdentify;
	}
	public String getTimpstamp() {
		return Timpstamp;
	}
	public void setTimpstamp(String timpstamp) {
		Timpstamp = timpstamp;
	}
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	public String getFeeRate_StartDate() {
		return FeeRate_StartDate;
	}
	public void setFeeRate_StartDate(String FeeRate_StartDate) {
		this.FeeRate_StartDate = FeeRate_StartDate;
	}
	public String getFeeRate_ExpireDate() {
		return FeeRate_ExpireDate;
	}
	public void setFeeRate_ExpireDate(String FeeRate_ExpireDate) {
		this.FeeRate_ExpireDate = FeeRate_ExpireDate;
	}
	public String getFeeRateType() {
		return FeeRateType;
	}
	public void setFeeRateType(String feeRateType) {
		FeeRateType = feeRateType;
	}
	public String getSettlementType() {
		return SettlementType;
	}
	public void setSettlementType(String settlementType) {
		SettlementType = settlementType;
	}
	public String getRefundType() {
		return RefundType;
	}
	public void setRefundType(String refundType) {
		RefundType = refundType;
	}
	public String getRefundMode() {
		return RefundMode;
	}
	public void setRefundMode(String refundMode) {
		RefundMode = refundMode;
	}
	public String getFeeRateCode() {
		return FeeRateCode;
	}
	public void setFeeRateCode(String FeeRateCode) {
		this.FeeRateCode = FeeRateCode;
	}

	public void displayInfo() {
		System.out.println("ID: "+ID);
		System.out.println("CaseNO:"+CaseNO); 
		System.out.println("MerchantNO: "+MerchantNO);
		System.out.println("MerchantName: "+MerchantName);
		System.out.println("ValidIdentify: "+ValidIdentify);
		System.out.println("Timpstamp: "+Timpstamp);
		System.out.println("ProductType: "+ProductType);
		System.out.println("FeeRate_StartDate: "+FeeRate_StartDate);
		System.out.println("FeeRate_ExpireDate: "+FeeRate_ExpireDate);
		System.out.println("FeeRateType: "+FeeRateType);
		System.out.println("SettlementType: "+SettlementType);
		System.out.println("RefundType: "+RefundType);
		System.out.println("RefundMode: "+RefundMode);
		System.out.println("FeeRateCode: "+FeeRateCode);

	}
}
