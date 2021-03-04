package kr.co.rgrg.admin.pagination;

import org.apache.ibatis.session.SqlSession;

import kr.co.rgrg.admin.dao.GetRgrgHandler;

public class PaginationDAO {
	
	private static PaginationDAO pDAO;
	
	private PaginationDAO() {
	}//PaginationDAO
	
	public static PaginationDAO getInstance() {
		if(pDAO == null) {
			pDAO = new PaginationDAO();
		}
		return pDAO;
	}//getInstance
	
	public int selectTotalCnt(TotalCntVO tcVO) {
		int cnt=0;
		
		SqlSession ss=GetRgrgHandler.getInstance().getSqlSession();
		cnt=ss.selectOne("selectTotalCnt", tcVO);
		ss.close();
		
		return cnt;
	}//selectTotalCnt
	
}//class
