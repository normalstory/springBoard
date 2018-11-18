package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.AddFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.board.model.TextVo;
import kr.or.ddit.util.model.PageVo;

public interface BoardDaoInf {

	int addBoard(BoardVo boardVo);

	List<BoardVo> boardList();

	List<BoardVo> boardManu();

	BoardVo chackPan(String string);

	int updatePan(BoardVo boardVo);
	
	List<TextVo> textList(PageVo pageVo);

	int pageCnt(String panId);

	int addText(TextVo textVo);

	int insertFile(AddFileVo addFile);

	TextVo selectText(int textNum);

	int delText(int textnum);

	List<AddFileVo> fileList(int textnum);

	int addReply(ReplyVo reply);

	List<ReplyVo> replyList(int textnum);

	int replyDel(String repleid);

	int textUpdate(TextVo textVo);

	AddFileVo fileSelectByUUID(String addfileuuid);
	
}
