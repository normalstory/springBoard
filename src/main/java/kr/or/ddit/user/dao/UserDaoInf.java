package kr.or.ddit.user.dao;

import kr.or.ddit.user.model.UserVo;

public interface UserDaoInf {

	UserVo selectUser(String userid);
	
}
