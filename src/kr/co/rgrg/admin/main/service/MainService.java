package kr.co.rgrg.admin.main.service;

import kr.co.rgrg.admin.main.dao.MainDAO;
import kr.co.rgrg.admin.main.vo.AdminLoginVO;

public class MainService {
	
	public String adminLogin(AdminLoginVO alVO) {
		
		MainDAO mDAO=MainDAO.getInstance();
		String id=mDAO.selectAdminLogin(alVO);
		
		return id;
	}//adminLogin
	
}//class
