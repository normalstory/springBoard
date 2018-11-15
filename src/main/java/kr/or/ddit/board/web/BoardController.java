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
	
	//1. 메인페이지 
	@RequestMapping("/main")
	public String loginView() {		
		return "main";
	}
	
	//2. 게시판관리 페이지 로드 
	@RequestMapping("/boardSetView")
	public String boardSet(HttpServletRequest req) {	
		List<BoardVo> boardList = boardService.boardList();
		req.setAttribute("boardList", boardList);
		return "board/boardSet";
	}

	//3. 게시판관리 페이지 : 게시판 추가, 업데이트, 리스트(메뉴) 출력
	@RequestMapping(name="/boardSet",method= {RequestMethod.POST})
	public String boardSetCreate(HttpServletRequest req, BoardVo boardVo) {

		//게시판을 추가하는 경우(한개 form으로 두 기능 시행을 위해)
		String setCase = req.getParameter("setCase");
		logger.debug("**setCase : {}",setCase);
		if(setCase.equals("add")){
			boardVo.setBoardname(req.getParameter("addboardname"));
			boardVo.setBoarddel(req.getParameter("boarddel"));
			boardVo.setUserid(req.getParameter("userid"));
			
			boardService.addBoard(boardVo);	
			req.getServletContext().setAttribute("boardVo", boardVo);
			
		}
		
		if(setCase.equals("update")){
			//다중처리 
			String[] panIds = req.getParameterValues("boardupid");
			System.out.println(" 다중 게시판 출력 여부들  : " + panIds.length);
			System.out.println(" 0번 방 게시판 id  : " + panIds[0]);
			String[] names = req.getParameterValues("boardname");
			System.out.println(" 다중 게시판 이름들  : " + names.length);
			System.out.println(" 0번 방 게시판 이름  : " + names[0]);
			String[] dels = req.getParameterValues("boardUse");
			System.out.println(" 다중 게시판 출력 여부들  : " + dels.length);
			System.out.println(" 0번 방 게시판 출력 여 : " + dels[0]);
			
			for(int i=0; i<names.length-1; i++) {	
				System.out.println("panIds[i] : "+panIds[i]);
				BoardVo panVo = boardService.chackPan(panIds[i]);
				System.out.println("업데이트되는 panVo 상세 : "+ panVo);
				panVo.setBoardname(names[i]);
				panVo.setBoarddel(dels[i]);
				panVo.setBoardnum(i);
				
				int updatePanResult = boardService.updatePan(panVo);
				System.out.println(i+ ". 게시판관리 > panVo 수정: 성공1,실패0 : "+ updatePanResult);
				req.getServletContext().setAttribute("boardVo", panVo);
			}
		}
		List<BoardVo> boardManu = boardService.boardManu();
		req.getServletContext().setAttribute("boardManu", boardManu);
		return "redirect:/boardSetView";
	}
	
	
	//4. 게시글 작성 페이지 로드
	@RequestMapping("/textEditer")
	public String textEditer() {	
		return "board/textEditer";
	}
	
}
