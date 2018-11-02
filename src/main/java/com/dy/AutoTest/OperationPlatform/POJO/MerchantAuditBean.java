package com.dy.AutoTest.OperationPlatform.POJO;

import java.io.Serializable;

public class MerchantAuditBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int ID              ;
	private String OperID          ;
	private String TransactionName ;
	private String KeyInfo         ;
	private String Comment         ;
	
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOperID() {
		return OperID;
	}
	public void setOperID(String operID) {
		OperID = operID;
	}
	public String getTransactionName() {
		return TransactionName;
	}
	public void setTransactionName(String transactionName) {
		TransactionName = transactionName;
	}
	public String getKeyInfo() {
		return KeyInfo;
	}
	public void setKeyInfo(String keyInfo) {
		KeyInfo = keyInfo;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}

	public void displayInfo() {
		System.out.println("ID: "+ID);
		System.out.println("OperID: "+OperID);
		System.out.println("TransactionName: "+TransactionName);
		System.out.println("KeyInfo:"+KeyInfo);
		System.out.println("Comment:"+Comment);
	}
}
