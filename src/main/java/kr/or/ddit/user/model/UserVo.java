package kr.or.ddit.user.model;

import java.util.Date;

public class UserVo {

	private String userid;
	private String username;
	private String userpass; 
	private String useraddr1;
	private String useraddr2;
	private String userzipcode;
	private Date   userbirth;
	private String useremail; 
	private String usertel;
	private String userprofile;

	public UserVo(){}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUseraddr1() {
		return useraddr1;
	}

	public void setUseraddr1(String useraddr1) {
		this.useraddr1 = useraddr1;
	}

	public String getUseraddr2() {
		return useraddr2;
	}

	public void setUseraddr2(String useraddr2) {
		this.useraddr2 = useraddr2;
	}

	public String getUserzipcode() {
		return userzipcode;
	}

	public void setUserzipcode(String userzipcode) {
		this.userzipcode = userzipcode;
	}

	public Date getUserbirth() {
		return userbirth;
	}

	public void setUserbirth(Date userbirth) {
		this.userbirth = userbirth;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsertel() {
		return usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(String userprofile) {
		this.userprofile = userprofile;
	}

	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", username=" + username + ", userpass=" + userpass + ", useraddr1="
				+ useraddr1 + ", useraddr2=" + useraddr2 + ", userzipcode=" + userzipcode + ", userbirth=" + userbirth
				+ ", useremail=" + useremail + ", usertel=" + usertel + ", userprofile=" + userprofile + "]";
	}	
	
}


