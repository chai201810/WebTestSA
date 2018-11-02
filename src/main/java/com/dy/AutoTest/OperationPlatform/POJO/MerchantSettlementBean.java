package com.dy.AutoTest.OperationPlatform.POJO;

import java.io.Serializable;

public class MerchantSettlementBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int ID                     ;
	private String CaseNO;
	private String MerchantNO;
	private String MerchantName           ;
	private String Status                 ;
	private String Timpstamp              ;
	private String AccountType            ;
	private String SettlementType         ;
	private String SettlementOptions      ;
	private String BankName               ;
	private String SubBankBelongProvice      ;
	private String SubBankBelongCity         ;
	private String SubBankInfo            ;
	private String Account                ;
	private String AccountName            ;
	private String SettlementCycle        ;
	private String SettlementDays         ;
	private String NextSettlementDate     ;
	private String SuspendIdentify        ;
	private String Settlement_StartDate   ;
	private String Settlement_ExpireDate  ;
	private String Start_Amount           ;
	private String Minimum_Amount         ;
	private String MerchantSettlementType ;
	private String Self_Settlement        ;
	
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
	public void setSubBankBelongProvice(String subBankBelongProvice) {
		SubBankBelongProvice = subBankBelongProvice;
	}
	public void setSubBankBelongCity(String subBankBelongCity) {
		SubBankBelongCity = subBankBelongCity;
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
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getTimpstamp() {
		return Timpstamp;
	}
	public void setTimpstamp(String timpstamp) {
		Timpstamp = timpstamp;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public String getSettlementType() {
		return SettlementType;
	}
	public void setSettlementType(String settlementType) {
		SettlementType = settlementType;
	}
	public String getSettlementOptions() {
		return SettlementOptions;
	}
	public void setSettlementOptions(String settlementOptions) {
		SettlementOptions = settlementOptions;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getSubBankBelongProvice() {
		return SubBankBelongProvice;
	}
	public void setBankBelongProvice(String subBankBelongProvice) {
		SubBankBelongProvice = subBankBelongProvice;
	}
	public String getSubBankBelongCity() {
		return SubBankBelongCity;
	}
	public void setBankBelongCity(String subBankBelongCity) {
		SubBankBelongCity = subBankBelongCity;
	}
	public String getSubBankInfo() {
		return SubBankInfo;
	}
	public void setSubBankInfo(String subBankInfo) {
		SubBankInfo = subBankInfo;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getSettlementCycle() {
		return SettlementCycle;
	}
	public void setSettlementCycle(String settlementCycle) {
		SettlementCycle = settlementCycle;
	}
	public String getSettlementDays() {
		return SettlementDays;
	}
	public void setSettlementDays(String settlementDays) {
		SettlementDays = settlementDays;
	}
	public String getNextSettlementDate() {
		return NextSettlementDate;
	}
	public void setNextSettlementDate(String nextSettlementDate) {
		NextSettlementDate = nextSettlementDate;
	}
	public String getSuspendIdentify() {
		return SuspendIdentify;
	}
	public void setSuspendIdentify(String suspendIdentify) {
		SuspendIdentify = suspendIdentify;
	}
	public String getSettlement_StartDate() {
		return Settlement_StartDate;
	}
	public void setSettlement_StartDate(String settlement_StartDate) {
		Settlement_StartDate = settlement_StartDate;
	}
	public String getSettlement_ExpireDate() {
		return Settlement_ExpireDate;
	}
	public void setSettlement_ExpireDate(String settlement_ExpireDate) {
		Settlement_ExpireDate = settlement_ExpireDate;
	}
	public String getStart_Amount() {
		return Start_Amount;
	}
	public void setStart_Amount(String start_Amount) {
		Start_Amount = start_Amount;
	}
	public String getMinimum_Amount() {
		return Minimum_Amount;
	}
	public void setMinimum_Amount(String minimum_Amount) {
		Minimum_Amount = minimum_Amount;
	}
	public String getMerchantSettlementType() {
		return MerchantSettlementType;
	}
	public void setMerchantSettlementType(String merchantSettlementType) {
		MerchantSettlementType = merchantSettlementType;
	}
	public String getSelf_Settlement() {
		return Self_Settlement;
	}
	public void setSelf_Settlement(String self_Settlement) {
		Self_Settlement = self_Settlement;
	}
	                                      
	
	public void displayInfo() {
		System.out.println("ID: "                     +ID                    );
		System.out.println("CaseNO:" 				+CaseNO); 
		System.out.println("MerchantNO: "           + MerchantNO          );
		System.out.println("MerchantName: "           +MerchantName          );
		System.out.println("Status: "                 +Status                );
		System.out.println("Timpstamp: "              +Timpstamp             );
		System.out.println("AccountType: "            +AccountType           );
		System.out.println("SettlementType: "         +SettlementType        );
		System.out.println("SettlementOptions: "      +SettlementOptions     );
		System.out.println("BankName: "               +BankName              );
		System.out.println("BankBelongProvice: "      +SubBankBelongProvice     );
		System.out.println("BankBelongCity: "         +SubBankBelongCity        );
		System.out.println("SubBankInfo: "            +SubBankInfo           );
		System.out.println("Account: "                +Account               );
		System.out.println("AccountName: "            +AccountName           );
		System.out.println("SettlementCycle: "        +SettlementCycle       );
		System.out.println("SettlementDays: "         +SettlementDays        );
		System.out.println("NextSettlementDate: "     +NextSettlementDate    );
		System.out.println("SuspendIdentify: "        +SuspendIdentify       );
		System.out.println("Settlement_StartDate: "   +Settlement_StartDate  );
		System.out.println("Settlement_ExpireDate: "  +Settlement_ExpireDate );
		System.out.println("Start_Amount: "           +Start_Amount          );
		System.out.println("Minimum_Amount: "         +Minimum_Amount        );
		System.out.println("MerchantSettlementType: " +MerchantSettlementType);
		System.out.println("Self_Settlement: "        +Self_Settlement       );
	}
	
}
