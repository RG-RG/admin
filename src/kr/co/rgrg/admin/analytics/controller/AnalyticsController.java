package kr.co.rgrg.admin.analytics.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.rgrg.admin.analytics.service.AnalyticsService;

@Controller
@SessionAttributes("id")
public class AnalyticsController {
	
	@RequestMapping(value = "analytics.do", method=RequestMethod.GET)
	public String getAnalytics(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		
		if(id != null) {
			model.addAttribute("like_list", new AnalyticsService().searchMostLikeList());
		}
		
		return "analytics/analytics";
	}
	
	@RequestMapping(value="/analytics_admin.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getStatistics(HttpSession session, Model model, HttpServletRequest request) {
		String id = (String)session.getAttribute("id");

		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String metrics = request.getParameter("metrics");
		String dimensions = request.getParameter("dimensions");

		String analyticsResult = HelloAnalytics.getResult(id, startDate, endDate, metrics, dimensions);
		
		String result = analyticsResult;
		
		System.out.println(result);
		
		
		return result;
	}
	
	
	
}//class
