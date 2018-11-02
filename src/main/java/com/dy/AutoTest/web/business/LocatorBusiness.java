package com.dy.AutoTest.web.business;

import java.util.List;
import java.util.Map;

import com.dy.AutoTest.web.dao.impl.TestingDaoImpl;

public class LocatorBusiness {
	private List<Map<String, Object>> list;
	private Map<String, Object> map;
	private TestingDaoImpl testingDao;
	
	public LocatorBusiness(String tableName) {
		testingDao=new TestingDaoImpl();
		list=testingDao.getLocator(tableName);
	}
	
	public String getXPath(String elementName) {
		String xPath="";
		int i;
		for(i=0;i<list.size();i++) {
			map=list.get(i);
			if(map.get("ElementName").equals(elementName)){
				xPath= (String)map.get("XPath");
				break;
			}
		}
		if(i==list.size()) {
//			System.out.println(Thread.currentThread() .getStackTrace()[1].getClassName()+
//					"."+Thread.currentThread().getStackTrace()[1].getMethodName()+": ElementName: "+elementName+" in table is not exist! Please check!");
			System.out.println("LocatorBusiness.getXPath: ElementName("+elementName+") in table is not exist! Please check!");
		}else if (xPath.equals("")) {
			System.out.println("Element XPath is null!");
		}
		return xPath;
	}
	public String getCSS(String elementName) {
		String CSS="";
		int i;
		for(i=0;i<list.size();i++) {
			map=list.get(i);
			if(map.get("ElementName").equals(elementName)
					&& !map.get("CSS").equals("")){
				CSS= (String)map.get("CSS");
				break;
			}
		}
		if(i==list.size()) {
//			System.out.println(Thread.currentThread() .getStackTrace()[1].getClassName()+
//					"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"ElementName: "+elementName+" in table is not exist! Please check!");
			System.out.println("LocatorBusiness.getCSS: ElementName("+elementName+") in table is not exist! Please check!");
		}else if (CSS.equals("")) {
			System.out.println("Element CSS is null!");
		}
		return CSS;
	}
	
/*	
	public String getLoginPageXPath(String elementName) {
		list=testingDao.getLoginPageLocator();
		String xPath="";
		for(int i=0;i<list.size();i++) {
			map=list.get(i);
			if(map.get("ElementName").equals(elementName)
					&& !map.get("XPath").equals("")){
				xPath= (String)map.get("XPath");
				break;
			}
		}
		if (xPath.equals("")) {
			System.out.println("ElementName is not exist! Please check!");
		}
		return xPath;
	}
	
	public String getLoginPageCSS(String elementName) {
		list=testingDao.getLoginPageLocator();
		String CSS="";
		for(int i=0;i<list.size();i++) {
			map=list.get(i);
			if(map.get("ElementName").equals(elementName)
					&& !map.get("CSS").equals("")){
				CSS= (String)map.get("CSS");
				break;
			}
		}
		if (CSS.equals("")) {
			System.out.println("ElementName is not exist! Please check!");
		}
		return CSS;
	}
*/
}
