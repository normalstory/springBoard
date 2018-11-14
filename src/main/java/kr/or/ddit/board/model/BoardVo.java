package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	private String 	boardid;
	private String 	boardname;
	private String 	boarddel;
	private Date 	boardbirth;
	private int 	boardnum;
	private int 	dragnum;
	private String 	userid;
	
	public BoardVo() {}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getBoardid() {
		return boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public String getBoardname() {
		return boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}

	public String getBoarddel() {
		return boarddel;
	}

	public void setBoarddel(String boarddel) {
		this.boarddel = boarddel;
	}

	public Date getBoardbirth() {
		return boardbirth;
	}

	public void setBoardbirth(Date boardbirth) {
		this.boardbirth = boardbirth;
	}

	public int getDragnum() {
		return dragnum;
	}

	public void setDragnum(int dragnum) {
		this.dragnum = dragnum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "BoardVo [boardnum=" + boardnum + ", boardid=" + boardid + ", boardname=" + boardname + ", boarddel="
				+ boarddel + ", boardbirth=" + boardbirth + ", dragnum=" + dragnum + ", userid=" + userid + "]";
	}
	
}
