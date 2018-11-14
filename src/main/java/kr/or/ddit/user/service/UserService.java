package kr.or.ddit.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;

@Service
public class UserService implements UserServiceInf{
	
	@Resource(name="userDao")
	private UserDaoInf userDao;

	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}
	
	
	
}
