package kr.or.ddit.board.model;

public class AddFileVo {

	private int    addfilenum;
	private String addfileuuid;
	private String addfilename; 
	private String addfileext; 
	private String addfilepath; 
	private int    textnum;
	
	public AddFileVo() {}

	public int getAddfilenum() {
		return addfilenum;
	}

	public void setAddfilenum(int addfilenum) {
		this.addfilenum = addfilenum;
	}

	public String getAddfileuuid() {
		return addfileuuid;
	}

	public void setAddfileuuid(String addfileuuid) {
		this.addfileuuid = addfileuuid;
	}

	public String getAddfilename() {
		return addfilename;
	}

	public void setAddfilename(String addfilename) {
		this.addfilename = addfilename;
	}

	public String getAddfileext() {
		return addfileext;
	}

	public void setAddfileext(String addfileext) {
		this.addfileext = addfileext;
	}

	public String getAddfilepath() {
		return addfilepath;
	}

	public void setAddfilepath(String addfilepath) {
		this.addfilepath = addfilepath;
	}

	public int getTextnum() {
		return textnum;
	}

	public void setTextnum(int textnum) {
		this.textnum = textnum;
	}

	@Override
	public String toString() {
		return "AddFileVo [addfilenum=" + addfilenum + ", addfileuuid=" + addfileuuid + ", addfilename=" + addfilename
				+ ", addfileext=" + addfileext + ", addfilepath=" + addfilepath + ", textnum=" + textnum + "]";
	}

	
}
