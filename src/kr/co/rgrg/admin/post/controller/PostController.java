package kr.co.rgrg.admin.post.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rgrg.admin.pagination.RangeVO;
import kr.co.rgrg.admin.post.domain.CommentDomain;
import kr.co.rgrg.admin.post.domain.PostDetailDomain;
import kr.co.rgrg.admin.post.domain.PostListDomain;
import kr.co.rgrg.admin.post.service.PostService;

@Controller
public class PostController {
	
	/**
	 * �� ����� �������� ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="post_list.do", method=GET)
	public String getPostList(String page, Model model) {
		List<PostListDomain> list = null;
		
		int current_page = 1;
		if (page != null) {
			current_page = Integer.parseInt(page);
		}//end if
		RangeVO rVO = new RangeVO(current_page);
		list = new PostService().getPostList(rVO);
		model.addAttribute("post_list", list);
		
		return "post/post_list";
	}//getPostList
	
	/**
	 * �� �󼼳����� �������� ��
	 * @param post_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="post_detail.do", method=GET)
	public String getPostDetail(String post_num, Model model) {
		PostDetailDomain pdd = null;
		
		int p_num = Integer.parseInt(post_num);
		pdd = new PostService().getPostDetail(p_num);
		model.addAttribute("post_detail", pdd);
		
		return "post/post_detail";
	}//getPostDetail
	
	/**
	 * �� �󼼳����� ����� �������� ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="comment_list.do", method=GET)
	public String getCommentList(String page, Model model) {
		List<CommentDomain> list = null;
		
		int current_page = 1;
		if (page != null) {
			current_page = Integer.parseInt(page);
		}//end if
		RangeVO rVO = new RangeVO(current_page);
		rVO.setColumn_value("2");
		//rVO.setColumn_value(column_value); //Ŭ���� post_num
		list = new PostService().getCommentList(rVO);
		model.addAttribute("comment_list", list);
		
		return "post/comm_list";
	}//getCommentList
	
	/**
	 * ���� �����ϴ� ��
	 * @param post_num
	 * @return
	 */
	@RequestMapping(value="remove_post.do", method=GET)
	public String removePost(String post_num) {
		boolean flag = false;
		
		int p_num = Integer.parseInt(post_num);
		flag = new PostService().removePost(p_num);
		
		return "post/post_list";
	}//removePost
	
	/**
	 * ����� �����ϴ� ��
	 * @param comm_num
	 * @return
	 */
	@RequestMapping(value="remove_comment.do", method=POST)
	@ResponseBody
	public String removeComment(String comm_num) {
		boolean flag = false;
		
		int c_num = Integer.parseInt(comm_num);
		flag = new PostService().removeComment(c_num);
		
		return "post/comm_list";
	}//removeComment
	
}//PostController
