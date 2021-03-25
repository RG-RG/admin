package kr.co.rgrg.admin.analytics.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
}//class
