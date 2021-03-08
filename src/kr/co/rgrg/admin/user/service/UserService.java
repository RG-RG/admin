package kr.co.rgrg.admin.user.service;

import java.util.List;

import kr.co.rgrg.admin.user.dao.UserDAO;
import kr.co.rgrg.admin.user.domain.UserListDomain;

public class UserService {
	
	/**
	 * 모든 사용자의 목록을 반환함(관리자용)
	 * @return
	 */
	public List<UserListDomain> userList(){
		List<UserListDomain> userList = null;
		
		UserDAO uDAO = UserDAO.getInstance();
		userList = uDAO.selectUserList();
		
		return userList; 
	}

}
