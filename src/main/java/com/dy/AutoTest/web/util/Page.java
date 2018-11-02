package com.dy.AutoTest.web.util;



/**
 * ��ҳ��
 * @author Jerry
 *
 */

/*public class Page<T> {
	
}*/
public class Page {
	private int pageSize =10;
	private int totalCount;
	private int totalPages;
	private int start; //��ʼ����
	private int pageNo;//��ǰҳ
//	private List<T> pageList;//����
	
	public Page(int totalCount) {
		this.totalCount=totalCount;
	}
	/**	
	*��ȡ��ǰҳ��
	*/
	public int getCurrentPageNo(){
        return start / pageSize + 1;
    }
	/**
	*�Ƿ�����һҳ
	*/
	public boolean getHasNextPage(){
        return getCurrentPageNo() < totalPages;
    }
	/**
	*�Ƿ�����һҳ
	*/
	 public boolean getHasPrePage(){
	        return getCurrentPageNo() > 1;
	    }
	/**
	*��ȡ��ҳ��
	 */
	public int getTotalPages() {
        totalPages = totalCount / pageSize;
        if(totalCount % pageSize != 0){
            totalPages++;
        }
        return totalPages;
    }
	/**
	*��ȡ��ҳ�����ع���
	 */
	public int getTotalPages(int pageSize) {
		this.pageSize=pageSize;
        totalPages = totalCount / pageSize;
        if(totalCount % pageSize != 0){
            totalPages++;
        }
        return totalPages;
    }
	/**
	 * ��ÿ�ʼ��ҳ������
	 * @param pageNo
	 * @return
	 */
	public int getStart(int pageNo){
        if(pageNo < 1){
            pageNo = 1;
        }
        else if(getTotalPages()>0&&pageNo > getTotalPages()){
            pageNo = getTotalPages();
        }
          
        start = (pageNo-1) * pageSize+1;
        return start;
    }
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
		System.out.println(pageSize);
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	
	
}
