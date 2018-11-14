package kr.or.ddit.board.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	//1. 페이지 로드 
	@RequestMapping("/main")
	public String loginView() {		
		return "main";
	}
	
	//1. 페이지 로드 
	@RequestMapping("/boardSetView")
	public String boardSet() {		
		return "board/boardSet";
	}
	
	@RequestMapping("/boardSet")
	public String boardSetCreate(@RequestParam("userid")String userId, BoardVo boardVo, Model model) {
		String userid = userId;
		String boardId = boardVo.getBoardid();
		String boardDel = boardVo.getBoarddel();
		
		boardVo.setBoardid(boardId);
		boardVo.setBoarddel(boardDel);
		boardVo.setUserid(userid);
		
		int resultCnt = boardService.addBoard(boardVo);
		
		model.addAttribute("boardVo", boardVo);		
		
		return "board/boardSet";
	}
	
	
}
