package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

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
	
	
}
