package kr.or.ddit.board.model;

import java.util.Date;

public class Reply {
	private String repleid;
	private int textnum;
	private String replesubline;
	private Date replebirth;
	private String replestate; 
	private Date repledelday;
	
	public Reply() {}

	public String getRepleid() {
		return repleid;
	}

	public void setRepleid(String repleid) {
		this.repleid = repleid;
	}

	public int getTextnum() {
		return textnum;
	}

	public void setTextnum(int textnum) {
		this.textnum = textnum;
	}

	public String getReplesubline() {
		return replesubline;
	}

	public void setReplesubline(String replesubline) {
		this.replesubline = replesubline;
	}

	public Date getReplebirth() {
		return replebirth;
	}

	public void setReplebirth(Date replebirth) {
		this.replebirth = replebirth;
	}

	public String getReplestate() {
		return replestate;
	}

	public void setReplestate(String replestate) {
		this.replestate = replestate;
	}

	public Date getRepledelday() {
		return repledelday;
	}

	public void setRepledelday(Date repledelday) {
		this.repledelday = repledelday;
	}

	@Override
	public String toString() {
		return "Reply [repleid=" + repleid + ", textnum=" + textnum + ", replesubline=" + replesubline + ", replebirth="
				+ replebirth + ", replestate=" + replestate + ", repledelday=" + repledelday + "]";
	}	
}
