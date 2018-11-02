package com.dy.AutoTest.web.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class OpenCSVUtil {
	private String filePath;
	private String nextLine[];
	private String value;
	List<String[]> approvalList=new ArrayList<String []>();
	CSVReader reader;

	public OpenCSVUtil(String filePath) {
		this.filePath=filePath;
	}

	public String getData(String lineName,String columnName) {
		
		try {
			//throw FileNotFoundException
			reader=new CSVReader(new FileReader(filePath));
				//throw IOException
				while((nextLine=reader.readNext())!=null) {
					approvalList.add(nextLine);
				}
				
//			int count=0;
			int index=0;
			//字段名
			for(String j:approvalList.get(0)) {
//				count++;
//				if(j.equals(columnName)) {
//					index=count-1;
//				}
				if(j.equals(columnName)) 
//					break;
				index++;
			}
			
			for(String [] i:approvalList) {
				if(i[0].equals(lineName))
					value=i[index].toString();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
