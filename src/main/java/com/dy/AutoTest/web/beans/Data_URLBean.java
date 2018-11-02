package com.dy.AutoTest.web.beans;

public class Data_URLBean {
	
	
	private String ID ;
	private String URL         ;
	private String Comment     ;
	
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}

	public void displayInfo() {
		System.out.println("ID:"+getID());
		System.out.println("URL:"+getURL());
		System.out.println("Comment:"+getComment());
	}
}
