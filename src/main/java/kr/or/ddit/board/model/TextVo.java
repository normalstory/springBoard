package kr.or.ddit.board.model;

import java.util.Date;

public class TextVo {
	private int 	textnum;
	private String  texttitle;
	private String  textsubline;
	private Date	textbirth;
	private String  textstate;
	private Date 	textdelday;
	private int 	textseqnum;
	private int 	textnump;
	private int 	tofile_id;
	private String  repleid;
	private String  boardid; 
	private String  userid;
	private String  t;	//for list alias
	
	public TextVo() {}

	public int getTextnum() {
		return textnum;
	}

	public void setTextnum(int textnum) {
		this.textnum = textnum;
	}

	public String getTexttitle() {
		return texttitle;
	}

	public void setTexttitle(String texttitle) {
		this.texttitle = texttitle;
	}

	public String getTextsubline() {
		return textsubline;
	}

	public void setTextsubline(String textsubline) {
		this.textsubline = textsubline;
	}

	public Date getTextbirth() {
		return textbirth;
	}

	public void setTextbirth(Date textbirth) {
		this.textbirth = textbirth;
	}

	public String getTextstate() {
		return textstate;
	}

	public void setTextstate(String textstate) {
		this.textstate = textstate;
	}

	public Date getTextdelday() {
		return textdelday;
	}

	public void setTextdelday(Date textdelday) {
		this.textdelday = textdelday;
	}

	public int getTextseqnum() {
		return textseqnum;
	}

	public void setTextseqnum(int textseqnum) {
		this.textseqnum = textseqnum;
	}

	public int getTextnump() {
		return textnump;
	}

	public void setTextnump(int textnump) {
		this.textnump = textnump;
	}

	public int getTofile_id() {
		return tofile_id;
	}

	public void setTofile_id(int tofile_id) {
		this.tofile_id = tofile_id;
	}

	public String getRepleid() {
		return repleid;
	}

	public void setRepleid(String repleid) {
		this.repleid = repleid;
	}

	public String getBoardid() {
		return boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "TextVo [textnum=" + textnum + ", texttitle=" + texttitle + ", textsubline=" + textsubline
				+ ", textbirth=" + textbirth + ", textstate=" + textstate + ", textdelday=" + textdelday
				+ ", textseqnum=" + textseqnum + ", textnump=" + textnump + ", tofile_id=" + tofile_id + ", repleid="
				+ repleid + ", boardid=" + boardid + ", userid=" + userid + ", t=" + t + "]";
	}

}
 