package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.TextVo;
import kr.or.ddit.util.model.PageVo;

@Service
public class BoardService implements BoardServiceInf{

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
		System.out.println("&&&pageList : " + pageList);
		int pageCnt = boardDao.pageCnt(boardid);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageVoList", pageList);
		resultMap.put("pageNum", (int)Math.ceil((double)pageCnt/pageVo.getPageSize()));
		
		return resultMap;
	}


	
}
