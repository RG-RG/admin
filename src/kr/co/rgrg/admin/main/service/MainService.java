package kr.co.rgrg.admin.main.service;

import kr.co.rgrg.admin.main.dao.MainDAO;
import kr.co.rgrg.admin.main.domain.AdminLoginDomain;
import kr.co.rgrg.admin.main.vo.AdminLoginVO;
import kr.co.rgrg.admin.main.vo.AdminUpdatePassVO;

public class MainService {
	
	public AdminLoginDomain adminLogin(AdminLoginVO alVO) {
		AdminLoginDomain alDomain=MainDAO.getInstance().selectAdminLogin(alVO);
		
		return alDomain;
	}//adminLogin
	
	public String adminPassChk(String id) {
		String pass=MainDAO.getInstance().selectCurrentPass(id);
		
		return pass;
	}//adminLogin
	
	public Boolean adminPassModify(AdminUpdatePassVO aupVO) {
		Boolean flag=false;
		int cnt=MainDAO.getInstance().updateAdminPass(aupVO);
		if(cnt==1) {
			flag=true;
		}//end if
		
		return flag;
	}//adminPassModify
	
}//class
