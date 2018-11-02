package com.dy.AutoTest.PersonPortal.PageObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.web.actions.Do;
import com.dy.AutoTest.web.util.Page;

public class TransactionPage {
	private WebDriver driver=null;
	private Do du=null;
	private Page page=null;
	private int totalCount;
	private int totalPages;
	
	public TransactionPage(WebDriver driver) {
		this.driver=driver;
		du=new Do(driver);
	}
	
	public void doDateSearch() {
		du.what("a_week").click();
		du.waitFor(2000);
		du.what("a_month").click();
		du.waitFor(2000);
		du.what("a_halfyear").click();
		du.waitFor(2000);
		du.what("a_today").click();
		du.waitFor(2000);
		du.what("a_year").click();
		du.waitFor(2000);
		
		du.what("a_month").click();
		du.waitFor(2000);
	}
	
	public void doPurchaseSearch() {
		du.what("a_purchase").click();
		du.waitFor(2000);
//			消费流程是：进行中、成功、过期、关闭、退款、全部
			du.what("purchase_status_ing").click();
			du.waitFor(2000);
			du.what("purchase_status_success").click();
			du.waitFor(2000);
			du.what("purchase_status_expired").click();
			du.waitFor(2000);
			du.what("purchase_status_close").click();
			du.waitFor(2000);
			du.what("purchase_status_refund").click();
			du.waitFor(2000);
			du.what("purchase_status_all").click();
			du.waitFor(2000);
	}
	
	public void doDeposit() {
		du.what("a_deposit").click();
		du.waitFor(2000);
			du.what("deposit_status_waiting").click();
			du.waitFor(2000);
			du.what("deposit_status_success").click();
			du.waitFor(2000);
			du.what("deposit_status_failed").click();
			du.waitFor(2000);
			du.what("deposit_status_all").click();
			du.waitFor(2000);
	}
	
	public void doWithdraw() {
		du.what("a_withdraw").click();
		du.waitFor(2000);
			du.what("withdraw_status_ing").click();
			du.waitFor(2000);
			du.what("withdraw_status_success").click();
			du.waitFor(2000);
			du.what("withdraw_status_failed").click();
			du.waitFor(2000);
			du.what("withdraw_status_all").click();
			du.waitFor(2000);
	}
	
	public void doTransfer() {
		du.what("a_transfer").click();
		du.waitFor(2000);
			du.what("transfer_status_ing").click();
			du.waitFor(2000);
			du.what("transfer_status_success").click();
			du.waitFor(2000);
			du.what("transfer_status_failed").click();
			du.waitFor(2000);
			du.what("transfer_status_all").click();
			du.waitFor(2000);
	}
	
	public int getCount() {
		String sumString=du.what("count").getText();
		int totalCount=0;
		//获取总条数
		String regex="\\d+";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(sumString);
		if(matcher.find()) {
			totalCount=Integer.parseInt(matcher.group());
		}else {
			System.out.println("查询记录为0条");
		}
		return totalCount;
	}
	
	public void doPageTurning() {
		totalCount=getCount();
		page=new Page(totalCount);
		totalPages=page.getTotalPages();
		if(totalPages==1) {
			System.out.println("记录只有1页，无需测试翻页");
		}else {
			//依次点击下一页按钮
			for(int i=1;i<=totalPages;i++) {
				du.what("pageNO_Button","›").click();
				du.waitFor(2000);
			}
			//依次点击上一页按钮
			for(int i=totalPages;i>=1;i--) {
				du.what("pageNO_Button","‹").click();
				du.waitFor(2000);
				
			}
			//按照页码依次点击
			for(int i=1;i<=totalPages;i++) {
				du.what("pageNO_Button",""+i).click();
				du.waitFor(2000);
				
			}
			//点击首页按钮
			du.what("pageNO_Button","«").click();
			du.waitFor(2000);
			//点击尾页按钮
			du.what("pageNO_Button","»").click();
		}
		
	}
	
	
	
}
