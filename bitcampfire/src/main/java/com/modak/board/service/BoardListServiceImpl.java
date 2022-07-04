package com.modak.board.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modak.board.bean.BoardDTO;
import com.modak.board.bean.BoardPaging;
import com.modak.board.dao.BoardDAO;

@Service
public class BoardListServiceImpl implements BoardListService {
	
	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public String getUserWriteTablelist(int pg) {
		StringBuffer sb = new StringBuffer();
		//페이징 처리하려면 다 받아오면 안되잖아. 몇개씩 표시할지 start랑 end정해줘야 되잖아. 
		
		//최신순으로 정렬할 때, startNum이랑 endNum map에 담아서 보내주기 
		int boardPerPage = 10;
		int startNum = 1 + boardPerPage*(pg-1);
		int endNum = boardPerPage + boardPerPage*(pg-1);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = boardDao.getBoardRangeOrderByTime(map); 
		System.out.println("\n @ boardTalbeList size : " + list.size());
		System.out.println("\n @ getBoardRange parameter : " + pg + map.get("startNum") + map.get("endNum"));
		for(BoardDTO dto : list) {
			sb.append(boardDtoToTrTag(dto));
		}
		
		return sb.toString(); 
	}
	
	//풍혁 (220703) : getUserWriteTablelist() method에서 table에 tr을 추가하는 코드가 너무 길어질 것으로 판단해, tr을 만들어주는 method를 생성했습니다. 
	private String boardDtoToTrTag(BoardDTO boardDTO) {
		StringBuffer tr = new StringBuffer();
		
		//풍혁(220703) : DTO의 Date field를 String으로 변경 시작 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = boardDTO.getBoard_date_created();        
		String dateToStr = dateFormat.format(date);
		//풍혁(220703) : DTO의 Date field를 String으로 변경 마무리
		
		tr.append("<tr>");
			tr.append("<td id = 'td_subject'>");
				tr.append("<span id = 'tdSeq'>"+ boardDTO.getBoard_id()+"</span><span id = 'categoryTag'>"+boardDTO.cateidToString()+"</span> <br>");
				tr.append("<span id = 'boardSubject'>"+boardDTO.getBoard_title()+"</span>");
			tr.append("</td>");
			
			tr.append("<td id = 'td_recommend'>");
				tr.append("<span id = 'boardRecommend'><img alt='thumbs_up.jpg' src='#'>"+ boardDTO.getBoard_vote_cnt() +"</span>");
			tr.append("</td>");
		
			tr.append("<td id = 'td_state'>");
				tr.append("<span id = 'boardState'>"+ boardDTO.getBoard_view_cnt()+"</span>");
			tr.append("</td>");
			
			tr.append("<td id = 'td_author'>");
				tr.append("<span id = 'boardAuthor'> <img alt='user_icon.jpg' src='#'>"+ boardDTO.getBoard_uid()+"<br><span id = 'boardLogdate'>"+ dateToStr +"</span> </span>");
			tr.append("</td>");
			
		tr.append("</tr>");
		
		return tr.toString();
	}
	
	// 풍혁(220703) : list 하단에 pageList 입니다. container에 bean으로 올려서 받아쓰는 방법도 있으나 일단 객체생성 방식으로 사용해보겠습니다. 
	@Override
	public String getBoardPagingList(int pg) {
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(10); //이전 다음 사이에 10개의 page
		boardPaging.setPageSize(10); //page 당 10개의 글 존재
		boardPaging.setTotalA(boardDao.getTotalBoardNum());
		boardPaging.makePagingHTML();
		
		return boardPaging.getPagingHTML().toString();
	}
	
	
}
