package kr.co.rgrg.admin.main.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.rgrg.admin.main.domain.AdminLoginDomain;
import kr.co.rgrg.admin.main.service.MainService;
import kr.co.rgrg.admin.main.vo.AdminLoginVO;
import kr.co.rgrg.admin.main.vo.AdminUpdatePassVO;

@Controller
@SessionAttributes("id")
public class MainController {
	
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	@RequestMapping(value="index.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String adminMain() {
		
		return "main";
	}//adminMain
	
	@RequestMapping(value="login.do", method= RequestMethod.POST)
	public String adminLogin(AdminLoginVO alVO, Model model) {
		
		AdminLoginDomain alDomain=new MainService().adminLogin(alVO);
		Boolean flag=pwdEncoder.matches(alVO.getPass(), alDomain.getPass());
		if(flag) {
			model.addAttribute("id", alDomain.getId());
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
	
	@RequestMapping(value="pass_chk_frm.do", method={RequestMethod.GET,RequestMethod.POST})
	public String adminPassChkFrm() {
		
		return "login/pass_chk_form";
	}//adminPassChkFrm
	
	@RequestMapping(value="pass_chk.do", method = RequestMethod.POST)
	public String adminPassChk(Model model, HttpSession hs, String pass) {
		String id=(String)hs.getAttribute("id");
		
		String cur_pass=new MainService().adminPassChk(id);
		Boolean flag=pwdEncoder.matches(pass, cur_pass);
		if(!flag) {	
			model.addAttribute("check_fail", "check_fail");
		}//end if
		return "login/pass_modify_frm";
	}//adminPassChk
	
	@RequestMapping(value="modify_pass.do", method=RequestMethod.POST)
	public String adminPassModify(Model model, HttpSession hs, SessionStatus ss, AdminUpdatePassVO aupVO) {
		aupVO.setId((String)hs.getAttribute("id"));
		
		String inputPass=aupVO.getPass();
		String pwd=pwdEncoder.encode(inputPass);
		aupVO.setPass(pwd);
		
		Boolean flag=new MainService().adminPassModify(aupVO);
		if(flag) {
			model.addAttribute("modify_success", "modify_success");
		}else {
			model.addAttribute("modify_fail", "modify_fail");
		}//end if
		
		ss.setComplete();
		return "main";
	}//adminPassModify
	
}//class
