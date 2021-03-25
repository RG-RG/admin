package kr.co.rgrg.admin.analytics.service;

import java.util.List;

import kr.co.rgrg.admin.analytics.dao.AnalyticsDAO;
import kr.co.rgrg.admin.analytics.domain.MostLikePost;

public class AnalyticsService {
	
	/**
	 * ���ƿ� �� �Խñ��� ��ȸ�ϴ� ��
	 * @return
	 */
	public List<MostLikePost> searchMostLikeList(){
		
		AnalyticsDAO aDAO = AnalyticsDAO.getInstance();
		List<MostLikePost> list = aDAO.selectMostLikeList();
		
		return list;
	}
}
