package kr.co.rgrg.admin.user.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.rgrg.admin.dao.GetRgrgHandler;
import kr.co.rgrg.admin.user.domain.UserListDomain;
import kr.co.rgrg.admin.pagination.RangeVO;

public class UserDAO {
	private static UserDAO uDAO;
	
	public UserDAO() {
		
	}
	
	public static UserDAO getInstance() {
		if (uDAO == null) {
			uDAO = new UserDAO();
		}
		return uDAO;
	} //getInstance
	
	
	
	/**
	 * 회원 정보를 전부 조회함(관리자용)
	 * @return
	 */
	public List<UserListDomain> selectUserList(RangeVO rVO) {
		List<UserListDomain> userList = null;
		
		SqlSession ss = GetRgrgHandler.getInstance().getSqlSession();
		userList = ss.selectList("kr.co.rgrg.admin.main.selectUserList", rVO);
		ss.close();

		return userList;
	}
	
}
