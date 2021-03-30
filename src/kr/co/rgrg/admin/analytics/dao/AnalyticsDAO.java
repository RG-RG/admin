package kr.co.rgrg.admin.analytics.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.rgrg.admin.analytics.domain.MostLikePostDomain;
import kr.co.rgrg.admin.dao.GetRgrgHandler;
import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.post.domain.PostListDomain;

public class AnalyticsDAO {
	private static AnalyticsDAO aDAO;
	
	public AnalyticsDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public static AnalyticsDAO getInstance() {
		if(aDAO == null) {
			aDAO = new AnalyticsDAO();
		}//end if
		
		return aDAO;
	}//getInstance
	
	
	/**
	 * 좋아요 순으로 게시글 리스트를 조회
	 * @return
	 */
	public List<MostLikePostDomain> selectMostLikeList() {
		
		SqlSession ss = GetRgrgHandler.getInstance().getSqlSession();
		List<MostLikePostDomain> list = ss.selectList("kr.co.rgrg.admin.analytics.selectMostLikeList");
		ss.close();
		
		return list;
	}
}
