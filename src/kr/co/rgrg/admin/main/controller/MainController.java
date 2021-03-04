package kr.co.rgrg.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.rgrg.admin.main.service.MainService;
import kr.co.rgrg.admin.main.vo.AdminLoginVO;

@Controller
@SessionAttributes("id")
public class MainController {
	
	@RequestMapping(value="index.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String adminMain() {
		
		return "main";
	}//adminMain
	
	@RequestMapping(value="login.do", method= RequestMethod.POST)
	public String adminLogin(AdminLoginVO alVO, Model model) {
		
		String id=new MainService().adminLogin(alVO);
		if(id!=null && !"".equals(id)) {
			model.addAttribute("id", id);
		}else{
			model.addAttribute("login_fail", "login_fail");
		}//end else
		
		return "main";
	}//adminLogin
	
	@RequestMapping(value="logout.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String adminLogout(SessionStatus ss) {
		ss.setComplete();
		return "redirect:index.do";
	}//adminLogout
	
}//class
