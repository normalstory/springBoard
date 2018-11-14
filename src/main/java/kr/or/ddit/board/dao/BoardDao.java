package kr.or.ddit.board.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVo;

@Repository
public class BoardDao implements BoardDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int addBoard(BoardVo boardVo) {
		return template.insert("board.addBoard", boardVo);
	}
	
	
}
