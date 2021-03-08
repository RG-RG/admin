package kr.co.rgrg.admin.main.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.rgrg.admin.dao.GetRgrgHandler;
import kr.co.rgrg.admin.main.vo.AdminLoginVO;
import kr.co.rgrg.admin.main.vo.AdminUpdatePassVO;

public class MainDAO {
	
	private static MainDAO mDAO;
	
	private MainDAO() {
	}//LikeDAO
	
	public static MainDAO getInstance() {
		if (mDAO==null) {
			mDAO=new MainDAO();
		}//end if
		return mDAO;
	}//getInstance
	
	public String selectAdminLogin(AdminLoginVO alVO) {
		
		SqlSession ss= GetRgrgHandler.getInstance().getSqlSession();
		String id=ss.selectOne("kr.co.rgrg.admin.main.selectAdminId",alVO);
		ss.close();
		
		return id;
	}//selectAdminLogin
	
	public String selectCurrentPass(AdminLoginVO alVO) {
		
		SqlSession ss= GetRgrgHandler.getInstance().getSqlSession();
		String id=ss.selectOne("kr.co.rgrg.admin.main.selectCurrentPassId",alVO);
		ss.close();
		
		return id;
	}//selectCurrentPass
	
	public int updateAdminPass(AdminUpdatePassVO aupVO) {
		
		SqlSession ss=GetRgrgHandler.getInstance().getSqlSession();
		int cnt=ss.update("kr.co.rgrg.admin.main.updateAdminPass", aupVO);
		ss.commit();
		ss.close();
		
		return cnt;
	}//updateAdminPass
	
}//class
