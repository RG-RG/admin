package kr.co.rgrg.admin.user.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.rgrg.admin.user.domain.UserListDomain;
import kr.co.rgrg.admin.user.service.UserService;
import kr.co.rgrg.admin.pagination.PaginationService;
import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.pagination.TotalCntVO;

@Controller
public class UserController {
	
	@RequestMapping(value = "user_list.do", method = RequestMethod.GET)
	public String userList(Model model, String param_page) {
		int current_page = 1;
		if (param_page != null) {
			current_page = Integer.parseInt(param_page);
		}//end if
		
		RangeVO rVO = new RangeVO(current_page);
		TotalCntVO tcVO = new TotalCntVO("member");
		
		List<UserListDomain> user_list = new UserService().userList(rVO);
		model.addAttribute("user_list", user_list);
		String str_pagination = new PaginationService().getPagination(current_page, tcVO);
		model.addAttribute("pagination_view", str_pagination);
		
		return "user/user_list";
	}//userList
	
}//class
