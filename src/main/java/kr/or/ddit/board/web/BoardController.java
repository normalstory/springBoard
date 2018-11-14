package kr.or.ddit.board.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	//1. 페이지 로드 
	@RequestMapping("/main")
	public String loginView() {		
		return "main";
	}
	
	//1. 페이지 로드 
	@RequestMapping("/boardSetView")
	public String boardSet(HttpServletRequest req) {	
		List<BoardVo> boardList = boardService.boardList();
		req.setAttribute("boardList", boardList);
		return "board/boardSet";
	}
	
	@RequestMapping(name="/boardSet",method= {RequestMethod.POST})
	public String boardSetCreate(HttpServletRequest req, BoardVo boardVo) {

		//게시판을 추가하는 경우(한개 form으로 두 기능 시행을 위해)
		String setCase = req.getParameter("setCase");
		logger.debug("**setCase : {}",setCase);
		if(setCase.equals("add")){
			boardVo.setBoardname(req.getParameter("boardname"));
			boardVo.setBoarddel(req.getParameter("boarddel"));
			boardVo.setUserid(req.getParameter("userid"));
			
			boardService.addBoard(boardVo);	
			req.getServletContext().setAttribute("boardVo", boardVo);
			
			List<BoardVo> boardManu = boardService.boardManu();
			req.getServletContext().setAttribute("boardManu", boardManu);
			
		}
		return "redirect:/boardSetView";
	}
	
	
}
