package kr.co.rgrg.admin.user.service;

import java.util.List;

import kr.co.rgrg.admin.user.dao.UserDAO;
import kr.co.rgrg.admin.user.domain.UserListDomain;
import kr.co.rgrg.admin.pagination.RangeVO;

public class UserService {
	
	/**
	 * 모든 사용자의 목록을 반환함(관리자용)
	 * @return
	 */
	public List<UserListDomain> userList(RangeVO rVO){
		List<UserListDomain> userList = null;
		
		UserDAO uDAO = UserDAO.getInstance();
		userList = uDAO.selectUserList(rVO);
		
		return userList; 
	}

}
