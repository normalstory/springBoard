package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.test.ServiceDaoTestConfig;

public class BoardDaoTest extends ServiceDaoTestConfig{

	Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Test
	public void addBoardTest() {
		/***Given***/
		BoardVo boardVo =new BoardVo();
		
		/***When***/
		boardVo.setBoardid("첫판");
		boardVo.setBoarddel("y");
		boardVo.setUserid("boss");		
		logger.debug("boardVo :{}",boardVo);
		
		int resultCnt = boardService.addBoard(boardVo);
		logger.debug("resultCnt :{}",resultCnt);
		
		/***Then***/
	}

}
