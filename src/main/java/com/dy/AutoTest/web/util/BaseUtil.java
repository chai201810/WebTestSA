package com.dy.AutoTest.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class BaseUtil {
/*	
	public static void loadMap(Map<String , Object> map) {
		Map=map;
	}
	
	public static Object getMapValue(String keyName) {
		return null;
	}
	*/
//	public static void loadList(List<Map<String,Object>> list) {
//		List=list;
//	}
//	

	public static String getMapTargetValue(List<Map<String, Object>> list,
			String sourceKeyName,String sourceValue,String targetKeyName) {
		String targetValue="";
		Map<String , Object> map=null;
		int i;
		for(i=0;i<list.size();i++) {
			map=list.get(i);
			if(map.get(sourceKeyName).equals(sourceValue)){
				targetValue= (String)map.get(targetKeyName);
				break;
			}
		}
		if(i==list.size()) {
			System.out.println("The field "+sourceKeyName+"==>"+sourceValue
					+" is not exist in the List! Please check!");
		}else if (targetValue.equals("")) {
			System.out.println("targetValue is null!");
		}
		return targetValue;
	}
	
	
	/**
	 * (String)Date-->(fomat)(String)Date
	 * eg: (String)20180815-->todate()-->fomate():2018-08-15-->(String)2018-08-15
	 * 
	 * 
	 * @param 
	 * @return
	 */
	public static String fomatDateStringToString(String date_yyyymmdd) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=format1.parse(date_yyyymmdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dateString=format2.format(date);
		return dateString;
	}
	public static String fomatDateStringToString(String date_yyyymmdd,String targetFormat) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat(targetFormat);
		Date date=null;
		try {
			date=format1.parse(date_yyyymmdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dateString=format2.format(date);
		return dateString;
	}
	public static String fomatDateStringToString(String sourceDateString,String sourceFormate,String targetFormat) {
		SimpleDateFormat format1 = new SimpleDateFormat(sourceFormate);
		SimpleDateFormat format2 = new SimpleDateFormat(targetFormat);
		Date date=null;
		try {
			date=format1.parse(sourceDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String targetDateString=format2.format(date);
		return targetDateString;
	}
	public static String fomatDateToString(Date date,String targetFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(targetFormat);
		return sdf.format(date);
	}
	
	
	
	public static <T> List<Object> toObject(List<T> list){
		List<Object> objlist = new ArrayList<Object>();
		for(T e : list){
			Object obj = e;
			objlist.add(obj);
		}
		return objlist;
	}
	
	
	
}
