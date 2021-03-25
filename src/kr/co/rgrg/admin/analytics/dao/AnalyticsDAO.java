package kr.co.rgrg.admin.analytics.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.rgrg.admin.analytics.domain.MostLikePost;
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
	 * ���ƿ� ������ �Խñ� ����Ʈ�� ��ȸ
	 * @return
	 */
	public List<MostLikePost> selectMostLikeList() {
		
		SqlSession ss = GetRgrgHandler.getInstance().getSqlSession();
		List<MostLikePost> list = ss.selectList("kr.co.rgrg.admin.analytics.selectMostLikeList");
		ss.close();
		
		return list;
	}
}
