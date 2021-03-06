package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.model.AddFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.board.model.TextVo;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.util.model.PageVo;

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
	@RequestMapping(value="/boardSet", method= {RequestMethod.POST})
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
			String[] names = req.getParameterValues("boardname");
			String[] dels = req.getParameterValues("boardUse");
			
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
	
	//4. 게시글 목록 페이지 로드
	@RequestMapping(value="/textList", method= {RequestMethod.GET})
	public String textList(BoardVo boardVo, PageVo pageVo, Model model) {	
		int page = pageVo.getPage();
		int pageSize = pageVo.getPageSize();
		String search = pageVo.getSearch();
		String boardid= boardVo.getBoardid();
		
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		pageVo.setPanId(boardid);
		pageVo.setSearch(search);

		logger.debug("#$#pageVo : {}",pageVo);
		
		Map<String, Object> resultMap = boardService.textPagingList(pageVo, boardid);
		List<TextVo> textList = (List<TextVo>) resultMap.get("pageVoList");
		int pageNum = (int)resultMap.get("pageNum");

		logger.debug("#$#textList : {}",textList);
		logger.debug("#$#pageNum : {}",pageNum);
		logger.debug("#$#page : {}",page);
		model.addAttribute("textList", textList);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		
		boardVo =boardService.chackPan(boardVo.getBoardid());
		model.addAttribute("pageVo", pageVo);
		
		return "board/textList";
	}
	
	//view 
	//5. 새글 작성 페이지 로드 
	@RequestMapping("/textEditerView")
	public String textEditerView(HttpServletRequest req, Model model) {
		model.addAttribute("userid", req.getParameter("userid"));
		model.addAttribute("boardid", req.getParameter("boardid"));
		
		model.addAttribute("type", "new");
		return "board/textEditer";
	}
	
	//7. 게시글 수정 페이지로드
	@RequestMapping("/textUpdateView")
	public String textUpdateView(HttpServletRequest req, Model model) {
		model.addAttribute("userid", req.getParameter("userid"));
		model.addAttribute("boardid", req.getParameter("boardid"));
		model.addAttribute("textnum", req.getParameter("textnum"));
		TextVo textVo = boardService.selectText(Integer.parseInt(req.getParameter("textnum")));
		model.addAttribute("textVo", textVo);
		
		//첨부파일목록 
		List<AddFileVo> fileList = boardService.fileList(textVo.getTextnum());
		model.addAttribute("fileList",fileList);
		
		model.addAttribute("type", "update");
		return "board/textEditer";
	}
	
	//8.게시글 답글 페이지로드/
	@RequestMapping("/textReplyEditerView")
	public String textReplyEditerView(HttpServletRequest req, Model model) {
		model.addAttribute("userid", req.getParameter("userid"));
		model.addAttribute("boardid", req.getParameter("boardid"));
		model.addAttribute("textnum", req.getParameter("textnum"));
		TextVo textVo = boardService.selectText(Integer.parseInt(req.getParameter("textnum")));
		model.addAttribute("textVo", textVo);
		
		//첨부파일목록 
		List<AddFileVo> fileList = boardService.fileList(textVo.getTextnum());
		model.addAttribute("fileList",fileList);
		
		model.addAttribute("type", "textReply");
		return "board/textEditer";
	}
	
	//9. 공용 에디터 :  1)새글 type new   2)수정 type update  3)답글 type textReply   	
	@RequestMapping(value="/textEditer", method= {RequestMethod.POST})
	public String textEditer(HttpServletRequest req, Model model,
							 @RequestPart("uploadFile") MultipartFile[] part ) {	 
		//구분
		String viewType = req.getParameter("viewType");
		//주체
		String userid = req.getParameter("userid");
		String boardid = req.getParameter("boardid");
		String texttitle = req.getParameter("texttitle");
		//요소 
		String textsubline = req.getParameter("smarteditor");
	
		//파라미터 debug 
		logger.debug("viewTypeo :{}, boardid : {}, textsubline :{}",viewType,boardid,textsubline);

		TextVo textVo = new TextVo();
		//게시글(개별)
		if(viewType.equals("new")) {
			textVo.setTexttitle(texttitle);
			textVo.setTextsubline(textsubline);
			textVo.setBoardid(boardid);
			textVo.setUserid(userid);
			logger.debug("newSet-TextVo :{}", textVo);
			
			int result = boardService.addText(textVo);
			logger.debug("addText-Result :{}", result);
		}
		
		if(viewType.equals("update")) {
			int textnum = Integer.parseInt(req.getParameter("textnum"));
			textVo = boardService.selectText(textnum);
			logger.debug("asUpdate-TextVo :{}",textVo);
			
			textVo.setTexttitle(texttitle);
			textVo.setTextsubline(textsubline);
			logger.debug("toUpdate-TextVo :{}",textVo);
			
			int result = boardService.textUpdate(textVo);
			logger.debug("dBupdate-Result :{}", result);
		}
		
		if(viewType.equals("textReply")) {
			int textnum = Integer.parseInt(req.getParameter("textnum"));
			
			textVo.setTextnump(textnum);	//+ 부모/자식 설정   |형제는 xml에서 nextval
			textVo.setTexttitle(texttitle);
			textVo.setTextsubline(textsubline);
			textVo.setBoardid(boardid);
			textVo.setUserid(userid);
			logger.debug("newSet-TextVo :{}", textVo);
			
			int result = boardService.addText(textVo);
			logger.debug("addText-Result :{}", result);
		}
		model.addAttribute("textVo", textVo);
		
		
		//첨부파일 갯수 가져오기
		int checkFileCnt = Integer.parseInt(req.getParameter("addDirBtCnt"));
		//파일받아오기 
		for(int i =0; i< checkFileCnt ; i++) {
			try { 
				//해당 반복문에 대한 예외처리(null) 
				if(part[i].getSize()>0) { 	
					String path = "/Users/bhuanchanwoo/git/springBoard/src/main/webapp/files";
					String orginalFileName = part[i].getOriginalFilename();	
					String fileExt = FileUtil.getFileExt(orginalFileName);
					String addfileuuid = UUID.randomUUID().toString()+fileExt; 
				
					File file = new File(path+File.separator+addfileuuid);
					
					AddFileVo addFile = new AddFileVo();
					addFile.setAddfileuuid(addfileuuid);
					addFile.setAddfilename(orginalFileName);
					addFile.setAddfilepath(path);
					addFile.setAddfileext(fileExt);
					if(textVo.getTofile_id()==0)
						addFile.setTextnum(textVo.getTextnum());
					else
						addFile.setTextnum(textVo.getTofile_id());
					logger.debug("fileVo :{}",addFile);
					
					part[i].transferTo(file);	//경로 저장 
					boardService.insertFile(addFile);	//데이터베이스 저장
				
				}
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/textList?page=1&pageSize=10&boardid="+textVo.getBoardid();
	}
	
	
	//6. 상세 페이지 로드  
	@RequestMapping("/textDetail")
	public String textDetail(HttpSession session, BoardVo boardVo, TextVo textVo, ReplyVo replyVo, Model model ) {
		model.addAttribute("userVo", session.getAttribute("uservo"));
		model.addAttribute("textVo", boardService.selectText(textVo.getTextnum()));
		model.addAttribute("boardVo", boardService.chackPan(boardVo.getBoardid()));
		//첨부파일목록 
		List<AddFileVo> fileList = boardService.fileList(textVo.getTextnum());
		model.addAttribute("fileList",fileList);
		
		//댓글목록
		List<ReplyVo> replyList = boardService.replyList(textVo.getTextnum());
		model.addAttribute("replyList", replyList);
		
		return "board/textDetail";
	}
	
	//7. 게시글 삭제 
	@RequestMapping("/textDel")
	public String textDel(BoardVo boardVo, TextVo textVo) {
		boardService.delText(textVo.getTextnum());
		BoardVo board = boardService.chackPan(boardVo.getBoardid());
		return "redirect:/textList?page=1&pageSize=10&boardid="+textVo.getBoardid()+"&boardname="+board.getBoardname();
	}	
		
	//7. 댓글추가 
	@RequestMapping("/textReply")
	public String textReply(TextVo textVo, ReplyVo replyVo) {
		replyVo.setTextnum(textVo.getTextnum());
		replyVo.setReplesubline(replyVo.getReplesubline());
		boardService.addReply(replyVo);
		
		textVo = boardService.selectText(textVo.getTextnum());
		return "redirect:/textDetail?textnum="+textVo.getTextnum()+"&boardid="+textVo.getBoardid();
	}
	
	//7. 댓글삭제 
	@RequestMapping("/replyDel")
	public String replyDel(TextVo textVo, ReplyVo replyVo) {
		int resultReplyDel = boardService.replyDel(replyVo.getRepleid());
		
		textVo = boardService.selectText(textVo.getTextnum());
		return "redirect:/textDetail?textnum="+textVo.getTextnum()+"&boardid="+textVo.getBoardid();
	}
	
}
