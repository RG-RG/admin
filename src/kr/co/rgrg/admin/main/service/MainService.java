package kr.co.rgrg.admin.main.service;

import kr.co.rgrg.admin.main.dao.MainDAO;
import kr.co.rgrg.admin.main.vo.AdminLoginVO;
import kr.co.rgrg.admin.main.vo.AdminUpdatePassVO;

public class MainService {
	
	public String adminLogin(AdminLoginVO alVO) {
		String id=MainDAO.getInstance().selectAdminLogin(alVO);
		
		return id;
	}//adminLogin
	
	public Boolean adminPassChk(AdminLoginVO alVO) {
		Boolean flag=false;
		String id=MainDAO.getInstance().selectCurrentPass(alVO);
		if(id!=null && !"".equals(id)) {
			flag=true;
		}//end if
		
		return flag;
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
