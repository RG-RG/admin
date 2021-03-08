package kr.co.rgrg.admin.user.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.rgrg.admin.user.domain.UserListDomain;
import kr.co.rgrg.admin.user.service.UserService;


@Controller
public class UserController {
	
	@RequestMapping(value = "user_list.do", method = RequestMethod.GET)
	public String userList(Model model) {
		
		List<UserListDomain> user_list = new UserService().userList();
		
		model.addAttribute("user_list", user_list);
		
		return "user/user_list";
	}//userList
	
}//class
