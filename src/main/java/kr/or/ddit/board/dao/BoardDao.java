package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.AddFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.board.model.TextVo;
import kr.or.ddit.board.web.BoardController;
import kr.or.ddit.util.model.PageVo;

@Repository
public class BoardDao implements BoardDaoInf{

	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
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

	@Override
	public List<TextVo> textList(PageVo pageVo) {
		
		logger.debug("#$# pageVo : {} " , pageVo);
		return template.selectList("board.textList", pageVo);
	}

	@Override
	public int pageCnt(String panId) {
		return template.selectOne("board.pageCnt",panId);
	}

	@Override
	public int addText(TextVo textVo) {
		return template.insert("board.addText", textVo);
	}

	@Override
	public int insertFile(AddFileVo addFile) {
		return template.insert("board.addFile", addFile);
	}

	@Override
	public TextVo selectText(int textNum) {
		return template.selectOne("board.selectText", textNum);
	}

	@Override
	public int delText(int textnum) {
		return template.delete("board.delText", textnum);
	}

	@Override
	public List<AddFileVo> fileList(int textnum) {
		return template.selectList("board.fileList", textnum);
	}

	@Override
	public int addReply(ReplyVo reply) {
		return template.insert("board.addReply", reply);
	}

	@Override
	public List<ReplyVo> replyList(int textnum) {
		return template.selectList("board.replyList", textnum);
	}

	@Override
	public int replyDel(String repleid) {
		return template.update("board.replyDel", repleid);
	}

	@Override
	public int textUpdate(TextVo textVo) {
		return template.update("board.textUpdate", textVo);
	}

	@Override
	public AddFileVo fileSelectByUUID(String addfileuuid) {
		return template.selectOne("board.fileSelectByUUID", addfileuuid);
	}

	
}
