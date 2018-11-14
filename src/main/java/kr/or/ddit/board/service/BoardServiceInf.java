package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {

	int addBoard(BoardVo boardVo);

	List<BoardVo> boardList();

	List<BoardVo> boardManu();

}
