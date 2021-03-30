package kr.co.rgrg.admin.analytics.service;

import java.util.List;

import kr.co.rgrg.admin.analytics.dao.AnalyticsDAO;
import kr.co.rgrg.admin.analytics.domain.MostLikePostDomain;

public class AnalyticsService {
	
	/**
	 * 좋아요 순 게시글을 조회하는 일
	 * @return
	 */
	public List<MostLikePostDomain> searchMostLikeList(){
		
		AnalyticsDAO aDAO = AnalyticsDAO.getInstance();
		List<MostLikePostDomain> list = aDAO.selectMostLikeList();
		
		return list;
	}
}
