package com.modak.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.modak.board.service.BoardListService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	//Board 공통 영역 : 시작 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		@Autowired
		private BoardListService boardListService;
		//풍혁 (0704) : 여유가 있다면 간단한 설명 주석으로 달아주세요~ 
	//Board 공통 영역 : 끝 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	//풍혁 : 시작 ==================================
		//boardList 띄우기.. 게시판 별 boardList
		@GetMapping(value = "/list")
		public ModelAndView boardList(@RequestParam(value = "pg", required = false, defaultValue = "1") int pg) {
			
			//ajax방식으로 할 거 아니면, String이나 String Buffer 물어와야 됨. 
			System.out.println("/boardList/list mapping..!!");
			
			String userWriteTableList = boardListService.getUserWriteTablelist(pg);
			String boardPagingList = boardListService.getBoardPagingList(pg);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("userWriteTableList", userWriteTableList);
			mav.addObject("boardPagingList", boardPagingList);
			mav.setViewName("/board/boardList");
			
			return mav;
		}
	//풍혁 : 끝 ====================================
	
		
	// 은혜 : 시작   @@@@@@@@@@@@@@@@@@@@@@@  
	
	// 은혜 : 끝  @@@@@@@@@@@@@@@@@@@@@@@ 
	
	
	// 정수 : 시작  ###################### 
	
	// 정수 : 끝  ###################### 
			
				
}
