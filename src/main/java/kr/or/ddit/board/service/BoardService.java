package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.AddFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.board.model.TextVo;
import kr.or.ddit.board.web.BoardController;
import kr.or.ddit.util.model.PageVo;

@Service
public class BoardService implements BoardServiceInf{

	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;

	@Override
	public int addBoard(BoardVo boardVo) {
		return boardDao.addBoard(boardVo);
	}

	@Override
	public List<BoardVo> boardList() {
		return boardDao.boardList();
	}

	@Override
	public List<BoardVo> boardManu() {
		return boardDao.boardManu();
	}

	@Override
	public BoardVo chackPan(String string) {
		return boardDao.chackPan(string);
	}

	@Override
	public int updatePan(BoardVo boardVo) {
		return boardDao.updatePan(boardVo);
	}

	@Override
	public int pageCnt(String panId) {
		return boardDao.pageCnt(panId);
	}

	@Override
	public Map<String, Object> textPagingList(PageVo pageVo, String boardid) {
		List<TextVo> pageList =boardDao.textList(pageVo);
		logger.debug("#$# pageList : {} " , pageList);
		
		int pageCnt = boardDao.pageCnt(boardid);
		logger.debug("#$# pageCnt : {} " , pageCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageVoList", pageList);
		resultMap.put("pageNum", (int)Math.ceil((double)pageCnt/pageVo.getPageSize()));
		
		return resultMap;
	}

	@Override
	public int addText(TextVo textVo) {
		return boardDao.addText(textVo);
	}

	@Override
	public int insertFile(AddFileVo addFile) {
		return boardDao.insertFile(addFile);
	}

	@Override
	public TextVo selectText(int textNum) {
		return boardDao.selectText(textNum);
	}

	@Override
	public int delText(int textnum) {
		return boardDao.delText(textnum);
	}

	@Override
	public List<AddFileVo> fileList(int textnum) {
		return boardDao.fileList(textnum);
	}

	@Override
	public int addReply(ReplyVo reply) {
		return boardDao.addReply(reply);
	}

	@Override
	public List<ReplyVo> replyList(int textnum) {
		return boardDao.replyList(textnum);
	}

	@Override
	public int replyDel(String repleid) {
		return boardDao.replyDel(repleid);
	}

	@Override
	public int textUpdate(int textnum) {
		return boardDao.textUpdate(textnum) ;
	}

	@Override
	public AddFileVo fileSelectByUUID(String addfileuuid) {
		return boardDao.fileSelectByUUID(addfileuuid);
	}


	
}
