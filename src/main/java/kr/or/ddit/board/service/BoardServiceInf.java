package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.TextVo;
import kr.or.ddit.util.model.PageVo;

public interface BoardServiceInf {

	int addBoard(BoardVo boardVo);

	List<BoardVo> boardList();

	List<BoardVo> boardManu();

	BoardVo chackPan(String string);

	int updatePan(BoardVo panVo);
	
	int pageCnt(String panId);
	Map<String, Object> textPagingList(PageVo pageVo, String panId);
	
}
