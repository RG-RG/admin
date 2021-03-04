package kr.co.rgrg.admin.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
	
	@RequestMapping(value = "post_list.do", method = RequestMethod.GET)
	public String postList() {
		
		return "post/post_list";
	}//postList
	
}//class
