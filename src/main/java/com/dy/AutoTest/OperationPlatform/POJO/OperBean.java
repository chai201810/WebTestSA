package com.dy.AutoTest.OperationPlatform.POJO;

import java.io.Serializable;

public class OperBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String CaseNO;
	private String OperID;
	private String password;
	private String comment;
	private String mobileNO;
	
	
	public OperBean() {
		
	}
	
	
	public OperBean(String operID, String password, String mobileNO, String comment) {
		this.OperID = operID;
		this.password = password;
		this.mobileNO = mobileNO;
		this.comment = comment;
	}
	
	
	public String getCaseNO() {
		return CaseNO;
	}


	public void setCaseNO(String caseNO) {
		CaseNO = caseNO;
	}


	public String getOperID() {
		return OperID;
	}
	public void setOperID(String operID) {
		this.OperID = operID;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNO() {
		return mobileNO;
	}
	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public void displayInfo() {
		System.out.println("TestCaseID:"+CaseNO);
		System.out.println("OperID:"+getOperID());
		System.out.println("password:"+getPassword());
		System.out.println("comment:"+getComment());
		System.out.println("mobileNO:"+getMobileNO());
	}
}
