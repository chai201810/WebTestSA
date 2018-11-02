package com.dy.AutoTest.web.beans;

public class LocatorBean {
	private String ID      ;
	private String ElementName;
	private String XPath      ;
	private String CSS        ;
	private String Type       ;
	private String Parent     ;
	private String Comment    ;
	
	
	public LocatorBean() {
		
	}
	public LocatorBean(String elementName, String xPath) {
		ElementName = elementName;
		XPath = xPath;
	}
	public LocatorBean(String elementName, String xPath, String cSS, String type, String parent,
			String comment) {
		ElementName = elementName;
		XPath = xPath;
		CSS = cSS;
		Type = type;
		Parent = parent;
		Comment = comment;
	}
	public LocatorBean(String iD, String elementName, String xPath, String cSS, String type, String parent,
			String comment) {
		ID = iD;
		ElementName = elementName;
		XPath = xPath;
		CSS = cSS;
		Type = type;
		Parent = parent;
		Comment = comment;
	}


	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getElementName() {
		return ElementName;
	}
	public void setElementName(String elementName) {
		ElementName = elementName;
	}
	public String getXPath() {
		return XPath;
	}
	public void setXPath(String xPath) {
		XPath = xPath;
	}
	public String getCSS() {
		return CSS;
	}
	public void setCSS(String cSS) {
		CSS = cSS;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getParent() {
		return Parent;
	}
	public void setParent(String parent) {
		Parent = parent;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}

	
}
