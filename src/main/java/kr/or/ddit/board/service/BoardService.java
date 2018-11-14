package kr.or.ddit.board.service;

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
	
	
}
