package com.modak.board.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPaging {

	private int currentPage; //현재페이지
	private int pageBlock; //[이전][1][2][3][다음]
	private int pageSize; //페이지당 몇개 표시할건지 
	private int totalA; //총글수
	private StringBuffer pagingHTML;
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
	
		int totalP = (int)(Math.ceil(totalA / (float)pageSize));
		//int totalP = ( totalA - 1) / ( pageSize + 1); //총 페이지 수
		int startPage = (currentPage-1) / pageBlock * pageBlock +1; //시작 페이지 번호 
		int endPage = startPage + pageBlock - 1;
		if(endPage > totalP) {
			endPage = totalP;
		}
		
		System.out.println("@@@ caled totalP = " + totalP + "@@@ caled startPage  = " + startPage +"@@@ caled endPage = " + endPage );
		
		if(startPage != 1) { //if(startPage > pageBlock)
			int previousPage = startPage-1;
			pagingHTML.append("[<span id='paging' class='listPage'>이전</span>]");
		}
		
		for(int i = startPage; i<=endPage; i++) {
			if(i == currentPage) {
				pagingHTML.append("[<span id = 'currentPaging' class='listPage'>" + i + "</span>]" );
			}else {
				pagingHTML.append("[<span id = 'paging' class='listPage'>" + i + "</span>]" );
			}
		}
			
		if(endPage < totalP) {
				int nextPage = endPage+1;
				pagingHTML.append("[<span id = 'paging' class='listPage'> 다음 </span>]" );
		}
	}
}
