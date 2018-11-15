package kr.or.ddit.board.dao;

import java.util.List;

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

	@Override
	public List<BoardVo> boardList() {
		return template.selectList("board.boardList");
	}

	@Override
	public List<BoardVo> boardManu() {
		return template.selectList("board.boardManu");
	}

	@Override
	public BoardVo chackPan(String string) {
		return template.selectOne("board.chackPan", string);
	}

	@Override
	public int updatePan(BoardVo boardVo) {
		return template.update("board.updatePan", boardVo);
	}
	
	
}
